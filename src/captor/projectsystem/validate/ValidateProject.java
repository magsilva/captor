package captor.projectsystem.validate;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.projectvalidator.FirstLayerValidator;
import captor.projectsystem.projectvalidator.SecondLayerValidator;
import captor.projectsystem.xmlgen.CompilerException;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.CustomRenderer;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * @author Kicho
 *
 */
public class ValidateProject {
    
    private Model model;
    
    public ValidateProject(Model model)  {
        this.model = model;
    }
    
    public boolean validate()  {

        if ( model.getProject() == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG54);
            return false;
        }
        
        if ( model.getProject().getStatus() == Project.CLOSED )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG54);
            return false;
        }
        
        //iniciar o processo com a validação
        model.getGui().getGuiView().setClearAllViews(true);
        if ( model.getGui().getGuiControl().getNodeError() != null )  {
	        //select the error node
            TreePath tp = new TreePath(model.getGui().getGuiControl().getNodeError().getPath());
	        model.getGui().getGuiControl().setNodeError(null);
	        model.getGui().getTree().setSelectionPath(tp);
	        
	        //updating all icons
            CustomRenderer customRenderer = new CustomRenderer(model);
            model.getGui().getTree().setCellRenderer(customRenderer);
        }

        //validação da primeira camada
        FirstLayerValidator fld = new FirstLayerValidator(model);
        if ( !fld.validate() )  {
            model.getGui().getGuiView().setErrorView("");
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG55);
            return false;
        }
        
        //validação da segunda camada
        SecondLayerValidator fld2 = new SecondLayerValidator(model);
        if ( !fld2.validate() )  {
            model.getGui().getGuiView().setErrorView("");
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(),  MyIntl.MSG56);
            return false;
        }
        
        if ( !thirdLayerValidate() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(),  MyIntl.MSG56);
            return false;
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    private boolean thirdLayerValidate()  {
        JTree tree = model.getGui().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
        try  {
            
            for ( int i = 0; i < root.getChildCount(); i++ )  {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
                
                for ( int j = 0; j < node.getChildCount(); j++ )  {
                    boolean flag = thirdLayerValidate2((DefaultMutableTreeNode) node.getChildAt(j));
                    if ( !flag )
                        return false;
                }
                
            }
            
        }
        catch(CompilerException e)  {
            return false;
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    private boolean thirdLayerValidate2(DefaultMutableTreeNode root) throws CompilerException {
        FormPath pp = (FormPath) root.getUserObject();
        
        if ( pp != null )  {
            FITBodyCard ife = pp.getCard();
            if ( ife != null )  {
                if ( !ife.validateAllFields() )  {
                    
                    model.getGui().getGuiView().setErrorView(MyIntl.VE_VALIDATE_PROJECT_1);
                    model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_VALIDATE_PROJECT_2, pp.getFullPath()));
                    
                    model.getGui().getGuiView().setErrorView(MyIntl.VE_VALIDATE_PROJECT_3);
                    model.getGui().getGuiView().setErrorView("");
                    
                    model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_VALIDATE_PROJECT_4, ife.getErrorMsg()));
                    return false;
                }
                
                int count = root.getChildCount();
                if ( count > 0 )  {
                    for ( int i = 0; i < count; i++ )  {
                        DefaultMutableTreeNode aux = (DefaultMutableTreeNode) root.getChildAt(i);
                        if ( !thirdLayerValidate2(aux) )
                            return false;
                    }
                }
                
            }
        }
        
        return true;
    }
    
}
