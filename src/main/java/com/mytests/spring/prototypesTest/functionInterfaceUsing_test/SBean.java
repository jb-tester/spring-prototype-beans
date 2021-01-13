package com.mytests.spring.prototypesTest.functionInterfaceUsing_test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class SBean {
    @Autowired
    private Function<String, PBean> beanFactory;

    public PBean getPBeanInstance(String str1) {
        PBean bean = beanFactory.apply(str1);
        return bean;
    }
}
