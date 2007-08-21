package captor.windowsystem.main.locationPane.util;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.domainsystem.FormType;
import captor.lib.intl.MyIntl;
import captor.windowsystem.main.bodyPane.FITBodyCard;

/**
 * @author Kicho
 */
public class FormPath {
    
    FormType formType;
    int interaction = 0;
    FITBodyCard card;
    DefaultMutableTreeNode treeNode;
    
    public FormPath() {
    }
    
    public FormPath(FormType patternType, int interaction) {
        this.formType = patternType;
        this.interaction = interaction;
    }
    
    public FormPath(FormType patternType) {
        this.formType = patternType;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the treeNode.
     */
    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }
    
    /**
     * @param treeNode The treeNode to set.
     */
    public void setTreeNode(DefaultMutableTreeNode treeNode) {
        this.treeNode = treeNode;
    }
    
    /**
     * @return Returns the card.
     */
    public FITBodyCard getCard() {
        return card;
    }
    /**
     * @param card The card to set.
     */
    public void setCard(FITBodyCard card) {
        this.card = card;
    }
    /**
     * @return Returns the interaction.
     */
    public int getInteraction() {
        return interaction;
    }
    /**
     * @param interaction The interaction to set.
     */
    public void setInteraction(int interaction) {
        this.interaction = interaction;
    }
    /**
     * @return Returns the patternType.
     */
    public FormType getFormType() {
        return formType;
    }
    /**
     * @param patternType The patternType to set.
     */
    public void setFormType(FormType patternType) {
        this.formType = patternType;
    }
    
    //-------------------------------------------------------------------------
    
    public String getPatternName()  {
        if ( formType != null )  {
            return formType.getName();
        }
        
        return "";
    }
    
    //-------------------------------------------------------------------------

    public String getFullPathWithoutIndex()  {
        String interactionString = new Integer(interaction+1).toString();
        String path = new String();
        
        if ( formType != null )
            path = "->".concat(formType.getName());
        
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) treeNode.getParent();
        
        if ( parent == null )  {
            return "Interaction ".concat(interactionString.concat(path));
        }
        
        while ( parent != null )  {
            Object obj = parent.getUserObject();
            if ( obj instanceof FormPath )  {
                FormPath tPP = (FormPath) obj;
                if ( !tPP.getPatternName().equals("") )  {
                    path = tPP.getPatternName().concat(path);
                    path = "->".concat(path);
                }
            }
            parent = (DefaultMutableTreeNode) parent.getParent();
        }
        
        String ret = "Interaction ".concat(interactionString.concat(path));
        
        return ret;
    }
    
    //-------------------------------------------------------------------------

    public String getFullPath()  {
        
        String interactionString = new Integer(interaction+1).toString();
        String path = new String();
        
        if ( formType != null )
            path = "->".concat(formType.getName());
        
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) treeNode.getParent();
        
        if ( parent == null )  {
            return "Interaction ".concat(interactionString.concat(path));
        }
        
        while ( parent != null )  {
            Object obj = parent.getUserObject();
            if ( obj instanceof FormPath )  {
                FormPath tPP = (FormPath) obj;
                if ( !tPP.getPatternName().equals("") )  {
                    //count the number of children with the same name
                    //if it has more than one, then index it
                    int count = countChildren(tPP);
                    if ( count == -1 )  {
                        path = tPP.getPatternName().concat(path);
                        path = "->".concat(path);
                    }
                    else  {
                        path = tPP.getPatternName().concat("(" + new Integer(count).toString() + ")").concat(path);
                        path = "->".concat(path);
                    }
                }
            }
            parent = (DefaultMutableTreeNode) parent.getParent();
        }

        int count = countChildren(this);
        if ( count == -1 )  {
            return "Interaction ".concat(interactionString.concat(path));
        }

        return "Interaction ".concat(interactionString.concat(path)).concat("(" + new Integer(count).toString() + ")");
    }
    
    //-------------------------------------------------------------------------
    
    private int countChildren(FormPath p)  {

        DefaultMutableTreeNode dntm = p.getTreeNode();
        DefaultMutableTreeNode parent = null;
        parent = (DefaultMutableTreeNode) dntm.getParent();

        //if this PatternPath pp hasn't a brother with the same name return -1
        int index = 0;
        if ( parent != null )  {
            for ( int i = 0; i < parent.getChildCount(); i++ )  {
                
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) 	parent.getChildAt(i);
                Object obj = node.getUserObject();
                FormPath pp = null;
                if ( obj instanceof FormPath )
                    pp = (FormPath) obj;
                
                if ( pp != null )  {
                    if ( p.getFullPathWithoutIndex().equals(pp.getFullPathWithoutIndex()) )  {
                        index++;
                    }
                }
            }
        }
        
        if ( index <= 1 )
            return -1;
        
        //if PatternPath pp has a brother with the same name return a index
        index = 1;
        if ( parent != null )  {
            for ( int i = 0; i < parent.getChildCount(); i++ )  {
                
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent.getChildAt(i);
                Object obj = node.getUserObject();
                if ( obj != null && obj instanceof FormPath )  {
                    FormPath pp = (FormPath) obj;
                    if ( pp != null )  {
                        
                        if ( pp == p )  {
                            return index;
                        }

                        if ( p.getFullPathWithoutIndex().equals(pp.getFullPathWithoutIndex()) )  {
                            index++;
                        }
                        
                    }
                }
            }
        }
        
        return index;
    }
    
    //-------------------------------------------------------------------------
    
    public String getName()  {
        if ( formType != null )
            return formType.getName();
        
        return MyIntl.NAVIGATOR_ROOT_NAME;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        return getName();
    }
    
    //-------------------------------------------------------------------------
    
    //the copy, cut, paste utility was disabled in 10/2005
    public FormPath getCopy()  {
        FormPath pp = new FormPath();
        pp.setTreeNode(treeNode);
        pp.setInteraction(interaction);
        pp.setFormType(formType);
        
        return pp;
    }
    
    //-------------------------------------------------------------------------
}
