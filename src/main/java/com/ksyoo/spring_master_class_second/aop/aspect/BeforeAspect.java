package com.ksyoo.spring_master_class_second.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;

@Aspect
@SpringBootConfiguration
public class BeforeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.ksyoo.spring_master_class_second.aop..*.*(..))")
    public void before(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted Before             : {}", signature);
    }

    @Before("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void beforePointCut(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted Before PointCut    : {}", signature);
    }

    @Before("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.allLayerExecution()")
    public void beforePointCutAll(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted Before PointCut All: {}", signature);
    }

    @AfterReturning(
            value = "execution(* com.ksyoo.spring_master_class_second.aop.business.*.*(..))",
            returning = "result"
    )
    public void afterReturn(JoinPoint joinPoint, Object result) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted after-return       : {}, result: {}", signature, result);
    }

    @After("execution(* com.ksyoo.spring_master_class_second.aop..*.*(..))")
    public void after(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted After              : {}", signature);
    }

    @After("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void afterPointCut(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted After  PointCut    : {}", signature);
    }

    @After("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.allLayerExecution()")
    public void afterPointCutAll(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        logger.info("    Intercepted After  PointCut All: {}", signature);
    }

//    // Weaving & Weaver
//    // intercept
//    @Before("execution(* com.ksyoo.spring_master_class_second..*.*(..))")
//    public void beforeAllInPackage(JoinPoint joinPoint) {
//        // advice
//        var signature = joinPoint.getSignature();
//        logger.info("  Intercepted beforeAllInPackage: {}", signature);
//    }
}
