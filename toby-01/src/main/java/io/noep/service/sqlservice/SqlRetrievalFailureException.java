package io.noep.service.sqlservice;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 28.
 * Time  : 오후 3:31
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class SqlRetrievalFailureException extends RuntimeException {

    public SqlRetrievalFailureException(String message) {
        super(message);
    }

    public SqlRetrievalFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
