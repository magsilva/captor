/*
 *
 */
package captor.windowsystem.formcomponent.gren.classpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import captor.modelsystem.Model;
import captor.windowsystem.formcomponent.gren.classpanel.data.GRENAttribute;


/**
 * @author Kicho
 *
 */
public class AttListListener extends MouseAdapter implements ActionListener {
    
    private JPopupMenu popup;
    private JMenuItem copy, cut, paste;
    private Model model;
    private JList list;
    private GRENAttributePanel sourcePanel;
    
    public AttListListener(Model model, JList list, GRENAttributePanel sourcePanel) {
        super();
        
        this.model = model;
        this.list = list;
        this.sourcePanel = sourcePanel;
        
        popup = new JPopupMenu();
        
        copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        popup.add(copy);

        cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        popup.add(cut);

        paste = new JMenuItem("Paste");
        paste.addActionListener(this);
        popup.add(paste);
    }
    
    //-------------------------------------------------------------------------
    
    public void mouseClicked(java.awt.event.MouseEvent event)  {
        if(event.getModifiers() == MouseEvent.BUTTON3_MASK) {//right button click on mouse
            JList list = (JList) event.getSource();
            rightClickList(list, event);            
        }        
    }

    private void rightClickList(JList list, java.awt.event.MouseEvent event)  {

        if ( list.isSelectionEmpty() )  {
            copy.setEnabled(false);
            cut.setEnabled(false);
        }
        else  {
            copy.setEnabled(true);
            cut.setEnabled(true);
        }

        paste.setEnabled(true);
        popup.show(event.getComponent(),event.getX(), event.getY());

    }
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
//        System.out.println(e);
        
        if ( e.getActionCommand().equals("Copy") || e.getActionCommand().equals("Cut") )  {
            Vector v = new Vector();
            DefaultListModel listModel = (DefaultListModel) list.getModel();
            int []index = list.getSelectedIndices();
            for ( int i = 0; i < index.length; i++ )  {
                GRENAttribute gattr = (GRENAttribute) listModel.elementAt(index[i]);
                GRENAttribute gattr2 = gattr.getCopy();
                v.add(gattr2);
            }
            
            model.getUtil().getClipboard().put("gren_attributes", v);
        }
        
        if ( e.getActionCommand().equals("Cut") )  {
            DefaultListModel listModel = (DefaultListModel) list.getModel();
            int []index = list.getSelectedIndices();
            for ( int i = 0; i < index.length; i++ )  {
                listModel.remove(index[i]);
            }            
        }
        else if ( e.getActionCommand().equals("Paste") )  {
            //atualizar os elementos do frame
            Object obj = model.getUtil().getClipboard().get("gren_attributes");
            if ( obj != null )  {
                if ( obj instanceof Vector )  {
                    
                    Vector v = (Vector) obj;
                    for ( int i = 0; i < v.size(); i++ )  {
                        sourcePanel.addAttribute((GRENAttribute ) v.get(i));
                    }
                }
            }
        }
        
    }
    
}

