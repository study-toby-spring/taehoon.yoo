package io.noep.connection;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 8. 5.
 * Time  : 오후 12:50
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 프록시
 */
public class CountingConnector implements Connector {

    private Connector connector;
    private int count;

    public CountingConnector(Connector connector) {
        this.connector = connector;
    }


    public Connection getConnection() {
        count++;
        return this.connector.getConnection();
    }
}
