package io.noep.service.sqlservice;

import java.util.Map;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 28.
 * Time  : 오후 3:35
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class SimpleSqlService implements SqlService {

    private Map<String, String> sqlMap;

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        String sql = sqlMap.get(key);

        if (sql == null)
            throw new SqlRetrievalFailureException(key + "에 대한 sql을 찾을 수 없습니다");
        else
            return sql;
    }
}
