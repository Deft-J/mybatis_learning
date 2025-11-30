package com.coder.test;

import com.coder.mapper.EmployeeMapper;
import com.coder.model.Employee;
import com.coder.model.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUpdateSal {
    public static void main(String[] args) throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            EmployeeExample example = new EmployeeExample();
            example.createCriteria()
                    .andAgeGreaterThan(27)
                    .andJobEqualTo("销售员");

            List<Employee> empList = mapper.selectByExample(example);
            System.out.println("符合条件的员工数量：" + empList.size());

            for (Employee emp : empList) {
                int newSal = emp.getSal() + 1000;
                emp.setSal(newSal);
                mapper.updateByPrimaryKeySelective(emp);
            }
            session.commit();
            System.out.println("工资更新完成！");
        }
    }
}
