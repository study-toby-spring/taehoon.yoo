package io.noep.pointcut;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오후 3:50
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface TargetInterface {

    void hello();
    void hello(String a);
    int minus(int a, int b) throws RuntimeException;
    int plus(int a, int b) ;
}
