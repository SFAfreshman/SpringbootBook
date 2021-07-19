package com.example.demo.MyAnnotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created BY DarkSheep ON 2021/7/18 23:53
 **/
@Target({ElementType.METHOD,ElementType.TYPE})//作用范围
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Component
@Documented//生成文档
public @interface MyAnnotationDemo {
    String value();//参数类型为字符串,当仅有一个参数且参数名为value时,使用注解可以省略参数名
}
