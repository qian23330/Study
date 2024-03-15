# 力扣-高频SQL题50道-基础版
use leetcode;


# 1757. 可回收且低脂的产品
Create table If Not Exists Products
(
    product_id int,
    low_fats   ENUM ('Y', 'N'),
    recyclable ENUM ('Y','N')
);
Truncate table Products;
insert into Products (product_id, low_fats, recyclable)
values ('0', 'Y', 'N');
insert into Products (product_id, low_fats, recyclable)
values ('1', 'Y', 'Y');
insert into Products (product_id, low_fats, recyclable)
values ('2', 'N', 'Y');
insert into Products (product_id, low_fats, recyclable)
values ('3', 'Y', 'Y');
insert into Products (product_id, low_fats, recyclable)
values ('4', 'N', 'N');

select product_id
from Products
where low_fats = 'Y'
  and recyclable = 'Y';


# 584. 寻找用户推荐人
Create table If Not Exists Customer
(
    id         int,
    name       varchar(25),
    referee_id int
);
Truncate table Customer;
insert into Customer (id, name, referee_id)
values ('1', 'Will', NULL);
insert into Customer (id, name, referee_id)
values ('2', 'Jane', NULL);
insert into Customer (id, name, referee_id)
values ('3', 'Alex', '2');
insert into Customer (id, name, referee_id)
values ('4', 'Bill', NULL);
insert into Customer (id, name, referee_id)
values ('5', 'Zack', '1');
insert into Customer (id, name, referee_id)
values ('6', 'Mark', '2');

select name
from Customer
where referee_id != 2
   or referee_id is null;


# 595. 大的国家
Create table If Not Exists World
(
    name       varchar(255),
    continent  varchar(255),
    area       int,
    population int,
    gdp        bigint
);
Truncate table World;
insert into World (name, continent, area, population, gdp)
values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000');
insert into World (name, continent, area, population, gdp)
values ('Albania', 'Europe', '28748', '2831741', '12960000000');
insert into World (name, continent, area, population, gdp)
values ('Algeria', 'Africa', '2381741', '37100000', '188681000000');
insert into World (name, continent, area, population, gdp)
values ('Andorra', 'Europe', '468', '78115', '3712000000');
insert into World (name, continent, area, population, gdp)
values ('Angola', 'Africa', '1246700', '20609294', '100990000000');

select name, population, area
from World
where area >= 3000000
   or population >= 25000000;


# 1148. 文章浏览 I
Create table If Not Exists Views
(
    article_id int,
    author_id  int,
    viewer_id  int,
    view_date  date
);
Truncate table Views;
insert into Views (article_id, author_id, viewer_id, view_date)
values ('1', '3', '5', '2019-08-01');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('1', '3', '6', '2019-08-02');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('2', '7', '7', '2019-08-01');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('2', '7', '6', '2019-08-02');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('4', '7', '1', '2019-07-22');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('3', '4', '4', '2019-07-21');
insert into Views (article_id, author_id, viewer_id, view_date)
values ('3', '4', '4', '2019-07-21');

select distinct author_id as id
from Views
where author_id = viewer_id
order by author_id;


# 1683. 无效的推文
Create table If Not Exists Tweets
(
    tweet_id int,
    content  varchar(50)
);
Truncate table Tweets;
insert into Tweets (tweet_id, content)
values ('1', 'Vote for Biden');
insert into Tweets (tweet_id, content)
values ('2', 'Let us make America great again!');

select tweet_id
from Tweets
where char_length(content) > 15;

# 1378. 使用唯一标识码替换员工ID
Create table If Not Exists Employees
(
    id   int,
    name varchar(20)
);
Create table If Not Exists EmployeeUNI
(
    id        int,
    unique_id int
);
Truncate table Employees;
insert into Employees (id, name)
values ('1', 'Alice');
insert into Employees (id, name)
values ('7', 'Bob');
insert into Employees (id, name)
values ('11', 'Meir');
insert into Employees (id, name)
values ('90', 'Winston');
insert into Employees (id, name)
values ('3', 'Jonathan');
Truncate table EmployeeUNI;
insert into EmployeeUNI (id, unique_id)
values ('3', '1');
insert into EmployeeUNI (id, unique_id)
values ('11', '2');
insert into EmployeeUNI (id, unique_id)
values ('90', '3');

select EmployeeUNI.unique_id, Employees.name
from Employees
         left join EmployeeUNI on Employees.id = EmployeeUNI.id;


# 1068. 产品销售分析 I
Create table If Not Exists Sales
(
    sale_id    int,
    product_id int,
    year       int,
    quantity   int,
    price      int
);
Create table If Not Exists Product
(
    product_id   int,
    product_name varchar(10)
);
Truncate table Sales;
insert into Sales (sale_id, product_id, year, quantity, price)
values ('1', '100', '2008', '10', '5000');
insert into Sales (sale_id, product_id, year, quantity, price)
values ('2', '100', '2009', '12', '5000');
insert into Sales (sale_id, product_id, year, quantity, price)
values ('7', '200', '2011', '15', '9000');
Truncate table Product;
insert into Product (product_id, product_name)
values ('100', 'Nokia');
insert into Product (product_id, product_name)
values ('200', 'Apple');
insert into Product (product_id, product_name)
values ('300', 'Samsung');

