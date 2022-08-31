package com.ksyoo.spring_master_class_second.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.ksyoo.spring_master_class_second.aop.data.*.*(..))")
    public void dataLayerExecution() {}

    @Pointcut("execution(* com.ksyoo.spring_master_class_second.aop.business.*.*(..))")
    public void businessLayerExecution() {}

//    @Pointcut("execution(* com.ksyoo.spring_master_class_second.aop..*.*(..))")
    @Pointcut("com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.dataLayerExecution() || com.ksyoo.spring_master_class_second.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void allLayerExecution() {}

    @Pointcut("@annotation(com.ksyoo.spring_master_class_second.aop.aspect.TrackTime)")
    public void TrackTimeAnnotation() {}
}
