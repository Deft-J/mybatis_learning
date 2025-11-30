package com.coder.util;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SessionUtil {
    public static SqlSession getSession() {
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
