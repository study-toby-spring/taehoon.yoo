package io.noep.service.sqlservice;

import java.util.Map;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:02
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface UpdatableSqlRegistry extends SqlRegistry {

    void updateSql(String key, String sql) throws SqlUpdateFailureException;

    void updateSql(Map<String,String> sqlmap) throws SqlUpdateFailureException;
}
