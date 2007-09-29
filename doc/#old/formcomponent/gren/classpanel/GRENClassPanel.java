package captor.windowsystem.formcomponent.gren.classpanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.def.Constant;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.formcomponent.gren.classpanel.data.GRENAttribute;
import captor.windowsystem.formcomponent.gren.classpanel.data.GRENClass;


/**
 * @author Kicho
 *
 */
public class GRENClassPanel extends FormComponent implements ActionListener, KeyListener {

    JTextField resource, pluralForm;
    JButton attr;
    JLabel resourceLabel, pluralFormLabel;
    GRENAttributePanel attrPanel;
    Vector sysAttrs; 
    
    private GRENClass grenClass;
    private String classname, readFrom;
    
    public GRENClassPanel(Model model, DefaultMutableTreeNode node) {
        super(model, node);
        grenClass = new GRENClass();
        create();
        classname = "";
        readFrom = "";
        sysAttrs = new Vector();
    }

    //-------------------------------------------------------------------------

    private void fillMainValues(Node node)  {
        NodeList nodeList = node.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node aux = nodeList.item(i);
            if ( aux.getFirstChild() != null )  {
                if ( aux.getNodeName().toUpperCase().equals("CLASS"))  {
	                resource.setText(aux.getFirstChild().getNodeValue());
	            }
	            else if ( aux.getNodeName().toUpperCase().equals("PLURALFORM"))  {
	                pluralForm.setText(aux.getFirstChild().getNodeValue());
	            }
	            else if ( aux.getNodeName().toUpperCase().equals("ATTRIBUTES"))  {
	                fillAttributes(aux);
	            }
            }
        }        
    }

    private void fillAttributes(Node node)  {
        NodeList nodeList = node.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node aux = nodeList.item(i);
            if ( aux.getNodeName().toUpperCase().equals("ATTRIBUTE"))  {
                fillAttribute(aux);
            }            
        }        
    }

    private void fillAttribute(Node node)  {
        NodeList nodeList = node.getChildNodes();
        GRENAttribute gattr = null;
        gattr = new GRENAttribute();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node aux = nodeList.item(i);
            
            if ( aux.getNodeName().toUpperCase().equals("NAME"))  {
                gattr.setName(aux.getFirstChild().getNodeValue());
            }
            else if ( aux.getNodeName().toUpperCase().equals("TYPE"))  {
                gattr.setType(aux.getFirstChild().getNodeValue());
            }
            else if ( aux.getNodeName().toUpperCase().equals("LENGTH"))  {
                if ( aux.getFirstChild() != null )  {
                    try {
                        Integer intAux = new Integer(aux.getFirstChild().getNodeValue());
                        gattr.setLenght(intAux.intValue());   
                    } 
                    catch (NumberFormatException e) {} 
                    catch (DOMException e) {}
                }
            }
        }
        
        if ( gattr != null )  {
            grenClass.addAttr(gattr);
        }
    }

    //--------------------------------------------------------------------------

    private void readFrom()  {
        resource.setEnabled(false);
        pluralForm.setEnabled(false);
        attr.setEnabled(false);
        
        FormComponent fe = getFormElement(readFrom);
        if ( fe != null )  {
            if ( fe instanceof GRENClassPanel )  {
		        GRENClassPanel gcp = (GRENClassPanel) fe; 
		        JTextField fromResourceTF = gcp.getResourceTF();
				JTextField fromResourcePLTF = gcp.getResourcePLTF();
				new ReadFromListener(fromResourceTF, resource);
				new ReadFromListener(fromResourcePLTF, pluralForm);
            }
        }
        
		return;
    }

    //--------------------------------------------------------------------------

    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        resourceLabel = new JLabel();
        resource = new JTextField();
        pluralForm = new JTextField();
        attr = new JButton("Attributes");
        
        attr.addActionListener(this);
        resource.addKeyListener(this);
        
        pluralForm.addKeyListener(this);
        
        Dimension d = new Dimension(169,20);
        resource.setSize(d);
        resource.setPreferredSize(d);
        pluralForm.setSize(d);
        pluralForm.setPreferredSize(d);
        resource.setMaximumSize(d);
        pluralForm.setMaximumSize(d);

        resourceLabel.setPreferredSize(new Dimension(Constant.LABEL_WIDTH,20));
        resourceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        resourceLabel.setText("Class: ");
        this.add(resourceLabel);
        panel.add(resource);
        panel.add(new JLabel("     "));
        pluralFormLabel = new JLabel("Plural form: ");
        panel.add(pluralFormLabel);
        panel.add(pluralForm);
        panel.add(new JLabel("     "));
        panel.add(attr);
        panel.add(Box.createHorizontalGlue());
        panel.add(new JLabel("  "));
        this.add(panel);
    }

    //-------------------------------------------------------------------------

    public String getId() {
        return classname;
    }
    
    //-------------------------------------------------------------------------

    public String getValues() {
        return resource.getText();
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        attrPanel = new GRENAttributePanel(model, grenClass, sysAttrs);
        attrPanel.setVisible(true);
        
        model.getProject().getPatternTree().print();
    }
    
    //-------------------------------------------------------------------------

    public boolean validateParameters()  {
        String value = (String) parameter.get("CLASS");
        if ( value == null )  {
            return false;
        }

        value = (String) parameter.get("SYS_ATT1");
        if ( value != null && !validateSysAtt(value))
            return false;
        value = (String) parameter.get("SYS_ATT2");
        if ( value != null && !validateSysAtt(value))
            return false;
        value = (String) parameter.get("SYS_ATT3");
        if ( value != null && !validateSysAtt(value))
            return false;
        value = (String) parameter.get("SYS_ATT4");
        if ( value != null && !validateSysAtt(value))
            return false;
        value = (String) parameter.get("SYS_ATT5");
        if ( value != null && !validateSysAtt(value))
            return false;
        value = (String) parameter.get("SYS_ATT6");
        if ( value != null && !validateSysAtt(value) )
            return false;
        value = (String) parameter.get("SYS_ATT7");
        if ( value != null && !validateSysAtt(value) )
            return false;
        value = (String) parameter.get("SYS_ATT8");
        if ( value != null && !validateSysAtt(value) )
            return false;
        value = (String) parameter.get("SYS_ATT9");
        if ( value != null && !validateSysAtt(value) )
            return false;
        
        value = (String) parameter.get("ATTRIBUTES");
        if ( value != null )  {
            if ( !(value.equals("false") || value.equals("true")) )   {
                return false;    
            }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    private boolean validateSysAtt(String value)  {
        
        if ( value == null ) 
            return true;
        
        String []values = value.split(":");
        if ( values.length != 3 )  {
            return false;
        }
        
        if ( !(values[1].equals("char") || values[1].equals("date") ||
                values[1].equals("integer") || values[1].equals("float")) )  {
            return false;
        }

        int len = 0;
        if ( values[2] != null && !values[2].equals("") )  {
	        try {
	            Integer i = new Integer(values[2]);
	            len = i.intValue();
	        } catch (NumberFormatException e) {
	            return false;
	        }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    public void updateValues()  {
        String value = (String) parameter.get("READ_FROM");
        if ( value != null )  {
            readFrom = value;
            value = null;
            readFrom();
        } 
    }
    
    //-------------------------------------------------------------------------

    public void parseParameters()  {
        
        String value = (String) parameter.get("CLASS");
        if ( value != null )  {
            classname = value;
            String aux = value.concat(": ");
            resourceLabel.setText(aux);
            value = null;
        } 
        else  {
            model.getGui().getGuiView().setWarningView("<font color=\"#FF0000\"><b>Meta-model error.</b></font><br><br>Use meta-model validator for details.<br>");
            model.getGui().getGuiView().setConsoleView("");
        }
        
        value = (String) parameter.get("READ_FROM");
        if ( value != null )  {
            readFrom = value;
            value = null;
            readFrom();
        } 
        
        value = (String) parameter.get("SYS_ATT1");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT2");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT3");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT4");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT5");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT6");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT7");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT8");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("SYS_ATT9");
        if ( value != null )  {
            addSysAtt(value);
        }
        value = (String) parameter.get("ATTRIBUTES");
        if ( value != null )  {
            if ( value.equals("false") )   {
                attr.setEnabled(false);    
            }
        }
    }

    //-------------------------------------------------------------------------

    private void addSysAtt(String value)  {
        String []values = value.split(":");
        
        int len = 0;
        if ( values != null && values.length >= 3 ) {
	        if ( values[2] != null && !values[2].equals("") )  {
		        try {
		            Integer i = new Integer(values[2]);
		            len = i.intValue();
		        } catch (NumberFormatException e) {
		            return;
		        }
	        }
        }
        
        GRENAttribute ga = new GRENAttribute();
        ga.setName(values[0]);
        ga.setType(values[1]);
        ga.setLenght(len);
        ga.setAttSystem(true);
        
        sysAttrs.add(ga);
    }
    
    //-------------------------------------------------------------------------
    
    public boolean validateFields()  {
        
        //return true for ready only fields
        String value = (String) parameter.get("READ_FROM");
        if ( value != null )  {
            return true;
        }
        
        //validação da classe
        String required = (String) parameter.get("CLASS_USE");
        if ( required == null )
            required = "";
        
        if ( !required.toUpperCase().equals("NOT_REQUIRED") )  {
	        if ( resource.getText().trim().equals("") )  {
	            cleanErrorLine();
	            addErrorLine("'" + resourceLabel.getText().substring(0, resourceLabel.getText().length() - 2) + "' value cannot be blank.");
	            return false;
	        }
        }

       	String regexp = "[(a-zA-Z)][(A-Za-z\\-_0-9)]*";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(resource.getText().trim());
        
        if ( !required.toUpperCase().equals("NOT_REQUIRED") )  {
	        if ( !m.matches() )  {
	            cleanErrorLine();
	            addErrorLine("'" + resourceLabel.getText().substring(0, resourceLabel.getText().length() - 2) + "' invalid format.");
	            addErrorLine("Possible values: " + regexp);
	            return false;
	        }
        }

        if ( required.toUpperCase().equals("NOT_REQUIRED") && 
                resource.getText().trim().equals("") &&
                !pluralForm.getText().trim().equals("") )  {
            cleanErrorLine();
            addErrorLine("If the class " + resourceLabel.getText().substring(0, resourceLabel.getText().length() - 2) + " is empty, it's pluralForm must be empty too.");
            return false;
        }

        if ( required.toUpperCase().equals("NOT_REQUIRED") && 
                !resource.getText().trim().equals("") &&
                pluralForm.getText().trim().equals("") )  {
            cleanErrorLine();
            addErrorLine("If the class " + resourceLabel.getText().substring(0, resourceLabel.getText().length() - 2) + " is not empty, it's pluralForm must not be empty.");
            return false;
        }

        //validação da forma plural
        if ( !required.toUpperCase().equals("NOT_REQUIRED") )  {
	        if ( pluralForm.getText().trim().equals("") )  {
	            cleanErrorLine();
	            addErrorLine(resourceLabel.getText().substring(0, resourceLabel.getText().length() - 2) + " plural form value cannot be null.");
	            return false;
	        }
        }        

        m = p.matcher(pluralForm.getText().trim());
        if ( !required.toUpperCase().equals("NOT_REQUIRED") && !resource.getText().trim().equals(""))  {
	        if ( !m.matches() )  {
	            cleanErrorLine();
	            addErrorLine("'" + pluralFormLabel.getText().substring(0, pluralFormLabel.getText().length() - 2) + " invalid format. Possible values: " + regexp);
	            return false;
	        }
        }        
        
        //DIRTY BUG FIX
        String aux = resource.getText();
        aux = aux.replace("   ", "");
        aux = aux.replace("  ", "");
        aux = aux.replace(" ", "");
        
        if ( !aux.equals("") )  {
	        String firstLetter = resource.getText().substring(0, 1);
	        if ( !firstLetter.equals(firstLetter.toUpperCase()))  {
	            cleanErrorLine();
	            addErrorLine("The first letter of a class name (" + resource.getText() + ") must be in upper case.");
	            return false;
	        }
        }
        return true;
    }

    //-------------------------------------------------------------------------

    public void toXML(CCBuffer out)  {
        //DIRTY FIX
        String aux = resource.getText();
        aux = aux.replace("   ", "");
        aux = aux.replace("  ", "");
        aux = aux.replace("", "");
        
        if ( aux.equals("") )
            return;
        
        resource.setText(resource.getText().trim());
        pluralForm.setText(pluralForm.getText().trim());
        
        if ( resource.getText().equals("") )
        	return;
        
        String description = resourceLabel.getText();
        description = description.substring(0, description.length() - 2);
        description = description.concat(" (").concat(resource.getText() + ")");
//        model.getGui().getGuiView().setConsoleView("Generating xml from element: " + description);
        
        out.newLine();
        out.ident();
        out.appendln("<grenclass name=\"" + classname + "\">");
        out.ident();
        out.append("<class>");
        out.append(resource.getText(), true);
        out.append("</class>", true);

        out.newLine();
        out.append("<object>");
        out.append(resource.getText().substring(0, 1).toLowerCase().concat(resource.getText().substring(1, resource.getText().length())), true);
        out.append("</object>", true);

        out.newLine();
        out.append("<pluralForm>");
        out.append(pluralForm.getText(), true);
        out.append("</pluralForm>", true);
        out.newLine();
        out.newLine();
        out.appendln("<attributes>");
        Vector v = grenClass.getAttrs();
        for ( int i = 0; i < v.size(); i++ )  {
            GRENAttribute attr = (GRENAttribute) v.get(i);
            out.ident();
            out.appendln("<attribute>");
            out.ident();
            
            out.append("<name>");
            out.append(attr.getName(), true);
            out.appendln("</name>", true);
            
            out.append("<uname>");
            out.append(attr.getName().substring(0,1).toUpperCase().concat(attr.getName().substring(1, attr.getName().length())), true);
            out.appendln("</uname>", true);
            
            out.append("<type>");
            out.append(attr.getType(), true);
            out.appendln("</type>", true);
            
            out.append("<length>");
            out.append(attr.getLenght(), true);
            out.appendln("</length>", true);
            
            out.dident();
            out.appendln("</attribute>");
            out.dident();
        }
        out.appendln("</attributes>");
        out.dident();
        out.appendln("</grenclass>");
        out.dident();
    }
    
    //-------------------------------------------------------------------------

    public void load(Node data)  {
        
        String currentClass = (String) parameter.get("CLASS");
        if ( currentClass == null )
            return;
        
        NodeList nodeList = data.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("GRENCLASS") )  {
                NamedNodeMap nnm = node.getAttributes();
                Node nameAtt = nnm.getNamedItem("name");
                if ( nameAtt.getNodeValue().toUpperCase().equals(currentClass.toUpperCase()))  {
                    fillMainValues(node);
                }
            }
        }
        
    }
    
    //--------------------------------------------------------------------------

    public JTextField getResourceTF()  {
        return resource;
    }
    public JTextField getResourcePLTF()  {
        return pluralForm;
    }
    
    public void setResourceTFText(String text)  {
        resource.setText(text);
    }
    public void setResourcePLTFText(String text)  {
        pluralForm.setText(text);
    }
    
    //--------------------------------------------------------------------------

    /**
     * @return Returns the classname.
     */
    public String getClassname() {
        return classname;
    }
    /**
     * @param classname The classname to set.
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }
    /**
     * @return Returns the grenClass.
     */
    public GRENClass getGrenClass() {
        return grenClass;
    }
    /**
     * @param grenClass The grenClass to set.
     */
    public void setGrenClass(GRENClass grenClass) {
        this.grenClass = grenClass;
    }
    /**
     * @return Returns the pluralForm.
     */
    public JTextField getPluralForm() {
        return pluralForm;
    }
    /**
     * @param pluralForm The pluralForm to set.
     */
    public void setPluralForm(JTextField pluralForm) {
        this.pluralForm = pluralForm;
    }
    /**
     * @return Returns the readFrom.
     */
    public String getReadFrom() {
        return readFrom;
    }
    /**
     * @param readFrom The readFrom to set.
     */
    public void setReadFrom(String readFrom) {
        this.readFrom = readFrom;
    }
    //--------------------------------------------------------------------------
    
    public Vector getRequiredParameters()  {
        Vector v = new Vector();
        v.add("class -   (required)");
        v.add("read_from");
        v.add("sys_attr1");
        v.add("sys_attr2");
        v.add("sys_attr3");
        v.add("sys_attr4");
        v.add("sys_attr5");
        v.add("sys_attr6");
        v.add("sys_attr7");
        v.add("sys_attr8");
        v.add("sys_attr9");
        v.add("attributes");
        
        String whiteSpace = "                                          ";
        String description = "";
        description = description.concat("\n" + whiteSpace + "Examples:");
        description = description.concat("\n\n" + whiteSpace + "    Attribute 'class':");
        description = description.concat("\n" + whiteSpace + "        <parameter>");
        description = description.concat("\n" + whiteSpace + "                <name>class</name>");
        description = description.concat("\n" + whiteSpace + "                <value>Recurso</value>");
        description = description.concat("\n" + whiteSpace + "        </parameter>");
        description = description.concat("\n\n" + whiteSpace + "    Attribute 'read_from':");
        
        description = description.concat("\n" + whiteSpace + "        <parameter>");
        description = description.concat("\n" + whiteSpace + "                <name>read_from</name>");
        description = description.concat("\n" + whiteSpace + "                <value>parent(1.*)->Recurso</value>");
        description = description.concat("\n" + whiteSpace + "                                        OR");
        description = description.concat("\n" + whiteSpace + "                <value>[parent||child]([PATTERN_ID])->CLASSNAME</value>");
        description = description.concat("\n" + whiteSpace + "        </parameter>");

        description = description.concat("\n\n" + whiteSpace + "    Attribute 'sys_attX':");
        description = description.concat("\n" + whiteSpace + "        <parameter>");
        description = description.concat("\n" + whiteSpace + "                <name>sys_attX</name>");
        description = description.concat("\n" + whiteSpace + "                <value>IdCode:integer:</value>");
        description = description.concat("\n" + whiteSpace + "                                        OR");
        description = description.concat("\n" + whiteSpace + "                <value>description:char:10");
        description = description.concat("\n" + whiteSpace + "        </parameter>");

        description = description.concat("\n\n" + whiteSpace + "    Attribute 'attributes':");
        description = description.concat("\n" + whiteSpace + "        <parameter>");
        description = description.concat("\n" + whiteSpace + "                <name>attributes</name>");
        description = description.concat("\n" + whiteSpace + "                <value>true</value>");
        description = description.concat("\n" + whiteSpace + "                                        OR");
        description = description.concat("\n" + whiteSpace + "                <value>false");
        description = description.concat("\n" + whiteSpace + "        </parameter>");

        description = description.concat("\n");
        v.add(description);
        
        return v;
    } 
    
    //--------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)  {}
    public void keyReleased(KeyEvent e) {
    	model.getProject().setStatus(Project.UNSAVED);
    }

    //--------------------------------------------------------------------------
}
