package com.gou.springcloud.common.annotation;

import java.lang.annotation.*;

/**
 * @author goujianjun
 * @date 2019-06-04 14:34
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnorePermission {
}
