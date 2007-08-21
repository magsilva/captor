package captor.windowsystem.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.projectmanager.saveas.SaveAsWindow;


public class ProjectMenuListener implements ActionListener  {

    private Model model;

    public ProjectMenuListener(Model model) {
        this.model = model;
    }

    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_OPEN) )  {
            ProjectSystem pm = new ProjectSystem(model);
            pm.openProject();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_PROPERTIES) )  {
            ProjectSystem pm = new ProjectSystem(model);
            pm.showProperties();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_VALIDATE) )  {
            ProjectSystem pj = new ProjectSystem(model);
            pj.validate();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_SAVE) )  {
            model.getGui().getGuiView().setClearAllViews(true);
            ProjectSystem pj = new ProjectSystem(model);
            pj.save();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_SAVEAS) )  {
            //verificar o estado do projeto atual
            if ( model.getProject() == null )  {
                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG80);
                return;
            }
            
            if ( model.getProject().getStatus() == Project.CLOSED )  {
                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG80);
                return;
            }
            
            SaveAsWindow saw = new SaveAsWindow(model);
            saw.setVisible(true);
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_CLEAN) )  {
            ProjectSystem pj = new ProjectSystem(model);
            pj.clean();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_CLOSE) )  {
            ProjectSystem pm = new ProjectSystem(model); 
            pm.closeProject();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_BUILD) )  {
            ProjectSystem pj = new ProjectSystem(model);
            pj.build(); 
        }
        
    }
    
    //-------------------------------------------------------------------------
}
