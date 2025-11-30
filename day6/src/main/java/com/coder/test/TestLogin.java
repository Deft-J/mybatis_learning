package com.coder.test;

import com.coder.model.Permission;
import com.coder.service.UserService;
import com.coder.model.User;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        System.out.print("请输入用户名：");
        String uname = scanner.next();
        System.out.print("请输入密码：");
        String pwd = scanner.next();
        User user = userService.login(uname, pwd);
        if (user == null) {
            System.out.println("登录失败！用户名或密码错误。");
        } else {
            System.out.println("欢迎用户：" + user.getUname());
            System.out.print("您的角色：");
            Set<String> roleSet = new HashSet<>();
            user.getRoles().forEach(role -> roleSet.add(role.getRname()));
            System.out.println(String.join("、", roleSet));
            System.out.println("可操作菜单：");
            Set<Permission> permSet = new HashSet<>();
            user.getRoles().forEach(role -> permSet.addAll(role.getPermissions()));
            permSet.forEach(perm -> {
                System.out.printf(perm.getUrl()+perm.getPname()+'\n');
            });
            System.out.println("最后访问时间已更新为：" + user.getLasttime());
        }

        scanner.close();
    }
}
