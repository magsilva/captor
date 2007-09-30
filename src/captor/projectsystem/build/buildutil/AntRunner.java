/*
 *
 */
package captor.projectsystem.build.buildutil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class AntRunner {
    
    private Model model;
    private Project project;
    
    public AntRunner(Model model)  {
        this.model = model;
        System.out.println("----------");
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("CLASSPATH"));
        System.out.println(System.getenv("ANT_HOME"));
        System.out.println(System.getenv("PATH"));
    }

    //-------------------------------------------------------------------------

    public void posCall() throws Exception  {
        try {
            call("pos-build.xml");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //-------------------------------------------------------------------------

    public void preCall() throws Exception  {
        try {
            call("pre-build.xml");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void call(String buildFileName) throws Exception {
        try
        {
            String separator = System.getProperty("file.separator");
            String path;
            String bf;
            
            path = model.getProject().getPath();
            
            File file = new File(path, buildFileName);
            if ( !file.exists() )  {
                path = model.getConfig().getSystemConfig().getInstallPath();
                path = path.concat(separator);
                path = path.concat("domains");
                path = path.concat(separator);
                path = path.concat(model.getProject().getDomain());
            }
            
            bf = path.concat(separator);
            bf = bf.concat(buildFileName);
            file = new File(path, buildFileName);
            if ( !file.exists() )  {
                return;
            }
            
            
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_ANTRUNNER_1);

            //pre-processamento do arquivo build.xml
            //colocar uma variavel (project_path) com o valor do path do projeto
            bf = bf.replaceAll("\\\\", "/");
            bf = bf.replaceAll("//", "/");
            model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_ANTRUNNER_2, bf));
            updateProjectPath(file);
            
            init(bf, path);
            //properties
            HashMap m = new HashMap();
            m.put("event", "test");
            m.put("subject", "sujet java 3");
            m.put("message", "message java 3");
            setProperties(m, false);
            
            //run default target
            if  ( runTarget(null) )  {
                model.getGui().getGuiView().setConsoleView(MyIntl.VE_ANTRUNNER_4);
            }
            else  {
                model.getGui().getGuiView().setConsoleView(MyIntl.VE_ANTRUNNER_5);
                return;
            }
        } catch (Exception e) { 
            model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_ANTRUNNER_3, StringUtil.formatOutput(e.toString())));
            return;
        }
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * Initializes a new Ant Project.
     * @(protected) _buildFile The build File to use. If none is provided, it will
     be defaulted to "build.xml".
     * @(protected) _baseDir The project's base directory. If none is provided, will
     be defaulted to "." (the current directory).
     * @(protected) Exception Exceptions are self-explanatory (read their Message)
     */
    public void init(String _buildFile, String _baseDir) throws Exception  {
        // Create a new project, and perform some default initialization
        project = new Project();
        try { 
            project.init(); 
        }
        catch (BuildException e) { 
            throw new Exception("The default task list could not be loaded.");
        }
        
        // Set the base directory. If none is given, "." is used.
        if ( _baseDir == null ) 
            _baseDir=new String(".");
        
        try { 
            project.setBasedir(_baseDir); 
        }
        catch (BuildException e)        { 
            throw new Exception("The given basedir: " + _baseDir + " doesn't exist, or isn't a directory."); 
        }
        
        // Parse the given buildfile. If none is given, "build.xml" is used.
        if (_buildFile == null) 
            _buildFile = new String("build.xml");
        
        try {
            ProjectHelper.getProjectHelper().parse(project, new File(_buildFile)); }
        catch (BuildException e){
            throw new Exception("Configuration file " + _buildFile + " is invalid, or cannot be read.\n" + e);
            
        }
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * Sets the project's properties.
     * May be called to set project-wide properties, or just before a target
     call to set target-related properties only.
     * @(protected) _properties A map containing the properties' name/value couples
     * @(protected) _overridable If set, the provided properties values may be
     overriden by the config file's values
     * @(protected) Exception Exceptions are self-explanatory (read their Message)
     */
    public void setProperties(Map _properties, boolean _overridable) throws Exception {
        
        // Test if the project exists
        if (project == null) 
            throw new Exception("Properties cannot be set because the project has not been initialized. Please call the 'init' method first !");
        
        // Property hashmap is null
        if (_properties == null) 
            throw new Exception("The provided property map is null.");
        
        // Loop through the property map
        Set propertyNames = _properties.keySet();
        Iterator iter = propertyNames.iterator();
        while (iter.hasNext()) {
            
            // Get the property's name and value
            String propertyName =  (String) iter.next();
            String propertyValue = (String) _properties.get(propertyName);
            if (propertyValue == null) 
                continue;
            
            // Set the properties
            if (_overridable) 
                project.setProperty(propertyName, propertyValue);
            else 
                project.setUserProperty(propertyName, propertyValue);
        }
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * Runs the given Target.
     * @(protected) _target The name of the target to run. If null, the project's
     default target will be used.
     * @(protected) Exception Exceptions are self-explanatory (read their Message)
     */
    public boolean runTarget(String _target) throws Exception    {
        // Test if the project exists
        if (project == null) 
            throw new Exception("No target can be launched because the project has not been initialized. Please call the 'init' method first !");
        
        // If no target is specified, run the default one.
        if (_target == null) 
            _target = project.getDefaultTarget();
        
        // Run the target
        try  {
            project.executeTarget(_target);  
        }
        catch (BuildException e)        { 
            model.getGui().getGuiView().setConsoleView(StringUtil.formatOutput(e.getMessage()));
            return false;
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    public void updateProjectPath(File file)  {
        String content = "";
        try {
            content = FileUtils.readFileToString(file, "ISO-8859-1");
        } catch (IOException e) {
            model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_ANTRUNNER_6, file.getAbsolutePath()));
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(e.toString()) + "<br>");
        }
        
        if ( model.getProject() != null && model.getProject().getPath() != null )  {       
            
            String []lines = content.split("\n");
            for ( int i = 0; i < lines.length; i++ )  {
                lines[i] = lines[i].concat("\n");
            }
            
            String pathLine = "<property name=\"project_path\" location=\"" + model.getProject().getPath() + "\"/>\n";
            String outputLine = "<property name=\"project_output_path\" location=\"" + model.getProject().getOutputFolder() + "\"/>\n";
            String installLine = "<property name=\"install_path\" location=\"" + model.getConfig().getSystemConfig().getInstallPath() + "\"/>\n";
            String projectLine = "<property name=\"project_name\" value=\"" + model.getProject().getName() + "\"/>\n";
            
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
            int interaction = root.getChildCount();
            String []s = new String[interaction];
            for ( int j = 0; j < interaction; j++ )  {
                s[j] = "<property name=\"interaction_" + j + "\" value=\"" + j + "\"/>\n";
            }
            
            StringBuffer sb = new StringBuffer("");
            try {
                for ( int i = 0; i < lines.length; i++ )  {
                    if ( lines[i].length() >= 26 && lines[i].substring(0,26).equals("<!--PROJECT_GENERATED_DATA") )  {
                        i++;
                        while ( lines[i].length() < 26 || !lines[i].substring(0,26).equals("<!--PROJECT_GENERATED_DATA") )  {
                            i++;
                        }
                        sb.append("<!--PROJECT_GENERATED_DATA - DO_NOT_EDIT-->\n");
                        sb.append(pathLine);
                        sb.append(outputLine);
                        sb.append(installLine);
                        sb.append(projectLine);
                        for ( int j = 0; j < interaction; j++ )  {
                            sb.append(s[j]);
                        }
                        sb.append("<!--PROJECT_GENERATED_DATA - DO_NOT_EDIT-->\n");
                    }
                    else  {
                        sb.append(lines[i]);
                    }
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            
            try {
                FileUtils.writeStringToFile(file, sb.toString(), "ISO-8859-1");
            } catch (IOException e1) {
                
                model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_ANTRUNNER_7, file.getAbsolutePath()));
                model.getGui().getGuiView().setErrorView(MyIntl.VE_ANTRUNNER_8 + StringUtil.formatOutput(e1.toString()) + "<br>");
            }
        }
        
    }    
    
    //-------------------------------------------------------------------------
}