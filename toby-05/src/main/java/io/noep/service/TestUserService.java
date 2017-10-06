package io.noep.service;

import io.noep.domain.User;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 6.
 * Time  : 오후 6:25
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class TestUserService extends UserService {
    private String id;

    public TestUserService(String id) {
        this.id = id;
    }

    @Override
    protected void upgradeLevel(User user) {
        if(user.getId().equals(this.id)) throw new TestUserServiceException();
        super.upgradeLevel(user);

    }

    static class TestUserServiceException extends RuntimeException{
    }
}
