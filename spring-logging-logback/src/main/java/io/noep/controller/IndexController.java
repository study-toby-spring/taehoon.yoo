package io.noep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 19.
 * Time  : 오후 12:15
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */

@RequestMapping("/")
public class IndexController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "hello";

    }
}
