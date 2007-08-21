package fwslib;

/**
 * @author Kicho
 *
 */
public class SensorReading {

    public static final int LowRes = 0;
    public static final int HighRes = 1;
    
    private int id;
    public int res;
    public int value;
    
    public SensorReading(int id, int r, int v) {
        this.id = id;
        this.res = r;
        this.value = v;
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    //-------------------------------------------------------------------------
}
