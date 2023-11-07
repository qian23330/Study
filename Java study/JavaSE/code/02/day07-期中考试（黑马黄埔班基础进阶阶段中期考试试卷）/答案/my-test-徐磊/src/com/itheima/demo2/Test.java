package com.itheima.demo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // 1、把数据拿到程序中来。
        String userStrs = "10001:张三:男:1990-01-01#10002:李四:女:1989-01-09#10003:王五:男:1999-09-09#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01#10006:张三:女:1999-01-01#10007:刘备:女:1999-01-01#10008:张三:女:2003-07-01#10009:猪八戒:男:1900-01-01";
        // 2、定义一个用户类。
        // 3、提前定义一个List<User>集合用于存储用户对象
        List<User> users = new ArrayList<>();
        // 4、把全部用户数据，用#分割。
        String[] userStrArray = userStrs.split("#");

        for (String userStr : userStrArray) {
            // userStr = "10001:张三:男:1990-01-01"
            // 5、创建一个用户对象，封装这个用户数据
            User user = new User();
            String[] userData = userStr.split(":");
            user.setId(Long.valueOf(userData[0]));
            user.setName(userData[1]);
            user.setGender(userData[2]);
            user.setBirthday(LocalDate.parse(userData[3]));

            // 6、把这个用户对象存入到集合中去
            users.add(user);
        }
        System.out.println(users);

        System.out.println("------------------------------------------------");

        // 7、遍历List集合中的每个用户对象，统计相同名称出现的次数。
        Map<String, Integer> result = new HashMap<>();
        for (User user : users) {
            String name = user.getName();
            if(result.containsKey(name)) {
                result.put(name, result.get(name) + 1);
            }else {
                result.put(name, 1);
            }
        }

        // 8、遍历Map集合。
        result.forEach((k ,v) -> {
            System.out.println(k + ":" + v + "次");
        });
    }
}
