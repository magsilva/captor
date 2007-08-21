/*
 *
 */
package captor.windowsystem.main.locationPane.util;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;


/**
 * @author Kicho
 *
 */
public class FormHelp extends CaptorFrame implements ActionListener {

    public static final long serialVersionUID = 157;

    JTextArea ta;
    JScrollPane scroll;
    JButton close;
    
    public FormHelp(Model model, String text) {
        super(model, model.getGui().getCaptorWindow());
        ta.setText(text);
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        this.setLayout(null);
        this.setTitle("Form help");
        setCenterSize(358,290);
        
        ta = new JTextArea();
        scroll = new JScrollPane(ta);
        close = new JButton("Close");
        
        int width = 320;
        int heigth = 200;
        
        ta.setBounds(new Rectangle(15, 15, width, heigth));
        scroll.setBounds(new Rectangle(15, 15, width, heigth));
        close.setBounds(new Rectangle(275, 225, 60, 25));
        close.addActionListener(this);
        

        this.getContentPane().add(scroll, null);
        this.getContentPane().add(close, null);
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        close();
    }

    //-------------------------------------------------------------------------

    protected void windowClosing2(WindowEvent e) {
        close();
    }
    
    public void dispose() {
        close();
    }
    
    //-------------------------------------------------------------------------
}
