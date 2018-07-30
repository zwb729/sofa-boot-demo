/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.web.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weibin.myhome.biz.shared.engine.ServiceEngine;
import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.common.ServiceResult;
import org.weibin.myhome.common.util.AssertUtils;
import org.weibin.myhome.common.util.exception.InnerErrorCode;
import org.weibin.myhome.web.model.JsonResponse;
import org.weibin.myhome.web.util.JsonExecTemplate;

/**
 *
 * @author weibin
 * @version $Id: GatewayController.java, v 0.1 2018-07-30 11:36 weibin Exp $
 */
@RestController
public class GatewayController {

    @SofaReference
    private ServiceEngine serviceEngine;

    @RequestMapping(value = "/gateway", method = { RequestMethod.GET,
                                                   RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResponse jsonGateway(HttpServletRequest request) {
        return JsonExecTemplate.execute(() -> {
            return this.processGatewayRequest(request);
        });
    }

    private ServiceResult processGatewayRequest(HttpServletRequest request) {
        String serviceCode = request.getParameter("service_code");
        AssertUtils.notEmpty(serviceCode, InnerErrorCode.ILLEGAL_SERVICE_CODE, "service_code非法");

        ServiceContext context = new ServiceContext();
        context.setServiceCode(serviceCode);

        Map<String, String> userParams = context.getParams();
        for (Enumeration<String> ite = request.getParameterNames(); ite.hasMoreElements();) {
            String name = ite.nextElement();
            userParams.put(name, request.getParameter(name));
        }

        return serviceEngine.execute(context);
    }

    /**
     * Setter method for property <tt>serviceEngine</tt>.
     *
     * @param serviceEngine value to be assigned to property serviceEngine
     */
    public void setServiceEngine(ServiceEngine serviceEngine) {
        this.serviceEngine = serviceEngine;
    }
}