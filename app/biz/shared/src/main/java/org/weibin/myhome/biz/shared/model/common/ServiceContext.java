/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.model.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author weibin
 * @version $Id: ServiceContext.java, v 0.1 2018-07-30 15:12 weibin Exp $
 */
public class ServiceContext {

    private String              serviceCode;

    private Map<String, String> params = new HashMap<>();

    /**
     * Getter method for property <tt>serviceCode</tt>.
     *
     * @return property value of ServiceCode
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Setter method for property <tt>serviceCode</tt>.
     *
     * @param serviceCode value to be assigned to property serviceCode
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * Getter method for property <tt>params</tt>.
     *
     * @return property value of Params
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * Setter method for property <tt>params</tt>.
     *
     * @param params value to be assigned to property params
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}