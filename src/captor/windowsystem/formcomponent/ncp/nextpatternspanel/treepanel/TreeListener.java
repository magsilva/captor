/*
 *
 */
package captor.windowsystem.formcomponent.ncp.nextpatternspanel.treepanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeListener extends MouseAdapter {

    JTree tree;
    BodyPanel bodyPanel;
    
    public TreeListener(JTree tree, BodyPanel bodyPanel) {
        this.tree = tree;
        this.bodyPanel = bodyPanel;
    }
    
    //-------------------------------------------------------------------------

    public void mouseClicked(java.awt.event.MouseEvent event)  {
        if( event.getModifiers() == MouseEvent.BUTTON1_MASK )  {
            showForm();
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void showForm()  {
        bodyPanel.loadForm((DefaultMutableTreeNode) tree.getLastSelectedPathComponent());
    }
    
    //-------------------------------------------------------------------------
}
