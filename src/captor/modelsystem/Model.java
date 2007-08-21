package captor.modelsystem;

import java.util.Observable;

/**
 *
 * This class has pointers to all model elements in the MVC archtecture used
 * to build the main application window.
 *
 * @author Kicho
 */
public class Model extends Observable  {
    
    //very private attributes
    private String name;
    private boolean production;
    
    private Project project;
    private Config config;
    
    private GUI gui;
    
    private Util util;
    
    public Model() {
    }
    
    //-------------------------------------------------------------------------

    public void load(String installPath)  {
        production = true;
        name = "FIT Model";
        
        
        //inicia as configurações
        config = new Config(installPath, this, production);
        config.load();
        
        //inicia o modelo dos componentes gui do MVC
        gui = new GUI(this);
        util = new Util();
        
        //projeto corrent
        project = null;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the gui.
     */
    public GUI getGui() {
        return gui;
    }
    /**
     * @param gui The gui to set.
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }
    /**
     * @return Returns the config.
     */
    public Config getConfig() {
        return config;
    }
    /**
     * @param config The config to set.
     */
    public void setConfig(Config config) {
        this.config = config;
    }
    public void save()  {
        config.getGuiHiddenConfig().save();        
        config.getGuiConfig().save();
    }
    public boolean isProduction() {
        return production;
    }
    /**
     * @param production The production to set.
     */
    public void setProduction(boolean production) {
        this.production = production;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers(this);
    }
    /**
     * @return Returns the project.
     */
    public Project getProject() {
        return project;
    }
    /**
     * @param project The project to set.
     */
    public void setProject(Project project) {
        this.project = project;
    }
    /**
     * @return Returns the util.
     */
    public Util getUtil() {
        return util;
    }
    /**
     * @param util The util to set.
     */
    public void setUtil(Util util) {
        this.util = util;
    }

    //-------------------------------------------------------------------------
}
