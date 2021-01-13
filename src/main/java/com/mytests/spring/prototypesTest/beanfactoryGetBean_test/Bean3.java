package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class Bean3 {
    
    String str1;
    String str2;
    String str3="nothing";
    
    public Bean3(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public void setStr3(String str3) {
        this.str3=str3;
    }
    
    public String display(){
        return "Bean3 with args: "+str1+", "+str2+", "+str3;
    }
}
