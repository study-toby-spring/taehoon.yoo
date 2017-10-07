package io.noep.service;

import io.noep.domain.User;

import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 6.
 * Time  : 오후 8:05
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface UserService {

    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    void update(User user);
    void upgradeLevels() throws Exception;
}
