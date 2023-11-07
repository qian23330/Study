

```java
1.【单选题】反馈
void的含义是 ？ 
	A: 方法体为空
	B: 方法体没有意义
	C: 定义方法时必须有返回值
	D: 方法没有返回值

格式:
修饰符 返回值类型  方法名称(参数列表...){
	方法体; 
	return 返回值;
}
```

```java
2.【单选题】
方法的形参 （）
	A: 可以没有
	B: 至少有一个
	C: 必须定义多个形参
	D: 形参的数据类型可以是基本数据类型，但不可以是引用数据类型

形参: 在定义方法时()中定义的参数
具体形参的个数和类型是由需求确定的
```

```java
3.【单选题】代码如下：
public static void main(String[] args){
   ________________________________
}
public static void method(){
    System.out.println("我是黑马程序员");
}
运行结果是：
​ 我是黑马程序员
横线处应该填写的正确代码是（）
	A: method;
	B: void v = method();
	C: method();
	D: method("我是黑马程序员");
```

```java
本题分数:10分  *难度：3星 
4.【单选题】反馈请观察以下代码，分别为第三行和第六行选出正确选项，保证可以在控制台上输出
public class Test08 {
    public static void main(String[] args){
	    _____①_____
    }

    public _____②_____ print() {	
        System.out.println("wo ai java");
        return ;
    }
}
运行结果是：​ wo ai java
​ 横线处应该填写的正确代码是？ 
	A: ①  void v = print();		②  static void
	B: ①  print();				②  static void    
	C: ①  int v = print();		②  static int	
	D: ①  print();				②  static
```



```java
5.【单选题】反馈
下列方法定义格式正确的是 ？

A:错误:方法不能嵌套定义
public static void method1(){
    public static void method2(){
    }
}

B:
public static void method1(){
    
}

C:错误,返回值类型应该写为int
public static void method1(){
   return 10;
}

D:
public static boolean method1(int n){
    if(n < 10){	
        return false;
    }else if(n >= 10){
		return true;
	}//少了一个else
}
	
A: 选择A
	
B: 选择B
	
C: 选择C
	
D: 选择D

```



```java
6.【单选题】反馈
观察以下代码，请选出方法调用过程的正确顺序 

//1 2 4 5 6 2 3
public static void main(String[] args) {
    System.out.println("开始执行");	   //1
    int a = print(10);                //2
    System.out.println(a);		     //3
}
public static int print(int n){    	 //4
    n += 10;                         //5
    return n;          			    //6
}
	
A: 1，2，3，4，5，6  
	
B: 1，2，4，6，5，3 
	
C: 1，4，5，6，2，3 
	
D: 1，2，4，5，6，3  

```





```java
7.【单选题】反馈 
以下选项中，关于方法定义的参数或返回值描述正确的是: 
	
A: 方法的参数可以有，可以没有，也可以有多个 
	
B: 方法除了可以定义在类中，也可以定义在方法中，形成方法的嵌套 	错误: 方法不能嵌套定义
	
C: 一个方法执行完成之后可以有一个返回值 ,也可以有多个返回值	 错误: 只能有一个返回值
	
D: 方法都必须显式使用return关键字  错误: 如果没有返回值,返回值类型写为void,return ; 可以省略
```



```java
8.【单选题】反馈
下面程序代码，在空白处能正确调用divide(  )方法的选项是 

public class Demo {
    public static void main(String[] args) {
        _________________________
    }   
    public static double divide(int a, int b) {
        return a * 1.0 / b;
    }
}
	
A: double a = divide(1, 2);
	
B: double a = divide(1.0, 2.0);
	
C: int x = divide(1,2);
	
D:  int x = divide(1.0,2.0);

```



```java

 本题分数:10分  *难度：3星
9.【多选题】反馈
下面关于方法的概述描述，正确的是 		

	
A: 方法定义的先后顺序无所谓 
	
B: 方法的定义不能产生嵌套包含关系
	
C: 方法可以让程序的执行效率更高 
	
D: 方法定义好了之后，不会执行的，如果要想执行，一定要进行方法的调用 
```



```java
10.【多选题】反馈
关于对方法的调用，正确的是: 
有返回值赋值调,无返回值单独调
	
A: 有具体返回值的方法, 可以直接调用, 赋值调用以及输出调用

B: 没有具体返回值的方法, 可以直接调用和输出调用 
	
C: 有具体返回值的方法, 只能赋值调用和输出调用
	
D: 没有具体返回值的方法, 只能直接调用
```





