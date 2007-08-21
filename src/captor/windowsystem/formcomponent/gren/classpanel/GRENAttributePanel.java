package captor.windowsystem.formcomponent.gren.classpanel;

import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.gren.classpanel.data.GRENAttribute;
import captor.windowsystem.formcomponent.gren.classpanel.data.GRENClass;


/**
 * @author Kicho
 *
 */
public class GRENAttributePanel extends CaptorFrame  implements ActionListener, ListSelectionListener, KeyListener  {

    public static final long serialVersionUID = 100;

    JList list;
    DefaultListModel listModel;
    JLabel jLabelAttListAtt;
    JPanel panel;
    JButton jButtonNovo;
    JButton jButtonRemove;
    JButton jButtonSave;
    JButton jButtonClose;
    JLabel jLabelAttName;
    JLabel jLabelAttType;
    JLabel jLabelAttLenght;
    JTextField jTextFieldAttName;
    JTextField jTextFieldAttLenght;
    JComboBox jComboBoxAttType;
    JLabel jLabelClassName;
    JScrollPane scrollPane;
    JPopupMenu popup;
    JMenuItem menuItem;
    
    private AttWinKeyEventDispatcher kev;
    private GRENClass grenClass;
    private Vector sysAttrs;
    
    public GRENAttributePanel(Model model, GRENClass grenClass, Vector sysAttrs) {
        super(model);
        this.grenClass = grenClass;
        this.sysAttrs = sysAttrs;
        
        init2();
    }
    
    //-------------------------------------------------------------------------

    private void init2()  {
        
        if ( sysAttrs != null )  {
            for ( int i = 0; i < sysAttrs.size(); i++ )  {
                listModel.addElement(sysAttrs.get(i));
            }
        }
        
        if ( grenClass != null )  {
            for ( int i = 0; i < grenClass.getAttrs().size(); i++ )  {
                listModel.addElement(grenClass.getAttrs().get(i));
            }
        }

        popup = new JPopupMenu();
        
        menuItem = new JMenuItem("Copy");
        menuItem.addActionListener(this);
        popup.add(menuItem);

        menuItem = new JMenuItem("Cut");
        menuItem.addActionListener(this);
        popup.add(menuItem);

        menuItem = new JMenuItem("Paste");
        menuItem.addActionListener(this);
        popup.add(menuItem);
        
        kev = new AttWinKeyEventDispatcher(this);         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);        
    }

    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        this.setLayout(null);
        this.setCenterSize(560,280);
        this.getContentPane().setLayout(null);
        this.setTitle("Attributes");
        this.setResizable(false);
        
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.addListSelectionListener(this);
        list.addMouseListener(new AttListListener(model, list, this));
        
        jLabelAttListAtt = new JLabel();
        panel = new JPanel();
        jButtonNovo = new JButton();
        jButtonRemove = new JButton();
        jButtonSave = new JButton();
        jButtonClose = new JButton();
        jLabelAttName = new JLabel();
        jLabelAttType = new JLabel();
        jLabelAttLenght = new JLabel();
        jTextFieldAttName = new JTextField();
        jTextFieldAttLenght = new JTextField();
        jLabelClassName = new JLabel();
        scrollPane = new JScrollPane(list);
        
