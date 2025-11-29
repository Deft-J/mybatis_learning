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

public class TestEmployeeMapper {

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
            List<Employee> jiangsuEmpList = mapper.selectJiangsuEmployees();
            jiangsuEmpList.forEach(System.out::println);

            Double jilinAvgSal = mapper.selectJilinAvgSal();
            System.out.println("平均工资：" + (jilinAvgSal == null ? 0 : jilinAvgSal));
            mapper.updateSalesmanToManager();
            session.commit();

            List<Employee> updatedEmpList = mapper.selectJiangsuEmployees();
            updatedEmpList.forEach(emp -> {
                if (emp.getName().equals("吴八")) {
                    System.out.println("吴八当前职位：" + emp.getJob());
                }
            });

            mapper.deleteEmployeeOver35();
            session.commit();
            List<Employee> allEmpList = mapper.selectJiangsuEmployees();

        } catch (Exception e) {
            if (session != null) session.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
