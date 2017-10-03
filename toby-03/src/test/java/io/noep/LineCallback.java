package io.noep;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 3.
 * Time  : 오후 9:40
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
