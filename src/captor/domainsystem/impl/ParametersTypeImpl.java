//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.09.30 at 03:11:33 PM BRT 
//


package captor.domainsystem.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import captor.domainsystem.ParameterType;
import captor.domainsystem.ParametersType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametersType", propOrder = {
    "parameter"
})
public class ParametersTypeImpl
    implements ParametersType
{

    @XmlElement(type = ParameterTypeImpl.class)
    protected List<ParameterType> parameter;

    public List<ParameterType> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<ParameterType>();
        }
        return this.parameter;
    }

}
