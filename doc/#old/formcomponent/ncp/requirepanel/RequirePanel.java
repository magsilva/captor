package captor.windowsystem.formcomponent.ncp.requirepanel;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.def.Constant;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;

/**
 * @author Kicho
 *
 */
public class RequirePanel extends FormComponent implements ActionListener {

    String id;
    JLabel textLabel;
    JButton plus;
    JButton minus;
    JButton edit;
    JList list;
    DefaultListModel listModel;
    
    public RequirePanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        id = "";
        listModel = new DefaultListModel();
        list = new JList(listModel);
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        textLabel = new JLabel("Require: ");
    }

    //-------------------------------------------------------------------------

    public void create2()  {
        
        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        textLabel = new JLabel("Require: ");
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JScrollPane scrollPane = new JScrollPane (list);

        Dimension d2 = new Dimension(433,90);
        scrollPane.setSize(d2);
        scrollPane.setPreferredSize(d2);
        scrollPane.setMaximumSize(d2);
        //main panel
        
        //button panel
        plus = new JButton("Add");
        plus.addActionListener(this);
        minus = new JButton("Remove");
        minus.addActionListener(this);
        edit = new JButton("Edit");
        edit.addActionListener(this);
        
        Dimension d = new Dimension(75,25);
        minus.setPreferredSize(d);
        minus.setMinimumSize(d);
        minus.setMaximumSize(d);

        plus.setPreferredSize(d);
        plus.setMinimumSize(d);
        plus.setMaximumSize(d);

        edit.setPreferredSize(d);
        edit.setMinimumSize(d);
        edit.setMaximumSize(d);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(edit);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
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
        
        if ( listModel.size() == 0 )
            return;
        
        out.newLine();
        out.ident();
        out.appendln("<require>");

        for ( int i = 0; i < listModel.size(); i++ )  {
            RequireValuesPanel tvp = (RequireValuesPanel) listModel.get(i);
            tvp.toXML(out);
        }

        out.appendln("</require>");
        out.dident();
}
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {

        for ( int i = 0; i < listModel.size(); i++ )  {
            RequireValuesPanel tvp = (RequireValuesPanel) listModel.get(i);
            String s = tvp.validateFields();
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
        String id = (String) parameter.get("ID");
        if ( id == null )
            return;
        
        NodeList nodeList = data.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("REQUIRE") )  {
                fillMainValues(node);
            }
        }
    }

    //-------------------------------------------------------------------------
    
    private void fillMainValues(Node xmlNode)  {
        NodeList nodeList = xmlNode.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node orNode = nodeList.item(i);
            if ( orNode.getNodeName().toUpperCase().equals("OR") )  {
                
                RequireValuesPanel rvp = new RequireValuesPanel(model, listModel, node);
                rvp.setEdit(true);
                rvp.load(orNode);
                
                if ( rvp.getListModel().size() > 0 )
                    listModel.addElement(rvp);
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
        if ( id == null )
            return false;

        return true;
    }
    
    //-------------------------------------------------------------------------

    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        v.add("id -   (required)");

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
		if ( e.getActionCommand().equals("Add") )  {
		    RequireValuesPanel tvp = new RequireValuesPanel(model, listModel, node);
		    tvp.setVisible(true);
		}        
		else if ( e.getActionCommand().equals("Remove") )  {
		    if ( listModel.getSize() > 0 && list.getMaxSelectionIndex() >= 0 )  {
		        listModel.remove(list.getMaxSelectionIndex());
				model.getProject().setStatus(Project.UNSAVED);
				
				//atualizar os ids da lista
		        for ( int j = 0; j < listModel.size(); j++ )  {
		            RequireValuesPanel rvp = (RequireValuesPanel) listModel.get(j);
		            rvp.setId(new Integer(j+1).toString());
		        }
		    }
		}        
		else if ( e.getActionCommand().equals("Edit") )  {
		    if ( listModel.getSize() > 0 && list.getMaxSelectionIndex() >= 0 )  {
		        RequireValuesPanel rvp = (RequireValuesPanel) listModel.getElementAt(list.getMaxSelectionIndex());
		        rvp.setVisible(true);
		    }
		}        
    }

    //-------------------------------------------------------------------------
}
