package org.ycframework.annotion;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // TYPE:类，接口
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface YcConfiguration {

}
