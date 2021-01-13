package com.mytests.spring.prototypesTest.functionInterfaceUsing_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class RunMe2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig2.class);
        SBean sBean = ctx.getBean(SBean.class);
        System.out.println(sBean.getPBeanInstance("foo").getStr1());
    }

}