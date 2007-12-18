package captor.windowsystem.formcomponent.std;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.def.Constant;
import captor.lib.util.IntegerUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.Parameter;

/**
 * @author Kicho
 *
 */
public class TablePanel extends FormComponent implements ActionListener {

    public static final long serialVersionUID = 111;

    private String id;

    JLabel textLabel;
    JTable table;
    Vector columnNames;
    JButton plus, minus, edit;
    DefaultTableModel tableModel;
    
    public TablePanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        id = "";
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        textLabel = new JLabel("Text Label: ");
    }
    
    //-------------------------------------------------------------------------

    public void create2()  {
        
        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        makeTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane (table);
        
        Dimension d = new Dimension(432,140);
        
        table.setSize(d);
        table.setPreferredSize(d);
        table.setMaximumSize(d);
        
        scrollPane.setSize(d);
        scrollPane.setPreferredSize(d);
        scrollPane.setMaximumSize(d);
        //main panel
        
        //button panel
        plus = new JButton("Add");
        plus.addActionListener(this);
        minus = new JButton("Remove");
        minus.addActionListener(this);
        edit = new JButton("Edit");
        edit.addActionListener(this);
        
        
        d = new Dimension(75,25);
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
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(edit);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
        bPanel.add(Box.createRigidArea(new Dimension(5,60)));
        //button panel

        panel.add(textLabel);
        panel.add(scrollPane);
        panel.add(new JLabel(" "));
        panel.add(bPanel);
        panel.add(Box.createHorizontalGlue());
        
        this.add(panel);
    }

    private void makeTableModel()  {
        Vector cnames = new Vector();
        
        String value = (String) parameter.get("COLNAME1");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME2");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME3");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME4");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME5");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME6");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME7");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME8");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME9");
        if ( value != null )
            cnames.add(value);

        value = (String) parameter.get("COLNAME10");
        if ( value != null )
            cnames.add(value);
        
        Vector data = new Vector();
        tableModel = new DefaultTableModel(data, cnames);
    }
    
    //-------------------------------------------------------------------------

    public void parseParameters()  {
        String id2 = (String) parameter.get("ID");
        if ( id2 != null )  {
            id = id2;
        } 
        
        String value = (String) parameter.get("LABEL");
        if ( value != null )  {
            textLabel = new JLabel(value.concat(": "));
        }
        
        columnNames = new Vector();
        value = (String) parameter.get("COLNAME1");
        if ( value != null )  {
            columnNames.add(value);
        } 

        value = (String) parameter.get("COLNAME2");
        if ( value != null )  {
            columnNames.add(value);
        } 

        create2();
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        
        out.newLine();
        out.ident();
        out.appendln("<table id=\"" + id + "\">");
        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            out.ident();
            out.appendln("<row number=\"" + i + "\">");

            for ( int j = 0; j < tableModel.getColumnCount(); j++ )  {
                
                String colValue = (String) tableModel.getValueAt(i, j);
                String colName = tableModel.getColumnName(j);
                out.ident();
                out.appendln("<col number=\"" + j + "\">");
                
                out.ident();
                out.append("<name><![CDATA[");
                out.append(colName,true);
                out.appendln("]]></name>",true);
                
                out.append("<value><![CDATA[");
                out.append(colValue,true);
                out.appendln("]]></value>",true);
                out.dident();
                out.appendln("</col>");
                out.dident();
            }
            out.appendln("</row>");
        }
        out.dident();
        out.appendln("</table>");
        out.dident();
    }
    
    //-------------------------------------------------------------------------

    public void load(Node data)  {
        String id = (String) parameter.get("ID");
        if ( id == null )
            return;
        
        NodeList nodeList = data.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("TABLE") )  {
                NamedNodeMap nnm = node.getAttributes();
                Node idAtt = nnm.getNamedItem("id");
                if ( idAtt.getNodeValue().toUpperCase().equals(id.toUpperCase()))  {
                    fillMainValues(node);
                }
            }
        }
        
        
    }
    
    //-------------------------------------------------------------------------
    
    private void fillMainValues(Node node)  {
        NodeList nodeList = node.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node2 = nodeList.item(i);
            
            if ( node2.getNodeName().toUpperCase().equals("ROW") )  {
                NamedNodeMap nnm = node2.getAttributes();
                Node numberAtt = nnm.getNamedItem("number");
                Integer row = new Integer(0);
                
                if ( numberAtt == null )  {
                    return;
                }
                
                try {
                    row = new Integer(numberAtt.getNodeValue());
                } catch (NumberFormatException e) {
                    return;
                } catch (DOMException e) {
                    return;
                }
                
                fillRow(node2, row.intValue());
            }
        }
    }
    
    private void fillRow(Node node, int row)  {
        Vector rowValues = new Vector();
        NodeList nodeList = node.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node2 = nodeList.item(i);
            if ( node2 == null )
                return;

            if ( node2.getNodeName().toUpperCase().equals("COL") )  {
                
                NamedNodeMap nnm = node2.getAttributes();
                Node numberAtt = nnm.getNamedItem("number");
                
                if ( numberAtt == null )  {
                    return;
                }
                
                try {
                    if ( !IntegerUtil.isInt(numberAtt.getNodeValue()) )  {
                        return;
                    }
                } catch (DOMException e) {
                    return;
                }
                
                fillCol(node2, rowValues);
            }
        }
        tableModel.addRow(rowValues);
    }
    
    private void fillCol(Node node, Vector rowValues)  {
        
        NodeList nodeList = node.getChildNodes();
        if ( nodeList == null )
            return;
        
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node2 = nodeList.item(i);
            
            if ( node2 == null )
                return;
            
            if ( node2.getNodeName().toUpperCase().equals("VALUE") )  {
                
                NodeList nlist = node2.getChildNodes();
                for ( int k = 0; k < nlist.getLength(); k++ )  {
                    Node node3 = nlist.item(k);
                    
                    if ( node3 == null )
                        return;
                    
                    if ( node3.getNodeType() == Node.CDATA_SECTION_NODE )  {
	                    rowValues.add(node3.getNodeValue());
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
            errorMsg = "This element requires the 'id' parameter.\n";
            return false;
        }
        
        String colname1 = (String) parameter.get("COLNAME1");
        if ( colname1 == null )  {
            errorMsg = "This element requires the 'colname1' parameter.\n";
            return false;
        } 
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        v.add(new Parameter("id"           , "string", "", "1"            , "Unique identifier"                           , "", true));
        v.add(new Parameter("label"        , "string", "", "TablePanel"   , "The left corner text label"                  , "", false));

        for ( int i = 1; i < 11; i++ )  {
            if ( i == 1 )
                v.add(new Parameter("colname" + i     , "string", "", "colname1"     , "Column name"                  , "", true));
            else
                v.add(new Parameter("colname" + i     , "string", "", "colname1"     , "Column name"                  , "", false));
        }
        
        for ( int i = 1; i < 11; i++ )
            v.add(new Parameter("regexp" + i     , "string", "", ""              , "Regular expression matcher"                  , "", false));

        return v;
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
		    
		    TableValuesPanel tvp = new TableValuesPanel(model, this, tableModel);
		    tvp.setVisible(true);
		}        
		else if ( e.getActionCommand().equals("Remove") )  {
		    if ( tableModel.getRowCount() > 0 && table.getSelectedRow() >= 0 )  {
		        tableModel.removeRow(table.getSelectedRow());
				model.getProject().setStatus(Project.UNSAVED);
		    }
		}        
        else if ( e.getActionCommand().equals("Edit") )  {
        	int row = table.getSelectedRow();
        	if ( row != -1 )  {
    		    TableValuesPanel tvp = new TableValuesPanel(model, this, tableModel, row);
    		    tvp.setVisible(true);
        	}
        }
		
    }

    //-------------------------------------------------------------------------

    public void setLabel(String label)  {
        textLabel.setText(label);
    }
    
    //-------------------------------------------------------------------------

    public void setTableModel(DefaultTableModel tableModel)  {
        Vector data = tableModel.getDataVector();
        for ( int i = 0; i < data.size(); i++ )  {
            Vector v = (Vector) data.get(i);
            this.tableModel.addRow(v);    
        }
    }

    //-------------------------------------------------------------------------

    public boolean validateFields()  {

        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            for ( int j = 0; j < tableModel.getColumnCount(); j++ )  {
                String regexp = (String) parameter.get("REGEXP" + new Integer(j+1).toString());
                if ( regexp == null )
                    continue;
                
                String colValue = (String) tableModel.getValueAt(i, j);
                if ( colValue == null || colValue.equals("") )
                    continue;
                
    	        Pattern p = Pattern.compile(regexp);
    	        Matcher m = p.matcher(colValue.trim());
    	        
   		        if ( !m.matches() )  {
   		            cleanErrorLine();
   		            addErrorLine("Table value invalid format.\n\n");
   		            addErrorLine("The value '" + colValue.trim() + "' in line '" + (i+1) + "' column '" + (j+1) + "' doesn't match the regular expression: " + regexp + ".\n");
   		            return false;
   		        }
            }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
}