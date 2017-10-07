package io.noep.junit;

import io.noep.dao.UserDao;
import io.noep.domain.Level;
import io.noep.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 5:44
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-02.xml")
public class UserDaoTest2 {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    /**
     * 픽스처 : 테스트를 수행하는 데 필요한 정보나 오브젝트
     */
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        /**
         * 클래스 인스턴스는 매번 초기화되지만, applicationContext는 매번 동일하
         */
        System.out.println(this.context);
        System.out.println(this);

        this.user1 = new User("gyumee", "박성철", "springno1", Level.BASIC, 1, 0, "a@b.c");
        this.user2 = new User("orange", "오렌지", "ihaveanorange", Level.SILVER, 55, 10,"d@e.f");
        this.user3 = new User("pineapple", "파인애플", "ihaveapineapple", Level.GOLD, 100, 40, "g@h.i");

    }

    @Test
    public void addAndGet() throws SQLException {

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        User userget1 = userDao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = userDao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.get("unknown_id");
    }

    @Test
    public void count() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));
    }

    @Test
    public void getAll() throws IOException {
        userDao.deleteAll();


        List<User> users0 = userDao.getAll();
        assertThat(users0.size(), is(0));

        userDao.add(user1);

        List<User> users1 = userDao.getAll();
        assertThat(users1.size(), is(1));
        checkSameUser(user1, users1.get(0));

        userDao.add(user2);

        List<User> users2 = userDao.getAll();
        assertThat(users2.size(), is(2));
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));


        userDao.add(user3);

        List<User> users3 = userDao.getAll();
        assertThat(users3.size(), is(3));
        checkSameUser(user1, users3.get(0));
        checkSameUser(user2, users3.get(1));
        checkSameUser(user3, users3.get(2));

    }

    @Test(expected = DataAccessException.class)
    public void duplicateKey() {
        userDao.deleteAll();

        userDao.add(user1);
        userDao.add(user1);
    }

    @Test
    public void sqlExceptionTranslate() {
        userDao.deleteAll();

        try {
            userDao.add(user1);
            userDao.add(user1);
        } catch (DuplicateKeyException ex) {
            SQLException sqlEx = (SQLException) ex.getRootCause();
            SQLExceptionTranslator set =
                    new SQLErrorCodeSQLExceptionTranslator(this.dataSource);

            assertThat(set.translate(null, null, sqlEx) instanceof DuplicateKeyException, is(true));
        }

    }

    @Test
    public void update() {
        userDao.deleteAll();

        userDao.add(user1);
        userDao.add(user2);

        user1.setName("오민규");
        user1.setPassword("springno6");
        user1.setLevel(Level.GOLD);
        user1.setRecommend(999);

        userDao.update(user1);

        User user1update = userDao.get(user1.getId());
        checkSameUser(user1, user1update);

        User user2same = userDao.get(user2.getId());
        checkSameUser(user2, user2same);
    }

    private void checkSameUser(User user1, User user2) {
        assertThat(user1.getId(), is(user2.getId()));
        assertThat(user1.getName(), is(user2.getName()));
        assertThat(user1.getPassword(), is(user2.getPassword()));
        assertThat(user1.getLevel(), is(user2.getLevel()));
        assertThat(user1.getLogin(), is(user2.getLogin()));
        assertThat(user1.getRecommend(), is(user2.getRecommend()));
        assertThat(user1.getEmail(), is(user2.getEmail()));
    }


}
