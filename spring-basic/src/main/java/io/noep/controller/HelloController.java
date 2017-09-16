package io.noep.controller;

import io.noep.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 7. 22.
 * Time  : 오후 1:03
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Controller
public class HelloController {

    @Autowired
    private TestBean testbean;

    @RequestMapping(
            path = {"hello"},
            method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        String foo = testbean.getFoo();
        String bar = testbean.getBar();

        return foo+ bar;
    }

}
