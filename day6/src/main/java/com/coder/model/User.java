package com.coder.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private int uid;
    private String uname;
    private String pwd;
    private Date lasttime;
    private List<Role> roles;
}
