package captor.projectsystem;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.build.BuilderLauncherThread;
import captor.projectsystem.clean.CleanProject;
import captor.projectsystem.close.CloseProject;
import captor.projectsystem.open.OpenProject;
import captor.projectsystem.save.SaveProject;
import captor.projectsystem.saveas.SaveProjectAs;
import captor.projectsystem.util.LongTask;
import captor.projectsystem.validate.ValidateProject;
import captor.windowsystem.ProjectPropertiesWindow;
import captor.windowsystem.projectmanager.build.ProgressLauncher;

/**
*
* This class is the facade desing pattern for project management requirements.
* 
* <p>
* It has methods to build, save, clean, save as, open and close a 
* project.
* </p>
*
* @author Kicho
*/
public class ProjectSystem {
    
    private Model model;
    
    public ProjectSystem(Model model)  {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public void openProject()  {
        if ( model.getProject() != null && model.getProject().getStatus() != Project.CLOSED )  {
            if ( ! closeProject() )  {
                return;
            }
        }
        
        OpenProject op = new OpenProject(model);
        op.open();
    }   
    
    public void openProject(String path)  {
        if ( model.getProject() != null && model.getProject().getStatus() != Project.CLOSED )  {
            if ( ! closeProject() )  {
                return;
            }
        }
        
        OpenProject op = new OpenProject(model);
        op.open(path);
    }
    
    //-------------------------------------------------------------------------

    public void build()  {
        if ( model.getGui().getGuiControl().getFormError() != null )
            model.getGui().getGuiControl().getFormError().setBorder(null);
        
        //verificando o estado do model.getProject()
        if ( model.getProject() == null || model.getProject()== null || model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG32);
            return;
        }
        
        //se o projeto não estiver salvo não será possível continuar o processo de compilação
        if ( model.getProject().getStatus() != Project.SAVED )  {
            int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), MyIntl.MSG33, MyIntl.MSG34,  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if ( res != JOptionPane.OK_OPTION )  {
                return;
            }
            SaveProject sp = new SaveProject(model);
            if ( !sp.save() )
                return;
        }

        model.getGui().getGuiView().setClearAllViews(true);
        
        //isso lança a janela da barra de progresso
        LongTask task = new LongTask();
        ProgressLauncher pl = new ProgressLauncher(model, task);
        pl.start();
        
        //lança a thread que faz o build
        BuilderLauncherThread bt = new BuilderLauncherThread(model, task);
        bt.start();
        
        return;
    }
    
    //-------------------------------------------------------------------------

    public boolean validate()  {
        if ( model.getGui().getGuiControl().getFormError() != null )
            model.getGui().getGuiControl().getFormError().setBorder(null);
        
        ValidateProject vp = new ValidateProject(model);
        if ( !vp.validate() )  {
            return false;
        }

        JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG35);
        return true;
    }
    
    //-------------------------------------------------------------------------

    public boolean save()  {
        if ( model.getGui().getGuiControl().getFormError() != null )
            model.getGui().getGuiControl().getFormError().setBorder(null);

        SaveProject sp = new SaveProject(model);
        return sp.save();
    }
    
    //-------------------------------------------------------------------------
    
    public void saveAs(String name, String baseDir, String outputDir)  {
        if ( model.getGui().getGuiControl().getFormError() != null )
            model.getGui().getGuiControl().getFormError().setBorder(null);

        SaveProjectAs spa = new SaveProjectAs(model);
        spa.saveAs(name, baseDir, outputDir);
    }
    
    //-------------------------------------------------------------------------
    
    public void showProperties()  {
        if ( model.getProject() == null || model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG36);
        }
        else  {
            ProjectPropertiesWindow pp = new ProjectPropertiesWindow(model);
            pp.setVisible(true);
        }
    }
    
    //-------------------------------------------------------------------------

    public void clean()  {
        CleanProject cp = new CleanProject(model);
        cp.clean();
    }

    //-------------------------------------------------------------------------

    public boolean closeProject()  {
        CloseProject cp = new CloseProject(model);
        return cp.closeProject();
    }
    
    //-------------------------------------------------------------------------
}
