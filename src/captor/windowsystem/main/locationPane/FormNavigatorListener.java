//JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), "There is no open project to validate.");
//model.getGui().getGuiView().setConsoleView("");
//model.getGui().getGuiView().setErrorView("");
//model.getGui().getGuiView().setWarningView("");


package captor.windowsystem.main.locationPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.FormType;
import captor.domainsystem.Forms;
import captor.domainsystem.NextFormType;
import captor.domainsystem.NextFormsType;
import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormHelp;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * @author Kicho
 *
 */
public class FormNavigatorListener implements ActionListener  {
    
    Model model;
    DomainSystem d;
    DefaultMutableTreeNode lastPattern;
    int insertDependens = 0;
    
    public FormNavigatorListener(Model model) {
        this.model = model;
        d = new DomainSystem(model);
    }
    
    /*
     * The component notify this object through this method.
     * This method always get and an argument in the action 
     * event object.
     * 
     * The argument has always the form: "OPERATION_TYPE[:ARGUMENT]"
     * where operation type is the type of operation requested and the
     * optional argument has some important value to this operation.
     * 
     * Current accepted operations types:
     * 
     *  - Constant.INSERT_PATTERN_AFTER:form_id
     *      - Insert a form after the lastSelected form
     *  - Constant.DELETE_NODE
     *      - Delete the lastSelectedNode
     *  - Constant.HELP_NODE
     *      - Show the help string from the lastSelectedForm to the user
     *  - Constant.LOAD_PATTERN
     *      - The user left-clicked in some form node in the navigator. 
     *        We have to show the form in the body panel
     *  - Constant.UP_NODE
     *      - Move this form up
     *  - Constant.UP_DOWN
     *      - Move this form down
     * 
     * */
    public void actionPerformed (ActionEvent e) {
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode)model.getGui().getTree().getLastSelectedPathComponent();
        
        Object obj = lastSelectedComponent.getUserObject();
        FormPath pp = null;
        if ( obj instanceof FormPath )
            pp = (FormPath) lastSelectedComponent.getUserObject();
        
        
        //the command and the argument
        String cmd = getCommand(e.getActionCommand());
        String argument = getArgument(e.getActionCommand());
        
