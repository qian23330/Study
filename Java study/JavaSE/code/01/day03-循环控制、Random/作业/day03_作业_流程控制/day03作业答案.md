### day03作业编程题

### 题目1:

```java
需求:
	让用户依次录入三个整数，求出三个数中的最大值，并打印到控制台。【使用if】
	
实现步骤:
	
```

**您的代码**

```java
/*
    需求:
        让用户依次录入三个整数，求出三个数中的最大值，并打印到控制台。【使用if】

    实现步骤:
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的三个整数数字,分别保存int变量a,b,c中
        3.计算a,b,c的最大值
        4.打印最大值
 */
@SuppressWarnings("all")
public class Test01_01 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的三个整数数字,分别保存int变量a,b,c中
        System.out.println("请输入第一个整数数字: ");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数数字: ");
        int b = sc.nextInt();
        System.out.println("请输入第三个整数数字: ");
        int c = sc.nextInt();
        //3.计算a,b,c的最大值
        /*//方式一:
        int temp = (a > b) ? a : b;
        int max = (temp > c) ? temp : c;*/

        /*//方式二
        int max;
        if(a>b) {
            max = a;
        } else {
            max = b;
        }
        if (c > max) {
            max = c;
        }*/

        /*//方式三
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }*/
        //方式四
        int max;
        if (a >= b && a >= c) {
            max = a;
        } else if (b >= a && b >= c) {
            max = b;
        } else {
            max = c;
        }
        //4.打印最大值
        System.out.println("最大值: " + max);
    }
}
```



### 题目2:

```java
需求:
    1.根据程序员的工龄(整数)给程序员涨工资(整数),程序员的工龄和基本工资通过键盘录入
    2.涨工资的条件如下：
        [10-15)     +20000
        [5-10)      +10000
        [3~5)       +5000
        [1~3)       +3000        
     3.运行程序:
         请输入作为程序员的你的工作的工龄:10
         请输入作为程序员的你的基本工资为:60000
         程序运行后打印格式
         	"您目前工作了10年，基本工资为 60000元, 应涨工资 20000元,涨后工资 80000元"
     
         
实现步骤:
	
```

**您的代码**

```java
/*
    需求:
        1.根据程序员的工龄(整数)给程序员涨工资(整数),程序员的工龄和基本工资通过键盘录入
        2.涨工资的条件如下：
            [10-15)     +20000
            [5-10)      +10000
            [3~5)       +5000
            [1~3)       +3000
         3.运行程序:
             请输入作为程序员的你的工作的工龄:10
             请输入作为程序员的你的基本工资为:60000
             程序运行后打印格式
                "您目前工作了10年，基本工资为 60000元, 应涨工资 20000元,涨后工资 80000元"
    实现步骤:
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的代表工龄的整数数字,保存int变量gl中
        3.获取键盘录入的代表基本工资的整数数字,保存int变量jbgz中
        4.定义int变量yzgz,用来记录应涨工资的数量
        5.使用if语句第三种格式判断工龄的范围,记录应涨工资
        6.根据题目需求输出结果数据
 */
public class Test02 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的代表工龄的整数数字,保存int变量gl中
        System.out.println("请输入作为程序员的你的工作的工龄:");
        int gl = sc.nextInt();
        //3.获取键盘录入的代表基本工资的整数数字,保存int变量jbgz中
        System.out.println("请输入作为程序员的你的基本工资为:");
        int jbgz = sc.nextInt();
        //4.定义int变量yzgz,用来记录应涨工资的数量
        int yzgz /*= 0*/;
        //5.使用if语句第三种格式判断工龄的范围,记录应涨工资
        if (gl >= 10 && gl < 15) {
            yzgz = 20000;
        } else if (gl >= 5 && gl < 10) {
            yzgz = 10000;
        } else if (gl >= 3 && gl < 5) {
            yzgz = 5000;
        } else if (gl >= 1 && gl < 3) {
            yzgz = 3000;
        } else {
            yzgz = 0;
        }
        //6.根据题目需求输出结果数据
        System.out.println("您目前工作了" + gl + "年，基本工资为 "
                + jbgz + "元, 应涨工资 " + yzgz + "元,涨后工资 " + (jbgz + yzgz) + "元");
    }
}
```



### 题目3:

```java
需求:
	打印出1到100之间的既是3的倍数又是5倍数的数字以及这些数字的和
实现步骤:	
```

##### 答案:

```java
/*
    需求:
        打印出1到100之间的既是3的倍数又是5倍数的数字以及这些数字的和

    实现步骤:
        1.定义int变量sum,初始值0,用来累加求和
        2.使用for循环获取1到100之间的数字,循环变量int类型num
        3.判断num中当前数字如果满足条件(既是3的倍数又是5倍数)
        3.1 输出满足条件的当前数字
        3.2 把满足条件的当前数字累加到求和变量sum中
        4.for循环结束后,打印结果数据
 */
public class Test03_01 {
    public static void main(String[] args) {
        //1.定义int变量sum,初始值0,用来累加求和
        int sum = 0;
        //2.使用for循环获取1到100之间的数字,循环变量int类型num
        for (int num = 1; num <= 100; num++) {
            //3.判断num中当前数字如果满足条件(既是3的倍数又是5倍数)
            if ((num % 3 == 0) && (num % 5 == 0)) {
                //3.1 输出满足条件的当前数字
                System.out.println(num);
                //3.2 把满足条件的当前数字累加到求和变量sum中
                sum += num;
            }
        }
        //4.for循环结束后,打印结果数据
        System.out.println("以上满足条件的数字之和: " + sum);
    }
}
```



