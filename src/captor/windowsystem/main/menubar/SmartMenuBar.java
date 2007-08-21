package captor.windowsystem.main.menubar;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.help.HelpContents;
import captor.windowsystem.util.IconUtil;


/**
 * This class create and instantiate the menu bar located in the main window.
 * 
 * @author Kicho
 */
public class SmartMenuBar extends JMenuBar implements Observer {
    
    public static final long serialVersionUID = 159;

    private JMenu file;
    private JMenu fileNew;
    private JMenuItem fileNewProject;
    private JMenuItem fileExit;
    private JMenuItem lastOpenProject1, lastOpenProject2, lastOpenProject3, lastOpenProject4;
    
    private JMenu project;
    private JMenuItem projectOpen;
    private JMenuItem projectClose;
    private JMenuItem projectSave;
    private JMenuItem projectSaveAs;
    private JMenuItem projectBuild;
    private JMenuItem projectClean;
    private JMenuItem projectValidate;
    private JMenuItem projectProperties;
    
    private JMenu tools;
    private JMenuItem metaModelValidator;
    
    private JMenu window;
    private JMenuItem windowNewWindow;
    private JMenu windowShowView;
    private JMenuItem windowConsole;
    private JMenuItem windowError;
    private JMenuItem windowWarning;
    private JMenuItem windowPreferences;
    
    private JMenu help;
    private JMenuItem helpContents;
    private JMenuItem helpAbout;
    
    private Model model;
    private WindowMenuListener windowMenuListener;
    private ProjectMenuListener projectMenuListener;
    private HelpMenuListener helpMenuListener;
    private FileMenuListener fileMenuListener;
    private ToolsMenuListener toolsMenuListener;
    
