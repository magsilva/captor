package captor.windowsystem.formcomponent.ncp.fcomponentpanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.ncp.fcomponentpanel.bean.Element;
import captor.windowsystem.formcomponent.ncp.fcomponentpanel.bean.Parameter;
import captor.windowsystem.formcomponent.ncp.fcomponentpanel.util.FEUtil;

/**
 * @author Kicho
 *
 */
public class ShowFormElementFrame extends CaptorFrame implements ActionListener {
    
    public static final long serialVersionUID = 147;

    Element element;
    CaptorFrame owner;
    
    public ShowFormElementFrame(Model model, CaptorFrame owner, String classname, DefaultTableModel tableModel) {
        super(model, owner);
        this.model = model;
        
        this.element = new Element(model);
        this.element.setClassname(classname);
        
        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            Vector data = (Vector) tableModel.getDataVector().get(i);
            String name = (String) data.get(0);
            String value = (String) data.get(1);
            this.element.addParameter(new Parameter(name, value));
        }
        
        this.owner = owner;
    }
    
    //-------------------------------------------------------------------------
    
    public boolean initialize()  {
        
        //---------

        setCenterSize(800, 300);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle(MyIntl.NCP_LABEL_FE2);
        addWindowListener(this);
        
        //---------

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Dimension minSize = new Dimension(150, 30);
        Dimension prefSize = new Dimension(100, 300);
        Dimension maxSize = new Dimension(450, 380);
        
        //---------
        FormComponent fe = getFormComponent();
        if ( fe == null )
            return false;
        
        //---------

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        JButton okButton = new JButton(MyIntl.NCP_LABEL_OK);
        JButton cancelButton = new JButton(MyIntl.NCP_LABEL_CANCEL);
        
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
        
        return true;
    }
    
    protected void init() throws Exception {
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void dispose() {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_CANCEL) )  {
            this.setVisible(false);
        }
        else {
            this.setVisible(false);
        }
    }
    
    //-------------------------------------------------------------------------
    
    private FormComponent getFormComponent()  {
        FormComponent fe = null;
        try {
            fe = FEUtil.getFormElementInstance(owner, model, element.getClassname());
            if ( fe == null )  {
                //the error was already sinalized by FEUTil
                return null;
            }
            
            for(int i = 0; i < element.getParameters().size(); i++ ) {
                Parameter pt = (Parameter) element.getParameters().get(i);
                fe.setParameter(pt.getName(), pt.getValue());
            }   
            
            fe.parseParameters();
            
            if ( !fe.validateParameters() )  {
                JOptionPane.showMessageDialog(this, MyIntl.MSG105 + fe.getErrorMsg());
                return null;
            }
        }
        catch (Throwable e) {
            JOptionPane.showMessageDialog(this, MyIntl.MSG105 + e.toString());
            e.printStackTrace();
            return null;
        } 

        return fe;
    }
    
    //-------------------------------------------------------------------------
}
