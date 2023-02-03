package com.willyhui94.springbootaopannotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterReturningTraceableAspect {

  @AfterReturning(
      value =
          "@annotation(com.willyhui94.springbootaopannotation.annotation.AfterReturningTraceable)",
      returning = "result")
  public void processAfterReturningTraceable(JoinPoint joinPoint, Object result) throws Throwable {
    ObjectMapper objectMapper = new ObjectMapper();

    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();

    log.info(
        "AfterReturningTraceableAspect invoke: {}.{}, arguments: {}",
        className,
        methodName,
        objectMapper.writeValueAsString(result));
  }
}
