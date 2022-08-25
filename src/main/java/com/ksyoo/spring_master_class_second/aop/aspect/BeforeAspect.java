package com.ksyoo.spring_master_class_second.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;

@Aspect
@SpringBootConfiguration
public class BeforeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.ksyoo.spring_master_class_second.aop.*.*.*(..))")
    public void beforeAll(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("  Intercepted All Method Calls Before: {}", signature);
    }

    @AfterReturning(
            value = "execution(* com.ksyoo.spring_master_class_second.aop.*.*.*(..))",
            returning = "result"
    )
    public void afterAll(JoinPoint joinPoint, Object result) {
        var signature = joinPoint.getSignature();
        logger.info("  Intercepted All Method Calls AfterReturn: {}, value: {}", signature, result);
    }

    @After("execution(* com.ksyoo.spring_master_class_second.aop.*.*.*(..))")
    public void after(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("  Intercepted All Method Calls After: {}", signature);
    }

//    @Before("execution(* com.ksyoo.spring_master_class_second.aop.business1.*.*(..))")
//    public void before1(JoinPoint joinPoint) {
//        var signature = joinPoint.getSignature();
//        logger.info("  Intercepted Method Calls 1: {}", signature);
//    }
//
//    @Before("execution(* com.ksyoo.spring_master_class_second.aop.business2.*.*(..))")
//    public void before2(JoinPoint joinPoint) {
//        var signature = joinPoint.getSignature();
//        logger.info("  Intercepted Method Calls 2: {}", signature);
//    }
}
