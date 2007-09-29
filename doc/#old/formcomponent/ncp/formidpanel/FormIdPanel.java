package captor.windowsystem.formcomponent.ncp.formidpanel;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;

import captor.lib.def.Constant;
import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;

/**
 * @author Kicho
 *
 */
public class FormIdPanel extends FormComponent {

    JTextField textId;
    
    public FormIdPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        create();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel textLabel = new JLabel("Id: ");
        textLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,12));
        
        textId = new JTextField();
        Dimension d = new Dimension(210,20);
        textId.setSize(d);
        textId.setMaximumSize(d);
        textId.setPreferredSize(d);

        
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        panel.add(textLabel);
        panel.add(textId);
        panel.add(Box.createHorizontalGlue());
        String space = "                                                      ";
        space = space + space;
        panel.add(new JLabel(space));
        textId.setEnabled(false);
        this.add(panel);
        
        setValue();
    }

    //-------------------------------------------------------------------------

    public void parseParameters()  {
    }
    
    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        textId.setText(textId.getText().trim());
        
        out.newLine();
        out.ident();
        out.append("<formId>");
        out.append(textId.getText(), true);
        out.appendln("</formId>", true);
        out.dident();
    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields()  {
        return true;
    }
    
    //-------------------------------------------------------------------------

    public void load(Node data)  {
        setValue();
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

    public void setId(String tf)  {
        textId.setText(tf);
    }    

    //-------------------------------------------------------------------------

    public void updateValues()  {
        setValue();
    }
    
    //-------------------------------------------------------------------------

    public String getId()  {
        return textId.getText();
    }

    //-------------------------------------------------------------------------
    
    private void setValue()  {
        if ( model.getGui().getTree() != null ) {
	        if ( node != null )  {
		        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
		        if ( parent != null )  {
			        Integer parentDepth = new Integer(parent.getIndex(node) + 1);
			        textId.setText(parentDepth.toString());
		        }
	        }
        }
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {return textId.getText();}
    
    //-------------------------------------------------------------------------
}
