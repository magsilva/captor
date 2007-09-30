/*
 *
 */
package captor.windowsystem.formcomponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import captor.lib.util.FloatUtil;
import captor.lib.util.IntegerUtil;

public class Parameter {

    private String name, value, type, defaultValue, description, regexp;
    private boolean required;

    private String errorMessage;
    
    public Parameter(String name, String type, String value, String defaultValue, String description, String regexp, boolean required) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.defaultValue = defaultValue;
        this.regexp = regexp;
        this.required = required;
        this.description = description;
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
     * @return Returns the regexp.
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * @param regexp The regexp to set.
     */
    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    /**
     * @return Returns the required.
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required The required to set.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type to set.
     */
    public void setType(String type) {
        
        if (   !(type.toLowerCase().equals("string")
                || type.toLowerCase().equals("int") 
                || type.toLowerCase().equals("float")
                || type.toLowerCase().equals("boolean")
                || type.toLowerCase().equals("anytype"))
            )
            throw new RuntimeException("Invalid parameter type.");
        
        this.type = type;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @return Returns the defaultValue.
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue The defaultValue to set.
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Returns the errorMessage.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage The errorMessage to set.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    //-------------------------------------------------------------------------
    
    public boolean validate()  {
        
        if ( required == true && value == null )  {
            errorMessage = "The parameter " + name + " is required but it has no value.";
            return false;
        }
        
        if ( required == true && value.equals("") )  {
            errorMessage = "The parameter " + name + " is required but it has no value.";
            return false;
        }
        
        if ( type.toLowerCase().equals("int") )  {
            if ( !IntegerUtil.isInt(value) )  {
                errorMessage = "The parameter " + name + " must have a integer format.";
                return false;
            }
        }

        if ( type.toLowerCase().equals("float") )  {
            if ( !FloatUtil.isFloat(value) )  {
                errorMessage = "The parameter " + name + " must have a float format.";
                return false;
            }
        }

        if ( type.toLowerCase().equals("boolean") )  {
            if ( !(value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) )  {
                errorMessage = "The parameter " + name + " must have a boolean format.";
                return false;
            }
        }
         
        if ( regexp != null && !regexp.equals("") )  {
            Pattern p = Pattern.compile(regexp);
            Matcher m = p.matcher(value);
            
            if ( !m.matches() )  {
                errorMessage = "The parameter " + name + " doesn't match the regular expression: " + regexp + ".";
                return false;
            }
            
        }

        return true;
    }

    //-------------------------------------------------------------------------
}
