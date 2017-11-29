package io.noep.junit;

import io.noep.service.sqlservice.SqlUpdateFailureException;
import io.noep.service.sqlservice.UpdatableSqlRegistry;
import io.noep.service.sqlservice.updatable.EmbeddedDbSqlRegistry;
import org.junit.After;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.HashMap;

import static org.junit.Assert.fail;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 27.
 * Time  : 오후 11:02
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class EmbeddedDbSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {

    EmbeddedDatabase db;

    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/io/noep/embedded/schema.sql")
                //.addScript("classpath:/io/noep/embedded/data.sql")
                .build();

        EmbeddedDbSqlRegistry embeddedDbSqlRegistry = new EmbeddedDbSqlRegistry();
        embeddedDbSqlRegistry.setDataSource(db);
        return embeddedDbSqlRegistry;
    }

    @Test
    public void transactionalUpdate() {
        checkFindResult("SQL1", "SQL2", "SQL3");

        HashMap<String, String> sqlmap = new HashMap<>();
        sqlmap.put("KEY1", "Modified1");
        sqlmap.put("KEY9999!@#$", "Modified9999"); // 존재하지 않는 키를 맵핑

        try {
            sqlRegistry.updateSql(sqlmap);
            fail();
        } catch (SqlUpdateFailureException e) {

        }

        checkFindResult("SQL1", "SQL2", "SQL3");
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}
