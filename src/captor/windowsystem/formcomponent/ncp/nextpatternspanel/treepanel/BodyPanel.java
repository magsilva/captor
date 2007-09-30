/*
 *
 */
package captor.windowsystem.formcomponent.ncp.nextpatternspanel.treepanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.modelsystem.Model;
import captor.windowsystem.formcomponent.ncp.nextpatternspanel.NextFormsPanel;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;

public class BodyPanel extends JPanel {

    public static final long serialVersionUID = 106;

    JPanel bodyPanel;
    
    public BodyPanel(Model model) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        bodyPanel = new JPanel();
        bodyPanel.setLayout(new CardLayout());
        
        bodyPanel.setBackground(Color.black);
        bodyPanel.add(new JPanel(), "init");
        
        this.setPreferredSize(new Dimension(500, 200));
        bodyPanel.setPreferredSize(new Dimension(500, 200));
        this.setMinimumSize(new Dimension(500, 200));
        bodyPanel.setMinimumSize(new Dimension(500, 200));
        
        this.add(Box.createRigidArea(new Dimension(5,5)));
        this.add(bodyPanel);
        this.add(Box.createVerticalGlue());
    }

    //-------------------------------------------------------------------------
    
    public void loadForm(DefaultMutableTreeNode lastSelectedNode)  {
        if ( lastSelectedNode == null )
            return;
        
        Object obj = lastSelectedNode.getUserObject();
        if ( obj instanceof FormPath )  {
            FormPath fp = (FormPath) obj;
            
            FITBodyCard card = fp.getCard();
            if ( card == null )
                return;
            
            card.updateAllElements();
            bodyPanel.add(card, card.toString());
            
            for ( int i = 0; i < card.getFormElList().size(); i++ )  {
                Object obj2 = card.getFormElList().get(i);
                if ( obj2 instanceof NextFormsPanel )  {
                    NextFormsPanel nfp = (NextFormsPanel) obj2;
                    nfp.enableButtons(false);
                }
            }

            CardLayout cl = (CardLayout)(bodyPanel.getLayout());
            cl.show(bodyPanel, card.toString());
        }
    }
    
    //-------------------------------------------------------------------------
}
