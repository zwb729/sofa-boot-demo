/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.common.util.exception;

/**
 *
 * @author weibin
 * @version $Id: exception.java, v 0.1 2018-06-28 13:16 weibin Exp $
 */
public class InnerException extends RuntimeException {

    /** 错误码 */
    private InnerErrorCode errorCode;

    /**
     * 禁止无参构造器
     */
    private InnerException() {
        super();
    }

    /**
     * @param resultCode
     */
    public InnerException(InnerErrorCode resultCode) {
        super();
        this.errorCode = resultCode;
    }

    /**
     * @param t
     * @param resultCode
     */
    public InnerException(Throwable t, InnerErrorCode resultCode) {
        super(t);
        this.errorCode = resultCode;
    }

    /**
     * @param resultCode
     * @param message
     */
    public InnerException(InnerErrorCode resultCode, String message) {
        super(message);
        this.errorCode = resultCode;
    }

    /**
     * @param t
     * @param resultCode
     * @param message
     */
    public InnerException(Throwable t, InnerErrorCode resultCode, String message) {
        super(message, t);
        this.errorCode = resultCode;
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     *
     * @return property value of resultCode
     */
    public InnerErrorCode getErrorCode() {
        return errorCode;
    }

}