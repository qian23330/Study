### 一、选择题(4分/题)

##### 1.下列有关数组和集合说法,错误的选项为 (    )

A：数组和集合的长度都是可变的

B：数组的长度固定, 集合的长度可变

C：数组可以存储基本类型和引用类型数据

D:  集合中存储的是引用数据类型



##### 2.关于集合说法错误的是（   ）

A： ArrayList的底层数据结构是数组 

B： ArrayList可以存储重复的元素 

C： ArrayList的删除方法是delete()

D： ArrayList获取长度度的方法是size()



##### 3.下列创建 ArrayList 对象错误的是：（  ）

 A： 

```java
ArrayList<String> list1 = new ArrayList(); 
```

 B：

```java
 ArrayList<int> list = new ArrayList(); 
```

 C： 

```java
ArrayList<Character> list2 = new ArrayList(); 
```

D： 

```java
ArrayList<Long> list3 = new ArrayList(); 
```



##### 4.下面代码横线处根据输出要求应该填写的代码是（  ）

```java
public static void main(String[] args){
    ArrayList<String> list = new ArrayList<>();
    list.add("php");
    list.add("itcast");
    list.add("heima");
    list.add("baima");
    list.add("java");
    System.out.println("集合当中的元素个数有:" +  _________);
    System.out.println("获取集合中的元素heima:" +  _________);
    System.out.println("删除集合中的元素php:" +  _________);
}
```

A:   ①list.size(5) ②list.get(1) ③list.remove(0)

B:   ①list.length() ②list.get(2) ③list.remove(0)

C:   ①list.size() ②list.get(2) ③list.remove(0)

D:   ①list.size() ②list.get(3) ③list.remove(1)



##### 5.下列代码的运行结果是（   ）

```java
public static void main(String[] args){
    ArrayList<String> list = new ArrayList<>();
    list.add("PHP");
    list.add("Android");
    list.add("iOS");
    list.add("Java");
    ArrayList<String> newList = method(list);
    System.out.println(newList);
}
public static ArrayList<String> method(ArrayList<String> list){
    ArrayList<String> array = new ArrayList<>();
    for(int i=0;i<list.size();i++){
        String str = list.get(i);
        if(str.equals("Java")){
            array.add("得Java者，得天下~");
        }
    }
    return array;
}
```



A:   	[PHP，Android，iOS，Java] 

B:   	[得Java者，得天下~] 

C: 	  [PHP，Android，iOS，Java，得Java者，得天下~] 

D:  	[PHP，Android，iOS，得Java者，得天下~] 



##### 6.下列代码的运行结果是（  ）

```java
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList();
    list.add(100);
    list.add(200);
    list.add(300);
    ArrayList<Integer> newList = changeList(list);
    for (int i = 0; i < newList.size(); i++) {
        System.out.print(newList.get(i)+" ");
    }
}

public static ArrayList<Integer> changeList(ArrayList<Integer> arr) {
    for (int i = 0; i < 3; i++) {
        arr.add(666);
    }

    return arr;
}

```

 

A:  100 200 300

B:  666 666 666

C:  100 200 300 666 666 666

D:  666 666 666 100 200 300



##### 7.ArrayList 的初始化内容如下：

```java
ArrayList<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");
list.add("b");
list.add("b");

```

##### 下面可以删除 list 集合中所有的”b”的代码是（）

A:  

```java
for (int i = 0; i < list.size (); i++) { 
    if (list.get (i).equals ("b")){ 
        list.remove (i); 
    } 
}
```

B:  

```java
for (int i = list.size ()-1; i > 0; i--) { 
    if (list.get (i).equals ("b")) { 
        list.remove (i); 
    } 
}
```

C:  

```java
list.remove ("b");
```

D:  

```java
以上的代码都不能成功删除 list 集合中所有的”b”;
```



##### 8.以下代码的打印结果为(    )

```java
public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("123");
    list.add("456");
    list.add("1");
    for(int i = 0;i<list.size();i++) {
        if(list.get(i).length()>1) {
            list.remove(i);
        }
    }
    System.out.println(list);
}
```

A： [123,456, 1]

B： [456]

