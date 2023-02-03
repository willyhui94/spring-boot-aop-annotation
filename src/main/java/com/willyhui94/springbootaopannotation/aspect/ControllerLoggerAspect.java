package com.willyhui94.springbootaopannotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willyhui94.springbootaopannotation.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLoggerAspect {

  // first * represent any return value
  // com.willyhui94.springbootaopannotation.controller represent package path
  // second * represent any controller
  // third * represent any method
  @Pointcut(value = "execution(* com.willyhui94.springbootaopannotation.controller.*.*(..))")
  public void controllerPointcut() {}

  @Around(value = "controllerPointcut()")
  public Object processControllerLogger(ProceedingJoinPoint joinPoint) throws Throwable {
    ObjectMapper objectMapper = new ObjectMapper();

    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    Object[] array = joinPoint.getArgs();

    log.info(
        "ControllerLoggerAdvice start Invoke {}.{}, arguments: {}",
        className,
        methodName,
        objectMapper.writeValueAsString(array));

    Object result = joinPoint.proceed();
    log.info("ControllerLoggerAdvice end Invoke {}.{}", className, methodName);
    return result;
  }

  @AfterThrowing(value = "controllerPointcut()", throwing = "error")
  public void afterThrow(JoinPoint joinPoint, Exception error) {
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    log.info("ControllerLoggerAdvice AfterThrowing Invoke {}.{}", className, methodName);
    log.info("ControllerLoggerAdvice AfterThrowing error: {}", error.getMessage());
    throw new ServiceException(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
  }
}
