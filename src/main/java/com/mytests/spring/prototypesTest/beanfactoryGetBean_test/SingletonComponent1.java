package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

import org.springframework.stereotype.Component;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
//@Component  
public class SingletonComponent1 {


    private final String arg1;
    private final String arg2;
    // no autowiring errors are shown!
    public SingletonComponent1(String arg1, String arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
}
