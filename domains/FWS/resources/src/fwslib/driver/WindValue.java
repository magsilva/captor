package fwslib.driver;

/**
 * @author Kicho
 *
 */
public class WindValue {

    private boolean hasRead = false;
    private String value = "";
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the hasRead.
     */
    public synchronized boolean isRead() {
        return hasRead;
    }
    /**
     * @param hasRead The hasRead to set.
     */
    public synchronized void setRead(boolean hasRead) {
        this.hasRead = hasRead;
    }
    /**
     * @return Returns the value.
     */
    public synchronized String getValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public synchronized void setValue(String value) {
        this.value = value;
    }
    
    //-------------------------------------------------------------------------
}
