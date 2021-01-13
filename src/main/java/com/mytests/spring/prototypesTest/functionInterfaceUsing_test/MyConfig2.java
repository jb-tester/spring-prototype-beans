package com.mytests.spring.prototypesTest.functionInterfaceUsing_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Function;

@Configuration
public class MyConfig2 {
    @Bean
    public Function<String, PBean> beanFactory() {
        return str1 -> pBean(str1);
    } 

    @Bean
    @Scope("prototype")
    public PBean pBean(String str1) {
       return new PBean(str1);
    }
    
    @Bean
    public SBean singletonFunctionBean() {
        return new SBean();
    }
    
}