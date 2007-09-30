/*
 *
 */
package captor.windowsystem.metamodelvalidator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import captor.lib.intl.MyIntl;
import captor.windowsystem.CaptorFrame;


/**
 * @author Kicho
 *
 */
public class Footer extends JPanel implements ActionListener {
    
    public static final long serialVersionUID = 134;

    JButton close, help;
    
    private CaptorFrame frame;
    
    public Footer(CaptorFrame frame) {
        super();
        this.frame = frame;
        create();
    }
    
    public void create()  {
        
        this.setPreferredSize(new Dimension(500,40));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        close = new JButton(MyIntl.METAMODEL_VALIDATOR_CLOSE);
        close.addActionListener(this);
        
        add(new JLabel("   "));
        
        Dimension minSize = new Dimension(5, 100);
        Dimension prefSize = new Dimension(5, 500);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 1200);
        add(new Box.Filler(minSize, prefSize, maxSize));

        add(new JLabel("         "));
        add(close);
        add(new JLabel("   "));
    }
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.METAMODEL_VALIDATOR_CLOSE) )  {
            frame.setVisible(false);
            frame.dispose();
        }
    }

}
