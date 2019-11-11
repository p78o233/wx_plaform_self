package com.example.suport.aop;/*
 * @author p78o2
 * @date 2019/9/24
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class ApiCheckAspect {

    // 在这里定义切点，切点为我们之前设置的注解@checkApi
//    @Pointcut("@annotation(com.example.suport.aop.CheckApi)")
//    public void checkApi() {
//    }
//    @Pointcut("@annotation(com.example.suport.aop.CheckApi) " )
//    public void checkApiMenthod(){}
//    @Around("checkApi()")
//    public String checkApiPoint(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 首先获取方法的签名，joinPoint中有相应的签名信息
//        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
//        // 通过方法的签名可以获取方法本身
//        Method method = signature.getMethod();
//        // 通过joinPoint获取方法的实际参数的值
//        Object[] args = joinPoint.getArgs();
//
//        return null;
//    }

//    @Before("checkApiMenthod()")
//    public Object Interceptor(JoinPoint pjp){
//        Object result = null;
//        Object[] args = pjp.getArgs();
//        return result;
//    }
    /**
     * 定义有一个切入点
     */
    @Pointcut("execution(public * com.example.suport.service.impl..*.*(..))")
    public void checkAppid() {
    }

    @Before("checkAppid()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //得到拦截的方法
        Method method = signature.getMethod();
        //获取方法参数注解，返回二维数组是因为某些参数可能存在多个注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations != null && parameterAnnotations.length > 0) {
            //获取方法参数名
            String[] paramNames = signature.getParameterNames();
            //获取参数值
            Object[] paranValues = joinPoint.getArgs();
            //获取方法参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();

        }
    }
}
