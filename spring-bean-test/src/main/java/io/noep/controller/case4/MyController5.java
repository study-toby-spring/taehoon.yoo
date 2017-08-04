package io.noep.controller.case4;

import io.noep.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 8:48
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 속성을 이용한 빈 주입 (setter 주입)
 * 인스턴스가 생성 후에 빈 주입이 진행됨
 *  필수가 아닌 옵션의 형태의 의존성을 가질 때 사용한다
 *
 */

@Controller
@RequestMapping("/case5")
public class MyController5 {

    private MyService myService;

    @Autowired
    @Qualifier("myServiceMockImpl")
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam long id) {
        return myService.findById(id).toString();
    }
}
