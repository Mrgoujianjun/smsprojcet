package com.gou.springcloud.common.annotation;

import java.lang.annotation.*;

/**
 * @author goujianjun
 * @date 2020-03-01 21:44
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogPersistence {
    /**
     * mapping地址
     * @return
     */
    String value() default "";
}
