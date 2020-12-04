package com.li.mvvmlibary.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 08
 * 描述：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindLayout {
    int value() ;
}
