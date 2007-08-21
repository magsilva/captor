package captor.domainsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * 
 * This class provides access to data in the main configuratin file.
 * 
 * <p>
 * It's represents the current domain been used by the project manager 
 * and has common methods for clients that manipulate in some way the 
 * domain information. i.e ProjectSystem classes and WindowSystem classes.
 * </p>
 *
 * @author Kicho
 */
public class DomainSystem implements IDomainSystem  {

    private Model model;
    
    public DomainSystem(Model model) {
        super();
        this.model = model;
    }

    //-------------------------------------------------------------------------

    public Vector getDomainNames()  {
        Vector v = new Vector();
        File file = new File(model.getConfig().getSystemConfig().getDomainPath());
        
        if ( !file.exists() )  {
            String errorMsg = "<font color=\"#FF0000\"><b>Cannot find domains directory: " + model.getConfig().getSystemConfig().getDomainPath() + "</b></font><br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
            throw new RuntimeException(errorMsg);
        }
        
        if ( !file.isDirectory() )  {
            String errorMsg = "The domain directory files: " + model.getConfig().getSystemConfig().getDomainPath() + " is not a directory.<br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
            throw new RuntimeException(errorMsg);
        }

        File[] files = file.listFiles();
        for ( int i = 0; i < files.length; i++ )  {
            File aux = files[i];
            if ( aux.isDirectory() )  {
                if ( new File(aux, files[i].getName().concat(".domain")).exists() )
                    v.add(files[i].getName());
            }
        }
        
        return v;
    }
    
    //-------------------------------------------------------------------------

    public Vector getVariantByForm(String name)  {
        Vector v = new Vector();
        Forms p = model.getProject().getForms();
        
        if ( p == null )  {
            String errorMsg = "<font color=\"#FF0000\"><b>Cannot load forms from meta model.</b></font><br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
            throw new RuntimeException(errorMsg);
        }

        List patternsList = p.getForm();
		for(Iterator it1 = patternsList.iterator(); it1.hasNext();) {
		    FormType pt = (FormType) it1.next();
		    if ( pt.getName().equals(name) )
		        v.add(pt);
		}
		
        return v;
    }

    //-------------------------------------------------------------------------

    public FormType getFirstForm()  {

        Forms p = model.getProject().getForms();
        
        if ( p == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG1);
            return null;
        }

        List patternsList = p.getForm();
		for(Iterator it1 = patternsList.iterator(); it1.hasNext();) {
		    FormType pt = (FormType) it1.next();
		    if ( pt.isIsRoot() ) 
		        return pt;
		}
		
