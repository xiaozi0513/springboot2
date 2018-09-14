package com.wh.core.datasource.aspect;

import com.wh.core.datasource.DynamicDataSourceContextHolder;
import com.wh.core.datasource.annotation.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: wang_hui
 * @date: 2018/9/14 下午12:00
 */
@Slf4j
@Aspect
@Component
public class TargetDataSourceAspect {

//    @Pointcut("execution( * com.wh.mapper.*.*.*(..))")
    @Pointcut("@annotation(com.wh.core.datasource.annotation.TargetDataSource)")
    public void dataSourcePointcut() {

    }


    @Around("dataSourcePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        System.out.println("*****" + method.getName());
        if (method.isAnnotationPresent(TargetDataSource.class)) {
            TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
            DynamicDataSourceContextHolder.setDataSourceLookupKey(targetDataSource.value());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceLookupKey();
        }
    }

}
