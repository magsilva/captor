package captor.windowsystem.util;
/**
 * This class represents a form path.
 * 
 * <p>
 * A form path is a string in the form: [parent|child]->id(ID) where ID is a form id.
 * </p>
 * 
 * 
 * @author Kicho
 *
 */
public class FormPathUtil  {
    
    String reference;
    String id;
    
    public FormPathUtil(String reference, String id)  {
        this.reference = reference;
        this.id = id;
    }
    
    //-------------------------------------------------------------------------
    
    public String getId() {
        return id;
    }
    public String getReference() {
        return reference;
    }
    
    //-------------------------------------------------------------------------
}