//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.03 at 11:03:12 PM BRT 
//


package captor.domainsystem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the captor.domainsystem package. 
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

    private final static QName _Forms_QNAME = new QName("", "forms");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: captor.domainsystem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FormComponentsType }
     * 
     */
    public FormComponentsType createFormComponentsType() {
        return new FormComponentsType();
    }

    /**
     * Create an instance of {@link NextFormsType }
     * 
     */
    public NextFormsType createNextFormsType() {
        return new NextFormsType();
    }

    /**
     * Create an instance of {@link ParameterType }
     * 
     */
    public ParameterType createParameterType() {
        return new ParameterType();
    }

    /**
     * Create an instance of {@link FormType }
     * 
     */
    public FormType createFormType() {
        return new FormType();
    }

    /**
     * Create an instance of {@link FormComponentType }
     * 
     */
    public FormComponentType createFormComponentType() {
        return new FormComponentType();
    }

    /**
     * Create an instance of {@link NextFormType }
     * 
     */
    public NextFormType createNextFormType() {
        return new NextFormType();
    }

    /**
     * Create an instance of {@link ParametersType }
     * 
     */
    public ParametersType createParametersType() {
        return new ParametersType();
    }

    /**
     * Create an instance of {@link FormsType }
     * 
     */
    public FormsType createFormsType() {
        return new FormsType();
    }

    /**
     * Create an instance of {@link OrType }
     * 
     */
    public OrType createOrType() {
        return new OrType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "forms")
    public JAXBElement<FormsType> createForms(FormsType value) {
        return new JAXBElement<FormsType>(_Forms_QNAME, FormsType.class, null, value);
    }

}
