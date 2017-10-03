package io.noep.dao.factory;

import io.noep.dao.AccountDao;
import io.noep.dao.JdbcContext;
import io.noep.dao.MessageDao;
import io.noep.dao.UserDao;
import io.noep.dao.connection.ConnectionMaker;
import io.noep.dao.connection.DConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 1:07
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(datasource());
        userDao.setJdbcContext(jdbcContext());
        return userDao;
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

    @Bean
    public DataSource datasource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/toby-test");
        dataSource.setUsername("root");
        dataSource.setPassword(null);

        return dataSource;
    }

    @Bean
    public JdbcContext jdbcContext() {
        return new JdbcContext();
    }
}

