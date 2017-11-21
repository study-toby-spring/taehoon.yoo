package io.noep.service.sqlservice;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:50
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class DefaultSqlService extends BaseSqlService {

    public DefaultSqlService() {
        setSqlReader(new JaxbXmlSqlReader());
        setSqlRegistry(new HashMapSqlRegistry());
    }

}
