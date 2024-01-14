package com.bigc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

// 配置 -> 数据库 -> 调用
@Configuration
public class QuartzConfig {

    // FactoryBean可简化Bean的实例化过程：
    // 1.通过FactoryBean封装Bean的实例化过程。
    // 2.将FactoryBean装配到spring容器里。
    // 3.将FactoryBean注入给其他的Bean。
    // 4.该Bean得到的是FactoryBean所管理的对象实例。

    // 配置JobDetail
//    @Bean
//    public JobDetailFactoryBean

    // 配置Trigger(SimpleTriggerFactoryBean, CronTriggerFactoryBean)

}
