package io.noep.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 6.
 * Time  : 오후 7:54
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class DummyMailSender implements MailSender {

    private String host;

    public void send(SimpleMailMessage simpleMailMessage) throws MailException {

    }

    public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
