package captor.windowsystem.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.MainWindow;
import captor.windowsystem.PreferencesWindow;


public class WindowMenuListener implements ActionListener  {

    private Model model;
    
    public WindowMenuListener(Model model) {
        this.model = model;
    }

    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_WARNING) )  {
            showHideWarningView();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_ERROR) )  {
            showHideErrorView();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_CONSOLE) )  {
            showHideConsoleView();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_NEW_WINDOW) )  {
            newWindow();
        }
        else if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_PREFERENCES) )  {
            openWindowPreferences();
        }
    }
    
    //-------------------------------------------------------------------------

    public void showHideConsoleView()  {
        if ( model.getConfig().getGuiHiddenConfig().getShowConsoleView() == true )
            model.getConfig().getGuiHiddenConfig().setShowConsoleView(false);
        else
            model.getConfig().getGuiHiddenConfig().setShowConsoleView(true);
    }
    
    //-------------------------------------------------------------------------

    public void showHideWarningView()  {
        if ( model.getConfig().getGuiHiddenConfig().getShowWarningView() == true )
            model.getConfig().getGuiHiddenConfig().setShowWarningView(false);
        else
            model.getConfig().getGuiHiddenConfig().setShowWarningView(true);
    }

    //-------------------------------------------------------------------------

    public void showHideErrorView()  {
        if ( model.getConfig().getGuiHiddenConfig().getShowErrorView() == true )
            model.getConfig().getGuiHiddenConfig().setShowErrorView(false);
        else
            model.getConfig().getGuiHiddenConfig().setShowErrorView(true);
    }

    //-------------------------------------------------------------------------

    public void openWindowPreferences()  {
        PreferencesWindow pw = new PreferencesWindow(model);
        pw.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    public void newWindow()  {
        model.getGui().getGuiControl().setSaveModel(true);
        Model m = new Model();
        m.load(model.getConfig().getSystemConfig().getInstallPath());
        m.getUtil().setClipboard(model.getUtil().getClipboard());
        
        MainWindow f = new MainWindow(m);
        f.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
}
