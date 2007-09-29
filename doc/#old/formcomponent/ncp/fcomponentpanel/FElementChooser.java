package captor.windowsystem.formcomponent.ncp.fcomponentpanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
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

import captor.domainsystem.ParameterType;
import captor.domainsystem.impl.ParameterTypeImpl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.util.MyKeyEventDispatcher;

/**
 * @author Kicho
 *
 */
public class FElementChooser extends CaptorFrame implements ActionListener {
    
    private MyKeyEventDispatcher kev;
    private JComboBox combo;
    private FComponentPanel fep;
    private Properties applicationProps;
    
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton plus, minus;
    
    //-------------------------------------------------------------------------
    
    public FElementChooser(Model model, FComponentPanel fep) {
        super(model, model.getGui().getCaptorWindow());
        this.model = model;
        this.fep = fep;
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        setCenterSize(450, 215);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle("Form element");
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

        //---------------

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
    
    private JPanel parameterPanel()  {
        
        String[] columnNames = {"name", "value"};
        String data[][] = {{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
                {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
                {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
                {"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""}};
        
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(100, 50));
        
        //---------------

        JLabel textLabel = new JLabel("Parameters: ");
        textLabel.setPreferredSize(new Dimension(80,12));
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        plus = new JButton("+");
        plus.addActionListener(this);
        minus = new JButton("-");
        minus.addActionListener(this);
        
        Dimension d = new Dimension(45,30);
        
        plus.setPreferredSize(d);
        minus.setPreferredSize(d);
        plus.setMinimumSize(d);
        minus.setMinimumSize(d);
        plus.setMaximumSize(d);
        minus.setMaximumSize(d);
        
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(plus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        bPanel.add(minus);
        bPanel.add(Box.createRigidArea(new Dimension(5,5)));
        
        //---------------

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        panel.add(textLabel);
        panel.add(scrollPane);
        panel.add(new JLabel(" "));
        panel.add(bPanel);
        panel.add(Box.createRigidArea(new Dimension(10,0)));
        
        //---------------

        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel comboPanel()  {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel("Element:");
        label.setPreferredSize(new Dimension(70,12));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Vector elements = load();
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
        JButton test = new JButton("Test");
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
        else if ( e.getActionCommand().equals("Test") )  {
            test();
        }
        else if ( e.getActionCommand().equals("+") )  {
            ParameterSetter ps = new ParameterSetter(model, this);
            ps.setVisible(true);
        }
        else if ( e.getActionCommand().equals("-") )  {
            int [] rrows = table.getSelectedRows();
            for ( int i = 0; i < rrows.length; i++ )  {
                tableModel.removeRow(rrows[i]);
            }
        }
        else {
            ok();
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void test()  {
        //get the parameter list
        Vector parameterList = getParameterList();
        
        if ( !validateParameters(parameterList) )
            return;
        
        TestFE tfe = new TestFE(model);
        tfe.initialize(combo.getSelectedItem().toString(), parameterList);
        tfe.setVisible(true);
    }
    
    //-------------------------------------------------------------------------
    
    private void ok()  {
        if ( validateParameters(getParameterList()) )  {
	        fep.addParameter(this);
	        this.setVisible(false);
	        model.getProject().setStatus(Project.UNSAVED);
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void addParameter(String name, String value) {
        int wrow = 0;
        
        Vector vmodel = tableModel.getDataVector();
        for ( int i = 0; i < vmodel.size(); i++ )  {
            Vector vdata = (Vector) vmodel.get(i);
            String s = (String) vdata.get(0);
            if ( s.equals("") )  {
                wrow = i;
                break;
            }
        }
        
        Vector v = new Vector();
        v.add(name);
        v.add(value);
        tableModel.insertRow(wrow, v);
    }
    
    //-------------------------------------------------------------------------
    
    public Vector load() {
        
        String separator = System.getProperty("file.separator");
        String path = model.getConfig().getSystemConfig().getInstallPath();
        path = path.concat(separator);
        path = path.concat("config");
        path = path.concat(separator);
        path = path.concat("formelements");
        path = path.concat(separator);
        
        String defaultPath = path.concat("formelements.properties.default");
        String mainPath = path.concat("formelements.properties");
        
        Properties defaultProps;
        try  {
            defaultProps = new Properties();
            FileInputStream in = new FileInputStream(defaultPath);
            defaultProps.load(in);
            in.close();        
            applicationProps = new Properties(defaultProps);
            
            File file = new File(mainPath);
            if ( !file.exists() )  {
                applicationProps = defaultProps;
            }
            else  {
                in = new FileInputStream(mainPath);
                applicationProps.load(in);
                in.close();
            }
        }
        catch(Exception e)  {
            String errorMsg = "<font color=\"#FF0000\"><b>Exception: Cannot open properties files.</b></font><br>Check if the file " + mainPath + " exists.";
            model.getGui().getGuiView().setErrorView(errorMsg);
            return new Vector();
        }
        
        Vector elements = new Vector();
        elements.add(applicationProps.getProperty("el0"));
        elements.add(applicationProps.getProperty("el1"));
        elements.add(applicationProps.getProperty("el2"));
        elements.add(applicationProps.getProperty("el3"));
        elements.add(applicationProps.getProperty("el4"));
        elements.add(applicationProps.getProperty("el5"));
        elements.add(applicationProps.getProperty("el6"));
        elements.add(applicationProps.getProperty("el7"));
        elements.add(applicationProps.getProperty("el8"));
        elements.add(applicationProps.getProperty("el9"));
        
        elements.add(applicationProps.getProperty("el10"));
        elements.add(applicationProps.getProperty("el11"));
        elements.add(applicationProps.getProperty("el12"));
        elements.add(applicationProps.getProperty("el13"));
        elements.add(applicationProps.getProperty("el14"));
        elements.add(applicationProps.getProperty("el15"));
        elements.add(applicationProps.getProperty("el16"));
        elements.add(applicationProps.getProperty("el17"));
        elements.add(applicationProps.getProperty("el18"));
        elements.add(applicationProps.getProperty("el19"));
        
        elements.add(applicationProps.getProperty("el20"));
        elements.add(applicationProps.getProperty("el21"));
        elements.add(applicationProps.getProperty("el22"));
        elements.add(applicationProps.getProperty("el23"));
        elements.add(applicationProps.getProperty("el24"));
        elements.add(applicationProps.getProperty("el25"));
        elements.add(applicationProps.getProperty("el26"));
        elements.add(applicationProps.getProperty("el27"));
        elements.add(applicationProps.getProperty("el28"));
        elements.add(applicationProps.getProperty("el29"));
        
        elements.add(applicationProps.getProperty("el30"));
        elements.add(applicationProps.getProperty("el31"));
        elements.add(applicationProps.getProperty("el32"));
        elements.add(applicationProps.getProperty("el33"));
        elements.add(applicationProps.getProperty("el34"));
        elements.add(applicationProps.getProperty("el35"));
        elements.add(applicationProps.getProperty("el36"));
        elements.add(applicationProps.getProperty("el37"));
        elements.add(applicationProps.getProperty("el38"));
        elements.add(applicationProps.getProperty("el39"));
        
        elements.add(applicationProps.getProperty("el40"));
        elements.add(applicationProps.getProperty("el41"));
        elements.add(applicationProps.getProperty("el42"));
        elements.add(applicationProps.getProperty("el43"));
        elements.add(applicationProps.getProperty("el44"));
        elements.add(applicationProps.getProperty("el45"));
        elements.add(applicationProps.getProperty("el46"));
        elements.add(applicationProps.getProperty("el47"));
        elements.add(applicationProps.getProperty("el48"));
        elements.add(applicationProps.getProperty("el49"));
        
        Vector v = new Vector();
        for ( int i = 0; i < elements.size(); i++ )  {
            String s = (String) elements.get(i);
            if ( s!= null && !s.equals("") )
                v.add(s);
        }
        
        return v;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        return (String) combo.getSelectedItem();
    }
    
    //-------------------------------------------------------------------------
    
    public void toXML(CCBuffer out)  {
        
        out.newLine();
        out.ident();
        out.appendln("<formComponent>");
        out.ident();
        
        out.append("<fullname>");
        out.append((String) combo.getSelectedItem(), true);
        out.appendln("</fullname>", true);
        
        if ( tableModel.getDataVector().size() > 0 )  {
            out.appendln("<parameters>");
            out.ident();
            
            Vector vmodel = tableModel.getDataVector();
            for ( int i = 0; i < vmodel.size(); i++ )  {
                Vector vdata = (Vector) vmodel.get(i);
                String name = (String) vdata.get(0);
                String value = (String) vdata.get(1);
                
                if ( name.equals("") )
                    continue;
                
                out.appendln("<parameter>");
                
                out.ident();
                out.append("<name>");
                out.append(name, true);
                out.appendln("</name>", true);
                
                out.append("<value>");
                out.append(value, true);
                out.appendln("</value>", true);
                
                out.dident();
                out.appendln("</parameter>");
            }
            
            out.dident();
            out.appendln("</parameters>");

            out.dident();
            out.appendln("</formComponent>");
            out.dident();
        }        
    }
    
    //-------------------------------------------------------------------------
    
    public void setFullName(String s)  {
        int count = combo.getItemCount();
        for ( int i = 0; i < count; i++ )  {
            String item = (String) combo.getItemAt(i);
            if ( s.trim().equals(item.trim()) )  {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
    
    //-------------------------------------------------------------------------

    public void setParameters(Vector v)  {
        for ( int i = 0; i < v.size(); i++ )  {
            ParameterType pt = (ParameterType) v.get(i);
            addParameter(pt.getName(), pt.getValue());
        }
    }
    
    //-------------------------------------------------------------------------

    public String validateFields()  {

        String fullname = (String) combo.getSelectedItem(); 
        Vector parameters = new Vector();
        
        if ( tableModel.getDataVector().size() > 0 )  {
            
            Vector vmodel = tableModel.getDataVector();
            for ( int i = 0; i < vmodel.size(); i++ )  {
                Vector vdata = (Vector) vmodel.get(i);
                String name = (String) vdata.get(0);
                String value = (String) vdata.get(1);
                
                Vector parData = new Vector();
                parData.add(name);
                parData.add(value);
                
                parameters.add(parData);
                
            }
            
            FormComponent fe = getFormElementInstance(fullname);
            if ( fe == null )
                return "Cannot instantiate formElement " + fullname;
            
            for ( int i = 0; i < parameters.size(); i++ )  {
                Vector parameter = (Vector) parameters.get(i);
                String name = (String) parameter.get(0);
                String value = (String) parameter.get(1);
                fe.setParameter(name, value);
            }
            
            if (!fe.validateParameters() )  {
                StringBuffer  sb = new StringBuffer();
                sb.append("<b>Error :</b> formComponent validation error.<br>");
                sb.append("<b>Source error:</b> There are missing formComponent parameters in the form component: \"" + fullname + "\".<br>");
                sb.append("FormComponent parameters list:<br><br>");
                for ( int j = 0; j < fe.getRequiredParameters().size(); j++ )  {
                    String aux = (String) fe.getRequiredParameters().get(j);
                    sb.append("                 - " + fe.getRequiredParameters().get(j) + "<br>");
                }

                sb.append("<br>Correction: Put the required missing parameters in the formComponent: \"" + fullname + "\" in the form indicated above.<br>");

                return sb.toString();
            }        
        }
        

        //return null if ok
        return null;
    }

    private FormComponent getFormElementInstance(String className)  {
        Class cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 1.\n\n");
            model.getGui().getGuiView().setErrorView(e.toString());
            return null;
        }
        
        
        Class partypes[] = new Class[2];
        partypes[0] = model.getClass();
        partypes[1] = model.getGui().getTree().getModel().getRoot().getClass();
        Constructor ctor;
        
        try {
            ctor = cls.getConstructor(partypes);
        } catch (SecurityException e1) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 2.\n\n");
            model.getGui().getGuiView().setErrorView(e1.toString());
            return null;
        } catch (NoSuchMethodException e1) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 3.\n\n");
            model.getGui().getGuiView().setErrorView(e1.toString());
            return null;
        }
        
        Object arglist[] = new Object[2];
        arglist[0] = model;
        arglist[1] = null;
        Object retobj;
        
        try {
            retobj = ctor.newInstance(arglist);
        } catch (IllegalArgumentException e4) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 4.\n\n");
            model.getGui().getGuiView().setErrorView(e4.toString());
            return null;
        } catch (InstantiationException e4) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 5.\n\n");
            model.getGui().getGuiView().setErrorView(e4.toString());
            return null;
        } catch (IllegalAccessException e4) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 6.\n\n");
            model.getGui().getGuiView().setErrorView(e4.toString());
            return null;
        } catch (InvocationTargetException e4) {
            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 7.\n\n");
            model.getGui().getGuiView().setErrorView(e4.toString());
            return null;
        }
        
        return (FormComponent) retobj;
   
    }
    
    //-------------------------------------------------------------------------
    
    public FElementChooser getCopy(FComponentPanel fep)  {
        FElementChooser fec = new FElementChooser(model, fep);
        
        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            String name = (String) tableModel.getValueAt(i, 0);
            String value = (String) tableModel.getValueAt(i, 1);
            fec.addParameter(name, value);
            fec.setFullName(combo.getSelectedItem().toString());
        }        
        return fec;
    }
    
    //-------------------------------------------------------------------------
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    //-------------------------------------------------------------------------
    
    public boolean validateParameters(Vector parameterList)  {

        try {
            Class cls = Class.forName(combo.getSelectedItem().toString());
            
            Class partypes[] = new Class[2];
            partypes[0] = model.getClass();
            partypes[1] = model.getGui().getTree().getModel().getRoot().getClass();
            Constructor ctor = cls.getConstructor(partypes);                 
            
            Object arglist[] = new Object[2];
            arglist[0] = model;
            arglist[1] = null;
            Object retobj = ctor.newInstance(arglist);
            FormComponent fe = (FormComponent) retobj;
            
            for(int i = 0; i < parameterList.size(); i++ ) {
                ParameterType pt = (ParameterType) parameterList.get(i);
                fe.setParameter(pt.getName(), pt.getValue());
            }   
            
            fe.parseParameters();
            
            if ( !fe.validateParameters() )  {
                StringBuffer sb = new StringBuffer();
                sb.append("         Error - There are missing 'required' parameters in the form component parameter list.\n");
                sb.append("Correction - Put the missing 'required' parameres in the parameres list.\n\n");
                sb.append("            Tip -  See individual form component documentation for required parameters details.\n\n");
                
                sb.append("FormComponent parameters list:\n\n");
                for ( int j = 0; j < fe.getRequiredParameters().size(); j++ )  {
                    String aux = (String) fe.getRequiredParameters().get(j);
                    sb.append("  - " + fe.getRequiredParameters().get(j) + "\n");
                }

                JOptionPane.showMessageDialog(this, sb.toString());
                return false;
            }
        }
        catch (Throwable e) {
            JOptionPane.showMessageDialog(this, "Cannot instantiate class: " + combo.getSelectedItem().toString());
            model.getGui().getGuiView().setErrorView(e.toString());
            return false;
        } 
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    private Vector getParameterList()  {
        Vector parameterList = new Vector();
        
        for ( int i = 0; i < tableModel.getRowCount(); i++ )  {
            String name = (String) tableModel.getValueAt(i, 0);
            String value = (String) tableModel.getValueAt(i, 1);
            
            if ( name.trim().equals(""))
                break;
            
            ParameterType pt = new ParameterTypeImpl();
            pt.setName(name);
            pt.setValue(value);
            
            parameterList.add(pt);
        }
        
        return parameterList;
        
    }

    //-------------------------------------------------------------------------
}

