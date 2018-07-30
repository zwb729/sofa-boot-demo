/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.factory;

import java.util.HashMap;
import java.util.Map;

import org.weibin.myhome.biz.shared.engine.ServiceProcessor;

/**
 *
 * @author weibin
 * @version $Id: ProcessorFactory.java, v 0.1 2018-07-30 15:33 weibin Exp $
 */
public class ProcessorFactory {

    private Map<String, ServiceProcessor> processorMap = new HashMap<>();

    public ServiceProcessor getServiceProcessor(String serviceCode) {
        return this.processorMap.get(serviceCode);
    }

    /**
     * Setter method for property <tt>processorMap</tt>.
     *
     * @param processorMap value to be assigned to property processorMap
     */
    public void setProcessorMap(Map<String, ServiceProcessor> processorMap) {
        this.processorMap = processorMap;
    }
}