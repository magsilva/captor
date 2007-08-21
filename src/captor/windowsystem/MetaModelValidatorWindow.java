/*
 *
 */
package captor.windowsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;

import captor.domainsystem.metamodelvalidator.MetaModelValidator;
import captor.modelsystem.Model;
import captor.windowsystem.metamodelvalidator.Body;
import captor.windowsystem.metamodelvalidator.Footer;
import captor.windowsystem.metamodelvalidator.Header;


/**
 * @author Kicho
 *
 */
public class MetaModelValidatorWindow extends CaptorFrame  {

    public static final long serialVersionUID = 32587;

    public MetaModelValidatorWindow(Model model) {
        super(model);
    }
    
    //-------------------------------------------------------------------------
    
    protected void init() throws Exception {
        //configurando esse frame
        this.setLayout(new BorderLayout());
        this.setCenterSize(515, 500);
        this.setResizable(true);
        this.setState(Frame.NORMAL);
        this.setTitle("MMV - Meta Model Validator");
        this.addWindowListener(this);
        
        //construção dos panes da janela
        Body body = new Body(model);
        Footer footer = new Footer(this);

        MetaModelValidator mmv = new MetaModelValidator(model.getConfig().getSystemConfig().getInstallPath());
        Header header = new Header(mmv, model, body);
        header.setPreferredSize(new Dimension(400, 40));
        
        //adicionando os panes
        this.getContentPane().add(header, BorderLayout.PAGE_START);
        this.getContentPane().add(body, BorderLayout.CENTER);
        this.getContentPane().add(footer, BorderLayout.PAGE_END);
    }
    
    //-------------------------------------------------------------------------

    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    public void dispose() {
        close();
    }

    //-------------------------------------------------------------------------
}
