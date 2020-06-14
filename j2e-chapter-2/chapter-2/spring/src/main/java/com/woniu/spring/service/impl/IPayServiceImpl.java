package com.woniu.spring.service.impl;

import com.woniu.spring.service.IPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
@Service("IPayService")
public class IPayServiceImpl implements IPayService {

    private static double total=100000000;
    private static double totalP=100000000;

    @Override
    public String payByPoint(double money) {
        BigDecimal decimal=new BigDecimal(totalP);
        if(decimal.subtract(new BigDecimal(money)).compareTo(BigDecimal.ZERO)>=0){
            totalP=decimal.subtract(new BigDecimal(money)).floatValue();
            return "success";
        }else{
            return "fail";
        }
    }

    @Override
    public String payRMB(double money) {
        BigDecimal decimal=new BigDecimal(total);
        if(decimal.subtract(new BigDecimal(money)).compareTo(BigDecimal.ZERO)>=0){
            total=decimal.subtract(new BigDecimal(money)).floatValue();
            return "success";
        }else{
            return "fail";
        }
    }

}