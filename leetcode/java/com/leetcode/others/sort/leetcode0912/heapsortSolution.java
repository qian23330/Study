package com.leetcode.others.sort.leetcode0912;

/*
力扣-912-排序数组
排序-堆排序
*/

import java.util.Arrays;
import java.util.Scanner;

class heapsortSolution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    /* 堆的长度为 n ，从节点 i 开始，从顶至底堆化 */
    private void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l < n && nums[l] > nums[ma])
                ma = l;
            if (r < n && nums[r] > nums[ma])
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(nums, i, ma);
            // 循环向下堆化
            i = ma;
        }
    }

    /* 堆排序 */
    private void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换根节点与最右叶节点（即交换首元素与尾元素）
            swap(nums, 0, i);
            // 以根节点为起点，从顶至底进行堆化
            siftDown(nums, i, 0);
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
        int[] nums = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(new heapsortSolution().sortArray(nums)));
    }
}
