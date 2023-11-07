package com.itheima.d1_properties;

import java.io.FileWriter;
import java.util.Properties;

/**
 * 目标：掌握把键值对数据存入到属性文件中去
 */
public class PropertiesTest2 {
    public static void main(String[] args) throws Exception {
        // 1、创建Properties对象出来，先用它存储一些键值对数据
        Properties properties = new Properties();
        properties.setProperty("张无忌", "minmin");
        properties.setProperty("殷素素", "cuishan");
        properties.setProperty("张翠山", "susu");

        // 2、把properties对象中的键值对数据存入到属性文件中去
        properties.store(new FileWriter("properties-xml-log-app/src/users2.properties")
                , "i saved many users!");

    }
}
