package captor.projectsystem.save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.validate.ValidateProject;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.projectsystem.xmlgen.XMLGenerator;


/**
 * @author Kicho
 *
 */
public class SaveProject {

    private Model model;
    
    public SaveProject(Model model)  {
        this.model = model;
    }

    //-------------------------------------------------------------------------

    public boolean save()  {
        if ( model.getProject() == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG37);
            return false;
        }
        
        if ( model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG37);
            return false;
        }

        if ( model.getProject().getStatus() == Project.SAVED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG38);
            return false;
        }

        ValidateProject vp = new ValidateProject(model);
        if ( !vp.validate() )  {
            return false;
        }

        //gerando o XML a partir dos dados da interface
        XMLGenerator xmlGen = new XMLGenerator(model);
        Vector buffer = xmlGen.gen(false);
        if ( buffer == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG39);
        	return false;
        }
        
        //salvando efetivamente as interações
        save(buffer);
        
        model.getProject().setStatus(Project.SAVED);
        return true;
    }

    //-------------------------------------------------------------------------

    public void save(Vector out)  {
        
        //apagar todos os arquivos do inputFolder
        String path = model.getProject().getInputFolder();
        try {
            File f = new File(path);
            if  ( !f.exists() )  {
                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG40, f.getAbsolutePath()));
                return;
            }
            FileUtils.cleanDirectory(f);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG41, e.toString()));
            return;
        }
        
        for ( int i = 0; i < out.size(); i++ )  {
	        path = model.getProject().getInputFolder();
	        path = path.concat(System.getProperty("file.separator"));
	        path = path.concat("interaction_".concat(new Integer(i).toString())).concat(".fit");
	        
	        FileOutputStream fos;
	        
	        try {
	            fos = new FileOutputStream(path);
	            CCBuffer buffer = (CCBuffer) out.get(i);
	            CopyUtils.copy(buffer.getBuffer().toString(), fos);
	            fos.flush();
	            fos.close();
	        } catch (FileNotFoundException e1) {
	            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG42, e1.getMessage()));
	        } catch (IOException e2) {
	            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG42, e2.getMessage()));
	        }
        }
    }

    //-------------------------------------------------------------------------
}
