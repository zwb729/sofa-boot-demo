/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.converter.field;

/**
 *
 * @author weibin
 * @version $Id: RecParamFieldConverter.java, v 0.1 2018-07-03 16:06 weibin Exp $
 */
public interface RequestFieldConverter {

    /**
     * @param str
     * @return
     */
    Object convert(String str);
}