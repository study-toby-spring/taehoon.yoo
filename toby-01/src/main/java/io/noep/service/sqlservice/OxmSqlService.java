package io.noep.service.sqlservice;

import io.noep.dao.UserDao;
import io.noep.jaxb.SqlType;
import io.noep.jaxb.Sqlmap;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 27.
 * Time  : 오후 10:02
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class OxmSqlService implements SqlService {

    private final BaseSqlService baseSqlService = new BaseSqlService();

    private final OxmSqlReader oxmSqlReader = new OxmSqlReader();

    private SqlRegistry sqlRegistry = new HashMapSqlRegistry();

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.oxmSqlReader.setUnmarshaller(unmarshaller);
    }

    public void setSqlmapFile(String sqlmapFile) {
        this.oxmSqlReader.setSqlmapFile(sqlmapFile);
    }

    public void setSqlmap(Resource resource) {
        this.oxmSqlReader.setSqlmap(resource);
    }

    @PostConstruct
    public void loadSql() {
        this.baseSqlService.setSqlReader(this.oxmSqlReader);
        this.baseSqlService.setSqlRegistry(this.sqlRegistry);

        this.baseSqlService.loadSql();
    }

    private class OxmSqlReader implements SqlReader {

        private Unmarshaller unmarshaller;
        private String sqlmapFile;
        private Resource sqlmap = new ClassPathResource("sqlmap.xml", UserDao.class);

        public void setUnmarshaller(Unmarshaller unmarshaller) {
            this.unmarshaller = unmarshaller;
        }

        public void setSqlmapFile(String sqlmapFile) {
            this.sqlmapFile = sqlmapFile;
        }

        public void setSqlmap(Resource sqlmap) {
            this.sqlmap = sqlmap;
        }

        @Override
        public void read(SqlRegistry sqlRegistry) {

            try {
                Source source = new StreamSource(sqlmap.getInputStream());


                Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(source);

                for (SqlType sql : sqlmap.getSql()) {
                    sqlRegistry.registerSql(sql.getKey(), sql.getValue());
                }

            } catch (IOException e) {
                throw new IllegalArgumentException(this.sqlmap.getFilename() + "을 가져올 수 없습니다", e);
            }
        }
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        return this.baseSqlService.getSql(key);
    }
}
