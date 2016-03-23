package cn.springmvc.service;

import java.lang.annotation.*;

/**
 * Created by 王涛涛 on 2016/3/10.
 */

//自定义注解相关设置
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String desc() default "无描述信息";
}
