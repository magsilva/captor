/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import java.util.Iterator;
import java.util.List;

import captor.domainsystem.FormType;
import captor.domainsystem.NextFormType;
import captor.domainsystem.NextFormsType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.domainsystem.metamodelvalidator.semanticValidator.SemanticValidatorUtil;
import captor.lib.util.IntegerUtil;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class NextPatternsPart extends Part {
    
    public NextPatternsPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormType pt)  {
        
        NextFormsType npst = pt.getNextForms();
        if ( npst != null )  {
            vr.ident();
            vr.appendBuffer("Validating nextForm tag:");
            List nplist = npst.getNextForm();
            for(Iterator it1 = nplist.iterator(); it1.hasNext();) {
                NextFormType npt = (NextFormType) it1.next();
                if ( npt != null )  {
                    
                    String id = npt.getId();
                    String multiplicity = npt.getMaxChilds();
                    
                    vr.ident();
                    vr.appendBuffer("Validating nextForm tag id (" + id + ") and multiplicity(" + multiplicity + ").");
                    
                    if ( !SemanticValidatorUtil.validateNextPatternId(id) )  {
                        vr.ident();
                        vr.newLine();
                        vr.appendBuffer("- Error       : NextForm tag validation error.");
                        vr.appendBuffer("- Source error: the id tag '<id>" + id + "</id>' has a error.");
                        vr.appendBuffer("-               the id '" + id + "' is not valid.");
                        vr.appendBuffer("- Correction  : put the id in the correct form.");
                        vr.newLine();
                        vr.appendBuffer("- Examples:");
                        vr.appendBuffer("               <id>1.1</id>");
                        vr.appendBuffer("               <id>1.2</id>");
                        vr.appendBuffer("               <id>3.*</id>");
                        vr.appendBuffer("               <id>10.3</id>");
                        vr.newLine();
                        vr.setSuccess(false);
                        vr.dident();
                        return;
                    }
                    
                    if ( !IntegerUtil.isInt(multiplicity) )  {
                        if ( !multiplicity.toUpperCase().equals("N") )  {
                            vr.ident();
                            vr.newLine();
                            vr.appendBuffer("- Error       : NextForm tag validation error.");
                            vr.appendBuffer("- Source error: the multiplicity tag '<multiplicity>" + multiplicity + "</multiplicity>' has a error.");
                            vr.appendBuffer("-               the multiplicity value '" + multiplicity + "' is not valid.");
                            vr.appendBuffer("- Correction  : put the multiplicity in the correct form.");
                            vr.newLine();
                            vr.appendBuffer("- Examples:");
                            vr.appendBuffer("               <multiplicity>1</multiplicity>");
                            vr.appendBuffer("               <multiplicity>2</multiplicity>");
                            vr.appendBuffer("               <multiplicity>3</multiplicity>");
                            vr.appendBuffer("               <multiplicity>5</multiplicity>");
                            vr.appendBuffer("               <multiplicity>10</multiplicity>");
                            vr.appendBuffer("               <multiplicity>1000</multiplicity>");
                            vr.appendBuffer("               <multiplicity>n</multiplicity>");
                            vr.appendBuffer("               <multiplicity>N</multiplicity>");
                            vr.newLine();
                            vr.setSuccess(false);
                            vr.dident();
                            return;
                        }
                    }
                    
                    if ( d.getFormById(id) == null )  {
                        vr.ident();
                        vr.newLine();
                        vr.appendBuffer("- Error       : NextForm tag validation error.");
                        vr.appendBuffer("- Source error: the id tag '<id>" + id + "</id>' has a error.");
                        vr.appendBuffer("-               there is no form with this id in the meta-model.");
                        vr.appendBuffer("- Correction  : Remove or correct the id value.");
                        vr.newLine();
                        vr.setSuccess(false);
                        vr.dident();
                        return;
                    }
                    
                    vr.appendBuffer("Validating nextForm tag id (" + id + ") and multiplicity(" + multiplicity + ") - OK");
                    vr.dident();
                    
                }//if
                
            }//for    
            
            vr.appendBuffer("Validating nextForm tag - OK");
            vr.dident();
            vr.newLine();
        }//if
        
    }//method

}
