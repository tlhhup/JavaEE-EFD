package com.woniu.spring.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class LoggerAdvice {

    private static final Logger LOGGER= Logger.getLogger(LoggerAdvice.class);

    public void before(){
        System.out.println("在方法执行之前执行");
    }

    public void after(){
        System.out.println("在方法执行之后执行");
    }

    /**
     * 回调函数
     * @param joinPoint
     * @return
     */
    public Object around(ProceedingJoinPoint joinPoint){
		/*joinPoint.getArgs();//得到实际参数
		joinPoint.getTarget();//得到目标对象
		joinPoint.getSignature();//得到方法签名
		*/
        try {
            //记录支付多少钱
            Object money = joinPoint.getArgs()[0];
            Object result = joinPoint.proceed();//完成目标对象方法的调用
            //支付成功
            LOGGER.debug("支付了："+money+"  结果为："+result);

            return result;
        } catch (Throwable e) {
            LOGGER.debug("支付失败"+e.getMessage());
        }
        return null;
    }


}
