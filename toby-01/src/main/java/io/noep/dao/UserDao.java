package io.noep.dao;

import io.noep.domain.User;

import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 3.
 * Time  : 오후 10:43
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
}
