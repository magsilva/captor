//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.11.07 at 11:59:56 GMT-03:00 
//


package captor.projectsystem.build.mapper;


/**
 * Java content class for mainType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/Dev/Captor/dev/scripts/jaxb/RULES.XSD line 18)
 * <p>
 * <pre>
 * &lt;complexType name="mainType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callTask" type="{}callTaskType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="if" type="{}ifType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="for-each" type="{}for-EachType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface MainType {


    /**
     * Gets the value of the ForEach property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ForEach property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForEach().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link captor.projectsystem.build.mapper.ForEachType}
     * 
     */
    java.util.List getForEach();

    /**
     * Gets the value of the If property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the If property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link captor.projectsystem.build.mapper.IfType}
     * 
     */
    java.util.List getIf();

    /**
     * Gets the value of the CallTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the CallTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link captor.projectsystem.build.mapper.CallTaskType}
     * 
     */
    java.util.List getCallTask();

}
