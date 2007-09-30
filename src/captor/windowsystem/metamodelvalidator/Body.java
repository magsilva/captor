/*
 *
 */
package captor.windowsystem.metamodelvalidator;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class Body extends JPanel {

    public static final long serialVersionUID = 131;

    JTextArea ta;
    JScrollPane scrollPane;

    public Body(Model model)  {
        setOpaque(true);
        repaint();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        ta = new JTextArea();
        ta.addMouseListener(new BodyMouseListener());
        scrollPane = new JScrollPane(ta);
        
        this.add(scrollPane);
    }
    
    //-------------------------------------------------------------------------
    
    public void setText(ValidationResults vr)  {
        ta.setText(vr.getBuffer().toString());
        if ( vr.isSuccess() )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG84);
        }
        else  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG85);
        }
    }
    
    //-------------------------------------------------------------------------

    public JTextArea getTA()  {
        return ta;
    }
}