        return null;
    }

    //-------------------------------------------------------------------------

    public FormType getFormById(String id)  {

        Forms p = model.getProject().getForms();
        if ( p == null )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load forms from meta model.</b></font><br>");
            throw new RuntimeException("Cannot load forms from meta model.");
        }

        List patternsList = p.getForm();
		for(Iterator it1 = patternsList.iterator(); it1.hasNext();) {
		    FormType pt = (FormType) it1.next();
		    if ( compareId(pt.getId(), id) )
		        return pt;
		}
		
        return null;
    }

    //-------------------------------------------------------------------------

    public boolean compareId(String id1, String id2)  {
        if ( id1.equals(id2) )
            return true;
        
	    String []idV1 = id1.split("\\.");
	    String []idV2 = id2.split("\\.");
	    if ( idV1.length == idV2.length )  {
	        
	        if ( idV1.length == 2 && idV1[0].equals(idV2[0]) && idV1[1].equals(idV2[1]) )
	            return true;
	        
	        if ( idV1.length == 2 && idV1[0].equals("*") && idV1[1].equals("*") )
	            return true;
	        
	        if ( idV2.length == 2 && idV2[0].equals("*") && idV2[1].equals("*") )
	            return true;
	        
	        for ( int i = 0; i < idV1.length; i++ )  {
	            if ( !(idV1[i].equals(idV2[i]) || idV1[i].equals("*") || idV2[i].equals("*")) )
	                return false;
	        }
	        
	        return true;
	    }
        
	    return false;
    }

    //-------------------------------------------------------------------------

    public boolean containId(Vector v, String id)  {
    	for ( int i = 0; i < v.size(); i++ )  {
    			String aux = (String) v.get(i);
    			if ( compareId(aux, id) )
    				return true;
    	}
    	
    	return false;
    }

    //-------------------------------------------------------------------------

    public String extendsMechanism(Forms p)  {
        
        if ( p == null )  {
            return "Cannot load forms from meta model (extendsMechanism failed).<br>";
        }
        
        List patternsList = p.getForm();
		for(Iterator it1 = patternsList.iterator(); it1.hasNext();) {
		    FormType pt = (FormType) it1.next();
		    String et = pt.getExtends();
		    if ( et == null )
		        continue;
			        
		    FormType  auxPt = getFormById(et);

	        //se o pai desse no for nulo, a clausula extends esta errada
		    if ( auxPt == null )  {
			    return "Bad Metal-model.<br><br>&nbsp;&nbsp;&nbsp;&nbsp;Form: " + pt.getName() + "<br>&nbsp;&nbsp;&nbsp;&nbsp;Id: " + pt.getId() + "<br><br>This form extends a pattern with id \"" + et + "\", but this id was not found in \"" + p.getName() + "\" form meta-model.<br>You need to fix this error before load this meta-model again.<br>";
	        }

		    String ret = extendsMechanism2(auxPt, pt);
		    if ( ret != null )
		        return ret;
		}
		
		return null;
    }
    
    private String extendsMechanism2(FormType father, FormType son)  {
        
        if ( son == null )  {
            return "Cannot find son pattern in extends mechanism.<br>";
        }
        
        //nextpatterns
        if ( (son.getNextForms() == null) &&
                (father.getNextForms() != null) )  {
            if ( father.getNextForms().getNextForm() != null )  {
       		    son.setNextForms(father.getNextForms());
            }
        }

        if ( (son.getHelp() == null) &&
                (father.getHelp() != null) )  {
  		    son.setHelp(father.getHelp());
        }

        //formElements
        if ( (son.getFormComponents() == null) &&
                (father.getFormComponents() != null) )  {
            if ( father.getFormComponents().getFormComponent() != null )  {
       		    son.setFormComponents(father.getFormComponents());
            }
        }
        
        return null;
    }

    //-------------------------------------------------------------------------
    
    public void loadGuiDomain(String path)  {
        Unmarshaller u = null;
        JAXBContext jc = null;
        ValidationEventCollector vec = new ValidationEventCollector();
        
        try  {
            jc = JAXBContext.newInstance("captor.domainsystem");
            u = jc.createUnmarshaller();
            
            u.setValidating(true);
            u.setEventHandler(vec);
        }
        catch(Exception e)  {
            model.getGui().getGuiView().setErrorView("Cannot load captor.domainsystem XML instance: " + StringUtil.formatOutput(e.toString()) + "<br>");		
            throw new RuntimeException("Cannot load captor.domainsystem XML instance: " + e);
        }
        
        try {
            FileInputStream is = new FileInputStream(path);
            Forms f = (Forms)u.unmarshal(is);
            model.getProject().setForms(f);
        } catch (FileNotFoundException e2)  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot find file: </b></font>" + path + "<br>");
            throw new RuntimeException("Cannot find file: " + path);
        }catch ( UnmarshalException e4 )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot parse the domain file: </b></font>" + path + "<br>");
            model.getGui().getGuiView().setErrorView("<br><b>Domain file invalid format: </b>" + StringUtil.formatOutput(e4.getMessage()) + "<br><br>");
            throw new RuntimeException("UnmarshalException: " + e4.getMessage());
            
	    } catch ( JAXBException e3 )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\">Cannot parse the domain file.: </font>" + path + "<br><br>");
            model.getGui().getGuiView().setErrorView("Metal-model invalid format: " + StringUtil.formatOutput(e3.getMessage()) + "<br><br>");
            throw new RuntimeException("Cannot find file: " + path);
        } catch (RuntimeException e1) {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\">Cannot parse the domain file.: </font>" + path + "<br><br>");
            model.getGui().getGuiView().setErrorView("Cannot validade domain meta-model file.<br><br>");
            throw new RuntimeException("Cannot validade domain meta-model file: " + path);
	    } 
        
        if( vec.hasEvents() ) {
            String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            ValidationEvent []ve = vec.getEvents();
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Metal-model invalid format:</b></font><br><br>");
            String spath = path.replace("\\\\", "\\");
            for ( int i = 0; i < ve.length; i++ )  {
                int severityNumber = ve[i].getSeverity();
                String severity = "";
                if ( severityNumber == ValidationEvent.ERROR )
                    severity = "ERROR";
                else if ( severityNumber == ValidationEvent.FATAL_ERROR )
                    severity = "FATAL ERROR";
                else if ( severityNumber == ValidationEvent.WARNING )
                    severity = "WARNING";
                
                if ( i > 0 )
                    model.getGui().getGuiView().setErrorView("<center><b>-----------------------------------------------------------------</b></center><br>");
                
                ValidationEventLocator locator = ve[i].getLocator(); 
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>File:</b> " + spath + "<br>");

                String msg = StringUtil.formatOutput(ve[i].getMessage());
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;<b>Description:</b> " + msg + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Severity:</b> " + severity + "<br><br>");
                
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Position:</b> <br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Line Number:</b> " + locator.getLineNumber() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;<b>Column Number:</b> " + locator.getColumnNumber() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Node:</b> " + locator.getNode() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>URL:</b> " + locator.getURL() + "<br><br>");
            }
        }
        
        String errorMsg = extendsMechanism(model.getProject().getForms());
        
        if ( errorMsg != null )
            model.getGui().getGuiView().setErrorView(errorMsg);
        
    }

    //-------------------------------------------------------------------------

}