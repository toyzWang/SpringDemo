package cn.springmvc.annotation;

import org.springframework.scheduling.annotation.Async;

/**
 * Created by 王涛涛 on 2016/3/21.
 */
public class Test {

    @MyAsync
    public  void testAsyncMethod(){
        try {
            //让程序暂停100秒，相当于执行一个很耗时的任务
            for (int i = 0; i < 100000000; i++) {
            }
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
