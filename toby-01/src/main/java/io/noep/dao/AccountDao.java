package io.noep.dao;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 1:11
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class AccountDao {

    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
