package com.coder.service;

import com.coder.mapper.UserMapper;
import com.coder.model.User;
import com.coder.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public User login(String uname, String pwd) {
        SqlSession session = null;
        try {
            session = SessionUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.login(uname, pwd);

            if (user != null) {
                userMapper.updateLastTime(user.getUid());
                session.commit();
            }
            return user;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
