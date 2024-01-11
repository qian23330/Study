package com.bigc.service;

import com.bigc.pojo.LoginTicket;
import com.bigc.pojo.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public interface UserService {

    User findUserById(int id);

    Map<String, Object> register(User user);

    int activation(int userId, String code);

    Map<String, Object> login(String username, String password, int expiredSeconds);

    void logout(String ticket);

    LoginTicket findLoginTicket(String ticket);

    int updateHeader(int userId, String headerUrl);

    int updatePassword(int userId, String newPassword);

    User findUserByName(String username);

    Map<String, Object> getCode(String email);

    Map<String, Object> forget(String email, String verifycode, String password);

    // redis缓存消息
    // 1.优先从缓存中取值
    User getCache(int userId);
    // 2.取不到时初始化缓存数据
    User initCache(int userId);
    // 3.数据变更时清除缓存数据
    void clearCache(int userId);

    Collection<? extends GrantedAuthority> getAuthorities(int userId);
}
