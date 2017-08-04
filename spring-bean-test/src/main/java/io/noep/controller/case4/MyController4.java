package io.noep.controller.case4;

import io.noep.service.MyService;
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
 * Desc  : 생성자를 이용한 빈 주입
 * 1. 스프링에서 권장하는 빈 주입방식
 * 2. 의존성이 생긴 인스턴스가 생성됨과 동시에 주입되므로 좀 더 안전하게 사용할 수 있다
 * 3. 의존 관계과 명확해서 누락될 시에는 컴파일 에러가 발생
 */

@Controller
@RequestMapping("/case4")
public class MyController4 {

    private final MyService myService;

    public MyController4(@Qualifier("myServiceImpl") MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam long id) {
        return myService.findById(id).toString();
    }
}
