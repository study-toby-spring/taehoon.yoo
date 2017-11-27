package io.noep.service.sqlservice;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:06
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 왜 없지, 그래서 하나 만듦
 */
public class SqlUpdateFailureException extends RuntimeException {

    public SqlUpdateFailureException(String message) {
        super(message);
    }
}
