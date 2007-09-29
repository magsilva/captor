/*
 *
 */
package captor.windowsystem.formcomponent.ncp.fcomponentpanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.util.MyKeyEventDispatcher;


/**
 * @author Kicho
 *
 */
public class ParameterSetter extends CaptorFrame implements ActionListener, KeyListener {
    
    private MyKeyEventDispatcher kev;
    private FElementChooser tfe;
    
    JTextField nameTextField, valueTextField;
    
    //-------------------------------------------------------------------------

    public ParameterSetter(Model model, FElementChooser tfe) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.tfe = tfe;
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        setCenterSize(300, 150);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle("Form element");
        addWindowListener(this);
        
        Dimension minSize = new Dimension(5, 10);
        
        Dimension prefSize = new Dimension(20, 350);
        
        Dimension prefSize2 = new Dimension(40, 80);
        
        Dimension maxSize = new Dimension(150, 400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        panel.add(panel());
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        panel.add(footer());
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        
        this.add(panel);
        
        kev = new MyKeyEventDispatcher(this);         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);        
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(kev);
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void dispose() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(kev);
        close();
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel panel()  {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

        JLabel textLabel = new JLabel("Name: ");
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        nameTextField = new JTextField();
        nameTextField.addKeyListener(this);
        nameTextField.setSize(new Dimension(150,12));
        
        panel1.add(Box.createRigidArea(new Dimension(10,0)));
        panel1.add(textLabel);
        panel1.add(nameTextField);
        panel1.add(new JLabel("   "));
        panel1.add(Box.createHorizontalGlue());

        //-----------------
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        
        textLabel = new JLabel("Value: ");
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        valueTextField = new JTextField();
        valueTextField.addKeyListener(this);
        valueTextField.setSize(new Dimension(150,12));
        
        panel2.add(Box.createRigidArea(new Dimension(10,0)));
        panel2.add(textLabel);
        panel2.add(valueTextField);
        panel2.add(new JLabel("   "));
        panel2.add(Box.createHorizontalGlue());

        //--------------
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        panel3.add(panel1);
        panel3.add(new JLabel(" "));
        panel3.add(panel2);

        return panel3;
    }
    
    //-------------------------------------------------------------------------
    
    public JPanel footer()  {
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(okButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));
        
        return buttonPanel;
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("Cancel") )  {
            this.setVisible(false);
        }
        else if ( e.getActionCommand().equals("OK") )  {
            String name = nameTextField.getText().trim();
            String value = valueTextField.getText().trim();
            
            if ( name.trim().equals("") )  {
            }
            if ( value.trim().equals("") )  {
            }
            
            tfe.addParameter(name, value);
            this.setVisible(false);
        }
    }
    
    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {}
    public void keyReleased(KeyEvent e) {
    	//model.getProject().setStatus(Project.UNSAVED);
    }

    //-------------------------------------------------------------------------
}
