package com.willyhui94.springbootaopannotation.controller;

import com.willyhui94.springbootaopannotation.service.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ErrorController {

  @Autowired private ErrorService errorServiceImpl;

  public ErrorController(ErrorService errorServiceImpl) {
    this.errorServiceImpl = errorServiceImpl;
  }

  @GetMapping("/error")
  public String getAllProducts() {
    return errorServiceImpl.throwError();
  }
}
