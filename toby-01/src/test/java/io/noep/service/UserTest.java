package io.noep.service;

import io.noep.domain.Level;
import io.noep.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 4.
 * Time  : 오후 8:46
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void upgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() == null) continue;
            user.setLevel(level);
            user.upgradeLevel();
            assertThat(user.getLevel(), is(level.nextLevel()));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void cannotUpgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() != null) continue;
            user.setLevel(level);
            user.upgradeLevel();
        }
    }
}
