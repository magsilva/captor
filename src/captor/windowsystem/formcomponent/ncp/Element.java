/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

import java.awt.Component;
import java.util.Vector;

import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;

public class Element {
    
    private Vector parameters;
    private String classname;
    private Model model;
    
    public Element(Model model) {
        this.model = model;
        parameters = new Vector();
        classname = "";
    }
    
    public void addParameter(Parameter parameter)  {
        
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            if ( p.getName().equals(parameter.getName()) )  {
                p.setValue(parameter.getValue());
                return;
            }
        }
        
        parameters.add(parameter);
    }
    
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the classname.
     */
    public String getClassname() {
        return classname;
    }
    
    /**
     * @param classname The classname to set.
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }
    
    /**
     * @return Returns the parameters.
     */
    public Vector getParameters() {
        return parameters;
    }
    
    /**
     * @param parameters The parameters to set.
     */
    public void setParameters(Vector parameters) {
        this.parameters = parameters;
    }
    
    public void deleteParameterByName(String name)  {
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            if ( p.getName().trim().equals(name.trim()) )  {
                parameters.removeElement(p);
                return;
            }
        }
    }
    
    //-------------------------------------------------------------------------

    public Parameter getParameterByName(String name)  {
        
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            if ( p.getName().trim().equals(name.trim()))
                return p;
        }
        
        return null;
    }
    
    //-------------------------------------------------------------------------
    
    public String validate(Component component)  {
        
        FormComponent fe = FEUtil.getFormElementInstance(component, model, classname);
        if ( fe == null )  {
            return "Cannot instantiate formElement " + classname;
        }
        
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            fe.setParameter(p.getName(), p.getValue());
        }
        
        if (!fe.validateParameters() )  {
            StringBuffer  sb = new StringBuffer();
            sb.append("           Error : formComponent validation error.\n");
            sb.append("Source error: There are missing parameters in the form component selected (" + classname + ").\n");
            sb.append("   Correction: Put the required missing parameters in the parameters list.\n");
            sb.append("               Tip: Press the 'Help' button for parameters specific elements details.\n\n");
            
            return sb.toString();
        }        
        
        //return null if ok
        return null;
    }
    
    //-------------------------------------------------------------------------
    
    public boolean validateParameters()  {
        
//      try {
//      Class cls = Class.forName(combo.getSelectedItem().toString());
//      
//      Class partypes[] = new Class[2];
//      partypes[0] = model.getClass();
//      partypes[1] = model.getGui().getTree().getModel().getRoot().getClass();
//      Constructor ctor = cls.getConstructor(partypes);                 
//      
//      Object arglist[] = new Object[2];
//      arglist[0] = model;
//      arglist[1] = null;
//      Object retobj = ctor.newInstance(arglist);
//      FormComponent fe = (FormComponent) retobj;
//      
//      for(int i = 0; i < parameterList.size(); i++ ) {
//      ParameterType pt = (ParameterType) parameterList.get(i);
//      fe.setParameter(pt.getName(), pt.getValue());
//      }   
//      
//      fe.parseParameters();
//      
//      if ( !fe.validateParameters() )  {
//      StringBuffer sb = new StringBuffer();
//      sb.append("         Error - There are missing 'required' parameters in the form component parameter list.\n");
//      sb.append("Correction - Put the missing 'required' parameres in the parameres list.\n\n");
//      sb.append("            Tip -  See individual form component documentation for required parameters details.\n\n");
//      
//      sb.append("FormComponent parameters list:\n\n");
//      for ( int j = 0; j < fe.getRequiredParameters().size(); j++ )  {
//      String aux = (String) fe.getRequiredParameters().get(j);
//      sb.append("  - " + fe.getRequiredParameters().get(j) + "\n");
//      }
//      
//      JOptionPane.showMessageDialog(this, sb.toString());
//      return false;
//      }
//      }
//      catch (Throwable e) {
//      String msg = StringUtil.formatMessage(MyIntl.MSG58, combo.getSelectedItem().toString());
//      JOptionPane.showMessageDialog(this, msg);
//      model.getGui().getGuiView().setErrorView(e.toString());
//      return false;
//      } 
//      
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    public void toXML(CCBuffer out)  {
        
      out.newLine();
      out.ident();
      out.appendln("<formComponent>");
      out.ident();
      
      out.append("<fullname>");
      out.append(classname, true);
      out.appendln("</fullname>", true);
      
      if ( parameters.size() > 0 )  {
          out.appendln("<parameters>");
          out.ident();
          
          for ( int i = 0; i < parameters.size(); i++ )  {
              Parameter p = (Parameter) parameters.get(i);
              String name = p.getName();
              String value = p.getValue();
              
              if ( name.equals("") )
              continue;
              
              out.appendln("<parameter>");
              
              out.ident();
              out.append("<name>");
              out.append(name, true);
              out.appendln("</name>", true);
              
              out.append("<value>");
              out.append(value, true);
              out.appendln("</value>", true);
              
              out.dident();
              out.appendln("</parameter>");
          }
          
          out.dident();
          out.appendln("</parameters>");
          
      }
      
      out.dident();
      out.appendln("</formComponent>");
      out.dident();
    }
    
    //-------------------------------------------------------------------------
    
    public void print()  {
        System.out.println("Element:");
        System.out.println("   Name: " + classname);
        System.out.println("   Parameters:");
        
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            System.out.println("       Name: " + p.getName());
            System.out.println("      Value: " + p.getValue());
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        return classname;
    }
    
    //-------------------------------------------------------------------------
    
    public void removeParameters()  {
        parameters = new Vector();
    }
    
    //-------------------------------------------------------------------------

    public void removeParameterByName(String name)  {
        for ( int i = 0; i < parameters.size(); i++ )  {
            Parameter p = (Parameter) parameters.get(i);
            if ( p.getName().equals(name) )  {
                parameters.remove(i);
            }
        }
    }
    
    //-------------------------------------------------------------------------
}
