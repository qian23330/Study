package com.bigc.service.Impl;

import com.bigc.mapper.LoginTicketMapper;
import com.bigc.mapper.UserMapper;
import com.bigc.pojo.LoginTicket;
import com.bigc.pojo.User;
import com.bigc.service.UserService;
import com.bigc.utils.CommunityConstant;
import com.bigc.utils.CommunityUtil;
import com.bigc.utils.MailClient;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService, CommunityConstant {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Value("${community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;


    @Override
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (user == null) {
            throw new IllegalArgumentException("参数值不能为空！");
        }
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMsg", "账号不能为空！");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg", "密码不能为空！");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("emailMsg", "邮箱不能为空！");
            return map;
        }

        // 验证账号
        User u = userMapper.selectByName(user.getUsername());
        if (u != null) {
            map.put("usernameMsg", "该账号已存在！");
            return map;
        }

        // 验证邮箱
        u = userMapper.selectByEmail(user.getEmail());
        if (u != null) {
            map.put("emailMsg", "该邮箱已被注册！");
            return map;
        }

        // 注册用户
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.MD5(user.getPassword() + user.getSalt()));
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(CommunityUtil.generateUUID());
        user.setHeaderUrl(String.format("https://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        // 激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // http://localhost:8080/community/activation/101/code 邮件url
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);

        return map;

    }

    @Override
    public int activation(int userId, String code) {
        User user = userMapper.selectById(userId);
        if (user.getStatus() == 1) {
            return ACTIVATION_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            userMapper.updateStatus(userId, 1);
            return ACTIVATION_SUCCESS;
        } else {
            return ACTIVATION_FAILURE;
        }
    }

    @Override
    public Map<String, Object> login(String username, String password, int expiredSeconds) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg",  "账号不能为空！");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg",  "密码不能为空！");
            return map;
        }

        // 验证账号
        User user = userMapper.selectByName(username);
        if (user == null) {
            map.put("usernameMsg",  "账号不存在！");
            return map;
        }

        // 验证账号是否激活
        if (user.getStatus() == 0) {
            map.put("usernameMsg",  "该账号未激活！");
            return map;
        }

        // 验证密码
        password = CommunityUtil.MD5(password + user.getSalt());
        if (!user.getPassword().equals(password)) {
            map.put("passwordMsg",  "密码不正确！");
            return map;
        }

        // 生成登录凭证
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(user.getId());
        loginTicket.setTicket(CommunityUtil.generateUUID());
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000L));
        loginTicketMapper.insertLoginTicket(loginTicket);

        map.put("ticket", loginTicket.getTicket());
        return map;
    }

    @Override
    public void logout(String ticket) {
        loginTicketMapper.updateStatus(ticket, 1);
    }

    @Override
    public LoginTicket findLoginTicket(String ticket) {
        return loginTicketMapper.selectByTicket(ticket);
    }

    @Override
    public void updateHeader(int userId, String headUrl) {
        userMapper.updateHeader(userId, headUrl);
    }

    @Override
    public void updatePassword(int userId, String newPassword) {
        userMapper.updatePassword(userId, newPassword);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    // 忘记密码之后给邮箱发送验证码
    public Map<String, Object> getCode(String email) {
        Map<String,Object> map = new HashMap<>();

        // 空值判断
        if (StringUtils.isBlank(email)){
            map.put("emailMsg","请输入邮箱！");
            return map;
        }

        // 邮箱格式是否合法
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            map.put("emailMsg", "请输入有效的邮箱格式！");
            return map;
        }

        // 邮箱是否正确
        User user = userMapper.selectByEmail(email);
        if (user == null){
            map.put("emailMsg","该邮箱还未注册过，请注册后再使用！");
            return map;
        }

        // 该用户还未激活
        if (user.getStatus() == 0){
            map.put("emailMsg","该邮箱还未激活，请到邮箱中激活后再使用！");
            return map;
        }

        // 邮箱正确的情况下，发送验证码到邮箱
        Context context = new Context();
        context.setVariable("email", email);
        String code = CommunityUtil.generateUUID().substring(0,5);
        context.setVariable("code", code);
        String content = templateEngine.process("/mail/forget", context);
        mailClient.sendMail(email, "找回密码", content);

        map.put("code", code); // map中存放一份，为了之后和用户输入的验证码进行对比
        map.put("expirationTime", LocalDateTime.now().plusMinutes(5L)); // 过期时间
        return map;
    }

    @Override
    public Map<String, Object> forget(String email, String verifycode, String password) {
        Map<String,Object> map = new HashMap<>();
        // 空值处理
        if (StringUtils.isBlank(email)){
            map.put("emailMsg","请输入邮箱！");
            return map;
        }
        if (StringUtils.isBlank(verifycode)){
            map.put("codeMsg","请输入验证码！");
            return map;
        }
        if (StringUtils.isBlank(password)){
            map.put("passwordMsg","请输入新密码！");
            return map;
        }

        // 邮箱在获取验证码那一步已经验证过了，是有效的邮箱，且验证码也有效
        User user = userMapper.selectByEmail(email);
        password = CommunityUtil.MD5(password + user.getSalt());
        userMapper.updatePassword(user.getId(), password);
        return map;
    }


}
