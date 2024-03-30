package com.leetcode.others.practice;

/*
力扣
practice-练习
 */


import java.util.*;

class Solution {

    private static class People {
        String name;
        int age;

        People(){};

        People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 2);
        map.put(2, 3);
        map.forEach((k, v) -> System.out.println("key是-" + k + " value是-" + v));
        map.entrySet().removeIf(v -> v.getValue() == 1 || v.getValue() == 2);
        System.out.println("-----");
        map.forEach((k, v) -> System.out.println("key是-" + k + " value是-" + v));
        System.out.println("-----");

        People people1 = new People("Tom", 35);
        People people2 = new People("Ruby", 32);
        PriorityQueue<People> pq = new PriorityQueue<>(Comparator.comparingInt(People::getAge));
        pq.offer(people1);
        pq.offer(people2);
        pq.forEach((p) -> System.out.println(p.getName()));
    }
}

