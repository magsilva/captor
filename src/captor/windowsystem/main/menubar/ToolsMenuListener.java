/*
 *
 */
package captor.windowsystem.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.MetaModelValidatorWindow;


/**
 * @author Kicho
 *
 */
public class ToolsMenuListener implements ActionListener  {

    private Model model;
    
    public ToolsMenuListener(Model model) {
        this.model = model;
    }

    public void actionPerformed (ActionEvent e) {
//        System.out.println (e.getActionCommand());
        
        if ( e.getActionCommand().equals(MyIntl.SUBMENU_BAR_METAMODEL_VALIDATOR) )  {
            metaModelValidator();
        }
    }
    
    private void metaModelValidator()  {
        MetaModelValidatorWindow mmv = new MetaModelValidatorWindow(model);
        mmv.setVisible(true);
    }
    
}
