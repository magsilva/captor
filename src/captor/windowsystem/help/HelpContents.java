package captor.windowsystem.help;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

import javax.help.DefaultHelpModel;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.JHelp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;

/**
 * This class implements a Help window with java help processing.
 * 
 * @author Kicho
 *
 */
public class HelpContents implements ActionListener  { 
    
    private JHelp jh = null;
    private JFrame frame;
    private Model model;
    
    public HelpContents(Model model)  {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        ClassLoader cl;
        HelpSet hs = null;
        
        URL x[] = parseURLs();
        cl = new URLClassLoader(x);
        
        String name = "jhelpset.hs";
        URL url = HelpSet.findHelpSet(cl, name);
        if (url == null) {
            JOptionPane.showMessageDialog(null , MyIntl.MSG70, MyIntl.MSG71, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            hs = new HelpSet(cl, url);
        } catch (HelpSetException ex) {
            
            JOptionPane.showMessageDialog(null , StringUtil.formatMessage(MyIntl.MSG72, url.toString()) , MyIntl.MSG71, JOptionPane.ERROR_MESSAGE);
        }
        
        if (jh == null) {
            jh = new JHelp(hs);
        } else {
            jh.setHelpSetPresentation(hs.getDefaultPresentation());
            DefaultHelpModel m = new DefaultHelpModel(hs);
            jh.setModel(m);
        }
        
        createFrame (hs.getTitle());
        launch();
    }        
    
    //-------------------------------------------------------------------------
    
    protected void launch() {
        if (frame == null) return;
        frame.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    protected JFrame createFrame(String title) {
        if (jh == null) return null;
        
        if (frame == null) {
            frame = new JFrame(title);
            
            //centralizando o frame no meio
            int width = 400;
            int height = 350;
            frame.setBounds(100,50, width, height);
            
            frame.setForeground(Color.black);
            frame.setBackground(Color.lightGray);
            frame.getContentPane().add(jh);	// the JH panel
        } 
        frame.pack();
        
        return frame;
    }
    
    //-------------------------------------------------------------------------

    private URL[] parseURLs() {
        
        String path = "file:"; 
        path = path.concat(model.getConfig().getSystemConfig().getInstallPath());
        path = path.concat(File.separator);
        path = path.concat("help");
        path = path.concat(File.separator);
        path = path.concat("output");
        
        Vector v = new Vector();
        try {
            URL url = new URL(path);
            v.addElement(url);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null , StringUtil.formatMessage(MyIntl.MSG73, path), MyIntl.MSG71, JOptionPane.ERROR_MESSAGE);
        }
        URL back[] = new URL[v.size()];
        v.copyInto(back);
        return back;
    }

    //-------------------------------------------------------------------------
}
