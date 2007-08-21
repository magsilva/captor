package captor.windowsystem.main.viewPane;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import captor.modelsystem.Model;
import captor.windowsystem.util.IconUtil;


/**
 * @author Kicho
 *
 */
public class ViewMouseListener extends MouseAdapter implements ActionListener  {

    /**
     *
     */

    private JPopupMenu popup;
    private JMenuItem clear, copy, clearall;//, cut, paste;
    private Object object;
    private Model model;
    
    public ViewMouseListener(Model model) {
        super();
        this.model = model;
        popup = new JPopupMenu();
        
        clear = new JMenuItem("Clear");
        clear.addActionListener(this);
        insertIcon(clear, "clean.gif");
        popup.add(clear);
        
        clearall = new JMenuItem("Clear All");
        clearall.addActionListener(this);
        insertIcon(clearall, "cleanall.gif");
        popup.add(clearall);
        
        popup.addSeparator();
        
        copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        insertIcon(copy, "copy.gif");
        popup.add(copy);

//        cut = new JMenuItem("Cut");
//        cut.addActionListener(this);
//        insertIcon(cut, "cut.gif");
//        popup.add(cut);

//        paste = new JMenuItem("Paste");
//        paste.addActionListener(this);
//        insertIcon(paste, "paste.gif");
//        popup.add(paste);

    }
    
    //-------------------------------------------------------------------------

    public void mouseClicked(java.awt.event.MouseEvent event)  {
//        System.out.println(object);
        if(event.getModifiers() == MouseEvent.BUTTON3_MASK) {//right button click on mouse
            object = event.getSource();

            object = event.getSource();
            JEditorPane ta = (JEditorPane) object;
            String selection = ta.getSelectedText();
            if ( selection == null || selection.equals("") )  {
                copy.setEnabled(false);
//                cut.setEnabled(false);
            }
            else  {
                copy.setEnabled(true);
//                cut.setEnabled(true);
            }
            
            if ( ta.getText().equals("") )
                clear.setEnabled(false);
            else
                clear.setEnabled(true);

//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            Transferable clipData = clipboard.getContents(clipboard);
//            if (clipData != null) {
//              if (clipData.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
//                    paste.setEnabled(true);
//              }
//              else  {
//                  paste.setEnabled(false);
//              }
//            }            
            
            popup.show(event.getComponent(),event.getX(), event.getY());            
        }        
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
//        System.out.println(e);
        JEditorPane ta = (JEditorPane) object;
        
        if ( e.getActionCommand().equals("Clear") )  {
            ta.setText("");
        }
        else if ( e.getActionCommand().equals("Clear All") )  {
            model.getGui().getGuiView().setClearAllViews(true);
        }        
        else if ( e.getActionCommand().equals("Copy") )  {
            String selection = ta.getSelectedText();
            StringSelection data = new StringSelection(selection);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(data, data);            
        }        
        else if ( e.getActionCommand().equals("Cut") )  {
            String selection = ta.getSelectedText();
            StringSelection data = new StringSelection(selection);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(data, data);
            ta.replaceSelection("");
        }        
//        else if ( e.getActionCommand().equals("Paste") )  {
//            String selection = "";
//
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            Transferable clipData = clipboard.getContents(clipboard);
//            if (clipData != null) {
//              if (clipData.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
//                try {
//                    selection = (String)(clipData.getTransferData(DataFlavor.stringFlavor));
//                } catch (UnsupportedFlavorException e1) {} 
//                  catch (IOException e1) {}
//              }
//            }            
//            ta.insert(selection, ta.getCaretPosition());
//        }        
    }
    
    //-------------------------------------------------------------------------

    public void insertIcon(JMenuItem jitem, String iconName)  {
        Icon icon = IconUtil.getIcon(iconName);
        jitem.setIcon(icon);
    }
    
    //-------------------------------------------------------------------------
}
