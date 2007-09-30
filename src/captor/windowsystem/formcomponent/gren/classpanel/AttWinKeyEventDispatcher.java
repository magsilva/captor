package captor.windowsystem.formcomponent.gren.classpanel;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class AttWinKeyEventDispatcher implements KeyEventDispatcher {

    private JFrame window;
    
    public AttWinKeyEventDispatcher(JFrame window)  {
        super();
        this.window = window;
    }
    
    //-------------------------------------------------------------------------

    public boolean dispatchKeyEvent(KeyEvent e) {

        if ( e.getKeyCode() == 27 )  {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
            window.setVisible(false);
            window.dispose();
        }
        
        // If the key should not be dispatched to the
        // focused component, set discardEvent to true
        boolean discardEvent = false;
        return discardEvent;
    }
    
    //-------------------------------------------------------------------------
}

