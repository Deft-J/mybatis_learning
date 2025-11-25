package com.coder.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SessionUtil {
    public static SqlSession getSession() throws IOException {
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static SqlSession getSession(boolean autoCommit) {
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")).openSession(autoCommit);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
