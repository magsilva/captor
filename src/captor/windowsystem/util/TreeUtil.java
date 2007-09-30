/*
 *
 */
package captor.windowsystem.util;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeUtil {

    //-------------------------------------------------------------------------

    public static void expandTree(JTree tree)  {
        if ( tree == null )
            return;
        
        for ( int i = 0; i < tree.getRowCount(); i++ ) {
            tree.expandRow(i);
        }
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        if ( root == null )
            return;
        
        expandNode(tree, root, new TreePath(root));
    }
    
    //-------------------------------------------------------------------------

    public static void expandNode(JTree tree, TreeNode node, TreePath path)  {
        if ( node.getChildCount() == 0 )  {
            tree.makeVisible(new TreePath(path)); 
            return;
        }
        
        for ( int i = 0; i < node.getChildCount(); i++ ) {
            TreeNode child = node.getChildAt(i);
            expandNode(tree, child , new TreePath(child));
        } 
    }
    
    //-------------------------------------------------------------------------
}
