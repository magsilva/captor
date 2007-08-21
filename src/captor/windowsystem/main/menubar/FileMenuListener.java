package captor.windowsystem.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.NewProjectWindow;


public class FileMenuListener implements ActionListener  {

    private Model model;
    
    public FileMenuListener(Model model) {
        this.model = model;
    }

    public void actionPerformed (ActionEvent e) {
//        System.out.println (e.getActionCommand());
        
        if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_EXIT) )  {
            model.getGui().getGuiControl().setExit(true);
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_PROJECT) )  {
            if ( model.getProject() != null )  {
	            ProjectSystem pm = new ProjectSystem(model);
	            if ( pm.closeProject() )  {
	                NewProjectWindow np = new NewProjectWindow(model);
	                np.setVisible(true);
	                return;
	            }
	            else  {
	                JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG81);	                
	            }
            }
            else  {
                NewProjectWindow np = new NewProjectWindow(model);
                np.setVisible(true);
            }
            
        }      
        else if ( e.getActionCommand().equals("lastOpenProject1") )  {
            openProject(model.getConfig().getGuiHiddenConfig().getLastOpenProject1());
        }      
        else if ( e.getActionCommand().equals("lastOpenProject2") )  {
            openProject(model.getConfig().getGuiHiddenConfig().getLastOpenProject2());
        }      
        else if ( e.getActionCommand().equals("lastOpenProject3") )  {
            openProject(model.getConfig().getGuiHiddenConfig().getLastOpenProject3());
        }      
        else if ( e.getActionCommand().equals("lastOpenProject4") )  {
            openProject(model.getConfig().getGuiHiddenConfig().getLastOpenProject4());
        }      

    }
    
    //-------------------------------------------------------------------------
    
    private void openProject(String path)  {
        ProjectSystem pm = new ProjectSystem(model); 
        pm.openProject(path);
    }
    
    //-------------------------------------------------------------------------
}
