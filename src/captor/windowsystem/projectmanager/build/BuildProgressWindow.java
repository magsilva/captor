package captor.windowsystem.projectmanager.build;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;

import captor.lib.intl.MyIntl;
import captor.modelsystem.GUI;
import captor.modelsystem.Model;
import captor.projectsystem.util.LongTask;
import captor.windowsystem.MainWindow;


public class BuildProgressWindow extends JFrame implements ActionListener, WindowListener, WindowStateListener {
    public static final long serialVersionUID = 129;

    public final static int ONE_SECOND = 10;

    private LongTask task; 
    private Timer timer;
    private Model model;
    
    JProgressBar progressBar;
    JTextArea taskOutput;
    
    public BuildProgressWindow(LongTask task, Model model) {
        super();
        
        this.task = task;
        this.model = model;
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setTitle(MyIntl.PROJECT_BUILD_PROGRESS);
        this.setResizable(true);
        this.setCenterSize(280, 124);
        this.setAlwaysOnTop(true);
        this.addWindowListener(this);

        progressBar = new JProgressBar(0, 280);
        progressBar.setBounds(new Rectangle(20,10, 250, 15));
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setString("");          //but don't paint it
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(progressBar);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        add(panel);
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel();
        label.setText(MyIntl.PROJECT_BUILD_PWAIT);
        label.setFont(new java.awt.Font("Dialog", 1, 11));
        
        JButton cancel = new JButton(MyIntl.PROJECT_BUILD_CANCEL);
        cancel.addActionListener(this);
        
        panel.add(new JLabel("      "));
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        panel.add(cancel);
        panel.add(new JLabel("       "));
        
        add(panel);
        add(new JLabel(" "));
        
        model.getGui().setBuildWindow(this);
    }

    //-------------------------------------------------------------------------

    protected void setCenterSize(int width, int height)  {
        Dimension dim = this.getToolkit().getScreenSize();
        this.setBounds((dim.width - width) / 2, (dim.height - height) / 2 - 70, width, height);
    }

    //-------------------------------------------------------------------------
    
    public void play()  {
        GUI gui = model.getGui();
        MainWindow mw = gui.getCaptorWindow();
        mw.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        progressBar.setIndeterminate(true);

        timer = new Timer(ONE_SECOND, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        
        if ( e!=null && e.getActionCommand() != null && e.getActionCommand().equals(MyIntl.PROJECT_BUILD_CANCEL) )  {
            model.getGui().setBuildWindow(null);
          	task.setCancelled(true);
            exit2();
        }
        else if ( task.isDone() )  {
            timer.stop();
            this.setVisible(false);
            this.dispose();
            model.getGui().getCaptorWindow().toFront();
            
            if ( !task.hasError() )
                JOptionPane.showMessageDialog(this, MyIntl.MSG90);
            
            model.getGui().setBuildWindow(null);
            model.getGui().getCaptorWindow().setEnabled(true);
            model.getGui().getCaptorWindow().toFront();
        }
    }
    
    //-------------------------------------------------------------------------

    public void windowClosed(WindowEvent e)       {}
    public void windowOpened(WindowEvent e)       {}
    public void windowIconified(WindowEvent e)    {}
    public void windowDeiconified(WindowEvent e)  {}
    public void windowActivated(WindowEvent e)    {}
    public void windowDeactivated(WindowEvent e)  {}
    public void windowStateChanged(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        exit2();
    }

    //-------------------------------------------------------------------------
    
    private void exit2()  {
        this.setVisible(false);
        task.setError(true);
      	task.setDone(true);
        model.getGui().getCaptorWindow().setEnabled(true);
        model.getGui().getCaptorWindow().toFront();
        JOptionPane.showMessageDialog(this, MyIntl.MSG91);
        model.getGui().setBuildWindow(null);
    }
    
    //-------------------------------------------------------------------------
}
