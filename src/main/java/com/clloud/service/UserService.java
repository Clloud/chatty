package com.clloud.service;

import com.clloud.pojo.Users;

public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    boolean queryUserNameIsExist(String username);

    /**
     * 查询用户的用户名和密码是否正确
     * @param username
     * @param pwd
     * @return
     */
    Users queryUserForLogin(String username, String pwd);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Users saveUser(Users user);
}
