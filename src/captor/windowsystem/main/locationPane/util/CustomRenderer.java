/*
 *
 */
package captor.windowsystem.main.locationPane.util;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import captor.modelsystem.Model;
import captor.windowsystem.util.IconUtil;


/**
 * @author Kicho
 *
 */
public class CustomRenderer extends DefaultTreeCellRenderer{
    
    public static final long serialVersionUID = 156;

    Model model;
    
    public CustomRenderer(Model model){
        this.model = model;
    }
    
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus){
        Component result = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object obj = node.getUserObject();
        
        FormPath pp = null;
        if ( obj instanceof FormPath )
            pp = (FormPath) node.getUserObject();
        
        Icon icon = null;

        if ( model != null && 
                model.getGui() != null && 
                model.getGui().getGuiControl() != null && 
                model.getGui().getGuiControl().getNodeError() != null &&
                model.getGui().getGuiControl().getNodeError() == node ) {
            icon = IconUtil.getIcon("error.gif");
        }
        else if ( root == node || pp == null)  {
            icon = IconUtil.getIcon("rootnode.gif");
        }
        else  {
            icon = IconUtil.getIcon("patternnode.gif");
        }


        if ( icon != null )
            setIcon(icon);
        
        return result;
    }
    
}