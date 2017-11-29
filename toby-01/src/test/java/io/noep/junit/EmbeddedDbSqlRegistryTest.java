package io.noep.junit;

import io.noep.service.sqlservice.ConcurrentHashMapSqlRegistry;
import io.noep.service.sqlservice.UpdatableSqlRegistry;
import io.noep.service.sqlservice.updatable.EmbeddedDbSqlRegistry;
import org.junit.After;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

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

    @After
    public void tearDown() {
        db.shutdown();
    }
}
