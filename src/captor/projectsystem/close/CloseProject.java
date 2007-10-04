package captor.projectsystem.close;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.save.SaveProject;


/**
 * @author Kicho
 *
 */
public class CloseProject {
    
    private Model model;
    
    public CloseProject(Model model)  {
        this.model = model;
    }

    //-------------------------------------------------------------------------

    public boolean closeProject()  {
        if ( model.getProject() == null ) {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG25);
            return true;
        }
        
        int status = model.getProject().getStatus();
        if ( status == Project.CLOSED ) {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG26);
            return true;
        }
        else if ( status == Project.UNSAVED ) {
            int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), MyIntl.MSG27, MyIntl.MSG28,  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if ( res == JOptionPane.OK_OPTION )  {
                SaveProject sp = new SaveProject(model);
                if ( ! sp.save() )
                    return false;
            }
            
            closeProject2();
        }
        else if ( status == Project.SAVED )  {
            closeProject2();
        }
        
        model.getGui().getGuiControl().setCloseProject(true);
        model.getGui().getGuiView().setClearAllViews(true);
        
        return true;
    }

    //-------------------------------------------------------------------------

    private void closeProject2()  {
        model.getProject().setStatus(Project.CLOSED);
        model.getProject().setFormsType(null);
        model.setProject(null);
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getGui().getTree().getModel().getRoot();
        root.removeAllChildren();
        ((DefaultTreeModel)model.getGui().getTree().getModel()).reload(root);
        
        if ( model.getProject() != null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG29, model.getProject().getName()));
        }
    }

    //-------------------------------------------------------------------------
}