```
11.下列关于continue和break的描述正确的是( )
break: 只能使用在循环和switch语句中
continue: 只能使用在循环语句中
```

|      | `A: continue只能用于循环体中`        |
| ---- | ------------------------------------ |
|      | `B: break只能用于循环体中  `         |
|      | `C: continue只能用于switch语句体中 ` |
|      | `D: break只能用于switch语句块中`     |



12.下面程序执行的结果是 (  )

```java
int i = 100; 

while(true) { 	
	if (i++ > 100)  { 
        
		break; 

	} 

	System.out.println(i); 

} 
```

 

|      | `A: 100 ` |
| ---- | --------- |
|      | `B: 101`  |
|      | `C: 102 ` |
|      | `D: 报错` |



13.分析以下代码片段,并按照下列两个问题在横线处补全代码,下列选项正确的是(  )

```java
public class Test01 {
        public static void main(String[] args) {
            for(int x=1; x<=10; x++) {
                if(x % 3==0) {
                  // 补全代码
    			  __________
                }
                System.out.println("我爱Java!");
            }
        }
    }
```

问题:
     ① 在控制台输出2次:"我爱Java!" 横线处应该填写什么?
     ② 在控制台输出7次:"我爱Java!" 横线处应该填写什么?

|      | `A: ①continue ②break `   |
| ---- | ------------------------ |
|      | `B: ①continue ②continue` |
|      | `C: ①break ②continue`    |
|      | `D: ①break ②break `      |



14.下列代码的运行结果是(  )

```java
public static void main(String[] args){
        for(int i=1;i<=10;i++){//针对循环体i的有效值: 1,2,3,4...10
        	if(i%5==0){               
                System.out.println("hello");
                break;
            }
        }
    }
```

 

|      | `A: 输出5个hello`  |
| ---- | ------------------ |
|      | `B: 输出4个hello`  |
|      | `C: 输出1个hello`  |
|      | `D: 输出9个hello ` |



15.下列代码的运行结果是 

```java
public static void main(String[] args) {
    	int count = 0;
    	for(int i = 1;i <= 10;i++) {
            if(i % 5 == 0) {
                break;
            }
                      
            if (i == 3 || i == 7 || i == 9){
                continue;
            } 
            
            count++;
        }
        System.out.println(count);
    }
```

 

|      | `A: 4`  |
| ---- | ------- |
|      | `B: 3`  |
|      | `C: 2 ` |
|      | `D: 1`  |



16.下列代码能够获取1到100(包含1和100)之间随机数的（ ）

 

A：

```java
Random r = new Random();
int num = r.nextInt();
```

B：

```java
Random r = new Random();
int num = r.nextInt(100);
```

C：

```java
Random r = new Random();
int num = r.nextInt(100)+1;
```

D：

```java
Random r = new Random(System.in);
int num = r.nextInt(100+1);
```

 

|      | `A:  ` |
| ---- | ------ |
|      | `B:  ` |
|      | `C:  ` |
|      | `D:  ` |



17.下列代码能够用于随机产生[1,99]包含1,包含99之间整数的是( )

```java
public static void main(String[] args) {
    Random r = new Random();
    int num = r.nextInt(40)+59;
    System.out.println(num);
}	
```

B：

```java
public static void main(String[] args) {
    Random r = new Random();
    int num = r.nextInt(99) + 1;
    System.out.println(num);
}
```

C：

```java
public static void main(String[] args) {
    Random r = new Random();
    int num = r.nextInt(99);
    System.out.println(num);
}
```

D：

```java
public static void main(String[] args) {
    Random r = new Random();
    int num = r.nextInt(100)-1;
    System.out.println(num);
}
```

 

|      | `A:   ` |
| ---- | ------- |
|      | `B:   ` |
|      | `C:  `  |
|      | `D:  `  |



18【多选】

```
下列关于break和continue说法正确的是（）
```

|      | `A: break是跳出本次循环,执行break之后,循环还可以继续执行`    |
| ---- | ------------------------------------------------------------ |
|      | `B: continue是结束本次循环, 还会继续执行下一次循环`          |
|      | `C: break除了用于循环还可以用于swtich语句,在switch语句中表示跳出switch语句,在循环中表示终止当前循环` |
|      | `D: continue除了用于循环还可以用于switch语句,都表示继续匹配的意思` |