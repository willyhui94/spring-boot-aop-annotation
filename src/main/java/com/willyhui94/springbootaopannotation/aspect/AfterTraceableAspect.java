package com.willyhui94.springbootaopannotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterTraceableAspect {

  @After("@annotation(com.willyhui94.springbootaopannotation.annotation.AfterTraceable)")
  public void processAfterTraceable(JoinPoint joinPoint) throws Throwable {
    ObjectMapper objectMapper = new ObjectMapper();

    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();

    log.info("AfterTraceableAspect invoke: {}.{}", className, methodName);
  }
}
