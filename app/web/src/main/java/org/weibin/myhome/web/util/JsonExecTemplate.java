/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.web.util;

import java.util.function.Supplier;

import org.weibin.myhome.web.model.JsonResponse;

/**
 *
 * @author weibin
 * @version $Id: JsonExecTemplate.java, v 0.1 2018-07-30 11:31 weibin Exp $
 */
public class JsonExecTemplate {

    public static JsonResponse execute(Supplier resultSupplier) {
        JsonResponse resp = new JsonResponse();
        try {
            Object result = resultSupplier.get();
            resp.setResult(result);

            resp.setSuccess(true);
        } catch (Exception e) {
            resp.setErrorCode("system_error");
            resp.setErrorMsg(e.getMessage());
        }

        return resp;
    }
}