package captor.lib.util.system;

import java.io.File;
import java.io.FileInputStream;
import java.util.Observable;
import java.util.Properties;

public class SystemConfig extends Observable {

    private String installPath;
    private String projectPath;
    private String configPath;
    private String domainPath;
    private String projectDefaultConfigPath;
    private String hiddenConfigPropertiesPath, hiddenConfigPropertiesDefaultPath;
    private String fitPropertiesPath, fitPropertiesDefaultPath;
    
    private String xmlEncoding;
    private String xmlVersion;
    
    private Properties applicationProps;
    
    /**
     * 
     */
    public SystemConfig(String installPath) {
        this.installPath = installPath;

        this.xmlEncoding = "";
        this.xmlVersion = "";
    }

    /**
     * @return Returns the domainPath.
     */
    public String getDomainPath() {
        return domainPath;
    }
    /**
     * @param domainPath The domainPath to set.
     */
    public void setDomainPath(String domainPath) {
        this.domainPath = domainPath;
    }
    /**
     * @return Returns the xmlVersion.
     */
    public String getXmlVersion() {
        return xmlVersion;
    }
    /**
     * @param xmlVersion The xmlVersion to set.
     */
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
    }
    /**
     * @return Returns the xmlEncoding.
     */
    public String getXmlEncoding() {
        return xmlEncoding;
    }
    /**
     * @param xmlEncoding The xmlEncoding to set.
     */
    public void setXmlEncoding(String xmlEncoding) {
        this.xmlEncoding = xmlEncoding;
    }
    /**
     * @param installPath The installPath to set.
     */
    public void setInstallPath(String installPath) {
        this.installPath = installPath;
    }
    /**
     * @return Returns the hiddenConfigPropertiesPath.
     */
    public String getHiddenConfigPropertiesPath() {
        return hiddenConfigPropertiesPath;
    }
    /**
     * @param hiddenConfigPropertiesPath The hiddenConfigPropertiesPath to set.
     */
    public void setHiddenConfigPropertiesPath(String hiddenConfigPropertiesPath) {
        this.hiddenConfigPropertiesPath = hiddenConfigPropertiesPath;
    }
    /**
     * @return Returns the hiddenConfigPropertiesDefaultPath.
     */
    public String getHiddenConfigPropertiesDefaultPath() {
        return hiddenConfigPropertiesDefaultPath;
    }
    /**
     * @param hiddenConfigPropertiesDefaultPath The hiddenConfigPropertiesDefaultPath to set.
     */
    public void setHiddenConfigPropertiesDefaultPath(
            String hiddenConfigPropertiesDefaultPath) {
        this.hiddenConfigPropertiesDefaultPath = hiddenConfigPropertiesDefaultPath;
    }
    /**
     * @return Returns the projectPropertiesDefaultPath.
     */
    public String getProjectPropertiesDefaultPath() {
        return projectDefaultConfigPath;
    }
    /**
     * @param projectPropertiesDefaultPath The projectPropertiesDefaultPath to set.
     */
    public void setProjectPropertiesDefaultPath(
            String projectPropertiesDefaultPath) {
        this.projectDefaultConfigPath = projectPropertiesDefaultPath;
    }
    /**
     * @return Returns the configPath.
     */
    public String getEtcPath() {
        return configPath;
    }
    /**
     * @param configPath The configPath to set.
     */
    public void setEtcPath(String configPath) {
        this.configPath = configPath;
    }
    
    /**
     * @return Returns the projectDefaultConfigPath.
     */
    public String getProjectDefaultConfigPath() {
        return projectDefaultConfigPath;
    }
    /**
     * @param projectDefaultConfigPath The projectDefaultConfigPath to set.
     */
    public void setProjectDefaultConfigPath(String projectDefaultConfigPath) {
        this.projectDefaultConfigPath = projectDefaultConfigPath;
    }
    /**
     * @return Returns the projectPath.
     */
    public String getProjectPath() {
        return projectPath;
    }
    /**
     * @param projectPath The projectPath to set.
     */
    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
    /**
     * @return Returns the installPath.
     */
    public String getInstallPath() {
        return installPath;
    }
    /**
     * @param installPath The installPath to set.
     */

    
    /**
     * @return Returns the fitPropertiesDefaultPath.
     */
    public String getFitPropertiesDefaultPath() {
        return fitPropertiesDefaultPath;
    }
    /**
     * @param fitPropertiesDefaultPath The fitPropertiesDefaultPath to set.
     */
    public void setFitPropertiesDefaultPath(String fitPropertiesDefaultPath) {
        this.fitPropertiesDefaultPath = fitPropertiesDefaultPath;
    }
    /**
     * @return Returns the fitPropertiesPath.
     */
    public String getFitPropertiesPath() {
        return fitPropertiesPath;
    }
    /**
     * @param fitPropertiesPath The fitPropertiesPath to set.
     */
    public void setFitPropertiesPath(String fitPropertiesPath) {
        this.fitPropertiesPath = fitPropertiesPath;
    }
    
    public void load(boolean production)  {
        
        String separator = System.getProperty("file.separator");

        projectPath = installPath.concat(separator + "projects" + separator);
        
        configPath = installPath.concat(separator + "config" + separator);
        projectDefaultConfigPath = installPath.concat(separator + "config" + separator + "project_config.properties.default");
        hiddenConfigPropertiesDefaultPath = installPath.concat(separator + "config" + separator + "hidden_config.properties.default");
        hiddenConfigPropertiesPath = installPath.concat(separator + "config" + separator + "hidden_config.properties");
        fitPropertiesPath = installPath.concat(separator + "config" + separator + "fit.properties");
        fitPropertiesDefaultPath = installPath.concat(separator + "config" + separator + "fit.properties.default");
        domainPath = installPath.concat(separator + "domains");
        projectDefaultConfigPath = installPath.concat(separator + "config" + separator + "project_default_config.properties.default");
        if ( production )  {
            String path = installPath.concat(separator + "config" + separator + "generator.properties.default");
            
            Properties defaultProps;
            try  {
                defaultProps = new Properties();
                FileInputStream in = new FileInputStream(path);
                defaultProps.load(in);
                in.close();        
                
                applicationProps = new Properties(defaultProps);
                path = installPath.concat(separator + "config" + separator + "generator.properties");
                
                File file = new File(path);
                //o arquivo não existe. pod deixar usando o defalut.
                if ( !file.exists() )  {
                    xmlVersion = defaultProps.getProperty("xmlVersion");
                    xmlEncoding = defaultProps.getProperty("xmlEncoding");
                    return;
                }
                
                in = new FileInputStream(path);
                applicationProps.load(in);
                in.close();
            }
            catch(Exception e)  {
                System.out.println("Captor Exception: Cannot open properties files. Check if the files installPath/config/properties.files exist.\n" + e);
                return;
            }
            
            xmlVersion = applicationProps.getProperty("xmlVersion");
            xmlEncoding = applicationProps.getProperty("xmlEncoding");
        }
        else  {
            xmlEncoding = "ISO-8859-1";
            xmlVersion = "1.0";
        }
        
    }
    
}
