package captor.windowsystem.formcomponent.ncp.fcomponentpanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import captor.domainsystem.ParameterType;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.util.MyKeyEventDispatcher;

/**
 * @author Kicho
 *
 */
public class TestFE extends CaptorFrame implements ActionListener {
    
    private MyKeyEventDispatcher kev;
    
    //-------------------------------------------------------------------------
    
    public TestFE(Model model) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public void initialize(String element, Vector parameters)  {
        
        //---------

        setCenterSize(800, 250);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle("Form element");
        addWindowListener(this);
        
        //---------

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Dimension minSize = new Dimension(150, 30);
        Dimension prefSize = new Dimension(100, 300);
        Dimension maxSize = new Dimension(450, 380);
        
        //---------
        boolean hasParameterError = false;
        FormComponent fe = null;
        try {
            Class cls = Class.forName(element);
            
            Class partypes[] = new Class[2];
            partypes[0] = model.getClass();
            partypes[1] = model.getGui().getTree().getModel().getRoot().getClass();
            Constructor ctor = cls.getConstructor(partypes);                 
            
            Object arglist[] = new Object[2];
            arglist[0] = model;
            arglist[1] = null;
            Object retobj = ctor.newInstance(arglist);
            fe = (FormComponent) retobj;
            
            for(int i = 0; i < parameters.size(); i++ ) {
                ParameterType pt = (ParameterType) parameters.get(i);
                fe.setParameter(pt.getName(), pt.getValue());
            }   
            
            fe.parseParameters();
            
            if ( !fe.validateParameters() )  {
                JOptionPane.showMessageDialog(this, "         Error - There are missing required parameters.\nCorrection - Put the required missing parameres in the parameres list.\n\n           Tip -  See individual form component documentation for required parameters details.\n");
                hasParameterError = true;
            }
        }
        catch (Throwable e) {
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(e.toString()));
            model.getGui().getGuiView().setErrorView("<b>Use the meta-model validator to see details.</b><br><br>");
            e.printStackTrace();
        } 
        
        JScrollPane scrollPane = new JScrollPane(fe);
        
        //---------

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(okButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(12,20)));

        //---------
        
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        panel.add(fe);
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        panel.add(buttonPanel);
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        
        this.add(panel);
        
        kev = new MyKeyEventDispatcher(this);         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);        
    }
    
    protected void init() throws Exception {
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
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("Cancel") )  {
            this.setVisible(false);
        }
        else {
            this.setVisible(false);
        }
    }
    
    //-------------------------------------------------------------------------
}
