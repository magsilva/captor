package captor.windowsystem.formcomponent.ncp.requirepanel;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.domainsystem.DomainSystem;
import captor.lib.formtree.FormNode;
import captor.lib.formtree.FormTree;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.ncp.formidpanel.FormIdPanel;
import captor.windowsystem.formcomponent.ncp.nextpatternspanel.NextFormsPanel;
import captor.windowsystem.main.bodyPane.ICards;

/**
 * @author Kicho
 *
 */
public class PathValidator {

    DefaultMutableTreeNode myTreeNode;
    String currentPath;
    FormNode currentNode;
    FormNode ownerNode;
    
    Model model;
    DomainSystem domain;
    String errorMsg;
    RequireValuesPanel parentPanel;
    boolean inValidadeFields;
    
    public PathValidator(Model model, DefaultMutableTreeNode myTreeNode, RequireValuesPanel parentPanel) {
        this.model = model;
        this.myTreeNode = myTreeNode;
        this.parentPanel = parentPanel;
        
        domain = new DomainSystem(model);
        ownerNode = getFormNode(myTreeNode);
        
        currentPath = "";
        errorMsg = "";
        inValidadeFields = false;
    }

    //-------------------------------------------------------------------------

    public boolean validate(String value)  {
        
        //syntax checking
        if ( value.substring(value.length()-2, value.length()-1).equals("-") || 
                value.substring(value.length()-1, value.length()).equals(">"))  {
            setSyntaxError();
            return false;
        }
        
        //syntax checking
        String[] paths = value.split("->");
        StringBuffer sb = new StringBuffer();
        Vector vpaths = new Vector();        
        for ( int i = 0; i < paths.length; i++ )  {
            
            String unityPath = paths[i];
            if ( unityPath.trim().equals("") )  {
                setSyntaxError();
                return false;
            }
            
            int openParIndex = unityPath.indexOf("(");
            int closeParIndex = unityPath.lastIndexOf(")");
            
            if ( unityPath.length() != closeParIndex+1 )  {
                setSyntaxError();
                return false;
            }
            
            if ( openParIndex == -1 || closeParIndex == -1 )  {
                setSyntaxError();
                return false;
            }
            
            String reference = unityPath.substring(0, openParIndex);
            if ( !(reference == null || reference.equals("child") || reference.equals("parent")) )  {
                setSyntaxError();
                return false;
            }
            
            String id = unityPath.substring(openParIndex+1, closeParIndex);
            
            if ( !validateNextPatternId(id) )  {
                setSyntaxError();
                return false;
            }
            
            Vector path = new Vector();
            path.add(reference);
            path.add(id);
            vpaths.add(path);
        }
        
        //call validatePaths after a succesfuly syntax check
        return validatePaths(vpaths);
    }

    //-------------------------------------------------------------------------
    
    public String getErrorMsg() {
        return errorMsg;
    }

    //-------------------------------------------------------------------------

    private boolean validatePaths(Vector paths)  {
        
        //if has nothing to validate, just return true
        if ( paths.size() == 0 )
            return true;
        
        FormNode captorProjectNode = ownerNode.getParent();
        
        //validate the first element path
        Vector path = (Vector) paths.get(0);
        String reference = (String) path.get(0);
        String id = (String) path.get(1);
        currentPath = "current form->" + reference + "(" + id + ")";        
        
        if ( reference.equals("child") )  {
            String ret = validateHasNextForm(ownerNode, id);
            if ( ret != null )  {
                setPathError(paths, 0, ret);
                return false;
            }
        }
        else if ( reference.equals("parent") ) {
            String ret = validateHasParentForm(ownerNode, id); 
            if ( ret != null )  {
                setPathError(paths, 0, ret);
                return false;
            }
        }
        
        //validate the others elements paths
        for ( int i = 1; i < paths.size(); i++ )  {
            path = (Vector) paths.get(i);
            reference = (String) path.get(0);
            id = (String) path.get(1);
            currentPath = currentPath + "->" + reference + "(" + id + ")";        
            if ( reference.equals("child") )  {
                String ret = validateHasNextForm(currentNode, id);
                if ( ret != null )  {
                    setPathError(paths, 0, ret);
                    return false;
                }
            }
            else if ( reference.equals("parent") ) {
                String ret = validateHasParentForm(currentNode, id); 
                if ( ret != null )  {
                    setPathError(paths, 0, ret);
                    return false;
                }
            }
        }
        
        model.getProject().setStatus(Project.UNSAVED);
        return true;
    }

