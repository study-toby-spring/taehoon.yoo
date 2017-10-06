package io.noep.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 7.
 * Time  : 오전 12:55
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MockMailSender implements MailSender {

    private List<String> requests = new ArrayList<>();

    public List<String> getRequests() {
        return requests;
    }

    public void send(SimpleMailMessage simpleMailMessage) throws MailException {
        requests.add(simpleMailMessage.getTo()[0]);

    }

    public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

    }
}