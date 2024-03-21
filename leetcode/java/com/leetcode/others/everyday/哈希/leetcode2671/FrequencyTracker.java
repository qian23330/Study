package com.leetcode.others.everyday.哈希.leetcode2671;

/*
力扣-2671-频率跟踪器
每日一题-24.03.21-哈希-设计
*/

import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {
    private final Map<Integer, Integer> cnt;
    private final Map<Integer, Integer> freq;

    public FrequencyTracker() {
        cnt = new HashMap<>();
        freq = new HashMap<>();
    }

    private void update(int number, int x) {
        int c = cnt.merge(number, x, Integer::sum);
        freq.merge(c - x, -1, Integer::sum);
        freq.merge(c, 1, Integer::sum);
    }

    public void add(int number) {
        update(number, 1);
    }

    public void deleteOne(int number) {
        if (cnt.getOrDefault(number, 0) > 0) {
            update(number, -1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0;
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3); // 数据结构现在包含 [3]
        frequencyTracker.deleteOne(3); // 数据结构现在包含 [3, 3]
        System.out.println(frequencyTracker.hasFrequency(2)); // 返回 true ，因为 3 出现 2 次
    }
}