    //-------------------------------------------------------------------------

    private String validateHasNextForm(FormNode formNode, String id)  {
        int index = currentPath.lastIndexOf("->");
        String currentPath2 = "";
        if ( index != - 1)
            currentPath2 = currentPath.substring(0, index); 
        
        if ( formNode == null )
            return "\nThe form node \"" + currentPath2 + "\" doesn't have a child with id equals to \"" + id + "\".\nAdd this id to in the next forms element at the specified form.\n";
    
        
        ICards card = formNode.getCard();
        if ( card != null )  {
            Vector v = card.getFormElList();
            for ( int l = 0; l < v.size(); l++ )  {
                FormComponent fc = (FormComponent) v.get(l);
                if ( fc instanceof NextFormsPanel )  {
                    NextFormsPanel nfp = (NextFormsPanel) fc;
                    if ( validateNextForm(nfp, id) )  {
                        currentNode = getFormPathWithId(id);
                        return null; 
                    }
                }
                
            }        
        }
        
        return "\nThe form node \"" + currentPath2 + "\" doesn't have a child with id equals to \"" + id + "\".\nAdd this id to in the next forms element at the specified form.\n";
    }

    //-------------------------------------------------------------------------

    private String validateHasParentForm(FormNode formNode, String id)  {
        int index = currentPath.lastIndexOf("->");
        String currentPath2 = "";
        if ( index != - 1)
            currentPath2 = currentPath.substring(0, index); 
        
        if ( formNode == null )
            return "\nThe form node \"" + currentPath2 + "\" doesn't have a parent with id equals to \"" + id + "\".\n";
        
        String currentFormId = "";
        ICards card = formNode.getCard();
        if ( card != null )  {
            Vector v = card.getFormElList();
            
            for ( int l = 0; l < v.size(); l++ )  {
                FormComponent fc = (FormComponent) v.get(l);
                if ( fc instanceof FormIdPanel )  {
                    FormIdPanel fip = (FormIdPanel) fc;
                    currentFormId = fip.getValues(); 
                }
            }
        }
        
        FormNode captorProject = formNode.getParent();
        
        for ( int i = 0; i < captorProject.getChildCount(); i++ )  {
            FormNode fNode = captorProject.getChildAt(i);
            card = fNode.getCard();
            if ( fNode == formNode )
                continue;
            
            Vector v2 = card.getFormElList();
            for ( int j = 0; j < v2.size(); j++ )  {
                FormComponent fc = (FormComponent) v2.get(j);
                if ( fc instanceof FormIdPanel )  {
                    FormIdPanel fip = (FormIdPanel) fc;
                    String fipId = fip.getId();
                    if ( fipId.equals(id) )  {
                        for ( int k = 0; k < v2.size(); k++ )  {
                            FormComponent fc2 = (FormComponent) v2.get(k);
                            if ( fc2 instanceof NextFormsPanel )  {
                                NextFormsPanel nfp = (NextFormsPanel) fc2;
                                if ( validateNextForm(nfp, currentFormId) )  {
                                    currentNode = getFormPathWithId(id);
                                    return null;
                                }
                            }	
                        }                    
                    }
                }
            }
        }
        
        return "\nThe form node \"" + currentPath2 + "\" doesn't have a parent with id equals to \"" + id + "\".\nAdd this id to in the next forms element at the specified form.\n";
    }

    //-------------------------------------------------------------------------

    private boolean validateNextForm(NextFormsPanel nfp, String id)  {
        
        DefaultTableModel tableModel = nfp.getTableModel();
        Vector vmodel = tableModel.getDataVector();
        for ( int j = 0; j < vmodel.size(); j++ )  {
            Vector vdata = (Vector) vmodel.get(j);
            String idFCE = (String) vdata.get(0);
            if ( domain.compareId(idFCE.concat(".*"), id.concat(".*")) )
                return true;
        }
        
        return false;
    }

    //-------------------------------------------------------------------------

    private FormNode getFormPathWithId(String id)  {
        FormTree ftree = new FormTree(model);
        ownerNode = getFormNode(myTreeNode);
        FormNode captorProject = ownerNode.getParent();
        int teste = captorProject.getChildCount();
        
        for ( int i = 0; i < captorProject.getChildCount(); i++ )  {
            FormNode fNode = captorProject.getChildAt(i);
            ICards card = fNode.getCard();
            Vector formElList = card.getFormElList();
            
            for ( int j = 0; j < formElList.size(); j++ )  {
                FormComponent fc = (FormComponent) formElList.get(j);
                if ( fc instanceof FormIdPanel )  {
                    FormIdPanel fip = (FormIdPanel) fc;
                    String fipId = fip.getId();
                    if ( fipId.equals(id) )  {
                        return fNode;
                    }
                }
                
            }
        }
        
        return null;
    }

