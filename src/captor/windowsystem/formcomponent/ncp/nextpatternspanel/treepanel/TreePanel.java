/*
 *
 */
package captor.windowsystem.formcomponent.ncp.nextpatternspanel.treepanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.CustomRenderer;
import captor.windowsystem.main.locationPane.util.FormPath;
import captor.windowsystem.util.IconUtil;
import captor.windowsystem.util.TreeUtil;


public class TreePanel extends JPanel implements ActionListener {
    
    public static final long serialVersionUID = 108;

    JPanel controlPane, control, historyPane;
    
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode []level;
    JTree tree;
    JScrollPane treePane;
    JPanel mainPane;
    JSplitPane splitPane;
    JLabel label = new JLabel(MyIntl.NAVIGATOR_LABEL);
    JButton button = new JButton("x");
    int currentPosition = 28;
    BodyPanel bodyPanel;
    DefaultMutableTreeNode sourceNode;
    
    private Model model;
    
    public TreePanel(Model model, DefaultMutableTreeNode sourceNode) {
        this.model = model;
        this.sourceNode = sourceNode;
        create();
    }
    
    public void create()  {
        FormPath pp = new FormPath();
        root = new DefaultMutableTreeNode(pp);
        pp.setTreeNode(root);
        
        createTree();
        treePane = new JScrollPane(tree);
        
        mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
        mainPane.add(treePane);
        mainPane.add(Box.createRigidArea(new Dimension(2,2)));
        
        //------------------------------
        
        label = new JLabel(MyIntl.NAVIGATOR_LABEL);
        button = new JButton();
        button.setBackground(Color.white);
        Dimension d = new Dimension(18, 19);
        button.setPreferredSize(d);
        button.setMaximumSize(d);
        
        Icon icon = IconUtil.getIcon("closeArrow.gif");
        
        button.setIcon(icon);
        button.addActionListener(this);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.add(Box.createRigidArea(new Dimension(2,6)));
        titlePanel.add(label);
        
        JPanel hHeader = new JPanel();
        hHeader.setMaximumSize(new Dimension(600, 30));
        hHeader.setLayout(new BoxLayout(hHeader, BoxLayout.X_AXIS));
        hHeader.add(titlePanel);
        hHeader.add(Box.createHorizontalGlue());
        hHeader.add(button);
        hHeader.add(Box.createRigidArea(new Dimension(2,3)));
        
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        hHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        //------------------------------
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(5,12)));
        add(hHeader);
        add(Box.createRigidArea(new Dimension(5,1)));
        add(mainPane);
        add(Box.createRigidArea(new Dimension(5,3)));
    }
    
    //-------------------------------------------------------------------------
    
    private void createTree()  {
        tree = new JTree(root);
        DefaultTreeModel treeModel = null;
        CustomRenderer customRenderer = new CustomRenderer(model);
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        tree.setCellRenderer(customRenderer);
        tree.setShowsRootHandles(false);
        loadNagivatorTree();
    }
    
    //-------------------------------------------------------------------------
    
    public void loadNagivatorTree()  {
        DefaultMutableTreeNode mainRoot = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        
        Object obj = sourceNode.getUserObject();
        FormPath fp = null;
        
        if ( obj instanceof FormPath )  {
            fp = (FormPath) obj;
        }
        
        if ( fp == null )
            return;
        
        for ( int i = 0; i < mainRoot.getChildCount(); i++ )  {
            if ( fp.getInteraction() == i )  {
                DefaultMutableTreeNode mainInteractionNode = (DefaultMutableTreeNode) mainRoot.getChildAt(i);
                makeInteraction(mainInteractionNode, i);
                TreeUtil.expandTree(tree);
            }
        }
        

    }
    
    private void makeInteraction(DefaultMutableTreeNode mainInteractionNode, int interactionNumber)  {
        DefaultMutableTreeNode newInteraction = new DefaultMutableTreeNode("Interaction " + new Integer(interactionNumber + 1).toString());
        root.insert(newInteraction, root.getChildCount());
        
        for ( int i = 0; i < mainInteractionNode.getChildCount(); i++ )  {
            DefaultMutableTreeNode mainCaptorProjectNode = (DefaultMutableTreeNode) mainInteractionNode.getChildAt(i);
            makeCaptorProject(mainCaptorProjectNode, newInteraction);
        }
    }
    
    private void makeCaptorProject(DefaultMutableTreeNode mainCaptorProjectNode, DefaultMutableTreeNode parentNode)  {
        for ( int i = 0; i < mainCaptorProjectNode.getChildCount(); i++ )  {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) mainCaptorProjectNode.getChildAt(i);
            Object obj = currentNode.getUserObject();
            if ( obj instanceof FormPath )  {
                FormPath fp = (FormPath) obj;
                FormPath newFP = fp.getCopy();
                newFP.setTreeNode(null);
                newFP.setCard(fp.getCard());
                
                DefaultMutableTreeNode newFormNode = new DefaultMutableTreeNode(newFP);
                newFP.setTreeNode(newFormNode);
                parentNode.insert(newFormNode, parentNode.getChildCount());
            }
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e) {
        if ( mainPane.isVisible() )  {
            mainPane.setVisible(false);
            label.setVisible(false);
            currentPosition = splitPane.getDividerLocation();
            splitPane.setDividerLocation(28);
            
            splitPane.setEnabled(false);
            
            Icon icon = IconUtil.getIcon("openArrow.gif");
            button.setIcon(icon);
        }
        else  {
            mainPane.setVisible(true);
            label.setVisible(true);
            
            splitPane.setEnabled(true);
            Icon icon = IconUtil.getIcon("closeArrow.gif");
            button.setIcon(icon);
            splitPane.setDividerLocation(currentPosition);
        }
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @param splitPane The splitPane to set.
     */
    public void setSplitPane(JSplitPane splitPane) {
        this.splitPane = splitPane;
    }
    
    /**
     * @return Returns the tree.
     */
    public JTree getTree() {
        return tree;
    }
    
    /**
     * @param bodyPanel The bodyPanel to set.
     */
    public void setBodyPanel(BodyPanel bodyPanel) {
        this.bodyPanel = bodyPanel;
        tree.addMouseListener(new TreeListener(tree, bodyPanel));
    }
    
    //-------------------------------------------------------------------------
}

