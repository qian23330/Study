package com.exam.huawei.round1;

import java.util.*;

/**
 * 1.云服务计费
 * 编写一个程序为某云服务计算客户话单，输入为某云服务的计费日志和各种计费因子的计费单价的列表，计费日志内容包含时间戳、客户标识、计费因子、
 * 计费时长4个字段。日志中如果同一客户同一计费因子在相同时间戳上报多次话单只能计费一次，选先上报的日志计费。计算每个客户的话单总费用。
 * 解答要求
 * 时间限制: C/C++ 1000ms,其他语言: 2000ms内存限制: C/C++ 256MB,其他语言: 512MB
 * 输入
 * 第1行表示计费日志的条数n，是一个正整数，范围是1<=n<=1000
 * 第2到n+1行表示云服务的计费日志，共4列，第1列表示时间戳(是一个数字字符串，长度为10) 、第2列表示客户标识(是一个字符串，长度为1-16)，
 * 第3列表示计费因子 (是一个字符串，长度为1-16，计费因子查不到时认为计费因子单价是0），第四列表示计费时长时长（范围为0-100，
 * 当计费时长不在范围内要认为是计费日志有问题，当成计费为0处理)，这4个字段使用逗号分隔
 * 第n+2行表示计费因子的数量m，m是一个正整数，范围是1<=m<=100
 * 第n+3到n+3+m行表示各种计费因子的计费单价的列表，该表有2列,第1列表示计费因子 (是一个字符串，长度为1-16)，第2列表示单价(是一个正整数，
 * 范围为1~100)，这2个字段使用逗号分隔
 * 输出
 * 每个客户的话单总费用,共2列，第1列表示客户名，第2列表示话单费用，2列用逗号分割，输出按客户标识字典序升序排序
 * 样例
 * 输入
 * 5
 * 1627845600,client1,factorA,10
 * 1627845605,client2,factorB,15
 * 1627845610,client1,factorA,5
 * 1627845610,client1,factorB,8
 * 1627845620,client2,factorB,20
 * 2
 * factorA,5
 * factorB,7
 * 输出
 * client1,131
 * client2,245
 */

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
        res.sort(Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> entry : res) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}
