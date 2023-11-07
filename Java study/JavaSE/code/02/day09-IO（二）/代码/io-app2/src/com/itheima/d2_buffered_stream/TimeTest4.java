package com.itheima.d2_buffered_stream;

import java.io.*;

/**
    目标：观察原始流和缓冲流的性能。
 */
public class TimeTest4 {
    // 复制的视频路径
    private static final String SRC_FILE = "D:\\resource\\线程池.avi";
    // 复制到哪个目的地
    private static final String DEST_FILE = "D:\\";

    public static void main(String[] args) {
        // copy01(); // 低级字节流一个一个字节的赋值，慢的简直让人无法忍受，直接淘汰！
        copy02();// 低级的字节流流按照一个一个字节数组的形式复制，速度较慢！
        // copy03(); // 缓冲流按照一个一个字节的形式复制，速度较慢,直接淘汰！
        copy04(); // 缓冲流按照一个一个字节数组的形式复制，速度极快，推荐使用！
    }

    private static void copy01() {
        long startTime = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "1.avi");
        ){

            int b;
            while ((b = is.read()) != -1){
                os.write(b);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("低级字节流一个一个字节复制耗时：" + (endTime - startTime) / 1000.0 + "s");
    }

    private static void copy02() {
        long startTime = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "2.avi");
        ){
            byte[] buffer = new byte[1024*64];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("低级字节流使用字节数组复制耗时：" + (endTime - startTime) / 1000.0 + "s");
    }

    private static void copy03() {
        long startTime = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(SRC_FILE);
                BufferedInputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(DEST_FILE + "3.avi");
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ){

            int b;
            while ((b = bis.read()) != -1){
                bos.write(b);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("缓冲流一个一个字节复制耗时：" + (endTime - startTime) / 1000.0 + "s");
    }

    private static void copy04() {
        long startTime = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(SRC_FILE);
                BufferedInputStream bis = new BufferedInputStream(is, 64 * 1024);
                OutputStream os = new FileOutputStream(DEST_FILE + "4.avi");
                BufferedOutputStream bos = new BufferedOutputStream(os, 64 * 1024);
        ){
            byte[] buffer = new byte[1024 * 64]; // 32KB
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("缓冲流使用字节数组复制耗时：" + (endTime - startTime) / 1000.0 + "s");
    }
}










