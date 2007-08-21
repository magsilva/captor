package captor.projectsystem.build.mapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * This class load the mapper trasnfomation file into memory 
 * before the generation process occurs.
 * 
 * @author Kicho
 *
 */
public class Mapper {

    private String filename;
    private Model model;
    
    public Mapper(Model model, String filename)  {
        this.filename = filename;
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public ComposerType load()  {
        Unmarshaller u = null;
        JAXBContext jc = null;
        ValidationEventCollector vec = new ValidationEventCollector();
        Composer composer = null;
        
        try  {
            jc = JAXBContext.newInstance("captor.projectsystem.build.mapper");
            u = jc.createUnmarshaller();
            
            u.setValidating(true);
            u.setEventHandler(vec);
        }
        catch(Exception e)  {
            String msgError = "Cannot load captor.projectsystem.build.mapper XML instance: " + StringUtil.formatOutput(e.toString()) + "<br>";
            model.getGui().getGuiView().setErrorView(msgError);		
            throw new RuntimeException(msgError);
        }
        
        try {
            composer = ((Composer)u.unmarshal(new FileInputStream(filename)));
        } catch (RuntimeException e1) {
            String msgError = "Cannot validade mapper meta-model file: " + filename + "<br>";
            model.getGui().getGuiView().setErrorView(msgError);
            //throw new RuntimeException("Cannot validade domain meta-model file: " + filename);
        } catch (FileNotFoundException e2)  {
            String msgError = "<font color=\"#FF0000\"><b>Cannot find file:</b></font> " + filename + "<br>";
            model.getGui().getGuiView().setErrorView(msgError);
            throw new RuntimeException("Cannot find file: " + msgError);
        } catch ( JAXBException e3 )  {
            //this exception is been take it in the vec.hasEvents   ;o)
        }
        
        if( vec.hasEvents() ) {
            ValidationEvent []ve = vec.getEvents();
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Mapper file invalid format:</b></font><br><br>");
            model.getGui().getGuiView().setErrorView("");
            String spath = filename.replace("\\\\", "\\");
            for ( int i = 0; i < ve.length; i++ )  {
                int severityNumber = ve[i].getSeverity();
                String severity = "";
                if ( severityNumber == ValidationEvent.ERROR )
                    severity = "ERROR";
                else if ( severityNumber == ValidationEvent.FATAL_ERROR )
                    severity = "FATAL ERROR";
                else if ( severityNumber == ValidationEvent.WARNING )
                    severity = "WARNING";
                String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                ValidationEventLocator locator = ve[i].getLocator(); 
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>File:</b> " + spath + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;<b>Description:</b> " + StringUtil.formatOutput(ve[i].getMessage()) + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Severity:</b> " + severity + "<br>");
                model.getGui().getGuiView().setErrorView("<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Position:</b> " + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Line Number:</b> " + locator.getLineNumber() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;<b>Column Number:</b> " + locator.getColumnNumber() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Node:</b> " + locator.getNode() + "<br>");
                model.getGui().getGuiView().setErrorView(space + "(" + i + ")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>URL:</b> " + locator.getURL() + "<br>");
                model.getGui().getGuiView().setErrorView("<br>");

                int index = ve[i].getMessage().indexOf("Possible tag names are");
                
//              if ( ve[i].getMessage().equals("Unexpected element {}:callTask") ||
//              ve[i].getMessage().equals("Unexpected element {}:if") ||
//              ve[i].getMessage().equals("Unexpected element {}:for-each") )  {
              if ( index != -1 ) {
                    model.getGui().getGuiView().setErrorView("This usually means that you put a statement in the wrong position.<br>");
                    model.getGui().getGuiView().setErrorView("<br>Remember:<br><br>");
                    model.getGui().getGuiView().setErrorView(" - In the statements tag, you aways have to put the statements: callTask, if and for-each tag in this order.<br>");
                    model.getGui().getGuiView().setErrorView(" - After the if tag, you aways have to put the statements: callTask, ifTask and for-each tag in this order.<br>");
                    model.getGui().getGuiView().setErrorView(" - After the for-each tag, you aways have to put the statements: callTask, ifTask and for-each tag in this order.<br>");
                    model.getGui().getGuiView().setErrorView("");
                }
                
                throw new RuntimeException("Mapper file invalid format");
            }
        }
        
        return composer;
    }

    //-------------------------------------------------------------------------

}