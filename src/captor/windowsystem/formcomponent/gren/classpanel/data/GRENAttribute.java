package captor.windowsystem.formcomponent.gren.classpanel.data;



/**
 * @author Kicho
 *
 */
public class GRENAttribute {

    String name, type;
    int lenght;
    boolean attSystem;
    
    public GRENAttribute() {
        name = "";
        type = "";
        lenght = 0;
    }

    public GRENAttribute(String name, String type, int lenght) {
        this.name = name;
        this.type = type;
        this.lenght = lenght;
    }
    
    /**
     * @return Returns the attSystem.
     */
    public boolean isAttSystem() {
        return attSystem;
    }
    
    /**
     * @param attSystem The attSystem to set.
     */
    public void setAttSystem(boolean attSystem) {
        this.attSystem = attSystem;
    }
    //-------------------------------------------------------------------------


    /**
     * @return Returns the lenght.
     */
    public int getLenght() {
        return lenght;
    }
    /**
     * @param lenght The lenght to set.
     */
    public void setLenght(int lenght) {
        this.lenght = lenght;
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
        this.type = type;
    }
    
    public String toString()  {
        return name;
    }
    
    //-------------------------------------------------------------------------
    
    public GRENAttribute getCopy()  {
        String nname = new String(name);
        String ttype = new String(type);
        int llenght = new Integer(lenght).intValue();
        
        return new GRENAttribute(nname, ttype, llenght);
    }
    
}
