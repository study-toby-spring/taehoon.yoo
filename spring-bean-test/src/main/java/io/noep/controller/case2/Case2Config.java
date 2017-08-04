package io.noep.controller.case2;

import io.noep.domain.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 8:13
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */

@Configuration
public class Case2Config {

    @Bean(name = "myServiceObject")
    public Object myUser() {
        MyUser myUser = new MyUser();
        myUser.setId(9999);
        myUser.setName("myBean");
        myUser.setEmail("my@Bea.n");
        return myUser;
    }
}
