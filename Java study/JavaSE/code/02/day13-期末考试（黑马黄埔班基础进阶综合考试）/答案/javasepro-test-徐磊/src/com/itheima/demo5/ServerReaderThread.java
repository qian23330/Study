package com.itheima.demo5;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 处理的信息：注册 登录。
        try {
            // 1、得到输入流
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                // 2、读消息类型
                int type = dis.readInt();
                // 3、区别消息，不同处理
                switch (type) {
                    case 1:
                        // 注册
                        register();
                        break;
                    case 2:
                        // 登录
                        login();
                }
            }
        } catch (Exception e) {
            // 离线逻辑
            System.out.println("有人离线了~~");
        }
    }

    private void register() throws Exception {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String loginName = dis.readUTF();
        String passWord = dis.readUTF();

        // 开始做判断，登录名是否重复的问题。
        String result = "注册成功";
        if(exist(loginName)) {
            result = "注册失败，您注册的登录名称已被占用！";
        }else {
            // 保存登录名和密码
            Properties properties = new Properties();
            properties.setProperty(loginName, passWord);
            properties.store(new FileWriter(Server.USERS_FILE_PATH, true), "");
        }

        // 响应结果回去
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(result);
        dos.flush();
    }

    private void login() throws Exception {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String loginName = dis.readUTF();
        String passWord = dis.readUTF();

        String result = "登录成功";
        File file = new File(Server.USERS_FILE_PATH);
        if(file.exists()){
            // 提取全部的登录名，看是否存在当前这个登录名
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            // 校验登录名：根据登录名获取密码
            String OKpwd = properties.getProperty(loginName);
            if(OKpwd == null) {
                result = "登录名称错误";
            }else {
                // 比较密码
                if(!OKpwd.equals(passWord)){
                    result = "密码错误！";
                }
            }
            // 校验密码
        }else {
            result = "当前无任何用户信息，无法登录！";
        }

        // 响应result即可
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(result);
        dos.flush();
    }

    public boolean exist(String loginName) throws Exception {
        File file = new File(Server.USERS_FILE_PATH);
        if(file.exists()){
            // 提取全部的登录名，看是否存在当前这个登录名
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            if(properties.containsKey(loginName)) {
                return true;
            }
        }
        return false;
    }

}
