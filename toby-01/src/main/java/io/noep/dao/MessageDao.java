package io.noep.dao;

import io.noep.dao.connection.ConnectionMaker;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 1:11
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MessageDao {

    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

}
