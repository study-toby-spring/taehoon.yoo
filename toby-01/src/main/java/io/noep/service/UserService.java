package io.noep.service;

import io.noep.dao.UserDao;
import io.noep.domain.Level;
import io.noep.domain.User;

import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 4.
 * Time  : 오후 7:58
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            Boolean changed = null;

            if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
                user.setLevel(Level.SILVER);
                changed = true;
            } else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
                user.setLevel(Level.GOLD);
                changed = true;
            } else if (user.getLevel() == Level.GOLD) {
                changed = false;
            } else {
                changed = false;
            }

            if (changed) {
                userDao.update(user);
            }
        }
    }


    public void add(User user) {
        if (user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
