package io.noep.service.sqlservice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:40
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class HashMapSqlRegistry implements SqlRegistry {

    private Map<String, String> sqlMap = new HashMap<>();

    @Override
    public String findSql(String key) throws SqlNotFoundException {
        String sql = sqlMap.get(key);
        if (sql == null) {
            throw new SqlNotFoundException(key + "를 이용해서 Sql을 찾을 수 없습니다.");
        } else {
            return sql;
        }
    }

    @Override
    public void registerSql(String key, String sql) {
        sqlMap.put(key, sql);
    }
}
