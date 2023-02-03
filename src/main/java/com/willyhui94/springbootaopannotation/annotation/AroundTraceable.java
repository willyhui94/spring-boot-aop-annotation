package com.willyhui94.springbootaopannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundTraceable {

    String param1() default "parameter 1";
    String param2() default "parameter 1";
}
