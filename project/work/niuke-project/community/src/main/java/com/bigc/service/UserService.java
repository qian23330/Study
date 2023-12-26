package com.bigc.service;

import com.bigc.pojo.LoginTicket;
import com.bigc.pojo.User;

import java.util.Map;
import java.util.Objects;

public interface UserService {

    User findUserById(int id);

    Map<String, Object> register(User user);

    int activation(int userId, String code);

    Map<String, Object> login(String username, String password, int expiredSeconds);

    void logout(String ticket);

    LoginTicket findLoginTicket(String ticket);
}
