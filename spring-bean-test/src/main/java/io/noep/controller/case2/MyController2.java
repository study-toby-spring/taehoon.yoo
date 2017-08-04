package io.noep.controller.case2;

import io.noep.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 8:09
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : @Resource를 이용한 빈 주입
 */
@Controller
@RequestMapping("/case2")
public class MyController2 {

    /**
     * @Resource는 잘 안쓰다보니 생소한데. bean의 이름을 우선적으로 찾아 주입한다고 합니다.
     * Case2Config에 선언된 Bean 을 주입해 보았습니다.
     */

    @Resource(name = "myServiceObject")
    private Object myService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam long id) {
        return myService.toString();
    }
}
