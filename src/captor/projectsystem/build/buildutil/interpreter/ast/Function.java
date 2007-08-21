/*
 *
 */
package captor.projectsystem.build.buildutil.interpreter.ast;

/**
 * @author Kicho
 *
 */
public class Function {
    
    private Parameters parameters;
    private String name;
    
    public Function(String name, Parameters parameters) {
        this.name = name;
        this.parameters = parameters;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the parameters.
     */
    public Parameters getParameters() {
        return parameters;
    }
    /**
     * @param parameters The parameters to set.
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    
    //-------------------------------------------------------------------------
}
