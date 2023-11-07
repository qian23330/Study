package com.itheima.d6_object_stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 目标：掌握对象字节输入流的使用：反序列化对象。
 */
public class Test2ObjectInputStream {
    public static void main(String[] args) {
        try (
                // 1、创建一个对象字节输入流管道，包装 低级的字节输入流与源文件接通
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io-app2/src/itheima11out.txt"));
                ){
            User u = (User) ois.readObject();
            System.out.println(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
