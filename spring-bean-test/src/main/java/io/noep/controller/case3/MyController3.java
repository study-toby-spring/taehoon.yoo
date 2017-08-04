package io.noep.controller.case3;

import io.noep.service.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 8:22
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : @Inject를 이용한 Bean 주입
 */

@Controller
@RequestMapping("/case3")
public class MyController3 {

    /**
     * @Inject도 많이 안 써보기는 했는데. 타입을 먼저 확인한 뒤 빈을 주입시킵니다
     * 직접 사용해보니
     * @Inject
     * private MyService myService형태의 경우 @Autowired 때와 마찬가지로
     * NoUniqueBeanDefinitionException이 나타납니다
     */

    @Inject
    @Qualifier("myServiceImpl")
    private MyService myService;

    @Inject
    @Qualifier("myServiceMockImpl")
    private MyService myServiceMockImpl;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam long id) {
        return myService.findById(id).toString();
    }

    @RequestMapping(path = "/2", method = RequestMethod.GET)
    @ResponseBody
    public String hello2(@RequestParam long id) {
        return myServiceMockImpl.findById(id).toString();
    }
}
