package io.noep.service;

import io.noep.dao.UserDao;
import io.noep.domain.Level;
import io.noep.domain.User;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 4.
 * Time  : 오후 7:58
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UserService {

    private UserDao userDao;
    private DataSource dataSource;
    private PlatformTransactionManager transactionManager;

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_LOGCOUNT_FOR_GOLD = 30;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void upgradeLevels() throws Exception {
        TransactionStatus status =
                this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            List<User> users = userDao.getAll();

            for (User user : users) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }

            this.transactionManager.commit(status);
        } catch (Exception e) {
            this.transactionManager.rollback(status);
            throw e;
        }
    }

    protected void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
        sendUpgradeEmail(user);
    }

    private void sendUpgradeEmail(User user) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.ksug.org");
        Session s = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(s);
        try {
            message.setFrom(new InternetAddress("useradmin@ksug.org"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Upgrade 안내");
            message.setText("사용자님의 등급이 +"+ user.getLevel().name() + "로 업그레이드 되었습니다.");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean canUpgradeLevel(User user) throws IllegalAccessException {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC:
                return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_LOGCOUNT_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalAccessException("Unknown Level: " + currentLevel);
        }
    }


    public void add(User user) {
        if (user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
