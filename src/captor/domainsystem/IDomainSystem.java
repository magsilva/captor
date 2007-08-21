/*
*
*/
package captor.domainsystem;

import java.util.Vector;

/**
* @author Kicho
*
*/
public interface IDomainSystem {

   public void loadGuiDomain(String path);    
   public Vector getVariantByForm(String name);
   public FormType getFormById(String id);
   public boolean compareId(String id1, String id2);
   public boolean containId(Vector v, String id);
   public String extendsMechanism(Forms p);
}
