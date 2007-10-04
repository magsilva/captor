package captor.domainsystem.metamodelvalidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.FormsType;
import captor.domainsystem.metamodelvalidator.semanticValidator.SemanticValidator;
import captor.modelsystem.Model;
import captor.modelsystem.Project;

/**
 * @author Kicho
 *
 */
public class MetaModelValidator {

    private Model model;
    private File file;
    private FormsType forms;
    private ValidationResults vr;

    public MetaModelValidator(String installPath)  {
        model = new Model();
        model.load(installPath);
    }
    
    //-------------------------------------------------------------------------
    
    public ValidationResults validate(File file)  {
        this.file = file;

        if ( file == null )
            return null;
        
        if ( !file.isFile() )
            return null;
            
        vr = new ValidationResults();

        vr.appendBuffer("Step 1  Loading the domains file into a object tree.\n");
        //carregar o metamodelo
        
        loadDomain();
        
        if ( !vr.isSuccess() )  {
            return vr;
        }
        
        
        if ( model.getProject() == null )
            model.setProject(new Project(model));
        
        model.getProject().setFormsType(forms);
        vr.ident();
        vr.appendBuffer("- Tree successfully loaded.");
        vr.dident();
        
        vr.newLine();
        vr.appendBuffer("Step 2 - Apply the extends mechanism to normalize the tree.\n");
        
        //colocar o mecanismo de extens�o pra normalizar a �rvore
        DomainSystem d = new DomainSystem(model);
        String ret = d.extendsMechanism(forms);
        if ( ret != null )  {
            vr.appendBuffer(ret);
            vr.setSuccess(false);
            return vr;
        }
        vr.ident();
        vr.appendBuffer("- Extends mechanism successfully applied.");
        vr.dident();

        //fazer a valida��o semantica
        vr.newLine();
        vr.appendBuffer("Step 3 - Checking semantic restrictions:\n");
        SemanticValidator sv = new SemanticValidator(model, vr);
        sv.validate();
        
        if ( !vr.isSuccess() )  {
            return vr;
        }
        vr.ident();
        vr.newLine();
        vr.appendBuffer("- Checking semantic restrictions OK.\n\n");
        vr.dident();
        
        return vr;
    }
    
    //-------------------------------------------------------------------------
    
    public void loadDomain()  {
        Unmarshaller u = null;
        JAXBContext jc = null;
        ValidationEventCollector vec = new ValidationEventCollector();
        
        try  {
            jc = JAXBContext.newInstance("captor.domainsystem");
            u = jc.createUnmarshaller();
            u.setEventHandler(vec);
        }
        catch(Exception e)  {
            vr.appendBuffer("Cannot load captor.domainsystem XML instance: " + e);
            vr.setSuccess(false);
            return;
        }
        
        String path = file.getAbsolutePath();
        
        try {
            JAXBElement<FormsType> element = (JAXBElement<FormsType>) u.unmarshal(new FileInputStream(path));
            forms = element.getValue();
        } catch (RuntimeException e1) {
            vr.appendBuffer("Cannot validade domain meta-model file: " + path);
            vr.setSuccess(false);
            return;
        } catch (FileNotFoundException e2)  {
            vr.appendBuffer("Cannot find file: " + path);
            vr.setSuccess(false);
            return;
        } catch ( JAXBException e3 )  {
            //guiView.setErrorView("Metal-model invalid format - " + e3.toString());
            //Esta exce��o vai ser tratada no vec.hasEvents   ;o)
        }
        
        StringBuffer buffer = new StringBuffer();
        if( vec.hasEvents() ) {
            ValidationEvent []ve = vec.getEvents();
            buffer = buffer.append("\n\nMetal-model syntax validation error:\n\n");
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
                
                ValidationEventLocator locator = ve[i].getLocator(); 
                buffer = buffer.append("       (" + i + ")        File: " + spath + "\n");
                buffer = buffer.append("       (" + i + ") Description: " + ve[i].getMessage() + "\n");
                buffer = buffer.append("       (" + i + ")    Severity: " + severity + "\n");
                buffer = buffer.append("\n");
                buffer = buffer.append("       (" + i + ")         Position: " + "\n");
                buffer = buffer.append("       (" + i + ")                Line Number: " + locator.getLineNumber() + "\n");
                buffer = buffer.append("       (" + i + ")              Column Number: " + locator.getColumnNumber() + "\n");
                buffer = buffer.append("       (" + i + ")                       Node: " + locator.getNode() + "\n");
                buffer = buffer.append("       (" + i + ")                        URL: " + locator.getURL() + "\n");
                buffer = buffer.append("\n------------------------------------------------------------------\n");
            }
            
            vr.appendBuffer(buffer);
            vr.setSuccess(false);
            return;
        }
        
        return;
    }
    
    //-------------------------------------------------------------------------
    
}
