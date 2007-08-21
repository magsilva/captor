/*
 *
 */
package captor.windowsystem.projectmanager.build;

import captor.modelsystem.Model;
import captor.projectsystem.util.LongTask;

/**
 * @author Kicho
 *
 */
public class ProgressLauncher extends Thread {

    private BuildProgressWindow bp;
    
    public ProgressLauncher(Model model, LongTask task)  {
        bp = new BuildProgressWindow(task, model);
    }
    
    public void run()  {
        bp.setVisible(true);
        bp.play();
    }
    
}
