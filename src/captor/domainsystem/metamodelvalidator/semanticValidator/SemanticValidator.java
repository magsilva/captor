/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator;

import java.util.Iterator;
import java.util.List;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.FormType;
import captor.domainsystem.FormsType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.ExtendsPart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.FormElementPart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.IdNameAndVariantPart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.IsRootPart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.NextPatternsPart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.PLNamePart;
import captor.domainsystem.metamodelvalidator.semanticValidator.parts.PatternsIdsPart;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public class SemanticValidator {
    
    private Model model;
    private DomainSystem d;
    private ValidationResults vr;
    private ExtendsPart extendsPart;
    private NextPatternsPart nextPatternsPart;
    private FormElementPart formElementPart;
    private IdNameAndVariantPart idNameAndVariantPart;
    private PatternsIdsPart patternsIdsPart;
    private PLNamePart pLNamePart;
    private IsRootPart isRootPart;
    
    public SemanticValidator(Model model, ValidationResults vr)  {
        this.model = model;
        this.vr = vr;
        d = new DomainSystem(model);
        
        extendsPart = new ExtendsPart(model, vr);
        nextPatternsPart = new NextPatternsPart(model, vr);
        formElementPart = new FormElementPart(model, vr);
        idNameAndVariantPart = new IdNameAndVariantPart(model, vr);
        patternsIdsPart = new PatternsIdsPart(model, vr);
        pLNamePart = new PLNamePart(model, vr);
        isRootPart = new IsRootPart(model, vr);
    }
    
    //-------------------------------------------------------------------------
    
    public void validate()  {
        
        patternsIdsPart.check(model.getProject().getFormsType());
        if ( !vr.isSuccess() )
            return;
        
        pLNamePart.check(model.getProject().getFormsType());
        if ( !vr.isSuccess() )
            return;
        
        isRootPart.check(model.getProject().getFormsType());
        if ( !vr.isSuccess() )
            return;
        
        vr.newLine();
        vr.appendBuffer("Validating all form attributes from meta-model.");
        
        FormType pt = d.getFirstForm();
        if ( pt == null )  {
            
            vr.ident();
            vr.newLine();
            vr.appendBuffer("Cannot find root form in the meta-model.");
            vr.appendBuffer("The meta-model must contain a form with attribute 'isRoot=true'.\n");
            vr.newLine();
            vr.appendBuffer("Example: '<form isRoot=\"true\">'.");
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
        //pra cada padr�o chamar a valida��o
        List patternList = model.getProject().getFormsType().getForm();

        //isso nao vai acontecer nunca por causa do XMLSchema (mas eu vou deixar s� pra ter certeza)
        if ( patternList == null )  {
            vr.ident();
            vr.appendBuffer("There are no forms in the meta-model.");
            vr.dident();
            vr.setSuccess(false);
            return;
        }
        
        for(Iterator it1 = patternList.iterator(); it1.hasNext();) {
            if ( !vr.isSuccess() )
                return;
            
            pt = (FormType) it1.next();
            validate2(pt, model.getProject().getFormsType());
        }
        
        vr.newLine();
        vr.appendBuffer("Validating all form attributes from meta-model - OK");
        return;
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    private void validate2(FormType pt, FormsType pts)  {
        
        vr.ident();
        vr.newLine();
        vr.appendBuffer("Form id: " + pt.getId());

        idNameAndVariantPart.check(pt, pts);
        if ( !vr.isSuccess() )
            return;

        extendsPart.check(pt);
        if ( !vr.isSuccess() )
            return;
        
        nextPatternsPart.check(pt);  //ok
        if ( !vr.isSuccess() )
            return;
        
        formElementPart.check(pt);
        if ( !vr.isSuccess() )
            return;
        
        vr.newLine();
        vr.dident();
        vr.appendBuffer("Form id validation (" + pt.getId() + ") - OK");
        vr.dident();
    }
    
    //-------------------------------------------------------------------------
}
