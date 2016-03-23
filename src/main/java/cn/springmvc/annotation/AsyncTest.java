package cn.springmvc.annotation;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 王涛涛 on 2016/3/21.
 */
@ContextConfiguration(locations = {
        "classpath*:/conf/spring.xml",
        "classpath*:/conf/spring-mybatis.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "localhost")
public class AsyncTest {

    @Autowired
    private Test myTest;

    @org.junit.Test
    public void Test(){
        myTest.testAsyncMethod();
        System.out.println("我已经执行了！");
    }
}