select product_name, year, price
from Sales
         left join Product on Product.product_id = Sales.product_id;


# 1581. 进店却未进行过交易的顾客
Create table If Not Exists Visits
(
    visit_id    int,
    customer_id int
);
Create table If Not Exists Transactions
(
    transaction_id int,
    visit_id       int,
    amount         int
);
Truncate table Visits;
insert into Visits (visit_id, customer_id)
values ('1', '23');
insert into Visits (visit_id, customer_id)
values ('2', '9');
insert into Visits (visit_id, customer_id)
values ('4', '30');
insert into Visits (visit_id, customer_id)
values ('5', '54');
insert into Visits (visit_id, customer_id)
values ('6', '96');
insert into Visits (visit_id, customer_id)
values ('7', '54');
insert into Visits (visit_id, customer_id)
values ('8', '54');
Truncate table Transactions;
insert into Transactions (transaction_id, visit_id, amount)
values ('2', '5', '310');
insert into Transactions (transaction_id, visit_id, amount)
values ('3', '5', '300');
insert into Transactions (transaction_id, visit_id, amount)
values ('9', '5', '200');
insert into Transactions (transaction_id, visit_id, amount)
values ('12', '1', '910');
insert into Transactions (transaction_id, visit_id, amount)
values ('13', '2', '970');

select v.customer_id, count(*) as count_no_trans
from Visits as v
         left join Transactions as t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id;


# 197. 上升的温度
Create table If Not Exists Weather
(
    id          int,
    recordDate  date,
    temperature int
);
Truncate table Weather;
insert into Weather (id, recordDate, temperature)
values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature)
values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature)
values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature)
values ('4', '2015-01-04', '30');

select w1.id
from Weather w1
         join Weather w2 on datediff(w1.recordDate, w2.recordDate) = 1
where w1.temperature > w2.temperature;


# 1661. 每台机器的进程平均运行时间
Create table If Not Exists Activity
(
    machine_id    int,
    process_id    int,
    activity_type ENUM ('start', 'end'),
    timestamp     float
);
Truncate table Activity;
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('0', '0', 'start', '0.712');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('0', '0', 'end', '1.52');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('0', '1', 'start', '3.14');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('0', '1', 'end', '4.12');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('1', '0', 'start', '0.55');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('1', '0', 'end', '1.55');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('1', '1', 'start', '0.43');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('1', '1', 'end', '1.42');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('2', '0', 'start', '4.1');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('2', '0', 'end', '4.512');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('2', '1', 'start', '2.5');
insert into Activity (machine_id, process_id, activity_type, timestamp)
values ('2', '1', 'end', '5');

select a1.machine_id, round(avg(a2.timestamp - a1.timestamp), 3) as processing_time
from Activity as a1
         join Activity as a2
              on a1.machine_id = a2.machine_id and a1.process_id = a2.process_id and a1.activity_type = 'start' and
                 a2.activity_type = 'end'
group by a1.machine_id;


# 577. 员工奖金
Create table If Not Exists Employee
(
    empId      int,
    name       varchar(255),
    supervisor int,
    salary     int
);
Create table If Not Exists Bonus
(
    empId int,
    bonus int
);
Truncate table Employee;
insert into Employee (empId, name, supervisor, salary)
values ('3', 'Brad', NULL, '4000');
insert into Employee (empId, name, supervisor, salary)
values ('1', 'John', '3', '1000');
insert into Employee (empId, name, supervisor, salary)
values ('2', 'Dan', '3', '2000');
insert into Employee (empId, name, supervisor, salary)
values ('4', 'Thomas', '3', '4000');
Truncate table Bonus;
insert into Bonus (empId, bonus)
values ('2', '500');
insert into Bonus (empId, bonus)
values ('4', '2000');

select name, bonus
from Employee
         left join Bonus on Employee.empId = Bonus.empId
where bonus is null
   or bonus < 1000;


