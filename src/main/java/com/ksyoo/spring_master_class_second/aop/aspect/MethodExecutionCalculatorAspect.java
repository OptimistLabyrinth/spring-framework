package com.ksyoo.spring_master_class_second.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;

@Aspect
@SpringBootConfiguration
public class MethodExecutionCalculatorAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.ksyoo.spring_master_class_second.aop.*.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        logger.info("  Time Taken by {} is {}", proceedingJoinPoint, timeTaken);
    }
}
