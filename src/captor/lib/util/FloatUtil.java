/*
 *
 */
package captor.lib.util;

public class FloatUtil {

    public static boolean isFloat(String s)  {
            try {
                Float i = new Float(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
    }

}
