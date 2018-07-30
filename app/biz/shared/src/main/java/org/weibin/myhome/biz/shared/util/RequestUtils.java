/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weibin.myhome.biz.shared.annotation.RequestField;
import org.weibin.myhome.biz.shared.converter.field.RequestFieldConverter;
import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.common.ServiceRequest;
import org.weibin.myhome.common.util.log.LogUtils;

/**
 *
 * @author weibin
 * @version $Id: RequestUtils.java, v 0.1 2018-07-30 15:21 weibin Exp $
 */
public class RequestUtils {

    /** logger */
    private final static Logger                                                       LOGGER            = LoggerFactory
        .getLogger(RequestUtils.class);

    private static Map<Class<? extends RequestFieldConverter>, RequestFieldConverter> fieldConverterMap = new HashMap<>();

    /**
     * @param context
     * @param requestClass
     * @param <T>
     * @return
     */
    public static <T extends ServiceRequest> T buildRecRequest(ServiceContext context,
                                                               Class<T> requestClass) {
        if (context == null || requestClass == null) {
            return null;
        }

        try {
            T request = requestClass.newInstance();

            populateFields(context, requestClass, request);

            return request;
        } catch (Exception e) {
            LogUtils.error(LOGGER, e, "convert request error for class=" + requestClass.getName());
        }

        return null;
    }

    /**
     * 逐一组装字段
     * @param context
     * @param clazz
     * @param target
     * @throws Exception
     */
    private static void populateFields(ServiceContext context, Class<?> clazz, Object target)
                                                                                              throws Exception {
        for (Field f : clazz.getDeclaredFields()) {
            // 取注解参数
            RequestField fieldAnnotation = f.getDeclaredAnnotation(RequestField.class);
            String annoField = null;
            String annoDefValue = null;
            Class<? extends RequestFieldConverter> annoConverterType = null;
            if (fieldAnnotation != null) {
                annoField = fieldAnnotation.field();
                annoDefValue = fieldAnnotation.defaultValue();
                annoConverterType = fieldAnnotation.converter();
            }

            // request里field名称
            String fieldName = f.getName();

            // field type
            Class fieldType = f.getType();

            // context.param中参数key，如果注解没特别指定，用field名称
            String keyName = fieldName;
            if (StringUtils.isNotBlank(annoField)) {
                keyName = annoField;
            }

            // 取入参，如果参数未传，并且注解有默认，取注解默认值
            String paramValue = context.getParams().get(keyName);
            if (paramValue == null && !"".equals(annoDefValue)) {
                paramValue = annoDefValue;
            }

            // 无参数，不处理
            if (paramValue == null) {
                continue;
            }

            // 取setter
            String setterName = "set" + StringUtils.capitalize(f.getName());
            Method setter = clazz.getMethod(setterName, f.getType());

            // 无setter，不处理
            if (setter == null) {
                continue;
            }

            // 如果注解指定converter，做转换
            Object obj = null;
            try {
                // 有转换器且不是接口默认
                if (annoConverterType != null && annoConverterType != RequestFieldConverter.class) {
                    RequestFieldConverter converter = fieldConverterMap.get(annoConverterType);
                    if (converter == null) {
                        synchronized (fieldConverterMap) {
                            converter = annoConverterType.newInstance();
                            fieldConverterMap.put(annoConverterType, converter);
                        }
                    }

                    obj = converter.convert(paramValue);
                } else if (fieldType == String.class) {
                    obj = paramValue;
                } else if (fieldType == int.class || fieldType == Integer.class) {
                    obj = Integer.parseInt(paramValue);
                } else if (fieldType == double.class || fieldType == Double.class) {
                    obj = Double.parseDouble(paramValue);
                } else if (fieldType == float.class || fieldType == Float.class) {
                    obj = Float.parseFloat(paramValue);
                } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                    obj = Boolean.parseBoolean(paramValue);
                } else {
                    obj = null;
                }
                //}
            } catch (Exception e) {
                LogUtils.error(LOGGER, e, "convert request error for filed=" + f.getName());
            }

            if (obj != null) {
                setter.invoke(target, new Object[] { obj });
            }
        }

        // 递归父类
        if (clazz.getSuperclass() != null) {
            populateFields(context, clazz.getSuperclass(), target);
        }
    }
}