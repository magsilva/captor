/*
 *
 */
package captor.projectsystem;



/**
 * @author Kicho
 *
 */
public interface IProjectSystem {

    public void openProject();
    public void openProject(String path);    
    public boolean validate();
    public boolean save();
    public void saveAs(String name, String baseDir, String outputDir);    public void showProperties();
    public void build();
    public void clean();
    public boolean closeProject();
    
}
