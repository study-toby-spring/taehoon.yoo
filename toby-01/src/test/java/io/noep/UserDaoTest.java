package io.noep;

import io.noep.dao.DaoFactory;
import io.noep.dao.UserDao;
import io.noep.domain.User;

import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:12
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("유태훈");
        user.setPassword("single");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
