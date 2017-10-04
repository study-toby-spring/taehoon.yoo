package io.noep.service;

import io.noep.domain.User;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 4.
 * Time  : 오후 8:56
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface UserLevelUpgradePolicy {

    boolean canUpgradeLevel(User user) throws IllegalAccessException;
    void upgradeLevel(User user);
}
