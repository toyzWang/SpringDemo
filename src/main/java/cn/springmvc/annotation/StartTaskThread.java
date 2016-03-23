package cn.springmvc.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by 王涛涛 on 2016/3/23.
 */
public class StartTaskThread implements Runnable {

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private int i;
    Object task;
    public StartTaskThread(ThreadPoolTaskExecutor threadPoolTaskExecutor, int i,ProceedingJoinPoint pjp) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.i = i;
        this.task = pjp;
    }
    @Override
    public synchronized  void run() {
        System.out.println("创建任务并提交到线程池中：");
        FutureTask<String> futureTask = new FutureTask<String>(new ThreadPoolTask(task));
        threadPoolTaskExecutor.execute(futureTask);
        // 在这里可以做别的任何事情
        String result = null;
        try {
            // 取得结果，同时设置超时执行时间为1秒。同样可以用future.get()，不设置执行超时时间取得结果
            result = futureTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            futureTask.cancel(true);
        } catch (Exception e) {
            futureTask.cancel(true);
            // 超时后，进行相应处理
        } finally {
            System.out.println("task@" + i + ":result=" + result);
        }
    }
}
