### 一、选择题

##### 1.关于面向对象的特点,错误的是：（）

A：角色发生了转换,将我们从指挥者变成了执行者

B：可以将复杂的事情简单化

C：角色发生了转换,将我们从执行者变成了指挥者

D：是一种更符合我们思考习惯的思想



##### 2.下列描述错误的是（ ）

A:  面向对象是一种基于面向过程的编程思想。

B:  使用面向对象思想完成一个功能，强调找一个具有该功能的对象，使用这个对象完成功能。

C:  面向对象与面向过程，两种思想相互独立，二者没有任何关联.

D:  毛毛想吃棉花糖，她有2种方案，一是出去小吃街上找个卖棉花糖的商贩，让商贩给做一个大棉花糖.二是自己上网搜索制作棉花糖的步骤，然后学着一步步自己做。自己做，就是面向过程思想，关注步骤;找商贩做就是面向对象思想，关注具备功能的对象



##### 3.下列描述正确的是（）

A:  类与对象之间是包含关系，类包含对象。

B:  类与对象之间是等价关系，类和对象其实是同一个概念。 

C: 通过一个类，只能创建一个对象。

D: 对象是类的实例，类是对象的模板。



##### 4.下列描述错误的是（ ）

A:   必须先定义成员变量，再定义成员方法。

B:  定义成员变量时，可以不给变量赋值。成员变量有默认初始化值 

C: 类的{}中定义的是类的成员，可以有成员变量和成员方法.

D:  成员变量的名字可以和局部变量的名字相同。



##### 5.下列描述错误的是（ ）

A:  在方法中的变量是局部变量

B:  局部变量随着方法的调用而存在，随着方法的调用结束而消失

C:  成员变量在类中、方法外

D:  局部变量有默认的初始化值



##### 6.下面关于Java中类与对象描述错误的是 (  )

A： 对象是类的一个实例 

B： 类是所有事物的模板，用事物属性特征和行为来描述所有事物 

C： 类是对象的模板，对象是类的实体 

D： 对象是一类事物的具体体现，必然具备该类事物的属性和行为 



##### 7.下列关于成员变量和局部变量的区别,说法正确的是( )【多选题】

A：成员变量有默认初始化值，局部变量没有默认初始化值

B：成员变量在整个类中都可以使用，局部变量只能在所属的方法中使用

C：成员变量被定义在类中方法外，局部变量被定义在方法声明上或者方法内部

D：成员变量在栈内存中，局部变量在堆内存中



##### 8.如果已经定义了一个Student类，那么创建其对象的正确写法是：（）

A：`Student p = new student();`

B：`Student p = new Student();`

C：`Student p = new.Student();`

D：`student p = new student();`



##### 9.下面代码中定义Person类,

##### 在测试类Demo中的main方法中编写代码的四个选项中说法正确(相关需求看选项中的注释)的是（）【多选题】

```java
public class Person {
    String name;
    int age;
    public void show() {
        System.out.println("姓名: "+name+", 年龄: "+age);
    }
}
public class Demo {
    public static void main(String[] args){
        
    }
}
```

A:

```java
//可以正确创建Person类的对象
Person p = new Person;
```

B:

```java
//可以正确创建Person类的对象
Person p = new Person();
```

C:

```java
//可以正确创建Person类的对象
Person p = new Person();
//可以正确调用方法,并打印输出结果: 姓名: null, 年龄: 0
p.show();
```

D:

```java
//可以正确创建Person类的对象
Person p = new Person();
//可以正确的给成员变量赋值
p.name = "张三";
p.age = 18;

//可以正确调用方法,并打印输出结果: 姓名: 张三, 年龄: 18
p.show();
```



##### 10.如果有一个Student类的定义如下，并且已经创建了stu对象：

```java
public class Student {
  String name;
  public void method() {
  	System.out.println(name);
  }
}
public class Demo {
    Student stu = new Student();
    
}
```

##### 那么希望给其成员变量name赋值,并执行成员方法method的正确写法是：（）

