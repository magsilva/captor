package captor.lib.formtree;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.domainsystem.FormType;
import captor.windowsystem.main.bodyPane.ICards;

/**
 * This class has information to describe a form node and provide methos
 * to access this information for clients.
 * 
 * @author Kicho
 */
public class FormNode {

    private FormNode parent;
    private Vector childs;
    
    FormType formType;
    int interaction = 0;
    ICards card;
    
    DefaultMutableTreeNode node;
    boolean root = false;
    
    public FormNode(FormNode parent)  {
        this.parent = parent;
        childs = new Vector();
    }

    //-------------------------------------------------------------------------
    
    public void addChild(FormNode node)  {
        childs.add(node);
    }	
    
    //-------------------------------------------------------------------------

    public FormNode getParent()  {
        return parent;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the card.
     */
    public ICards getCard() {
        return card;
    }
    /**
     * @param card The card to set.
     */
    public void setCard(ICards card) {
        this.card = card;
    }
    /**
     * @return Returns the interaction.
     */
    public int getInteraction() {
        return interaction;
    }
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
    /**
     * @param interaction The interaction to set.
     */
    public void setInteraction(int interaction) {
        this.interaction = interaction;
    }
    public FormType getFormType() {
        return formType;
    }
    public void setFormType(FormType patternType) {
        this.formType = patternType;
    }
    
    //-------------------------------------------------------------------------
    
    public int getChildCount()  {
        return childs.size();
    }
    
    //-------------------------------------------------------------------------
    
    public FormNode getChildAt(int i)  {
        return (FormNode) childs.get(i);
    }
    
    //-------------------------------------------------------------------------
    
    public boolean hasChilds()  {
        if ( childs.size() > 0 )
            return true;

        return false;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        String ret = new String();
        
        FormNode pparent = parent;
        while ( pparent != null )  {
            FormType ft = pparent.getFormType();
            if ( ft != null )
                ret = "->Form(" + ft.getName() + ")" + ret;
            pparent = pparent.getParent();
        }

        
        ret = "interaction" + interaction + ret + "->Form(" + formType.getName() + ")";
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the root.
     */
    public boolean isRoot() {
        return root;
    }
    /**
     * @param root The root to set.
     */
    public void setRoot(boolean root) {
        this.root = root;
    }
    
    //-------------------------------------------------------------------------
}
