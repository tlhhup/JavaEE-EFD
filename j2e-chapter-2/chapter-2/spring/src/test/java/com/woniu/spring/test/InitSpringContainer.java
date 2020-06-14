package com.woniu.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class InitSpringContainer {

    @Test
    public void init(){
        ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
    }

}
