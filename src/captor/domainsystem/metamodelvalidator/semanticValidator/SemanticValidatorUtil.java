/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator;

import java.util.Vector;

import captor.domainsystem.FormId;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.lib.util.IntegerUtil;
import captor.windowsystem.util.FormPathUtil;


/**
 * @author Kicho
 *
 */
public class SemanticValidatorUtil {
    
    //-------------------------------------------------------------------------
    
    public static void validatePatternId(String id, ValidationResults vr)
    {
        //verificar a forma NUMBER.NUMBER
        FormId formId = null;
        try {
        	formId = new FormId(id);
        } catch (IllegalArgumentException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error     : There is a incorrect form ID.");
            vr.appendBuffer("- Correction: Give a correct form id for this form.");
            vr.newLine();
            vr.appendBuffer("- Form description: ");
            vr.appendBuffer("                       form id:      " + id);
            vr.newLine();

            vr.appendBuffer("- Example: ");
            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <id>1.1</id>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");

            vr.newLine();
            vr.appendBuffer("           <form>     ");
            vr.appendBuffer("                <id>3.3</id>");
            vr.appendBuffer("                ....");
            vr.appendBuffer("                ....");
            
            vr.newLine();
            vr.appendBuffer("The form id must take this form: NUMBER.NUMBER where NUMBER is any number from 1 to 37675.");
            vr.newLine();
            vr.newLine();

            vr.dident();
            vr.setSuccess(false);
            return;
        }     
    } 
    
    //-------------------------------------------------------------------------
    
    public static boolean validateNextPatternId(String id)  {

        FormId formId = null;
        try {
        	formId = new FormId(id);
        } catch (IllegalArgumentException e) {
        	return false;
        }

        return true;
    } 

    //-------------------------------------------------------------------------

    public static void validateExtendsId(String id, ValidationResults vr)
    {       
        FormId formId = null;
        try {
        	new FormId(id);
        } catch (IllegalArgumentException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Extends form Id validation(" + id + ") returned " + false);
            vr.appendBuffer("- The id must have a form: NUMBER(.NUMBER)*");
            vr.newLine();
            vr.appendBuffer("- Possible values: {'1.1', '1.1.2', '3.4.5.3',...}");
            vr.setSuccess(false);
            vr.dident();
            return;
        }
    } 

    //-------------------------------------------------------------------------

    public static Vector validatePatternPath(String patternPath, ValidationResults vr)  {
        Vector v = getPathsFromPatternPath(patternPath, vr);
        if ( !vr.isSuccess() )  {
            vr.appendBuffer("- Validating formPath tag - NOT OK");
            vr.dident();
            return null;
        }
        
        return v;
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    private static Vector getPathsFromPatternPath(String path, ValidationResults vr)  {
        Vector v = new Vector();
        
        String[] paths = path.split("->");
                
	    for ( int i = 0; i < paths.length; i++ )  {

            vr.ident();
            vr.appendBuffer("Validating path (syntax): " + paths[i]);
	        
	        
	        String unityPath = paths[i];
	        int openParIndex = unityPath.indexOf("(");
	        int closeParIndex = unityPath.lastIndexOf(")");
	        
	        if ( openParIndex == -1 || closeParIndex == -1 )  {
	            vr.ident();
	            vr.newLine();
	            vr.appendBuffer("- Error       : require tag validation error.");
	            vr.appendBuffer("- Source error: the formPath tag '<formPath>" + path + "</formPath>' has a error.");
	            vr.appendBuffer("-               the subpath '" + unityPath + "' either don't hava a child(ID) or parent(ID) form.");
	            vr.appendBuffer("- Correction  : put the form path in the correct form.");
	            vr.newLine();
	            vr.appendBuffer("- Examples:");
	            vr.appendBuffer("               child(3.1)->child(2.2)");
	            vr.appendBuffer("               child(1.2)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.*)");
	            vr.newLine();
	            vr.setSuccess(false);
	            vr.dident();
	            return null;
	        }
	        
	        String reference = unityPath.substring(0, openParIndex);
	        if ( !(reference == null || reference.equals("child") || reference.equals("parent")) )  {
	            vr.ident();
	            vr.newLine();
	            vr.appendBuffer("- Error       : require tag validation error.");
	            vr.appendBuffer("- Source error: the formPath tag '<formPath>" + path + "</formPath>' has a error.");
	            vr.appendBuffer("-               the reference '" + reference + "' either don't hava a 'child' or 'parent' form.");
	            vr.appendBuffer("- Correction  : put the form path in the correct form.");
	            vr.newLine();
	            vr.appendBuffer("- Examples:");
	            vr.appendBuffer("               child(3.1)->child(2.2)");
	            vr.appendBuffer("               child(1.2)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.*)");
	            vr.newLine();
	            vr.setSuccess(false);
	            vr.dident();
	            return null;
	        }
	        
	        String id = unityPath.substring(openParIndex+1, closeParIndex);
	        
	        if ( !validateNextPatternId(id) )  {
	            vr.ident();
	            vr.newLine();
	            vr.appendBuffer("- Error       : require tag validation error.");
	            vr.appendBuffer("- Source error: the formPath tag '<formPath>" + path + "</formPath>' has a error.");
	            vr.appendBuffer("-               the id '" + id + "' either don't is a number and nor is a '*' character.");
	            vr.appendBuffer("- Correction  : put the form path in the correct form.");
	            vr.newLine();
	            vr.appendBuffer("- Examples:");
	            vr.appendBuffer("               child(3.1)->child(2.2)");
	            vr.appendBuffer("               child(1.2)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.3)");
	            vr.appendBuffer("               child(1.*)->child(2.*)");
	            vr.newLine();
	            vr.setSuccess(false);
	            vr.dident();
	            return null;
	        }
	        
            vr.appendBuffer("Validating path (syntax): " + paths[i] + " - OK");
            vr.dident();
	        v.add(new FormPathUtil(reference, id));
	    }
	    
	    return v;
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------

}
