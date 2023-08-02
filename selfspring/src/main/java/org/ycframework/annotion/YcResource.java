package org.ycframework.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface YcResource {
    String name() default ""; // 指定要装配的对象的id名
}
