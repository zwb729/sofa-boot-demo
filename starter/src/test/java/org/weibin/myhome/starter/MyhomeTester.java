/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.weibin.myhome.biz.shared.engine.ServiceEngine;
import org.weibin.myhome.biz.shared.model.common.ServiceContext;
import org.weibin.myhome.biz.shared.model.common.ServiceResult;

import com.alipay.sofa.runtime.api.annotation.SofaReference;

/**
 *
 * @author weibin
 * @version $Id: test.java, v 0.1 2018-07-30 16:42 weibin Exp $
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyhomeTester {

    @SofaReference
    private ServiceEngine serviceEngine;

    @Test
    public void test() {
        ServiceContext context = new ServiceContext();
        context.setServiceCode("demo");
        context.getParams().put("name", "Mr Zhang");

        ServiceResult result = serviceEngine.execute(context);
        System.out.println(result);
    }
}