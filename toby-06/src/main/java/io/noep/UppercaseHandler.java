package io.noep;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 2:24
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UppercaseHandler implements InvocationHandler {

    private Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ret = method.invoke(target, args);
        if (ret instanceof String && method.getName().startsWith("say")) {
            return ((String) ret).toUpperCase();
        } else {
            return ret;
        }
    }
}
