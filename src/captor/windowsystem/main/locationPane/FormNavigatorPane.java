package captor.windowsystem.main.locationPane;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import captor.lib.def.Constant;
import captor.modelsystem.Model;

/**
 * This class implements a panel that shows the navigator pane in the main window.
 * 
 * @author Kicho
 */
public class FormNavigatorPane extends JPanel implements Observer {
    
    public static final long serialVersionUID = 120;

    JPanel mainPane;
    TreePane historyPane;
    
    private Model model;
    
    public FormNavigatorPane(Model model) {
        super();
        this.model = model;
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        mainPane = new JPanel();
        historyPane = new TreePane(model);
        
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
        mainPane.add(historyPane);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(mainPane);
    }
    
    //-------------------------------------------------------------------------
    
    public void update(Observable observable, Object obj)  {
 
        if ( obj instanceof String )  {
            String aux = (String) obj;

            if ( aux.equals(Constant.LOAD_DOMAIN) )
                loadDomain();
        }
    }    
    
    //-------------------------------------------------------------------------

    private void loadDomain()  {
        historyPane.loadDomain();        
    }
    
    //-------------------------------------------------------------------------
}    
