package io.noep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:42
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class SimpleConnectionMaker {

    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        /**
         * ref : https://slipp.net/questions/276
         * Class.forName 을 실행하는 경우 문자열로 전달되는 클래스가 메모리 상에 등록된다.
         * 'com.mysql.jdbc.Driver 가 메모리에 로드되면서 static 절이 실행된다.
         * 이후 DriverManager에 드라이버 등록 메소드를 수행하는 것을 알 수 있다
         */

        /**
         * 라고 생각했는데, java1.6 이상부터는 서비스로더 기반으로 JDBC Driver가 자동으로 등록된다고 한다
         * 그래서 해당 코드를 호출하지 않아도 돌아간다.
         */
        //Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/toby-test", "root", null);
        return c;
    }

}
