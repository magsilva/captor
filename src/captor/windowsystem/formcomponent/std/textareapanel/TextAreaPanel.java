package captor.windowsystem.formcomponent.std.textareapanel;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
public class TextAreaPanel extends FormComponent implements KeyListener  {
    
    public static final long serialVersionUID = 150;

    JTextArea textArea;
    JLabel textLabel;
    
    private String id;
    
    public TextAreaPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        id = "";
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        textLabel = new JLabel("");
        textArea = new JTextArea();
        
        textArea.addKeyListener(this);
//        Dimension d2 = new Dimension(540,130);
//        textArea.setRows(4);
//        textArea.setColumns(50);
//        textArea.setSize(d);
//        textArea.setPreferredSize(d);
//        textArea.setMaximumSize(d);
//        textArea.setMinimumSize(d);
        
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        textLabel.setText("Text area label: ");

        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Dimension d = new Dimension(433,85);
        scroll.setPreferredSize(d);
        scroll.setMaximumSize(d);
        scroll.setMinimumSize(d);
        
//        panel.add(Box.createRigidArea(new Dimension(10,0)));
        panel.add(textLabel);
        panel.add(scroll);
        panel.add(Box.createHorizontalGlue());

        this.add(panel);
    }

    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {}
    public void keyReleased(KeyEvent e) {
    	model.getProject().setStatus(Project.UNSAVED);
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
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        textArea.setText(textArea.getText().trim());

        out.newLine();
        out.ident();
        String id = (String) parameter.get("ID");
        out.append("<textatt name=\"" + id + "\">");
        out.append(textArea.getText(), true);
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
	        if ( textArea.getText().trim().equals("") )  {
	            cleanErrorLine();
	            addErrorLine("'" + textLabel.getText().substring(0, textLabel.getText().length() - 2) + "' value cannot be blank.");
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
        
        return v;
    }
    
    //-------------------------------------------------------------------------

    private void fillMainValues(Node node)  {
        if ( node != null && node.getFirstChild() != null && node.getFirstChild().getNodeValue() != null )
            textArea.setText(node.getFirstChild().getNodeValue());
    }

    //-------------------------------------------------------------------------
    
    public void updateValues()  {
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {
        return textArea.getText();
    }
    
    //-------------------------------------------------------------------------
}
