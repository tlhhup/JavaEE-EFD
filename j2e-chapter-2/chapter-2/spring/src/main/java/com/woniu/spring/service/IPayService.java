package com.woniu.spring.service;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public interface IPayService {

    /**
     * 积分支付
     * @param money
     * @return
     */
    String payByPoint(double money);

    /**
     * 人民币支付
     * @param money
     * @return
     */
    String payRMB(double money);

}