### 题目4:

```java
需求:
	从键盘上录入一个大于100的三位数,打印出100到该数字之间满足如下要求的数字,数字的个数,以及数字的和:
		1.数字的个位数不为7;
		2.数字的十位数不为5;
		3.数字的百位数不为3;
实现步骤:

```

##### 答案:

```java
/*
    需求:
        从键盘上录入一个大于100的三位数,打印出100到该数字之间满足如下要求的数字,数字的个数,以及数字的和:
            1.数字的个位数不为7;
            2.数字的十位数不为5;
            3.数字的百位数不为3;
            以上三个条件: 必须同时满足
    实现步骤:
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的大于100的整数数字,保存int变量maxValue
        3.定义int变量count,初始值0,用来统计个数
        4.定义int变量sum,初始值0,用来累加求和
        5.使用for循环获取10到maxValue之间的数字,循环变量int类型num
        5.1 判断num中的数字如果满足条件
        5.2 输出满足条件的当前数字
        5.3 把满足条件的当前数字累加到求和变量sum中
        5.4 计数器count的值增加1
        6.for循环结束,输出结果数据
    要求:
        每行输出十个,之间使用空格隔开
 */
public class Test04 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的大于100的整数数字,保存int变量maxValue
        System.out.println("请输入大于100的三位整数数字: ");
        int maxValue = sc.nextInt();
        //3.定义int变量count,初始值0,用来统计个数
        int count = 0;
        //4.定义int变量sum,初始值0,用来累加求和
        int sum = 0;
        //5.使用for循环获取10到maxValue之间的数字,循环变量int类型num
        for (int num = 100; num <= maxValue; num++) {
            //5.1 判断num中的数字如果满足条件
            int ge = num % 10;
            int shi = num / 10 % 10;
            int bai = num / 100 % 10;
            if ((ge != 7) && (shi != 5) && (bai != 3)) {
                //5.2 输出满足条件的当前数字
                System.out.println(num);
                //5.3 把满足条件的当前数字累加到求和变量sum中
                sum += num;
                //5.4 计数器count的值增加1
                count++;
            }
        }
        //6.for循环结束,输出结果数据
        System.out.println("以上满足条件的数字之和: " + sum);
        System.out.println("以上满足条件的数字个数: " + count);
    }
}

```



### 题目5:

```java
需求:      
	1.打印所有四位数中 个位 + 千位 == 百位 + 十位 的数字
    2.最后要打印符合条件的数字的总数量
   	3.打印格式如下:
		1010
        1021 
        1032
        1043 
        ....
        以上满足条件的四位数总共有 615 个
实现步骤:
	     
```

##### 答案:

```java
/*
    需求:
        1.打印所有四位数中 个位 + 千位 == 百位 + 十位 的数字
        2.最后要打印符合条件的数字的总数量
        3.打印格式如下:
            1010
            1021
            1032
            1043
            ....
            以上满足条件的四位数总共有 615 个
    实现步骤:
        1.定义int变量count,初始值0,用来统计个数
        2.使用for循环遍历所有的四位数字,循环变量int类型num
        2.1 计算num中当前数字的个位,十位,百位,千位
        2.2 判断如果满足条件(个位 + 千位 == 百位 + 十位)
        2.3 输出满足条件的当前数字
        2.4 计数器count的值增加1
        2.5 判断如果步骤2.3中输出的数字是当前行的第五个数字,直接换行
        3.for循环结束后,输出结果数据

    要求:
        每行输出五个,之间使用空格隔开

 */
@SuppressWarnings("all")
public class Test05_01 {
    public static void main(String[] args) {
        //1.定义int变量count,初始值0,用来统计个数
        int count = 0;
        //2.使用for循环遍历所有的四位数字,循环变量int类型num
        for (int num = 1000; num <= 9999; num++) {
            //2.1 计算num中当前数字的个位,十位,百位,千位
            int ge = num % 10;
            int shi = num / 10 % 10;
            int bai = num / 100 % 10;
            int qian = num / 1000 % 10;
            //2.2 判断如果满足条件(个位 + 千位 == 百位 + 十位)
            if ((ge + qian) == (bai + shi)) {
                //2.3 输出满足条件的当前数字
                System.out.print(num + " ");
                //2.4 计数器count的值增加1
                count++;
                //2.5 判断如果步骤2.3中输出的数字是当前行的第五个数字,直接换行
                if (count % 5 == 0) {
                    System.out.println();
                }
            }

        }
        //3.for循环结束后,输出结果数据
        System.out.println("以上满足条件的数字个数: " + count);
    }
}
```



