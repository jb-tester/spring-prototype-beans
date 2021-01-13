package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
@Component @Scope("prototype")
public class PrototypeComponent1 {
    
    String str1;
    List<Integer> integerList;
    int someInt;
    public PrototypeComponent1(String str1, List<Integer> integerList, int someInt) {
        this.str1 = str1;
        this.integerList = integerList;
        this.someInt = someInt;
    }
    
    public String display(){
        return "PrototypeComponent1 instance with args: "+str1+", "+integerList.toString()+", "+someInt;
    }
}
