/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.model.result;

import org.weibin.myhome.biz.shared.model.common.ServiceResult;

/**
 *
 * @author weibin
 * @version $Id: DemoResult.java, v 0.1 2018-07-30 15:44 weibin Exp $
 */
public class DemoResult extends ServiceResult {

    private String echo;

    /**
     * Getter method for property <tt>echo</tt>.
     *
     * @return property value of Echo
     */
    public String getEcho() {
        return echo;
    }

    /**
     * Setter method for property <tt>echo</tt>.
     *
     * @param echo value to be assigned to property echo
     */
    public void setEcho(String echo) {
        this.echo = echo;
    }
}