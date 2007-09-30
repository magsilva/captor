package captor.windowsystem.formcomponent.ncp.fcomponentpanel;

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

import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.ncp.fcomponentpanel.bean.Element;
import captor.windowsystem.formcomponent.ncp.fcomponentpanel.bean.Parameter;

public class FComponentPanel  extends FormComponent implements ActionListener {
    
    public static final long serialVersionUID = 14;

    JButton plus, minus, edit, up, down;
    DefaultListModel listModel;
    JList list;

    public FComponentPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        Dimension d = new Dimension(490,140);
        
        listModel = new DefaultListModel();
        list = new JList(listModel);

        Dimension d1 = new Dimension(432,150);
        Dimension d2 = new Dimension(400,120);

        JScrollPane scrollPane = new JScrollPane(list);
        
        list.setSize(d2);
        list.setPreferredSize(d2);
        list.setMaximumSize(d2);

        scrollPane.setSize(d1);
        scrollPane.setPreferredSize(d1);
        scrollPane.setMaximumSize(d1);
        
        JLabel textLabel = new JLabel(MyIntl.NCP_LABEL_FE);
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
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
        
        
        d = new Dimension(80,25);
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
        
        //panel.add(Box.createRigidArea(new Dimension(10,0)));
        panel.add(textLabel);
        panel.add(scrollPane);
        panel.add(new JLabel(" "));
        panel.add(bPanel);
        panel.add(Box.createHorizontalGlue());

        this.add(panel);
    }

    //-------------------------------------------------------------------------

    public void parseParameters()  {
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        out.newLine();
        out.ident();
        out.appendln("<formComponents>");

        for ( int i = 0; i < listModel.getSize(); i++ )  {
            Element element = (Element) listModel.getElementAt(i);
            element.toXML(out);
        }
        
        out.appendln("</formComponents>");
        out.dident();
    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {
        if ( listModel.getSize() == 0 )  {
            cleanErrorLine();
            addErrorLine(MyIntl.MSG113);
            return false;
        }
        
        Element element = null;
        for ( int i = 0; i < listModel.getSize(); i++ )  {
            element = (Element) listModel.getElementAt(i);
            String s = element.validate(this);
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
        String fullname = "";
        Vector parameters = new Vector();
        
        NodeList nodeList = data.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("FORMCOMPONENTS") )  {
                NodeList nodeList2 = node.getChildNodes();
                for ( int j = 0; j < nodeList2.getLength(); j++ )  {
                    Node node2 = nodeList2.item(j);
                    if ( node2.getNodeName().toUpperCase().equals("FORMCOMPONENT") )  {
                        NodeList nodeList3 = node2.getChildNodes();
                        for ( int k = 0; k < nodeList3.getLength(); k++ )  {
                            Node node3 = nodeList3.item(k);
                            if ( node3.getNodeName().toUpperCase().equals("FULLNAME") )  {
                                fullname = node3.getFirstChild().getNodeValue(); 
                            }
                            if ( node3.getNodeName().toUpperCase().equals("PARAMETERS") )  {
                                parameters = new Vector();
                                NodeList nodeList4 = node3.getChildNodes();
                                for ( int m = 0; m < nodeList4.getLength(); m++ )  {
                                    Node node4 = nodeList4.item(m);
                                    if ( node4.getNodeName().toUpperCase().equals("PARAMETER") )  {
                                        NodeList nodeList5 = node4.getChildNodes();
                                        Parameter pt = new Parameter();
                                        for ( int n = 0; n < nodeList5.getLength(); n++ )  {
                                            Node node5 = nodeList5.item(n);
                                            if ( node5.getNodeName().toUpperCase().equals("NAME") )  {
                                                if ( node5.getFirstChild()!= null )
                                                    pt.setName(node5.getFirstChild().getNodeValue());
                                            }                                    
                                            if ( node5.getNodeName().toUpperCase().equals("VALUE") )  {
                                                if ( node5.getFirstChild()!= null )
                                                    pt.setValue(node5.getFirstChild().getNodeValue());
                                            }                                    
                                        }
                                        parameters.add(pt);
                                    }                                    
                                }
                            }
                        }
                        
                        Element element = new Element(model);
                        element.setClassname(fullname);
                        element.setParameters(parameters);
                        addElement(element);
                    }                    
                }
            }
        }
    }
    
    //-------------------------------------------------------------------------

    public String getId()  {
        return "";
    }
    
    //-------------------------------------------------------------------------

    public boolean validateParameters()  {
        return true;
    }
    
    //-------------------------------------------------------------------------

    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        return v;
    }
    
    //-------------------------------------------------------------------------

    public void updateValues()  {
    }
    
    //-------------------------------------------------------------------------

    public void addElement(Element element)  {
        int index = listModel.getSize();
        for ( int i = 0; i < index; i++ )  {
            Element element2 = (Element) listModel.getElementAt(i);
            if ( element == element2 )  {
                list.setSelectedIndex(i);
                list.ensureIndexIsVisible(i);
                return;
            }
        }
        
        listModel.insertElementAt(element, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_ADD) )  {
                FElementChooserFrame fec = new FElementChooserFrame(model, this);
                fec.setVisible(true);
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_REMOVE) )  {
        	int index = list.getSelectedIndex();
        	if ( index != -1 )  {
                int res = JOptionPane.showConfirmDialog((Component)model.getGui().getCaptorWindow(), MyIntl.MSG92, MyIntl.MSG93, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if ( res == JOptionPane.OK_OPTION )  {
            	    listModel.removeElementAt(index);
                	model.getProject().setStatus(Project.UNSAVED);
                }
        	}
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_EDIT) )  {
            
        	int index = list.getSelectedIndex();
        	if ( index != -1 )  {
                Element element = (Element) listModel.getElementAt(index);
                FElementChooserFrame fec = new FElementChooserFrame(model, this, element);
                fec.setVisible(true);
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
    
    public String getValues()  {
        return "";
    }

    //-------------------------------------------------------------------------
    
    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;
    }
    
    //-------------------------------------------------------------------------
}    

