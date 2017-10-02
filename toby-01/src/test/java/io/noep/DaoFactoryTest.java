package io.noep;

import io.noep.dao.factory.DaoFactory;
import io.noep.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 3:36
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class DaoFactoryTest {

    /**
     * 매번 new 예약어로 실행되므로 같은 값을 가진
     * 동일한 오브젝트가 2개 생성
     */
    @Test
    public void test() {
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);
        System.out.println(dao1 == dao2);
        System.out.println(dao1.equals(dao2));
        assertThat(dao1, not(dao2));
    }

    @Test
    public void test2() {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao3 = context.getBean("userDao", UserDao.class);
        UserDao dao4 = context.getBean("userDao", UserDao.class);

        System.out.println(dao3);
        System.out.println(dao4);
        System.out.println(dao3 == dao4);
        System.out.println(dao3.equals(dao4));
        assertThat(dao3, is(dao4));
    }

}
