package io.noep;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 9. 16.
 * Time  : 오전 11:16
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class TestBean {
    private String foo;
    private String bar;


    public TestBean() {

    }

    public TestBean(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
