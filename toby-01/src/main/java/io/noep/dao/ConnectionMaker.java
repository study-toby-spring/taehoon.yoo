package io.noep.dao;

import java.sql.Connection;
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
public interface ConnectionMaker {

    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
