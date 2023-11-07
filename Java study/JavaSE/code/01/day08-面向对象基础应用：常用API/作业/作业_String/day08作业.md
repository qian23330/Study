### 一、选择题

##### 1.观察下列代码，求最终结果（）

```java
String str1 = "Abc";
if(str1.equals("abc")){
  System.out.println("爱Java,爱生活~");
} else {
    System.out.println("爱生活,爱Java~");
}
```

A：什么也没有输出

B：爱Java,爱生活~

C：爱生活,爱Java~

D：运行报错

##### 2.观察下列代码，选出标号1和2的正确答案（）【多选题】

```java
char[] chs = {'h','e','l','l','o'};
String s1 = new String(chs);
String s2 = new String(chs);
String s3 = "hello";
String s4 = "hello";
//1
System.out.println((s1==s2)+","+(s1==s3)+","+(s3==s4));
//2
System.out.println((s1.equals(s2))+","+(s1.equals(s3))+","+(s3.equals(s4)));
```

A：fase,fase,true

B：false,false,false

C：true,true,true

D：true,true,false



##### 3.观察下列代码，选出标号1和2的正确答案（）【多选题】

```java
public static void main(String[] args) {
    String s1 = "abc";
    String s2 = "abc";
    String s3 = "ABC";
    String s4 = "a";
    String s5 = s4 + "bc";
    String s6 = "a" + "bc";
    //1
    System.out.println(s1.equals(s2)+" "+s1.equalsIgnoreCase(s3)+" "+s2.equals(s5)+" "+s3.equalsIgnoreCase(s5));
    //2
    System.out.println((s1==s2)+" "+(s1==s3)+" "+(s2==s5)+" "+(s2==s6));
    
}
```

A:  true false true true 

B:  true false false true 

C:  true true true true 

D:  true true true false 



##### 4.以下哪个选项可以获取字符串对象的长度（）

A：public int length

B：public int length(){ ... }

C：public int size(){ ... }

D：public char charAt(int index){ ... }



##### 5.以下代码反转字符串逻辑正确的是（ ）

A:

```java
String s = "12345";
for (int i = s.length(); i >= 0; i--) {
	s+= s.charAt(i);
}
System.out.println(s);
```

B:

```java
String s = "12345";
for (int i = s.length()-1; i >= 0; i--) {
	s+= s.charAt(i);
}
System.out.println(s);
```

C:

```java
String s = "12345";
String s2 = "";
for (int i = s.length()-1; i >= 0; i--) {
	s2+= s.charAt(i);
}
s = s2;
System.out.println(s);
```

D:

```java
String s = "12345";
String s2 = "";
for (int i = 0; i < s.length(); i++) {
	s2+= s.charAt(i);
}
s = s2;
System.out.println(s);
```



##### 6.下面关于 String 的描述不正确的是（）【多选题】

A、equals()方法比较的是两个字符串的内容

B.、equals()方法比较的是两个字符串的地址和内容

C、charAt()返回的是指定的索引处的 char 值

D、length 属性代表的是字符串的长度



### 二、编程题

#### 1:需求	

```java
请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。

例如："abcba"、"上海自来水来自海上"均为对称字符串。

```

```java
/*
    需求:
        请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。
        例如："abcba"、"上海自来水来自海上"均为对称字符串。

    课堂上讲过了
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(duiChen("上海自来水来自海上"));
        System.out.println(duiChen("abcdcba"));
        System.out.println(duiChen("123"));

        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'0');
        System.out.println((int)'9');
    }

    public static boolean duiChen(String s) {
        //根据参数字符串对象s创建一个新的StringBuilder对象sb
        StringBuilder sb = new StringBuilder(s);
        //把StringBuilder对象中的内容反转
        sb.reverse();
        //把StringBuilder对象中的内容再转换成一个新的字符串
        String newStr = sb.toString();
        //如果是对称字符串,反转前后是一样的自然返回true
        //如果不是对称字符串,反转前后不一样的,自然返回false
        return newStr.equals(s);
    }
}
```

#### 2:需求

```java
请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。
比如：Hello12345World中字母：10个，数字：5个。
```

```java
import java.util.Scanner;

/*
    需求:
        请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。
        比如：Hello12345World中字母：10个，数字：5个。

    实现步骤:
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的字符串,保存String变量str中
        3.定义两个int变量count1和count2,初始值0,分别用来统计字母和数字的数量
        4.遍历字符串(方式一: for + charAt(索引) 方式二: toCharArray() + for遍历数组)
        4.1 获取当前字符保存char变量ch中
        4.2 判断char变量ch中如果是字母,计数器count1的值增加1
        4.3 判断char变量ch中如果是数字,计数器count2的值增加1
        5.for循环结束后,输出count1和count2的值
 */
public class Test02 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的字符串,保存String变量str中
        System.out.println("请输入一个字符串: ");
        String str = sc.nextLine();
        //3.定义两个int变量count1和count2,初始值0,分别用来统计字母和数字的数量
        int count1 = 0, count2 = 0;
        //4.遍历字符串(方式一: for + charAt(索引) 方式二: toCharArray() + for遍历数组)
        for (int i = 0; i < str.length(); i++) {
            //4.1 获取当前字符保存char变量ch中
            char ch = str.charAt(i);
            //4.2 判断char变量ch中如果是字母,计数器count1的值增加1
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                count1++;
            } else if (ch >= '0' && ch <= '9') {
                //4.3 判断char变量ch中如果是数字,计数器count2的值增加1
                count2++;
            }
        }
        //5.for循环结束后,输出count1和count2的值
        System.out.println("字符串: " + str + "中有" + count1 + "个字母");
        System.out.println("字符串: " + str + "中有" + count2 + "个数字");
    }
}
```



