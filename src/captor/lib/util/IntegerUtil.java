/*
 *
 */
package captor.lib.util;

public class IntegerUtil {

    public static boolean isInt(String s)  {
        try {
            Integer i = new Integer(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
