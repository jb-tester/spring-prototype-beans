package com.mytests.spring.prototypesTest.beanfactoryGetBean_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class RunMe {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Bean1 bean1 = ctx.getBean(Bean1.class);
        Bean2 bean2_1 = (Bean2) ctx.getBean("prototypeBean21",bean1, "foo");
        Bean2 bean2_2 = (Bean2) ctx.getBean("prototypeBean22",bean1, "bar", 100);
        
        
       // Bean3 bean3_1 = ctx.getBean(Bean3.class, "foo","bar");
        Bean3 bean3_2 = ctx.getBean(Bean3.class, "foo","bar","boo");
        
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        PrototypeComponent1 component11 = ctx.getBean(PrototypeComponent1.class,"bar", integerList, 100);


        System.out.println(bean2_1.display());
        System.out.println(bean2_2.display());
        System.out.println(bean3_2.display());
        System.out.println(component11.display());
    }

}