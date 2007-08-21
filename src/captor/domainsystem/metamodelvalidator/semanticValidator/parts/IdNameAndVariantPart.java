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
public class IdNameAndVariantPart extends Part {

    public IdNameAndVariantPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormType pt, FormsType pts)  {
        String id = pt.getId();
        String name = pt.getName();
        String variant = pt.getVariant();
        
        //verificar se o id  é branco ou nulo
        //verificar se o nome é branco e nulo
        //verificar se a variant é branca ou nula
        
        //verificar se existe outro padrão com esse nome/variant
        
        //verificar se existe dois padrões com o mesmo id
        
        vr.ident();
        vr.appendBuffer("Validating form id, name and variant from meta-model.");
        vr.dident();
        
        if ( id == null || id.trim().equals("") )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There is a form with no ID.");
            vr.appendBuffer("- Correction: Give a form id for this form.");
            vr.newLine();
            vr.appendBuffer("- Form description: ");
            vr.appendBuffer("                       form id:      " + id);
            vr.appendBuffer("                       form name:    " + name);
            vr.appendBuffer("                       form variant: " + variant);
            vr.newLine();
            vr.appendBuffer("- Example: ");
            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <id>1.1</id>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");
            vr.dident();
            vr.setSuccess(false);
            return;
        }

        if ( name == null || name.trim().equals("") )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There is a form with no name.");
            vr.appendBuffer("- Correction: Give a form name for this form.");
            vr.newLine();
            vr.appendBuffer("- Form description: ");
            vr.appendBuffer("                       form id:      " + id);
            vr.appendBuffer("                       form name:    " + name);
            vr.appendBuffer("                       form variant: " + variant);
            vr.newLine();
            vr.appendBuffer("- Example: ");
            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <name>1.1</name>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");
            vr.dident();
            vr.setSuccess(false);
            return;
        }

        if ( variant == null || variant.trim().equals("") )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There is a form with no variant value.");
            vr.appendBuffer("- Correction: Give a form variant for this form.");
            vr.newLine();
            vr.appendBuffer("- Form description: ");
            vr.appendBuffer("                       form id:      " + id);
            vr.appendBuffer("                       form name:    " + name);
            vr.appendBuffer("                       form variant: " + variant);
            vr.newLine();
            vr.appendBuffer("- Examples: ");
            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <variant>Default</variant>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");

            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <variant>Recurso Simples</variant>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");

            vr.dident();
            vr.setSuccess(false);
            return;
        }

        List patternList = pts.getForm();
        if ( patternList == null )  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("There are no forms in the meta-model.");
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
        //-------------------------------------------------------------------------
        //-------------------------------------------------------------------------

        //verificar se existe outro padrão com o mesmo nome/variant ou mesmo id 
        for(Iterator it1 = patternList.iterator(); it1.hasNext();) {
            FormType pt2 = (FormType) it1.next();
            if ( pt == pt2 )
                continue;
            
            if ( pt2.getName().toUpperCase().equals(pt.getName().toUpperCase()) && 
                    pt2.getVariant().toUpperCase().equals(pt.getVariant().toUpperCase()) )  {
                vr.ident();
                vr.newLine();
                vr.appendBuffer("- Error     : There two form with the same name and variant.");
                vr.appendBuffer("- Correction: Give a diferent form name/variant for each form.");
                vr.newLine();
                vr.appendBuffer("- Form description: ");
                vr.appendBuffer("                       form id:      " + id);
                vr.appendBuffer("                       form name:    " + name);
                vr.appendBuffer("                       form variant: " + variant);
                vr.dident();
                vr.setSuccess(false);
                return;
            }
            
            if ( pt2.getId().toUpperCase().equals(pt.getId().toUpperCase()) )  {
                vr.ident();
                vr.newLine();
                vr.appendBuffer("- Error     : There two form with the same id.");
                vr.appendBuffer("- Correction: Give a diferent form id for each form.");
                vr.newLine();
                vr.appendBuffer("- Form description: ");
                vr.appendBuffer("                       form id:      " + id);
                vr.appendBuffer("                       form name:    " + name);
                vr.appendBuffer("                       form variant: " + variant);
                vr.dident();
                vr.setSuccess(false);
                return;
            }
        }
        
        vr.ident();
        vr.appendBuffer("Validating form id, name and variant from meta-model - OK");
        vr.newLine();
        vr.dident();
    }
    
}
