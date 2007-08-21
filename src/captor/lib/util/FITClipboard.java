package captor.lib.util;

import java.util.Hashtable;

/**
 * A Clipboard object for transfer area activities.
 * 
 * @author Kicho
 *
*/
public class FITClipboard {

   Hashtable table;
   
   public FITClipboard()  {
       table = new Hashtable();
   }
   
   //-------------------------------------------------------------------------

   /**
    * @return Returns the obj.
    */
   public synchronized Object get(String key) {
       return table.get(key);
   }
   /**
    * @param obj The obj to set.
    */
   public synchronized void put(String key, Object obj) {
       if ( table!= null && key != null && obj != null )
           table.put(key, obj);
   }
   
   //-------------------------------------------------------------------------
}
