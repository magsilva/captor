package captor;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.swing.UIManager;

import captor.lib.intl.MyIntlEnglish;
import captor.lib.intl.MyIntlPortuguese;
import captor.lib.util.FITPrintStream;
import captor.modelsystem.Model;
import captor.windowsystem.MainWindow;
import captor.windowsystem.util.IconUtil;
import java.lang.Math;
/**
 * 
 * This class initialize a new application.
 * 
 * <p>
 * It can receive an argument representing the installPath
 * or can be called without arguments.
 * </p>
 * 
 * <p>
 * If the installPath argument is not set, the main method
 * will try to find out the installPath by itself.
 * </p>
 *
 * @author Kicho
 */
public class Captor {
    
    //---------------------------------------------------------------------
    
    public static void main(String[] args)  {
        
        //getting installPath
        String installPath = new File(".").getAbsolutePath();
        int size = installPath.length();
        if ( installPath.substring(size -1, size).equals(".") )
            installPath = installPath.substring(0, size - 1);
        
        //checking installPath
        installPath = installPath.replaceAll("\"", "");
        File file = new File(installPath);
        if ( ! file.exists() )  {
            System.out.println("Error:");
            System.out.println("The directory " + installPath + " doesn't exist.");
            System.exit(0);
        }
        
        if ( ! file.isDirectory() )  {
            System.out.println("Error:");
            System.out.println("The parameter " + installPath + " isn't a valid directory.");
            System.exit(0);
        }
        
        //---------------------------------------------------------------------
        
        if ( args.length > 0 )  {
            if ( args[0].equals("pt") )  {
                MyIntlPortuguese.load();
            }
            else if ( args[0].equals("en") )  {
                MyIntlEnglish.load();
            }
            else  {
                MyIntlEnglish.load();
            }
        }
        else  {
            MyIntlEnglish.load();
        }
        
        //Model creation. 
        //This is an important object that almost everybody will use it.
        Model model = new Model();
        model.load(installPath);
        IconUtil.setJarFileName(installPath + "lib\\res.jar");
        
        //---------------------------------------------------------------------
        
        //install look and feel
        installLookAndFeel(model);
        
        //---------------------------------------------------------------------
        
        //main window creation
        MainWindow frame = new MainWindow(model);
        frame.setVisible(true);
        
        //start the log system (deprecated)
        startLog(model);

          //automaticly open the last opened project.
//        ProjectSystem pm = new ProjectSystem(model); 
//        pm.openProject(model.getConfig().getGuiHiddenConfig().getLastOpenProject1());
    }
    
    //---------------------------------------------------------------------
    
    //Este método redireciona a saída System.err para a um elemento da GUI
    private static void startLog(Model model)  {
      BufferedOutputStream bos = new BufferedOutputStream(new ByteArrayOutputStream());
      new FITPrintStream(model, bos, true);
    }
    
    //---------------------------------------------------------------------
    
    private static void installLookAndFeel(Model model)  {
        try  {
            boolean flag = false;
            UIManager.LookAndFeelInfo[] installed = UIManager.getInstalledLookAndFeels();
            
            for (int i = 0; (i < installed.length && !flag); i++) {
                String name = installed[i].getClassName();
                if ( name.equals(model.getConfig().getGuiConfig().getLookAndFeel()) )  {
                    flag = true;
                }
            }        
            
            if ( flag )  {
                UIManager.setLookAndFeel(model.getConfig().getGuiConfig().getLookAndFeel());
            }
            else  {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            
        }catch(Exception e1)  {
            System.out.println("Cannot install look and feel.");
        }
    }
    
    //---------------------------------------------------------------------
}