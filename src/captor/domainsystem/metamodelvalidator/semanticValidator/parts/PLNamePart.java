/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import captor.domainsystem.FormsType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class PLNamePart extends Part {

    public PLNamePart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormsType pts)  {
        vr.ident();
        vr.appendBuffer("Validating form language name from meta-model.");
        vr.dident();
        
        if ( pts.getName() == null || pts.getName().trim().equals("") )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : The form language has no name.");
            vr.appendBuffer("- Correction: Give a tag name for form languagem.");
            vr.newLine();
            vr.appendBuffer("- Example: ");
            vr.newLine();
            vr.appendBuffer("           <?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
            vr.appendBuffer("           <forms>     ");
            vr.appendBuffer("                <name>GRN</name>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
        vr.ident();
        vr.appendBuffer("Validating form languagem name from meta-model - OK");
        vr.newLine();
        vr.dident();
    }
    
}
