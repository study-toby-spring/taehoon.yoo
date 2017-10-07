package io.noep.service;

import io.noep.dao.UserDao;
import io.noep.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 12:56
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MockUserDao implements UserDao {

    private List<User> users;
    private List<User> updated = new ArrayList<>();

    public MockUserDao(List<User> users) {
        this.users = users;
    }

    public List<User> getUpdated() {
        return updated;
    }

    public void add(User user) {
        throw new UnsupportedOperationException();
    }

    public User get(String id) {
        throw new UnsupportedOperationException();
    }

    public List<User> getAll() {
        return this.users;
    }

    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        throw new UnsupportedOperationException();
    }

    public void update(User user) {
        updated.add(user);
    }
}