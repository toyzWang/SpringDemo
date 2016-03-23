package cn.springmvc.annotation;

import org.aspectj.lang.ProceedingJoinPoint;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * Created by 王涛涛 on 2016/3/23.
 */
public class ThreadPoolTask implements Callable<String>, Serializable {
    private static final long serialVersionUID = 0;

    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    public ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }
    @Override
    public synchronized String call() throws Exception {
        ProceedingJoinPoint pjp = (ProceedingJoinPoint) threadPoolTaskData;
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "default";
        }
        return "success";
    }
}
