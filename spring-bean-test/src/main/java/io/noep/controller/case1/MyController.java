package io.noep.controller.case1;

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
 * Time  : 오전 7:59
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : @Autowired 를 이용한 빈 주입 (Field Injection)
 */

@Controller
@RequestMapping("/case1")
public class MyController {

    /**
     * autowired는 하위 타입으로 선언된 bean들을 모두 주입하기 때문에
     * 아래와 같이 선언하면 예외가 나타납니다.
     * Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
     * No qualifying bean of type 'io.noep.service.MyService' available:
     * expected single matching bean but found 2: myServiceImpl,myServiceMockImpl
     * <p>
     * 따라서 @Qualifier를 이용해 대상 bean의 이름을 명시해주어야 합니다.
     */

    @Autowired
    @Qualifier("myServiceImpl")
    private MyService myService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam long id) {
        return myService.findById(1l).toString();
    }
}
