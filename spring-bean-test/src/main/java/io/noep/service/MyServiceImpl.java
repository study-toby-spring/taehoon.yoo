package io.noep.service;

import io.noep.domain.MyUser;
import org.springframework.stereotype.Service;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 3:29
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : myService의 테스트용 구현체 1, 사용자가 요청한 id를 반환합니다.
 */
@Service
public class MyServiceImpl implements MyService {

    public MyUser findById(long id) {
        MyUser myUser = new MyUser();
        myUser.setId(id);
        myUser.setName("nameTest" + id);
        myUser.setEmail("emailTest" + id);
        return myUser;
    }
}
