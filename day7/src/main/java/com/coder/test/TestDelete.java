package com.coder.test;

import java.io.IOException;
import com.coder.mapper.EmployeeMapper;
import com.coder.model.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;


public class TestDelete {
    public static void main(String[] args) throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            EmployeeExample example = new EmployeeExample();
            example.createCriteria().andAddrLike("%陕西省%");
            int deleteCount = mapper.deleteByExample(example);
            session.commit();
        }
    }
}
