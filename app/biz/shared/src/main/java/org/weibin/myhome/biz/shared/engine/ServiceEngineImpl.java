/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.engine;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.weibin.myhome.biz.shared.factory.ProcessorFactory;
import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.common.ServiceRequest;
import org.weibin.myhome.biz.shared.model.common.ServiceResult;
import org.weibin.myhome.biz.shared.util.RequestUtils;
import org.weibin.myhome.common.util.AssertUtils;
import org.weibin.myhome.common.util.exception.InnerErrorCode;

/**
 *
 * @author weibin
 * @version $Id: ServiceEngineImpl.java, v 0.1 2018-07-30 15:11 weibin Exp $
 */
public class ServiceEngineImpl implements ServiceEngine {

    private ProcessorFactory processorFactory;

    @Override
    public ServiceResult execute(ServiceContext context) {
        String serviceCode = context.getServiceCode();
        ServiceProcessor processor = processorFactory.getServiceProcessor(serviceCode);
        AssertUtils.notNull(processor, InnerErrorCode.CONFIG_ERROR, "cant find processor for: ",
            serviceCode);

        Class requestType = this.getRequestClass(processor);
        ServiceRequest request = RequestUtils.buildRecRequest(context, requestType);

        return processor.process(context, request);
    }

    /**
     * @param processor
     * @return
     */
    protected Class getRequestClass(ServiceProcessor processor) {

        // 取process方法的第二个参数类型
        Method[] methods = processor.getClass().getMethods();
        for (Method m : methods) {
            if (StringUtils.equals(m.getName(), "process")) {
                return m.getParameterTypes()[1];
            }
        }

        return null;

        //Type clazz = processor.getClass();
        //Type[] params = ((ParameterizedType) clazz).getActualTypeArguments();
        //
        //// 入参IN是第一个，第二个是OUT
        //return (Class) params[0];
    }

    /**
     * Setter method for property <tt>processorFactory</tt>.
     *
     * @param processorFactory value to be assigned to property processorFactory
     */
    public void setProcessorFactory(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }
}