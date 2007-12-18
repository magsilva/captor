/*
 *
 */
package captor.windowsystem.formcomponent.ncp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.formcomponent.Parameter;

public class ShowParametersFrame extends CaptorFrame {

    public static final long serialVersionUID = 149;

    Model model;
    private JPanel mainPanel = null;
    private JPanel headerPanel = null;
    private JPanel footerPanel = null;
    private JPanel centerPanel = null;
    private JEditorPane textArea;
    private JScrollPane scroll;
    private JButton okButton = null;
    Vector parametersVector;
    
    public ShowParametersFrame(Model model, CaptorFrame parentWindow, Vector parametersVector) {
        super(model, parentWindow);
        this.parametersVector = parametersVector;
        
		try {
            init();
        } catch (Exception e) {}
    }

    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        setTitle(MyIntl.NCP_LABEL_PAR_DESC);
        setCenterSize(453,382);
        add(getMainPanel());
        setDescription();
    }

    //-------------------------------------------------------------------------

    private JPanel getMainPanel() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(getHeaderPanel(), java.awt.BorderLayout.NORTH);
            mainPanel.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
            mainPanel.add(getFooterPanel(), java.awt.BorderLayout.SOUTH);
        }
        return mainPanel;
    }

    //-------------------------------------------------------------------------

    private JPanel getFooterPanel() {
        if (footerPanel == null) {
            footerPanel = new JPanel();
            footerPanel.setLayout(new BoxLayout(getFooterPanel(), BoxLayout.X_AXIS));
            footerPanel.add(new JLabel(" "));
            footerPanel.add(Box.createHorizontalGlue());
            footerPanel.add(getOkButton());
            footerPanel.add(new JLabel(" "));
            footerPanel.setPreferredSize(new Dimension(453, 35));
        }
        return footerPanel;
    }

    //-------------------------------------------------------------------------

    private JPanel getCenterPanel() {
        if (centerPanel == null) {
            centerPanel = new JPanel();
            centerPanel.setLayout(new BorderLayout());
            textArea = new JEditorPane();
            textArea.setContentType("text/html");
            textArea.setText("<b></b>");
            textArea.setEditable(true);

            scroll = new JScrollPane(textArea);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            centerPanel.add(scroll);
        }
        return centerPanel;
    }

    //-------------------------------------------------------------------------

    private JButton getOkButton() {
        if (okButton == null) {
            okButton = new JButton("Ok");
            okButton.addActionListener(this);
        }
        return okButton;
    }

    //-------------------------------------------------------------------------
    
    public void windowClosing2(WindowEvent e) {
        close();
    }

    //-------------------------------------------------------------------------

    private JPanel getHeaderPanel() {
        if (headerPanel == null) {
            headerPanel = new JPanel();
            headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
            headerPanel.add(new JLabel(MyIntl.NCP_LABEL_PL1));
            headerPanel.add(Box.createHorizontalGlue());
            headerPanel.add(new JLabel(" "));
            headerPanel.setPreferredSize(new Dimension(453, 35));
        }
        return headerPanel;
    }

    //-------------------------------------------------------------------------
    
    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("Ok") )  {
            setVisible(false);
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void setDescription()  {
        
      if ( parametersVector == null )  {
          return;
      }
      
      StringBuffer sb = new StringBuffer();
      sb.append(MyIntl.NCP_LABEL_SHOW_PAR1);

      for ( int j = 0; j < parametersVector.size(); j++ )  {
          Parameter par = (Parameter) parametersVector.get(j);
          
          sb.append(MyIntl.NCP_LABEL_SHOW_PAR2 + par.getName() + "<br>");
          sb.append(MyIntl.NCP_LABEL_SHOW_PAR3 + par.getType() + "<br>");
          if ( !par.getDefaultValue().equals("") ) {
          sb.append(MyIntl.NCP_LABEL_SHOW_PAR4 + par.getDefaultValue() + "<br>");
          }
          if ( !par.getRegexp().equals("") ) {
          sb.append(MyIntl.NCP_LABEL_SHOW_PAR5 + par.getRegexp() + "<br>");
          }
          String req = "";
          if ( par.isRequired() )
              req = "<b><font color=\"red\">true</font></b>";
          else
              req = "true";
          sb.append(MyIntl.NCP_LABEL_SHOW_PAR6 + req + "<br>");
          if ( !par.getDescription().equals("") ) {
              sb.append(MyIntl.NCP_LABEL_SHOW_PAR7 + par.getDescription() + "<br>");
              }
          
          sb.append("<br><hr><br>");
      }

      
      textArea.setText(sb.toString());
      textArea.setCaretPosition(1);
    }
    
    //-------------------------------------------------------------------------
}  
