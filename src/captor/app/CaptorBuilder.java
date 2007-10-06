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

package captor.app;

import org.apache.commons.cli.CommandLine;

import captor.windowsystem.MainWindow;


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
  */
public class CaptorBuilder extends CaptorGui
{
	protected CaptorBuilder(String installPathname, String language)
	{
		super(installPathname, language);
	}
	
	protected void startGui()
	{
	    MainWindow frame = new MainWindow(model);
	    frame.setVisible(true);
	}

	public static void main(String[] args)
    {
    	CommandLine cmdline = processCmdline(args, getOptions());
    	String installPath = cmdline.getOptionValue('d');
    	String language = cmdline.getOptionValue('l', "en");
    	CaptorGui captor = new CaptorBuilder(installPath, language);
    }
}