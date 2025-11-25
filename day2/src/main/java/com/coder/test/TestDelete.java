package com.coder.test;

import com.coder.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        session.delete("deleteByAge",35);
        session.close();
    }
}
