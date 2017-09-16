package io.noep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 9. 16.
 * Time  : 오전 11:55
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class PropertyPlaceholderConfigurerTest {

    @Autowired
    private TestBean testBean;

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        String foo = testBean.getFoo();
        String bar = testBean.getBar();
        System.out.println(foo + bar);

    }
}