C： [1]

D： [456, 1]

##### 9.代码如下,完成两个需求：1.求出集合的长度，2.删除集合list中的字符串“orange”。下面选项中代码正确的是（  ）

```java
public static void main(String[] args) {
     ArrayList<String> list = new ArrayList<>();
     list.add("apple");
     list.add("banana");
     list.add("orange"); 
}
```

A：

```java
//1.求出集合的长度
int count = list.size();
//2.删除集合list中的字符串“orange”
list.remove(3); 
```

B：

```java
//1.求出集合的长度
int count = list.size();
//2.删除集合list中的字符串“orange”
list.remove(2); 
```

C：

```java
//1.求出集合的长度
int count = list.length();
//2.删除集合list中的字符串“orange”
list.remove(2); 
```

D：

```java
//1.求出集合的长度
int count = list.length();
//2.删除集合list中的字符串“orange”
list.remove(3); 
```



##### 10.以下代码的打印结果为(    )

```java
public static void main(String[] args) {
    ArrayList<Integer> list =  new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    changeList(list);
    for (int i = 0; i < list.size(); i++) {
        int num = list.get(i);
        System.out.print(num+" ");
    }
}

public static void changeList(ArrayList<Integer> list) {
    for (int i = 0; i < 3; i++) {
        int num = list.get(i);
        num *= 10;
        list.set(i, num);
    }

}
```

A： ArrayList集合不能存储基本类型,编译报错

B： 10 20 30

C： 0 0 0

D： 100 200 300



### 二、编程题

#### 1.需求:

```java
1.设计一个汽车Car类，私有成员变量：brand（品牌），color（颜色），int（价格），并生成相应的get/set方法,空参/满参构造。
2.定义测试类，在main方法中完成以下要求：
2.1创建三个Car对象，分别为” 宝马”，”黑色”，500000；”奔驰”，”红色”，300000； ”奥迪”，”红色”，200000；
2.2将以上3个对象添加到ArrayList集合对象中
2.3遍历集合，将颜色为“红色”的汽车按照如下格式打印到控制台上。
    奔驰-红色-300000
    奥迪-红色-200000
```

Car类的内容:

```java
package itheima01;
//设计一个汽车Car类,私有成员变量：brand（品牌）,color（颜色）,int（价格）,并生成相应的get/set方法,空参/满参构造
public class Car {
    private String brand;//品牌
    private String color;//颜色
    private int price;//价格
    public Car() {
    }

    public Car(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

```

测试类的内容:

```java
package itheima01;


import java.util.ArrayList;
import java.util.Collections;

/*
    需求:
        1.设计一个汽车Car类,私有成员变量：brand（品牌）,color（颜色）,int（价格）,并生成相应的get/set方法,空参/满参构造。
        2.定义测试类,在main方法中完成以下要求：
        2.1创建三个Car对象,分别为"宝马","黑色",500000；"奔驰","红色",300000； "奥迪","红色",200000；
        2.2将以上3个对象添加到ArrayList集合对象中
        2.3遍历集合,将颜色为"红色"的汽车按照如下格式打印到控制台上。
            奔驰-红色-300000
            奥迪-红色-200000

        
 */
public class Test01 {
    public static void main(String[] args) {
        //2.1创建三个Car对象,分别为"宝马","黑色",500000；"奔驰","红色",300000； "奥迪","红色",200000；
        Car c1 = new Car("宝马", "黑色", 500000);
        Car c2 = new Car("奔驰", "红色", 300000);
        Car c3 = new Car("奥迪", "红色", 200000);

        //2.2将以上3个对象添加到ArrayList集合对象中
        //创建ArrayList集合对象list,存储数据类型Car
        ArrayList<Car> list = new ArrayList<>();

        list.add(c1);
        list.add(c2);
        list.add(c3);

        //2.3遍历集合,将颜色为"红色"的汽车按照如下格式打印到控制台上。
        for (int i = 0; i < list.size(); i++) {
            //获取当前对象
            Car car = list.get(i);
            if ("红色".equals(car.getColor())) {
                System.out.println(car.getBrand() + "-" + car.getColor() + "-" + car.getPrice());
            }
        }
    }
}
```