A：`stu.name="张三"` 和 `stu.method;`

B：`stu.name()="张三"` 和 `stu.method();`

C：`stu.name="张三"` 和 `stu.method();`

D：`stu.name()="张三"` 和 `stu.method;`

##### 11:下列关于private描述错误的是 (  )

A: 被private修饰的成员变量和成员方法，只能在本类中使用，不能在其他类中直接访问 

B: private是一个修饰符，可以完成类对成员变量的封装，防止外部非法访问. 

C:  类的成员变量被private修饰，如果想让成员变量被其他类使用，可以为成员变量提供对应public的setXxx和getXxx方法. 

D:   private仅用来修饰成员变量.  



##### 12:下列关于this描述错误的是（）  

A:  当成员变量和局部变量重名时，可以使用this来区分。 

B:  局部变量和成员变量同名时,直接写变量名代表的成员变量

C:  局部变量和成员变量同名时,直接写this.变量名代表的成员变量

D:  在方法中访问本类成员变量(和局部变量不重名)，可以省略this不写。



##### 13.下列描述正确的是（）

A:  构造方法名必须和类名一致。

B:  同一个类的多个构造方法，不能构成方法重载。  

C:  构造方法的返回值类型必须是void。

D:  定义一个类，如果没有定义构造方法，那么这个类没有构造方法。



##### 14.下列有关标准类的定义，描述正确的是（ ）

A:     

```
1.成员变量私有

2.提供私有setter和getter方法

3.提供私有构造
```



B:  	

```
1.成员变量私有

2.提供公共setter和getter方法

3.提供私有构造 
```



C:  	

```
1.成员变量私有

2.提供公共setter和getter方法

3.提供public修饰的空参构造和满参构造 
```



D:    

```
1.成员变量私有

2.提供私有setter和getter方法

3.提供private修饰的空参构造和满参构造 
```

##### 15.下面关于构造方法的描述，正确的选项有哪些？（ ）【多选题】

 A： 方法名必须和类名相同 

 B： 方法名的前面没有返回值类型的声明 

 C： 在方法中不能使用 return 语句返回一个值 

 D： 当定义了带参数的构造方法，系统默认的不带参数的构造方法依然会自动提供 



##### 16.下面关于 Scanner 的方法中说法正确的是（）。【多选题】

 A： Scanner 的 next()方法 对于录入的字符串碰到空格就会停止录入。

 B： Scanner 的 nextInt()方法可以录入数字和字符。

 C： Scanner 的 nextLine()方法会把整行字符串全部录入。

 D： Scanner 的 nextLine()方法可以录入数字和字符。



**17. 给定如下 java 代码，编译运行时，以下哪些语句的值为 true（）** 【多选题】

```java
char[] chs = {'h','e','l','l','o'};
String s = new String(chs);
String t = new String(chs);
String h = new String("hello");
String e = "hello";
String f = "hello";

```

 A： s.equals(t);

 B： t.equals(e);

 C： s==t;

 D： e==f;

 E:   s.equals(h);

 F:   s==h;

 G:  h == e; 





**18.现有 Animal 类 属性有 name 和 age，下列选项中属于它的构造方法的有（ ）**  【多选题】

A. 

```java
public Animal() { } 
```



B.

```java
public Animals() { } 
```



C.

```java
 public Animal(String name, int age) {
     this.name = name; 
     this.age = age; 
 } 
```



D.

```java
 public void Animal(String name, int age) {
     this.name = name; 
     this.age = age; 
 }
```



##### 19.下列关于java中类的说法哪个是不正确的是 (  ) 【多选题】

A： 类中不仅可以定义成员变量和成员方法法，还可以定义构造方法 

B： 构造方法是类中的特殊方法,主要是完成给对象中的成员变量进行初始化的 

C： 类中的构造方法必须被定义为public的,不能定义为private的

D： 一个类中只能定义一个构造方法,不能不定义,也不能定义多个构造方法



