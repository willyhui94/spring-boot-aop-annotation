package com.willyhui94.springbootaopannotation.exception;

import com.willyhui94.springbootaopannotation.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  @ResponseBody
  public ResponseResult processSystemException(HttpServletResponse response, ServiceException e) {
    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.setContentType("application/json;charset=UTF-8");
    ResponseResult responseResult = new ResponseResult();
    responseResult.setCode(e.getCode());
    responseResult.setMessage(e.getMessage());
    log.info("GlobalExceptionHandler.processSystemException: {}", e.getMessage());
    return responseResult;
  }
}
