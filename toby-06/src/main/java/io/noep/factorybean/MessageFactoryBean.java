package io.noep.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 2:43
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MessageFactoryBean implements FactoryBean<Message> {
    String text;

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public Message getObject() throws Exception {
        return Message.newMessage(this.text);
    }

    @Override
    public Class<?> getObjectType() {
        return Message.class;
    }

    @Override // 팩토리 빈이 싱글턴이냐? -> X, 팩토리 빈을 통해 만들어진 빈은 싱글톤으로 관리한다
    public boolean isSingleton() {
        return false;
    }
}
