/*
 *
 */
package captor.windowsystem.preferences;

/**
 * @author Kicho
 *
 */
public class LookFeelType {
    
    private String name;
    private String id;
    
    public LookFeelType(String name, String id)  {
        this.name = name;
        this.id = id;
    }
    
    public String toString()  {
        return name;
    }
    
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }
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
}
