package captor.modelsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Observable;
import java.util.Properties;

import captor.domainsystem.FormsType;
import captor.lib.def.Constant;
import captor.lib.formtree.FormTree;
import captor.lib.util.StringUtil;

/**
 * This class represents the project been used by the user.
 * 
 * <p>
 * All data inserted in the new project wizard like project name,
 * project directory and so on are stored here.
 * </p>
 * 
 * @author Kicho
 */
public class Project extends Observable  {
    
    public static final int CLOSED = 1;
    public static final int SAVED = 2;
    public static final int UNSAVED = 3;
    
    //properties
    private String name;
    private String domain;
    private String path, inputFolder, outputFolder;
    private int status;
    
    //internal use
    private Properties applicationProps;
    private Model model;
    private FormsType forms;
    
    private boolean overwriteResources;
    
    public Project(Model model) {
        this.model = model;
        this.status = SAVED;
        overwriteResources = true;
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the domain.
     */
    public FormsType getFormsType() {
        return forms;
    }
    /**
     * @param patterns The patterns to set.
     */
    public void setFormsType(FormsType forms) {
        this.forms = forms;
        setChanged();
        notifyObservers(this);
    }
    /**
     * @return Returns the inputFolder.
     */
    public String getInputFolder() {
        return inputFolder;
    }
    /**
     * @param inputFolder The inputFolder to set.
     */
    public void setInputFolder(String folder) {
        this.inputFolder = folder;
    }
    /**
     * @return Returns the outputFolder.
     */
    public String getOutputFolder() {
        return outputFolder;
    }
    /**
     * @param outputFolder The outputFolder to set.
     */
    public void setOutputFolder(String folder) {
        this.outputFolder = folder;
    }
    /**
     * @return Returns the status.
     */
    public int getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(int status) {
        this.status = status;
        if ( status == CLOSED )  {
            setChanged();
            notifyObservers(Constant.CLOSE_PROJECT);
        }
    }
    /**
     * @return Returns the domain.
     */
    public String getDomain() {
        return domain;
    }
    /**
     * @param domain The domain to set.
     */
    public void setDomain(String domain) {
        this.domain = domain;
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
    }
    
    /**
     * @return Returns the overwriteResources.
     */
    public boolean getOverwriteResources() {
        return overwriteResources;
    }
    /**
     * @param overwriteResources The overwriteResources to set.
     */
    public void setOverwriteResources(boolean overwriteResources) {
        this.overwriteResources = overwriteResources;
    }
    /**
     * @return Returns the path.
     */
    public String getPath() {
        return path;
    }
    /**
     * @param path The path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    //-------------------------------------------------------------------------

    public void loadDefault(boolean production)  {
        
        String ppath = model.getConfig().getSystemConfig().getProjectPropertiesDefaultPath();
        if ( production )  {
            Properties defaultProps;
            try  {
                defaultProps = new Properties();
                FileInputStream in = new FileInputStream(ppath);
                defaultProps.load(in);
                in.close();        
                
                applicationProps = new Properties(defaultProps);
                name = applicationProps.getProperty("name");
                domain = applicationProps.getProperty("domain");
                path = applicationProps.getProperty("path");
                inputFolder = applicationProps.getProperty("inputFolder");
                outputFolder = applicationProps.getProperty("outputFolder");
                
                try {
                    overwriteResources = new Boolean(applicationProps.getProperty("overwriteResources")).booleanValue();
                } catch (RuntimeException e1) {
                    overwriteResources = true;
                }
                status = SAVED;
            }
            catch(Exception e)  {
                model.getGui().getGuiView().setErrorView("Captor Exception: Cannot open properties files.<br>Check if the files " + ppath + " exists.<br>");
                return;
            }
        } else {
            path = System.getProperty("user.home");
            name = "Blank project";
            domain = "GRN";
            inputFolder = path + File.separator + "input";
            outputFolder = path + File.separator + "output";
            status = SAVED;
            overwriteResources = true;
        }
        
    }
    
    //-------------------------------------------------------------------------

    public void load(String projectFilePath) {
        
        String ppath = model.getConfig().getSystemConfig().getProjectPropertiesDefaultPath();
        
        Properties defaultProps;
        try  {
            defaultProps = new Properties();
            FileInputStream in = new FileInputStream(ppath);
            defaultProps.load(in);
            in.close();        
            
            applicationProps = new Properties(defaultProps);
            
            File file = new File(projectFilePath);
            if ( !file.exists() )  {
                applicationProps = defaultProps;
            }
            else  {
                in = new FileInputStream(projectFilePath);
                applicationProps.load(in);
                in.close();
            }
        }
        catch(Exception e)  {
            return;
        }
        
        name = applicationProps.getProperty("name");
        domain = applicationProps.getProperty("domain");
        outputFolder = applicationProps.getProperty("outputFolder");
        
        try {
            overwriteResources = new Boolean(applicationProps.getProperty("overwriteResources")).booleanValue();
        } catch (RuntimeException e1) {
            overwriteResources = true;
        }
        
        File file = new File(projectFilePath);
        path = file.getParent();
        String separator = System.getProperty("file.separator");
        inputFolder = path.concat(separator).concat("input");
        
        status = SAVED;
        setChanged();
        notifyObservers(Constant.LOAD_PROJECT);
    }
    
    //-------------------------------------------------------------------------

    public void save()  {
        String separator = System.getProperty("file.separator");
        String ppath = path.concat(separator).concat(name).concat(".cap");
        
        if ( status != CLOSED && applicationProps != null )  {
            try  {
                FileOutputStream out = new FileOutputStream(ppath);
                
                applicationProps.put("name", name);
                applicationProps.put("domain", domain);
                applicationProps.put("outputFolder", outputFolder);
                applicationProps.put("overwriteResources", new Boolean(overwriteResources).toString());
                
                applicationProps.store(out, "---DO NOT EDIT THIS FILE---");
                out.close();        
            }
            catch(Exception e)  {
                model.getGui().getGuiView().setErrorView("Captor Exception: Cannot save project properties file: " + ppath + "<br><br>" + StringUtil.formatOutput(e.toString()));
                e.printStackTrace();
                return;
            }
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    public FormTree getPatternTree()  {
        FormTree pt = new FormTree(model);
        pt.create();
        return pt;
    }
}
