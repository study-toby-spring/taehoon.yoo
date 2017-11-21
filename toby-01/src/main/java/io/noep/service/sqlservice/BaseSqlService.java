package io.noep.service.sqlservice;

import javax.annotation.PostConstruct;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:38
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class BaseSqlService implements SqlService {

    protected SqlReader sqlReader;
    protected SqlRegistry sqlRegistry;

    public void setSqlReader(SqlReader sqlReader) {
        this.sqlReader = sqlReader;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    @PostConstruct
    public void loadSql() {
        this.sqlReader.read(this.sqlRegistry);
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        try {
            return this.sqlRegistry.findSql(key);
        } catch (SqlNotFoundException e) {
            throw new SqlRetrievalFailureException(e);
        }
    }
}
