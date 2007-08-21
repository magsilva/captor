package fwslib;

import java.util.Vector;

import fws.FWS;


/**
 * @author Kicho
 *
 */
public class DataBanker {

    private static Vector v = new Vector();
    
    //-------------------------------------------------------------------------
    
    public static void init()  {
        for ( int i = 0; i < FWS.HistoryLenght; i++ )  {
            v.addElement(new SensorReading(0, 1,0));
        }
    }

    //-------------------------------------------------------------------------

    public static synchronized void write(SensorReading r)  {
        v.removeElementAt(0);
        v.addElement(new SensorReading(r.getId(), r.res, r.value));
    }
    
    //-------------------------------------------------------------------------
    
    public static synchronized Vector read()  {
        return (Vector) v.clone();
    }
    
    //-------------------------------------------------------------------------
}
