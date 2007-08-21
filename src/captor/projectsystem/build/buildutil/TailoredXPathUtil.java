/*
 *
 */
package captor.projectsystem.build.buildutil;

import javax.xml.transform.TransformerException;

import org.apache.xpath.XPathAPI;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Document;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class TailoredXPathUtil {

    public static String evaluateXPath(Model model, String str, Document document)  {
        char []charArray = str.toCharArray();
        
        StringBuffer ret = new StringBuffer("");
        
        for ( int i = 0; i < charArray.length; i++ )  {
            if ( charArray[i] != '$')  {
                ret = ret.append(charArray[i]);
            }
            else  {
                StringBuffer var = new StringBuffer("");
                i = i + 2;
                while( charArray[i] != '}' && i < charArray.length )  {
                    var = var.append(charArray[i]);
                    i++;
                }
                
                StringBuffer value = evaluateXPath2(var, document);
                if ( value == null || value.equals("") )  {
                    model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_TAILOREXPATH_UTIL_1, var.toString()));
                    return null;
                }
                ret = ret.append(value);
            }
        }
        
        String aux = ret.toString();
        String replacement = new String(System.getProperty("file.separator"));
        if ( replacement.equals("\\"))
            replacement = "\\\\";
        
        aux = aux.replaceAll("/", replacement);
        aux = aux.replaceAll("\\\\", replacement);
        
        return aux;
    }
    
    //-------------------------------------------------------------------------
    
    private static StringBuffer evaluateXPath2(StringBuffer var, Document document)  {
        
        try {
            XObject xobject = XPathAPI.eval(document, var.toString());
            String ret = xobject.toString();
            
            if ( ret.equals("") )
                return null;
            
            return new StringBuffer(ret);
        } catch (TransformerException e) {
            e.printStackTrace();
        	return null;
        }
    }

    //-------------------------------------------------------------------------
}