        if ( cmd.equals(Constant.NEW_INTERACTION) )  {
            newInteraction();
        }
        else if ( cmd.equals(Constant.DELETE_NODE) )  {
            delete(pp);
        }
        else if ( cmd.equals(Constant.HELP_NODE) )  {
            help(pp);
        }
        else if ( cmd.equals(Constant.LOAD_FORM) )  {
            loadForm(pp, argument);
        }
        if ( cmd.equals(Constant.INSERT_FORM_AFTER) )  {
            insertPatternAfter(argument);
        }
        else if ( cmd.equals(Constant.UP_NODE) )  {
            upNode();
        }
        else if ( cmd.equals(Constant.DOWN_NODE) )  {
            downNode();
        }
    }
    
    //-----------------------------------------------------------------------------
    
    private void loadForm(FormPath pp, String id)  {
        pp.setFormType(d.getFormById(id));
        model.getGui().getGuiControl().setLoadPattern(true);
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-----------------------------------------------------------------------------
    
    public void newInteraction()  {
        FormType pt = d.getFirstForm();
        if ( pt == null )
            return;
        
        FormPath pp = new FormPath();
        pp.setFormType(pt);
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        
        //the number of this interaction
        int cont = model.getGui().getTree().getModel().getChildCount(root);
        pp.setInteraction(cont);
        cont++;
        
        //a new interactio node
        DefaultMutableTreeNode interactionNode = new DefaultMutableTreeNode("Interaction ".concat(new Integer(cont).toString()));
        root.add(interactionNode);
        
        //create the first form in an automatic way
        DefaultMutableTreeNode firstPattern = new DefaultMutableTreeNode(pp);
        pp.setTreeNode(firstPattern);
        
        //aqui
        FITBodyCard card = new FITBodyCard(model, pp, firstPattern);
        card.create();
        pp.setCard(card);
        
        interactionNode.add(firstPattern);
        
        lastPattern = firstPattern;
        insertDependens = 0;
        insertDependents(firstPattern, pp);
        
        TreeBuilder tb = new TreeBuilder(model);
        tb.expandInteraction(interactionNode);
        tb.selectFirstForm(interactionNode);
        model.getGui().getGuiControl().setLoadedPattern(true);
        
        //the project was modified so we have to say that for observers
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-----------------------------------------------------------------------------
    
    private void insertPatternAfter(String id)  {
        
        if ( !validateMultiplicity(id) )  {
            return;
        }
        
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        
        Forms p = model.getProject().getForms();
        FormType pt = d.getFormById(id);
        
        if ( pt == null )  {
            String msgError = "Meta-model error.\nCannot find Form id: " + id + " in \"" + p.getName() + "\" domain model.\nRun Meta-Model Validator to get details.";
            model.getGui().getGuiView().setErrorView(msgError);
            throw new RuntimeException(msgError);
        }
        
        //creating a new FormPath
        FormPath pp = (FormPath) lastSelectedComponent.getUserObject();
        FormPath newPP = pp.getCopy();
        newPP.setCard(null);
        newPP.setFormType(pt);
        
        //inserindo o elemento na árvore
        int index = lastSelectedComponent.getChildCount();
        DefaultMutableTreeNode newFormNode = new DefaultMutableTreeNode(newPP);
        lastSelectedComponent.insert(newFormNode, index);
        newPP.setTreeNode(newFormNode);
        
        FITBodyCard card = new FITBodyCard(model, newPP, newFormNode);
        card.create();
        newPP.setCard(card);
        
        insertDependens = 0;
        insertDependents(newFormNode, newPP);
        
        //esticando a árvore no elemento inserido
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
        
        TreePath tp = new TreePath(newFormNode.getPath());
        model.getGui().getTree().setSelectionPath(tp);
        
        //carrega o formulario do padrão default no body
        model.getGui().getGuiControl().setLoadPattern(true);
        
        //expanding the tree
        model.getGui().getTree().expandPath(new TreePath(parent.getPath()));
        
        //the project was modified so we have to say that for observers
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-----------------------------------------------------------------------------
    
    private void insertDependents(DefaultMutableTreeNode formNode, FormPath fp)  {
        //prevent a infinite loop recursive call
        insertDependens++;
        if ( insertDependens > 30 )
            return;
        
        NextFormsType nfst = fp.getFormType().getNextForms();
        if ( nfst == null )
            return;
        
        List nextFormsList = nfst.getNextForm();
        
        for ( int i = 0; i < nextFormsList.size(); i++ )  {
            NextFormType nft = (NextFormType) nextFormsList.get(i);
            if ( nft == null )
                continue;
            
            String formId = nft.getId();
            String minChilds = nft.getMinChilds();
            
            int minChildsInt = 0;
            try {
                minChildsInt = new Integer(minChilds).intValue();
            } catch (NumberFormatException e) {
                continue;
            }
            
            if ( minChildsInt > 0 )  {
                //creating a new FormPath
                for ( int j = 0; j < minChildsInt; j++ )  {
                    FormPath newPP = fp.getCopy();
                    newPP.setCard(null);
                    
                    formId = formId.replaceAll("\\*", "1");
                    FormType pt = d.getFormById(formId);
                    
                    newPP.setFormType(pt);
                    
                    //inserindo o elemento na árvore
                    int index = formNode.getChildCount();
                    DefaultMutableTreeNode newFormNode = new DefaultMutableTreeNode(newPP);
                    newPP.setTreeNode(newFormNode);
                    formNode.insert(newFormNode, index);
                    FITBodyCard card = new FITBodyCard(model, newPP, newFormNode);
                    card.create();
                    newPP.setCard(card);
                    
                    lastPattern = newFormNode;
                    
                    insertDependents(newFormNode, newPP);
                }
            }
            
        }
    }
    
    //-----------------------------------------------------------------------------
    
    private void delete(FormPath pp)  {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        
        if ( parent == root )
            deleteInteraction();
        else
            deleteForm(pp);
    }    
    
    //-----------------------------------------------------------------------------
    
    private void deleteInteraction()  {
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        String actionCommand = (String) lastSelectedComponent.getUserObject();
        
        int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), "Are you sure that tou want to delete \"" + actionCommand + "\"?", "Delete Interaction", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if ( res == JOptionPane.OK_OPTION )  {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
            
            //apagar a parte persistente tbm:
            String separator = System.getProperty("file.separator");
            File file = new File(model.getProject().getInputFolder() + separator + "interaction_" + parent.getIndex(lastSelectedComponent) + ".fit");
            if ( file.exists() )  {
                file.delete();
            }
            
            parent.remove(lastSelectedComponent);
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
            
            //refresh the node names
            for ( int i = 0; i < root.getChildCount(); i++ )  {
                DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) root.getChildAt(i);
                dmt.setUserObject("Interaction " + new Integer((i + 1)).toString());
            }
            
            ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
            
            //the project was modified so we have to say that for observers
            model.getProject().setStatus(Project.UNSAVED);
            model.getGui().getGuiControl().setLoadedPattern(true);
        }
        
    }
    
    //-----------------------------------------------------------------------------
    
    private void deleteForm(FormPath pp)  {

        if ( !validateParentMinChilds(pp) )
            return;
        
        if ( pp.getFormType().isIsRoot() )  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG74, pp.getName()));
            return;
        }
        
        
        int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG75, pp.getFormType().getName()), MyIntl.MSG76, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if ( res == JOptionPane.OK_OPTION )  {
            DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
            parent.remove(lastSelectedComponent);
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
            ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
            
            TreePath tp = new TreePath(parent.getPath());
            model.getGui().getTree().setSelectionPath(tp);
            model.getGui().getTree().expandPath(new TreePath(parent.getPath()));
            
            //indica que o projeto foi modificado
            model.getProject().setStatus(Project.UNSAVED);
        }
        
        model.getGui().getGuiControl().setLoadedPattern(true);
    }
    
    //-----------------------------------------------------------------------------
    
    //if the user want to insert a form after the lastSelectedForm we have to check
    //if the meta-model multiplicity defined in meta-model permits
    private boolean validateMultiplicity(String id)  {
        Forms p = model.getProject().getForms();
        if ( p == null )  {
            model.getGui().getGuiView().setErrorView("Cannot load forms from meta model.");
            throw new RuntimeException("Cannot load forms from meta model.");
        }
        
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        FormPath pp = (FormPath) lastSelectedComponent.getUserObject();
        FormType pt = pp.getFormType();
        
        if ( pt == null )  {
            String msgError = "Cannot find Form: " + id + " in \"" + p.getName() + "\" pattern language meta-model.";
            model.getGui().getGuiView().setErrorView(msgError);
            throw new RuntimeException(msgError);
        }
        
        //getting all the nextPatternsIds and multiplicitys from meta-model
        NextFormsType npst = pt.getNextForms();
        List nplist = npst.getNextForm();
        Vector nextPatternsList = new Vector();
        for(Iterator it1 = nplist.iterator(); it1.hasNext();) {
            NextFormType npt = (NextFormType) it1.next();
            nextPatternsList.add(npt);
        }        
        
        //getting all children id's
        Vector ppList = new Vector();
        for ( int i = 0; i < lastSelectedComponent.getChildCount(); i++ )  {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) lastSelectedComponent.getChildAt(i);
            FormPath aux = (FormPath) dmtn.getUserObject();
            String auxId = aux.getFormType().getId();
            ppList.add(auxId);
        }
        
        
        for ( int i = 0; i < nextPatternsList.size(); i++ )  {
            NextFormType npt = (NextFormType) nextPatternsList.get(i);
            if ( new DomainSystem(model).compareId(id, npt.getId()) )  {
                String cardinality = npt.getMaxChilds();
                if ( cardinality.toUpperCase().equals("N") )
                    return true;
                
                int childs = 0;
                for ( int j = 0; j < ppList.size(); j++)  {
                    String ids = (String) ppList.get(j);
                    if ( new DomainSystem(model).compareId(ids, id) )  {
                        childs++;
                    }
                }
                
                Integer mult;
                try {
                    mult = new Integer(cardinality);
                    if ( childs >= mult.intValue() )  {
                        JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG77, cardinality, d.getFormById(id).getName()));
                        return false;
                    }
                } catch (NumberFormatException e) {
                    String errorMsg = "The meta-model has a invalid value.\nUse meta-model validator to see details.";
                    model.getGui().getGuiView().setErrorView(errorMsg);
                    throw new RuntimeException(errorMsg);
                }
            }
        }
        
        return true;
    }
    
    //-----------------------------------------------------------------------------
    
    private void help(FormPath pp)  {
        if ( pp.getFormType() == null ) {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG78);
            return;
        }
        
        if ( pp.getFormType().getHelp() == null || pp.getFormType().getHelp().trim().equals("") ) {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG78);
            return;
        }
        
        FormHelp help = new FormHelp(model, pp.getFormType().getHelp());
        help.setVisible(true);
    }
    
    //-----------------------------------------------------------------------------
    
    private void upNode()  {
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        parent.insert(lastSelectedComponent, (parent.getIndex(lastSelectedComponent) -1 ) );
        
        
        //pushing the tree
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
        
        TreePath tp = new TreePath(lastSelectedComponent.getPath());
        model.getGui().getTree().setSelectionPath(tp);
        
        DefaultMutableTreeNode parent2 = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        model.getGui().getTree().expandPath(new TreePath(parent2.getPath()));
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-----------------------------------------------------------------------------
    
    private void downNode()  {
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        parent.insert(lastSelectedComponent, (parent.getIndex(lastSelectedComponent) + 1 ) );
        
        //pushing the tree
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
        
        TreePath tp = new TreePath(lastSelectedComponent.getPath());
        model.getGui().getTree().setSelectionPath(tp);
        
        DefaultMutableTreeNode parent2 = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        model.getGui().getTree().expandPath(new TreePath(parent2.getPath()));
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-----------------------------------------------------------------------------
    
    private String getCommand(String actionCommand)  {
        int index = actionCommand.indexOf(":");
        
        if ( index != -1 )  {
            return actionCommand.substring(0, index);
        }
        
        return actionCommand;
    }
    
    //-----------------------------------------------------------------------------

    private String getArgument(String actionCommand)  {
        int index = actionCommand.indexOf(":");
        
        if ( index != -1 )  {
            return actionCommand.substring(index+1 , actionCommand.length());
        }

        return null;
    }
    
    //-----------------------------------------------------------------------------
    
    private boolean validateParentMinChilds(FormPath fp)  {
        
        String formNodeId = fp.getFormType().getId();
        
        //getting the number of all brothers with the same id
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        int brothers = 0;
        for ( int i = 0; i < parent.getChildCount(); i++ )  {
            DefaultMutableTreeNode brother = (DefaultMutableTreeNode) parent.getChildAt(i);
            if ( brother.getUserObject() instanceof FormPath )  {
                FormPath bfp = (FormPath) brother.getUserObject();
                if ( formNodeId.trim().equals(bfp.getFormType().getId().trim())) 
                    brothers++;
            }
        }
        
        //getting the minChilds value, if any
        int minChildsInt = 0;
        FormPath parentFormPath = null;
        if ( parent.getUserObject() instanceof FormPath )  {
            parentFormPath = (FormPath) parent.getUserObject();
            FormType ft = parentFormPath.getFormType();
            NextFormsType nfs = ft.getNextForms();
            List nextFormList = nfs.getNextForm();
            for ( int i = 0; i < nextFormList.size(); i++ )  {
                NextFormType nf = (NextFormType) nextFormList.get(i);
                if ( d.compareId(nf.getId().trim(),formNodeId) )  {
                    String minChilds = nf.getMinChilds();
                    try {
                        minChildsInt = new Integer(minChilds).intValue();
                    } catch (NumberFormatException e) {
                        minChildsInt = 0;
                    }
                    break;
                }
            }
        } 
        
        if ( brothers-1 < minChildsInt )  {
            String parentName = "";
            if ( parentFormPath != null )  {
                parentName = parentFormPath.getName();
            }
            
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG79, parentName, brothers, d.getFormById(formNodeId).getName()));
            return false;
        }
        
        return true;
    }
    
    //-----------------------------------------------------------------------------
}
