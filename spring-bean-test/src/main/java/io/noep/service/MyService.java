package io.noep.service;

import io.noep.domain.MyUser;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오전 3:24
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface MyService {

    MyUser findById(long id);
}
