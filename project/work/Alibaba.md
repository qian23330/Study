#### 播放音频得奖励
##### 背景
新上线的音频播放小程序存在着用户黏性低，停留时间短等问题，借助奖励发放的作为利益点，根据用户播放时长发放不同数量的奖励，让用户能够在小程序中停留更长时间，从而提高小程序的用户留存率
##### 需求描述
根据用户播放音频的时长，为用户阶梯发放奖励，发放的规则如下

| 累计播放时长 | 阶段发放奖励数量 | 累计发放奖励数量 |
| --- | --- | --- |
| 160 | 1 | 1 |
| 320 | 1 | 2 |
| 640 | 2 | 4 |
| 960 | 2 | 6 |
| 1280 | 2 | 8 |
| 1600 | 2 | 10 |
| 3200 | 10 | 20 |
| 6400 | 10 | 30 |

##### 业务流程
![](https://cdn.nlark.com/yuque/__puml/9b95980ac0d2bb28f5d6c86df9c1af2a.svg#lake_card_v2=eyJ0eXBlIjoicHVtbCIsImNvZGUiOiJAc3RhcnR1bWxcblxuYXV0b251bWJlclxuXG5hY3RvciBcIueUqOaIt1wiIGFzIFVzZXIgXG5wYXJ0aWNpcGFudCBcIuWuouaIt-err1wiIGFzIGtoZCAjbGlnaHRibHVlXG5wYXJ0aWNpcGFudCBcIuacjeWKoeerr1wiIGFzIHlkICNvcmFuZ2VcbnBhcnRpY2lwYW50IFwi5aWW5Yqx5Y-R5pS-5LiL5ri4XCIgYXMgc2wgI2xpZ2h0Z3JlZW5cbnBhcnRpY2lwYW50IFwi6YWN572u5Lit5b-DXCIgYXMgZHJtICNjeWFuXG5wYXJ0aWNpcGFudCBcIuaVsOaNruW6k1wiIGFzIGRiICNzYWxtb25cblxuYWN0aXZhdGUgVXNlclxuXG5Vc2VyIC0-IGtoZDog5pKt5pS-5LiT6L6R5aOw6Z-zXG5hY3RpdmF0ZSBraGRcblxua2hkIC0-IHlkOiDkuIrmiqXmkq3mlL7ml7bplb9cbmFjdGl2YXRlIHlkXG5cbnlkIC0-IHlkOiDlj4LmlbDmoKHpqoxcbnlkIC0-IGRiOiDlrZjlgqjmkq3mlL7kuIrmiqXmtYHmsLRcbmFjdGl2YXRlIGRiXG55ZCAtPiB5ZDog57Sv6K6h5pKt5pS-5pe26ZW_XG55ZCAtPiBkYjog5a2Y5YKo5pKt5pS-5pe26ZW_XG55ZCAtPiBkcm06IOafpeivouWlluWKseWPkeaUvuinhOWImVxuYWN0aXZhdGUgZHJtXG5kcm0gLS0-IHlkOiDov5Tlm57lpZblirHlj5HmlL7op4TliJlcbmRlYWN0aXZhdGUgZHJtXG55ZCAtPiB5ZDog6K6h566X5Y-R5pS-55qE5YWL5pWwXG55ZCAtPiB5ZDog5p6E5bu65bmC562J6ZSuXG55ZCAtPiBzbDog5Y-R5pS-5aWW5YqxXG5hY3RpdmF0ZSBzbFxuc2wgLS0-IHlkOiDov5Tlm57lpZblirHlj5HmlL7nu5PmnpxcbmRlYWN0aXZhdGUgc2xcbnlkIC0-IGRiOiDorrDlvZXlpZblirHlj5HmlL7mtYHmsLRcbmRlYWN0aXZhdGUgZGJcbnlkIC0tPiBraGRcbmRlYWN0aXZhdGUgeWRcblxua2hkIC0tPiBVc2VyXG5cbkBlbmR1bWwiLCJ1cmwiOiJodHRwczovL2Nkbi5ubGFyay5jb20veXVxdWUvX19wdW1sLzliOTU5ODBhYzBkMmJiMjhmNWQ2Yzg2ZGY5YzFhZjJhLnN2ZyIsImlkIjoibXZrRVQiLCJtYXJnaW4iOnsidG9wIjp0cnVlLCJib3R0b20iOnRydWV9LCJjYXJkIjoiZGlhZ3JhbSJ9)##### 涉及的表
播放时长上报流水表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| id | long | 主键id |
| user_id | varchar | 用户id |
| sound_id | varchar | 声音id |
| duration | int | 上报时长 |
| sync_time | long | 上报时间 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 更新时间 |

播放记录表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| id | long | 主键id |
| user_id | varchar | 用户id |
| total_duration | int | 累计时长 |
| date | datetime | 记录日期 |
| last_sync_time | long | 最近上报时间 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 更新时间 |

发奖流水表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| id | long | 主键id |
| user_id | varchar | 用户id |
| biz_scene | varchar | 业务场景 |
| prize_code | varchar | 奖励id |
| prize_date | datetime | 发奖日期 |
| prize_stage | int | 发奖阶段 |
| prize_amount | int | 发奖数量 |
| out_biz_no | varchar | 外部业务号 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 更新时间 |

##### 业务关键点

1. 客户端上报播放时长的时候，每30s上报一次，上报的内容为“xx用户在什么时间播放xx声音xx秒”，支付宝小程序在弱网情况下会重试接口，为了防止重复上报，用户播放流水记录表需要加唯一索引——user_id + sound_id + sync_time
2. 客户端上报播放时长的时候，参数校验要着重处理上报的时长，过滤掉因为用户修改手机时间导致的播放时长异常
3. 计算累计播放时长的时候，需要通过时间段做范围查询后求和，因此检查用户播放流水记录表是否包含针对sync_time的索引是必须的
4. 每个用户每天应该只有一条总时长的数据记录，因此播放时长统计表需要包含user_id + date的唯一索引
5. 面对高频率的运营规则变动，为了提高系统的扩展性，将播放时长与奖励发放数量的对应关系维护在DRM配置中（if-else语句），并且借用Jexl脚本解析工具解析配置语句

[JEXL 简介-CSDN博客](https://blog.csdn.net/Angellyouran/article/details/127478954)

6. 播放音频发放奖励业务语义是：每个用户每天在当前具体场景下每个阶段只能发放xx奖励一次，因此下游outBizNo应该拼接为：userId + prize_code + biz_scene + date + stage
7. 考虑到扩展性，当前阶段只会发一种奖励，不排除以后和更多业务合作发其他东西，发奖处理器设计需要高内聚低耦合
![](https://cdn.nlark.com/yuque/__puml/400af008bc39107764c24687e5c8cad3.svg#lake_card_v2=eyJ0eXBlIjoicHVtbCIsImNvZGUiOiJAc3RhcnR1bWxcbmNsYXNzIFNlbmRQcml6ZUhhbmRsZXJGYWN0b3J5IHtcblx0K3NlbmRQcml6ZUhhbmRsZXJNYXBcbiAgK2dldFNlbmRQcml6ZUhhbmRsZXIoU3RyaW5nKVxufVxuXG5jbGFzcyBCYXNlU2VuZFByaXplSGFuZGxlciB7XG4gICtzZW5kZFByaXplKClcbn1cblxuQmFzZVNlbmRQcml6ZUhhbmRsZXIgPHwtZG93bi0gQW50Rm9yZXN0RW5lcmd5U2VuZEhhbmRsZXIgXG5CYXNlU2VuZFByaXplSGFuZGxlciA8fC1kb3duLSBCb29rQ29pblNlbmRIYW5kbGVyIFxuXG5AZW5kdW1sIiwidXJsIjoiaHR0cHM6Ly9jZG4ubmxhcmsuY29tL3l1cXVlL19fcHVtbC80MDBhZjAwOGJjMzkxMDc3NjRjMjQ2ODdlNWM4Y2FkMy5zdmciLCJpZCI6ImJobk11IiwibWFyZ2luIjp7InRvcCI6dHJ1ZSwiYm90dG9tIjp0cnVlfSwiY2FyZCI6ImRpYWdyYW0ifQ==)
7. 核对，阅读侧发奖流水表与森林侧发奖流水表按照outBizNo逐条比对，有偏差触发报警
#### 发布三板斧
##### 可灰度
逐步放开新增功能，把风险控制到最小
技术灰度：把机器划分为若干批次，每次发布一批次，然后暂停观察
业务灰度：把用户按照uid倒数两位分成100份，按照用户尾号进行且切流
##### 可监控
rpc接口监控：成功率，耗时，错误码
tr接口监控：成功率，耗时，错误码
错误监控
##### 可回滚
发布过程回滚：feature开关
运行过程回滚：降级开关
#### 代码规约
##### 可读性
命名规范
注释覆盖率
代码坏味道

推荐
《代码整洁之道》
《重构——改善代码既有设计》
##### 严谨性
参数校验
幂等控制（唯一键设计）
并发控制（一锁二判三更新）
调用下游处理（try-catch包裹）
异常处理（细节逐层Exception处理）
feature开关（逐步向外开放功能）
降级开关（通过配置一键回滚）
##### 扩展性
《设计模式之美》
工厂模式、策略模式、模板模式、责任链模式

#### 复习重点
java语言基础：面向对象原理，集合源码，并发（synchronize，cas，lock，aqs），反射 
jvm虚拟机（内存模型，垃圾回收，类加载机制）
mysql（增删改查语句，事务，索引，锁，mvcc，分库分表）
redis（基本数据结构的底层实现，应用场景）
spring，springmvc，mybatis。springboot
mq——rabbitmq
计算机网络、操作系统
leetcode
