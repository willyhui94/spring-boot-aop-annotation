package com.willyhui94.springbootaopannotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BeforeTraceableAspect {

  @Before("@annotation(com.willyhui94.springbootaopannotation.annotation.BeforeTraceable)")
  public void processBeforeTraceable(JoinPoint joinPoint) throws Throwable {
    ObjectMapper objectMapper = new ObjectMapper();

    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    Object[] array = joinPoint.getArgs();

    log.info(
        "BeforeTraceableAspect invoke: {}.{}, arguments: {}",
        className,
        methodName,
        objectMapper.writeValueAsString(array));
  }
}
