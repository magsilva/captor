package captor.windowsystem.main.locationPane.util;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.domainsystem.DomainSystem;
import captor.windowsystem.util.FormPathUtil;


/**
 * @author Kicho
 *
 */
public class TreeNavigator {

    //this may accept path like:
    //parent(2.1)->parent(1.*)->child(2.1) 
    //and must return null if it can't find a pattern from a path
    public DefaultMutableTreeNode getNode(DefaultMutableTreeNode currentNode, String path)  {
        Vector paths = getPaths(path);
        if ( paths == null )
            return null;
        
        for ( int i = 0; i < paths.size(); i++ )  {
            FormPathUtil unityPath = (FormPathUtil) paths.get(i);
            currentNode = getNodeFromPath(currentNode, unityPath);

            if ( currentNode == null )
                return null;
        }
        
        return currentNode;
    }
    
    //-------------------------------------------------------------------------
    
    private DefaultMutableTreeNode getNodeFromPath(DefaultMutableTreeNode currentNode, FormPathUtil path)  {
        if ( path.getReference().toUpperCase().equals("PARENT") )  {
            currentNode = (DefaultMutableTreeNode) currentNode.getParent();
            if ( currentNode.getUserObject() instanceof FormPath )  {
	            if ( currentNode.getUserObject() instanceof FormPath )  {
	                FormPath pp =  (FormPath) currentNode.getUserObject();
		            if ( new DomainSystem(null).compareId(pp.getFormType().getId(), path.getId()))  {
		                return currentNode;
		            }
            	}
            }
        }
        else if ( path.getReference().toUpperCase().equals("CHILD") )  {
            for ( int i = 0; i < currentNode.getChildCount(); i++ )  {
                DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) currentNode.getChildAt(i);    
	            if ( currentNode.getUserObject() instanceof FormPath )  {
	                FormPath pp =  (FormPath) dmtn.getUserObject();
	                if ( new DomainSystem(null).compareId(pp.getFormType().getId(), path.getId()))
	                    return dmtn;
	            }
            }
        }
        
        return null;
    }   

    //-------------------------------------------------------------------------
    
    private Vector getPaths(String path)  {
        Vector v = new Vector();
        String[] paths = path.split("->");
	    for ( int i = 0; i < paths.length; i++ )  {
	        String unityPath = paths[i];
	        int openParIndex = unityPath.indexOf("(");
	        int closeParIndex = unityPath.lastIndexOf(")");
	        
	        if ( openParIndex == -1 || closeParIndex == -1 )  {
	            return null;
	        }
	        
	        String reference = unityPath.substring(0, openParIndex);
	        String id = unityPath.substring(openParIndex+1, closeParIndex);
	        v.add(new FormPathUtil(reference, id));
	    }
	    
	    return v;
    }

    //-------------------------------------------------------------------------
}
