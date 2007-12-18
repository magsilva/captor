package captor.windowsystem.project.newproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.main.locationPane.FormNavigatorListener;


public class Footer extends JPanel implements ActionListener  {
    
    public static final long serialVersionUID = 121;

    private Model model;
    private Body body;
    private Project project;
    private CaptorFrame frame;
    
    JButton back, next, finish, cancel;
    
    public Footer(Model model, Project project, CaptorFrame frame) {
        super();
        this.model = model;
        this.project = project;
        this.frame = frame;
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        
        this.setPreferredSize(new Dimension(500,40));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        back = new JButton(MyIntl.NEW_PROJECT_WINDOW_BACK);
        next = new JButton(MyIntl.NEW_PROJECT_WINDOW_NEXT);
        finish = new JButton(MyIntl.NEW_PROJECT_WINDOW_FINISH);
        cancel = new JButton(MyIntl.NEW_PROJECT_WINDOW_CANCEL);
        
        back.addActionListener(this);
        next.addActionListener(this);
        finish.addActionListener(this);
        cancel.addActionListener(this);

        back.setPreferredSize(new Dimension(85, 400));
        next.setPreferredSize(new Dimension(85, 400));
        finish.setPreferredSize(new Dimension(85, 400));
        cancel.setPreferredSize(new Dimension(85, 400));
        
        finish.setEnabled(false);
        back.setEnabled(false);

        Dimension minSize = new Dimension(5, 450);
        Dimension prefSize = new Dimension(150, 450);
        Dimension maxSize = new Dimension(500, 450);
        add(new Box.Filler(minSize, prefSize, maxSize));
        
        add(cancel);
        add(new JLabel("  "));
        add(back);
        add(new JLabel("  "));
        add(next);
        add(new JLabel("  "));
        add(finish);
        add(new JLabel("  "));
    }
    
    //-------------------------------------------------------------------------

    /**
     * @return Returns the body.
     */
    public Body getBody() {
        return body;
    }
    /**
     * @param body The body to set.
     */
    public void setBody(Body body) {
        this.body = body;
    }
    
    //-------------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals(MyIntl.NEW_PROJECT_WINDOW_CANCEL) )  {
            frame.dispose();
        }
        else if ( e.getActionCommand().equals(MyIntl.NEW_PROJECT_WINDOW_NEXT) )  {
            body.next();
        }
        else if ( e.getActionCommand().equals(MyIntl.NEW_PROJECT_WINDOW_BACK) )  {
            body.back();
        }
        else if ( e.getActionCommand().equals(MyIntl.NEW_PROJECT_WINDOW_FINISH) )  {
            project.setStatus(Project.SAVED);
            model.setProject(project);
            
            model.getGui().loadGuiDomain();
            createProject();
            frame.dispose();
        }
    
        updateButtons();
    }
    
    //-------------------------------------------------------------------------
    
    public void updateButtons()  {
        if ( !body.hasBack() )
            back.setEnabled(false);
        else
            back.setEnabled(true);
            
        if ( !body.hasNext() )  {
            next.setEnabled(false);
            finish.setEnabled(true);
            finish.requestFocusInWindow();
        }
        else   {
            next.setEnabled(true);
            finish.setEnabled(false);
        }
        
    }
    
    //-------------------------------------------------------------------------

    private void createProject()  {
        //verificar se o path existe
        File file = new File(model.getProject().getPath());
        
        //se path nao existir, criar como diretorio
        if  ( !file.exists() )  {
            if ( !file.mkdirs() )  {
                String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br>Cannot create project because the directory \"" + model.getProject().getPath() + "\" cannot be created.<br>";
                model.getGui().getGuiView().setErrorView(errorMsg);
            }
        }
        else if ( !file.isDirectory() )  {
            String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br>The path \"" + model.getProject().getPath() + "\" must be a directory.<br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
        }
        
        //criar o output folder e o input folder se for necessario
        file = new File(model.getProject().getOutputFolder());
        if  ( !file.exists() )  {
            if ( !file.mkdirs() )  {
                String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br>Cannot create project because the directory \"" + model.getProject().getOutputFolder() + "\" cannot be created.<br>";
                model.getGui().getGuiView().setErrorView(errorMsg);
            }
        }
        else if ( !file.isDirectory() )  {
            String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br>Cannot create project because the path \"" + model.getProject().getOutputFolder() + "\" is not a directory.<br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
        }

        file = new File(model.getProject().getInputFolder());
        if  ( !file.exists() )  {
            if ( !file.mkdirs() )  {
                String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br>Cannot create project because the directory \"" + model.getProject().getInputFolder() + "\" cannot be created.<br>";
                model.getGui().getGuiView().setErrorView(errorMsg);
            }
        }
        else if ( !file.isDirectory() )  {
            String errorMsg = "<font color=\"#FF0000\"><b>Create project error.</b></font><br><br>Cannot create project because the path \"" + model.getProject().getInputFolder() + "\" is not a directory.<br>";
            model.getGui().getGuiView().setErrorView(errorMsg);
        }
        
        //criar o projeto em formato properties no path\projectname.prj
        model.getProject().save();
        
        //colocar na lista dos ultimos projetos abertos
        String ppath = model.getProject().getPath().concat(System.getProperty("file.separator")).concat(model.getProject().getName().concat(".cap"));
        model.getConfig().getGuiHiddenConfig().addLastOpenProject(ppath);
        
        //abrir a primeira intera��o!
        FormNavigatorListener fnl = new FormNavigatorListener(model);
        fnl.newInteraction();
    }
    
    //-------------------------------------------------------------------------
}

