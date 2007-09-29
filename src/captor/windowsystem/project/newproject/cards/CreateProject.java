package captor.windowsystem.project.newproject.cards;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;
import captor.windowsystem.project.newproject.Body;
import captor.windowsystem.project.util.ChooseDirectory;


public class CreateProject extends FITCard implements ActionListener, KeyListener  {
    
    public static final long serialVersionUID = 126;

    JPanel location;
    JLabel projectName;
    JTextField projectNameTF;
    JTextField rootFolderTF;
    JTextField outputFolderTF;
    JButton browseProjectPath, browseOutputPath;        
    String rootFolderString;
    JCheckBox check;
    
    private CaptorFrame frame;
    private Body body;
    
    public CreateProject(Model model, Project project, CaptorFrame frame, Body body) {
        super(model, project);
        this.frame = frame;
        this.body = body;
    }
    
    //-------------------------------------------------------------------------
    
    private void setDefaultSystemPath()
    {
        rootFolderString = model.getConfig().getSystemConfig().getInstallPath() + System.getProperty("file.separator") + "projects" + System.getProperty("file.separator");
        rootFolderTF.setText(rootFolderString);
        outputFolderTF.setText(rootFolderString);
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        project.setPath(model.getConfig().getSystemConfig().getInstallPath());
        project.setInputFolder(model.getConfig().getSystemConfig().getInstallPath());
        project.setOutputFolder(model.getConfig().getSystemConfig().getInstallPath());
        
        add(Box.createRigidArea(new Dimension(5,20)));
        add(createHeader());
        add(Box.createRigidArea(new Dimension(5,5)));
        add(createLocation());
        
        Dimension minSize = new Dimension(100, 250);
        Dimension prefSize = new Dimension(150, 250);
        Dimension maxSize = new Dimension(500, 850);
        add(new Box.Filler(minSize, prefSize, maxSize));
    }    
    
