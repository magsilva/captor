/*
 *
 */
package captor.windowsystem.formcomponent.ncp.nextpatternspanel;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.ncp.formidpanel.FormIdPanel;
import captor.windowsystem.formcomponent.ncp.formnamepanel.FormNamePanel;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;

public class NextFormBean {

    DefaultMutableTreeNode node;
    String minChilds, maxChilds;
    String formId = "";
    Model model;

    public NextFormBean(Model model) {
        minChilds = "0";
        maxChilds = "1";
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the maxChilds.
     */
    public String getMaxChilds() {
        return maxChilds;
    }

    /**
     * @return Returns the formId.
     */
    public String getFormId() {
        return formId;
    }

    /**
     * @param formId The formId to set.
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * @param maxChilds The maxChilds to set.
     */
    public void setMaxChilds(String maxChilds) {
        this.maxChilds = maxChilds;
    }

    /**
     * @return Returns the minChilds.
     */
    public String getMinChilds() {
        return minChilds;
    }

    /**
     * @param minChilds The minChilds to set.
     */
    public void setMinChilds(String minChilds) {
        this.minChilds = minChilds;
    }

    /**
     * @return Returns the node.
     */
    public DefaultMutableTreeNode getNode() {
        if ( node != null )
            return node;
        
        return getNodeById(formId);
    }

    /**
     * @param node The node to set.
     */
    public void setNode(DefaultMutableTreeNode node) {
        this.node = node;
    }
    
    //-------------------------------------------------------------------------
    
    public String validate()  {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        String ret = validateExist(root);
        if ( ret != null )
            return ret;
        
        ret = validateLoop(root);
        if ( ret != null )
            return ret;
        
        return null;
    }
    
    //-------------------------------------------------------------------------
    
    private String validateExist(DefaultMutableTreeNode currentNode)  {
        if ( node == null )  {
            node = getNodeById(formId);
        }
        
        if ( node == null )  {
            return MyIntl.MSG115;
        }
        
        FormPath fp1 = (FormPath) node.getUserObject();

        if ( currentNode.getUserObject() instanceof FormPath )  {
    
            FormPath fp2 = (FormPath) currentNode.getUserObject();
            if ( fp1.getCard() == fp2.getCard() )  {
                return null;
            }
        }
        
        for ( int i = 0; i < currentNode.getChildCount(); i++ )  {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) currentNode.getChildAt(i);
            String s = validateExist(dmtn);
            if ( s == null )  {
                return null;
            }
        }
        
        String classname = "";
        String ret = "Cannot find next form element.";
        FITBodyCard card = fp1.getCard();
        if ( card != null )  {
            Vector elList = card.getFormElList();
            if ( elList != null )  {
                
                for ( int i = 0; i < elList.size(); i++ )  {
                    FormComponent fc = (FormComponent) elList.get(i);
                    if ( fc instanceof FormNamePanel )  {
                        FormNamePanel tp = (FormNamePanel) fc;
                        classname = tp.getValues();
                    }
                }
                
                ret = "Cannot find next form element: '" + classname + "'.";
            }
        }
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        if ( node == null )  {
            node = getNodeById(formId);
        }
        
        if ( node == null )  {
            return "super.toString()1" + formId;
        }
        
        Object obj = node.getUserObject();
        if ( !(obj instanceof FormPath ))
            return "super.toString()2";
        
        FormPath fp = (FormPath) obj;

        if ( fp.getCard() == null )
            return "super.toString()3";

        Vector elList = fp.getCard().getFormElList();
        
        if ( fp.getCard() == null )
            return "super.toString4()";
        
        String classname = null;
        String classid = null;
        for ( int i = 0; i < elList.size(); i++ )  {
            FormComponent fc = (FormComponent) elList.get(i);
            if ( fc instanceof FormIdPanel )  {
                FormIdPanel fip = (FormIdPanel) fc;
                classid = fip.getValues();
            }
            if ( fc instanceof FormNamePanel )  {
                FormNamePanel tp = (FormNamePanel) fc;
                classname = tp.getValues();
            }
        }
        
        if ( classname == null || classid == null )
            return "super.toString()5";
        
        String ret = "Form name: \"" + classname + "\"  ";
        ret = ret + "- Min childs: " + minChilds + " - Id: " + classid + "Max childs: " + maxChilds;
        return ret;
    }
    
    //-------------------------------------------------------------------------
    
    public void toXML(CCBuffer out)  {
        
        String id = "";
        Object obj = node.getUserObject();
        if ( !(obj instanceof FormPath) )
            return;
        
        FormPath fp = (FormPath) obj;
        
        FITBodyCard card = fp.getCard();
        
        if ( card == null )
            return;
        
        for ( int i = 0; i < card.getFormElList().size(); i++ )  {
            FormComponent fc = (FormComponent) card.getFormElList().get(i);
            if ( fc instanceof FormIdPanel )  {
                FormIdPanel idPanel = (FormIdPanel) fc;
                id = idPanel.getValues();
            }
        }

        out.appendln("<nextForm>");
        out.ident();
        out.append("<id>");
        out.append(id + ".*", true);
        out.appendln("</id>", true);
        
        out.append("<maxChilds>");
        out.append(maxChilds, true);
        out.appendln("</maxChilds>", true);
        
        out.append("<minChilds>");
        out.append(minChilds, true);
        out.appendln("</minChilds>", true);
        
        out.dident();
        out.appendln("</nextForm>");
    }
    
    //-------------------------------------------------------------------------

    public DefaultMutableTreeNode getNodeById(String id)  {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        return getNodeById2(root, id);
    }
    
    public DefaultMutableTreeNode getNodeById2(DefaultMutableTreeNode node, String id)  {
        
        Object obj = node.getUserObject();
        if ( obj instanceof FormPath )  {
            FormPath fp = (FormPath) obj;
            
            FITBodyCard card = fp.getCard();
            if ( card != null )  {
                for ( int i = 0; i < card.getFormElList().size(); i++ )  {
                    FormComponent fc = (FormComponent) card.getFormElList().get(i);
                    if ( fc instanceof FormIdPanel )  {
                        FormIdPanel fid = (FormIdPanel) fc;
                        if ( fid.getValues().equals(id) )
                            return node;
                    }
                }
            }
        }
        
        for ( int i = 0; i < node.getChildCount(); i++ )  {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
            DefaultMutableTreeNode mynode = getNodeById2(childNode, id);
            if ( mynode != null )
                return mynode;
        }
        
        return null;
    }
    
    //-------------------------------------------------------------------------
    
    private String validateLoop(DefaultMutableTreeNode currentNode)  {
        return null;
    }
    
    //-------------------------------------------------------------------------
    
}
    