package captor.windowsystem.util;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import captor.windowsystem.CaptorFrame;
import captor.windowsystem.MainWindow;


/**
 * This class listens for ESC pressed button in the captor frames (except the main frame).
 * 
 * <p>
 * If a user press a ESC button, the the frame will be invisible.
 * </p>
 * 
 * @author Kicho
 *
 */
public class MyKeyEventDispatcher implements KeyEventDispatcher {
    
    public MyKeyEventDispatcher()  {
    }
    
    //-------------------------------------------------------------------------
    
    public boolean dispatchKeyEvent(KeyEvent e) {
        
        if ( e.getKeyCode() == 0 )  {
            return false;
        }

        if ( e.getID() != KeyEvent.KEY_PRESSED )  {
            return false;
        }

        if ( e.getKeyCode() != 27 )  {
            return false;
        }
        
        if ( KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow() instanceof MainWindow )  {
            return false;
        }
        
        if ( e.getKeyCode() == 27 )  {
            if ( KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow() instanceof CaptorFrame )  {
                e.consume();
                CaptorFrame cf = (CaptorFrame) KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
                cf.close();
                return true;
            }
        }

        return false;
    }
    
    //-------------------------------------------------------------------------
}

