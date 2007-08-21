/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import captor.domainsystem.FormType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.domainsystem.metamodelvalidator.semanticValidator.SemanticValidatorUtil;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class ExtendsPart extends Part {

    public ExtendsPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormType pt)  {
        String id = pt.getExtends();
        SemanticValidatorUtil.validateExtendsId(id, vr);
        
        if ( id != null )  {
            if ( d.getFormById(id) == null )  {
                vr.ident();
                vr.newLine();
                vr.appendBuffer("- Error       : Extends tag validation error.");
                vr.appendBuffer("- Source error: the tag value id '" + id + " has a error.");
                vr.appendBuffer("-               there is no form with this id in the meta-model.");
                vr.appendBuffer("- Correction  : Remove or correct the id value.");
                vr.newLine();
                vr.appendBuffer("- Example  : ");
                vr.appendBuffer("-                <extends>1.1</extends>");
                vr.appendBuffer("-                <extends>3.3</extends>");
                vr.newLine();
                vr.setSuccess(false);
                vr.dident();
                return;
            }
        }
        
    }

}
