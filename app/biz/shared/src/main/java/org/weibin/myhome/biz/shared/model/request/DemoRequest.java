/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.model.request;

import org.weibin.myhome.biz.shared.model.common.ServiceRequest;

/**
 *
 * @author weibin
 * @version $Id: DemoRequest.java, v 0.1 2018-07-30 15:44 weibin Exp $
 */
public class DemoRequest extends ServiceRequest {

    private String name;

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
}