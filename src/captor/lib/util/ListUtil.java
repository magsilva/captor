/*
 *
 */
package captor.lib.util;

import java.util.Iterator;
import java.util.List;

/**
 * @author Kicho
 *
 */
public class ListUtil {

    /**
     *
     */
    public ListUtil() {
    }
    
    public static List join(List l1, List l2)  {
        for(Iterator it = l2.iterator(); it.hasNext();) {
			l1.add(it.next());
        }
        
        return l1;
    }

}
