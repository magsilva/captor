package captor.windowsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import captor.lib.def.Constant;
import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.modelsystem.config.GUIHiddenConfig;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.main.WindowMaker;
import captor.windowsystem.util.IconUtil;
import captor.windowsystem.util.MyKeyEventDispatcher;

/**
 * Main application window.
 * 
 * <p>
 * This class will instantiate every main window component.
 * </p>
 *
 * @author Kicho
 */
public class MainWindow extends CaptorFrame implements Observer  {
    
    public static final long serialVersionUID = 70563;

    private WindowMaker windowMaker;
    JSplitPane hSplitPane, vSplitPane;
    
    //contador de janelas. qdo ele for igual a zero (system.exit())
    private int verticalBarPosition = 50;
    
    //a primeira janela deve começar com esse construtor
    public MainWindow(Model model)  {
        super(model);
        model.getGui().setCaptorWindow(this);
        model.getConfig().getGuiConfig().addObserver(this);
        model.getGui().getGuiControl().addObserver(this);

        MyKeyEventDispatcher kev = new MyKeyEventDispatcher();         
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(kev);
    }

    //-------------------------------------------------------------------------
    
    public void init() throws Exception {
        startFrame();
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        windowMaker = new WindowMaker(this, model);
        
        //configurando este frame
        this.setTitle("Captor");
        this.setIconImage(IconUtil.getImage("captor.jpg"));
        
        //configurando o tamanho do frame
        this.setBounds(new Rectangle(model.getConfig().getGuiHiddenConfig().getWinPosX(), model.getConfig().getGuiHiddenConfig().getWinPosY(), model.getConfig().getGuiHiddenConfig().getWinPosWidth(), model.getConfig().getGuiHiddenConfig().getWinPosHeight()));
        if (model.getConfig().getGuiHiddenConfig().getWindowState() == GUIHiddenConfig.WINDOW_MAXIMIZED )
            this.setExtendedState(MAXIMIZED_BOTH);
        
        //criando o menu do frame
        this.setJMenuBar(windowMaker.createSmartMenuBar());
        
        //adicionando os listeners
//        addWindowListener(this);
//        addWindowStateListener(this);
        
        //criando o cabeçalho com a barra de ferramentas
        this.getContentPane().add(windowMaker.createHeader(), BorderLayout.PAGE_START);
        
        //criando o corpo principal, a barra de controle e a barra de views
        JPanel bodyPanel = windowMaker.createBody();
        JPanel locationPanel = windowMaker.createLocation();
        JPanel viewPanel = windowMaker.createView();
        
        JScrollPane bodyScrollPane = new JScrollPane(bodyPanel);
        
        hSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bodyScrollPane, viewPanel);
        vSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, locationPanel, hSplitPane);
        
        vSplitPane.setDividerLocation(model.getConfig().getGuiHiddenConfig().getVSplitPosition());
        hSplitPane.setDividerLocation(model.getConfig().getGuiHiddenConfig().getHSplitPosition());
        
        this.getContentPane().add(vSplitPane, BorderLayout.CENTER);
        toFront();
        
        checkPermissions(model.getConfig().getSystemConfig().getInstallPath());
        
        endFrame();
    }
    
    //-------------------------------------------------------------------------
    
    private void startFrame()  {
    }
    
    private void endFrame()  {
    }
    
    //-------------------------------------------------------------------------
    
