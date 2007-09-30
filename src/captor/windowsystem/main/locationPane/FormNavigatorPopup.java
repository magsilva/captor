package captor.windowsystem.main.locationPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.FormType;
import captor.domainsystem.NextFormType;
import captor.domainsystem.NextFormsType;
import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * @author Kicho
 * This class shows the pop-up window when the user click in
 * some form in the form navigator panel.
 * There are tow kinds os pop-up windows:
 * 
 *  - The first is the rootPopUpWindow and the popUpForm
 */
public class FormNavigatorPopup extends MouseAdapter  {
    
    JTree tree;
    JPopupMenu popupForm, popupRoot;
    JMenu formVariant, nextForms, insertAfter, edit, help, move;
    JMenuItem menuItem;
    FormNavigatorListener historyListener;
    
    private Model model;
    private DomainSystem d;
    
    public FormNavigatorPopup(JTree tree, Model model) {
        this.tree = tree;
        this.model = model;
        
        historyListener = new FormNavigatorListener(model);
        d = new DomainSystem(model);
    }
    
    public void mouseClicked(java.awt.event.MouseEvent event)  {
        //the user has clicked in some form node in the tree
        //we should to display the form in the body panel and return
        if( event.getModifiers() == MouseEvent.BUTTON1_MASK )  {
            model.getGui().getGuiControl().setLoadedPattern(true);
            return;
        }

        //set the node selected
        if ( event.getModifiers() == MouseEvent.BUTTON3_MASK ) { 
            TreePath tp = model.getGui().getTree().getPathForLocation(event.getX(), event.getY());
            model.getGui().getTree().setSelectionPath(tp);
            model.getGui().getGuiControl().setLoadedPattern(true);
        }
        
        //the user has clicked in some form node with rigth-click
        //we have to show the rigth pop-up window 
        if ( event.getModifiers() == MouseEvent.BUTTON3_MASK ) { 
            
            TreePath tp = tree.getPathForLocation(event.getX(), event.getY());
            if ( tp != null )
                tree.setSelectionPath(tp);
            
//            DefaultMutableTreeNode lastSelectedComponent = null;
//            if ( event.getSource() instanceof DefaultMutableTreeNode )
//                lastSelectedComponent = (DefaultMutableTreeNode) event.getSource();
//            else
//              lastSelectedComponent = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            
            int pos = 0;
            if ( tp != null )  {
                pos =  tp.getPathCount();
            }
            
            if ( pos == 1 )  {
                //call pop-up window for root element in the tree ("Forms" node)
                makeRootPopup(event.getComponent(),event.getX(), event.getY());
            }
            else if ( pos >= 2 )  {
                // call the pop-up window to forms elements 
                // this window has a form: load variant, insert after, edit->delete, move-up, move-down and so on)
                makePopup(event.getComponent(),event.getX(), event.getY());
            }
        }
        
    }
    
    //------------------------------------------------------------------------------
    
    private void makeRootPopup(Component component, int x, int y)  {
        if ( model.getProject() != null )  {
            if ( model.getProject().getStatus() != Project.CLOSED )  {
                popupRoot = new JPopupMenu();
                menuItem = new JMenuItem(Constant.NEW_INTERACTION);
                menuItem.addActionListener(historyListener);
                popupRoot.add(menuItem);
            }
        }
        else  {
            popupRoot = null;
        }

        if ( popupRoot != null )  {
            popupRoot.show(component, x, y);
        }
    }
    
    //------------------------------------------------------------------------------
    
