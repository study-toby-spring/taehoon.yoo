package io.noep.pointcut;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오후 3:49
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class Target implements TargetInterface {

    @Override
    public void hello() {
    }

    @Override
    public void hello(String a) {
    }

    @Override
    public int minus(int a, int b) throws RuntimeException {
        return 0;
    }

    @Override
    public int plus(int a, int b) {
        return 0;
    }

    public void method() {

    }
}
