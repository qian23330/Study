package com.itheima.loop;

public class LoopNestedDemo7 {
    public static void main(String[] args) {
        // 目标：搞清楚循环嵌套的执行流程。
        // 场景：假如你有老婆，你犯错了，你老婆罚你说：3天，每天5句我爱你。
        for (int i = 1; i <= 3; i++) {
            // i = 1  2  3
            for(int j = 1; j <= 5; j++) {
                System.out.println("我爱你：" + i);
            }
            System.out.println("-------------------------");
        }

        /**
             ****
             ****
             ****
         */
        for (int i = 1; i <= 4; i++) {
            // i = 1  2  3
            // 定义一个循环控制每行打印多少列星星。
            for (int j = 1; j <= 40; j++) {
                System.out.print("*"); // 不换行
            }
            System.out.println(); // 换行
        }
    }
}
