/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;


/**
 * @author Kicho
 *
 */
public class ParameterSetterFrame extends CaptorFrame implements ActionListener, KeyListener {
    
    public static final long serialVersionUID = 146;

    private FElementChooserFrame fec;
    JTextField nameTextField, valueTextField;
    
    //-------------------------------------------------------------------------

    public ParameterSetterFrame(Model model, FElementChooserFrame tfe) {
        super(model,tfe);
        this.model = model;
        this.fec = tfe;
    }
    
    public ParameterSetterFrame(Model model, FElementChooserFrame tfe, String name, String value, boolean mandatory) {
        super(model, tfe);
        this.model = model;
        this.fec = tfe;
        
        if ( mandatory )
            nameTextField.setEnabled(false);
        nameTextField.setText(name);
        valueTextField.setText(value);
    }

    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        setCenterSize(300, 150);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle(MyIntl.NCP_LABEL_FE2);
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
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel panel()  {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

        JLabel textLabel = new JLabel(MyIntl.NCP_LABEL_NAME2);
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        nameTextField = new JTextField();
        nameTextField.setSize(new Dimension(150,12));
        
        panel1.add(Box.createRigidArea(new Dimension(10,0)));
        panel1.add(textLabel);
        panel1.add(nameTextField);
        panel1.add(new JLabel("   "));
        panel1.add(Box.createHorizontalGlue());

        //-----------------
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        
        textLabel = new JLabel(MyIntl.NCP_LABEL_VALUE2);
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        valueTextField = new JTextField();
        valueTextField.setSize(new Dimension(150,12));
        
        panel2.add(Box.createRigidArea(new Dimension(10,0)));
        panel2.add(textLabel);
        panel2.add(valueTextField);
        panel2.add(new JLabel("   "));
        panel2.add(Box.createHorizontalGlue());

        //--------------
        nameTextField.addKeyListener(this);
        valueTextField.addKeyListener(this);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        panel3.add(panel1);
        panel3.add(new JLabel(" "));
        panel3.add(panel2);

        return panel3;
    }
    
    //-------------------------------------------------------------------------
    
    public JPanel footer()  {
        JButton okButton = new JButton(MyIntl.NCP_LABEL_OK);
        JButton cancelButton = new JButton(MyIntl.NCP_LABEL_CANCEL);
        
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
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_CANCEL) )  {
            cancel();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_OK) )  {
            ok();
        }
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    private void cancel()  {
        setVisible(false);
    }
    
    //-------------------------------------------------------------------------
    
    private void ok()  {
        String name = nameTextField.getText().trim();
        String value = valueTextField.getText().trim();
        
        if ( name.trim().equals("") )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG103);
            return;
        }
        if ( value.trim().equals("") )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG104);
            return;
        }
        
        fec.addParameter(name, value);
        setVisible(false);
    }

    //-------------------------------------------------------------------------
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {
        //enter
        if ( e.getKeyCode() == 10 )  {
            ok();
        }
    }
    
    //-------------------------------------------------------------------------
}
