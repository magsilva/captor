package captor.windowsystem.formcomponent.std;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.def.Constant;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.Parameter;

/**
 * @author Kicho
 *
 */
public class ComboBoxPanel extends FormComponent implements ItemListener {

    public static final long serialVersionUID = 110;

    JComboBox combo;
        JLabel selectLabel;
        DefaultComboBoxModel listModel;
        
        private String id;
        
        public ComboBoxPanel(Model model, DefaultMutableTreeNode node) {
            super(model, node);
            id = "";
            create();
        }
        
        //-------------------------------------------------------------------------
        
        public void create()  {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//            panel.setMaximumSize(new Dimension(500,30));

            selectLabel = new JLabel("Combo Label: ");
            selectLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
            
            listModel = new DefaultComboBoxModel();
            combo = new JComboBox(listModel);
            Dimension d = new Dimension(244,20);
            combo.setSize(d);
            combo.setPreferredSize(d);
            combo.setMaximumSize(d);
            combo.addItemListener(this);
            
            selectLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            
            panel.add(selectLabel);
            panel.add(combo);
            panel.add(Box.createHorizontalGlue());
            panel.add(new JLabel(""));
//            panel.setBorder(BorderFactory.createLineBorder(Color.red));
//            this.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(panel);
        }

        //-------------------------------------------------------------------------
        
        public void parseParameters()  {
            String id2 = (String) parameter.get("ID");
            if ( id2 != null )  {
                id = id2;
            } 

            String value = (String) parameter.get("LABEL");
            if ( value != null )  {
                String aux = value.concat(": ");
                selectLabel.setText(aux);
            }
            
            value = (String) parameter.get("ELEMENTS");
            if ( value != null )  {
                String []aux = value.split(":");
                for ( int i = 0; i < aux.length; i++ )  {
                    listModel.addElement(aux[i]);
                }
            } 

            value = (String) parameter.get("DEFAULT_VALUE");
            if ( value != null )  {
                combo.setSelectedItem(value);
            } 
            
        }
        
        //-------------------------------------------------------------------------

        public void toXML(CCBuffer out)  {
            out.newLine();
            out.ident();
            String id = (String) parameter.get("ID");
            out.append("<combo name=\"" + id + "\">");
            out.append(combo.getSelectedItem().toString(), true);
            out.appendln("</combo>", true);
            out.dident();
        }
        
        //-------------------------------------------------------------------------

        public boolean validateFields()  {

            String id = (String) parameter.get("ID");
            if ( id == null )  {
                cleanErrorLine();
                addErrorLine("There is an error in the meta-model.\nThe formElement ComboBox doesn't have a ID parameter.");
                return false;
            }
            
            //valida��o da classe
            String required = (String) parameter.get("USE");
            if ( required == null )
                required = "";
            
            if ( required.toUpperCase().equals("REQUIRED") )  {
    	        if ( combo.getSelectedItem().toString().trim().equals("") )  {
    	            cleanErrorLine();
    	            addErrorLine("ComboBox with ID = " + id + " cannot be null.");
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
                if ( node.getNodeName().toUpperCase().equals("COMBO") )  {
                    NamedNodeMap nnm = node.getAttributes();
                    Node nameAtt = nnm.getNamedItem("name");
                    if ( nameAtt.getNodeValue().toUpperCase().equals(id.toUpperCase()))  {
                        fillMainValues(node);
                    }
                }
            }

        }
        
        //-------------------------------------------------------------------------

        public String getId()  {
            return id;
        }
        
        public String getValues()  {
            return combo.getSelectedItem().toString();
        }
        
        //-------------------------------------------------------------------------

        public boolean validateParameters()  {
            String id = (String) parameter.get("ID");
            if ( id == null )  {
                errorMsg = "This element requires the 'id' parameter.\n";
                return false;
            }
            
            String elements = (String) parameter.get("ELEMENTS");
            if ( elements == null )  {
                errorMsg = "This element requires the 'elements' parameter.\n";
                return false;
            }

            return true;
        }
        
        //-------------------------------------------------------------------------

        public Vector getRequiredParameters()  {
            Vector v = new Vector();

            v.add(new Parameter("id"           , "string", "", "1"            , "Unique identifier"                           , "", true));
            v.add(new Parameter("elements"     , "string", "", ""             , "Combo elements"                              , "", true));
            v.add(new Parameter("use"          , "string", "", "not_required" , "If some field value is requied"              , "[required|not_required]", false));
            v.add(new Parameter("label"        , "string", "", "TextPanel"    , "The left corner text label"                  , "", false));
            v.add(new Parameter("default_value", "string", "", ""             , "Default field value"                         , "", false));
            
            return v;
        }
        
        //-------------------------------------------------------------------------

        public void setLabel(String label)  {
            selectLabel.setText(label);
        }
            
        public void setSelectedValue(String s)  {
            combo.setSelectedItem(s);
        }    

        //-------------------------------------------------------------------------

        private void fillMainValues(Node node)  {
            if ( node != null && node.getFirstChild() != null && node.getFirstChild().getNodeValue() != null )
                combo.setSelectedItem(node.getFirstChild().getNodeValue());
        }

        //-------------------------------------------------------------------------
        
        public void updateValues()  {
        }
        
        //-------------------------------------------------------------------------
        
        public void itemStateChanged(ItemEvent e)  {
            model.getProject().setStatus(Project.UNSAVED);
        }
        
        //-------------------------------------------------------------------------
}
