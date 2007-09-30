/*
 *
 */
package captor.windowsystem.main.bodyPane;

import java.util.Vector;

import captor.projectsystem.xmlgen.CCBuffer;


/**
 * @author Kicho
 *
 */
public interface ICards {
    
    public abstract void updateAllElements();
    public abstract void toXML(CCBuffer out);
    public abstract boolean validateAllFields();
    public abstract Vector getFormElList();
    public abstract String toString();
    public abstract void load(org.w3c.dom.Node node);

}
