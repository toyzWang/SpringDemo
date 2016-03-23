package cn.springmvc.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by 王涛涛 on 2016/3/21.
 */
@Aspect
@Component
public class AsyncAspect {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Around(value = "within(cn.springmvc.annotation..*) && @annotation(asy)")
    public Object aroundMethod( ProceedingJoinPoint pjd, MyAsync asy) {
        final Object[] result = {null};
        try {
            new Thread(new StartTaskThread(taskExecutor, 1,pjd)).start();
        } catch (Throwable e) {
            System.out.println("异常通知");
        }
        return null;
    }
}
