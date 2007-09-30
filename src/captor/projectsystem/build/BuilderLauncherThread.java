/*
 *
 */
package captor.projectsystem.build;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.projectsystem.build.buildutil.AntRunner;
import captor.projectsystem.util.LongTask;

/**
 * @author Kicho
 *
 */
public class BuilderLauncherThread extends Thread {

    private Model model;
    private LongTask task;
    
    public BuilderLauncherThread(Model model, LongTask task)  {
        this.model = model;
        this.task = task;
    }
    
    public void run()  { 
        BuildProject bp = new BuildProject(model, task);
        
        try {

            AntRunner ac = new AntRunner(model);
            ac.preCall();
            
            boolean res = bp.build();
            if ( !res )
            	task.setError(true);
            
            task.setDone(true);
            if ( !task.hasError() )  {
                ac.posCall();
            }
            
        } catch (Exception e) {
            task.setDone(true);
            task.setError(true);
            
            String msg = MyIntl.MSG2 + e;
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), msg);
        }
        
    }
    
}
