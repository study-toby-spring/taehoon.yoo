package io.noep.service;

import io.noep.dao.UserDao;
import io.noep.domain.Level;
import io.noep.domain.User;

import static io.noep.service.UserService.MIN_LOGCOUNT_FOR_GOLD;
import static io.noep.service.UserService.MIN_LOGCOUNT_FOR_SILVER;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 4.
 * Time  : 오후 8:58
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class StandardUserLevelUpgradePolicy implements UserLevelUpgradePolicy {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

    public boolean canUpgradeLevel(User user) throws IllegalAccessException {
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



}
