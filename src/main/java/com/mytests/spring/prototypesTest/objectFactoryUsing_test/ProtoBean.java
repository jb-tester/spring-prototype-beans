package com.mytests.spring.prototypesTest.objectFactoryUsing_test;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class ProtoBean {
    private final String str1;
    private final String str2;

    public ProtoBean(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String getStr1Str2() {
        return str1+" "+str2;
    }
    
}
