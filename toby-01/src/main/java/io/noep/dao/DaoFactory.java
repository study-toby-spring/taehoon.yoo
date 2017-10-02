package io.noep.dao;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 1:07
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class DaoFactory {

    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
