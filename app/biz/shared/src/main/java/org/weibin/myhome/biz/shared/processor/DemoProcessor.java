/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.processor;

import org.weibin.myhome.biz.shared.engine.ServiceProcessor;
import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.request.DemoRequest;
import org.weibin.myhome.biz.shared.model.result.DemoResult;

/**
 *
 * @author weibin
 * @version $Id: DemoProcessor.java, v 0.1 2018-07-30 15:43 weibin Exp $
 */
public class DemoProcessor implements ServiceProcessor<DemoRequest, DemoResult> {
    @Override
    public DemoResult process(ServiceContext context, DemoRequest request) {
        DemoResult result = new DemoResult();

        result.setEcho("Hello, " + request.getName());

        return result;
    }
}