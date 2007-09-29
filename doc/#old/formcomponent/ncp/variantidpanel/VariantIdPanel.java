/*
 *
 */
package captor.windowsystem.formcomponent.ncp.variantidpanel;

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
public class VariantIdPanel extends FormComponent {
    JTextField textId;
    
    public VariantIdPanel(Model model, DefaultMutableTreeNode node) {
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
        
        //panel.add(Box.createRigidArea(new Dimension(10,0)));
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
        out.append("<patternId>");
        out.append(textId.getText(), true);
        out.appendln("</patternId>", true);
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
	        DefaultMutableTreeNode lastSelectedComponent = node;//= (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
	        if ( lastSelectedComponent != null )  {
		        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
		        if ( parent != null )  {
		            DefaultMutableTreeNode gparent = (DefaultMutableTreeNode) parent.getParent();
			        if ( gparent != null )  {
				        Integer parentDepth = new Integer(gparent.getIndex(parent) + 1);
				        Integer localDepth = new Integer(parent.getIndex(lastSelectedComponent) + 1);
				        textId.setText(parentDepth.toString() + "." + localDepth.toString());
			        }
		        }
	        }
        }
    }
    
    //-------------------------------------------------------------------------
    
    public String getValues()  {return "";}
    
    //-------------------------------------------------------------------------
}
