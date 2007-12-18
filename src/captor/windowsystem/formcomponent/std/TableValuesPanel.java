package captor.windowsystem.formcomponent.std;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;

/**
 * @author Kicho
 *
 */
public class TableValuesPanel extends CaptorFrame  implements ActionListener, KeyListener  {

    public static final long serialVersionUID = 112;

    TablePanel tablePanel;
    Model model;
    DefaultTableModel tableModel;
    Hashtable map = new Hashtable();
    int row = -1;
    
    public TableValuesPanel(Model model, TablePanel tablePanel2, DefaultTableModel tableModel) {
        super(model);
        this.tablePanel = tablePanel2;
        this.model = model;
        this.tableModel = tableModel;
        init2();
    }

    public TableValuesPanel(Model model, TablePanel tablePanel2, DefaultTableModel tableModel, int row) {
        super(model);
        this.tablePanel = tablePanel2;
        this.model = model;
        this.tableModel = tableModel;
        this.row = row;
        init2();
    }

    
    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        setLayout(new BorderLayout());
        setCenterSize(360, 380);
        setResizable(false);
        setState(Frame.NORMAL);
        setTitle("Table values panel");
        addWindowListener(this);
    }
    
    //-------------------------------------------------------------------------
    
    protected void init2() {
        this.getContentPane().add(header(), BorderLayout.PAGE_START);
        this.getContentPane().add(body(), BorderLayout.CENTER);
        this.getContentPane().add(footer(), BorderLayout.PAGE_END);
    }
    
    //-------------------------------------------------------------------------
    
    private JPanel header()  {
        JPanel panel = new JPanel();
        panel.add(new JLabel(" "));
    
        return panel;
    }
    
    //-------------------------------------------------------------------------

    private JPanel footer()  {
        JPanel panel = new JPanel();
        
        Dimension d = new Dimension(100,20);
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        ok.setSize(d);
        ok.setPreferredSize(d);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setSize(d);
        cancel.setPreferredSize(d);
    
        panel.add(ok);
        panel.add(Box.createRigidArea(new Dimension(5,5)));
        panel.add(cancel);
        
        return panel;
    }

    //-------------------------------------------------------------------------
    
    private JScrollPane body()  {
        Dimension d1 = new Dimension(280,230);
        Dimension d2 = new Dimension(290,300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.setSize(d1);
        panel.setPreferredSize(d1);
        
        //--------------------------------------------

        String value = (String) tablePanel.getParameter().get("COLNAME1");
        if ( value != null )
            addLine(panel, value, "COLNAME1", row, 0);

        value = (String) tablePanel.getParameter().get("COLNAME2");
        if ( value != null )
            addLine(panel, value, "COLNAME2", row, 1);

        value = (String) tablePanel.getParameter().get("COLNAME3");
        if ( value != null )
            addLine(panel, value, "COLNAME3", row, 2);

        value = (String) tablePanel.getParameter().get("COLNAME4");
        if ( value != null )
            addLine(panel, value, "COLNAME4", row, 3);

        value = (String) tablePanel.getParameter().get("COLNAME5");
        if ( value != null )
            addLine(panel, value, "COLNAME5", row, 4);

        value = (String) tablePanel.getParameter().get("COLNAME6");
        if ( value != null )
            addLine(panel, value, "COLNAME6", row, 5);

        value = (String) tablePanel.getParameter().get("COLNAME7");
        if ( value != null )
            addLine(panel, value, "COLNAME7", row, 6);

        value = (String) tablePanel.getParameter().get("COLNAME8");
        if ( value != null )
            addLine(panel, value, "COLNAME8", row, 7);

        value = (String) tablePanel.getParameter().get("COLNAME9");
        if ( value != null )
            addLine(panel, value, "COLNAME9", row, 8);

        value = (String) tablePanel.getParameter().get("COLNAME10");
        if ( value != null )
            addLine(panel, value, "COLNAME10", row, 9);

        //--------------------------------------------

        panel.add(Box.createRigidArea(new Dimension(150,250)));
        
        JScrollPane scrollPane = new JScrollPane (panel);
        scrollPane.setSize(d2);
        scrollPane.setPreferredSize(d2);
        
//        panel.setBorder(BorderFactory.createLineBorder(Color.black));
//        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
//        bodyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        return scrollPane;
    }
    
    //-------------------------------------------------------------------------

    private void addLine(JPanel panel, String value, String key, int row, int col)  {
        JPanel linePanel = new JPanel();
        linePanel.setLayout(new BoxLayout(linePanel, BoxLayout.X_AXIS));
        
        JTextField textField = new JTextField();
        
        if ( row != -1 & col != -1)  {
            String s = (String) tableModel.getValueAt(row, col);
            if ( s != null )
                textField.setText(s);
        }
        
        textField.addKeyListener(this);
        
        map.put(key, textField);
        JLabel label = new JLabel(value + ":");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Dimension d = new Dimension(70,12);
        label.setSize(d);
        label.setPreferredSize(d);
        
        linePanel.add(label);
        linePanel.add(Box.createRigidArea(new Dimension(5,5)));
        linePanel.add(textField);
        
        panel.add(Box.createRigidArea(new Dimension(150,10)));
        panel.add(linePanel);
    }
    
    //-------------------------------------------------------------------------

    protected void windowClosing2(WindowEvent e) {
        dispose();
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().equals("OK") )  {
		    
		    if ( !ok() )
		    	return;
		    setVisible(false);
		    dispose();
	    }
		else if ( e.getActionCommand().equals("Cancel") )  {
		    setVisible(false);
		    dispose();
	    }
    }
    
    //-------------------------------------------------------------------------
    
    private boolean ok()  {
	    Vector v = new Vector();
		for ( int i = 0; i < tableModel.getColumnCount(); i++ )  {
	        Integer k = new Integer(i+1);
	        JTextField tf = (JTextField) map.get("COLNAME" + k.toString());

	        if ( tf.getText().trim().equals("") )  {
		        String value = (String) tablePanel.getParameter().get("COLNAME1");
                
		        JOptionPane.showMessageDialog(this, StringUtil.formatMessage(MyIntl.MSG69, value));
	            return false;
	        }
	        
	        if ( tf != null )  {
	                v.add(tf.getText());
	        }
	    }
		
		if ( row == - 1 )  {
		    tableModel.addRow(v);
		}
		else  {
			for ( int i = 0; i < tableModel.getColumnCount(); i++ )  {
				for ( int j = 0; j < v.size(); j++ )  {
				    String s  = (String) v.get(j);
				    tableModel.setValueAt(s, row, j);
				}			    
			}		    
		}
		
		model.getProject().setStatus(Project.UNSAVED);
		return true;
    }
    
    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {
    	if ( e.getKeyCode() == 10 )  {
		    if ( ok() )  {
			    setVisible(false);
			    dispose();
		    	return;
		    }
    	}
    }
    
    //-------------------------------------------------------------------------
}
