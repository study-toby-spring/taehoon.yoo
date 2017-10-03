package io.noep;

import io.noep.dao.connection.CountingConnectionMaker;
import io.noep.dao.factory.CountingDaoFactory;
import io.noep.dao.UserDaoJdbc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

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

    /**
     * Java Configuration을 이용한 spring context 설정
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void test() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDaoJdbc dao = context.getBean("userDao", UserDaoJdbc.class);

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
        dao.get("whiteship");
        System.out.println("Connection counter : " + ccm.getCounter());
        dao.get("whiteship");
        System.out.println("Connection counter : " + ccm.getCounter());
    }

    /**
     * xml을 이용한 spring context 설정
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        ApplicationContext context =
                new GenericXmlApplicationContext("application-context.xml");

        UserDaoJdbc dao = context.getBean("userDao", UserDaoJdbc.class);
        System.out.println(dao.get("whiteship").toString());
    }
}
