package com.itheima.d3_util;

import java.util.Random;

public class MyUtil {

    private MyUtil(){
    }

    public static String createCode(int n){
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random r = new Random();
        // 2、开始定义一个循环产生每位随机字符
        for (int i = 0; i < n; i++) {
            // 3、随机一个字符范围内的索引。
            int index = r.nextInt(data.length());
            // 4、根据索引去全部字符中提取该字符
            code += data.charAt(index); // code = code + 字符
        }
        return code;
    }
}
