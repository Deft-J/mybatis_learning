package com.coder.test;

import com.coder.mapper.EmployeeMapper;
import com.coder.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestInsert {
    public static void main(String[] args) throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee emp7 = new Employee();
            emp7.setId(7);
            emp7.setName("张丽");
            emp7.setAddr("江苏省南京市");
            emp7.setAge(32);
            emp7.setJob("销售员");
            emp7.setSal(7000);
            mapper.insertSelective(emp7);


            Employee emp8 = new Employee();
            emp8.setId(8);
            emp8.setName("张伟");
            emp8.setAddr("江苏省苏州市");
            emp8.setAge(26);
            emp8.setJob("职员");
            emp8.setSal(5000);
            mapper.insertSelective(emp8);


            Employee emp9 = new Employee();
            emp9.setId(9);
            emp9.setName("王晓");
            emp9.setAddr("上海市");
            emp9.setAge(30);
            emp9.setJob("区域总监");
            emp9.setSal(20000);
            mapper.insertSelective(emp9);


            Employee emp10 = new Employee();
            emp10.setId(10);
            emp10.setName("赵敏");
            emp10.setAddr("上海市");
            emp10.setAge(25);
            emp10.setJob("财务");
            emp10.setSal(10000);
            mapper.insertSelective(emp10);
            session.commit();
        }
    }
}