package captor.windowsystem.main.locationPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.CustomRenderer;
import captor.windowsystem.main.locationPane.util.FormPath;
import captor.windowsystem.util.IconUtil;


public class TreePane extends JPanel implements Observer, ActionListener {
    
    public static final long serialVersionUID = 155;

    JPanel controlPane, control, historyPane;
    
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode []level;
    JTree tree;
    JScrollPane treePane;
    Color color;
    JPanel mainPane;
    
    JLabel label = new JLabel(MyIntl.NAVIGATOR_LABEL);
    JButton button = new JButton("x");
    private Model model;
    
    public TreePane(Model model) {
        this.model = model;
        color = new Color(132, 132, 132);
        color = Color.white;
        
        create();
    }
    
    public void create()  {
        
        FormPath pp = new FormPath();
        root = new DefaultMutableTreeNode(pp);
        pp.setTreeNode(root);

        createTree();
        treePane = new JScrollPane(tree);
        treePane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));  
        tree.addMouseListener(new FormNavigatorPopup(tree, model));

        mainPane = new JPanel();
        //mainPane.setBackground(color);
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
        //hHeader.setBackground(color);
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
        //setBackground(color);
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
        model.getGui().setTree(tree);
    }
    
    //-------------------------------------------------------------------------
    
    public void update(Observable observable, Object obj)  {
//        System.out.println("HistoryPane Notificado!");
    }
    
    //-------------------------------------------------------------------------
    
    public void loadDomain()  {
        if ( level != null )  {
	        for ( int i = 0; i < level.length; i++ )  {
	            if( level[i] != null )  {
	                root.remove(level[i]);
	            }
	        }
        }
        
        ((DefaultTreeModel)tree.getModel()).reload(root);
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e) {
        if ( mainPane.isVisible() )  {
            mainPane.setVisible(false);
            label.setVisible(false);
            
            model.getGui().getGuiControl().setHideNavigator(false);
            
            Icon icon = IconUtil.getIcon("openArrow.gif");
            
            button.setIcon(icon);
        }
        else  {
            mainPane.setVisible(true);
            label.setVisible(true);
            model.getGui().getGuiControl().setHideNavigator(true);
            Icon icon = IconUtil.getIcon("closeArrow.gif");
            button.setIcon(icon);
        }
    }

    //-------------------------------------------------------------------------
}
