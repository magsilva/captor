package captor.modelsystem.gui;

import java.util.Observable;

import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.def.Constant;
import captor.windowsystem.formcomponent.FormComponent;


/**
 * This bean control the application GUI behavior in a MVC architecture.
 * 
 * <p>
 * It is used by windowsystem components clients to inform about the 
 * window behavior changes.
 * </p>
 *
 * <p>
 * For example: If the user clicks in some node in the navigation panel, 
 * the body panel must responds showing the rigth form to the user.
 * </p>
 * 
 * <p>
 * The navigation panel will never invoke the body panel or any other 
 * component directly. Instead the client should only change a GuiControl 
 * atribute.
 * </p>
 * 
 * <p>
 * The notification propagation system will take care to notify all interesteds
 * in the model change.  
 * </p>
 *   
 * @author Kicho
 */
public class GUIControl extends Observable  {

    private boolean showNewProjectWindow;
    private boolean exit;
    private boolean closeProject;
    private boolean loadPattern;
    private boolean loadedPattern;
    private boolean saveModel;
    private boolean hideNavigator;
    
    private FormComponent formError;
    private DefaultMutableTreeNode nodeError;
    
    public GUIControl() {
        exit = false;
    }

    /**
     * @return Returns the hideNavigator.
     */
    public boolean isHideNavigator() {
        return hideNavigator;
    }
    /**
     * @param hideNavigator The hideNavigator to set.
     */
    public void setHideNavigator(boolean hideNavigator) {
        this.hideNavigator = hideNavigator;
        setChanged();
        if ( hideNavigator )
            notifyObservers(Constant.SHOW_NAVIGATOR);
        else
            notifyObservers(Constant.HIDE_NAVIGATOR);
    }
    /**
     * @return Returns the loadedPattern.
     */
    public boolean isLoadedPattern() {
        return loadedPattern;
    }
    /**
     * @param loadedPattern The loadedPattern to set.
     */
    public void setLoadedPattern(boolean loadedPattern) {
        this.loadedPattern = loadedPattern;
        setChanged();
        notifyObservers(Constant.LOADED_FORM);
    }
    /**
     * @return Returns the loadPattern.
     */
    public boolean getLoadPattern() {
        return loadPattern;
    }
    /**
     * @param loadPattern The loadPattern to set.
     */
    public void setLoadPattern(boolean loadPattern) {
        this.loadPattern = loadPattern;
        setChanged();
        notifyObservers(Constant.LOAD_FORM);
    }
    /**
     * @return Returns the closeProject.
     */
    public boolean getCloseProject() {
        return closeProject;
    }
    /**
     * @param closeProject The closeProject to set.
     */
    public void setCloseProject(boolean closeProject) {
        this.closeProject = closeProject;
        setChanged();
        notifyObservers(Constant.CLOSE_PROJECT);
    }
    /**
     * @return Returns the exit.
     */
    public boolean getExit() {
        return exit;
    }
    /**
     * @param exit The exit to set.
     */
    public void setExit(boolean exit) {
        this.exit = exit;
        setChanged();
        notifyObservers(Constant.EXIT);
    }
    /**
     * @return Returns the showNewProject.
     */
    public boolean getShowNewProjectWindow() {
        return showNewProjectWindow;
    }
    /**
     * @return Returns the saveModel.
     */
    public boolean isSaveModel() {
        return saveModel;
    }
    /**
     * @param saveModel The saveModel to set.
     */
    public void setSaveModel(boolean saveModel) {
        this.saveModel = saveModel;
        setChanged();
        notifyObservers(Constant.SAVE_MODEL);
    }
    /**
     * @return Returns the formError.
     */
    public FormComponent getFormError() {
        return formError;
    }
    /**
     * @param formError The formError to set.
     */
    public void setFormError(FormComponent formError) {
        this.formError = formError;
    }
    
    /**
     * @return Returns the nodeError.
     */
    public DefaultMutableTreeNode getNodeError() {
        return nodeError;
    }
    /**
     * @param nodeError The nodeError to set.
     */
    public void setNodeError(DefaultMutableTreeNode nodeError) {
        this.nodeError = nodeError;
    }
}
