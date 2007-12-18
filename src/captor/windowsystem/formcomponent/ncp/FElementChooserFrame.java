package captor.windowsystem.formcomponent.ncp;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.FormComponent;

/**
 * @author Kicho
 *
 */
public class FElementChooserFrame extends CaptorFrame implements ActionListener, ItemListener {
    
    public static final long serialVersionUID = 145;

    private FComponentPanel fep;
    
    private JComboBox combo;
    
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton plus, minus, help, edit;
    private Element element;
    
    //-------------------------------------------------------------------------
    
    public FElementChooserFrame(Model model, FComponentPanel fep, Element element) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.fep = fep;
        this.element = element;
        
        displayDataIfAny();
    }
    
    public FElementChooserFrame(Model model, FComponentPanel fep) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.fep = fep;
    }
    
    //-------------------------------------------------------------------------
    
    private void displayDataIfAny()  {
        for ( int i = 0; i < combo.getItemCount(); i++ )  {
            String classname = (String) combo.getItemAt(i);
            
            if ( classname == null && element.getClassname() != null )
                continue;
            
            if ( classname.trim().equals(element.getClassname()) )  {
                combo.setSelectedIndex(i);
                break;
            }
        }
        
        for ( int i = 0; i < element.getParameters().size(); i++ )  {
            Parameter p = (Parameter) element.getParameters().get(i);
            addParameter(p.getName(), p.getValue());
        }
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        setCenterSize(456, 373);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle(MyIntl.NCP_LABEL_FECHOOSER);
        addWindowListener(this);
        
        Dimension minSize = new Dimension(5, 10);
        Dimension prefSize = new Dimension(20, 80);
        Dimension prefSize2 = new Dimension(40, 80);
        Dimension maxSize = new Dimension(150, 300);
        
        //---------------
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        panel.add(comboPanel());
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        panel.add(parameterPanel());
        panel.add(new Box.Filler(minSize, prefSize2, maxSize));
        panel.add(footer());
        panel.add(new Box.Filler(minSize, prefSize, maxSize));
        
        this.add(panel);
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    private JPanel parameterPanel()  {
        
        String[] columnNames = {MyIntl.NCP_LABEL_NAME, MyIntl.NCP_LABEL_VALUE};
        String data[][] = {};
        
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        //---------------
        
        JLabel textLabel = new JLabel(MyIntl.NCP_LABEL_PARAMETERS);
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        plus = new JButton(MyIntl.NCP_LABEL_ADD);
        plus.addActionListener(this);
        minus = new JButton(MyIntl.NCP_LABEL_REMOVE);
        minus.addActionListener(this);
        edit = new JButton(MyIntl.NCP_LABEL_EDIT);
        edit.addActionListener(this);
        help = new JButton(MyIntl.NCP_LABEL_HELP);
        help.addActionListener(this);
        
        Dimension d = new Dimension(80,25);
        
        plus.setMinimumSize(d);
        plus.setMaximumSize(d);
        plus.setPreferredSize(d);
        
        minus.setMinimumSize(d);
        minus.setMaximumSize(d);
        minus.setPreferredSize(d);
        
        help.setMinimumSize(d);
        help.setMaximumSize(d);
        help.setPreferredSize(d);
        
        edit.setMinimumSize(d);
        edit.setMaximumSize(d);
        edit.setPreferredSize(d);
        
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(edit);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(help);
        bPanel.add(Box.createVerticalGlue());
        bPanel.add(new JLabel(" "));
        
        //---------------
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        panel.add(textLabel);
        panel.add(scrollPane);
        panel.add(new JLabel(" "));
        panel.add(bPanel);
        panel.add(Box.createRigidArea(new Dimension(10,0)));
        panel.setMinimumSize(new Dimension(200,240));
        
        //---------------
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel comboPanel()  {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel(MyIntl.NCP_LABEL_ELEMENT);
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Vector elements = FEUtil.getComboData(model);
        String choices[] = new String[elements.size()];
        for ( int i = 0; i < elements.size(); i++ )  {
            String s = (String) elements.get(i);
            if (  s!= null && !s.equals(""))  {
                choices[i] = (String) elements.get(i);
            }
        }
        
        combo = new JComboBox();
        combo.setEditable(true);
        for (int i=0;i<choices.length;i++) {
            combo.addItem (choices[i]);
        }
        
        combo.setPreferredSize(new Dimension(295,22));
        
        combo.addItemListener(this);
        
        
        JButton test = new JButton(MyIntl.NCP_LABEL_TEST);
        test.addActionListener(this);
        
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        panel.add(combo);
        panel.add(new JLabel(" "));
        panel.add(test);
        panel.add(Box.createHorizontalGlue());
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel footer()  {
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
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        
        if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_CANCEL) )  {
            this.setVisible(false);
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_ADD) )  {
            addAction();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_TEST) )  {
            testAction();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_EDIT) )  {
            editAction();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_REMOVE) )  {
            removeAction();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_HELP) )  {
            showHelpAction();
        }
        else if ( e.getActionCommand().equals(MyIntl.NCP_LABEL_OK) )  {
            okAction();
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void itemStateChanged(ItemEvent e)  {
        if ( this.isVisible() == false )
            return;
        
        String s = (String) combo.getSelectedItem();
        if ( e.getStateChange() == ItemEvent.SELECTED && !s.equals("") )  {
            updateParametersList();
        }
        
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    public void addParameter(String name, String value) {
        
        Vector data = tableModel.getDataVector();
        for ( int i = 0; i < data.size(); i++ )  {
            Vector rowData = (Vector) data.get(i);
            String mname = (String) rowData.get(0);
            String mvalue = (String) rowData.get(1);

            if ( mname.trim().equals(name.trim()) &&
                    mvalue.trim().equals(value.trim()))  {
                return;
            }
            
            if ( mname.trim().equals(name.trim()) &&
                    !mvalue.trim().equals(value.trim()))  {
                tableModel.setValueAt(value, i, 1);
                return;
            }
        }
        
        data = new Vector();
        data.add(name);
        data.add(value);
        tableModel.addRow(data);
    }
    
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    
    private void addAction()  {
        String classname = (String) combo.getSelectedItem();
        classname = classname.trim();
        
        if ( classname.equals("") )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG114);
            return;
        }
        
        ParameterSetterFrame ps = new ParameterSetterFrame(model, this);
        ps.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    private void showHelpAction()  {
        String fullname = (String) combo.getSelectedItem();
        if ( fullname == null )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG97);
            return;
        }
        
        fullname = fullname.trim();
        if ( fullname.equals("") )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG97);
            return;
        }
        
        FormComponent fe = FEUtil.getFormElementInstance(this, model, fullname);
        if ( fe == null )  {
            //the error was already sinalized by FEUtil (JOption dialog)
            return;
        }
        
        ShowParametersFrame spf = new ShowParametersFrame(model, this, fe.getRequiredParameters());
        spf.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    private void editAction()  {
        int index = table.getSelectedRow();
        if ( index < 0 )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG96);
            return;
        }
        
        Vector data = (Vector) tableModel.getDataVector().get(index);
        String name = (String) data.get(0);
        String value = (String) data.get(1);
        String classname = (String) combo.getSelectedItem();
        if ( isMandatory(classname, name) )  {
            ParameterSetterFrame ps = new ParameterSetterFrame(model, this, name, value, true);
            ps.setVisible(true);
        }
        else  {
            ParameterSetterFrame ps = new ParameterSetterFrame(model, this, name, value, true);
            ps.setVisible(true);
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void okAction()  {
        
        String classname = (String) combo.getSelectedItem();
        classname = classname.trim();
        
        //validation
        if ( classname.equals("") )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG98);
            return;
        }
        
        boolean create = false;
        if ( element == null )  {
            element = new Element(model);
            create = true;
        }
        
        //updating model based on widgets values
        if ( !element.getClassname().equals(classname) )  {
            element.setClassname(classname);
            model.getProject().setStatus(Project.UNSAVED);
        }
        
        Vector data = tableModel.getDataVector();
        boolean alreadyExists = false;
        for ( int i = 0; i < data.size(); i++ )  {
            Vector pdata = (Vector) data.get(i);
            String name = (String) pdata.get(0);
            String value = (String) pdata.get(1);
            alreadyExists = false;
            for ( int j = 0; j < element.getParameters().size(); j++ )  {
                Parameter ep = (Parameter) element.getParameters().get(j);
                if ( ep.getName().equals(name) )  {
                    alreadyExists = true;
                }
                
                if ( ep.getName().equals(name) && !ep.getValue().equals(value) )  {
                    ep.setValue(value);
                    model.getProject().setStatus(Project.UNSAVED);
                }
            }
            
            if ( !alreadyExists )  {
                Parameter p = new Parameter();
                p.setName(name);
                p.setValue(value);
                element.addParameter(p);
                model.getProject().setStatus(Project.UNSAVED);
            }
        }
        
        //removes the parameters that is no on the list
        for ( int j = 0; j < element.getParameters().size(); j++ )  {
            Parameter ep = (Parameter) element.getParameters().get(j);
            alreadyExists = false;
            for ( int i = 0; i < data.size(); i++ )  {
                Vector pdata = (Vector) data.get(i);
                String name = (String) pdata.get(0);
                if ( name.trim().equals(ep.getName().trim()) )
                    alreadyExists = true;
            }
            
            if ( !alreadyExists )  {
                element.removeParameterByName(ep.getName());
                model.getProject().setStatus(Project.UNSAVED);
            }
        }
        
        
        String errorDescription = element.validate(this);
        if ( errorDescription != null )  {
            JOptionPane.showMessageDialog(this, errorDescription);
            return;
        }
        
        //searching for unused parameters
        if ( hasUnusedParameters(element) != null )  {
            int res = JOptionPane.showConfirmDialog(this, MyIntl.MSG99 + hasUnusedParameters(element) + MyIntl.MSG100, MyIntl.MSG101, 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
            if ( res == JOptionPane.NO_OPTION )  {
                return;
            }
            
        }
        
        if ( create )
            model.getProject().setStatus(Project.UNSAVED);
        
        fep.addElement(element);
        this.setVisible(false);
    }
    
    //-------------------------------------------------------------------------
    
    private void removeAction()  {
        
        int index = table.getSelectedRow();
        if ( index < 0 )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG96);
            return;
        }
        //verificar se � mandatory
        Vector data = (Vector) tableModel.getDataVector().get(index);
        String name = (String) data.get(0);
        
        String classname = (String) combo.getSelectedItem();
        if ( !isMandatory(classname, name) )  {
            tableModel.removeRow(index);
            return;
        }
        
        JOptionPane.showMessageDialog(this, MyIntl.MSG102);
    }
    
    //-------------------------------------------------------------------------
    
    private void testAction()  {
        String classname = (String) combo.getSelectedItem();
        if ( classname.trim().equals("") )  {
            JOptionPane.showMessageDialog(this, "Choose a element in the select box first.");
            return;
        }
        
        ShowFormElementFrame sfef = new ShowFormElementFrame(model, this, classname, tableModel);
        if ( sfef.initialize() )
            sfef.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    private void updateParametersList()  {
        String classname = (String) combo.getSelectedItem();
        FormComponent fe = FEUtil.getFormElementInstance(this, model, classname);
        if ( fe == null )  {
            //the error is already sinalized by FEUtil
            return;
        }
        
        cleanTable();
        
        for ( int i = 0; i < fe.getRequiredParameters().size(); i++ )  {
            captor.windowsystem.formcomponent.Parameter p = 
                (captor.windowsystem.formcomponent.Parameter) fe.getRequiredParameters().get(i);
            
            if ( p.isRequired() )  {
                Vector data = new Vector();
                data.add(p.getName());
                data.add(p.getDefaultValue());
                tableModel.addRow(data);
            }
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void cleanTable()  {
        while ( tableModel.getRowCount() > 0 ) {
            tableModel.removeRow(0);
        }
    }
    
    //-------------------------------------------------------------------------
    
    private String hasUnusedParameters(Element element)  {
        
        StringBuffer sb = new StringBuffer();
        
        FormComponent fe = FEUtil.getFormElementInstance(this, model, element.getClassname());
        if ( fe == null )
            return null;
        
        Vector parameterName = new Vector();
        //getting all parameters name
        for ( int i = 0; i < fe.getRequiredParameters().size(); i++ )  {
            captor.windowsystem.formcomponent.Parameter p = (captor.windowsystem.formcomponent.Parameter) fe.getRequiredParameters().get(i);
            parameterName.add(p.getName());
        }
        
        for ( int i = 0; i < element.getParameters().size(); i++ )  {
            Parameter p = (Parameter) element.getParameters().get(i);
            if ( !contain(parameterName, p.getName()) )  {
                sb.append("    Parameter: " + p.getName() + "\n");
            }
        }
        
        if ( sb.toString().equals("") )
            return null;
        else
            return sb.toString();
    }
    
    //-------------------------------------------------------------------------
    
    private boolean contain(Vector v, String s)  {
        for ( int i = 0; i < v.size(); i++ )  {
            String aux = (String) v.get(i);
            if ( aux.equals(s) )
                return true;
        }
        return false;
    }
    
    //-------------------------------------------------------------------------
    
    private boolean isMandatory(String classname, String parameterName)  {
        if ( classname == null || parameterName == null )
            return false;
        
        FormComponent fe = FEUtil.getFormElementInstance(null, model, classname);
        if ( fe == null )  {
            return false;
        }
        
        for ( int i = 0; i < fe.getRequiredParameters().size(); i++ ) {
            captor.windowsystem.formcomponent.Parameter parameter = 
                (captor.windowsystem.formcomponent.Parameter) fe.getRequiredParameters().get(i);
            
            if ( parameter.getName().trim().equals(parameterName) 
                    && parameter.isRequired() )  {
                return true;
            }
        }         
        
        return false;
    }
    
    //-------------------------------------------------------------------------
}