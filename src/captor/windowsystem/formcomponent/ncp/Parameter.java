/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

public class Parameter {

    String name, value;
    boolean mandatory;
    
    public Parameter() {
        this.name = "";
        this.value = "";
        mandatory = false;
    }
    
    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
        mandatory = false;
    }

    //-------------------------------------------------------------------------

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the mandatory.
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * @param mandatory The mandatory to set.
     */
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
    
    //-------------------------------------------------------------------------
}
