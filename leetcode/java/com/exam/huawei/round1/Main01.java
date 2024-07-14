package com.exam.huawei.round1;

import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> ses = new HashSet<>();
        Map<String, Integer> h1 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            String[] a = s.split(",");
            String ts = a[0] + a[1] + a[2];
            if (ses.contains(ts)) {
                continue;
            }
            ses.add(ts);
            int tt = Integer.parseInt(a[3]);
            if (tt < 0 || tt > 100) {
                continue;
            }
            String key = a[1] + "_" + a[2];
            h1.put(key, h1.getOrDefault(key, 0) + tt);
        }

        int m = scanner.nextInt();
        Map<String, Integer> h2 = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String f = scanner.next();
            String[] b = f.split(",");
            h2.put(b[0], Integer.parseInt(b[1]));
        }

        Map<String, Integer> h3 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : h1.entrySet()) {
            String[] keys = entry.getKey().split("_");
            String k = keys[0];
            int v = entry.getValue();
            h3.put(k, h3.getOrDefault(k, 0) + h2.get(keys[1]) * v);
        }

        List<Map.Entry<String, Integer>> res = new ArrayList<>(h3.entrySet());
        res.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        for (Map.Entry<String, Integer> entry : res) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}
