package com.example.suport.aop;/*
 * @author p78o2
 * @date 2019/9/24
 */

import java.lang.annotation.*;
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckApi {
    boolean isValid() default true;
}
