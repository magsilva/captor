package captor.modelsystem;

import java.util.Observable;

import captor.lib.util.system.SystemConfig;
import captor.modelsystem.config.GUIConfig;
import captor.modelsystem.config.GUIHiddenConfig;
import captor.modelsystem.config.ProjectDefaultConfig;


/**
 * This class holds all application configuration information.
 * 
 * <p>
 * The guiConfig class hold the lokk and feel installed.<br>
 * It will be improved in the same way as user needs.
 * </p>
 * 
 * <p>
 * The GUIHiddenConfig holds information about the state of the window like current
 * x and y position, if the window is maximized, panel divider position and other stuffs
 * that improve the tool usability.
 * </p>
 * 
 * @author Kicho
 *
 */
public class Config extends Observable  {

    private GUIConfig guiConfig;
    private GUIHiddenConfig guiHiddenConfig;
    private SystemConfig systemConfig;
    private ProjectDefaultConfig projectDefaultConfig;
    private boolean production;
    
    public Config(String installPath, Model model, boolean production)  {
        systemConfig = new SystemConfig(installPath);
        guiHiddenConfig = new GUIHiddenConfig(model);
        guiConfig = new GUIConfig(model);
        this.production = production;
        projectDefaultConfig = new ProjectDefaultConfig(model);
    }
    
    //-------------------------------------------------------------------------

    public void load()  {
        systemConfig.load(production);
        guiHiddenConfig.load(production);        
        guiConfig.load(production);
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the systemConfig.
     */
    public SystemConfig getSystemConfig() {
        return systemConfig;
    }
    /**
     * @param systemConfig The systemConfig to set.
     */
    public void setSystemConfig(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    /**
     * @return Returns the guiConfiguration.
     */
    public GUIConfig getGuiConfig() {
        return guiConfig;
    }
    /**
     * @param guiConfiguration The guiConfiguration to set.
     */
    public void setGuiConfig(GUIConfig guiConfiguration) {
        this.guiConfig = guiConfiguration;
        setChanged();
        notifyObservers(this);
    }
    /**
     * @return Returns the guiHiddenConfiguration.
     */
    public GUIHiddenConfig getGuiHiddenConfig() {
        return guiHiddenConfig;
    }
    /**
     * @param guiHiddenConfiguration The guiHiddenConfiguration to set.
     */
    public void setGuiHiddenConfig(GUIHiddenConfig guiHiddenConfiguration) {
        this.guiHiddenConfig = guiHiddenConfiguration;
        setChanged();
        notifyObservers(this);
    }
    
    //-------------------------------------------------------------------------

    /**
     * @return Returns the projectDefaultConfig.
     */
    public ProjectDefaultConfig getProjectDefaultConfig() {
        return projectDefaultConfig;
    }
    /**
     * @param projectDefaultConfig The projectDefaultConfig to set.
     */
    public void setProjectDefaultConfig(
            ProjectDefaultConfig projectDefaultConfig) {
        this.projectDefaultConfig = projectDefaultConfig;
        setChanged();
        notifyObservers(this);
    }
    
    //-------------------------------------------------------------------------
}
