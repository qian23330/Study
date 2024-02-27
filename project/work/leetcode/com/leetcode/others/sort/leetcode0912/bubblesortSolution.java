package com.leetcode.others.sort.leetcode0912;

import java.util.Arrays;
import java.util.Scanner;

/*
力扣-912-排序数组
排序-冒泡排序
*/

class bubblesortSolution {
    public int[] sortArray(int[] nums) {
        bubbleSortWithFlag(nums);
        return nums;
    }

    /* 冒泡排序（标志优化） */
    private void bubbleSortWithFlag(int[] nums) {
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false; // 初始化标志位
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    swap(nums, j, j + 1);
                    flag = true; // 记录交换元素
                }
            }
            if (!flag)
                break; // 此轮冒泡未交换任何元素，直接跳出
        }
    }

    /* 元素交换 */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println("请输入几个数并用逗号隔开：");
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(new bubblesortSolution().sortArray(nums)));
    }
}
