package captor.windowsystem.formcomponent.gren.classpanel.data;

import java.util.Vector;

/**
 * @author Kicho
 *
 */
public class GRENClass {

    String classname;
    String pluralForm;
    Vector attrs;
    
    public GRENClass() {
        classname = "";
        pluralForm = "";
        attrs = new Vector();
    }

    public void addAttr(GRENAttribute attr)  {
        attrs.add(attr);
    }
    
    public void removeAttr(GRENAttribute attr)  {
        for ( int i = 0; i < attrs.size(); i++ )  {
            if ( (GRENAttribute) attrs.get(i) == attr )  {
                attrs.remove(attr);
                return;
            }
        }
    }
    
    /**
     * @return Returns the attrs.
     */
    public Vector getAttrs() {
        return attrs;
    }
    /**
     * @param attrs The attrs to set.
     */
    public void setAttrs(Vector attrs) {
        this.attrs = attrs;
    }
    /**
     * @return Returns the classname.
     */
    public String getClassname() {
        return classname;
    }
    /**
     * @param classname The classname to set.
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }
    /**
     * @return Returns the pluralForm.
     */
    public String getPluralForm() {
        return pluralForm;
    }
    /**
     * @param pluralForm The pluralForm to set.
     */
    public void setPluralForm(String pluralForm) {
        this.pluralForm = pluralForm;
    }
    
    public GRENClass getCopy()  {
        GRENClass gc = new GRENClass();
        gc.setClassname(new String(classname));
        gc.setPluralForm(new String(pluralForm));
        
        for ( int i = 0; i < attrs.size(); i++ )  {
            GRENAttribute attr = (GRENAttribute) attrs.get(i);
            gc.addAttr(attr.getCopy());    
        }
        
        return gc;
        
    }
}
