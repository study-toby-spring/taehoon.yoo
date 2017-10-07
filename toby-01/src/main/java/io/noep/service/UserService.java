package io.noep.service;

import io.noep.domain.User;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public interface UserService {

    void add(User user);
    @Transactional(readOnly = true)
    User get(String id);
    @Transactional(readOnly = true)
    List<User> getAll();
    void deleteAll();
    void update(User user);
    void upgradeLevels() throws Exception;
}
