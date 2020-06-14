package com.woniu.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class IPayServiceTest {

    @Resource
    private IPayService iPayService;

    @Test
    public void pay(){
        String result = iPayService.payByPoint(1000000000);
        System.out.println(result);
    }

}