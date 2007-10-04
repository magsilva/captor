package captor.windowsystem.formcomponent.ncp.requirepanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.util.MyKeyEventDispatcher;

/**
 * @author Kicho
 *
 */
public class RequireValuesPanel extends CaptorFrame implements ActionListener, KeyListener, MouseListener  {
    
    private MyKeyEventDispatcher kev;

    Hashtable map = new Hashtable();
    
    JTextField requireValueTF = new JTextField();
    JTextField idTF = new JTextField();
    JButton okButton = new JButton("Add");
    JButton removeButton = new JButton("Remove");
    JList list;
    DefaultMutableTreeNode myTreeNode;
    
    DefaultListModel parentListModel;
    DefaultListModel listModel;
    
    boolean edit = false;

    public RequireValuesPanel(Model model, DefaultListModel parentListModel, DefaultMutableTreeNode myTreeNode) {
        super(model);
        this.parentListModel= parentListModel;
        this.myTreeNode = myTreeNode;
        idTF.setText(new Integer(parentListModel.size()+1).toString());
        idTF.setEnabled(false);
        init2();
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        setLayout(new BorderLayout());
        setCenterSize(400, 380);
        setState(Frame.NORMAL);
        setTitle("Require values panel");
        addWindowListener(this);
        kev = new MyKeyEventDispatcher(this);         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);        
    }
    
    //-------------------------------------------------------------------------
    
    protected void init2() {
        this.getContentPane().add(header(), BorderLayout.PAGE_START);
        this.getContentPane().add(body(), BorderLayout.CENTER);
        this.getContentPane().add(footer(), BorderLayout.PAGE_END);
        requireValueTF.addKeyListener(this); 
        requireValueTF.requestFocusInWindow();
        list.addMouseListener(this);
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel header()  {
        JPanel panel = new JPanel();
        panel.add(new JLabel(" "));
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel footer()  {
        JPanel panel = new JPanel();
        
        Dimension d = new Dimension(100,20);
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        ok.setSize(d);
        ok.setPreferredSize(d);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setSize(d);
        cancel.setPreferredSize(d);
        
        panel.add(ok);
        panel.add(Box.createRigidArea(new Dimension(5,5)));
        panel.add(cancel);
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JScrollPane body()  {
        Dimension d = new Dimension(280,230);
        
        //main panel
        d = new Dimension(280,230);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(d);
        panel.setPreferredSize(d);
        
        //id panel
        JLabel label = new JLabel("Id:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        d = new Dimension(90,12);
        label.setSize(d);
        label.setPreferredSize(d);
        
        d = new Dimension(200,20);
        idTF.setSize(d);
        idTF.setPreferredSize(d);
        
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        idPanel.add(label);
        idPanel.add(Box.createRigidArea(new Dimension(4,4)));
        idPanel.add(idTF);
        idPanel.add(new JLabel("   "));
        
        //require panel
        label = new JLabel("Require path:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        d = new Dimension(90,12);
        label.setSize(d);
        label.setPreferredSize(d);
        
        d = new Dimension(200,20);
        requireValueTF.setSize(d);
        requireValueTF.setPreferredSize(d);
        
        JPanel requirePanel = new JPanel();
        requirePanel.setLayout(new BoxLayout(requirePanel, BoxLayout.X_AXIS));
        requirePanel.add(label);
        requirePanel.add(Box.createRigidArea(new Dimension(4,4)));
        requirePanel.add(requireValueTF);
        requirePanel.add(new JLabel("   "));
        
        //buttons panel
        d = new Dimension(250,25);
        okButton.setSize(d);
        okButton.setPreferredSize(d);
        okButton.addActionListener(this);
        
        removeButton.setSize(d);
        removeButton.setPreferredSize(d);
        removeButton.addActionListener(this);
        
        d = new Dimension(350,25);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setSize(d);
        buttonPanel.setPreferredSize(d);
        
        buttonPanel.add(Box.createRigidArea(new Dimension(253,4)));
        buttonPanel.add(okButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(4,4)));
        buttonPanel.add(removeButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,4)));
        
        //list panel
        listModel = new DefaultListModel();
        list = new JList(listModel);
        d = new Dimension(200,350);
        list.setSize(d);
        list.setPreferredSize(d);
        
        JScrollPane scrollList = new JScrollPane(list);
        scrollList.setSize(d);
        scrollList.setPreferredSize(d);
        
        d = new Dimension(350,200);
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.X_AXIS));
        listPanel.setSize(d);
        listPanel.setPreferredSize(d);
        
        label = new JLabel("Require path list:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        d = new Dimension(90,12);
        label.setSize(d);
        label.setPreferredSize(d);
        
        listPanel.add(label);
        listPanel.add(scrollList);
        buttonPanel.add(Box.createRigidArea(new Dimension(5,4)));
        listPanel.add(new JLabel("   "));
        
        //main panel 
        
        panel.add(Box.createRigidArea(new Dimension(250,5)));
        panel.add(idPanel);
        panel.add(Box.createRigidArea(new Dimension(250,35)));
        panel.add(requirePanel);
        panel.add(Box.createRigidArea(new Dimension(250,10)));
        panel.add(buttonPanel);
        panel.add(Box.createRigidArea(new Dimension(250,10)));
        panel.add(listPanel);
        panel.add(Box.createRigidArea(new Dimension(250,10)));
        
        d = new Dimension(290,300);
        JScrollPane scrollPane = new JScrollPane (panel);
        scrollPane.setSize(d);
        scrollPane.setPreferredSize(d);
        
        return scrollPane;
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    protected void windowClosing2(WindowEvent e) {
        dispose();
    }

    //-------------------------------------------------------------------------
    
    public String toString()  {
        return idTF.getText();
    }
    
    //-------------------------------------------------------------------------
    
    public DefaultListModel getListModel() {
        return listModel;
    }
    
    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;
    }
    
    //-------------------------------------------------------------------------
    
    public void toXML(CCBuffer out)  {
        
        
        out.ident();
        out.appendln("<or>");
        
        out.ident();
        out.append("<id>");
        out.append(idTF.getText(),true);
        out.appendln("</id>",true);
        out.dident();
        
        for ( int j = 0; j < listModel.size(); j++ )  {
            if ( listModel.get(j).toString().trim().equals("") )
                continue;
            out.ident();
            out.append("<formPath>");
            out.append(formatPath(listModel.get(j).toString()),true);
            out.appendln("</formPath>",true);
            out.dident();
        }
        
        out.appendln("</or>");
        out.dident();
        
    }
    
    //-------------------------------------------------------------------------
    
    private String formatPath(String path)  {
        char ppath [] = path.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean isInt = false;
        for ( int i = 0; i < ppath.length; i++ )  {
            
            while ( StringUtil.charIsInt(ppath[i]) && i < ppath.length )  {
                sb.append(ppath[i]);
                isInt = true;
                i++;
            }
            
            if ( isInt )  {
                sb.append(".*");
                isInt = false;
            }
            
            sb.append(ppath[i]);
        }
        return sb.toString();
    }

    //-------------------------------------------------------------------------
    
    public void load(Node xmlNode)
    {
        NodeList nodeList = xmlNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node requireNode = nodeList.item(i);
            
            if (requireNode.getNodeName().toUpperCase().equals("ID"))  {
                idTF.setText(requireNode.getFirstChild().getNodeValue());
            } else if (requireNode.getNodeName().toUpperCase().equals("FORMPATH")) {
                String path = requireNode.getFirstChild().getNodeValue();
                path = path.replaceAll("\\.\\*", "");
                listModel.addElement(path);
            }
        }
    }

    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e) {
        
        if ( e.getActionCommand().equals("Add") )  {
            addValidate();
            requireValueTF.requestFocusInWindow();
        }
        else if ( e.getActionCommand().equals("OK") )  {
            //validar o idpanel
            if ( idTF.getText().trim().equals("") )  {
                JOptionPane.showMessageDialog(this, "The id panel cannot be blank.");
                return;
            }
            
            //validar pelo menos 1 no list model
            if ( listModel.size() == 0 )  {
                JOptionPane.showMessageDialog(this, "The require list needs at least 1 item.");
                return;
            }
            
            if ( !edit )  {
                parentListModel.addElement(this);
            }
            
            edit = true;
            setVisible(false);
        }
        else if ( e.getActionCommand().equals("Remove") )  {
            int index = list.getSelectedIndex();
            if ( index < 0 )
                return;
            
            listModel.removeElementAt(index);
            model.getProject().setStatus(Project.UNSAVED);
        }
        else if ( e.getActionCommand().equals("Cancel") )  {
            setVisible(false);
            dispose();
        }
    }
   
    //-------------------------------------------------------------------------
    
    public boolean isEdit() {
        return edit;
    }
    
    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    //-------------------------------------------------------------------------
    
    public String validateFields()  {
        
        for ( int j = 0; j < listModel.size(); j++ )  {
            PathValidator pathValidator = new PathValidator(model, myTreeNode, this);
            pathValidator.setInValidadeFields(true);
            if ( ! pathValidator.validate(listModel.get(j).toString()) )  {
                return pathValidator.getErrorMsg();
            }
        }        
        
        return null;
    }
    

    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e)  {
        if ( e.getKeyCode() == 10 )  {
            addValidate();
            requireValueTF.requestFocusInWindow();
        }
        else if ( e.getKeyCode() == 27 )  {
            setVisible(false);
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void setId(String id)  {
        idTF.setText(id);   
    }

    //-------------------------------------------------------------------------
    
    public void addValidate()  {
        String value = requireValueTF.getText();
        value = value.trim();
        requireValueTF.setText(value);
        if ( value.equals("") )  {
            return;
        }
        
        //verify if this path already exists in the list path (listModel object)
        if ( !verifyExists() )  {
            JOptionPane.showMessageDialog(this, "This path already exists in the path list.");
            return;
        }
    
        PathValidator pathValidator = new PathValidator(model, myTreeNode, this);
        if ( pathValidator.validate(value) )  {
            listModel.addElement(value);
            requireValueTF.setText("");
            requireValueTF.requestFocusInWindow();
        }
        else  {
            JOptionPane.showMessageDialog(this, pathValidator.getErrorMsg());
        }
    }

    //-------------------------------------------------------------------------
    
    boolean verifyExists()  {
        for ( int j = 0; j < listModel.size(); j++ )  {
            String path = listModel.get(j).toString().trim();
            if ( path.equals("") ) 
                continue;
            
            if ( path.equals(requireValueTF.getText().trim()) )  {
                return false;
            }
        }        
        
        return true;
    }

    //-------------------------------------------------------------------------

    public void mouseClicked(MouseEvent e)   {
        int index = list.getSelectedIndex();
        if ( index < 0 )
            return;
        
        String s = (String) listModel.getElementAt(index);
        requireValueTF.setText(s);
    }
    
    public void mouseEntered(MouseEvent e)   {}
    public void mouseExited(MouseEvent e)    {}
    public void mousePressed(MouseEvent e)   {}
    public void mouseReleased(MouseEvent e)  {}
    
    //-------------------------------------------------------------------------
}
