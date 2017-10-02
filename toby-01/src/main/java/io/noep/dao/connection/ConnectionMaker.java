package io.noep.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:42
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 이미 DataSource라는 데이터베이스 커넥션 연결 추상화 인터페이스가 존재,
 * 차근차근 ConnectionMaker를 걷어낸다
 */
@Deprecated
public interface ConnectionMaker {
    @Deprecated
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
