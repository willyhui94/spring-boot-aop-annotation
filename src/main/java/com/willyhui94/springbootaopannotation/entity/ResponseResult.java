package com.willyhui94.springbootaopannotation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ResponseResult<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  private Integer code;

  private String message;

  public static <T> ResponseResult<T> systemException(Integer code, String message, T data) {
    ResponseResult<T> responseResult = new ResponseResult<>();
    responseResult.setCode(code);
    responseResult.setMessage(message);
    responseResult.setData(data);
    return responseResult;
  }
}
