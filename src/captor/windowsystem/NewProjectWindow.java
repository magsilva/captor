package captor.windowsystem;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.project.newproject.Body;
import captor.windowsystem.project.newproject.Footer;
import captor.windowsystem.project.newproject.Header;


/** @author Kicho
 * Janela que permite que o usuário crie um novo projeto.
 */
public class NewProjectWindow extends CaptorFrame  {
    
    public static final long serialVersionUID = 40565;

    private Header header;
    private Body body;
    private Footer footer;

    private Project project;
    
    public NewProjectWindow(Model model) {
        super(model, model.getGui().getCaptorWindow());
    }
    
    //-------------------------------------------------------------------------

    protected void init() throws Exception {
        project = new Project(model);
        project.loadDefault(true);
        
        this.setLayout(new BorderLayout());
        this.setCenterSize(540, 500);
        this.setResizable(false);
        this.setState(Frame.NORMAL);
        this.setTitle(MyIntl.PROJECT_NEW);
        this.addWindowListener(this);
        
        header = new Header();
        body = new Body(model, this, header, project);
        footer = new Footer(model, project, this);
        
        body.setFooter(footer);
        footer.setBody(body);
        
        body.first();
        
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
