/*
 *
 */
package captor.modelsystem;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JTree;

import captor.domainsystem.DomainSystem;
import captor.lib.def.Constant;
import captor.modelsystem.gui.GUIControl;
import captor.modelsystem.gui.GuiView;
import captor.windowsystem.MainWindow;


/**
 * This class handles the model element that control gui behavior.
 * 
 * @author Kicho
 *
 */
public class GUI extends Observable {
    
    private GUIControl guiControl;
    private GuiView guiView;

    private JTree tree;
    private MainWindow captorWindow;
    private Model model;
    private JFrame buildWindow;

    public GUI(Model model)  {
        this.model = model;
        
        guiControl = new GUIControl();
        guiView = new GuiView();
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the fitWindow.
     */
    public MainWindow getCaptorWindow() {
        return captorWindow;
    }
    /**
     * @return Returns the buildWindow.
     */
    public JFrame getBuildWindow() {
        return buildWindow;
    }
    /**
     * @param buildWindow The buildWindow to set.
     */
    public void setBuildWindow(JFrame buildWindow) {
        this.buildWindow = buildWindow;
    }
    /**
     * @param fitWindow The fitWindow to set.
     */
    public void setCaptorWindow(MainWindow fitWindow) {
        this.captorWindow = fitWindow;
    }
    /**
     * @return Returns the tree.
     */
    public JTree getTree() {
        return tree;
    }
    /**
     * @param tree The tree to set.
     */
    public void setTree(JTree tree) {
        this.tree = tree;
    }

    /**
     * @return Returns the guiView.
     */
    public GuiView getGuiView() {
        return guiView;
    }
    /**
     * @param guiView The guiView to set.
     */
    public void setGuiView(GuiView guiView) {
        this.guiView = guiView;
    }
    /**
     * @return Returns the production.
     */
    /**
     * @return Returns the guiControl.
     */
    public GUIControl getGuiControl() {
        return guiControl;
    }
    /**
     * @param guiControl The guiControl to set.
     */
    public void setGuiControl(GUIControl guiControl) {
        this.guiControl = guiControl;
    }

    //-------------------------------------------------------------------------
    
    public void loadGuiDomain()  {
        String path = model.getConfig().getSystemConfig().getInstallPath();
        path = path.concat(System.getProperty("file.separator"));
        path = path.concat("domains");
        path = path.concat(System.getProperty("file.separator"));
        path = path.concat(model.getProject().getDomain());
        path = path.concat(System.getProperty("file.separator"));
        path = path.concat(model.getProject().getDomain());
        path = path.concat(".domain");
        
        DomainSystem d = new DomainSystem(model);
        try {
            d.loadGuiDomain(path);
        } catch (RuntimeException e) {
            model.getGui().getGuiView().setErrorView("<b><font color=\"#FF0000\">Cannot load domain.</font></b><br>");
        }

        setChanged();
        notifyObservers(Constant.LOAD_DOMAIN);
    }
   
    //-------------------------------------------------------------------------

}
