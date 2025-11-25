package com.coder.test;

import com.coder.model.Teacher;
import com.coder.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) throws IOException {
        SqlSession session= SessionUtil.getSession();
        Teacher teacher=new Teacher();
        teacher.setAddr("江苏省");
        List<Teacher> list = session.selectList("selectByAddr",teacher);
        list.forEach(System.out::println);
        session.close();
    }
}
