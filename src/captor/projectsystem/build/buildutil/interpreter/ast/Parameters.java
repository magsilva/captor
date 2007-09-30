/*
 *
 */
package captor.projectsystem.build.buildutil.interpreter.ast;

import java.util.Vector;

/**
 * @author Kicho
 *
 */
public class Parameters {

    Vector parameters;

    public Parameters() {
        parameters = new Vector();
    }
    
    //-------------------------------------------------------------------------
    
    public void add(String parameter)  {
        parameters.add(parameter);
    }
    
    //-------------------------------------------------------------------------
    
    public Vector getParameters()  {
        return parameters;
    }

    //-------------------------------------------------------------------------
}
