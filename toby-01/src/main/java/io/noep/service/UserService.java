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

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_LOGCOUNT_FOR_GOLD = 30;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevels() throws IllegalAccessException {
        List<User> users = userDao.getAll();

        for (User user : users) {
            if (canUpgradeLevel(user)) {
                upgradeLevel(user);
            }
        }
    }

    private void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

    private boolean canUpgradeLevel(User user) throws IllegalAccessException {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC:
                return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_LOGCOUNT_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalAccessException("Unknown Level: " + currentLevel);
        }
    }


    public void add(User user) {
        if (user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
