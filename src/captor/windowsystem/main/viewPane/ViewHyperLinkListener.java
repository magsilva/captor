package captor.windowsystem.main.viewPane;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.lib.intl.MyIntl;
import captor.lib.util.IntegerUtil;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * @author Kicho
 *
 */
public class ViewHyperLinkListener implements HyperlinkListener {
    
    Model model;
    
    public ViewHyperLinkListener(Model model) {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public void hyperlinkUpdate(HyperlinkEvent e)  {
        
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED )  {
            showForm(e.getDescription());
        }
        
    } 
    
    //-------------------------------------------------------------------------
    
    private void showForm(String path)  {
        Vector formBeanPaths = parsePath(path);
        if ( formBeanPaths == null )
            return;
        
        JTree tree = model.getGui().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        DefaultMutableTreeNode lastNode = findNode(formBeanPaths, root);
        
        if ( lastNode == null )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG82 + path);
            return;
        }

        TreePath tp = new TreePath(lastNode.getPath());
        tree.setSelectionPath(tp);
        model.getGui().getGuiControl().setLoadedPattern(true);

    }
    
    //-------------------------------------------------------------------------
    
    private Vector parsePath(String path)  {
        Vector formBeanPaths = new Vector();
        String [] paths = path.split("->");
        if ( paths.length == 0 )
            return null;
        
        //adding the interaction path
        String interactionString = paths[0];
        interactionString = interactionString.substring(interactionString.lastIndexOf(" "), interactionString.length());
        interactionString = interactionString.trim();
        
        if ( !IntegerUtil.isInt(interactionString) )  {
            return null;
        }
        
        FormPathBean fpb = new FormPathBean();
        fpb.setFormName("Interaction");
        fpb.setFormIndex(1);
        formBeanPaths.add(fpb);
        
        //adding the other paths
        for ( int i = 1; i < paths.length; i++ )  {
            String currentPath = paths[i];
            int openPar = currentPath.lastIndexOf("(");
            int closePar = currentPath.lastIndexOf(")");
            if ( openPar == -1 || closePar == -1 )  {
                fpb = new FormPathBean();
                fpb.setFormName(currentPath);
                fpb.setFormIndex(1);
                formBeanPaths.add(fpb);
                continue;
            }
            String name = currentPath.substring(0, openPar);
            String indexString = currentPath.substring(openPar+1, closePar);
            
            Integer indexInteger = new Integer(0);
            try {
                indexInteger = new Integer(indexString);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                return null;
            }
            
            fpb = new FormPathBean();
            fpb.setFormName(name);
            fpb.setFormIndex(indexInteger.intValue());
            formBeanPaths.add(fpb);
        }
        
        return formBeanPaths;
    }
    
    //-------------------------------------------------------------------------
    
    private DefaultMutableTreeNode findNode(Vector formBeanPaths, DefaultMutableTreeNode root)  {
        FormPathBean fpb = (FormPathBean) formBeanPaths.get(0);
        for ( int i = 0; i < root.getChildCount(); i++ )  {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) root.getChildAt(i);
            if ( isNode(fpb, dmtn) )  {
                if ( formBeanPaths.size() == 1 )  {
                    return dmtn;
                }
                
                formBeanPaths.remove(0);
                return findNode(formBeanPaths, dmtn);
            }
        }

        return null;
    }
    
    //-------------------------------------------------------------------------
    
    private boolean isNode(FormPathBean fpb, DefaultMutableTreeNode node)  {
        Object obj = node.getUserObject();
        if ( obj instanceof String )  {
            String interactionString = (String) obj;
            interactionString = interactionString.substring(interactionString.lastIndexOf(" "), interactionString.length());
            interactionString = interactionString.trim();
            Integer interactionInteger = new Integer(0);
            try {
                interactionInteger = new Integer(interactionString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
            
            if ( fpb.getFormName().equals("Interaction") )  {
                if ( fpb.getFormIndex() == interactionInteger.intValue() )  {
                    return true;
                }
            }
            
            return false;
        }
        else if ( obj instanceof FormPath) {
            FormPath fp = (FormPath) obj;
            if ( fp.getName().equals(fpb.getFormName()) )  {
                if ( compareIndex(fpb.getFormIndex(), node ) )  {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------
    
    private boolean compareIndex(int index, DefaultMutableTreeNode node )  {
        
        Object obj = node.getUserObject();
        if ( ! (obj instanceof FormPath) )  {
            return false;
        }        
        
        int nodeIndex = getNodeIndex(node);
        
        if ( index == nodeIndex )
            return true;
        
        return false;
        
    }
    
    //-------------------------------------------------------------------------
    
    private int getNodeIndex(DefaultMutableTreeNode node)  {

        Object obj = node.getUserObject();
        if ( ! (obj instanceof FormPath) )  {
            return -1;
        }        

        FormPath nodeFP = (FormPath) obj;
        
        int index = 1;
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        for ( int i = 0; i < parent.getChildCount(); i++ )  {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) parent.getChildAt(i);
            if ( node == child )
                return index;
            
            obj = child.getUserObject();
            if ( obj instanceof FormPath )  {
                FormPath fp = (FormPath) obj;
                if ( fp.getName().equals(nodeFP.getName()) )  {
                    index++;
                }
            }
        }
        
        return -1;
    }
    
    //-------------------------------------------------------------------------
}
