package captor.windowsystem;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.preferences.LookFeelType;


/**@author Kicho
 * Janela que permite que o usu�rio configure as prefer�ncias de ferramenta
 */
public class PreferencesWindow extends CaptorFrame  {
    
    public static final long serialVersionUID = 50458;

    JPanel jPanelBodyBar, jPanelHeaderBar;
    JButton jButtonOK, jButtonCancel;
    
    JLabel installPathLabel, lookAndFeelLabel, headerTitle;
    JTextField installPathText;
    JComboBox lookAndFeelComboBox;

    public PreferencesWindow(Model model) {
        super(model, model.getGui().getCaptorWindow());
    }
    
    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        jPanelBodyBar = new JPanel();
        jPanelHeaderBar = new JPanel();
        
        jButtonOK = new JButton();
        jButtonCancel = new JButton();
        
        makeHeaderBar();
        makeBodyBar();
        makePane();
    }

    //-------------------------------------------------------------------------

    private void makePane()  {
        this.getContentPane().setLayout(null);
        this.setCenterSize(427, 492);
        this.setLocale(java.util.Locale.getDefault());
        this.setResizable(false);
        this.setState(Frame.NORMAL);
        this.setTitle(MyIntl.PREFERENCES_TITLE);
        this.addWindowListener(this);
        
        jButtonOK.setBounds(new Rectangle(223, 419, 80, 25));
        jButtonCancel.setBounds(new Rectangle(320, 419, 80, 25));

        jButtonOK.setText("OK");
        jButtonCancel.setText(MyIntl.PREFERENCES_CANCEL);
        
        jButtonOK.addActionListener(this);
        jButtonCancel.addActionListener(this);
        
        this.getContentPane().add(jPanelHeaderBar);
        this.getContentPane().add(jPanelBodyBar);
        this.getContentPane().add(jPanelHeaderBar);
        this.getContentPane().add(jButtonOK);
        this.getContentPane().add(jButtonCancel);
    }
    
    //-------------------------------------------------------------------------

    private void makeHeaderBar()  {
        jPanelHeaderBar.setBounds(new Rectangle(15, 10, 393, 45));
        jPanelHeaderBar.setBackground(UIManager.getColor("Button.shadow"));
        jPanelHeaderBar.setBorder(BorderFactory.createLoweredBevelBorder());
        
        jPanelHeaderBar.setLayout(null);

        headerTitle = new JLabel(MyIntl.PREFERENCES_GENERAL);
        headerTitle.setBounds(175,15, 150,13);
        
        jPanelHeaderBar.add(headerTitle);
    }    
    
    //-------------------------------------------------------------------------

    private void makeBodyBar()  {
        installPathLabel = new JLabel(MyIntl.PREFERENCES_INSTALL_PATH, JLabel.RIGHT);
        lookAndFeelLabel = new JLabel(MyIntl.PREFERENCES_LOOK_AND_FEEL, JLabel.RIGHT);
        
        installPathText = new JTextField();
        lookAndFeelComboBox = new JComboBox();

        UIManager.LookAndFeelInfo[] installed = UIManager.getInstalledLookAndFeels();
        for (int i = 0; i < installed.length; i++) {
            LookFeelType lft = new LookFeelType(installed[i].getName(), installed[i].getClassName());            
            lookAndFeelComboBox.addItem(lft);
        }        
        
        LookAndFeel lf = UIManager.getLookAndFeel();
        for ( int i = 0; i < lookAndFeelComboBox.getItemCount(); i++ )  {
            LookFeelType lft = (LookFeelType) lookAndFeelComboBox.getItemAt(i);
            if ( lft.getId().equals(lf.getClass().getName()) )
                lookAndFeelComboBox.setSelectedIndex(i);
        }
        
        lookAndFeelComboBox.addActionListener(this);
        String aux = model.getConfig().getSystemConfig().getInstallPath();
        installPathText.setText(aux);
        
        jPanelBodyBar.setBorder(BorderFactory.createEtchedBorder());
        jPanelBodyBar.setBounds(new Rectangle(15, 64, 393, 347));
        jPanelBodyBar.setLayout(null);

        installPathLabel.setBounds(new Rectangle(10, 25, 100, 20));
        installPathText.setBounds(new Rectangle(110, 25, 250, 20));
        
        lookAndFeelLabel.setBounds(new Rectangle(10, 65, 100, 20));
        lookAndFeelComboBox.setBounds(new Rectangle(110, 65, 250, 20));
        
        
        jPanelBodyBar.add(installPathLabel);
        jPanelBodyBar.add(lookAndFeelLabel);
        
        jPanelBodyBar.add(installPathText);
        jPanelBodyBar.add(lookAndFeelComboBox);
        
        installPathText.setEnabled(false);
    }    
    
    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("OK") )  {
            close();
        }
        else if ( e.getActionCommand().equals(MyIntl.PREFERENCES_CANCEL) )  {
            close();
        }
        else if ( e.getActionCommand().equals("comboBoxChanged") )  {
            setLookAndFeel();
        }
    }
    
    //-------------------------------------------------------------------------

    private void setLookAndFeel()  {
        try  {
            LookFeelType lft = (LookFeelType) lookAndFeelComboBox.getSelectedItem(); 
            model.getConfig().getGuiConfig().setLookAndFeel(lft.getId());
            UIManager.setLookAndFeel(lft.getId());
        } catch (Exception e1) {
            String msgError = "<font color=\"#FF0000\"><b>Cannot install Look and Feel.</b></font><br>" + StringUtil.formatOutput(e1.toString());
            model.getGui().getGuiView().setErrorView(msgError);
        }

        final JFrame root = model.getGui().getCaptorWindow();
	    try {
		UIManager.setLookAndFeel(model.getConfig().getGuiConfig().getLookAndFeel());
		SwingUtilities.invokeLater( new Runnable() {
		    public void run() { SwingUtilities.updateComponentTreeUI(root); }
		});
	    } catch (Exception e2) { 
            String msgError = "Cannot install Look and Feel.\n" + e2;
            model.getGui().getGuiView().setErrorView(msgError);
	    }
	    
	    final JFrame pref = this;
	    try {
		UIManager.setLookAndFeel(model.getConfig().getGuiConfig().getLookAndFeel());
		SwingUtilities.invokeLater( new Runnable() {
		    public void run() { SwingUtilities.updateComponentTreeUI(pref); }
		});
	    } catch (Exception e2) { 
            String msgError = "Cannot install Look and Feel.\n" + e2;
            model.getGui().getGuiView().setErrorView(msgError);
	    }
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