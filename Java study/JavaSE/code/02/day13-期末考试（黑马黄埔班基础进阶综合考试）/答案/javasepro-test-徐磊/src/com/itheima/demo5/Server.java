package com.itheima.demo5;


import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final String USERS_FILE_PATH = "javasepro-test-徐磊\\src\\users.properties";
    public static void main(String[] args) {
        try {
            // 1、注册端口：
            ServerSocket serverSocket = new ServerSocket(8118);
            while (true) {
                // 2、开始接收客户端的管道连接
                Socket socket = serverSocket.accept();
                // 3、分配一个独立的线程来处理客户端的socket
                new ServerReaderThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