    private void makePopup(Component component, int x, int y)  {
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedComponent.getParent();
        
        Object obj = lastSelectedComponent.getUserObject();
        FormPath pp = null;
        if ( obj instanceof FormPath)
            pp = (FormPath) lastSelectedComponent.getUserObject();
        
        popupForm = new JPopupMenu();
        
        if ( pp != null )  {
            //load pattern variant menu
            if ( pp.getFormType() != null )  {
                formVariant = makeLoadVariantMenu();
                if ( formVariant != null )  {
                    if ( formVariant.getItemCount() <= 0 )
                        formVariant.setEnabled(false);
                    
                    popupForm.add(formVariant);
                    popupForm.addSeparator();
                }
            }
            
            //insert after menu
            insertAfter = makeInsertAfterMenu(pp);
            if ( insertAfter != null )  {
                if ( insertAfter.getItemCount() <= 0 )
                    insertAfter.setEnabled(false);
                popupForm.add(insertAfter);
            }
            
        }
        
        //edit menu
        edit  = new JMenu(MyIntl.NAVIGATOR_POPUP_EDIT);
        menuItem = new JMenuItem(MyIntl.NAVIGATOR_POPUP_DELETE);
        menuItem.addActionListener(historyListener);
        menuItem.setActionCommand(Constant.DELETE_NODE + ":");
        edit.add(menuItem);
        
        if ( pp != null )  {
            popupForm.addSeparator();
        }
        
        popupForm.add(edit);
        
        move  = new JMenu(MyIntl.NAVIGATOR_POPUP_MOVE);
        move.setEnabled(false);
        if ( pp != null )  {
            if ( parent.getChildCount() > 1 )  {
                move.setEnabled(true);
                menuItem = new JMenuItem(MyIntl.NAVIGATOR_POPUP_MOVEUP);
                menuItem.addActionListener(historyListener);
                menuItem.setActionCommand(Constant.UP_NODE + ":");
                move.add(menuItem);
                
                if ( parent.getIndex(lastSelectedComponent) == 0 )
                    menuItem.setEnabled(false);
                
                
                menuItem = new JMenuItem(MyIntl.NAVIGATOR_POPUP_MOVEDOWN);
                menuItem.addActionListener(historyListener);
                menuItem.setActionCommand(Constant.DOWN_NODE + ":");
                move.add(menuItem);
                
                if ( (parent.getIndex(lastSelectedComponent) + 1) == parent.getChildCount() )
                    menuItem.setEnabled(false);
            }
        }
        popupForm.add(move);
        
        if ( pp != null )  {
            menuItem = new JMenuItem(MyIntl.NAVIGATOR_POPUP_HELP);
            menuItem.addActionListener(historyListener);
            menuItem.setActionCommand(Constant.HELP_NODE + ":");
            popupForm.addSeparator();
            popupForm.add(menuItem);
        }
        
        popupForm.show(component, x, y);
    }
    
    //------------------------------------------------------------------------------
    
    private JMenu makeInsertAfterMenu(FormPath pp)  {
        JMenu ia = new JMenu(MyIntl.NAVIGATOR_POPUP_INSERT_AFTER);
        boolean hasChild = false;
        
        Vector nextPatternsId = new Vector();
        //Criar um vetor com o id dos proximos padroes desse no
        NextFormsType npst = pp.getFormType().getNextForms();
        if ( npst != null )  {
            List l = npst.getNextForm();
            for(Iterator it1 = l.iterator(); it1.hasNext();) {
                Object obj = it1.next();
                NextFormType npt = (NextFormType) obj;
                String patternId = npt.getId();
                nextPatternsId.add(patternId);
            }        
        }
        
        //inserir os proximos padrões no menu
        Vector nextPatternNames = new Vector();
        Vector nextPatternIds = new Vector();
        for ( int i = 0; i < nextPatternsId.size(); i++ )  {
            String id = (String) nextPatternsId.get(i);
            String pname = d.getFormById(id).getName();
            nextPatternNames.add(pname);
            nextPatternIds.add(id);
        }
        
        for ( int i = 0; i < nextPatternNames.size(); i++ )  {
            menuItem = new JMenuItem((String) nextPatternNames.get(i));
            menuItem.addActionListener(historyListener);
            menuItem.setActionCommand(Constant.INSERT_FORM_AFTER + ":" + (String) nextPatternIds.get(i));
            
            ia.add(menuItem);
            hasChild = true;
        }
        
        if ( !hasChild )
            ia.setEnabled(false);
        
        return ia;
    } 
    
    //------------------------------------------------------------------------------
    
    private JMenu makeLoadVariantMenu(){
        DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        FormPath pp = (FormPath) lastSelectedComponent.getUserObject();
        
        formVariant = new JMenu(MyIntl.NAVIGATOR_POPUP_LOAD);
        
        FormType pt = pp.getFormType();
        
        if ( pt != null )  {
            Vector patternVariants = d.getVariantByForm(pt.getName());
            for ( int i = 0; i < patternVariants.size(); i++ )  {
                FormType ptv = (FormType) patternVariants.get(i);  
                menuItem = new JMenuItem(MyIntl.NAVIGATOR_POPUP_LOAD_VARIANT + ": " + ptv.getVariant());
                menuItem.addActionListener(historyListener);
                menuItem.setActionCommand(Constant.LOAD_FORM + ":" + ptv.getId());
                if ( !ptv.isEnabled() )
                    menuItem.setEnabled(false);
                
                if ( ptv.getId().equals(pt.getId()) )
                    menuItem.setEnabled(false);
                
                formVariant.add(menuItem);
            }
        }
        
        return formVariant;
    }
    
    //------------------------------------------------------------------------------
}