    //-------------------------------------------------------------------------

    private FormNode getFormNode(DefaultMutableTreeNode myTreeNode)  {
        FormTree ftree = new FormTree(model);
        FormNode root = ftree.getRoot();
        
        return getFormNode2(root, myTreeNode);
    }

    //-------------------------------------------------------------------------

    private FormNode getFormNode2(FormNode fnode, DefaultMutableTreeNode myTreeNode)  {
        if ( fnode.getNode() == myTreeNode )
            return fnode;
    
        for ( int i = 0; i < fnode.getChildCount(); i++ )  {
            FormNode fn = fnode.getChildAt(i);
            if ( fn != null && fn.getNode() == myTreeNode )  {
                return fn;
            }
        }
        
        for ( int i = 0; i < fnode.getChildCount(); i++ )  {
            FormNode fn = fnode.getChildAt(i);
            if ( fn != null )  {
                FormNode fn2 = getFormNode2(fn, myTreeNode);
                if ( fn2 != null && fn2.getNode() == myTreeNode )  {
                    return fn2;
                }
                
            }
        }
    
        return null;
    }
    
    //-------------------------------------------------------------------------
     
    private boolean validateNextPatternId(String id)  {
         //procurar por ids nulas
         if ( id == null || id.equals("") )  {
             return false;
         }
         
         try {
             Integer j = new Integer(id);
         } catch (NumberFormatException e) {
             return false;
         }
         
         return true;
     }

    //-------------------------------------------------------------------------
    
    private void setSyntaxError()  {
        StringBuffer sb = new StringBuffer();
    
        if ( inValidadeFields )  {
            sb.append("- Error       : require path syntax error.\n");
            sb.append("    - Correction  : correct the form path.\n");
            sb.append("    - Examples    :\n\n");
            sb.append("                 child(5)\n");
            sb.append("                 child(2)->child(3)\n");
            sb.append("                 parent(2)->parent(1)\n");
            sb.append("\n\n");
        }
        else  {
            sb.append("- Error          : require path syntax error.\n");
            sb.append("- Correction : correct the form path.\n");
            sb.append("- Examples   :\n\n");
            sb.append("               child(5)\n");
            sb.append("               child(2)->child(3)\n");
            sb.append("               parent(2)->parent(1)\n");
            sb.append("\n\n");
        }
        errorMsg = sb.toString();
    }

    //-------------------------------------------------------------------------

    private void setPathError(Vector paths, int pos, String desc)  {
        
        StringBuffer stringPath = new StringBuffer();
        for ( int i = 0; i < paths.size(); i++ )  {
            Vector path = (Vector) paths.get(i);
            String reference = (String) path.get(0);
            String id = (String) path.get(1);
            if ( i != 0 )
                stringPath.append("->");
            stringPath.append(reference + "(" + id + ")");
        }
        
        Vector pathError = (Vector) paths.get(pos);
        String refError = (String) pathError.get(0);
        String idError = (String) pathError.get(1);
        
        StringBuffer sb = new StringBuffer();
        
        //formating for different outputs
        if ( inValidadeFields )  {
            sb.append("- Error           : require path validation error.\n");
            sb.append("    - Correction      : correct the form path.\n");
            sb.append("    - Error paths     : " + stringPath + "\n");
            if ( paths.size() > 1 )
            sb.append("    - Error in        : " + refError + "(" + idError + ")" + "\n");
            sb.append(desc);
        }
        else  {
            sb.append("- Error            : require path validation error.\n");
            sb.append("- Correction   : correct the form path.\n");
            sb.append("- Error paths  : " + stringPath + "\n");
            if ( paths.size() > 1 )
            sb.append("- Error in     : " + refError + "(" + idError + ")" + "\n");
            sb.append(desc);
        }
        
        errorMsg = sb.toString();
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the inValidadeFields.
     */
    public boolean isInValidadeFields() {
        return inValidadeFields;
    }
    /**
     * @param inValidadeFields The inValidadeFields to set.
     */
    public void setInValidadeFields(boolean inValidadeFields) {
        this.inValidadeFields = inValidadeFields;
    }
    
    //-------------------------------------------------------------------------
}
