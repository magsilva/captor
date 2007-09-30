package captor.projectsystem.projectvalidator;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * @author Kicho
 *
 */
public class FirstLayerValidator extends LayerValidator  {

    public FirstLayerValidator(Model model)  {
        super(model);
    }
    
    protected boolean validate2(DefaultMutableTreeNode root) {

        //recursive call
        int count = root.getChildCount();
        if ( count > 0 )  {
            for ( int i = 0; i < count; i++ )  {
                DefaultMutableTreeNode aux = (DefaultMutableTreeNode) root.getChildAt(i);
                if ( !validate2(aux) ) 
                    	return false;
            }
        }
        
        int level = root.getLevel();
        
        //root level. this node is the root of the graph
        if ( level == 0 )  {
            return true;
        }
        
        //this node is a interaction node (i.e. Interaction1 or Interaction2 and so on)
        //and has no childs. This is ilegal under de law.
        if ( level == 1 && count == 0 )  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("The interaction: " + root + " has no child.<br>Please insert a form in this node or remove this interaction.<br>");
            return false;
        }
        
        //interaction node
        if ( level == 1 )  {
            return true;
        }
        
        FormPath pp = null;
        Object o = root.getUserObject();
        if ( o == null )  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("The form: " + root + " has not been initialized.<br>To build your project, please load some variant in this pattern or try to delete it.<br>");
            return false;
        }
        
        if ( o instanceof FormPath )  {
            pp = (FormPath) o;
        }
        else  {
            //me parece que isso nunca vai acontecer. porém, vamos tomar cuidado e manter uma validação de backup. 
            //se houver um eclipse solar poderemos remover esse "else" inteiro.
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("The form: " + root + " has not been correctly initialized.<br>");
            return false;
        }

        //if this node is a group and has no child
        if ( pp.getFormType() == null && count == 0 )  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("The interaction: " + root + " has no childs.<br>Please, insert a pattern or remove it.<br>");
            return false;
        }
        
        //esse nó nao tem card e é um padrão
        if ( pp.getCard() == null && pp.getFormType() != null)  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("The form: " + pp.getFullPath() + " has not been initialized.\nTo build your project, please load some variant in this pattern or try to delete it.<br>");
            return false;
        }
        
        return true;
    }
    
}
