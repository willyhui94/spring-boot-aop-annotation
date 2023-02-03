package com.willyhui94.springbootaopannotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willyhui94.springbootaopannotation.annotation.AroundTraceable;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class AroundTraceableAspect {

  @Pointcut("@annotation(com.willyhui94.springbootaopannotation.annotation.AroundTraceable)")
  public void aroundTraceablePointcut() {}

  @Around(value = "aroundTraceablePointcut()")
  public Object processAroundTraceable(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    ObjectMapper objectMapper = new ObjectMapper();

    String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
    String methodName = proceedingJoinPoint.getSignature().getName();
    Object[] array = proceedingJoinPoint.getArgs();

    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
    Method method = methodSignature.getMethod();

    AroundTraceable aroundTraceable = method.getAnnotation(AroundTraceable.class);
    String param1 = aroundTraceable.param1();
    String param2 = aroundTraceable.param1();

    log.info(
        "AroundTraceableAspect start invoke: {}.{}, annotation param1: {}, param2: {}, arguments: {}",
        className,
        methodName,
        param1,
        param2,
        objectMapper.writeValueAsString(array));

    Object result = proceedingJoinPoint.proceed();

    log.info(
        "AroundTraceableAspect end invoke: {}.{}, result: {}",
        className,
        methodName,
        objectMapper.writeValueAsString(result));
    return result;
  }
}
