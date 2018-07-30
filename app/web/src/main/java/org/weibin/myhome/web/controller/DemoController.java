/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.weibin.myhome.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weibin.myhome.web.model.JsonResponse;
import org.weibin.myhome.web.util.JsonExecTemplate;

/**
 *
 * @author weibin
 * @version $Id: DemoController.java, v 0.1 2018-07-30 10:42 weibin Exp $
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/demo.json", method = { RequestMethod.GET,
                                                     RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResponse doIndex(HttpServletRequest request) {
        return JsonExecTemplate.execute(() -> {
            String name = request.getParameter("name");
            return "Hello, " + name;
        });
    }
}