    private JPanel createHeader()  {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        
        projectName = new JLabel("   Project Name:   ");
        
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
        int labelMin = 90;
        int rootWidth = 100;

    	JPanel location = new JPanel();
        location.setLayout(new BoxLayout(location, BoxLayout.Y_AXIS));

        TitledBorder title = BorderFactory.createTitledBorder(MyIntl.NEW_PROJECT_WINDOW_LOCATION);
        location.setBorder(title);
        
        JPanel projectPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        JPanel overwritePanel = new JPanel();
        
        projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.X_AXIS));
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.X_AXIS));
        overwritePanel.setLayout(new BoxLayout(overwritePanel, BoxLayout.X_AXIS));
        
        // Project input path
        browseProjectPath = new JButton(MyIntl.NEW_PROJECT_WINDOW_BROWSE);
        browseProjectPath.setActionCommand("browseProjectPath");
        browseProjectPath.addActionListener(this);
        
        JLabel directory = new JLabel(MyIntl.NEW_PROJECT_WINDOW_DIR);      
        directory.setPreferredSize(new Dimension(labelMin, 20));
        
        rootFolderTF = new JTextField();
        rootFolderTF.setPreferredSize(new Dimension(rootWidth, 20));
        
        projectPanel.add(directory);
        // projectPanel.add(Box.createHorizontalGlue());
        projectPanel.add(rootFolderTF);
        projectPanel.add(browseProjectPath);
        
        
        // Project output path
        browseOutputPath = new JButton(MyIntl.NEW_PROJECT_WINDOW_BROWSE);
        browseOutputPath.setActionCommand("browseOutputPath");
        browseOutputPath.addActionListener(this);
        
        JLabel output = new JLabel(MyIntl.NEW_PROJECT_WINDOW_OUTPUT_DIR);
        output.setPreferredSize(new Dimension(labelMin, 40));
        
        outputFolderTF = new JTextField();
        outputFolderTF.setPreferredSize(new Dimension(rootWidth, 30));
                
        outputPanel.add(output);
        // outputPanel.add(Box.createHorizontalGlue());
        outputPanel.add(outputFolderTF);
        outputPanel.add(browseOutputPath);
        
        
        // Overwrite checkbox
        check = new JCheckBox(MyIntl.NEW_PROJECT_WINDOW_OVERWRITE);
        check.setPreferredSize(new Dimension(220, 15));
        check.addActionListener(this);
        check.setSelected(true);
        check.setPreferredSize(new Dimension(350, 30));
        add(check);
        
        Dimension minSize = new Dimension(5, 10);
        Dimension prefSize = new Dimension(5, 30);
        Dimension maxSize = new Dimension(5, 40);
        overwritePanel.add(new Box.Filler(minSize, prefSize, maxSize));
        overwritePanel.add(check);
        // overwritePanel.add(Box.createHorizontalGlue());
               
        location.add(projectPanel);
        
        minSize = new Dimension(100, 10);
        prefSize = new Dimension(150, 30);
        maxSize = new Dimension(500, 40);
        location.add(new Box.Filler(minSize, prefSize, maxSize));
        location.add(outputPanel);
        
        minSize = new Dimension(100, 10);
        prefSize = new Dimension(150, 50);
        maxSize = new Dimension(500, 60);
        location.add(new Box.Filler(minSize, prefSize, maxSize));
        location.add(overwritePanel);
        
        setDefaultSystemPath();
        rootFolderTF.setEnabled(true);
        outputFolderTF.setEnabled(true);
        
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
    
    public void actionPerformed(ActionEvent e)  {
        
        if ( e.getActionCommand().equals("browseProjectPath") )  {
            ChooseDirectory cd = new ChooseDirectory(frame, model);
            String ret = cd.open();
            if ( ret != null )  {
                rootFolderString = ret + System.getProperty("file.separator") + projectNameTF.getText();
                rootFolderTF.setText(rootFolderString);
            }
        }
        else if ( e.getActionCommand().equals("browseOutputPath") )  {
            ChooseDirectory cd = new ChooseDirectory(frame, model);
            String ret = cd.open();
            if ( ret != null )  {
            	outputFolterString = ret + System.getProperty("file.separator") + projectNameTF.getText();
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
        
        if ( !StringUtil.alpahNumericAndUnderscoreAndMinus(projectNameTF.getText()) )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG86);            
            return false;
        }
        
        String pname = projectNameTF.getText().trim().substring(0,1);
        if ( !pname.equals(pname.toUpperCase()) )  {
            JOptionPane.showMessageDialog(this, MyIntl.MSG87);
            return false;
        }
        
        String regexp = "[(A-Z)][(A-Za-z\\-_0-9)]*";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(projectNameTF.getText().trim());
        if ( !m.matches() )  {
            JOptionPane.showMessageDialog(this, StringUtil.formatMessage(MyIntl.MSG88, regexp));
            return false;
        }
        
        
        project.setName(projectNameTF.getText());
        project.setPath(rootFolderTF.getText());
        project.setInputFolder(rootFolderTF.getText() + System.getProperty("file.separator") + "input" + System.getProperty("file.separator"));
        project.setOutputFolder(outputFolderTF.getText() + System.getProperty("file.separator") + "output" + System.getProperty("file.separator"));
        
        if ( check.isSelected() )  {
            project.setOverwriteResources(true);
        }
        else  {
            project.setOverwriteResources(false);
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    public void start()  {
        projectNameTF.requestFocusInWindow();
    }
    
    //-------------------------------------------------------------------------
    
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e)  {
        //o enter foi pressionado
        if ( e.getKeyCode() == 10 )  {
            body.next();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        String path =  rootFolderString + System.getProperty("file.separator") + projectNameTF.getText() + System.getProperty("file.separator");
        path = path.replace("\\\\", "\\");
        rootFolderTF.setText(path);
    }
    
    //-------------------------------------------------------------------------
}
