package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
@Configuration
@ComponentScan
public class MyConfig {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }
    @Bean @Scope("prototype")
    public Bean2 prototypeBean21(Bean1 bean1, String str1){
        return new Bean2(bean1, str1);
    }
    @Bean @Scope("prototype")
    public Bean2 prototypeBean22(Bean1 bean1, String str1, int i1){
        Bean2 b2 = new Bean2(bean1,str1);
        b2.setI1(i1);
        return b2;
    }
    @Bean @Scope("prototype")
    public Bean3 prototypeBean31(String str1, String str2, String str3){
        Bean3 bean3 = new Bean3(str1,str2);
        bean3.setStr3(str3);
        return bean3;
    }
   // @Bean @Scope("prototype")
    public Bean3 prototypeBean32(String str1, String str2){
        return new Bean3(str1,str2);
    }

    //@Bean 
    public Bean4 singletonBean(String str1, String str2){
        return new Bean4(str1,str2);
    }
    
}
