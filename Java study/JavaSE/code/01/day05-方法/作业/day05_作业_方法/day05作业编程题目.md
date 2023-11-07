## 题目1

定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。

### 代码实现

```java
/*
    需求:
        定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。

    三要素:
        1.方法名称:         geMin
        2.是否有未知数据参加运算:  double a,double b
        3.是否产生结果数据: double
 */
public class Test01 {
    public static void main(String[] args) {
        //赋值调用: 传递常量
        double min = getMin(3.3, 2.2);
        System.out.println("min = " + min);

        //输出调用: 传递变量
        double a = 3.3, b = 2.2;
        System.out.println(getMin(a, b));
    }

    //定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。
    public static double getMin(double a, double b) {
        //方式一
        /*if (a > b) {
            return b;
        } else {
            return a;
        }*/
        //方式二
        //return (a<b) ? a : b;

        //方式三
        /*if (a > b) {
            return b;
        }
        return a;*/
        //方式四
        //假设a是最小的
        double min = a;
        if (b < min) {
            min = b;
        }
        return min;
    }
}
```



---

## 题目2:

定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。

### 代码实现

```java
/*
    需求:
        定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。

    三要素:
        1.方法名称:             geMax
        2.是否有未知数据参加运算:  int a,int b,int c
        3.是否产生结果数据: int
 */
@SuppressWarnings("all")
public class Test02 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的三个int数字,保存int变量a,b,c中
        System.out.println("请输入第一个整数数字: ");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数数字: ");
        int b = sc.nextInt();
        System.out.println("请输入第三个整数数字: ");
        int c = sc.nextInt();
        //3.调用方法,获取最大值,保存int变量max中
        int max = getMax(a, b, c);

        System.out.println("最大值: " + max);
    }

    //定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。
    public static int getMax(int a, int b, int c) {
        //三个数的最大值要么是a,要么是b,如果不是a,也不是b,一定是c
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}
```



## 题目3:

数字是有绝对值的，负数的绝对值是它本身取反，非负数的绝对值是它本身。请定义一个方法，方法能够得到小数类型数字的绝对值并返回。请定义方法并测试 

比如: 

​	小数数字 -6.6 的绝对值是 6.6 

​	小数数字 6.6 的绝对值是 6.6



### 代码实现

```java
/*
    需求:
        数字是有绝对值的，负数的绝对值是它本身取反，非负数的绝对值是它本身。
        请定义一个方法，方法能够得到一个小数类型数字的绝对值并返回。请定义方法并测试

    比如:

    ​	小数数字 -6.6 的绝对值是 6.6

    ​	小数数字 6.6 的绝对值是 6.6

    三要素:
        1.方法名称:                  abs
        2.是否有未知数据参加运算:     double num
        3.是否产生结果数据:          double

    其实很多功能在java中已经定义完毕了
    java.lang.Math类: 专门用来完成各种数学运算的
        abs方法:求绝对值的
        pow(m,n)方法: 计算m的n次方的
 */
public class Test03 {
    public static void main(String[] args) {
        double a = 3.3;
        System.out.println("3.3的绝对值: " + Test03.abs(a));
        //abs和main处于同一个类中,可以省略类名
        System.out.println("3.3的绝对值: " + abs(a));
        System.out.println("3.3的绝对值: " + Math.abs(a));

        double b = -3.3;
        System.out.println("-3.3的绝对值: " + Test03.abs(b));
        //abs和main处于同一个类中,可以省略类名
        System.out.println("-3.3的绝对值: " + abs(b));
        System.out.println("-3.3的绝对值: " + Math.abs(b));


        //153是不是水仙花数?
        System.out.println((1*1*1 + 5*5*5 + 3*3*3)==153);
        System.out.println((Math.pow(1,3)+Math.pow(5,3)+Math.pow(3,3))==153);
    }

    public static double abs(double num) {
        return (num < 0.0) ? -num : num;
    }
}

```



