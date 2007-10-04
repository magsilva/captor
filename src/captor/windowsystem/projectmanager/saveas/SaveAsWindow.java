package captor.windowsystem.projectmanager.saveas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.project.util.ChooseDirectory;


/**
 * @author Kicho
 *
 */
public class SaveAsWindow extends CaptorFrame implements KeyListener, ActionListener  {

    public static final long serialVersionUID = 130;

    JLabel projectName;
    JTextField projectNameTF;
    JTextField rootFolderTF, outputFolderTF;
    JButton browseProjectPath, browseOutputPath;        
    
    private String rootFolderString;
    
    public SaveAsWindow(Model model) {
        super(model, model.getGui().getCaptorWindow());
    }
    
    //-------------------------------------------------------------------------    

    protected void init() throws Exception {
        this.setLayout(new BorderLayout());
        
        this.setCenterSize(540, 200);
        this.setResizable(false);
        this.setState(Frame.NORMAL);
        this.setTitle(MyIntl.PROJECT_SAVEAS_TITLE );

        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel spacePanel1 = new JPanel();
        JPanel spacePanel2 = new JPanel();
        JPanel spacePanel3 = new JPanel();
        spacePanel1.setPreferredSize(new Dimension(540, 100));
        spacePanel2.setPreferredSize(new Dimension(540, 100));
        spacePanel3.setPreferredSize(new Dimension(540, 100));
        
        panel.add(spacePanel1);
        panel.add(createHeader());
        panel.add(createLocation());
        panel.add(spacePanel2);
        panel.add(createOKPanel());
        panel.add(spacePanel3);
        
        this.getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    //-------------------------------------------------------------------------    

    private void setDefaultSystemPath()  {
        String path = model.getConfig().getSystemConfig().getInstallPath() + File.separator + "projects" + File.separator;
        rootFolderTF.setText(path);
        
        path.concat(File.separator + "output" + File.separator);
        outputFolderTF.setText(path);
        rootFolderString = path;
    }

    //-------------------------------------------------------------------------
    
    private JPanel createOKPanel()  {
        JPanel okPanel = new JPanel();
        okPanel.setLayout(new BoxLayout(okPanel, BoxLayout.X_AXIS));
        
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(this);
        
        okPanel.add(new JLabel(" "));
        okPanel.add(Box.createHorizontalGlue());
        okPanel.add(okButton);
        okPanel.add(new JLabel("   "));
        
        return okPanel;
    }
    
    //-------------------------------------------------------------------------

    private JPanel createHeader()  {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        
        projectName = new JLabel(MyIntl.PROJECT_SAVEAS_NEW_PROJECT_HOME);
        
        projectNameTF = new JTextField();
        projectNameTF.setPreferredSize(new Dimension(45,300));
        projectNameTF.addKeyListener(this);
        
        header.add(projectName);
        header.add(projectNameTF);
        header.add(new JLabel("      "));
        
        return header;
    }

    //-------------------------------------------------------------------------

    private JPanel createLocation()  {
        JPanel location = new JPanel();
        location.setLayout(new BoxLayout(location, BoxLayout.Y_AXIS));
        TitledBorder title;
        title = BorderFactory.createTitledBorder(MyIntl.PROJECT_SAVEAS_LOCALIZACAO);
        location.setBorder(title);
        title = BorderFactory.createTitledBorder(MyIntl.PROJECT_SAVEAS_PLAYOUT);

        JPanel projectPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.X_AXIS));
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.X_AXIS));

        browseProjectPath = new JButton(MyIntl.PROJECT_SAVEAS_BROWSE);
        browseProjectPath.setActionCommand("browseProjectPath");
        browseProjectPath.addActionListener(this);
        JLabel directory = new JLabel(MyIntl.PROJECT_SAVEAS_BASE_DIR);
        
        int labelMin = 90;
        int rootWidth = 100;
        directory.setPreferredSize(new Dimension(labelMin, 20));
        
        rootFolderTF = new JTextField();
        rootFolderTF.setPreferredSize(new Dimension(rootWidth, 20));
        
        projectPanel.add(directory);
        projectPanel.add(Box.createHorizontalGlue());
        projectPanel.add(rootFolderTF);
        projectPanel.add(browseProjectPath);

        browseOutputPath = new JButton(MyIntl.PROJECT_SAVEAS_BROWSE);
        browseOutputPath.setActionCommand("browseOutputPath");
        browseOutputPath.addActionListener(this);
        JLabel output = new JLabel(MyIntl.PROJECT_SAVEAS_OUTPUT_DIR);
        outputFolderTF = new JTextField();
        
        outputFolderTF.setPreferredSize(new Dimension(rootWidth,20));
        output.setPreferredSize(new Dimension(labelMin, 20));
        
        outputPanel.add(output);
        outputPanel.add(Box.createHorizontalGlue());
        outputPanel.add(outputFolderTF);
        outputPanel.add(browseOutputPath);
        
        location.add(projectPanel);

        Dimension minSize = new Dimension(100, 10);
        Dimension prefSize = new Dimension(150, 30);
        Dimension maxSize = new Dimension(500, 40);
        location.add(new Box.Filler(minSize, prefSize, maxSize));
        
        location.add(outputPanel);
        
        setDefaultSystemPath();
        rootFolderTF.setEnabled(false);
        outputFolderTF.setEnabled(false);
        
        
        JPanel retPanel = new JPanel();

        retPanel.setLayout(new BoxLayout(retPanel, BoxLayout.X_AXIS));

        minSize = new Dimension(15, 10);
        prefSize = new Dimension(35, 20);
        maxSize = new Dimension(50, 200);

        retPanel.add(Box.createRigidArea(new Dimension(6,20)));
        retPanel.add(location);
        retPanel.add(Box.createRigidArea(new Dimension(8,10)));
        
        return retPanel;
    }
    
    //-------------------------------------------------------------------------

    public void windowClosing2(WindowEvent e) {
        close();
    }
    
    public void dispose() {
        close();
    }

    //-------------------------------------------------------------------------
    
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e)  {
        //o enter foi pressionado
        if ( e.getKeyCode() == 10 )  {
            doTheJob();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        String path =  rootFolderString + File.separator + projectNameTF.getText() + File.separator;
        rootFolderTF.setText(path);
    }
    
    //-------------------------------------------------------------------------

    public void doTheJob()  {
        if ( !validateFields() )
            return;
        
        String name = projectNameTF.getText();
        String baseDir = rootFolderTF.getText();
        String outputDir = outputFolderTF.getText();
        
        this.setVisible(false);
        
        ProjectSystem pj = new ProjectSystem(model);
        pj.saveAs(name, baseDir, outputDir);
        
        this.close();
    }    

    //-------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent e)  {
        if ( e.getActionCommand().equals("Ok") )  {
            doTheJob();
        }
        else if ( e.getActionCommand().equals("browseProjectPath") )  {
            ChooseDirectory cd = new ChooseDirectory(parentFrame, model);
            String ret = cd.open();
            if ( ret != null )  {
                rootFolderString = ret + System.getProperty("file.separator") + projectNameTF.getText();
                rootFolderTF.setText(rootFolderString);
            }
        }
        else if ( e.getActionCommand().equals("browseOutputPath") )  {
            ChooseDirectory cd = new ChooseDirectory(parentFrame, model);
            String ret = cd.open();
            if ( ret != null )  {
                outputFolderTF.setText(ret);
            }
        }
    }
    
    //-------------------------------------------------------------------------
    
    public boolean validateFields()  {
        String ret = StringUtil.validateProjectName(projectNameTF.getText());
        if ( ret != null )  {
            JOptionPane.showMessageDialog(this, ret);
            projectNameTF.requestFocusInWindow();
            return false;
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
}
