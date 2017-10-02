package io.noep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.either;
import static org.junit.Assert.assertTrue;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 6:23
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : junit 자신에 대한 테스트2 xml 컨텍스트 이용
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JUnitTest2 {

    @Autowired
    ApplicationContext context;

    static Set<JUnitTest2> testObjectSet = new HashSet<JUnitTest2>();
    static ApplicationContext contextObject = null;

    @Test
    public void test1(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);

        assertThat(contextObject == null || contextObject == this.context, is(true));
        contextObject = this.context;
    }

    @Test
    public void test2(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);

        assertTrue(contextObject == null || contextObject == this.context);
        contextObject = this.context;
    }

    @Test
    public void test3(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);

        // todo either deprecated됨 되는걸로 고치자
        assertThat(contextObject,
                either(is(nullValue())).or(is(this.contextObject)));
        contextObject = this.context;
    }
}
