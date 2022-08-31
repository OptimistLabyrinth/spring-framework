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

//    @Around("execution(* com.ksyoo.spring_master_class_second.aop.business.*.*(..))")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        proceedingJoinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        long timeTaken = endTime - startTime;
//        logger.info("        {} ms taken for {}", timeTaken, proceedingJoinPoint);
//    }

    @Around("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.TrackTimeAnnotation()")
    public void trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        logger.info("        {} ms taken for {}", timeTaken, proceedingJoinPoint);
    }

//    @Around("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.allLayerExecution()")
//    public void aroundPointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        var signature = proceedingJoinPoint.getSignature();
//        logger.info("    Intercepted Around PointCut: {}", signature);
//    }
}
