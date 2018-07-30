/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.biz.shared.engine;

import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.common.ServiceRequest;
import org.weibin.myhome.biz.shared.model.common.ServiceResult;

/**
 *
 * @author weibin
 * @version $Id: ServiceEngine.java, v 0.1 2018-07-30 15:10 weibin Exp $
 */
public interface ServiceEngine {

    /**
     * @param context
     * @param request
     * @return
     */
    ServiceResult execute(ServiceContext context);
}