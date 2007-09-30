/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import captor.domainsystem.FormType;
import captor.domainsystem.FormsType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.domainsystem.metamodelvalidator.semanticValidator.SemanticValidatorUtil;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class PatternsIdsPart extends Part {

    public PatternsIdsPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormsType pts)  {
        //verificação sintática semantica
        //procurar por dois id's iguais da pau
        //procurar por ids nulos
        
        vr.ident();
        vr.appendBuffer("Validating all form id's from meta-model.");
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
        
        Vector v = new Vector();
        vr.ident();
        for(Iterator it1 = patternList.iterator(); it1.hasNext();) {
            FormType pt = (FormType) it1.next();
            
            
            //contem dois ids iguais na LP
            if ( contain(v, pt.getId()))  {
                vr.ident();
                vr.newLine();
                vr.appendBuffer("- Error     : There are two forms with the same id (" + pt.getId() + ") in the meta-model.");
                vr.appendBuffer("- Correction: Put an different id on each form in the form language.");
                vr.dident();
                vr.setSuccess(false);
                return;
            }
            
            v.add(pt.getId());
            
            SemanticValidatorUtil.validatePatternId(pt.getId(), vr);
            if ( !vr.isSuccess() )
                return;
        }
        vr.dident();
        
        vr.ident();
        vr.appendBuffer("Validating all form id's - OK.");
        vr.newLine();
        vr.dident();
    }

    //-------------------------------------------------------------------------
    
    private boolean contain(Vector v, String id)  {
        for ( int i = 0; i < v.size(); i++ )  {
            String s = (String) v.get(i);
            if ( s.equals(id) )
                return true;
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------
}