//        String[] types = { "", "char", "integer", "float", "date", "discrete list", "list from a table", "multiples values from"};
        String[] types = { "", "char", "integer", "float", "date"};
        jComboBoxAttType = new JComboBox(types);
        jComboBoxAttType.addActionListener(this);

        jTextFieldAttName.addKeyListener(this);
        jTextFieldAttLenght.addKeyListener(this);
        jComboBoxAttType.addKeyListener(this);
        
        jButtonRemove.addActionListener(this);
        jButtonNovo.addActionListener(this);
        jButtonSave.addActionListener(this);
        jButtonClose.addActionListener(this);
        
        jLabelAttListAtt.setDoubleBuffered(false);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setLayout(null);

        jButtonNovo.setText("New");
        jButtonRemove.setText("Remove");
        jButtonSave.setText("Save");
        jButtonClose.setText("Close");
        jLabelAttName.setAlignmentX((float) 0.0);
        jLabelAttName.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabelAttType.setAlignmentX((float) 0.0);
        jLabelAttType.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabelAttName.setText  ("  Attribute name:");
        jLabelAttType.setText  ("  Attribute type:");
        jLabelAttLenght.setText("Attribute lenght:");
        jLabelAttLenght.setAlignmentX((float) 0.0);
        jLabelAttLenght.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextFieldAttName.setText("");
        jTextFieldAttLenght.setText("");
        jLabelAttListAtt.setText("List of attributes for class:");
        jLabelClassName.setFont(new java.awt.Font("Dialog", 1, 11));
        jLabelClassName.setText("ClassName");

        jLabelAttListAtt.setBounds(new Rectangle(10, 15, 132, 15));
        jLabelClassName.setBounds(new Rectangle(145, 15, 233, 15));
        list.setBounds(new Rectangle(10, 40, 174, 191));
        scrollPane.setBounds(new Rectangle(10, 40, 174, 191));
        panel.setBounds(new Rectangle(200, 40, 342, 146));

        jButtonNovo.setBounds(new Rectangle  (200, 204, 73, 25));
        jButtonRemove.setBounds(new Rectangle(290, 204, 73, 25));
        jButtonSave.setBounds(new Rectangle  (380, 204, 73, 25));
        jButtonClose.setBounds(new Rectangle (470, 204, 73, 25));

        jLabelAttName.setBounds(new Rectangle      (8, 25, 85, 15));
        jLabelAttType.setBounds(new Rectangle      (8, 60, 85, 15));
        jLabelAttLenght.setBounds(new Rectangle    (8, 95, 85, 15));

        jTextFieldAttName.setBounds(new Rectangle(106, 25, 215, 21));
        jComboBoxAttType.setBounds(new Rectangle   (106, 60, 215, 21));
        jTextFieldAttLenght.setBounds(new Rectangle(106, 95, 215, 21));

        jTextFieldAttName.setEnabled(false);
        jTextFieldAttLenght.setVisible(false);
        jLabelAttLenght.setVisible(false);
        jComboBoxAttType.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonRemove.setEnabled(false);
        
        panel.add(jLabelAttLenght, null);
        panel.add(jLabelAttType, null);
        panel.add(jLabelAttName, null);
        panel.add(jTextFieldAttName, null);
        panel.add(jComboBoxAttType, null);
        panel.add(jTextFieldAttLenght, null);

        this.getContentPane().add(scrollPane, null);
        this.getContentPane().add(jLabelAttListAtt, null);
        this.getContentPane().add(jLabelClassName, null);
        this.getContentPane().add(jButtonClose, null);
        this.getContentPane().add(jButtonNovo, null);
        this.getContentPane().add(jButtonRemove, null);
        this.getContentPane().add(jButtonSave, null);
        this.getContentPane().add(panel, null);
    }

    //-------------------------------------------------------------------------

    protected void windowClosing2(WindowEvent e) {
        dispose();
    }

    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        //System. out.println(e);
        
		if ( e.getActionCommand().equals("Close") )  {
		    setVisible(false);
		    dispose();
	    }
		else if ( e.getActionCommand().equals("New") )  {
		    newAttr();
		}
		else if ( e.getActionCommand().equals("Save") )  {
		    saveAttr();
		}
		else if ( e.getActionCommand().equals("Remove") )  {
		    removeAttr();
		}
		else if ( e.getActionCommand().equals("comboBoxChanged") )  {
		    typeChanged();
		}
		
    }
    
    private void typeChanged()  {
        String item = (String) jComboBoxAttType.getSelectedItem();
        if ( item.equals("char") )  {
            jTextFieldAttLenght.setVisible(true);
            jLabelAttLenght.setVisible(true);
        }
        else  {
            jTextFieldAttLenght.setVisible(false);
            jLabelAttLenght.setVisible(false);        }
    }
    
    //-------------------------------------------------------------------------

    private void newAttr()  {
        jTextFieldAttName.setText("");
        jTextFieldAttLenght.setText("");
        jComboBoxAttType.setSelectedIndex(0);
        
        jTextFieldAttName.setEnabled(true);
        jComboBoxAttType.setEnabled(true);
        jButtonSave.setEnabled(true);
        
        jTextFieldAttName.requestFocus();
    }
    
    //-------------------------------------------------------------------------

    private void removeAttr()  {
        int index = list.getSelectedIndex();
        int size = listModel.getSize();
        
        if ( size == 0 )  {            
            JOptionPane.showMessageDialog(panel, "There is no element to be removed.");
            jButtonRemove.setEnabled(false);
            return;
        }
        
        if ( index == -1 )  {            
            JOptionPane.showMessageDialog(panel, "You must first select a attribute element in the list before you try to remove it.");
            return;
        }

        GRENAttribute ga = (GRENAttribute) list.getSelectedValue();
        if ( ga.isAttSystem() )  {
            JOptionPane.showMessageDialog(panel, "This attribute cannot be removed.\nIt is a required attribute in this pattern.");
            return;
        }
        
        grenClass.removeAttr(ga);
        listModel.removeElementAt(index);
        
        size = listModel.getSize();
        if ( size == 0 )            
            jButtonRemove.setEnabled(false);
        
        grenClass.removeAttr((GRENAttribute) list.getSelectedValue());
        
        jTextFieldAttName.setText("");
        jComboBoxAttType.setSelectedIndex(0);
        jTextFieldAttLenght.setText("");

        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-------------------------------------------------------------------------

    private void saveAttr()  {
        //validação dos resultados
        if ( jTextFieldAttName.getText().equals("") )  {
            JOptionPane.showMessageDialog(panel, "The field attribute name cannot be blank.");
            return;
        }
        
        if ( jComboBoxAttType.getSelectedIndex() == 0 )  {
            JOptionPane.showMessageDialog(panel, "The field attribute type cannot be blank.");
            return;
        }
        
        Integer lenght = null;
        if ( jTextFieldAttLenght.isVisible() )  {
	        if ( jTextFieldAttLenght.getText().equals("") )  {
	            JOptionPane.showMessageDialog(panel, "The field attribute lenght cannot be blank.");
	            return;
	        }
	        
	        String aux = jTextFieldAttLenght.getText();
	        lenght = null;
	        
	        try {
	            lenght = new Integer(aux);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(panel, "The field attribute lenght must be a valid integer.");
	            return;
	        }
	        
	        if ( jComboBoxAttType.getSelectedIndex() == 0 )  {
	            JOptionPane.showMessageDialog(panel, "You have to choose a value for the field attribute type.");
	            return;
	        }
	        
	        //validar o intervalo do tamanho do atributo
	        if ( lenght.intValue() <= 0 )  {
	            JOptionPane.showMessageDialog(panel, "The attribute lenght must be greater than 0.");
	            return;
	        }
        }
        
        //validar o formato do nome do atributo
       	String regexp = "[(a-zA-Z)][(A-Za-z\\-_0-9)]*";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(jTextFieldAttName.getText().trim());
        if ( !m.matches() )  {
            JOptionPane.showMessageDialog(panel, "Invalid attribute name. It doesn't match the regular expression: " + regexp);
            return;
        }

        //atualizar os elementos do frame
        jTextFieldAttName.setEnabled(false);
        jComboBoxAttType.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonRemove.setEnabled(true);
        
        GRENAttribute gattr = new GRENAttribute();
        gattr.setName(jTextFieldAttName.getText());
        gattr.setType((String)jComboBoxAttType.getSelectedItem());
        if ( jTextFieldAttLenght.isVisible() && lenght != null )
            gattr.setLenght(lenght.intValue());
        
        //inserir o atributo no jlist
        addAttribute(gattr);
    }
    
    //-------------------------------------------------------------------------
    
    public void addAttribute(GRENAttribute gattr)  {
        
        //percorrer toda a lista e verificar se tem um atributo com o mesmo nome de gattr
        for ( int i = 0; i < listModel.getSize(); i++ )  {
            GRENAttribute attr = (GRENAttribute) listModel.get(i);
            if ( attr.getName().equals(gattr.getName()) )  {
                JOptionPane.showMessageDialog(this, "Cannot paste attribute '" + gattr.getName() + "' because the list already contain an attribute with this name.");
                return;
            }
        }
        
        listModel.addElement(gattr);
        grenClass.addAttr(gattr);
        model.getProject().setStatus(Project.UNSAVED);
    }
    
    //-------------------------------------------------------------------------
    
    public void valueChanged(ListSelectionEvent e) {
//        System.out.println(e.getSource().getClass().getName());
//        System.out.println(e.getSource());

        //mostrar o atributo no panel do lado direito
        GRENAttribute gattr = (GRENAttribute) list.getSelectedValue();
        
        if ( gattr == null )
            return;
        
        jComboBoxAttType.setSelectedIndex(0);
        jTextFieldAttName.setText("");
        jTextFieldAttLenght.setText("");

        jTextFieldAttName.setText(gattr.getName());
        jTextFieldAttLenght.setText(new Integer(gattr.getLenght()).toString());
        jComboBoxAttType.setSelectedItem(gattr.getType());
        jButtonRemove.setEnabled(true);
    }

    //-------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {
    	if ( e.getKeyCode() == 10 )  {
    	    saveAttr();
    	}
    }

    //-------------------------------------------------------------------------
}
