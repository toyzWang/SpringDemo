package cn.springmvc.annotation;

import java.lang.annotation.*;

/**
 * Created by 王涛涛 on 2016/3/21.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAsync {
    String desc() default "";
}

