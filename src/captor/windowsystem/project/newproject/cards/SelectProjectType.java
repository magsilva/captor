package captor.windowsystem.project.newproject.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.domainsystem.DomainSystem;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.project.newproject.Body;



public class SelectProjectType extends FITCard implements KeyListener {
    
    public static final long serialVersionUID = 127;

    private static String DOMAINS = MyIntl.NEW_PROJECT_WINDOW_DOMAINS;
    
    JLabel wizards;
    JPanel panel;
    
    DefaultMutableTreeNode root;
    JTree tree;
    JScrollPane treePane;
    
    private Body body;
    
    
    public SelectProjectType(Model model, Project project, Body body) {
        super(model, project);
        this.body = body;
    }
    
    public void create()  {
        this.setLayout(null);
        
        wizards = new JLabel(MyIntl.NEW_PROJECT_WINDOW_WIZARDS);
        wizards.setBounds(new Rectangle(15,10,100,10));
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(new Rectangle(15,25,505,290));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        DomainSystem d = new DomainSystem(model);
        root = new DefaultMutableTreeNode(DOMAINS);
        Vector domains = d.getDomainNames();
        DefaultMutableTreeNode first = null;

        DefaultMutableTreeNode firstNode = new DefaultMutableTreeNode("New Captor Project"); 
        root.add(firstNode);
        
        for (int i = 0; i < domains.size(); i++ )  {
            String s = (String) (domains.get(i));
            if ( s.equals("New Captor Project") )  {
                continue;
            }
            
            if ( i == 0 )  {
                first = new DefaultMutableTreeNode(domains.get(i)); 
                root.add(first);
            }
            else  {
                root.add(new DefaultMutableTreeNode(domains.get(i)));
            }
        }
        
        tree = new JTree(root);
        tree.addKeyListener(this);
        
        if ( first != null )  {
            TreePath tp = new TreePath(firstNode.getPath());
            tree.setSelectionPath(tp);
        }
        
        treePane = new JScrollPane(tree);
        panel.add(treePane);
        
        add(wizards);
        add(panel, BorderLayout.CENTER);
    }    
    
    public boolean validateFields()  {
        
        if ( tree.getSelectionPath() == null )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG89);
            return false;
        }
        
        String node = tree.getSelectionPath().getLastPathComponent().toString();
        if ( node.equals(DOMAINS) )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG89);
            return false;
        }
        
        project.setDomain(node);
        return true;
    }
    
    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e)  {
        //o enter foi pressionado
        if ( e.getKeyCode() == 10 )  {
            body.next();
        }
    }
    
    //-------------------------------------------------------------------------
}
