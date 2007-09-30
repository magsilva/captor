package captor.lib.formtree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.intl.MyIntl;
import captor.modelsystem.GUI;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * This class is used for form components to interate in the form tree without 
 * having to know about the DefaultMutableTreeNode graphical interface.
 * 
 * The user can select the lastSelected form or the root form in an easy way. 
 * 
 * @author Kicho
 *
 */
public class FormTree {
    
    private FormNode root;
    private FormNode lastSelected;
    private Model model;
    
    private DefaultMutableTreeNode lastSelectedComponent;
    
    public FormTree(Model model)  {
        this.model = model;
        create();
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the lastSelected.
     */
    public FormNode getLastSelected() {
        return lastSelected;
    }
    /**
     * @param lastSelected The lastSelected to set.
     */
    public void setLastSelected(FormNode lastSelected) {
        this.lastSelected = lastSelected;
    }
    /**
     * @return Returns the lastSelectedComponent.
     */
    public DefaultMutableTreeNode getLastSelectedComponent() {
        return lastSelectedComponent;
    }
    /**
     * @param lastSelectedComponent The lastSelectedComponent to set.
     */
    public void setLastSelectedComponent(
            DefaultMutableTreeNode lastSelectedComponent) {
        this.lastSelectedComponent = lastSelectedComponent;
    }
    /**
     * @return Returns the root.
     */
    public FormNode getRoot() {
        return root;
    }
    /**
     * @param root The root to set.
     */
    public void setRoot(FormNode root) {
        this.root = root;
    }

    //-------------------------------------------------------------------------
    
    public void create()  {
        GUI gui = model.getGui();
        JTree tree = gui.getTree();
        lastSelectedComponent = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        root = new FormNode(null);
        DefaultMutableTreeNode DMTNroot = (DefaultMutableTreeNode) tree.getModel().getRoot();
        root.setNode(DMTNroot);
        root.setRoot(true);

        if ( DMTNroot != null )
            fillNode(DMTNroot, root);
    }

    //-------------------------------------------------------------------------
    
    public FormNode getLastSelectedPattern()  {
        return lastSelected;
    }
    
    //-------------------------------------------------------------------------
    
    private void fillNode(DefaultMutableTreeNode parentDMTN, FormNode parentNode)  {
        for ( int i = 0; i < parentDMTN.getChildCount(); i++ )  {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) parentDMTN.getChildAt(i);
            
            Object obj = dmtn.getUserObject();
            if ( obj instanceof FormPath )  {
	            FormPath pp = (FormPath) obj; 
	            
	            FormNode pn = new FormNode(parentNode);
	            pn.setInteraction(pp.getInteraction());
	            pn.setNode(dmtn);
	            pn.setCard(pp.getCard());
	            pn.setFormType(pp.getFormType());
	            
	            parentNode.addChild(pn);
	            
	            if ( lastSelectedComponent == dmtn )  {
	                lastSelected = pn;
	            }
	            
	            fillNode(dmtn, pn);
            }
            else if ( obj instanceof String )  {
                String str = (String) obj;
                if ( str.substring(0, 11).equals("Interaction") ) {
    	            FormNode pn = new FormNode(root);
    	            pn.setInteraction(parentDMTN.getIndex(dmtn));
    	            pn.setNode(dmtn);
    	            
    	            parentNode.addChild(pn);
    	            fillNode(dmtn, pn);
                }
            }
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    public void print()  {
        print2(root);
    }
    
    //-------------------------------------------------------------------------

    public void print2(FormNode node)  {
        printName(node);
        for ( int i = 0; i < node.getChildCount(); i++ ) {
            FormNode fn = node.getChildAt(i);
            print2(fn);
        }
    }

    //-------------------------------------------------------------------------
    
    private void printName(FormNode pn)  {
        
        if ( pn == null )  {
            System.out.println("Cannot print a null form node.");
            return;
        }
        
        String out = "";
        FormNode parent = pn.getParent();
        
        while ( parent != null )  {
            if ( parent.getFormType() != null )
                out = "->" + parent.getFormType().getName() + out;
            parent = parent.getParent();
        }
        
        if ( pn.getFormType() != null )
            out = pn.getInteraction() + ":" + out + "->" + pn.getFormType().getName();
        else  {
            DefaultMutableTreeNode nde = pn.getNode();
            if ( nde != null )  {
                
                Object obj = nde.getUserObject();
                if ( obj instanceof String )  {
                    out = "Interaction: " + pn.getInteraction();
                }
                else  if ( obj instanceof FormPath )  {
                    out = MyIntl.NAVIGATOR_ROOT_NAME;
                }
            }
        }
 
        System.out.println("PTree - " + out);
    }
    
    //-------------------------------------------------------------------------
}
