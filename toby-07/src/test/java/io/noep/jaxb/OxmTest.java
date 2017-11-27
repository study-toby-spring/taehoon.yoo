package io.noep.jaxb;

import io.noep.jaxb.SqlType;
import io.noep.jaxb.Sqlmap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 27.
 * Time  : 오후 8:54
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 *    1.jaxb로 생성된 ObjectFactory 패키지 위치를 잘 못 맞춰줘서 JAXBException 발생
 *    2.@ContextConfiguration을 자동으로 인식하게 하려면 resource위치와 패키지 위치를 맞춰주어야 한다. (resources/io/noep/jaxb/OxmTest-context.xml)
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/OxmTest-context.xml")
@ContextConfiguration
public class OxmTest {

    @Autowired
    Unmarshaller unmarshaller;

    @Test
    public void unmarshallSqlMap() throws XmlMappingException, IOException {
        Source xmlSource = new StreamSource(
                getClass().getResourceAsStream("sqlmap.xml"));

        Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(xmlSource);

        List<SqlType> sqlList = sqlmap.getSql();
        assertThat(sqlList.get(0).getKey(), is("add"));
        assertThat(sqlList.get(0).getValue(), is("insert"));
        assertThat(sqlList.get(1).getKey(), is("get"));
        assertThat(sqlList.get(1).getValue(), is("select"));
        assertThat(sqlList.get(2).getKey(), is("delete"));
        assertThat(sqlList.get(2).getValue(), is("delete"));
    }
}