# 1280. 学生们参加各科测试的次数
Create table If Not Exists Students
(
    student_id   int,
    student_name varchar(20)
);
Create table If Not Exists Subjects
(
    subject_name varchar(20)
);
Create table If Not Exists Examinations
(
    student_id   int,
    subject_name varchar(20)
);
Truncate table Students;
insert into Students (student_id, student_name)
values ('1', 'Alice');
insert into Students (student_id, student_name)
values ('2', 'Bob');
insert into Students (student_id, student_name)
values ('13', 'John');
insert into Students (student_id, student_name)
values ('6', 'Alex');
Truncate table Subjects;
insert into Subjects (subject_name)
values ('Math');
insert into Subjects (subject_name)
values ('Physics');
insert into Subjects (subject_name)
values ('Programming');
Truncate table Examinations;
insert into Examinations (student_id, subject_name)
values ('1', 'Math');
insert into Examinations (student_id, subject_name)
values ('1', 'Physics');
insert into Examinations (student_id, subject_name)
values ('1', 'Programming');
insert into Examinations (student_id, subject_name)
values ('2', 'Programming');
insert into Examinations (student_id, subject_name)
values ('1', 'Physics');
insert into Examinations (student_id, subject_name)
values ('1', 'Math');
insert into Examinations (student_id, subject_name)
values ('13', 'Math');
insert into Examinations (student_id, subject_name)
values ('13', 'Programming');
insert into Examinations (student_id, subject_name)
values ('13', 'Physics');
insert into Examinations (student_id, subject_name)
values ('2', 'Math');
insert into Examinations (student_id, subject_name)
values ('1', 'Math');

select s.student_id, s.student_name, sub.subject_name, IFNULL(grouped.attended_exams, 0) AS attended_exams
from Students s
         cross join Subjects sub
         left join (select student_id, subject_name, count(*) as attended_exams
                    from Examinations
                    group by student_id, subject_name) grouped
                   on s.student_id = grouped.student_id and sub.subject_name = grouped.subject_name
order by s.student_id, sub.subject_name;


# 570. 至少有5名直接下属的经理
Create table If Not Exists Employee
(
    id         int,
    name       varchar(255),
    department varchar(255),
    managerId  int
);
Truncate table Employee;
insert into Employee (id, name, department, managerId)
values ('101', 'John', 'A', NULL);
insert into Employee (id, name, department, managerId)
values ('102', 'Dan', 'A', '101');
insert into Employee (id, name, department, managerId)
values ('103', 'James', 'A', '101');
insert into Employee (id, name, department, managerId)
values ('104', 'Amy', 'A', '101');
insert into Employee (id, name, department, managerId)
values ('105', 'Anne', 'A', '101');
insert into Employee (id, name, department, managerId)
values ('106', 'Ron', 'B', '101');

select Manager.name as name
from Employee as Manager
         join Employee as Report on Manager.id = Report.managerId
group by Manager.id, Manager.name
having count(Report.id) >= 5;


# 1934. 确认率
Create table If Not Exists Signups
(
    user_id    int,
    time_stamp datetime
);
Create table If Not Exists Confirmations
(
    user_id    int,
    time_stamp datetime,
    action     ENUM ('confirmed','timeout')
);
Truncate table Signups;
insert into Signups (user_id, time_stamp)
values ('3', '2020-03-21 10:16:13');
insert into Signups (user_id, time_stamp)
values ('7', '2020-01-04 13:57:59');
insert into Signups (user_id, time_stamp)
values ('2', '2020-07-29 23:09:44');
insert into Signups (user_id, time_stamp)
values ('6', '2020-12-09 10:39:37');
Truncate table Confirmations;
insert into Confirmations (user_id, time_stamp, action)
values ('3', '2021-01-06 03:30:46', 'timeout');
insert into Confirmations (user_id, time_stamp, action)
values ('3', '2021-07-14 14:00:00', 'timeout');
insert into Confirmations (user_id, time_stamp, action)
values ('7', '2021-06-12 11:57:29', 'confirmed');
insert into Confirmations (user_id, time_stamp, action)
values ('7', '2021-06-13 12:58:28', 'confirmed');
insert into Confirmations (user_id, time_stamp, action)
values ('7', '2021-06-14 13:59:27', 'confirmed');
insert into Confirmations (user_id, time_stamp, action)
values ('2', '2021-01-22 00:00:00', 'confirmed');
insert into Confirmations (user_id, time_stamp, action)
values ('2', '2021-02-28 23:59:59', 'timeout');

select s.user_id, round(ifnull(avg(c.action = 'confirmed'), 0), 2) as confirmation_rate
from Signups as s
         left join Confirmations as c on s.user_id = c.user_id
group by s.user_id;


# 620. 有趣的电影
Create table If Not Exists cinema
(
    id          int,
    movie       varchar(255),
    description varchar(255),
    rating      float(2, 1)
);
Truncate table cinema;
insert into cinema (id, movie, description, rating)
values ('1', 'War', 'great 3D', '8.9');
insert into cinema (id, movie, description, rating)
values ('2', 'Science', 'fiction', '8.5');
insert into cinema (id, movie, description, rating)
values ('3', 'irish', 'boring', '6.2');
insert into cinema (id, movie, description, rating)
values ('4', 'Ice song', 'Fantacy', '8.6');
insert into cinema (id, movie, description, rating)
values ('5', 'House card', 'Interesting', '9.1');

select *
from cinema
where description != 'boring'
  and mod(id, 2) = 1
order by rating desc;