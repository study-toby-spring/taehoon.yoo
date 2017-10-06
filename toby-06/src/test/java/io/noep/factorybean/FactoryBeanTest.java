package io.noep.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 2:47
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/FactoryBeanTest-context.xml") //설정파일 이름 기본값 설정은 잘 안되는듯 함
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    /**
     * 팩토리 빈에서 대상 빈을 가져오는 경우
     */
    @Test
    public void getMessageFromFactoryBean() {
        Object message = context.getBean("message");
        assertThat(message instanceof Message, is(true));
        assertThat(((Message)message).getText(), is("Factory Bean"));
    }

    /**
     * 팩토리 빈에서 팩토리 빈을 가져오는 경우 이름 앞에 '&'를 붙인다
     */
    @Test
    public void getMessageFromFactoryBean2() {
        Object message = context.getBean("&message");
        assertThat(message instanceof MessageFactoryBean, is(true));

    }
}
