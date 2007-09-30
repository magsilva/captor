package captor.windowsystem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.Vector;

import javax.swing.JFrame;

import captor.modelsystem.Model;

/**
 * This class is the parent class for all frames in the application.
 * It's provide some commom behavior to all frames.
 */
public abstract class CaptorFrame extends JFrame implements ActionListener, WindowListener, WindowStateListener {
    
    public static final long serialVersionUID = 1;

    protected Model model;
    protected CaptorFrame parentFrame;
    private static int mainWindowCount = 0;
    
    public CaptorFrame(Model model, CaptorFrame frame)  {
        this.parentFrame = frame;
        this.model = model;
        initialize();
    }

    public CaptorFrame(Model model)  {
       	this.model = model;
        this.parentFrame = null;
        mainWindowCount++;
       	initialize();
    }

    //-------------------------------------------------------------------------

    private void initialize()  {
        this.addWindowStateListener(this);
        this.addWindowListener(this);
        
        try {
            init();
            this.repaint();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //-------------------------------------------------------------------------

    public void setVisible(boolean b)  {
        
        if ( parentFrame == null )  {
            super.setVisible(b);
            return;
        }
        
        super.setVisible(b);

        //put all parents frames into the parents vector
        Vector parents = new Vector();
        if ( parentFrame != null )  {
            CaptorFrame cf = parentFrame;
            while ( cf != null )  {
                parents.add(cf);
                cf = cf.getFrame();
            }
        }
        
        //show background panels
        if ( !b && parentFrame != null )  {
            for ( int i = parents.size()-1; i >= 0; i-- )  {
                CaptorFrame cf = (CaptorFrame) parents.get(i);
                cf.toFront();
                cf.requestFocusInWindow();
            }
        }
        
        //enabling or disabling the parent window
        parentFrame.setEnabled(!b);
    }

    //-------------------------------------------------------------------------

    public void windowClosing(WindowEvent e) {
            windowClosing2(e);
    }
    
    //-------------------------------------------------------------------------

    public void close()  {
        setVisible(false);
        if ( parentFrame != null )
            parentFrame.setEnabled(true);
        super.dispose();
        
        
        if ( parentFrame == null )
            mainWindowCount--;
        
        if ( mainWindowCount == 0 && (parentFrame == null) )  {
            System.exit(0);
        }

    }

    //-------------------------------------------------------------------------

    protected abstract void init() throws Exception;
    protected abstract void windowClosing2(WindowEvent e);
    
    //-------------------------------------------------------------------------

    protected void setCenterSize(int width, int height)  {
        Dimension dim = this.getToolkit().getScreenSize();
        this.setBounds((dim.width - width) / 2, (dim.height - height) / 2 - 70, width, height);
    }

    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent event){}
    
    public void windowClosed(WindowEvent e)       {}
    public void windowOpened(WindowEvent e)       {}
    public void windowIconified(WindowEvent e)    {}
    public void windowDeiconified(WindowEvent e)  {}
    public void windowActivated(WindowEvent e)    {}
    public void windowDeactivated(WindowEvent e)  {}
    public void windowStateChanged(WindowEvent e) {}
    
    //-------------------------------------------------------------------------

    /**
     * @return Returns the frame.
     */
    public CaptorFrame getFrame() {
        return parentFrame;
    }

    //-------------------------------------------------------------------------
}
