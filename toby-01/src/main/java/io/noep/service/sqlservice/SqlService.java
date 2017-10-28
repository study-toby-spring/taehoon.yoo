package io.noep.service.sqlservice;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 28.
 * Time  : 오후 3:30
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface SqlService {
    String getSql(String key) throws SqlRetrievalFailureException;
}
