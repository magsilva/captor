//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.09.30 at 03:11:36 PM BRT 
//


package captor.projectsystem.build.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import captor.projectsystem.build.mapper.CallTaskType;
import captor.projectsystem.build.mapper.ForEachType;
import captor.projectsystem.build.mapper.IfType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "for-EachType", propOrder = {
    "callTask",
    "_if",
    "forEach"
})
public class ForEachTypeImpl
    implements ForEachType
{

    @XmlElement(type = CallTaskTypeImpl.class)
    protected List<CallTaskType> callTask;
    @XmlElement(name = "if", type = IfTypeImpl.class)
    protected List<IfType> _if;
    @XmlElement(name = "for-each", type = ForEachTypeImpl.class)
    protected List<ForEachType> forEach;
    @XmlAttribute
    protected String select;

    public List<CallTaskType> getCallTask() {
        if (callTask == null) {
            callTask = new ArrayList<CallTaskType>();
        }
        return this.callTask;
    }

    public List<IfType> getIf() {
        if (_if == null) {
            _if = new ArrayList<IfType>();
        }
        return this._if;
    }

    public List<ForEachType> getForEach() {
        if (forEach == null) {
            forEach = new ArrayList<ForEachType>();
        }
        return this.forEach;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String value) {
        this.select = value;
    }

}
