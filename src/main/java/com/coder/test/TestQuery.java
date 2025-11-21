package com.coder.test;

import com.coder.model.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestQuery {
    public static void main(String[] args) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();
        List<Teacher> list = session.selectList("selectAll");
        list.forEach(teacher-> System.out.println(teacher));
        session.close();
    }

}
