//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.03 at 11:03:13 PM BRT 
//


package captor.projectsystem.build.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for for-EachType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="for-EachType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callTask" type="{}callTaskType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="if" type="{}ifType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="for-each" type="{}for-EachType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="select" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "for-EachType", propOrder = {
    "callTask",
    "_if",
    "forEach"
})
public class ForEachType {

    protected List<CallTaskType> callTask;
    @XmlElement(name = "if")
    protected List<IfType> _if;
    @XmlElement(name = "for-each")
    protected List<ForEachType> forEach;
    @XmlAttribute
    protected String select;

    /**
     * Gets the value of the callTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callTask property.
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
     * {@link CallTaskType }
     * 
     * 
     */
    public List<CallTaskType> getCallTask() {
        if (callTask == null) {
            callTask = new ArrayList<CallTaskType>();
        }
        return this.callTask;
    }

    /**
     * Gets the value of the if property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the if property.
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
     * {@link IfType }
     * 
     * 
     */
    public List<IfType> getIf() {
        if (_if == null) {
            _if = new ArrayList<IfType>();
        }
        return this._if;
    }

    /**
     * Gets the value of the forEach property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forEach property.
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
     * {@link ForEachType }
     * 
     * 
     */
    public List<ForEachType> getForEach() {
        if (forEach == null) {
            forEach = new ArrayList<ForEachType>();
        }
        return this.forEach;
    }

    /**
     * Gets the value of the select property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelect() {
        return select;
    }

    /**
     * Sets the value of the select property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelect(String value) {
        this.select = value;
    }

}
