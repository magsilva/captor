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
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import captor.Captor;
import captor.app.CaptorOptionsParser;

public abstract class CaptorApp extends Captor
{
	protected CaptorApp(String installPathname)
	{
		super(installPathname);
	}
	
	protected static Options getOptions(Options options)
	{
		if (options == null) {
			options = new Options();
		}
		options.addOption("d", "basedir", true, "Base diretory");
		options.addOption("h", "help", false, "Usage instructions");
		return options;
	}

	
	protected static CommandLine processCmdline(String[] args, Options extraOptions)
	{
		CaptorOptionsParser parser = new CaptorOptionsParser();
		Options options = getOptions(extraOptions);
		HelpFormatter hf = new HelpFormatter();
		CommandLine cmdline = null;
		
		try {
			cmdline = parser.getOptions(options, args);
			if (cmdline.hasOption('h')) {
				hf.printHelp("OptionsTip", options);
				System.exit(0);
			}
		} catch (ParseException e) {
			String message = e.getMessage();
			String messagePrefix = "org.apache.commons.cli.MissingArgumentException: ";
			message.replace(messagePrefix, "");
			System.out.println(e.getMessage());
			hf.printHelp("OptionsTip", options);
			System.exit(1);
		}
		
		return cmdline;
	}

}
