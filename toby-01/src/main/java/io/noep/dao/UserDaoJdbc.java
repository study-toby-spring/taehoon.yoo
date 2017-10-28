package io.noep.dao;

import io.noep.domain.Level;
import io.noep.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 2.
 * Time  : 오후 12:06
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 6점 대 mysql driver를 쓰면 패키지 구조가 바뀐다
 */
public class UserDaoJdbc implements UserDao {

    private String sqlAdd;

    private RowMapper<User> userMapper = (resultSet, i) -> {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setLevel(Level.valueOf(resultSet.getInt("level")));
        user.setLogin(resultSet.getInt("login"));
        user.setRecommend(resultSet.getInt("recommend"));
        user.setEmail(resultSet.getString("email"));
        return user;
    };

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setSqlAdd(String sqlAdd) {
        this.sqlAdd = sqlAdd;
    }

    /**
     * 로컬 클래스를 만들어서 클래스 수를 줄인다
     *
     * @param user
     * @throws SQLException
     */
    public void add(User user) {

        this.jdbcTemplate.update(sqlAdd,
                user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail());
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public User get(String id) {

        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id}, userMapper);
    }

    public int getCount() {
        return this.jdbcTemplate.query(
                "select count(*) from users",
                resultSet -> {
                    resultSet.next();
                    return resultSet.getInt(1);
                });
    }

    public void update(User user) {
        this.jdbcTemplate.update(
                "update users set name = ?, password = ?, " +
                        "level = ?, login = ?, recommend = ?, email = ? where id = ? ",
                user.getName(), user.getPassword(),
                user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail(),
                user.getId());

    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id", userMapper);
    }
}
