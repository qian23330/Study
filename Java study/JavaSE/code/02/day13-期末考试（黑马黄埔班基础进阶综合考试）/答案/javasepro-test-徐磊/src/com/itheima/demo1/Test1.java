package com.itheima.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * **具体功能点要求**
 * 1)    定义订单类Order，创 建ArrayList集合，用于存储订单Order对象 （解析XML 4分，封装成对象2分）
 * 2）   请使用Stream流找出今天之前的订单，并遍历输出。（3分）
 * 3)   请使用Stream流找出集合中价格最贵的订流单，把这个订单的详细信息打印出来。（3分）
 * 4)   请使用Stream流遍历集合中的每个订单，要求按照价格降序输出每个订单的详情。（3分）
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        // 1、定义一个List集合存储全部订单对象
        List<Order> orders = new ArrayList<>();
        // 2、导入dom4j框架.
        SAXReader saxReader = new SAXReader();
        // 3、读取xml文件成为一个Document对象
        Document document = saxReader.read(Test1.class.getResourceAsStream("/orders.xml"));
        // 4、提取根元素
        Element root = document.getRootElement();
        // 5、提取一级子元素（order订单元素）
        List<Element> orderEles = root.elements();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 6、遍历每个订单元素
        for (Element orderEle : orderEles) {
            // 7、每个订单元素是一个订单对象。
            Order order = new Order();
            order.setId(Integer.valueOf(orderEle.attributeValue("id")));
            order.setName(orderEle.elementText("name"));
            order.setTime(LocalDateTime.parse(orderEle.elementText("time"), dtf));
            order.setPrice(Double.valueOf(orderEle.elementText("double")));
            // 8、把订单对象存入到集合中去
            orders.add(order);
        }
        System.out.println("订单内容如下：");
        for (Order order : orders) {
            System.out.println(order);
        }

        // 9、请使用Stream流找出今天之前的订单，并遍历输出。
        System.out.println("今天之前的订单如下：");
        orders.stream().filter(o -> o.getTime().isBefore(LocalDateTime.now())).forEach(System.out::println);

        // 10、请使用Stream流找出集合中价格最贵的订单，把这个订单的详细信息打印出来
        System.out.println("最贵的订单如下：");
        Order order = orders.stream().max((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice())).get();
        System.out.println(order);

        // 11、请使用Stream流遍历集合中的每个订单，要求按照价格降序输出每个订单的详情。
        System.out.println("根据价格降序如下：");
        orders.stream().sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())).forEach(System.out::println);
    }
}








