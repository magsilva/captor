/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JOptionPane;

import captor.domainsystem.ParameterType;
import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.Parameter;

public class FEUtil {
    
    //-------------------------------------------------------------------------
    
    public static FormComponent getFormElementInstance(Component owner, Model model, String className)  {
        Class cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        }
        
        Class partypes[] = new Class[2];
        partypes[0] = model.getClass();
        partypes[1] = model.getGui().getTree().getModel().getRoot().getClass();
        Constructor ctor;
        
        try {
            ctor = cls.getConstructor(partypes);
        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        } catch (NoSuchMethodException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        }
        
        Object arglist[] = new Object[2];
        arglist[0] = model;
        arglist[1] = null;
        Object retobj;
        
        try {
            retobj = ctor.newInstance(arglist);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        } catch (InstantiationException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        } catch (InvocationTargetException e) {
            JOptionPane.showMessageDialog(owner, StringUtil.formatMessage(MyIntl.MSG106, className, e.toString()));
            return null;
        }
        
        return (FormComponent) retobj;
    }
    
    //-------------------------------------------------------------------------

    public static boolean isMandatoryParameter(Component owner, Model model, Element element, String parName)  {
        
        FormComponent fe = getFormElementInstance(owner, model, element.getClassname());
        Vector v = fe.getRequiredParameters();
        
        for ( int i = 0; i < v.size(); i++ )  {
            if ( v.get(i) instanceof ParameterType )  {
                Parameter p = (Parameter) v.get(i);
                if ( p.getName().trim().equals(parName.trim()))  {
                    return p.isRequired();
                }
            }            
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------

    public static Vector getComboData(Model model) {
        
        Vector elements = new Vector();
        Vector v = new Vector();
        
        String separator = System.getProperty("file.separator");
        String path = model.getConfig().getSystemConfig().getInstallPath();
        path = path.concat(separator);
        path = path.concat("config");
        path = path.concat(separator);
        path = path.concat("formelements");
        path = path.concat(separator);
        
        String defaultPath = path.concat("formelements.properties.default");
        String mainPath = path.concat("formelements.properties");
        
        Properties defaultProps;
        try  {
            defaultProps = new Properties();
            FileInputStream in = new FileInputStream(defaultPath);
            defaultProps.load(in);
            in.close();        
            Properties applicationProps = new Properties(defaultProps);
            
            File file = new File(mainPath);
            if ( !file.exists() )  {
                applicationProps = defaultProps;
            }
            else  {
                in = new FileInputStream(mainPath);
                applicationProps.load(in);
                in.close();
            }
            
            for ( int i = 0; i < 50; i++ )  {
                elements.add(applicationProps.getProperty("el" + i));
            }

        }
        catch(Exception e)  {
            String errorMsg = "<font color=\"#FF0000\"><b>Exception: Cannot open properties files.</b></font><br>Check if the file " + mainPath + " exists.";
            model.getGui().getGuiView().setErrorView(errorMsg);
            return new Vector();
        }
        
        v.add("");
        for ( int i = 0; i < elements.size(); i++ )  {
            String s = (String) elements.get(i);
            if ( s!= null && !s.equals("") )
                v.add(s);
        }
        
        return v;
    }
    
    //-------------------------------------------------------------------------
}
