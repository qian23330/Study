package com.itheima.demo5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 1、创建客户端对象
            Client client = new Client();
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        socket = new Socket("127.0.0.1", 8118);
        System.out.println("连接服务端成功~~~~~~~~");
        // 1、开发界面。
        // 2、提示功能
        while (true) {
            System.out.println("请您输入操作命令：");
            System.out.println("1、注册");
            System.out.println("2、登录");
            System.out.println("请选择：");
            String command = sc.next();
            switch (command) {
                case "1":
                    // 注册
                    register();
                    break;
                case "2":
                    // 登录'
                    login();
                    break;
                case "exit":
                    System.out.println("退出系统！");
                    socket.close();
                    break;
            }
        }
    }

    private void register() throws Exception {
        System.out.println("==============注册==================");
        System.out.println("请您输入注册信息：");
        // 1、提示用户输入登录名和密码
        System.out.println("登录名称：");
        String loginName = sc.next();

        System.out.println("登录密码");
        String passWord = sc.next();

        // 2、发送登录名和密码给服务端保存
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1); // 注册
        dos.writeUTF(loginName);
        dos.writeUTF(passWord);
        dos.flush();

        // 3、马上接收服务端响应。
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF());
    }

    private void login() throws Exception {
        System.out.println("==============登录==================");
        System.out.println("请您输入登录信息：");
        System.out.println("登录名称：");
        String loginName = sc.next();

        System.out.println("登录密码");
        String passWord = sc.next();

        // 2、发送登录名和密码给服务端保存
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(2); // 登录
        dos.writeUTF(loginName);
        dos.writeUTF(passWord);
        dos.flush();

        // 3、马上接收服务端响应。
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF());
    }


}