//    public void windowStateChanged(WindowEvent e) {
//        if (e.getNewState() == 6 ) {
//            //a janela foi maximizada
//            model.getConfig().getGuiHiddenConfig().setWindowState(GUIHiddenConfig.WINDOW_MAXIMIZED);
//        }
//        else if (e.getNewState() == 0 ) {
//            //a janela foi desmaximizada
//            model.getConfig().getGuiHiddenConfig().setWindowState(GUIHiddenConfig.WINDOW_CUSTOM_SIZE);
//        }
//    }
    
    //-------------------------------------------------------------------------
    
    protected void windowClosing2(WindowEvent e) {
        exit();
    }
    
    //-------------------------------------------------------------------------
    
    private void saveModel()  {
        if ( model.isProduction() == true )  {
            Dimension d = this.getSize();
            
            model.getConfig().getGuiHiddenConfig().setWinPosX(this.getX() + 40);
            model.getConfig().getGuiHiddenConfig().setWinPosY(this.getY() + 40);
            model.getConfig().getGuiHiddenConfig().setWinPosWidth((int) d.getWidth());
            model.getConfig().getGuiHiddenConfig().setWinPosHeight((int) d.getHeight());
            
            model.getConfig().getGuiHiddenConfig().setHSplitPosition(hSplitPane.getLastDividerLocation());
            model.getConfig().getGuiHiddenConfig().setVSplitPosition(vSplitPane.getLastDividerLocation());
            
            model.getConfig().getGuiHiddenConfig().setHSplitPosition(hSplitPane.getDividerLocation());
            model.getConfig().getGuiHiddenConfig().setVSplitPosition(vSplitPane.getDividerLocation());
            
            model.save();
            
            
        }
    }
    
    //-------------------------------------------------------------------------
    
    private void exit()  {
        
        Dimension d = this.getSize();
        
        //salva o estado da janela
        model.getConfig().getGuiHiddenConfig().setWinPosX(this.getX());
        model.getConfig().getGuiHiddenConfig().setWinPosY(this.getY());
        model.getConfig().getGuiHiddenConfig().setWinPosWidth((int) d.getWidth());
        model.getConfig().getGuiHiddenConfig().setWinPosHeight((int) d.getHeight());
        
        model.getConfig().getGuiHiddenConfig().setHSplitPosition(hSplitPane.getLastDividerLocation());
        model.getConfig().getGuiHiddenConfig().setVSplitPosition(vSplitPane.getLastDividerLocation());
        
        model.getConfig().getGuiHiddenConfig().setHSplitPosition(hSplitPane.getDividerLocation());
        model.getConfig().getGuiHiddenConfig().setVSplitPosition(vSplitPane.getDividerLocation());
        
        model.save();
        
        //salvar o projeto 
        if ( (model.getProject() != null) && model.getProject().getStatus() == Project.UNSAVED )  {
            int res = JOptionPane.showConfirmDialog(model.getGui().getCaptorWindow(), "Is there an unsaved project opened by editor.\nDo you wish to save it before exit the application?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if ( res == JOptionPane.OK_OPTION )  {
                ProjectSystem pj = new ProjectSystem(model);
                boolean ret = pj.save();
                if ( ! ret )  {
                    return;
                }
            }
        }
        
        //fechar a janela
        close();
    }
    
    //-------------------------------------------------------------------------
    
    public void update(Observable observable, Object obj)  {
        if ( obj.equals(Constant.EXIT) )  {
            exit();
        }
        else if ( obj.equals(Constant.SAVE_MODEL) )  {
            saveModel();
        }
        else if ( obj.equals(Constant.SHOW_NAVIGATOR) )  {
            vSplitPane.setDividerLocation(verticalBarPosition);
            vSplitPane.setEnabled(true);
        }
        else if ( obj.equals(Constant.HIDE_NAVIGATOR) )  {
            verticalBarPosition = vSplitPane.getDividerLocation();
            vSplitPane.setDividerLocation(28);
            vSplitPane.setEnabled(false);
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    private void checkPermissions(String installPath)  {
        
        File path = new File(installPath);
        boolean flag = false;
        
        File config = new File(path, "config");
        if ( !config.canWrite() )  {
            checkPermissionError(config);
            flag = true;
        }
        
        File projects = new File(path, "projects");
        if ( !projects.canWrite() )  {
            checkPermissionError(projects);
            flag = true;
        }
        
        if ( flag )  {
            System.exit(0);
        }
    }
    
    //---------------------------------------------------------------------
    
    private void checkPermissionError(File file)  {
        JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), StringUtil.formatMessage(MyIntl.MSG83, file.getAbsolutePath()));
    }
    
    //---------------------------------------------------------------------
}
