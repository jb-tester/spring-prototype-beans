package com.mytests.spring.prototypesTest.objectFactoryUsing_test;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *
 * <p>Created by irina on 13.01.2021.</p>
 * <p>Project: spring-prototype-beans</p>
 * *
 */
public class UsageBean {
    @Autowired
    private ObjectProvider<ProtoBean> protoBeanObjectProvider;

    public ProtoBean getProtoBeanInstance() {
        return protoBeanObjectProvider.getObject("foo","bar");
    }
}
