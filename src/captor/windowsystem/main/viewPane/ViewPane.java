package captor.windowsystem.main.viewPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;


/**
 * This class shows the views pane in the main window.
 * 
 * <p>
 * The view panes is: console view, error view and warning view.
 * </p>
 * 
 * @author Kicho
 */
public class ViewPane extends JPanel implements Observer {
    
    public static final long serialVersionUID = 160;

    JTabbedPane tabbed;
    JPanel consolePanel, erroPanel, warningPanel;
    JEditorPane erroTA, consoleTA, warningTA;
    JScrollPane scrollPaneErro, scrollPaneWarning, scrollPaneConsole;

    JPopupMenu popup;
    JMenuItem menuItem;
    
    private Model model;
    
    public ViewPane(Model model) {
        super();
        this.model = model;
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        tabbed = new JTabbedPane();
        
        warningPanel = new JPanel();
        erroPanel = new JPanel();
        consolePanel = new JPanel();
        
        createEditors();
        
        ViewMouseListener mouseListener = new ViewMouseListener(model);
        erroTA.addMouseListener(mouseListener);
        warningTA.addMouseListener(mouseListener);
        consoleTA.addMouseListener(mouseListener);
        
        ViewHyperLinkListener vhll = new ViewHyperLinkListener(model);
        erroTA.addHyperlinkListener(vhll);
        warningTA.addHyperlinkListener(vhll);
        consoleTA.addHyperlinkListener(vhll);
        
        erroTA.setEditable(false);
        warningTA.setEditable(false);
        consoleTA.setEditable(false);

        erroPanel.setLayout(new GridLayout(1,1));
        warningPanel.setLayout(new GridLayout(1,1));
        consolePanel.setLayout(new GridLayout(1,1));
        
        erroPanel.add(erroTA, BorderLayout.CENTER);
        consolePanel.add(consoleTA, BorderLayout.CENTER);
        warningPanel.add(consoleTA, BorderLayout.CENTER);
        
        scrollPaneErro = new JScrollPane(erroTA);
        scrollPaneWarning = new JScrollPane(warningTA);
        scrollPaneConsole = new JScrollPane(consoleTA);
        
        tabbed.addTab(MyIntl.VIEW_PANE_CONSOLE, scrollPaneConsole);
        tabbed.addTab(MyIntl.VIEW_PANE_ERROR, scrollPaneErro);
        tabbed.addTab(MyIntl.VIEW_PANE_WARNING, scrollPaneWarning);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(tabbed);
        
        if ( !model.getConfig().getGuiHiddenConfig().getShowConsoleView() )
            showHideComponent(scrollPaneConsole);
        if ( !model.getConfig().getGuiHiddenConfig().getShowWarningView() )
            showHideComponent(scrollPaneWarning);
        if ( !model.getConfig().getGuiHiddenConfig().getShowErrorView() )
            showHideComponent(scrollPaneErro);
    }
    
    //-------------------------------------------------------------------------

    private void showHideComponent(Component component)  {
        int index = tabbed.indexOfComponent(component);
        
        if ( index != -1 && tabbed.isEnabledAt(index) )  
            tabbed.remove(index);
        else  {
            addComponent(component);
        }
    }

    private void addComponent(Component component)  {
        Vector aux = new Vector();
        if ( tabbed.getTabCount() != 0 )  {
            for ( int i = 0; i < tabbed.getTabCount(); i++ )  {
                aux.add(tabbed.getComponentAt(i));
            }
        }
        aux.add(component);
        for ( int i = 0; i < tabbed.getTabCount(); i++ )  {
            tabbed.remove(i);
        }            
        
        if ( aux.contains(scrollPaneConsole) )
            tabbed.addTab("Console", scrollPaneConsole);
        if ( aux.contains(scrollPaneErro) )
            tabbed.addTab("Error", scrollPaneErro);
        if ( aux.contains(scrollPaneWarning) )
            tabbed.addTab("Warning", scrollPaneWarning);
        
        tabbed.setSelectedComponent(component);
    }
    
    // -------------------------------------------------------------------------
    
    public void update(Observable observable, Object obj)  {
        
        String aux = (String) obj;
        
        if ( aux.equals(Constant.GUI_CONF_SHOW_HIDE_CONSOLE_VIEW) )
            showHideComponent(scrollPaneConsole);
        else if ( aux.equals(Constant.GUI_CONF_SHOW_HIDE_WARNING_VIEW) )
            showHideComponent(scrollPaneWarning);
        else if ( aux.equals(Constant.GUI_CONF_SHOW_HIDE_ERROR_VIEW) )
            showHideComponent(scrollPaneErro);
        else if ( aux.equals(Constant.PRINT_ERROR) )  {
            
            int index = tabbed.indexOfComponent(scrollPaneErro);
            if ( index == -1 )
                addComponent(scrollPaneErro);
            
            setText(erroTA, model.getGui().getGuiView().getErrorView());
            try {
                tabbed.setSelectedComponent(scrollPaneErro);
            } catch (RuntimeException e) {}
        }
        else if ( aux.equals(Constant.PRINT_WARNING) )  {
            
            int index = tabbed.indexOfComponent(scrollPaneWarning);
            if ( index == -1 )
                addComponent(scrollPaneWarning);

            setText(warningTA, model.getGui().getGuiView().getWarningView());
        }
        else if ( aux.equals(Constant.PRINT_CONSOLE) )  {

            int index = tabbed.indexOfComponent(scrollPaneConsole);
            if ( index == -1 )
                addComponent(scrollPaneConsole);

            setText(consoleTA, model.getGui().getGuiView().getConsoleView());
            try {
                tabbed.setSelectedComponent(scrollPaneConsole);
            } catch (RuntimeException e) {}
        }
        else if ( aux.equals(Constant.CLEAR_ALL_VIEWS) )  {
            clearAll();
        }
    }
    
    private void clearAll()  {
        warningTA.setText("");
        consoleTA.setText("");
        erroTA.setText("");
    }
    
    //-------------------------------------------------------------------------

    private void setText(JEditorPane editor, String text)  {
        String currentContent = editor.getText();
//        System.out.println(currentContent);
        int bodyEnd = currentContent.indexOf("</body>");
        String newContent = currentContent.substring(0, bodyEnd);
        newContent = newContent + text;
        newContent = newContent + currentContent.substring(bodyEnd, currentContent.length());
//        System.out.println("\n\nNewcontent:\n\n'" + newContent+ "'");
        editor.setText(newContent);
    }
    
    //-------------------------------------------------------------------------
    
    private void createEditors()  {
        erroTA = new JEditorPane();
        warningTA = new JEditorPane();
        consoleTA = new JEditorPane();
        
        erroTA.setContentType("text/html");
        warningTA.setContentType("text/html");
        consoleTA.setContentType("text/html");
        
        //initializing editors
        erroTA.setText("<b></b>");
        warningTA.setText("<b></b>");
        consoleTA.setText("<b></b>");
    }
    
    //-------------------------------------------------------------------------
}
