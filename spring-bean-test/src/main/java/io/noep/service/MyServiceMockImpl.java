package io.noep.service;

import io.noep.domain.MyUser;
import org.springframework.stereotype.Service;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 3:30
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */

@Service
public class MyServiceMockImpl implements MyService {

    public MyUser findById(long id) {

        MyUser myUser = new MyUser();
        myUser.setId(1);
        myUser.setName("taehoon");
        myUser.setEmail("noep@naver.com");
        return myUser;
    }
}
