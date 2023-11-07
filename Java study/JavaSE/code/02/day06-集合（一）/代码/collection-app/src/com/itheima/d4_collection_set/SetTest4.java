package com.itheima.d4_collection_set;

import java.util.Set;
import java.util.TreeSet;

/**
 * 目标：掌握TreeSet集合的使用。
 */
public class SetTest4 {
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        set1.add(6);
        set1.add(5);
        set1.add(5);
        set1.add(7);
        System.out.println(set1);

        // TreeSet就近选择自己自带的比较器对象进行排序
//        Set<Student> students = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                // 需求：按照身高升序排序
//                return Double.compare(o1.getHeight() , o2.getHeight());
//            }
//        });
        Set<Student> students = new TreeSet<>(( o1,  o2) ->  Double.compare(o1.getHeight() , o2.getHeight()));
        students.add(new Student("蜘蛛精",23, 169.7));
        students.add(new Student("紫霞",22, 169.8));
        students.add(new Student("至尊宝",26, 165.5));
        students.add(new Student("牛魔王",22, 183.5));
        System.out.println(students);
    }
}
