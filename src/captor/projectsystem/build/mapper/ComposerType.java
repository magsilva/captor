//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.11.07 at 11:59:56 GMT-03:00 
//


package captor.projectsystem.build.mapper;


/**
 * Java content class for composerType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/Dev/Captor/dev/scripts/jaxb/RULES.XSD line 6)
 * <p>
 * <pre>
 * &lt;complexType name="composerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="main" type="{}mainType"/>
 *         &lt;element name="tasks" type="{}tasksType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ComposerType {


    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link captor.projectsystem.build.mapper.TasksType}
     */
    captor.projectsystem.build.mapper.TasksType getTasks();

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link captor.projectsystem.build.mapper.TasksType}
     */
    void setTasks(captor.projectsystem.build.mapper.TasksType value);

    /**
     * Gets the value of the main property.
     * 
     * @return
     *     possible object is
     *     {@link captor.projectsystem.build.mapper.MainType}
     */
    captor.projectsystem.build.mapper.MainType getMain();

    /**
     * Sets the value of the main property.
     * 
     * @param value
     *     allowed object is
     *     {@link captor.projectsystem.build.mapper.MainType}
     */
    void setMain(captor.projectsystem.build.mapper.MainType value);

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getName();

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setName(java.lang.String value);

}
