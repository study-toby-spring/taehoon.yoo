package io.noep.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:40
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 상속을 통해 확장 방법이 제공되는 UserDao, NUserDao 만 구현함
 */
public class DUserDao extends UserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }

}
