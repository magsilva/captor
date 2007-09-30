package captor.windowsystem.formcomponent;

import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.modelsystem.Model;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;
import captor.windowsystem.main.locationPane.util.TreeNavigator;

/**
 * Form component abstract class.
 * 
 * <p>
 * This class provides a common behavior to all form components.
 * </p>
 * 
 * <p>
 * Every form componet have to extends this class and implements the 
 * required methods from the interface IFormComponent.
 * </p>
 * 
 * @author Kicho
 *
 */
public abstract class FormComponent extends JPanel implements IFormComponent {
    
    public static final long serialVersionUID = 2;

    protected Hashtable parameter;
    protected String errorMsg;
    protected Model model;
    protected DefaultMutableTreeNode node;

    public FormComponent(Model model, DefaultMutableTreeNode node)  {
        this.model = model;
        this.node = node;
        parameter = new Hashtable();
    }

    //-------------------------------------------------------------------------

    public String getErrorMsg() {
        return errorMsg;
    }
    
    //-------------------------------------------------------------------------
    //Get a form element denotated by a given path (i.e. parent(1.*)->FormElementId)
    
    public FormComponent getFormElement(String path)  {
        String id = "";
        
        String[] paths = path.split("->");
        String npath = "";
	    for ( int i = 0; i < paths.length; i++ )  {
	        if ( i == paths.length - 1 )  {
	            id = paths[i];
	        }
	        else  {
	            npath = npath.concat("->".concat(paths[i]));
	        }
	    }
	    npath = npath.substring(2, npath.length());
        
        TreeNavigator tn = new TreeNavigator();
        DefaultMutableTreeNode targetNode = tn.getNode(node, npath);
        
        if ( targetNode == null )  {
            model.getGui().getGuiView().setErrorView("<br>1 - Meta-model error: Cannot find component read_from parameter value: " + path + "<br>");
            return null;
        }

        Object obj = targetNode.getUserObject();
        if ( ! (obj instanceof FormPath) )  {
            //error
            model.getGui().getGuiView().setErrorView("<br>2 - Meta-model error: Cannot find component read_from parameter value: " + path + "<br>");
        }
        
        FormPath pp = (FormPath) obj;

        FITBodyCard card = pp.getCard();
        if ( card != null )  {
	        Vector formElemList = card.getFormElList();
	        
	        for ( int i = 0; i < formElemList.size(); i++ )  {
	            obj = formElemList.get(i);
	            FormComponent fe = (FormComponent) obj;
	            if ( fe.getId().toUpperCase().equals(id.toUpperCase()) )
	                return fe;
	        }
        }
        
        //error
        model.getGui().getGuiView().setErrorView("<br>3 - Meta-model error: Cannot find component read_from parameter value: " + path);
        return null;
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the node.
     */
    public DefaultMutableTreeNode getNode() {
        return node;
    }
    /**
     * @param node The node to set.
     */
    public void setNode(DefaultMutableTreeNode node) {
        this.node = node;
    }

    //-------------------------------------------------------------------------

    public Hashtable getParameter() {
        return parameter;
    }

    public void setParameter(String name, String value) {
        parameter.put(name.toUpperCase(), value);
    }
    
    public void setParameter(Hashtable parameter) {
        this.parameter = parameter;
    }

    //--------------------------------------------------------------------------

    public void setModel(Model model)  {
        this.model = model;
    }

    //-------------------------------------------------------------------------
    static String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    public void addErrorLine(String s)  {
        if ( errorMsg == null )
            errorMsg = "";
        errorMsg = errorMsg + space + s + "</font><br><font color=\"#0000FF\">";
    }
    
    //-------------------------------------------------------------------------
    
    public void cleanErrorLine()  {
        errorMsg = "";
    }

    //-------------------------------------------------------------------------
}
