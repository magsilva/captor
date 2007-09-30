/*
 *
 */
package captor.domainsystem.metamodelvalidator.semanticValidator.parts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.domainsystem.FormComponentType;
import captor.domainsystem.FormComponentsType;
import captor.domainsystem.FormType;
import captor.domainsystem.ParameterType;
import captor.domainsystem.ParametersType;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.modelsystem.Model;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.Parameter;

/**
 * @author Kicho
 *
 */
public class FormElementPart extends Part  {
    
    public FormElementPart(Model model, ValidationResults vr)  {
        super(model, vr);
    }
    
    public void check(FormType pt)  {
        vr.ident();
        vr.appendBuffer("Validating formElements tag:");
        FormComponentsType cst = pt.getFormComponents();
        if ( cst != null )  {
            List listComponent = cst.getFormComponent(); 
            for(Iterator it1 = listComponent.iterator(); it1.hasNext();) {
                FormComponentType fct = (FormComponentType) it1.next();
                
                vr.ident();
                vr.appendBuffer("Validating formElement:" + fct.getFullname());
                
                validateFormElementsInstantiation(fct);
                if ( !vr.isSuccess() )  {
                    vr.appendBuffer("- Validating formElements tag - NOT OK");
                    vr.dident();
                    return;
                }
                
                validateFormElementsTestClass(fct);
                if ( !vr.isSuccess() )  {
                    vr.appendBuffer("- Validating formElements tag - NOT OK");
                    vr.dident();
                    return;
                }
                
                validateFormElementsParameters(fct);
                if ( !vr.isSuccess() )  {
                    vr.appendBuffer("- Validating formElements tag - NOT OK");
                    vr.dident();
                    return;
                }
                
                vr.appendBuffer("Validating formElement:" + fct.getFullname() + " - OK");
                vr.dident();
            }
        }
        vr.appendBuffer("Validating formElements tag - OK");
        vr.dident();
        
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    public void validateFormElementsParameters(FormComponentType fct)  {
        vr.ident();
        vr.appendBuffer("Validating formElements parameters tag:");
        
        Object retobj = null;
        try {
            Class cls = Class.forName(fct.getFullname());
            
            Class partypes[] = new Class[2];
            partypes[0] = model.getClass();
            partypes[1] = new DefaultMutableTreeNode().getClass();
            Constructor ctor = cls.getConstructor(partypes);                 
            
            Object arglist[] = new Object[2];
            arglist[0] = model;
            arglist[1] = null;
            retobj = ctor.newInstance(arglist);
        } catch (Exception e) {return;} //nunca vai acontecer pq isso ja foi validado
        
        if ( retobj != null )  {
            //chamar os metodos setParameter
            if ( retobj instanceof FormComponent )  {
                FormComponent fe = (FormComponent) retobj;
                
                ParametersType pst = fct.getParameters();
                if ( pst != null )  {
                    List parameterList = pst.getParameter();
                    for(Iterator it2 = parameterList.iterator(); it2.hasNext();) {
                        ParameterType prt = (ParameterType) it2.next();
                        fe.setParameter(prt.getName(), prt.getValue());
                    }
                }
                
                //chamar o metodo parseParameter e ver o resultado
                boolean res = fe.validateParameters();
                if ( res == false )  {
                    vr.ident();
                    vr.newLine();
                    vr.appendBuffer("- Error       : formElements tag validation error.");
                    vr.appendBuffer("- Source error: the formElement parameters doesn't fit the minumum requirement from this formElement.");
                    vr.appendBuffer("                this formElement accept this parameters:\n");
                    vr.newLine();
                    for ( int i = 0; i < fe.getRequiredParameters().size(); i++ )  {
                        Parameter p = (Parameter) fe.getRequiredParameters().get(i);
                        vr.appendBuffer("                 - " + p.getName());
                    }
                    vr.newLine();
                    vr.setSuccess(false);
                    vr.dident();
                    return;
                }
            }
        }
        vr.appendBuffer("Validating formElements parameters tag - OK");
        vr.dident();
    }
    
    //-------------------------------------------------------------------------
    
    public void validateFormElementsInstantiation(FormComponentType fct)  {
        
        Object retobj = null;
        try {
            Class cls = Class.forName(fct.getFullname());

            if ( cls == null )
                System.out.println("cls == null");
            
            Class partypes[] = new Class[2];
            partypes[0] = model.getClass();
            partypes[1] = new DefaultMutableTreeNode().getClass();
            Constructor ctor = cls.getConstructor(partypes);                 

            if ( ctor == null )
                System.out.println("ctor == null");

            Object arglist[] = new Object[2];
            arglist[0] = model;
            arglist[1] = null;
            retobj = ctor.newInstance(arglist);
            
            if ( retobj == null )
                System.out.println("retobj == null");
            
        } catch (SecurityException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               This class can't be loaded. It's instantiation raised a SecurityException.");
            vr.appendBuffer("- Description:  : " + e);
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (IllegalArgumentException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a IllegalArgumentException.");
            vr.appendBuffer("-               Probably because it's constructor cannot be called.");
            vr.appendBuffer("- Correction  : check if the class extends the abstract class FormElement an it has a constructor: " + fct.getFullname() + "(Model model)");
            vr.appendBuffer("- Description:  : " + e);
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (ClassNotFoundException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a ClassNotFoundException.");
            vr.appendBuffer("- Correction  : Check if this path to the class is in the CLASSPATH or if this class really exists.");
            vr.newLine();
            vr.appendBuffer("- Current CLASSPATH   : " + System.getProperty("java.class.path","."));
            vr.appendBuffer("- Description:  : " + e);
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (NoSuchMethodException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a NoSuchMethodException, probably because the constructor cannot be called by client.");
            vr.newLine();
            vr.appendBuffer("- Correction  : All form element must extends the FormElement abstract class. Check if " + fct.getFullname() + " really extends the FormElement abstract class.");
            vr.newLine();
            vr.appendBuffer("- Description:  : " + e);
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (InstantiationException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a InstantiationException.");
            vr.newLine();
            vr.appendBuffer("- Correction  : Check if this path to the class is in the CLASSPATH or if this class really exists.");
            vr.appendBuffer("- Description:  : " + e);
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (IllegalAccessException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a IllegalAccessException.");
            vr.newLine();
            vr.appendBuffer("- Correction  : Check if this path to the class is in the CLASSPATH or if this class really exists.");
            vr.appendBuffer("- Description:  : " + e);
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        } catch (InvocationTargetException e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class can't be loaded. It's instantiation raised a InvocationTargetException.");
            vr.newLine();
            vr.appendBuffer("- Correction  : Check if this path to the class is in the CLASSPATH or if this class really exists.");
            vr.appendBuffer("- Description : " + e);
            vr.appendBuffer("-               " + e.getCause());
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            e.printStackTrace();
            return;
        }
        
        if ( retobj != null )  {
            if ( !(retobj instanceof FormComponent) )  {
                vr.ident();
                vr.newLine();
                vr.appendBuffer("- Error       : formElements tag validation error.");
                vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
                vr.newLine();
                vr.appendBuffer("- Correction  : Check if this path to the class is in the CLASSPATH or if this class really exists.");
                vr.newLine();
                vr.setSuccess(false);
                vr.dident();
                return;
            }
        }
        else  {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It cannot be instantiated.");
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
            return;
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    public void validateFormElementsTestClass(FormComponentType fct)  {
        try {
            Class cls = Class.forName(fct.getFullname());
            Class parent = cls.getSuperclass();
            while ( parent != null )  {
                if ( parent.getName().equals("captor.windowsystem.formcomponent.FormComponent") )
                    return;
                
                parent = parent.getSuperclass();
            }
        }
        catch (Throwable e) {
            vr.ident();
            vr.newLine();
            vr.appendBuffer("- Error       : formElements tag validation error.");
            vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
            vr.appendBuffer("-               It's class doen's extends the class FormElement.");
            vr.appendBuffer("-               All formElement classes must extends the class FormElement.");
            vr.appendBuffer("- Correction  : Remove or correct the fullname value.");
            vr.newLine();
            vr.setSuccess(false);
            vr.dident();
        }
        
        vr.ident();
        vr.newLine();
        vr.appendBuffer("- Error       : formElements tag validation error.");
        vr.appendBuffer("- Source error: the fullname tag '<fullname>" + fct.getFullname() + "</fullname>' has a error.");
        vr.appendBuffer("-               It's class doen's extends the class FormElement.");
        vr.appendBuffer("-               All formElement classes must extends the class FormElement.");
        vr.appendBuffer("- Correction  : Remove or correct the fullname value.");
        vr.newLine();
        vr.setSuccess(false);
        vr.dident();
    }
    
    //-------------------------------------------------------------------------
    
}
