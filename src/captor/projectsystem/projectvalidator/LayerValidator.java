/*
 *
 */
package captor.projectsystem.projectvalidator;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public abstract class LayerValidator {

    /**
     *
     */
    protected Model model;
    
    public LayerValidator(Model model) {
        super();
        this.model = model;
    }

    public void showErrorTitle()  {
        model.getGui().getGuiView().setErrorView("<b>Project Domain:</b> " + model.getProject().getDomain() + "<br>");
        model.getGui().getGuiView().setErrorView("<b>Project Name:</b>" + model.getProject().getName() + "<br><br>");
    }

    public boolean validate() {

        JTree tree = model.getGui().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
        return validate2(root);
    }
    
    protected abstract boolean validate2(DefaultMutableTreeNode root);
}
