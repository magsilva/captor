package captor.projectsystem.projectvalidator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.NextFormType;
import captor.domainsystem.NextFormsType;
import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.CustomRenderer;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * @author Kicho
 *
 */
public class SecondLayerValidator extends LayerValidator  {
    
    DomainSystem d;
    
    public SecondLayerValidator(Model model)  {
        super(model);
        d = new DomainSystem(model);
    }
    
    //-----------------------------------------------------------------------------    

    protected boolean validate2(DefaultMutableTreeNode root) {
        
        //recursive call
        int count = root.getChildCount();
        if ( count > 0 )  {
            for ( int i = 0; i < count; i++ )  {
                DefaultMutableTreeNode aux = (DefaultMutableTreeNode) root.getChildAt(i);
                if ( !validate2(aux) ) 
                    return false;
            }
        }
        
        int level = root.getLevel();
        
        //root level || interaction node. this node is the root of the graph
        if ( level == 0 || level == 1 )  {
            return true;
        }
        
        FormPath pp = null;
        Object o = root.getUserObject();
        if ( o == null )  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("<b>The form:</b> " + root + " has not been initialized.<br>To build your project, please load some variant in this pattern or try to delete it.<br>");
            return false;
        }
        
        if ( !(o instanceof FormPath) )  {
            showErrorTitle();  
            model.getGui().getGuiView().setErrorView("<b>The form:</b> " + root + " has not been correctly initialized.<br>");
            return false;
        }
        
        pp = (FormPath) o;
        
        //validateMinimum multiplicity
        if ( !validateMinChilds(root, pp) ) {
            return false;
        }
        
        return true;
    }

    //-------------------------------------------------------------------------

    private boolean validateMinChilds(DefaultMutableTreeNode root, FormPath pp)  {
        NextFormsType nft = pp.getFormType().getNextForms();
        if ( nft == null )
            return true;
        
        List nextFormList = nft.getNextForm();
        for(Iterator it1 = nextFormList.iterator(); it1.hasNext();) {
            NextFormType nextForm = (NextFormType) it1.next();
            String minChilds = nextForm.getMinChilds();
            String childFormId = nextForm.getId();
            int minChildsInt;
            
            try {
                minChildsInt = new Integer(minChilds).intValue();
            } catch (NumberFormatException e) {
                continue;
            }
            
            if ( minChildsInt <= 0 )
                continue;
            
            Enumeration enum2 = root.children();
            int count = 0;
            while ( enum2.hasMoreElements() )  {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enum2.nextElement();
                if ( node.getUserObject() instanceof FormPath )  {
                    FormPath nfp = (FormPath) node.getUserObject();
                    if ( d.compareId(nfp.getFormType().getId().trim(), childFormId.trim()) )  {
                        count++;
                    }
                }
            }
            
            if ( count < minChildsInt )  {
                showMinChildError(root, pp, childFormId, minChildsInt, count);
                return false;
            }
        }        
        return true;
    }
    
    //-----------------------------------------------------------------------------

    private void showMinChildError(DefaultMutableTreeNode root, FormPath pp, String formId, int minChildsInt, int currentChilds)  {
        //setting the node error
        model.getGui().getGuiControl().setNodeError(root);
        
        //selectig the error node in the tree
        TreePath tp = new TreePath(root.getPath());
        model.getGui().getTree().setSelectionPath(tp);
        
        //ask to listeners to show the body panel
        model.getGui().getGuiControl().setLoadedPattern(true);
        
        //update tree icons
        CustomRenderer customRenderer = new CustomRenderer(model);
        model.getGui().getTree().setCellRenderer(customRenderer);
        
        DomainSystem d = new DomainSystem(model);
        model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_SECOND_LAYER_VALIDATOR_1, pp.getFullPath(), pp.getFullPath(), minChildsInt, currentChilds, d.getFormById(formId).getName()));
    }
    
    //-----------------------------------------------------------------------------
}
