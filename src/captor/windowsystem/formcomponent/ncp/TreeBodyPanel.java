/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.FormPath;

public class TreeBodyPanel extends JPanel {
    public static final long serialVersionUID = 107;

    Model model;
    JSplitPane splitPane;
    TreePanel treePanel;
    BodyPanel bodyPanel;
    JScrollPane locationPanel;
    DefaultMutableTreeNode sourceNode;
    NextFormsPanel nfp;
    
    public TreeBodyPanel(Model model, DefaultMutableTreeNode sourceNode, NextFormsPanel nfp) {
        this.model = model;
        this.sourceNode = sourceNode;
        this.nfp = nfp;
        
        locationPanel = getLocationPanel();
        JScrollPane scrollBodyPanel = getBodyPanel2();
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, locationPanel, scrollBodyPanel);
        treePanel.setSplitPane(splitPane);
        treePanel.setBodyPanel(bodyPanel);
        splitPane.setDividerLocation(275);
        
        JScrollPane mainScrollPane = new JScrollPane(splitPane);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        this.setPreferredSize(new Dimension(950, 400));
        mainScrollPane.setPreferredSize(new Dimension(950, 400));
        this.setMinimumSize(new Dimension(750, 400));
        mainScrollPane.setMinimumSize(new Dimension(750, 400));
        
        this.add(mainScrollPane);
    }

    //-------------------------------------------------------------------------
    
    public boolean validateTree2()  {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePanel.getTree().getLastSelectedPathComponent();
        if ( node == null )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG112);
            return false;
        }
        
        Object obj = node.getUserObject();
        if ( !(obj instanceof FormPath) )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG112);
            return false;
        }
        
        //Forms root's node
        FormPath fp = (FormPath) obj;
        if ( fp.getFormType() == null )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG112);
            return false;
        }
        
        return true;
    }

    //-------------------------------------------------------------------------
    
    private JScrollPane getBodyPanel2()  {
        bodyPanel = new BodyPanel(model);
        bodyPanel.setEnabled(false);
        
        JScrollPane scrollLocation = new JScrollPane(bodyPanel);
        scrollLocation.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollLocation.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollLocation;
    }
    
    //-------------------------------------------------------------------------

    private JScrollPane getLocationPanel()  {
        treePanel = new TreePanel(model, sourceNode);
        JScrollPane scrollLocation = new JScrollPane(treePanel);
        scrollLocation.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollLocation.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollLocation;
    }

    /**
     * @return Returns the treePanel.
     */
    public TreePanel getTreePanel() {
        return treePanel;
    }
    
    public DefaultMutableTreeNode getLastSelectedNode()  {
        return (DefaultMutableTreeNode) treePanel.getTree().getLastSelectedPathComponent();
    }
    
    public BodyPanel getBodyPanel()  {
        return bodyPanel;
    }
    
    //-------------------------------------------------------------------------
}
