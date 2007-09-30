/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.modelsystem.Model;

/**
 * @author Kicho
 *
 */
public abstract class Part {

    protected Model model;
    protected DomainSystem d;
    protected ValidationResults vr;
    
    public Part(Model model, ValidationResults vr)  {
        this.model = model;
        this.vr = vr;
        d = new DomainSystem(model);
    }
}
