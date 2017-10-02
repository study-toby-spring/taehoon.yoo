package io.noep.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 4:14
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class CountingConnectionMaker implements ConnectionMaker {

    int counter = 0;
    private ConnectionMaker connectionMaker;

    public CountingConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return connectionMaker.makeNewConnection();
    }

    public int getCounter() {
        return counter;
    }
}
