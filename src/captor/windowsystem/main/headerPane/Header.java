package captor.windowsystem.main.headerPane;

import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.projectmanager.build.ProgressLauncher;

/**
 * This class implements a header panel located in the main window behind the
 * menu bar.
 * 
 * <p>
 * It current display the save and build access butttons.
 * </p>
 * 
 * @author Kicho
 *
 */
public class Header extends JPanel {
    
    public static final long serialVersionUID = 118;

    private Model model;
    
    JToolBar toolBar;
    JButton saveProject;
    JButton buildProject;
    Timer timer;
    ProgressLauncher pl;
    
    public Header(Model model) {
        create();
        this.model = model;
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        toolBar = new JToolBar();
        
        saveProject = new JButton(MyIntl.HEADER_SAVE);
        buildProject = new JButton(MyIntl.HEADER_BUILD);
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        toolBar.add(saveProject);
        toolBar.add(buildProject);
        
        add(toolBar);
        
        //adicionando os actionLinsteners
        buildProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buildProject_actionPerformed();
            }
        });
        
        saveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProject_actionPerformed();
            }
        });
    }

    //listeners
    //-------------------------------------------------------------------------

    void buildProject_actionPerformed() {
        ProjectSystem pj = new ProjectSystem(model);
        pj.build();
    }
    
    //---------------------------------------------------------------------

    void saveProject_actionPerformed() {
        ProjectSystem pj = new ProjectSystem(model);
        pj.save();
    }

    //---------------------------------------------------------------------
}
