

## 一、选择题

1、如果想要在电脑中编译并运行Java程序，电脑中必须安装什么（C）

```
A: 安装JRE
B: 安装JVM
C: 安装JDK
D: 安装Java
```

2.下列关于JVM、JRE、JDK说法错误的是：(C)

```
A：JVM是Java虚拟机，是运行所有Java程序的

B：JRE是Java程序的运行时环境，包含运行时所需要的核心类库

C：JVM是Java的运行环境，包含了JRE

D：JDK是Java程序开发工具包，包含了JRE和开发人员使用的编译和执行工具
```

3、以下变量的定义正确的是 D

```
A int x = 5.0;

B. double d = "中国";

C. a = 12;

D. double b = 3.14;
```

4.下面变量名定义正确的是（C） 

```
A、class 
B、2var1   
C、_var2 
D、var3& 
```



```
5.以下选项中哪个是java中的关键字（A  ）
```

|      | `A: public`     |
| ---- | --------------- |
|      | `B: name`       |
|      | `C: main`       |
|      | `D: HelloWorld` |



```
6.下列命令中，哪个是Java的运行命令?（ D ）
```

|      | `A: javac   ` |
| ---- | ------------- |
|      | `B: javadoc`  |
|      | `C: javah  `  |
|      | `D: java`     |



```
7.以下选项中,关于字面量说法正确的是（ A ）
```

|      | `A: ' '（里面是一个空格）。这是一个字符字面量 “  ”（里面是一个空格）。这是一个字符串字面量` |
| ---- | ------------------------------------------------------------ |
|      | `B: ''（里面是没有空格）。这是一个字符字面量 “”（里面是没有空格）。这是一个字符串字面量` |
|      | `C: 'ab'。这是一个字符字面量 “ab”。这是一个字符串字面量`     |
|      | `D: 1 ， 2 ， 3 ， 3.0 这4个都是整数字面量 1.0 ， 2.1 ， 3.1 这3个都是小数字面量` |



```
8.Java源文件和编译后的文件扩展名分别为 （  B ）
```

|      | `A: .class和  .java`  |
| ---- | --------------------- |
|      | `B: .java和 .class `  |
|      | `C: .class和  .class` |
|      | `D: .java和 .java`    |



```
9.关于字面量的打印输出，下列哪个选项是正确的？（ A ）
```

|      | `A: System.out.println("");`   |
| ---- | ------------------------------ |
|      | `B: System.out.println(''); `  |
|      | `C: System.out.println(ab); `  |
|      | `D: System.out.println('ab');` |



```
10.下面哪个选项可以正确输出字面量（ ）
```

|      | `A: System.out.println("HelloWorld");` |
| ---- | -------------------------------------- |
|      | `B: System.out.println('it');`         |
|      | `C: System.out.println('');`           |
|      | `D: System.out.println('false');`      |



11.下列程序能正确执行的是（C）

A:

```java
public class Helloworld { 
	public static void main(string[] args) { 
  			System.out.println("helloworld!");
 	 } 
} 
```

B:

```java
public class Helloworld { 
	public static void main(String[] args) { 
  		system.out.println("helloworld!")
   	}
}
```

C:

```java
public class Helloworld { 
    public static void main(String[] args) { 
        System.out.println("helloworld!");
    } 
}
```

D:

```java
public class Helloworld { 
	public static void main(String[] args); { 
  		System.out.println("helloworld!");
}
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D:  ` |



```
12.下列不属于java注释的是（ D ）
```

|      | `A: /*我爱北京天安门*/ ` |
| ---- | ------------------------ |
|      | `B: //我爱北京天安门`    |
|      | `C: /**我爱北京天安门*/` |
|      | `D: /我爱北京天安门**/`  |



```
13.下列哪个命令可以进入当前盘符下指定的目录（ A ）
```

|      | `A: cd`    |
| ---- | ---------- |
|      | `B: dir`   |
|      | `C: cls`   |
|      | `D: 盘符:` |

```

```

14.关于变量的定义、打印，下列哪个选项代码可以正常编译？（ A  ）

A

```java
public static void main(String[] args) {
    int a = 10;
    int b = 20;
}
```

B

```java
public static void main(String[] args) {
  int a;
    // 变量使用前必须给初始值
  System.out.println(a);
}
```

C

```java
public static void main(String[] args) {
    {
        int b = 128;
    }
    System.out.println(b);
}
```

D

```java
public static void main(String[] args) {
    int a = true;
}
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D: `  |



```
15.idea编写第一个入门程序的顺序是怎么样的？  B
```

|      | A: Module-> Module -->  Package --> Class     |
| ---- | --------------------------------------------- |
|      | B:  Project -> Module -->  Package --> Class  |
|      | `C: Project ->   Package --> Module --> Class |
|      | `D: Module->  Project-->  Package --> Class   |



```
16【多选题】下列关于Java关键字的说法，正确的是（ ABC ）
```

|      | `A: 程序员不能使用Java关键字来命名`          |
| ---- | -------------------------------------------- |
|      | `B: Java关键字有特定的含义`                  |
|      | `C:  Java关键字在高级编辑器中有特殊颜色标记` |
|      | `D: System是Java的关键字`                    |

## 二、代码题

### 题目1

请安装JDK17，并进行手动请编写程序,将如下语句输出到屏幕上:

```Java
你好Java!
```

------

##### 你的答案:

```java

```



### 题目2

字面量是指在程序中直接书写的一些数据，目的是要告诉我们该如何写这些数据,  请编写Java程序,分别将下列字面量数据打印到屏幕上。

```Java
字符串字面量:用双引号括起来的内容。  		   -->要求--->		请在控制台输出字符串 	"Hello World"
整数字面量:不带小数的数字。	      		  -->要求--->	   	   请在控制台输出整数数字	666
小数字面量:带小数的数字。		  		   -->要求--->		请在控制台输出小数数字	 -5.21 
字符字面量:用单引号括起来的内容。    		-->要求--->	     请在控制台输出字符		'我' 
布尔字面量:布尔值,表示真假。只有两个值：	  -->要求--->        请在控制台输出布尔字面量	false 
```

##### 你的答案:

```java

```



### 题目3

请编写程序，将某位学员的个人信息输出到屏幕上。信息包括姓名（字符串字面量）、性别（字符字面量）、年龄（整型字面量）、身高（单位米，小数字面量）、婚否（布尔字面量）。输出格式如下：

```java
小明
男
18
1.78
true
```

##### 你的答案:

```java

```



### 编程题4（拓展题）

**磊哥温馨提示：拓展题目，难度对初学者来说蛮大，实在不会没所谓，可以参考答案编写。**

1.请根据下列描述，选择合适的变量存储各种的数据，并模拟张三收李四和王五发来的红包的过程。

1)   张三自己的钱包里有5.1元钱。

2）李四发出了8.5元红包给张三

3）王五发出了20.0元红包给张三

4）请使用变量来运算出，张三 收到李四的红包后有多少钱并输出，张三收到王五的红包后有多少钱并输出。

**运行效果如下**

```
张三目前的余额是是：
5.1
张三接收李四的红包后余额是：
13.6
张三接收王五的红包后余额是：
33.6
```



##### 你的代码:

```java

```

