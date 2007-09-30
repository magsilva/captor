/*
 *
 */
package captor.windowsystem.metamodelvalidator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import captor.domainsystem.metamodelvalidator.MetaModelValidator;
import captor.domainsystem.metamodelvalidator.ValidationResults;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class Header extends JPanel implements ActionListener  {

    public static final long serialVersionUID = 133;

    JButton browseButton;
    JButton validateButton;
    JTextField filenameTF;
    JFileChooser fc;
    
    private MetaModelValidator mmv;
    private Model model;
    private Body body;
    private File file;
    
    public Header(MetaModelValidator mmv, Model model, Body body)  {
        this.model = model;
        this.mmv = mmv;
        this.body = body;
        create();
    }

    public void create()  {
        setOpaque(true);
        repaint();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        browseButton = new JButton(MyIntl.METAMODEL_VALIDATOR_BROWSE);
        browseButton.addActionListener(this);
        
        validateButton = new JButton(MyIntl.METAMODEL_VALIDATOR_VALIDATE);
        validateButton.addActionListener(this);
        validateButton.setEnabled(false);

        filenameTF = new JTextField("");
        filenameTF.setEnabled(false);
        filenameTF.setPreferredSize(new Dimension(400, 20));
        filenameTF.setMaximumSize(new Dimension(1200, 20));
        
        file = new File(model.getConfig().getSystemConfig().getInstallPath(), "domains");
        fc = new JFileChooser(file);
        fc.addChoosableFileFilter(new OpenDomainFilter());
        
        this.add(new JLabel("  "));
        this.add(filenameTF);
        this.add(new JLabel("  "));
        this.add(browseButton);
        this.add(new JLabel("      "));
        this.add(validateButton);
        this.add(new JLabel(" "));
        
        teste();
    }
    
    private void teste()  {
        file = new File(model.getConfig().getSystemConfig().getInstallPath() + "/domains/grn/grn.domain");
        filenameTF.setText(file.getAbsolutePath());
        validateButton.setEnabled(true);
    }
    
    //-------------------------------------------------------------------------
    
    private void browse()  {
        int returnVal = fc.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            filenameTF.setText(file.getAbsolutePath());
            validateButton.setEnabled(true);
        } 
    }
    //-------------------------------------------------------------------------
    
    private void validate2()  {
        body.getTA().setText("");
        
        if ( file != null && file.exists() )  {
            ValidationResults vr = mmv.validate(file);
        	body.setText(vr);
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e)  {
        if ( e.getActionCommand().equals(MyIntl.METAMODEL_VALIDATOR_BROWSE) )  {
            browse();
        }
        else if ( e.getActionCommand().equals(MyIntl.METAMODEL_VALIDATOR_VALIDATE) )  {
            validate2();
        }
    }

    //-------------------------------------------------------------------------

}