    public SmartMenuBar(Model model) {
        super();
        this.model = model;
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        
        fileMenuListener = new FileMenuListener(model);
        windowMenuListener = new WindowMenuListener(model);
        projectMenuListener = new ProjectMenuListener(model);
        helpMenuListener = new HelpMenuListener(model);
        toolsMenuListener = new ToolsMenuListener(model);
        
        file = new JMenu (MyIntl.MENU_BAR_FILE);
        if ( MyIntl.LANG.equals("pt") )
            file.setMnemonic('A');
        else
            file.setMnemonic('F');
        
        makeFileMenu();
        
        //---------------------------------------------------------------------
        
        project = new JMenu (MyIntl.MENU_BAR_PROJECT);
        project.setMnemonic('P');
        
        projectOpen = new JMenuItem (MyIntl.SUBMENU_BAR_OPEN, KeyEvent.VK_O);
        projectOpen.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        projectOpen.setMnemonic('O');
        insertIcon(projectOpen, "open.gif");

        projectSave = new JMenuItem (MyIntl.SUBMENU_BAR_SAVE, KeyEvent.VK_S);
        projectSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        insertIcon(projectSave, "save.gif");
        
        projectBuild = new JMenuItem (MyIntl.SUBMENU_BAR_BUILD, KeyEvent.VK_B);
        projectBuild.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        projectBuild.setMnemonic('B');
        insertIcon(projectBuild, "build.gif");
        
        projectSaveAs = new JMenuItem (MyIntl.SUBMENU_BAR_SAVEAS);
        insertIcon(projectSaveAs, "saveas.gif");
        
        projectClose = new JMenuItem (MyIntl.SUBMENU_BAR_CLOSE);
        projectClose.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        projectClose.setMnemonic('C');
        insertIcon(projectClose, "close.gif");
        
        projectClean = new JMenuItem (MyIntl.SUBMENU_BAR_CLEAN);
        insertIcon(projectClean, "clean.gif");
        
        projectValidate = new JMenuItem (MyIntl.SUBMENU_BAR_VALIDATE);
        insertIcon(projectValidate, "validateProject.gif");
        projectValidate.setMnemonic('K');
        projectValidate.setAccelerator(KeyStroke.getKeyStroke('K', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        
        projectProperties = new JMenuItem (MyIntl.SUBMENU_BAR_PROPERTIES);
        projectProperties.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        projectProperties.setMnemonic('P');
        insertIcon(projectProperties, "properties.gif");
        
        project.add(projectOpen);
        project.add(projectClose);
        project.addSeparator();
        project.add(projectSave);
        project.add(projectSaveAs);
        project.addSeparator();
        project.add(projectBuild);
        project.add(projectClean);
        project.add(projectValidate);
        project.addSeparator();
        project.add(projectProperties);
        
        projectClean.addActionListener(projectMenuListener);
        projectValidate.addActionListener(projectMenuListener);
        projectBuild.addActionListener(projectMenuListener);
        projectOpen.addActionListener(projectMenuListener);
        projectProperties.addActionListener(projectMenuListener);
        projectSave.addActionListener(projectMenuListener);
        projectSaveAs.addActionListener(projectMenuListener);
        projectClose.addActionListener(projectMenuListener);
        
        //---------------------------------------------------------------------
        
        tools = new JMenu (MyIntl.MENU_BAR_TOOLS);
        if ( MyIntl.LANG.equals("pt") )
            tools.setMnemonic('F');
        else
            tools.setMnemonic('T');
        
        metaModelValidator = new JMenuItem (MyIntl.SUBMENU_BAR_METAMODEL_VALIDATOR);
        //        insertIcon(metaModelValidator, "toolvalidator.jpg");
        
        tools.add(metaModelValidator);
        insertIcon(metaModelValidator, "tools.gif");
        metaModelValidator.addActionListener(toolsMenuListener);
        
        //---------------------------------------------------------------------
        
        window = new JMenu (MyIntl.MENU_BAR_WINDOW);
        if ( MyIntl.LANG.equals("pt") )
            window.setMnemonic('J');
        else
            window.setMnemonic('W');
            
        windowShowView = new JMenu (MyIntl.SUBMENU_BAR_SHOW_VIEW);
        insertIcon(windowShowView, "showview.jpg");
        
        windowNewWindow = new JMenuItem (MyIntl.SUBMENU_BAR_NEW_WINDOW);
        insertIcon(windowNewWindow, "newwindow.gif");
        
        windowError = new JMenuItem (MyIntl.SUBMENU_BAR_ERROR);
        insertIcon(windowError, "errorview.gif");
        
        windowWarning = new JMenuItem (MyIntl.SUBMENU_BAR_WARNING);
        insertIcon(windowWarning, "warning.gif");
        
        windowConsole = new JMenuItem (MyIntl.SUBMENU_BAR_CONSOLE);
        insertIcon(windowConsole, "console.gif");
        
        windowPreferences = new JMenuItem (MyIntl.SUBMENU_BAR_PREFERENCES);
        insertIcon(windowPreferences, "preferences.jpg");
        
        windowShowView.add(windowConsole);
        windowShowView.add(windowError);
        windowShowView.add(windowWarning);
        
        window.add(windowNewWindow);
        window.addSeparator();
        window.add(windowShowView);
        window.addSeparator();
        window.add(windowPreferences);
        
        windowWarning.addActionListener(windowMenuListener);
        windowConsole.addActionListener(windowMenuListener);
        windowError.addActionListener(windowMenuListener);
        windowNewWindow.addActionListener(windowMenuListener);
        windowPreferences.addActionListener(windowMenuListener);
        
        //---------------------------------------------------------------------
        
        help = new JMenu (MyIntl.MENU_BAR_HELP);
        help.setMnemonic('H');

        helpContents = new JMenuItem (MyIntl.SUBMENU_BAR_CONTENTS);
        insertIcon(helpContents, "help.gif");
        
        helpAbout = new JMenuItem (MyIntl.SUBMENU_BAR_ABOUT);
        insertIcon(helpAbout, "about.jpg");
        
        help.add(helpContents);
        help.addSeparator();
        help.add(helpAbout);
        
        helpAbout.addActionListener(helpMenuListener);
	    helpContents.addActionListener(new HelpContents(model));
        
        //---------------------------------------------------------------------
        
        this.add(file);
        this.add(project);
        this.add(tools);
        this.add(window);
        this.add(help);
    }
    
    //-------------------------------------------------------------------------

    public void insertIcon(JMenuItem jitem, String iconName)  {
        Icon icon = IconUtil.getIcon(iconName);

        jitem.setIcon(icon);
    }
    
    //-------------------------------------------------------------------------

    public void update(Observable observable, Object obj)  {
        if ( obj.equals(Constant.ADD_OPEN_PROJECT_TO_FILE_MENU) )  {
            makeFileMenu();
        }
        
    }
    
    //-------------------------------------------------------------------------

    public void makeFileMenu()  {
        file.removeAll();
        
        fileNew = new JMenu (MyIntl.SUBMENU_BAR_NEW);
        fileNew.setMnemonic('N');
        
        fileNewProject = new JMenuItem (MyIntl.SUBMENU_BAR_PROJECT, KeyEvent.VK_N);
        fileNewProject.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        insertIcon(fileNewProject, "newapplication.gif");
        
        fileExit = new JMenuItem (MyIntl.SUBMENU_BAR_EXIT);
        fileExit.setMnemonic('E');
        fileExit.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        
        lastOpenProject1 = null;
        lastOpenProject2 = null;
        lastOpenProject3 = null;
        lastOpenProject4 = null;
        
        if ( ! model.getConfig().getGuiHiddenConfig().getLastOpenProject1().equals("") )
            lastOpenProject1 = new JMenuItem (makeLastProjectName(model.getConfig().getGuiHiddenConfig().getLastOpenProject1()));
        if ( ! model.getConfig().getGuiHiddenConfig().getLastOpenProject2().equals("") )
            lastOpenProject2 = new JMenuItem (makeLastProjectName(model.getConfig().getGuiHiddenConfig().getLastOpenProject2()));
        if ( ! model.getConfig().getGuiHiddenConfig().getLastOpenProject3().equals("") )
            lastOpenProject3 = new JMenuItem (makeLastProjectName(model.getConfig().getGuiHiddenConfig().getLastOpenProject3()));
        if ( ! model.getConfig().getGuiHiddenConfig().getLastOpenProject4().equals("") )
            lastOpenProject4 = new JMenuItem (makeLastProjectName(model.getConfig().getGuiHiddenConfig().getLastOpenProject4()));
        
        file.add (fileNew);
        fileNew.add(fileNewProject);
        
        if ( lastOpenProject1 != null || 
                lastOpenProject2 != null ||
                lastOpenProject3 != null ||
                lastOpenProject4 != null )
            file.addSeparator();	
        
        if ( lastOpenProject1 != null )  {
            lastOpenProject1.setActionCommand("lastOpenProject1");
            lastOpenProject1.addActionListener(fileMenuListener);
            lastOpenProject1.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

            file.add(lastOpenProject1);
        }
        if ( lastOpenProject2 != null )  {
            lastOpenProject2.setActionCommand("lastOpenProject2");
            lastOpenProject2.addActionListener(fileMenuListener);
            file.add(lastOpenProject2);
        }
        if ( lastOpenProject3 != null )  {
            lastOpenProject3.setActionCommand("lastOpenProject3");
            lastOpenProject3.addActionListener(fileMenuListener);
            file.add(lastOpenProject3);
        }
        if ( lastOpenProject4 != null )  {
            lastOpenProject4.setActionCommand("lastOpenProject4");
            lastOpenProject4.addActionListener(fileMenuListener);
            file.add(lastOpenProject4);
        }
        file.addSeparator();
        
        file.add (fileExit);
        
        fileExit.addActionListener(fileMenuListener);
        fileNewProject.addActionListener(fileMenuListener);
    }
    
    //-------------------------------------------------------------------------

    public String makeLastProjectName(String name)  {
        int pos = name.lastIndexOf(System.getProperty("file.separator"));
        
        String ret = name.substring(pos + 1, name.length());
        
        String aux = name; 
        if ( (30 - ret.length()) < name.length() && (30 - ret.length()) > 1 )
            aux = name.substring(0, (30 - ret.length())).concat("... ");
        
        
        ret = ret.concat("   [" + aux + "]");
        
        if ( ret.length() > 50 )
            return ret.substring(0, 50);
        
        return ret;
    }
    
    //-------------------------------------------------------------------------
}
