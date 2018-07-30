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
 * @version $Id: ServiceProcessor.java, v 0.1 2018-07-30 15:03 weibin Exp $
 */
public interface ServiceProcessor<IN extends ServiceRequest, OUT extends ServiceResult> {

    OUT process(ServiceContext context, IN request);

}