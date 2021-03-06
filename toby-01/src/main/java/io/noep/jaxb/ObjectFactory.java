//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.0-b170531.0717 버전을 통해 생성되었습니다. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.17 시간 09:09:22 PM KST 
//


package io.noep.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.noep.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.noep.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sqlmap }
     * 
     */
    public Sqlmap createSqlmap() {
        return new Sqlmap();
    }

    /**
     * Create an instance of {@link SqlType }
     * 
     */
    public SqlType createSqlType() {
        return new SqlType();
    }

}
