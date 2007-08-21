package captor.windowsystem.main.bodyPane;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.def.Constant;
import captor.modelsystem.Model;
import captor.windowsystem.main.locationPane.util.FormPath;


public class BodyPane extends JPanel implements Observer {
    
    public static final long serialVersionUID = 116;

    JPanel panel;
    
    private Model model;
    
    public BodyPane(Model model) {
        this.model = model;
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        panel =  new JPanel();
        panel.setLayout(new CardLayout());
        panel.add(new JPanel(), "init");
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, "init");

        this.add(Box.createRigidArea(new Dimension(5,5)));
        this.add(panel);
        this.add(Box.createVerticalGlue());
    }
    
    //-------------------------------------------------------------------------
    
    public void update(Observable observable, Object obj)  {
        String aux = (String) obj;
        
        if ( aux.equals(Constant.LOADED_FORM) || aux.equals(Constant.LOAD_FORM) )  {
            DefaultMutableTreeNode lastSelectedComponent = (DefaultMutableTreeNode) model.getGui().getTree().getLastSelectedPathComponent();
            if ( lastSelectedComponent == null )  {
                cleanBody();
                return;
            }
            
            Object fpObj = lastSelectedComponent.getUserObject();
            if ( fpObj instanceof FormPath )  {

                FormPath pp = (FormPath) fpObj;
	            if ( pp == null ){
	                cleanBody();
	                return;
	            }
	            
	            FITBodyCard card = pp.getCard();
                if ( aux.equals(Constant.LOAD_FORM) )  {
                      card = new FITBodyCard(model, pp, lastSelectedComponent);
                      card.create();
                      pp.setCard(card);
                }
                
                if ( card != null )  {
                    card.updateAllElements();
    	            panel.add(card, card.toString());
    	            CardLayout cl = (CardLayout)(panel.getLayout());
    	            cl.show(panel, card.toString());
                }
            }
        }
        else if ( aux.equals(Constant.CLOSE_PROJECT) )  {
            CardLayout cl = (CardLayout)(panel.getLayout());
            cl.show(panel, "init");
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void cleanBody()  {
        panel.add(new JPanel(), "card");
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, "card");
    }
    //-------------------------------------------------------------------------
}
