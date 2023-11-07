package com.itheima.loop;

public class BreakAndContinueDemo8 {
    public static void main(String[] args) {
        // 目标：掌握break和continue的作用。
        // 1、break:跳出并结束当前所在循环的执行。
        // 场景：假如你又有老婆了，你犯错了，你老婆罚你说：5句我爱你
        // 说到第三句的时候心软了，让你别再说了。
        for (int i = 1; i <= 5; i++) {
            System.out.println("我爱你：" + i);
            if(i == 3){
                // 说明已经说完了第三句了，心软了。
                break; // 跳出并结束当前所在循环的执行。
            }
        }

        // 2、continue:跳出当前循环的当次执行，直接进入循环的下一次执行。
        // 场景: 假如你有老婆，你犯错了，你老婆罚你洗碗5天。
        // 第三天的时候，你表现很好，第三天不用洗碗，但是不解恨，第四天还是要继续的。
        for (int i = 1; i <= 5; i++) {
            if(i == 3) {
                // 已经到了第三天，第三天不用洗的。
                continue;
            }
            System.out.println("洗碗：" + i);
        }

        if(3 < 9){
            //break;
            // continue;
            System.out.println("Hello World");
        }
    }
}
