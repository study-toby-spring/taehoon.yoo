package io.noep.dao;

import io.noep.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:06
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 6점 대 mysql driver를 쓰면 패키지 구조가 바뀐다
 */
public class UserDao {

    private DataSource dataSource;
    private JdbcContext jdbcContext;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    /**
     * 로컬 클래스를 만들어서 클래스 수를 줄인다
     *
     * @param user
     * @throws SQLException
     */
    public void add(User user) throws SQLException {

        this.jdbcTemplate.update("insert into users(id,name,password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll() throws SQLException {
        this.jdbcTemplate.update("delete from users");
    }

    public User get(String id) throws SQLException {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id}, (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                });
    }

    public int getCount() {
        return this.jdbcTemplate.query(
                "select count(*) from users",
                resultSet -> {
                    resultSet.next();
                    return resultSet.getInt(1);
                });
    }


}
