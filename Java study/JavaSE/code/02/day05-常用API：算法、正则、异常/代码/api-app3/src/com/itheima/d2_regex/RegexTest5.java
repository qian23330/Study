package com.itheima.d2_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest5 {
    public static void main(String[] args) {
        method2();
    }

    // 需求2：把全部邮箱的账户名找出来。
    public static void method1(){
        String data = " 来黑马程序员学习Java，\n" +
                "        电话：1866668888，18699997777\n" +
                "        或者联系邮箱：boniu@itcast.cn，\n" +
                "        座机电话：01036517895，010-98951256\n" +
                "        邮箱：bozai@itcast.cn，\n" +
                "        邮箱：dlei0009@163.com，\n" +
                "        热线电话：400-618-9090 ，heima, 400-618-4000，4006184000，4006189090";
        // 1、定义爬取规则
        String regex = "(\\w{2,})@(\\w{2,20})(\\.\\w{2,10}){1,2}";
        // 2、把正则表达式封装成一个Pattern对象
        Pattern pattern = Pattern.compile(regex);
        // 3、通过pattern对象去获取查找内容的匹配器对象。
        Matcher matcher = pattern.matcher(data);
        // 4、定义一个循环开始爬取信息
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1)); // 指定获取正则表达式匹配后的第一组内容
            System.out.println(matcher.group(2)); // 指定获取正则表达式匹配后的第二组内容
        }
    }


    // 需求3：某系统的日志文件记录了当天进入系统的全部用户信息，需要把这些用户的名字爬取出来另作他用。
    public static void method2(){
        String data = "欢迎张全蛋光临本系统！他删库并跑路，欢迎李二狗子光临本系统！" +
                "欢迎马六子光临本系统！它浏览了很多好看的照片！欢迎夏洛光临本系统！他在六点钟购买了一台拖拉机！";
        // 1、定义爬取规则
        // String regex = "欢迎(.+)光临"; // 贪婪匹配
        String regex = "欢迎(.+?)光临"; // +? 非贪婪匹配
        // 2、把正则表达式封装成一个Pattern对象
        Pattern pattern = Pattern.compile(regex);
        // 3、通过pattern对象去获取查找内容的匹配器对象。
        Matcher matcher = pattern.matcher(data);
        // 4、定义一个循环开始爬取信息
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }
}
