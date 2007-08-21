package captor.lib.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    
    public static boolean alpahNumeric(String s)  {
        char [] c = s.toCharArray();
        
        boolean ret = true;
        for ( int i = 0; i < c.length; i++ )  {
            if ( c[i] < 48 )
                ret = false;
            if ( c[i] > 57 && c[i] < 65 )
                ret = false;
            if ( c[i] > 90 && c[i] < 97 )
                ret = false;
            if ( c[i] > 122 )
                ret = false;
        }
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public static boolean alpahNumeric(char c)  {
        
        boolean ret = true;
        if ( c < 48 )
            ret = false;
        if ( c > 57 && c < 65 )
            ret = false;
        if ( c > 90 && c < 97 )
            ret = false;
        if ( c > 122 )
            ret = false;
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public static boolean alpahNumericAndUnderscoreAndMinus(String s)  {
        char [] c = s.toCharArray();
        
        boolean ret = true;
        for ( int i = 0; i < c.length; i++ )  {
            if ( c[i] < 48 & c[i] != 45 )
                ret = false;
            if ( c[i] > 57 && c[i] < 65 )
                ret = false;
            if ( c[i] > 90 && c[i] < 97  && c[i] != 95)
                ret = false;
            if ( c[i] > 122)
                ret = false;
        }
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public static boolean alpahNumericAndUnderscoreAndMinus(char c)  {
        
        boolean ret = true;
        if ( c < 48 & c != 45 )
            ret = false;
        if ( c > 57 && c < 65 )
            ret = false;
        if ( c > 90 && c < 97  && c != 95)
            ret = false;
        if ( c > 122)
            ret = false;
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public static String validateProjectName(String s)  {
        if ( s.equals("") )  {
            return "The project name cannot be blank.";
        }
        
        if ( !alpahNumericAndUnderscoreAndMinus(s) )  {
            return "The project name contain a invalid character.";            
        }
        
        String pname = s.trim().substring(0,1);
        if ( !pname.equals(pname.toUpperCase()) )  {
            return "Invalid project name.\nThe fist letter must be in upper case form.";
        }
        
        String regexp = "[(A-Z)][(A-Za-z\\-_0-9)]*";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(s.trim());
        if ( !m.matches() )  {
            return "Invalid project name.\nIt doesn't match the regular expression: " + regexp;
        }
        
        return null;
    }
    
    //-------------------------------------------------------------------------
    
    public static boolean charIsInt(char c)  {
        if ( c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
            || c == '6' || c == '7' || c == '8' || c == '9' )
            return true;

        return false;
    }

    //-------------------------------------------------------------------------
    
    public static String formatOutput(String out)  {
        String s = new String(out);
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll("\n", "<br>");
        
        return s;
    }
    
    //-------------------------------------------------------------------------

    public static String formatMessage(String msg, String arg1, int arg2)  {
        String sarg2 = new Integer(arg2).toString();
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$1", sarg2);
        return s;
    }
    
    public static String formatMessage(String msg, String arg1)  {
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        return s;
    }

    public static String formatMessage(String msg, String arg1, String arg2)  {
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", arg2);
        return s;
    }

    public static String formatMessage(String msg, String arg1, String arg2, String arg3)  {
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", arg2);
        s = s.replaceAll("\\$3", arg3);
        return s;
    }

    public static String formatMessage(String msg, String arg1, String arg2, String arg3, String arg4)  {
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", arg2);
        s = s.replaceAll("\\$3", arg3);
        s = s.replaceAll("\\$4", arg4);
        return s;
    }

    public static String formatMessage(String msg, String arg1, int arg2, String arg3)  {
        String sarg2 = new Integer(arg2).toString();
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", sarg2);
        s = s.replaceAll("\\$3", arg3);
        return s;
    }
    
    public static String formatMessage(String msg, String arg1, String arg2, int arg3, int arg4, String arg5)  {
        String sarg3 = new Integer(arg3).toString();
        String sarg4 = new Integer(arg4).toString();
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", arg2);
        s = s.replaceAll("\\$3", sarg3);
        s = s.replaceAll("\\$4", sarg4);
        s = s.replaceAll("\\$5", arg5);
        return s;
    }

    public static String formatMessage(String msg, String arg1, String arg2, int arg3)  {
        String sarg3 = new Integer(arg3).toString();
        String s = new String(msg);
        s = s.replaceAll("\\$1", arg1);
        s = s.replaceAll("\\$2", arg2);
        s = s.replaceAll("\\$3", sarg3);
        return s;
    }

    public static String formatMessage(String msg, int arg1, String arg2)  {
        String sarg1 = new Integer(arg1).toString();
        String s = new String(msg);
        s = s.replaceAll("\\$1", sarg1);
        s = s.replaceAll("\\$2", arg2);
        return s;
    }

    //-------------------------------------------------------------------------
}
