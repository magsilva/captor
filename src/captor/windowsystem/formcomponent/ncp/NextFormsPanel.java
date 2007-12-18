package captor.windowsystem.formcomponent.ncp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.domainsystem.FormId;
import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.Parameter;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * @author Kicho
 *
 */
public class NextFormsPanel extends FormComponent implements ActionListener  {

    public static final long serialVersionUID = 105;

    String id;
    JLabel textLabel;
    JButton plus, minus, edit, up, down;
    
    JList list;
    DefaultListModel listModel;
    
    public NextFormsPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        id = "";
        listModel = new DefaultListModel();
        list = new JList(listModel);
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        textLabel = new JLabel(MyIntl.NCP_LABEL_NEXTFORMS);
    }

    //-------------------------------------------------------------------------

    public void create2()  {
        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        textLabel = new JLabel(MyIntl.NCP_LABEL_NEXTFORMS);
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JScrollPane scrollPane = new JScrollPane (list);

        Dimension d2 = new Dimension(432,150);
        scrollPane.setSize(d2);
        scrollPane.setPreferredSize(d2);
        scrollPane.setMaximumSize(d2);
        //main panel
        
        //button panel
        plus = new JButton(MyIntl.NCP_LABEL_ADD);
        plus.addActionListener(this);
        minus = new JButton(MyIntl.NCP_LABEL_REMOVE);
        minus.addActionListener(this);
        edit = new JButton(MyIntl.NCP_LABEL_EDIT);
        edit.addActionListener(this);
        up = new JButton(MyIntl.NCP_LABEL_UP);
        up.addActionListener(this);
        down = new JButton(MyIntl.NCP_LABEL_DOWN);
        down.addActionListener(this);
        
        Dimension d = new Dimension(80,25);
        minus.setPreferredSize(d);
        minus.setMinimumSize(d);
        minus.setMaximumSize(d);

        plus.setPreferredSize(d);
        plus.setMinimumSize(d);
        plus.setMaximumSize(d);

        edit.setPreferredSize(d);
        edit.setMinimumSize(d);
        edit.setMaximumSize(d);

        up.setPreferredSize(d);
        up.setMinimumSize(d);
        up.setMaximumSize(d);

        down.setPreferredSize(d);
        down.setMinimumSize(d);
        down.setMaximumSize(d);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(edit);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(up);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(down);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        //button panel

        panel.add(textLabel);
        panel.add(scrollPane);
        panel.add(new JLabel(" "));
        panel.add(bPanel);
        panel.add(Box.createHorizontalGlue());

        this.add(panel);
    }

    //-------------------------------------------------------------------------
    
    public void parseParameters()  {
        String id2 = (String) parameter.get("ID");
        if ( id2 != null )  {
            id = id2;
        } 
        
        create2();
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        if ( listModel.size() > 0 )  {
            out.newLine();
            out.ident();
            out.appendln("<nextForms>");
            out.ident();

            for ( int i = 0; i < listModel.size(); i++ )  {
                NextFormBean nfp = (NextFormBean) listModel.get(i);
                nfp.toXML(out);
            }
            
            out.dident();
            out.appendln("</nextForms>");
            out.dident();
        }
    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {

        for ( int i = 0; i < listModel.size(); i++ )  {
            NextFormBean nfp = (NextFormBean) listModel.get(i);
            String s = nfp.validate();
            if ( s != null )  {
                cleanErrorLine();
                addErrorLine(s);
                return false;
            }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    public void load(Node data)  {
        NodeList nodeList = data.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("NEXTFORMS") )  {
                NodeList nodeList2 = node.getChildNodes();
                for ( int j = 0; j < nodeList2.getLength(); j++ )  {
                    Node node2 = nodeList2.item(j);
                    if ( node2.getNodeName().toUpperCase().equals("NEXTFORM") )  {
                        NodeList nodeList3 = node2.getChildNodes();
                        String id = "";
                        String minChilds = "";
                        String maxChilds = "";
                        for ( int k = 0; k < nodeList3.getLength(); k++ )  {
                            Node node3 = nodeList3.item(k);
                            if ( node3.getNodeName().toUpperCase().equals("ID") )  {
                                id = node3.getFirstChild().getNodeValue();
                                FormId formId = new FormId(id);
                                id = formId.getPart(0);
                            }
                            if ( node3.getNodeName().toUpperCase().equals("MINCHILDS") )  {
                                minChilds = node3.getFirstChild().getNodeValue();
                            }
                            if ( node3.getNodeName().toUpperCase().equals("MAXCHILDS") )  {
                                maxChilds = node3.getFirstChild().getNodeValue();
                            }
                        }
                        
                        NextFormBean fb = new NextFormBean(model);
                        fb.setMinChilds(minChilds);
                        fb.setMaxChilds(maxChilds);
                        fb.setFormId(id);
                        addNFB(fb);
                    }                    
                }
            }
        }
        
    }

    //-------------------------------------------------------------------------
    
    public String getId()  {
        return id;
    }
    
    //-------------------------------------------------------------------------

    public boolean validateParameters()  {
        String id = (String) parameter.get("ID");
        if ( id == null )  {
            errorMsg = MyIntl.NCP_LABEL_NF_ERROR1;
            return false;
        }

        return true;
    }
    
    //-------------------------------------------------------------------------

    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        v.add(new Parameter("id"           , "string", "", "1"            , "Unique identifier"                           , "", true));

        return v;
    }
    
    //-------------------------------------------------------------------------
    
    public DefaultListModel getListModel() {
        return listModel;
    }
    
    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;
    }

    //-------------------------------------------------------------------------

    public void updateValues()  {
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {
        return "";
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_ADD) )  {
            NextFormFrame nfp = new NextFormFrame(model, this);
            nfp.setVisible(true);
        }        
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_REMOVE) )  {
            if ( listModel.getSize() > 0 && list.getMaxSelectionIndex() >= 0 )  {
                int res = JOptionPane.showConfirmDialog((Component)model.getGui().getCaptorWindow(), MyIntl.MSG110, MyIntl.MSG111, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if ( res == JOptionPane.OK_OPTION )  {
                    listModel.remove(list.getMaxSelectionIndex());
                    model.getProject().setStatus(Project.UNSAVED);
                }
            }
        }        
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_EDIT) )  {
            if ( listModel.getSize() > 0 && list.getMaxSelectionIndex() >= 0 )  {
                NextFormBean nfb = (NextFormBean) listModel.getElementAt(list.getMaxSelectionIndex());
                NextFormFrame nfp = new NextFormFrame(model, this, nfb);
                nfp.setVisible(true);
            }
        }        
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_UP) )  {
            int index = list.getSelectedIndex();
            if ( index == 0 || index == -1)
                return;
            
            Object obj1 = listModel.getElementAt(index-1);
            Object obj2 = listModel.getElementAt(index);
            
            listModel.setElementAt(obj2, index-1);
            listModel.setElementAt(obj1, index);
            
            list.setSelectedIndex(index-1);
            list.ensureIndexIsVisible(index-1);
            model.getProject().setStatus(Project.UNSAVED);
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_DOWN) )  {
            int index = list.getSelectedIndex();
            if ( index == listModel.getSize()-1  || index == -1)
                return;
            
            Object obj1 = listModel.getElementAt(index);
            Object obj2 = listModel.getElementAt(index+1);
            
            listModel.setElementAt(obj1, index+1);
            listModel.setElementAt(obj2, index);
            
            list.setSelectedIndex(index+1);
            list.ensureIndexIsVisible(index+1);
            model.getProject().setStatus(Project.UNSAVED);
        }
        
    }

    //-------------------------------------------------------------------------

    public void enableButtons(boolean enable)  {
        plus.setEnabled(enable);
        minus.setEnabled(enable);
        edit.setEnabled(enable);
        up.setEnabled(enable);
        down.setEnabled(enable);
    }
    
    //-------------------------------------------------------------------------
    
    public void addNFB(NextFormBean nfb)  {
        listModel.addElement(nfb);
    }
    
    //-------------------------------------------------------------------------
    
    public boolean containNode(DefaultMutableTreeNode selectedNode)  {
        for ( int i = 0; i < listModel.getSize(); i++ )  {
            NextFormBean nfb = (NextFormBean) listModel.get(i);
            
            if ( !(selectedNode.getUserObject() instanceof FormPath) )
                continue;
            
            if ( !(nfb.getNode().getUserObject() instanceof FormPath) )
                continue;

            FormPath fp1 = (FormPath) selectedNode.getUserObject();
            FormPath fp2 = (FormPath) nfb.getNode().getUserObject();
            
            if ( fp1.getCard() == fp2.getCard() )  {
                return true;
            }
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------
}    

