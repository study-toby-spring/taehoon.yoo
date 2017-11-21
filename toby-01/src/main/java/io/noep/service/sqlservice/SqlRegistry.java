package io.noep.service.sqlservice;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:02
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface SqlRegistry {

    void registerSql(String key, String sql);

    String findSql(String key) throws SqlNotFoundException;
}
