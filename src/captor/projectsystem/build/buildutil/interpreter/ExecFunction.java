package captor.projectsystem.build.buildutil.interpreter;

import java.util.Vector;

import javax.xml.transform.TransformerException;

import org.apache.xpath.XPathAPI;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Document;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.build.buildutil.interpreter.ast.Function;
import captor.projectsystem.build.buildutil.interpreter.ast.Parameters;


/**
 * @author Kicho
 *
 */
public class ExecFunction {

    public static boolean exec(Function function, Document document, Model model)  {
        
        if ( function == null )
            return false;
        
        Parameters parameters = function.getParameters();
        
        if ( function.getName().equals("exists") )  {
            boolean ret = false;
            ret = execExists(function, parameters.getParameters(), document, model);
            return ret;
        }
        else if ( function.getName().equals("equal") )  {
            return execEqual(function, parameters.getParameters(), document, model);
        }
        if ( function.getName().equals("not-equal") )  {
            return execNotEqual(function, parameters.getParameters(), document, model);
        }
        
        return false;
    }

    //-------------------------------------------------------------------------

    private static boolean execExists(Function function, Vector parameters, Document document, Model model)  {
        if ( parameters.size() != 1 )
            return false;

        String parameter = (String) parameters.get(0);
        
        if ( parameter == null )  {
            model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_1, function.getName()));
            return false;
        }

        XObject xobject;
        try {
            xobject = XPathAPI.eval(document, parameter);
            String ret = xobject.toString();
            if ( ret.equals("") )
                return false;

            return true;
        } catch (TransformerException e) {
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_2);
            model.getGui().getGuiView().setWarningView(StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_3, parameter, StringUtil.formatOutput(e.getMessage())));
            return false;
        }
    }
    
    //-------------------------------------------------------------------------

    private static boolean execEqual(Function function, Vector parameters, Document document, Model model)  {
        if ( parameters.size() != 2 )
            return false;
        
        String parameter1 = (String) parameters.get(0);
        String parameter2 = (String) parameters.get(1);

        parameter1 = getParameterValue(parameter1, document, model);
        if ( parameter1 == null )  {
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
            return false;
        }
        parameter2 = getParameterValue(parameter2, document, model);
        if ( parameter2 == null )  {
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
            return false;
        }

        return parameter1.equals(parameter2);
    }
    
    //-------------------------------------------------------------------------

    private static boolean execNotEqual(Function function, Vector parameters, Document document, Model model)  {
        if ( parameters.size() != 2 )
            return false;
        
        String parameter1 = (String) parameters.get(0);
        String parameter2 = (String) parameters.get(1);

        parameter1 = getParameterValue(parameter1, document, model);
        parameter2 = getParameterValue(parameter2, document, model);
        
        if ( parameter1 == null )  {
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
            return false;
        }
        if ( parameter2 == null )  {
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
            return false;
        }
        
        return !parameter1.equals(parameter2);
    }
    
    //-------------------------------------------------------------------------
    
    private static String getParameterValue(String parameter, Document document, Model model)  {
        
        char []charArray = parameter.toCharArray();
        int len = charArray.length;
        
        //se for um literal
        if ( charArray[0] == '\'' && charArray[len-1] == '\'' )  {
            return parameter.substring(1, len - 1);
        }
        
        XObject xobject;
        try {
            xobject = XPathAPI.eval(document, parameter);
            return xobject.toString();
        } catch (TransformerException e) {
            
            model.getGui().getGuiView().setWarningView(StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_5, parameter, StringUtil.formatOutput(e.getMessage())));
            return null;
        }
        
    }
        
    //-------------------------------------------------------------------------
}
