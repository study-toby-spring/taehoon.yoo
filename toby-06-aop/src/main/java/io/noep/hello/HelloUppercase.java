package io.noep.hello;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 2:18
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class HelloUppercase implements Hello {

    private Hello hello;

    public HelloUppercase(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return hello.sayThankYou(name).toUpperCase();
    }
}
