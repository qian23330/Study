package com.bigc.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    // 声明第三方Bean
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
