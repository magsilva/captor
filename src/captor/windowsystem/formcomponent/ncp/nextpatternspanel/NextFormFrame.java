package captor.windowsystem.formcomponent.ncp.nextpatternspanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.lib.intl.MyIntl;
import captor.lib.util.IntegerUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.ncp.nextpatternspanel.treepanel.TreeBodyPanel;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * @author Kicho
 *
 */
public class NextFormFrame extends CaptorFrame implements ActionListener {
    
    public static final long serialVersionUID = 104;

    private JComboBox minChildscombo, maxChildscombo;
    DefaultComboBoxModel minChildsComboModel, maxChildsComboModel;
    private NextFormsPanel nfp;
    private NextFormBean nfbean = null;
    private TreeBodyPanel treeBodyPanel;
    
    public NextFormFrame(Model model, NextFormsPanel nfp) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.nfp = nfp;
        init2();
    }
    
    public NextFormFrame(Model model, NextFormsPanel nfp, NextFormBean nfbean) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.nfp = nfp;
        this.nfbean = nfbean;
        init2();
    }
    
    //-------------------------------------------------------------------------
    protected void init() throws Exception {}
    
    protected void init2() {
        
        setLayout(new BorderLayout());
        setCenterSize(950, 550);
        setResizable(true);
        setState(Frame.NORMAL);
        setTitle(MyIntl.NCP_LABEL_NEXTFORMS);
        addWindowListener(this);
        this.setMaximizedBounds(new Rectangle(0, 0, 1000, 620));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().add(header(), BorderLayout.PAGE_START);
        this.getContentPane().add(body(), BorderLayout.CENTER);
        
        if ( nfbean != null )  {
            updateValues();
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel header()  {
        JPanel panel = new JPanel();
        panel.add(new JLabel(" "));
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel body()  {
        JPanel minChildsPanel = new JPanel();
        minChildsPanel.setLayout(new BoxLayout(minChildsPanel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel(MyIntl.NCP_LABEL_MIN_CHILDS);
        label.setPreferredSize(new Dimension(100,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        String choices[] = {"0", "1", "2", "3","5", "10"};
        minChildsComboModel = new DefaultComboBoxModel();
        for (int i=0;i<choices.length;i++) {
            minChildsComboModel.addElement(choices[i]);
        }
        
        minChildscombo = new JComboBox(minChildsComboModel);
        minChildscombo.setEditable(true);
        
        minChildscombo.setPreferredSize(new Dimension(118,22));
        minChildscombo.setSelectedIndex(0);
        
        minChildsPanel.add(label);
        minChildsPanel.add(minChildscombo);
        minChildsPanel.add(Box.createHorizontalGlue());
        
        //--------------------------
        
        JPanel maxChildsPanel = new JPanel();
        maxChildsPanel.setLayout(new BoxLayout(maxChildsPanel, BoxLayout.X_AXIS));
        
        label = new JLabel(MyIntl.NCP_LABEL_MAX_CHILDS);
        label.setPreferredSize(new Dimension(100,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        String choices2[] = {"N", "1", "2", "3","5", "10"};
        maxChildsComboModel = new DefaultComboBoxModel();
        for (int i=0;i<choices.length;i++) {
            maxChildsComboModel.addElement(choices2[i]);
        }
        maxChildscombo = new JComboBox(maxChildsComboModel);

        maxChildscombo.setEditable(true);
        maxChildscombo.setPreferredSize(new Dimension(118,22));
        maxChildscombo.setSelectedIndex(0);

        maxChildscombo.setMaximumSize(new Dimension(124,20));
        minChildscombo.setMaximumSize(new Dimension(124,20));

        
        maxChildsPanel.add(label);
        maxChildsPanel.add(maxChildscombo);
        maxChildsPanel.add(Box.createHorizontalGlue());
        
        //--------------------------

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        JButton okButton = new JButton(MyIntl.NCP_LABEL_OK);
        JButton cancelButton = new JButton(MyIntl.NCP_LABEL_CANCEL);
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        label = new JLabel(" ");
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        buttonPanel.add(label);
        buttonPanel.add(okButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalGlue());
        
        //-----------
        treeBodyPanel = new TreeBodyPanel(model, nfp.getNode(), nfp);
        JScrollPane scrollFTP = new JScrollPane(treeBodyPanel);
        scrollFTP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollFTP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        framePanel.add(scrollFTP);
        framePanel.add(Box.createRigidArea(new Dimension(5,20)));
        framePanel.add(minChildsPanel);
        framePanel.add(Box.createRigidArea(new Dimension(5,20)));
        framePanel.add(maxChildsPanel);
        framePanel.add(Box.createRigidArea(new Dimension(5,20)));
        framePanel.add(buttonPanel);
        framePanel.add(Box.createRigidArea(new Dimension(5,20)));
        
        return framePanel;
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_OK) )  {
            if ( ok() )  {
                closeMe();
            }
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_CANCEL) )  {
            closeMe();
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void closeMe()  {
        this.setVisible(false);
        enabledButtons();
        model.getGui().getGuiControl().setLoadedPattern(true);
    }

    //-------------------------------------------------------------------------

    private boolean ok()  {

        //validar o combo
        String minChildsValue = (String) minChildscombo.getSelectedItem();
        try {
            Integer i = new Integer(minChildsValue);
            if ( i.intValue() < 0 )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG62);
                return false;
            }
        } catch (NumberFormatException e1) {
            if ( !minChildsValue.toUpperCase().equals("N") && !minChildsValue.toUpperCase().equals("*") )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG63);
                return false;
            }
        }
        
        String maxChildsValue = (String) maxChildscombo.getSelectedItem();
        try {
            Integer i = new Integer(maxChildsValue);
            if ( i.intValue() < 1 )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG64);
                return false;
            }
        } catch (NumberFormatException e1) {
            if ( !maxChildsValue.toUpperCase().equals("N") && !maxChildsValue.toUpperCase().equals("*") )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG65);
                return false;
            }
        }

        if ( !maxChildsValue.toUpperCase().trim().equals("N") )  {
            if ( new Integer(maxChildsValue).intValue() < new Integer(minChildsValue).intValue() )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG107);
                return false;
            }
        }

        if ( nodeEqual(treeBodyPanel.getLastSelectedNode(), (DefaultMutableTreeNode)model.getGui().getTree().getLastSelectedPathComponent()) )  {
            if ( !IntegerUtil.isInt(minChildsValue) || new Integer(minChildsValue).intValue() != 0 )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG108);
                return false;
            }
        }

        //node selection validation
        if ( !treeBodyPanel.validateTree2() )  {
            return false;
        }

        if ( nfbean == null && nfp.containNode(treeBodyPanel.getLastSelectedNode()) )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG109);
            return false;
        }

        //validation OK
        //now edit or insert it
        boolean isNew = false;
        if ( nfbean == null )  {
            nfbean = new NextFormBean(model);
            isNew = true;
        }

        if ( !maxChildsValue.equals(nfbean.getMaxChilds()) 
                || !minChildsValue.equals(nfbean.getMinChilds()) 
                || !nodeEqual(treeBodyPanel.getLastSelectedNode(), nfbean.getNode())
                )   {
            model.getProject().setStatus(Project.UNSAVED);
        }
        
        nfbean.setNode(treeBodyPanel.getLastSelectedNode());
        nfbean.setMaxChilds(maxChildsValue);
        nfbean.setMinChilds(minChildsValue);
        
        if ( isNew )  {
            model.getProject().setStatus(Project.UNSAVED);
            nfp.addNFB(nfbean);
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    public void enabledButtons()  {
        JTree tree = treeBodyPanel.getTreePanel().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        
        for ( int i = 0; i < root.getChildCount(); i++ )  {
            DefaultMutableTreeNode interactionNode = (DefaultMutableTreeNode) root.getChildAt(i);
            
            for ( int j = 0; j < interactionNode.getChildCount(); j++ )  {
                DefaultMutableTreeNode formNode = (DefaultMutableTreeNode) interactionNode.getChildAt(j);
                Object obj = formNode.getUserObject();
                if ( obj instanceof FormPath )  {
                    FormPath fp = (FormPath) obj;
                    
                    FITBodyCard card = fp.getCard();
                    if ( card != null )  {
                        for ( int k = 0; k < card.getFormElList().size(); k++ )  {
                            Object obj2 = card.getFormElList().get(k);
                            if ( obj2 instanceof NextFormsPanel )  {
                                NextFormsPanel nfp = (NextFormsPanel) obj2;
                                nfp.enableButtons(true);
                            }
                        }
                    }
                }            
            }
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void updateValues()  {
        boolean hasItem = false;
        String s = "";
        
        for ( int i = 0; i < minChildscombo.getItemCount(); i++ )  {
            s = (String) minChildscombo.getItemAt(i);
            if ( s.equals(nfbean.getMinChilds()) )  {
                minChildscombo.setSelectedIndex(i);
                hasItem = true;
                break;
            }
        }
        
        if ( !hasItem )  {
            minChildsComboModel.addElement(nfbean.getMinChilds());
            minChildscombo.setSelectedItem(nfbean.getMinChilds());
        }
        
        hasItem = false;
        for ( int i = 0; i < maxChildscombo.getItemCount(); i++ )  {
            s = (String) maxChildscombo.getItemAt(i);
            if ( s.equals(nfbean.getMaxChilds()) )  {
                maxChildscombo.setSelectedIndex(i);
                break;
            }
        }
        
        if ( !hasItem )  { 
            maxChildsComboModel.addElement(nfbean.getMaxChilds());
            maxChildscombo.setSelectedItem(nfbean.getMaxChilds());
        }
        
        JTree tree = treeBodyPanel.getTreePanel().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        for ( int i = 0; i < root.getChildCount(); i++ )  {
            DefaultMutableTreeNode interactionNode = (DefaultMutableTreeNode) root.getChildAt(i);
            
            for ( int j = 0; j < interactionNode.getChildCount(); j++ )  {
                DefaultMutableTreeNode formNode = (DefaultMutableTreeNode) interactionNode.getChildAt(j);
                
                if ( !(formNode.getUserObject() instanceof FormPath) )
                    continue;
                
                if ( !(nfbean.getNode().getUserObject() instanceof FormPath) )
                    continue;

                FormPath fp1 = (FormPath) formNode.getUserObject();
                FormPath fp2 = (FormPath) nfbean.getNode().getUserObject();
                
                if ( fp1.getCard() == fp2.getCard() )  {
                    TreePath tp = new TreePath(formNode.getPath());
                    tree.setSelectionPath(tp);
                    treeBodyPanel.getBodyPanel().loadForm((DefaultMutableTreeNode) formNode);
                    return;
                }
            }            
        }        
    }
    
    //-------------------------------------------------------------------------
    
    private boolean nodeEqual(DefaultMutableTreeNode node1, DefaultMutableTreeNode node2)  {
        
        if ( node1 == null || node2 == null )
            return false;
        
        if ( !(node1.getUserObject() instanceof FormPath) )
            return false;
        
        if ( !(node2.getUserObject() instanceof FormPath) )
            return false;

        FormPath fp1 = (FormPath) node1.getUserObject();
        FormPath fp2 = (FormPath) node2.getUserObject();
        
        if ( fp1.getCard() == fp2.getCard() )  {
            return true;
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------
}
