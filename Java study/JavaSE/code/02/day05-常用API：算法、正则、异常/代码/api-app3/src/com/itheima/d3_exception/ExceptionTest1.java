package com.itheima.d3_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 目标：认识异常。
 */
public class ExceptionTest1 {
    public static void main(String[] args) throws ParseException{
//         Integer.valueOf("abc");

//         int[] arr = {11, 22, 33};
//         System.out.println(arr[5]);

//        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse("2028-11-11 10:24");
            System.out.println(d);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}