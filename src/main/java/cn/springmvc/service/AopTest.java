package cn.springmvc.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * Created by 王涛涛 on 2016/3/10.
 */
public class AopTest {
    @Around(value = "execution(* cn.springmvc.service.impl.*.*(..)) && @annotation(log)")
    public Object aroundMethod(ProceedingJoinPoint pjd, LogAnnotation log) {

        Object result = null;
        System.out.println(log.desc());
        try {
            System.out.println("前置通知");
            result = pjd.proceed();
            System.out.println("后置通知");
        } catch (Throwable e) {
            System.out.println("异常通知");
        }
        System.out.println("返回通知");
        return result;
    }
}
