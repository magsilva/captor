package captor.windowsystem.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.AboutWindow;


public class HelpMenuListener implements ActionListener  {
    
    private Model model;
    
    public HelpMenuListener(Model model) {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_ABOUT) )  {
            AboutWindow about = new AboutWindow(model);
            about.setVisible(true); 
        }
    }

    //-------------------------------------------------------------------------
}