#### 3:需求

```java
请编写程序，由键盘录入一个字符串，把字符串中的所有字母都变成大写后输出,再把字符串中的所有字母变成小写后输出。
比如：
    键盘录入字符串:Hello12345World~!#$
    控制台输出:
		转换后的大写字符串: HELLO12345WORLD~!#$
        转换后的小写字符串: hello12345world~!#$
要求:
	1.定义方法myToUpperCase,完成把方法参数字符串转换成大写字符串并返回转换后的结果
    2.定义方法myToLowerCase,完成把方法参数字符串转换成小写字符串并返回转换后的结果
    3.获取键盘录入的字符串后,分别调用以上两个方法,获取结果字符串并输出
    
```

```java
import java.util.ArrayList;
import java.util.Scanner;

/*
    需求:
        请编写程序，由键盘录入一个字符串，把字符串中的所有字母都变成大写后输出,再把字符串中的所有字母变成小写后输出。

    比如：
        键盘录入字符串:Hello12345World~!#$
        控制台输出:
            转换后的大写字符串: HELLO12345WORLD~!#$
            转换后的小写字符串: hello12345world~!#$
    要求:
        1.定义方法myToUpperCase,完成把方法参数字符串转换成大写字符串并返回转换后的结果
        2.定义方法myToLowerCase,完成把方法参数字符串转换成小写字符串并返回转换后的结果
        3.获取键盘录入的字符串后,分别调用以上两个方法,获取结果字符串并输出


 */
public class Test03 {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的字符串,保存String变量str中
        System.out.println("请输入一个字符串: ");
        String str = sc.nextLine();
        //调用方法,把字符串str转换成大写并输出
        System.out.println(myToUpperCase(str));
        //调用方法,把字符串str转换成小写并输出
        System.out.println(myToLowerCase(str));
    }

    /*
        1.定义方法myToUpperCase,完成把方法参数字符串转换成大写字符串并返回转换后的结果
        三要素:
            1.方法名称:     myToUpperCase
            2.参数列表:     String s
            3.返回值类型:   String

        注意:
            只有小写字母才可以转换成大写字母,其它字符一概不管
            小写字母如何转换成对应的大写字母:
                小写字母的ASCII码值 减去 32 就是对应的大写字母的ASCII码值
            //Hello12345World~!#$
        实现步骤:
            1.定义String变量str,初始值"",用来拼接字符串
            2.遍历方法参数字符串
            2.1 获取当前字符,保存char变量ch中
            2.2 判断如果ch中是小写字母,把ch中的小写字母变成大写字母
            2.3 把ch中的字符拼接到str中
            3.for循环结束后,直接返回str
     */
    public static String myToUpperCase(String s) {
        //1.定义String变量str,初始值"",用来拼接字符串
        String str = "";
        //2.遍历方法参数字符串
        for (int i = 0; i < s.length(); i++) {
            //2.1 获取当前字符,保存char变量ch中
            char ch = s.charAt(i);
            //2.2 判断如果ch中是小写字母,把ch中的小写字母变成大写字母
            if (ch >= 'a' && ch <= 'z') {
                //ch -= 32;//等价于: ch = (char)( ch - 32)
                ch = (char) (ch - 32);
            }
            //2.3 把ch中的字符拼接到str中
            str += ch;
        }
        //3.for循环结束后,直接返回str
        return str;
    }
    /*
        1.定义方法myToLowerCase,完成把方法参数字符串转换成小写字符串并返回转换后的结果
        三要素:
            1.方法名称:         myToLowerCase
            2.参数列表:         String s
            3.返回值类型:       String
        注意:
            只有小写字母才可以转换成大写字母,其它字符一概不管
            大写字母如何转换成对应的小写字母:
                大写字母的ASCII码值 加上 32 就是对应的小写字母的ASCII码值

        实现步骤:
            1.定义String变量str,初始值"",用来拼接字符串
            2.遍历方法参数字符串
            2.1 获取当前字符,保存char变量ch中
            2.2 判断如果ch中是大写字母,把ch中的大写字母变成小写字母
            2.3 把ch中的字符拼接到str中
            3.for循环结束后,直接返回str
     */
    public static String myToLowerCase(String s) {
        //1.定义String变量str,初始值"",用来拼接字符串
        String str = "";
        //2.遍历方法参数字符串
        for (int i = 0; i < s.length(); i++) {
            //2.1 获取当前字符,保存char变量ch中
            char ch = s.charAt(i);
            //2.2 判断如果ch中是大写字母,把ch中的大写字母变成小写字母
            if (ch >= 'A' && ch <= 'Z') {
                //ch += 32;//等价于: ch = (char)( ch + 32)
                ch = (char) (ch + 32);
            }
            //2.3 把ch中的字符拼接到str中
            str += ch;
        }
        //3.for循环结束后,直接返回str
        return str;
    }
}

```







