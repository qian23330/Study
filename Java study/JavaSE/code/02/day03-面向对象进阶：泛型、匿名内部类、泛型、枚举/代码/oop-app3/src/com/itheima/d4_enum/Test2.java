package com.itheima.d4_enum;

public class Test2 {
    public static void main(String[] args) {
        // 目标：掌握枚举类的使用场景。
        provideInfo(Constant.BOY);
    }

    public static void provideInfo(Constant sex){
        switch (sex) {
            case BOY:
                // 男生
                System.out.println("展示了一些信息给男生观看~~~");
                break;
            case GIRL:
                // 女生
                System.out.println("展示了一些信息给女生观看~~~");
                break;
        }
    }
}
