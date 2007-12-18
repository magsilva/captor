package captor.projectsystem.saveas;

import java.io.File;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.lib.util.FileUtil;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.close.CloseProject;
import captor.projectsystem.open.OpenProject;
import captor.projectsystem.save.SaveProject;


/**
 * @author Kicho
 *
 */
public class SaveProjectAs {

    private Model model;
    
    public SaveProjectAs(Model model)  {
        this.model = model;
    }

    //-------------------------------------------------------------------------
    
    public void saveAs(String name, String baseDir, String outputDir)  {
        
        //verificar o estado do projeto atual
        if ( model.getProject() == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG43);
            return;
        }
        
        if ( model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG43);
            return;
        }
        
        File filePathDir = new File(baseDir);
        if ( filePathDir.exists() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG44, filePathDir.getAbsolutePath()));
            return;
        }
        
        
        //verificar se o projeto esta salvo
        if ( model.getProject().getStatus() != Project.SAVED ) {
            int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), MyIntl.MSG45, MyIntl.MSG46,  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if ( res == JOptionPane.OK_OPTION )  {
                SaveProject sp = new SaveProject(model);
                if ( ! sp.save() )
                    return;
            }
            else  {
                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG47);
                return;
            }
        }
        
        model.getGui().getGuiView().setClearAllViews(true);

        //------------------------------------------------------------------
        
        if ( !filePathDir.exists() )  {
            filePathDir.mkdirs();
        }

        File outputDirectory = new File(outputDir);
        if ( !outputDirectory.exists() )  {
            outputDirectory.mkdirs();
        }
        if ( !outputDirectory.isDirectory() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG48, outputDirectory.getAbsolutePath()));
        }            
        
        File fitFile = new File(model.getProject().getPath(), model.getProject().getName().concat(".cap"));
        if ( !fitFile.exists() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG49, fitFile.getAbsolutePath()));
            return;
        }
        
        //copiar os arquivos do projeto para o outputDirectory
        File currInputDir = new File(model.getProject().getInputFolder());
        model.getGui().getGuiView().setClearAllViews(true);
        model.getGui().getGuiView().setConsoleView("<b>Copying directory " + currInputDir.getAbsolutePath() + " into " + filePathDir.getAbsolutePath() + "</b><br>");
        if ( !FileUtil.cloneDir(currInputDir, filePathDir) )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG50, currInputDir.getAbsolutePath(), filePathDir.getAbsolutePath()));
            return;
        }
        
        File fileInputDir = new File(filePathDir.getAbsolutePath(), "input");
        if ( !fileInputDir.exists() )  { 
            if ( !fileInputDir.mkdirs() )  {
                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG51, fileInputDir.getAbsolutePath()));
            }
        }
        if ( !fileInputDir.isDirectory() )  { 
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG52, fileInputDir.getAbsolutePath()));
        }            

        model.getGui().getGuiView().setConsoleView("<b>Updating files...</b><br>");
        //editar o arquivo do projeto para atualizar o novo path
        Project project = new Project(model);
        project.loadDefault(true);
        project.setName(name);
        project.setStatus(model.getProject().getStatus());
        project.setDomain(model.getProject().getDomain());
        project.setPath(filePathDir.getAbsolutePath());
        project.setInputFolder(fileInputDir.getAbsolutePath());
        project.setOutputFolder(outputDirectory.getAbsolutePath());
        project.save();
        model.getGui().getGuiView().setConsoleView("<br><b><font color=\"#009933\">Updating files - OK</font></b><br>");
        
        //perguntar se o usuario quer abrir o novo projeto
        int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), MyIntl.MSG53, MyIntl.MSG46,  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if ( res == JOptionPane.OK_OPTION )  {
            CloseProject cp = new CloseProject(model);
            cp.closeProject();
            
            File newFitFile = new File(project.getPath(), project.getName().concat(".cap"));
            OpenProject op = new OpenProject(model);
            op.open(newFitFile);
        }        
    }
    
    //-------------------------------------------------------------------------
}
