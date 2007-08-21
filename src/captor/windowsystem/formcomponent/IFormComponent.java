/*
 *
 */
package captor.windowsystem.formcomponent;

import java.util.Hashtable;
import java.util.Vector;

import org.w3c.dom.Node;

import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;


/**
 * @author Kicho
 *
 */
public interface IFormComponent {
    
    public abstract String getId();
    public abstract void parseParameters();
    public abstract boolean validateParameters();
    public abstract Vector getRequiredParameters();
    public abstract boolean validateFields();
    public abstract void create();
    public abstract void load(Node node);
    public abstract void toXML(CCBuffer out);
    public abstract void updateValues();
    public abstract String getValues();
    
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract void setModel(Model model);
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract FormComponent getFormElement(String path);
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract String getErrorMsg();
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract void setParameter(String name, String value);
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract void setParameter(Hashtable parameter);
    /**
     * This method are implemented by class FormElement.
     * Form component developers doesn't need to worry with it.
     */
    public abstract Hashtable getParameter();
}
