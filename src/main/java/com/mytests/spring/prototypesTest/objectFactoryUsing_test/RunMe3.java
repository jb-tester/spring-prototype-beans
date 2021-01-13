package com.mytests.spring.prototypesTest.objectFactoryUsing_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class RunMe3 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig3.class);
        UsageBean usageBean = ctx.getBean(UsageBean.class);
        System.out.println(usageBean.getProtoBeanInstance().getStr1Str2());
    }

}