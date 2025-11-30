package com.coder.mapper;
import com.coder.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User login(@Param("uname") String uname, @Param("pwd") String pwd);

    void updateLastTime(@Param("uid") int uid);
}