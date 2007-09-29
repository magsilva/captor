package captor.windowsystem.formcomponent.ncp.nextpatternspanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.util.MyKeyEventDispatcher;


/**
 * @author Kicho
 *
 */
public class NextFormPanel extends CaptorFrame implements ActionListener {

    private MyKeyEventDispatcher kev;
    private JTextField idTextField;
    private JComboBox combo;
    private NextFormsPanel npp;
    
    public NextFormPanel(Model model, NextFormsPanel npp) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.npp = npp;
    }
    
    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        
        setLayout(new BorderLayout());
        setCenterSize(230, 180);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle("Next pattern");
        addWindowListener(this);
        
        this.getContentPane().add(header(), BorderLayout.PAGE_START);
        this.getContentPane().add(body(), BorderLayout.CENTER);

        kev = new MyKeyEventDispatcher(this);         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);        
    }
    
    //-------------------------------------------------------------------------

    public void windowClosing2(WindowEvent e) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(kev);
        close();
    }
    
    public void dispose() {
    	KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(kev);
        close();
    }

    //-------------------------------------------------------------------------
    
    private JPanel header()  {
        JPanel panel = new JPanel();
        panel.add(new JLabel(" "));
    
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel body()  {
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel("Id:");
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        idTextField = new JTextField();
        idTextField.setSize(new Dimension(5,12));
        idTextField.addActionListener(this);
        
        idPanel.add(label);
        idPanel.add(idTextField);
        idPanel.add(Box.createRigidArea(new Dimension(100,20)));

        JPanel multiplicityPanel = new JPanel();
        multiplicityPanel.setLayout(new BoxLayout(multiplicityPanel, BoxLayout.X_AXIS));
        
        label = new JLabel("Multiplicity:");
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        String choices[] = {"1", "2", "3","5", "10", "N"};
        combo = new JComboBox();
        combo.setEditable(true);
        for (int i=0;i<choices.length;i++) {
          combo.addItem (choices[i]);
        }
        
        combo.setPreferredSize(new Dimension(118,22));
        
        multiplicityPanel.add(label);
        multiplicityPanel.add(combo);
        multiplicityPanel.add(Box.createHorizontalGlue());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        label = new JLabel(" ");
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        buttonPanel.add(label);
        buttonPanel.add(okButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalGlue());

        //-----------
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(idPanel);
        panel.add(Box.createRigidArea(new Dimension(5,20)));
        panel.add(multiplicityPanel);
        panel.add(Box.createRigidArea(new Dimension(5,20)));
        panel.add(buttonPanel);
        panel.add(Box.createRigidArea(new Dimension(5,20)));
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        
        if ( e.getActionCommand().equals("Cancel") )  {
            this.setVisible(false);
        }
        else {
            ok();
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void ok()  {
        if ( idTextField.getText().trim().equals("") )  {
            JOptionPane.showMessageDialog(this, "Error.\nThe id field is blank.");
            return;
        }

       	String regexp = "[(0-9)]+";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(idTextField.getText().trim());
        
	        if ( !m.matches() )  {
            JOptionPane.showMessageDialog(this, "The id field doesn't match the regular expression: " + regexp + ".");
	            return;
	        }
        
	        //validar o combo
	        String multiplicity = (String)combo.getSelectedItem();
	        
	        try {
            Integer i = new Integer(multiplicity);
        } catch (NumberFormatException e1) {
            if ( !multiplicity.toUpperCase().equals("N") && !multiplicity.toUpperCase().equals("*") )  {
                JOptionPane.showMessageDialog(this, "The multiplicity value must be a number or the string 'N'.");
   	            return;
            }
        }
	     
        //armazenar os dados no bean
	        npp.add(idTextField.getText().trim(), multiplicity);
	        
        this.setVisible(false);
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-------------------------------------------------------------------------
}
