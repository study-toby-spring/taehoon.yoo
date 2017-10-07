package io.noep.factorybean;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 2:42
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 생성자를 제공하지 않는 클래스
 */
public class Message {

    String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }
}
