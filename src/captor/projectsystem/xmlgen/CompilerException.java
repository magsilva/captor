/*
 *
 */
package captor.projectsystem.xmlgen;

/**
 * @author Kicho
 *
 */
public class CompilerException extends Exception {

    public static final long serialVersionUID = 101;

    public CompilerException(String action) {
        super();
        showMessage(action);
    }
    
    private void showMessage(String action)  {
        if ( action.equals("abort") )  {
            //System. out.println("Generation aborted!");
        }
    }

}
