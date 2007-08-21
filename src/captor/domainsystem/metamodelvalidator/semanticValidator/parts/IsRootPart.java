/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import java.util.Iterator;
import java.util.List;

import captor.domainsystem.FormType;
import captor.domainsystem.FormsType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class IsRootPart extends Part {

    public IsRootPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }

    public void check(FormsType pts)  {
        vr.ident();
        vr.appendBuffer("Validating root form from meta-model.");
        vr.dident();
        
        List patternList = pts.getForm();
        if ( patternList == null )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("There are no forms in the meta-model.");
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
//        Vector v = new Vector();
        vr.ident();
        int isRoot = 0;
        for(Iterator it1 = patternList.iterator(); it1.hasNext();) {
            FormType pt = (FormType) it1.next();
            
            if ( pt.isIsRoot() )  {
                isRoot++;
            }
        }
        
        if ( isRoot > 1 )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There are " + isRoot + " forms with the flag isRoot=\"true\"");
            vr.appendBuffer("- Correction: Use only one form with flag isRoot=\"true\".");
            vr.newLine();
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
        if ( isRoot < 1 )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There are no form with the flag isRoot=\"true\"");
            vr.appendBuffer("- Correction: Use only one form with flag isRoot=\"true\".");
            vr.newLine();
            vr.appendBuffer("- Example: ");
            vr.appendBuffer("-     <form isRoot=\"true\">");
            vr.appendBuffer("-        ....");
            vr.appendBuffer("-     </form>");
            vr.newLine();
            vr.dident();
            vr.setSuccess(false);
            return;
        }

        vr.dident();
        
        vr.ident();
        vr.appendBuffer("Validating root form from meta-model. - OK.");
        vr.newLine();
        vr.dident();
    }
    
}
