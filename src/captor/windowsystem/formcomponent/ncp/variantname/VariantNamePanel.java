package captor.windowsystem.formcomponent.ncp.variantname;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * 
 * TextPanel form component. 
 * 
 * <p>
 * This is the simplest form components that can exist.
 * </p>
 * 
 * @author Kicho
 *
 */
public class VariantNamePanel extends FormComponent implements KeyListener {
    
    public static final long serialVersionUID = 115;

    JTextField textField;
    JLabel textLabel;
    
    private String id, readFrom;
    
    public VariantNamePanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        id = "";
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        
        textLabel = new JLabel("Text Label");
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH, 12));
        
        textField = new JTextField();
        
        textField.addKeyListener(this);
        
        textField.setSize(new Dimension(405,12));
        textField.setMaximumSize(new Dimension(405,20));
        textField.setPreferredSize(new Dimension(405,20));
        
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
//        panel.add(Box.createRigidArea(new Dimension(10,0)));
        panel.add(textLabel);
        panel.add(textField);
        panel.add(Box.createHorizontalGlue());

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
            textLabel.setText(aux);
        } 

        value = (String) parameter.get("READ_FROM");
        if ( value != null )  {
            readFrom = value;
            value = null;
            readFrom();
        } 

        value = (String) parameter.get("DEFAULT_VALUE");
        if ( value != null )  {
            textField.setText(value);
        } 
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        textField.setText(textField.getText().trim());
        
        out.newLine();
        out.ident();
        String id = (String) parameter.get("ID");
        out.append("<textatt name=\"" + id + "\">");
        out.append(textField.getText(), true);
        out.appendln("</textatt>", true);
        out.dident();
    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {

        String id = (String) parameter.get("ID");
        if ( id == null )  {
            cleanErrorLine();
            addErrorLine("There is an error in the meta-model.\nThe formElement TextAtt doesn't have a ID parameter.");
            return false;
        }
        
        //validação da classe
        String required = (String) parameter.get("USE");
        if ( required == null )
            required = "";
        
        if ( required.toUpperCase().equals("REQUIRED") )  {
	        if ( textField.getText().trim().equals("") )  {
	            cleanErrorLine();
	            addErrorLine("'" + textLabel.getText().substring(0, textLabel.getText().length() - 2) + "' value cannot be blank.");
	            return false;
	        }
        }

        String regexp = (String) parameter.get("REGEXP");
        if ( regexp != null )  {
	       	//String regexp = "[(a-zA-Z)][(A-Za-z\\-_0-9)]*";
	        Pattern p = Pattern.compile(regexp);
	        Matcher m = p.matcher(textField.getText().trim());
	        
	        if ( !textField.getText().equals("") )  {
		        if ( !m.matches() )  {
		            cleanErrorLine();
		            addErrorLine("'" + textLabel.getText().substring(0, textLabel.getText().length() - 2) + "' invalid format."); 
		            addErrorLine("Possible values: " + regexp);
		            return false;
		        }
	        }
        }
        
        //verify if two variants have the same name
        String vname = textField.getText();
        vname = vname.trim();
        
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        for ( int i = 0; i < parent.getChildCount(); i++ )  {
            DefaultMutableTreeNode cnode = (DefaultMutableTreeNode) parent.getChildAt(i);
            if ( cnode == node )  {
                continue;
            }
            
            Object obj = cnode.getUserObject();
            if ( obj instanceof FormPath )  {
                FormPath fp = (FormPath) obj;
                FITBodyCard card = fp.getCard();
                Vector v = card.getFormElList();
                for ( int j = 0; j < v.size(); j++ )  {
                    FormComponent fe = (FormComponent) v.get(j);
                    if ( fe.getId().equals("variant_name") )  {
                        String vname2 = fe.getValues();
                        if ( vname2.trim().equals(textField.getText().trim()) )  {
                            cleanErrorLine();
                            addErrorLine("This name is been used by another variant.");
                            addErrorLine("Change the name and try again.");
                            return false;
                        }
                    }
                }
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
            if ( node.getNodeName().toUpperCase().equals("TEXTATT") )  {
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
    
    //-------------------------------------------------------------------------

    public boolean validateParameters()  {
        String id = (String) parameter.get("ID");
        if ( id == null )  {
            errorMsg = "This element requires the 'id' parameter.\n";
            return false;
        }

        return true;
    }
    
    //-------------------------------------------------------------------------

    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        
        v.add(new Parameter("id"           , "string", "", "1"            , "Unique identifier"                           , "", true));
        v.add(new Parameter("use"          , "string", "", "not_required" , "If some field value is requied"              , "[required|not_required]", false));
        v.add(new Parameter("label"        , "string", "", "TextPanel"    , "The left corner text label"                  , "", false));
        v.add(new Parameter("default_value", "string", "", ""             , "Default field value"                         , "", false));
        v.add(new Parameter("regexp"       , "regexp", "", ""             , "The regular expression value for validation" , "", false));
        
//        v.add("id -   (required)");
//        v.add("use");
//        v.add("label");
//        v.add("default_value");

        return v;
    }
    
    //-------------------------------------------------------------------------

    public void setLabel(String label)  {
        textLabel.setText(label);
    }
        
    public void setTextField(String tf)  {
        textField.setText(tf);
    }    

    //-------------------------------------------------------------------------
    
    public void updateValues()  {
        String value = (String) parameter.get("READ_FROM");
        if ( value != null )  {
            readFrom = value;
            value = null;
            readFrom();
        } 
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {
        return textField.getText();
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //The methods below are specific for this component
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------

    private void readFrom()  {
        textField.setEnabled(false);
        FormComponent fe = getFormElement(readFrom);
        if ( fe != null )  {
            String s = fe.getValues();
            if ( s != null )
                textField.setText(s);
        }
        
		return;
    }
    
    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {}
    public void keyReleased(KeyEvent e) {
    	model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-------------------------------------------------------------------------

    private void fillMainValues(Node node)  {
        if ( node != null && node.getFirstChild() != null && node.getFirstChild().getNodeValue() != null )
            textField.setText(node.getFirstChild().getNodeValue());
    }
    
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
}
