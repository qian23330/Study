```java
1.下列语句序列执行后，x 的值是(D)
int a=3, b=4, x=5;
if(a<b){
 	x=x+1;
}
```

 

|      | `A: 5 ` |
| ---- | ------- |
|      | `B: 3`  |
|      | `C: 4`  |
|      | `D: 6`  |



```java
2.下列语句序列执行后，ch的值是( C )。
int a = 10;
int b = 20;
char ch = 'A';
if(a < b) {
    ch='C';
}
```

 

|      | `A: ‘A’` |
| ---- | -------- |
|      | `B: ‘B’` |
|      | `C: ‘C’` |
|      | `D: 'D'` |



```java
3.下列语句序列执行后，b 的值是(B)。
int a=2, b=4;
if( a < b){
 	a *= 2;
}
```

 

|      | `A: 5 ` |
| ---- | ------- |
|      | `B: 4`  |
|      | `C: 8`  |
|      | `D: 10` |





```java
4.以下一段代码执行完毕后y的值是（A）。 
int x = 11; 
int y = 0; 
if(x>5){
	y = x + 5; 
} else {
	y = x – 5; 
}  
```

 

|      | `A: 16` |
| ---- | ------- |
|      | `B: 6`  |
|      | `C: 11` |
|      | `D: 0`  |



```java
5.下列语句序列执行后，m 的值是(B)。
int a=10, b=3, m=5;
if( a==b ) {
	m+=a;
}else{
	m*=a;
}
```

 

|      | `A: 15 ` |
| ---- | -------- |
|      | `B: 50`  |
|      | `C: 55 ` |
|      | `D: 5`   |



6.下列语句序列执行后，i 的值是(  D ) 

```java
int i=8, j=16;   
if( i > j ){
	i--; 
} else{
  	j--; 
}  
```

 

|      | `A: 15` |
| ---- | ------- |
|      | `B: 16` |
|      | `C: 7`  |
|      | `D: 8`  |

7.下列程序的运行结果是 ？ D

```java
public static void main(String [] args){
	int i = 1;
	while(i <= 10){
		i++;
        System.out.println("HelloWorld");
	}
}
```

 

|      | `A: 输出1次HelloWorld`  |
| ---- | ----------------------- |
|      | `B: 输出2次HelloWorld`  |
|      | `C: 输出9次HelloWorld`  |
|      | `D: 输出10次HelloWorld` |



8.下列程序的运行结果是 ？ D

```java
public static void main(String [] args){
	int i = 1;
	while(i <= 10){
		i++;
        if(i % 2 == 0) {
           System.out.println("HelloWorld"); 
        }
	}
}
```

 

|      | `A: 输出1次HelloWorld` |
| ---- | ---------------------- |
|      | `B: 输出2次HelloWorld` |
|      | `C: 输出4次HelloWorld` |
|      | `D: 输出5次HelloWorld` |



9.下列程序的运行结果是 ？ D

```java
public static void main(String [] args){
    int sum = 0;
	int i = 1;
	while(i <= 5){
        sum += i;  // 1 2 3 4 5
		i++;
	}
    System.out.println(sum);
}
```

 

|      | `A: 1`  |
| ---- | ------- |
|      | `B: 5`  |
|      | `C: 10` |
|      | `D: 15` |



10.下列程序的运行结果是 ？ D

```java
public static void main(String [] args){
    int sum = 0;
	int i = 1;
	while(i <= 5){
        if(i % 2 == 1) {
            sum += i;
        }
        i++;
	}
    System.out.println(sum);
}
```

 

|      | `A: 1` |
| ---- | ------ |
|      | `B: 3` |
|      | `C: 6` |
|      | `D: 9` |



11.下列程序运行结果是 ？ B

```java
public static void main(String[] args) {
    int i = 1;
    do {
        System.out.println("HelloWorld");
        i++;
    } while(i < 0);
}
```

 

|      | `A: 没有任何输出`       |
| ---- | ----------------------- |
|      | `B: 输出1次HelloWorld`  |
|      | `C: 输出5次HelloWorld`  |
|      | `D: 输出10次HelloWorld` |



12.下列程序会输出几次HelloWorld    C

```java
public static void main(String[] args) {
    for(int i = 1; i <= 10; i++) {
        System.out.println("HelloWorld");
    }
}
```

 

|      | `A: 1`  |
| ---- | ------- |
|      | `B: 2`  |
|      | `C: 10` |
|      | `D: 11` |



13.下列程序的输出结果是  D

```java
public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 5; i++) {
        sum += i;
    }
    System.out.println(sum);
}
```

 

|      | `A: 1`  |
| ---- | ------- |
|      | `B: 5`  |
|      | `C: 10` |
|      | `D: 15` |



14.下列程序的运行的结果是  C

```java
public static void main(String[] args) {
    int num = 10;
    for (int i = 0; i < 3; i++) {
        // i 0  1   2 
        num--;
    }
    System.out.print(num);
}
```

 

|      | `A: 1`  |
| ---- | ------- |
|      | `B: 3`  |
|      | `C: 7`  |
|      | `D: 10` |



15.下面程序的运行结果是  C

```java
public static void main(String[] args) {
	int sum = 0;
	for(int i = 1;i <= 5;i++) {
        if (i % 2 == 0) {
            sum += i;
        }
    }
    System.out.println(sum);
}
```

 

|      | `A: 0`  |
| ---- | ------- |
|      | `B: 2`  |
|      | `C: 6`  |
|      | `D: 15` |



16.下面程序的运行结果是   B

```java
public static void main(String[] args) {
    int count = 0;
    for (int i = 1; i <= 10; i++) {
        // 3 6 9
        if(i % 3 == 0) {
            count++;
        }
    }
    System.out.println(count);
}
```

 

|      | `A: 1`  |
| ---- | ------- |
|      | `B: 3`  |
|      | `C: 6`  |
|      | `D: 10` |