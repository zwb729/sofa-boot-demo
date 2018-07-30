/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.common.util;

import java.util.Collection;
import java.util.Map;

import org.weibin.myhome.common.util.exception.InnerErrorCode;
import org.weibin.myhome.common.util.exception.InnerException;

/**
 *
 * @author weibin
 * @version $Id: AssertUtils.java, v 0.1 2018-07-30 14:52 weibin Exp $
 */
public class AssertUtils {
    /**
     * @param expression
     * @param errorCode
     * @param objs
     */
    public static void isTrue(boolean expression, InnerErrorCode errorCode, Object... objs) {
        if (!expression) {
            throw new InnerException(errorCode, buildMessage(objs));
        }
    }

    /**
     * @param expression
     * @param errorCode
     * @param objs
     */
    public static void isFalse(boolean expression, InnerErrorCode errorCode, Object... objs) {
        if (expression) {
            throw new InnerException(errorCode, buildMessage(objs));
        }
    }

    /**
     * @param object
     * @param errorCode
     * @param objs
     */
    public static void isNull(Object object, InnerErrorCode errorCode, Object... objs) {
        isTrue((object == null), errorCode, objs);
    }

    /**
     * @param object
     * @param errorCode
     * @param objs
     */
    public static void notNull(Object object, InnerErrorCode errorCode, Object... objs) {
        isTrue((object != null), errorCode, objs);
    }

    /**
     * @param str
     * @param errorCode
     * @param objs
     */
    public static void notBlank(String str, InnerErrorCode errorCode, Object... objs) {
        isTrue((str != null && str.trim().length() > 0), errorCode, objs);
    }

    /**
     * @param str
     * @param errorCode
     * @param objs
     */
    public static void notEmpty(String str, InnerErrorCode errorCode, Object... objs) {
        isTrue((str != null && str.length() > 0), errorCode, objs);
    }

    /**
     * @param collection
     * @param errorCode
     * @param objs
     */
    public static void notEmpty(Collection collection, InnerErrorCode errorCode, Object... objs) {
        isTrue((collection != null && collection.size() > 0), errorCode, objs);
    }

    /**
     * @param map
     * @param errorCode
     * @param objs
     */
    public static void notEmpty(Map map, InnerErrorCode errorCode, Object... objs) {
        isTrue((map != null && map.size() > 0), errorCode, objs);
    }

    /**
     * @param objs
     * @return
     */
    private static String buildMessage(Object... objs) {
        StringBuilder sb = new StringBuilder();
        if (objs != null) {
            for (Object obj : objs) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}