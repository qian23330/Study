```
1.下列数组创建并初始化格式错误的是( C ) 
```

|      | `A: int[] arr = new int[] {33,22,11};`               |
| ---- | ---------------------------------------------------- |
|      | `B: int[] arr = new int[4]; `                        |
|      | `C: double[] arr = new double[3]{5.2, 3.14, 6.18}; ` |
|      | `D: int[] arr = {11,22,33}; `                        |

```
2.数组a的第三个元素表示为（ D ）
```

|      | `A: a(3)` |
| ---- | --------- |
|      | `B: a[3]` |
|      | `C: a(2)` |
|      | `D: a[2]` |

```
3.当访问无效的数组下标(就是索引)时，会发生（B  ）现象
```

|      | `A: 正常执行`                  |
| ---- | ------------------------------ |
|      | `B: 程序出错`                  |
|      | `C: 跳过当前行,继续执行下一行` |
|      | `D: 无现象`                    |

```
4.代码如下,运行结果是7,则横线处应该填写的内容是( C )
public static void main(String[] args){
    int[] arr = { 3,7,6,9,2,5,8 };
    System.out.println(______arr[1]______);
}
```

 

|      | `A: arr[6]` |
| ---- | ----------- |
|      | `B: arr[2]` |
|      | `C: arr[1]` |
|      | `D: arr[0]` |





```
5.下列代码的运行结果是( D )
public static void main(String[] args) {
    int arr[] = {1, 3, 5, 7, 9};
    System.out.println("结果是："+arr[1]);
    System.out.println("结果是："+arr[arr.length-1]);
}
```

 

|      | `A: 结果是:1 结果是:9 `  |
| ---- | ------------------------ |
|      | `B: 结果是:1 结果是:7`   |
|      | `C: 结果是:3 结果是:7 `  |
|      | `D: 结果是:3 结果是:9  ` |





```
6.下列代码中,有关数组的定义格式错误的是(  C   )
```

|      | `A:  int[] arr = {1,2,3,4,5,6};`           |
| ---- | ------------------------------------------ |
|      | `B:  int[] arr = new int[3];`              |
|      | `C:  int[] arr = new int[6]{1,2,3,4,5,6};` |
|      | `D:  int[] arr = new int[]{1,2,3,4,5,6};`  |





7.下列代码能够正常遍历数组的是(   B  )

A:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

B:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

C:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int i = 0;
        while(i < arr.length){
            System.out.println(arr[i]);
        }
    }
}
```

D:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        for (int i = 0; ; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D:  ` |





8.下列代码能够获取任意数组中元素最大值的是(   C  )

A:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {23,544,56,1,23,45,21,1,78};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {            
            if(max < arr[i]){
                arr[i] = max;
            }
            System.out.println(max);
        }
    }
}
```

B:

```java
public class Demo{  
    public static void main(String[] args){
        int[] arr = {23,544,56,1,23,45,21,1,78};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max > arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
```

C:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {23,544,56,1,23,45,21,1,78};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
```

D:

```java
public class Demo{
    public static void main(String[] args){
        int[] arr = {-23,-544,-56,-1,-23,-45,-21,-1,-78};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]){
                arr[i] = max;
            }
        }
        System.out.println(max);
    }
}
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D:  ` |





9.下面代码用于获取数组的最大值,画横线区域处应填写代码正确的是 (   C   )

```java
public static void main(String[] args){
    int[] arr = { 2,7,-1,6,3 };
    _____(1)______
    for(int i=1;i<arr.length;i++){
        if(___(2)____){
           ___(3)____
        }
    }
    System.out.println("最大值是:" + max);
}
```

 

|      | `A: (1)int max = 0; (2)arr[i]<max; (3)arr[i] = max; `        |
| ---- | ------------------------------------------------------------ |
|      | `B: 	(1)int max = 0; 	(2)arr[i] > max;  	(3)max = arr[i];  ` |
|      | `C: 	(1)int max = arr[0]; 	(2)arr[i] > max;  	(3)max = arr[i];   ` |
|      | `D: 	(1)int max = arr[0]; 	(2)arr[i] > max;  	(3)arr[i]= max ;  ` |





10.【多选题】下列操作中能够正常编译运行的是(    AC  )

A:

```java
public static void main(String[] args){
    int[] arr = {1,2,3};
    int[] nums = arr;
}
```

B:

```java
public static void main(String[] args){
    int[] arr = {1,2,3};
    int num = arr0;
}
```

C:

```java
public static void main(String[] args){
    int[] arr = {1,2,3};
    arr[1] = 5;
}
```

D:

```java
public static void main(String[] args){
    int[] arr = {1,2,3};
    arr.[0] = 2;
}
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D:  ` |