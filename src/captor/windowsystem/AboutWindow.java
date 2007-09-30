package captor.windowsystem;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class AboutWindow extends CaptorFrame implements ActionListener, WindowListener {

    public static final long serialVersionUID = 10258;

    JPanel jPanelBodyBar;
    JPanel jPanelHeaderBar;
    JButton jButtonOK;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JLabel jLabel9;
    JLabel jLabel10;
    
    public AboutWindow(Model model) {
        super(model, model.getGui().getCaptorWindow());
    }
    
    //-------------------------------------------------------------------------
    
    public void init() {
        jPanelBodyBar = new JPanel();
        jPanelHeaderBar = new JPanel();
        
        jButtonOK = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        
        jPanelBodyBar.setForeground(new Color(76, 208, 42));
        jPanelBodyBar.setBorder(BorderFactory.createEtchedBorder());
        
        jPanelHeaderBar.setBounds(new Rectangle(15, 7, 403, 45));
        jPanelBodyBar.setBounds(new Rectangle(15, 58, 403, 305));
        jPanelBodyBar.setLayout(null);
        
        this.getContentPane().setLayout(null);
        this.setBounds(294, 160, 436, 410);
        this.setLocale(java.util.Locale.getDefault());
        this.setResizable(false);
        this.setState(Frame.NORMAL);
        this.setTitle("About Captor");
        
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(this);
        
        jLabel1.setBounds(new Rectangle(20,  28,  274, 18));
        jLabel2.setBounds(new Rectangle(20,  95,  90,  15));
        jLabel3.setBounds(new Rectangle(47,  120, 331, 15));
        jLabel4.setBounds(new Rectangle(47,  140, 339, 15));
        jLabel5.setBounds(new Rectangle(47,  160, 341, 15));
        jLabel6.setBounds(new Rectangle(111, 180, 155, 15));
        jLabel7.setBounds(new Rectangle(47,  180, 66,  15));
        jLabel8.setBounds(new Rectangle(33,  54,  357, 15));
        
        jLabel9.setBounds(new Rectangle(20,  215,  90,  15));
        jLabel10.setBounds(new Rectangle(47,  235,  331,  15));
        
        jButtonOK.setBounds(new Rectangle(300, 265, 80, 30));
        
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
        jLabel1.setForeground(SystemColor.textHighlight);
        jLabel1.setText("Captor");
        //      jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
        //      jLabel2.setText("Developers:");
        //      jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
        //      jLabel3.setText("Edison Kicho Shimabukuro Junior");
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
        jLabel4.setText("Instituto de Ciências Matemáticas e de Computação ");
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
        jLabel5.setText("Universidade de São Paulo - Campus: São Carlos / 2005");
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel6.setForeground(new Color(0, 166, 111));
        jLabel6.setText("plb.generator@gmail.com");
        jLabel6.setText("edison.kicho@gmail.com");
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
        jLabel7.setText("Contact:");
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel8.setText("A customizable application generator.");
        
        //      jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
        //      jLabel9.setText("Collaborators:");
        //      jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
        //      jLabel10.setText("Rosana T. Vaccare Braga");
        //      jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
        
        
        Color c = SystemColor.textHighlight;
        c.brighter();
        jPanelHeaderBar.setBackground(c);
        
        jPanelHeaderBar.setLayout(null);
        JLabel headerTitle = new JLabel("About");
        headerTitle.setBounds(175,15, 150,13);
        headerTitle.setFont(new java.awt.Font("Dialog", 1, 16));
        
        jPanelHeaderBar.add(headerTitle);
        
        this.getContentPane().add(jPanelHeaderBar, null);
        this.getContentPane().add(jPanelBodyBar, null);
        
        jPanelBodyBar.add(jLabel1, null);
        jPanelBodyBar.add(jLabel3, null);
        jPanelBodyBar.add(jLabel4, null);
        jPanelBodyBar.add(jLabel5, null);
        jPanelBodyBar.add(jLabel2, null);
        jPanelBodyBar.add(jLabel7, null);
        jPanelBodyBar.add(jLabel8, null);
        jPanelBodyBar.add(jLabel6, null);
        jPanelBodyBar.add(jLabel9, null);
        jPanelBodyBar.add(jLabel10, null);
        jPanelBodyBar.add(jButtonOK, null);
        
        addWindowListener(this);
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e) {
        close();
    }
    
    protected void windowClosing2(WindowEvent e) {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosed(WindowEvent e)       {}
    public void windowOpened(WindowEvent e)       {}
    public void windowIconified(WindowEvent e)    {}
    public void windowDeiconified(WindowEvent e)  {}
    public void windowActivated(WindowEvent e)    {}
    public void windowDeactivated(WindowEvent e)  {}
    public void windowStateChanged(WindowEvent e) {}
    
    //-------------------------------------------------------------------------
}