#### 2.需求:

```java
1.定义一个 Person 类
    (1)属性:
		编号 id ( int 类型 )
    	姓名 name（String 类型）
    	性别 sex （String 类型）
    (2)要求:
		成员变量private修饰
   	 	生成空参构造/满参构造
    	生成set/get方法
2. 在测试类中创建 6 个对象（对象数据如下），依次将 Person 对象存入ArrayList集合对象中。
	1,"尼古拉斯","男"
    2,"马尔扎哈","男"
    3,"迪丽热巴","女"
    4,"阿凡提买买提","男"
    5,"王宝强","男"
    6,"柳岩","女"
3. 遍历集合删除其中性别为男且姓名长度大于等于 3 的元素，将剩余的元素数据打印在控制台。
  	打印如下:
	id:3    性别:女    姓名:迪丽热巴
   	id:6    性别:女    姓名:柳岩
```

Person类的内容:

```java
package itheima02;
/*
    1.定义一个 Person 类
            (1)属性:
                编号 id ( int 类型 )
                姓名 name（String 类型）
                性别 sex （String 类型）
            (2)要求:
                成员变量private修饰
                生成空参构造/满参构造
                生成set/get方法
 */
public class Person {
    private int id;
    private String name;
    private String sex;

    public Person() {
    }

    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

```

测试类的内容:

```java
package itheima02;

import java.util.ArrayList;

/*
    需求:
        1.定义一个 Person 类
            (1)属性:
                编号 id ( int 类型 )
                姓名 name（String 类型）
                性别 sex （String 类型）
            (2)要求:
                成员变量private修饰
                生成空参构造/满参构造
                生成set/get方法
        2. 在测试类中创建 6 个对象（对象数据如下），依次将 Person 对象存入ArrayList集合对象中。
            1,"尼古拉斯","男"
            2,"马尔扎哈","男"
            3,"迪丽热巴","女"
            4,"阿凡提买买提","男"
            5,"王宝强","男"
            6,"柳岩","女"
        3. 遍历集合删除其中性别为男且姓名长度大于等于 3 的元素，将剩余的元素数据打印在控制台。
            打印如下:
            id:3    性别:女    姓名:迪丽热巴
            id:6    性别:女    姓名:柳岩
 */
public class Test02 {
    public static void main(String[] args) {
        //2. 在测试类中创建 6 个对象（对象数据如下），依次将 Person 对象存入ArrayList集合对象中。
        Person p1 = new Person(1, "尼古拉斯", "男");
        Person p2 = new Person(2, "马尔扎哈", "男");
        Person p3 = new Person(3, "迪丽热巴", "女");
        Person p4 = new Person(4, "阿凡提买买提", "男");
        Person p5 = new Person(5, "王宝强", "男");
        Person p6 = new Person(6, "柳岩", "女");

        //创建ArrayList集合对象list,存储数据类型Person
        ArrayList<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        //3. 遍历集合删除其中性别为男且姓名长度大于等于 3 的元素，将剩余的元素数据打印在控制台。
        for (int i = 0; i < list.size(); i++) {
            //获取当前对象
            Person p = list.get(i);
            //获取性别和姓名
            String name = p.getName();
            String sex = p.getSex();
            if (("男".equals(sex)) && (name.length() >= 3)) {
                list.remove(i--);//如果倒过来遍历,则不用写--
            }
        }

        //4.打印删除元素后的集合内容
        for (int i = 0; i < list.size(); i++) {
            //获取当前对象
            Person p = list.get(i);
            //获取性别和姓名
            String name = p.getName();
            String sex = p.getSex();
            int id = p.getId();
            System.out.println("id:" + id + "    性别:" + sex + "    姓名:" + name);
        }
    }
}
```





#### 3.需求:

```java
1.定义"程序员"类,Coder,包含以下成员:
    1.1成员属性:
    	name (姓名):String类型，
        age (年龄):int类型，
        like (爱好):String类型

    1.2要求:
		成员变量private修饰
    	生成空参构造/满参构造
    	生成set/get方法
        
2.定义类Test,类中定义main()⽅法，按以下要求编写代码:
    2.1分别创建四个Coder对象，四个对象的属性分别为：
        "王宝强" ,25,”打篮球”、
        "汪峰" ,35,”游泳”、
        "李铁" ,19,”踢足球”、
        "姚明" ,18,”击剑”;
    2.2创建一个ArrayList集合，这个集合里面存储的是Coder类型，分别将上面的四个Coder对象添加到集合中 
    2.3遍历这个集合，在遍历的过程中，如果集合中对象的年龄大于30，那么将这个对象的爱好改成”打保龄球”，
        如果对象的年龄小于20， 那么就把这个对象删除。
    2.4正确修改和删除对象后，遍历集合，打印集合里所有对象的所有属性信息到控制台。
    2.5输出格式:
		王宝强----25----打篮球
		汪峰----35----打保龄球
```

Coder类的内容:

```java
package itheima03;
/*
     1.定义"程序员"类,Coder,包含以下成员:
        1.1成员属性:
            name (姓名):String类型，
            age (年龄):int类型，
            like (爱好):String类型

        1.2要求:
            成员变量private修饰
            生成空参构造/满参构造
            生成set/get方法
 */
public class Coder {
    private String name;
    private int age;
    private String like;

    public Coder() {
    }

    public Coder(String name, int age, String like) {
        this.name = name;
        this.age = age;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}

```

测试类的内容:

```java
package itheima03;

import java.util.ArrayList;
import java.util.Scanner;

/*
    需求:
        1.定义"程序员"类,Coder,包含以下成员:
            1.1成员属性:
                name (姓名):String类型，
                age (年龄):int类型，
                like (爱好):String类型

            1.2要求:
                成员变量private修饰
                生成空参构造/满参构造
                生成set/get方法

        2.定义类Test,类中定义main()⽅法，按以下要求编写代码:
            2.1分别创建四个Coder对象，四个对象的属性分别为：
                "王宝强" ,25,"打篮球"
                "汪峰" ,35,"游泳"
                "李铁" ,19,"踢足球"
                "姚明" ,18,"击剑"
            2.2创建一个ArrayList集合，这个集合里面存储的是Coder类型，分别将上面的四个Coder对象添加到集合中
            2.3遍历这个集合，在遍历的过程中，如果集合中对象的年龄大于30，那么将这个对象的爱好改成"打保龄球"，
                如果对象的年龄小于20， 那么就把这个对象删除。
            2.4正确修改和删除对象后，遍历集合，打印集合里所有对象的所有属性信息到控制台。
            2.5输出格式:
                王宝强----25----打篮球
                汪峰----35----打保龄球
 */
public class Test03 {
    public static void main(String[] args) {
        //2.1分别创建四个Coder对象，四个对象的属性分别为：
        Coder c1 = new Coder("王宝强", 25, "打篮球");
        Coder c2 = new Coder("汪峰", 35, "游泳");
        Coder c3 = new Coder("李铁", 19, "踢足球");
        Coder c4 = new Coder("姚明", 18, "击剑");

        //2.2创建一个ArrayList集合，这个集合里面存储的是Coder类型，分别将上面的四个Coder对象添加到集合中
        ArrayList<Coder> list = new ArrayList<>();

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        //2.3遍历这个集合，在遍历的过程中，
        for (int i = 0; i < list.size(); i++) {
            //获取当前对象
            Coder coder = list.get(i);
            //如果对象的年龄大于30,把爱好改成"打保龄球"
            if (coder.getAge() > 30) {
                coder.setLike("打保龄球");
            }
            //如果对象的年龄小于20
            if (coder.getAge() < 20) {
                //把这个对象删除
                list.remove(i--);//有可能出现多个连续的年龄 小于 20的需要删除,所以要i--,如果倒着遍历则不需要i--
            }
        }

        //2.4正确修改和删除对象后，遍历集合，打印集合里所有对象的所有属性信息到控制台。
        for (int i = 0; i < list.size(); i++) {
            //获取当前对象
            Coder coder = list.get(i);
            System.out.println(coder.getName() + "----" + coder.getAge() + "----" + coder.getLike());
        }
    }
}
```

