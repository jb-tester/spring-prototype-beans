package com.mytests.spring.prototypesTest.objectFactoryUsing_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */  
@Configuration
public class MyConfig3 {

    @Bean @Scope("prototype")
    public ProtoBean protoBean(String str1, String str2) {
        return new ProtoBean(str1, str2);
    }

    @Bean
    public UsageBean usageBean() {
        return new UsageBean();
    }
}
