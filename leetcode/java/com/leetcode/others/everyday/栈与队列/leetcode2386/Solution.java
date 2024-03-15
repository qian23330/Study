package com.leetcode.others.everyday.栈与队列.leetcode2386;

/*
力扣-2386-找出数组的第 K 大和
每日一题-24.03.09-最小堆
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


class Pair<L extends Number, I extends Number> {
    Long key;
    Integer value;

    public Pair(Long key, Integer value){
        this.key = key;
        this.value = value;
    }

    Long getKey(){
        return this.key;
    }

    Integer getValue(){
        return this.value;
    }
}


class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);

        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        pq.offer(new Pair<>(0L, 0)); // 空子序列
        while (--k > 0) {
            Pair<Long, Integer> p = pq.poll();
            long s = p.getKey();
            int i = p.getValue();
            if (i < nums.length) {
                // 在子序列的末尾添加 nums[i]
                pq.offer(new Pair<>(s + nums[i], i + 1)); // 下一个添加/替换的元素下标为 i+1
                if (i > 0) { // 替换子序列的末尾元素为 nums[i]
                    pq.offer(new Pair<>(s + nums[i] - nums[i - 1], i + 1));
                }
            }
        }
        return sum - pq.peek().getKey();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        System.out.println(new Solution().kSum(nums, k));
    }
}
