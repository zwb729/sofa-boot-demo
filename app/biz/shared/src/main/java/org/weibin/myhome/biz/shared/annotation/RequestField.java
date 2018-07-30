/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.weibin.myhome.biz.shared.converter.field.RequestFieldConverter;

/**
 *
 * @author weibin
 * @version $Id: RequestField.java, v 0.1 2018-07-30 15:25 weibin Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequestField {

    /**
     * 参数在context.param中的key
     * @return
     */
    String field() default "";

    /**
     * @return
     */
    String defaultValue() default "";

    /**
     * @return
     */
    Class<? extends RequestFieldConverter> converter() default RequestFieldConverter.class;

}