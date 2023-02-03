package com.willyhui94.springbootaopannotation.service.impl;

import com.willyhui94.springbootaopannotation.annotation.AfterReturningTraceable;
import com.willyhui94.springbootaopannotation.annotation.AfterTraceable;
import com.willyhui94.springbootaopannotation.annotation.AroundTraceable;
import com.willyhui94.springbootaopannotation.annotation.BeforeTraceable;
import com.willyhui94.springbootaopannotation.service.ErrorService;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {

  @AroundTraceable(param1 = "ErrorServiceImpl param1", param2 = "ErrorServiceImpl param2")
  @BeforeTraceable
  @AfterTraceable
  @AfterReturningTraceable
  @Override
  public String throwError() {
    throw new RuntimeException("test error");
  }
}
