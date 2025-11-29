package com.coder.test;

import com.coder.mapper.EmployeeMapper;
import com.coder.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestEmployeeAnnotationMapper {
    private static SqlSession getSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory.openSession(false);
    }

    public static void main(String[] args) throws IOException {
        SqlSession session = null;
        try {
            session = getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            //新增员工
            Employee newEmp = new Employee(null, "孙九", "浙江省杭州市", 28, "产品经理", 18000);
            mapper.saveEmployee(newEmp);
            session.commit();

            //根据 id 查询单个员工
            Employee emp = mapper.selectEmployeeById(7);

            //更新员工
            emp.setSal(19000);
            emp.setAddr("浙江省宁波市");
            mapper.updateEmployee(emp);
            session.commit();

            //查询所有员工
            List<Employee> allEmp = mapper.selectAllEmployees();
            allEmp.forEach(System.out::println);

            //删除员工
            mapper.deleteEmployeeById(7);
            session.commit();

        } catch (Exception e) {
            if (session != null) session.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
