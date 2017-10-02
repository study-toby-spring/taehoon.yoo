package io.noep;

import io.noep.dao.CountingConnectionMaker;
import io.noep.dao.CountingDaoFactory;
import io.noep.dao.UserDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 4:26
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UserDaoConnectionCountingTest {

    @Test
    public void test() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
        dao.get("whiteship");
        System.out.println("Connection counter : " + ccm.getCounter());
        dao.get("whiteship");
        System.out.println("Connection counter : " + ccm.getCounter());




    }
}
