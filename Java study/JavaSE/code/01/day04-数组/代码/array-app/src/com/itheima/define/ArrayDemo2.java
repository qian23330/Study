package com.itheima.define;

public class ArrayDemo2 {
    public static void main(String[] args) {
        // 目标：掌握数组的访问。
        int[] arr = {12, 24, 36};
                    //0   1  2
        // 1、访问数组的全部数据
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        // System.out.println(arr[3]);

        // 2、修改数组中的数据
        arr[0] = 66;
        arr[2] = 100;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        // 3、访问数组的元素个数：数组名.length
        System.out.println(arr.length);

        // 技巧：获取数组的最大索引: arr.length - 1(前提是数组中存在数据)
        System.out.println(arr.length - 1);

        int[] arr2 = {};
        System.out.println(arr2.length - 1);
    }
}
