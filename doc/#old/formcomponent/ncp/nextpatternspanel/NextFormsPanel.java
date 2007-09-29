/*
 *
 */
package captor.windowsystem.formcomponent.ncp.nextpatternspanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.domainsystem.DomainSystem;
import captor.lib.def.Constant;
import captor.lib.formtree.FormNode;
import captor.lib.formtree.FormTree;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.main.bodyPane.ICards;


/**
 * @author Kicho
 *
 */
public class NextFormsPanel extends FormComponent implements ActionListener  {

    JButton plus, minus;
    DefaultTableModel tableModel;
    JTable table;
    
    private String[] columnNames = {"id", "multiplicity"};
    String data[][] = {{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
            		   {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
            		   {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
            		   {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""}};

    public NextFormsPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);

        Dimension d = new Dimension(433,85);
        table.setSize(d);
        table.setPreferredSize(d);
        table.setMaximumSize(d);
        scrollPane.setSize(d);
        scrollPane.setPreferredSize(d);
        scrollPane.setMaximumSize(d);
        //table.setPreferredScrollableViewportSize(new Dimension(318, 50));
        
        
        
        JLabel textLabel = new JLabel("Next forms: ");
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        plus = new JButton("Add");
        plus.addActionListener(this);
        minus = new JButton("Remove");
        minus.addActionListener(this);
        d = new Dimension(75,25);
        minus.setPreferredSize(d);
        minus.setMinimumSize(d);
        minus.setMaximumSize(d);

        plus.setPreferredSize(d);
        plus.setMinimumSize(d);
        plus.setMaximumSize(d);
        
        
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
        bPanel.add(Box.createRigidArea(new Dimension(5,30)));
        
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
        out.appendln("<nextForms>");
        out.ident();

        Vector vmodel = tableModel.getDataVector();
        for ( int i = 0; i < vmodel.size(); i++ )  {
            Vector vdata = (Vector) vmodel.get(i);
            String id = (String) vdata.get(0);
            String multiplicity = (String) vdata.get(1);
            
            if ( id.equals("") )
                continue;
            
            out.appendln("<nextForm>");
            out.ident();
            out.append("<id>");
            out.append(id + ".*", true);
            out.appendln("</id>", true);
            
            out.append("<multiplicity>");
            out.append(multiplicity, true);
            out.appendln("</multiplicity>", true);
            
            out.dident();
            out.appendln("</nextForm>");
        }
        
        out.dident();
        out.appendln("</nextForms>");
        out.dident();

    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {
        FormTree ftree = new FormTree(model);
        FormNode root = ftree.getRoot();
        int lowRes = 0;
        int highRes = 0;
        boolean flag = true;
        
        
        Vector idList = getIdList(root);
        Vector npList = getNpList();
        
        for ( int i = 0; i < npList.size(); i++ )  {
            String npId = (String) npList.get(i);
            if ( !npId.equals("") )  {
	            for ( int j = 0; j < idList.size(); j++ )  {
	                String lId = (String) idList.get(j);
	                if ( new DomainSystem(model).compareId(lId, npId + ".*") ) 
	                    break;
	                
	                if (j == idList.size() -1 )  {
	                    cleanErrorLine();
	                    addErrorLine("NextForm validation error.\n\n    There is no form/variant with id equals to \"" + npId + "\" but there is a nextForm with this value.\n    Correct this incorrect value in the NextForms widgets.");
	                    return false;
	                }
	            }
            }
        }
        
        return true;
    }
    
    private Vector getIdList(FormNode root)  {
        Vector v = new Vector();
        for ( int i = 0; i < root.getChildCount(); i++ )  {
            FormNode interaction = root.getChildAt(i);
            for ( int j = 0; j  < interaction.getChildCount(); j++ )  {
                FormNode captorProject = interaction.getChildAt(j);
                for ( int k = 0; k  < captorProject.getChildCount(); k++ )  {
                    FormNode newForm = captorProject.getChildAt(k);
                    for ( int l = 0; l  < newForm.getChildCount(); l++ )  {
                        FormNode variant = newForm.getChildAt(l);
                        String s = getVariantId(variant);
                        if ( s != null )
                            v.add(s);
                    }
                }
            }
        }
        
        return v;
    }

    private String getVariantId(FormNode variant)  {
        ICards card = variant.getCard();
        Vector elList = card.getFormElList();
        Vector idList = new Vector();
        
        for ( int i = 0; i < elList.size(); i++ )  {
            FormComponent fc = (FormComponent) elList.get(i);
            if ( fc instanceof captor.windowsystem.formcomponent.ncp.variantidpanel.VariantIdPanel )  {
                return fc.getId();
            }
        }

        
        return null;
    }
    
    
    private Vector getNpList()  {
        Vector v = new Vector();
        
        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            v.add(tableModel.getValueAt(i, 0));
        }
        
        return v;
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
                        String multiplicity = "";
                        for ( int k = 0; k < nodeList3.getLength(); k++ )  {
                            Node node3 = nodeList3.item(k);
                            if ( node3.getNodeName().toUpperCase().equals("ID") )  {
                                id = node3.getFirstChild().getNodeValue();
                                String ids[] = id.split("\\.");
                                id = ids[0];
                            }
                            if ( node3.getNodeName().toUpperCase().equals("MULTIPLICITY") )  {
                                multiplicity = node3.getFirstChild().getNodeValue();
                                add(id, multiplicity);
                            }
                        }
                    }                    
                }
            }
        }
    }
    
    //-------------------------------------------------------------------------

    public String getId()  {
        return "nextForms";
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
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("Add") )  {
	        NextFormPanel npp = new NextFormPanel(model, this);
	        npp.setVisible(true);
        }
        else if ( e.getActionCommand().equals("Remove") )  {
            int [] rrows = table.getSelectedRows();
            for ( int i = 0; i < rrows.length; i++ )  {
                tableModel.removeRow(rrows[i]);
				model.getProject().setStatus(Project.UNSAVED);
            }
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void add(String id, String multiplicity)  {
        int wrow = 0;
        
        Vector vmodel = tableModel.getDataVector();
        for ( int i = 0; i < vmodel.size(); i++ )  {
            Vector vdata = (Vector) vmodel.get(i);
            String s = (String) vdata.get(0);
            if ( s.equals("") )  {
                wrow = i;
                break;
            }
        }
        
        Vector v = new Vector();
        v.add(id);
        v.add(multiplicity);
        tableModel.insertRow(wrow, v);
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {return "";}
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the tableModel.
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    /**
     * @param tableModel The tableModel to set.
     */
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    //-------------------------------------------------------------------------
}    

