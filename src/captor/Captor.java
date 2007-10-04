/*
Copyright (C) 2005 Edison Kicho Shimabukuro Junior <edison.kicho@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package captor;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import captor.lib.intl.MyIntlEnglish;
import captor.lib.intl.MyIntlPortuguese;
import captor.lib.util.FITPrintStream;
import captor.modelsystem.Model;
import captor.windowsystem.MainWindow;
import captor.windowsystem.util.IconUtil;


/**
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
public class Captor
{
    protected Model model;

    /**
     * Start logging service.
     */
    private static void startLog(Model model)
    {
    	BufferedOutputStream bos = new BufferedOutputStream(new ByteArrayOutputStream());
    	new FITPrintStream(model, bos, true);
    }
    
    private static void installLookAndFeel(Model model)
    {
        boolean useConfiguredLNF = false;
        UIManager.LookAndFeelInfo[] installed = UIManager.getInstalledLookAndFeels();

        try  {
            
            for (LookAndFeelInfo lnf : installed) {
            	String name = lnf.getClassName();
                if (name.equals(model.getConfig().getGuiConfig().getLookAndFeel()))  {
                    useConfiguredLNF = true;
                    break;
                }
            }        
            
            if (useConfiguredLNF)  {
            	try {
            		UIManager.setLookAndFeel(model.getConfig().getGuiConfig().getLookAndFeel());
            	} catch (Exception e) {
            		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            	}
            } else  {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (Exception e)  {
            System.out.println("Cannot install look and feel.");
        }
    }
    
    protected Captor(HashMap<String, Object> args)
    {
    	this((File) args.get("installPath"), (String) args.get("language"));
    }
    
	protected Captor(File installPath, String language)
	{
		String installPathname = null;
        
        try {
        	installPathname = installPath.getCanonicalPath() + File.separator;
        } catch (IOException e) {
		}
        
        if (language.equals("pt")) {
        	MyIntlPortuguese.load();
        } else if (language.equals("en")) {
        	MyIntlEnglish.load();
        } else {
            MyIntlEnglish.load();
        }

        IconUtil.setJarFileName(installPathname + "lib" + File.separator + "res.jar");

        model = new Model();
        model.load(installPathname);
        startLog(model);
        
        installLookAndFeel(model);
	}
	
	protected void start()
	{
        MainWindow frame = new MainWindow(model);
        frame.setVisible(true);
	}
    
    protected static HashMap<String, Object> parseArguments(String[] cmdlineArgs)
    {
    	//getting installPath
    	HashMap<String, Object> args = new HashMap<String, Object>();
        String[] installPathnames = new String[3];
        String language = "en"; 
        File installPath = null;

        // Install path configuration
        if (cmdlineArgs.length > 0) {
        	installPathnames[0] = cmdlineArgs[0];
        } else {
        	installPathnames[0] = null;
        }
        installPathnames[1] = System.getenv("CAPTOR_HOME");
	    installPathnames[2] = System.getProperty("user.dir") + File.separator + "..";
        

        for (String path : installPathnames) {
        	if (path != null) {
		        installPath = new File(path);
		        if (installPath.exists() && installPath.isDirectory()) {
		        	break;
		        } else {
		        	installPath = null;
		        }
	        }
        }
        
        if (installPath == null)  {
            System.out.println("Error: I couldn't setup the installation directory");
            System.out.println("Please, set the installation directory as the first parameter when " +
            		"launching the program or set the environment variable 'CAPTOR_HOME'.");
            System.exit(0);
        }
        
        
        // Language configuration
        if (cmdlineArgs.length > 1)  {
            if (cmdlineArgs[1].equals("pt")) {
                language = "pt";
            } else if (cmdlineArgs[1].equals("en")) {
            	language = "en";
            }
        }
        
        args.put("language", language);
        args.put("installPath", installPath);
        
        return args;
    }
	
    public static void main(String[] args)
    {
       	Captor captor = new Captor(parseArguments(args));
    	captor.start();
    }
}