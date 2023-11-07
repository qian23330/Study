## 题目1:

```java
需求:
	请使用静态初始化的方式,创建一个长度为5的整数数组,并为数组中的元素赋值,
	遍历数组,在同一行打印所有元素,元素之间用空格隔开,
	比如1:如果数组为{1,2,3,4,5}打印结果:1 2 3 4 5
    比如2:如果数组为{1,2,3,4,5}打印结果:[1, 2, 3, 4, 5]
```

### 你的答案:

```java
/*
    需求:
        请使用静态初始化的方式,创建一个长度为5的整数数组,并为数组中的元素赋值,
        遍历数组,在同一行打印所有元素,元素之间用空格隔开,
        比如:如果数组为{1,2,3,4,5}打印结果:1 2 3 4 5

    实现步骤:
        1.定义int数组array,并初始化
        2.使用for循环遍历数组array
        3.输出当前元素,不换行,后面拼接" "
 */
public class Test01_01 {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {1,2,3,4,5};
        //2.使用for循环遍历数组array
        for (int i = 0; i < array.length; i++) {
            //3.输出当前元素,不换行,后面拼接" "
            System.out.print(array[i]+" ");
        }
    }
}
```



## 题目2

```java
需求:
	现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的和并打印。
```



### 你的答案:

```java
public class Test02 {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {100, 50, 90, 60, 80, 70};
        //2.计算int数组array的元素和,保存int变量sum中
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.print("数组元素和:  "+sum);
    }
}
```



## 题目3

```java
需求:
	现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的最小值并打印。
```



### 你的答案:

```java
public class Test03 {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {100, 50, 90, 60, 80, 70};
        //2.计算int数组array的最小值,保存int变量min中
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.print("数组元素最小值:  "+min);
    }
}
```



## 题目4

```java
需求:
	现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的最大值并打印。
```



### 你的答案:

```java
public class Test04 {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {100, 50, 90, 60, 80, 70};
        //2.计算int数组array的最大值,保存int变量max中
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.print("数组元素最大值:  "+max);
    }
}
```



## 题目5

```java
需求:
	现有一个整数数组{100,50,90,60,80,70}。
	请编写程序，计算去掉最大值和最小值后的平均值（不考虑小数部分）
```



### 你的答案:

```java
/*
    需求:
        现有一个整数数组{100,50,90,60,80,70}。
        请编写程序，计算去掉最大值和最小值后的平均值（不考虑小数部分）

    实现步骤:
        1.定义int数组array,并初始化
        2.计算int数组array的元素和,保存int变量sum中
        3.计算int数组array的最大值,保存int变量max中
        4.计算int数组array的最小值,保存int变量min中
        5.根据题目需求计算平均值,保存int变量avg中
        6.输出结果数据
 */
public class Test05_01 {
    public static void main(String[] args) {
        //1.定义int数组array,并初始化
        int[] array = {100, 50, 90, 60, 80, 70};
        //2.计算int数组array的元素和,保存int变量sum中
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        //3.计算int数组array的最大值,保存int变量max中
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //4.计算int数组array的最小值,保存int变量min中
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        //5.根据题目需求计算平均值,保存int变量avg中
        int avg = (sum - max - min) / (array.length - 2);
        //6.输出结果数据
        System.out.println("平均值: " + avg);
    }
}
```

