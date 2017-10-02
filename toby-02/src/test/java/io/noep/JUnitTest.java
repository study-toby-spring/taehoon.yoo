package io.noep;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 6:23
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : junit 자신에 대한 테스트
 */
public class JUnitTest {

    static Set<JUnitTest> testObjectSet = new HashSet<JUnitTest>();

    @Test
    public void test1(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);
    }

    @Test
    public void test2(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);
    }

    @Test
    public void test3(){
        assertThat(testObjectSet, not(hasItem(this)));
        testObjectSet.add(this);
    }
}
