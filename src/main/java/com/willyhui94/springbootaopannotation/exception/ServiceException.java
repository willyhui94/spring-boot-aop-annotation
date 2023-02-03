package com.willyhui94.springbootaopannotation.exception;

public class ServiceException extends RuntimeException {

  private final Integer code;

  public ServiceException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public ServiceException(Integer code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
