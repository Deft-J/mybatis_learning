package com.coder.test;

import com.coder.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session= SessionUtil.getSession(true);
        Map<String, Object> params = new HashMap<>();
        params.put("newjob", "销售经理");
        params.put("age1", 30);
        params.put("oldjob", "销售员");
        session.update("update", params);
        session.close();
    }
}
