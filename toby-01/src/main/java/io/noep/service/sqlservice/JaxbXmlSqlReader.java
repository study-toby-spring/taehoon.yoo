package io.noep.service.sqlservice;

import io.noep.dao.UserDao;
import io.noep.jaxb.SqlType;
import io.noep.jaxb.Sqlmap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 21.
 * Time  : 오후 9:43
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class JaxbXmlSqlReader implements SqlReader {

    private static final String DEFAULT_SQLMAP_FILE = "sqlmap.xml";

    private String sqlMapFile = DEFAULT_SQLMAP_FILE;

    public void setSqlMapFile(String sqlMapFile) {
        this.sqlMapFile = sqlMapFile;
    }

    @Override
    public void read(SqlRegistry sqlRegistry) {
        String contextPath = Sqlmap.class.getPackage().getName();
        try {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = UserDao.class.getResourceAsStream(this.sqlMapFile);
            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);

            for (SqlType sql : sqlmap.getSql()) {
                sqlRegistry.registerSql(sql.getKey(), sql.getValue());
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
