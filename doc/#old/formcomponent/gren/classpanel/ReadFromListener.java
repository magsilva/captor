/*
 *
 */
package captor.windowsystem.formcomponent.gren.classpanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * @author Kicho
 *
 */
public class ReadFromListener implements KeyListener {
    
    private JTextField source;
    private JTextField destination;
    
    public ReadFromListener(JTextField source, JTextField destination)  {
        source.addKeyListener(this);
        this.source = source;
        this.destination = destination;
        this.destination.setText(source.getText());
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {}
    public void keyReleased(KeyEvent e) {
        destination.setText(source.getText());
    }

}
