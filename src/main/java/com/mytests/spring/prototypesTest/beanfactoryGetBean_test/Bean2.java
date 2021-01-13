package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class Bean2 {
    String str1;
    Bean1 bean1;
    int i1;

    public Bean2(Bean1 bean1, String str1) {
        this.bean1 = bean1;
        this.str1 = str1;
    }
    public String display(){
        return "Bean2 instance with args: "+bean1+", "+str1+", "+i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }
}
