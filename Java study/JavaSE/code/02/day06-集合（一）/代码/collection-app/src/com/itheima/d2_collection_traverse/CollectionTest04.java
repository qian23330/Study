package com.itheima.d2_collection_traverse;

import java.util.ArrayList;
import java.util.Collection;

/**
 *       目标：完成电影信息的展示。
 *       new Movie("《肖生克的救赎》" , 9.7 ,  "罗宾斯")
 *       new Movie("《霸王别姬》" , 9.6 ,  "张国荣、张丰毅")
 *       new Movie("《阿甘正传》" , 9.5 ,  "汤姆.汉克斯")
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        // 1、创建一个集合容器负责存储多部电影对象。
        Collection<Movie> movies = new ArrayList<>();
        movies.add( new Movie("《肖生克的救赎》" , 9.7 ,  "罗宾斯"));
        movies.add( new Movie("《霸王别姬》" , 9.6 ,  "张国荣、张丰毅"));
        movies.add( new Movie("《阿甘正传》" , 9.5 ,  "汤姆.汉克斯"));
        System.out.println(movies);

        for (Movie movie : movies) {
            System.out.println("电影名：" + movie.getName());
            System.out.println("评分：" + movie.getScore());
            System.out.println("主演：" + movie.getActor());
            System.out.println("---------------------------------------------");
        }
    }
}
