/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.common.util.exception;

/**
 *
 * @author weibin
 * @version $Id: IntlRecErrorCode.java, v 0.1 2018-06-28 13:17 weibin Exp $
 */
public enum InnerErrorCode {

    SUCCESS("成功"),

    SYSTEM_ERROR("系统错误"),

    CONFIG_ERROR("配置错误"),

    ILLEGAL_PARAM("参数非法"),

    ILLEGAL_SERVICE_CODE("ServiceCode非法"),

    ILLEGAL_CONTEXT("上下文非法"),

    SERVICE_NOT_FOUND("服务未找到"),

    ARGS_COUNT_UNMATCHED("参数个数不匹配"),

    ;

    /** 描述 */
    private String desc;

    /**
     * @param desc
     */
    private InnerErrorCode(String desc) {
        this.desc = desc;
    }

    /**
     * 通过<code>code</code>获得枚举
     * @param name
     * @return 枚举值
     */
    public static InnerErrorCode getByName(String name) {
        for (InnerErrorCode item : values()) {
            if (item.name().equals(name)) {
                return item;
            }
        }

        return null;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

}