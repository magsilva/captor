package captor.projectsystem.clean;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;


/**
 * @author Kicho
 *
 */
public class CleanProject {
    
    private Model model;
    
    public CleanProject(Model model)  {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public void clean()  {
        if ( model.getProject() == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG19);
            return;
        }
        
        if ( model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG19);
            return;
        }
        
        String outputFolder = model.getProject().getOutputFolder();
        File outputDir = new File(outputFolder);
        
        if ( !outputDir.exists() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG20, outputFolder));
            throw new RuntimeException(StringUtil.formatMessage(MyIntl.MSG20, outputFolder));
        }
        
        if ( !outputDir.isDirectory() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG21, outputFolder));
            throw new RuntimeException(StringUtil.formatMessage(MyIntl.MSG20, outputFolder));
        }
        
        //confirmar a ação:
        int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), "Are you sure that you want to recursively delete all interaction directorys located into: " + outputDir.getAbsolutePath() + "?", "Clean project", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if ( res != JOptionPane.OK_OPTION )  {
            return;
        }        
        
        model.getGui().getGuiView().setClearAllViews(true);
        File []files = outputDir.listFiles();
        boolean removed = false;
        for ( int i = 0; i < files.length; i++ )  {
            if ( files[i].isDirectory() )  {
                
                if ( files[i].getName().length() > 10 )  {
	                if ( files[i].getName().substring(0, 11).equals("interaction") ) {
	                    
	                    try {
	                        FileUtils.deleteDirectory(files[i]);
	                        model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_CLEAN_PROJECT_1, files[i].getAbsolutePath()));
	                        removed = true;
	                    } catch (IOException e) {
                            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG22, files[i].getAbsolutePath()));
	                        return;
	                    }
	                }
                }
            }
        }
        
        if ( removed ) 
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG23);
        else
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG24);
    }
    
    //-------------------------------------------------------------------------
}
