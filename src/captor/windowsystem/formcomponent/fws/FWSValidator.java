package captor.windowsystem.formcomponent.fws;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;

import captor.domainsystem.FormType;
import captor.lib.formtree.FormNode;
import captor.lib.formtree.FormTree;
import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.main.bodyPane.ICards;

/**
 * @author Kicho
 *
 */
public class FWSValidator extends FormComponent {

    public static final long serialVersionUID = 141;

    public FWSValidator(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setMaximumSize(new Dimension(300,2));
        
    }
    
    public void parseParameters()   {}
    public void toXML(CCBuffer out) {}
    public void load(Node data)     {}
    public void updateValues()      {setBorder(null);}
    public String getValues()  {return "";}

    //-------------------------------------------------------------------------

    public String getId()  {return "FWSValidator";}
    public boolean validateParameters()  {return true;}
    
    //-------------------------------------------------------------------------
    
    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        return v; 
    
    }
    
    //-------------------------------------------------------------------------

    public boolean validateFields() {
        
        FormTree ftree = new FormTree(model);
        FormNode root = ftree.getRoot();
        int lowRes = 0;
        int highRes = 0;

        for ( int i = 0; i < root.getChildCount(); i++ )  {
            FormNode interaction = root.getChildAt(i);
            
            for ( int m = 0; m < interaction.getChildCount(); m++ )  {
                FormNode fwsConfiguration = interaction.getChildAt(m);
                
	            for ( int j = 0; j < fwsConfiguration.getChildCount(); j++ )  {
	                FormNode buoyConfiguration = fwsConfiguration.getChildAt(j);
	                
	                for ( int k = 0; k < buoyConfiguration.getChildCount(); k++ )  {
	                    FormNode sensorConfiguration = buoyConfiguration.getChildAt(k);
	                    FormType ft = sensorConfiguration.getFormType();
	                    if ( ft != null && ft.getName() != null )  {
	                        if (ft.getName().trim().equals("Sensor Configuration") )  {
	        	                ICards card = sensorConfiguration.getCard();
	        	                if ( card != null )  {
	        	                    Vector v = card.getFormElList();
	        	                    for ( int l = 0; l < v.size(); l++ )  {
	        	                        FormComponent fc = (FormComponent) v.get(l);
	        	                        String value = fc.getValues();
	        	                        if ( value.equals("High") )
	        	                            highRes++;
	        	                        else if ( value.equals("Low") )
	        	                            lowRes++;
	        	                    }
	        	                }
	                        }
	                    }
	                }
	            }
            }
        }
        
        if ( highRes < 2 || lowRes < 2 )  {
            cleanErrorLine();
            addErrorLine("A FWS System must have at least 2 low resolution sensors and 2 High resolution sensors.");
            addErrorLine("");
            
	        if ( highRes < 2 )  {
	            if ( highRes == 1 )
	                addErrorLine("This configuration have only " + highRes + " high resolution sensor.");
	            else
	                addErrorLine("This configuration hasn't any high resolution sensor.");
	        }
	        if ( lowRes < 2 )  {  
	            if ( lowRes == 1 )
		            addErrorLine("This configuration have only " + lowRes + " low resolution sensor.");
	            else
	                addErrorLine("This configuration don't have any low resolution sensor.");
	        }
	        return false;
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
}
