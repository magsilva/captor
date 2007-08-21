package fwslib;

import java.util.Vector;

import fws.FWS;


/**
 * @author Kicho
 *
 */
public class Averager {

    public static int get()  {
        Vector v = DataBanker.read();
        int valueSum = 0;
        int weightSum = 0;
        
        for (int i = 0; i < v.size(); i++ )  {
            SensorReading r = (SensorReading) v.elementAt(i);
            
            int weigth;
            if ( r.res == SensorReading.LowRes )
                weigth = FWS.LowResWeight;
            else
                weigth = FWS.HighResWeight;
            
            valueSum += r.value * weigth;
            weightSum += weigth;
        }
        
        return valueSum/weightSum;
        
    }

}
