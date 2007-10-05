/*
Copyright (C) 2007 Marco Aurélio Graciotto Silva <magsilva@gmail.com>

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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CaptorOptionsParser extends PosixParser
{
	protected static String getDefaultInstallPath()
	{
		String[] installPathnames = new String[2];
		File installPath = null;

		installPathnames[0] = System.getenv("CAPTOR_HOME");
		installPathnames[1] = System.getProperty("user.dir") + File.separator + "..";

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

		try {
			return installPath.getCanonicalPath();
		} catch (IOException e) {
		}
		return null;
	}
	
	public CommandLine getOptions(Options options, String[] arguments1) throws ParseException
	{
		ArrayList<String> arguments2 = new ArrayList<String>(arguments1.length);
		for (String arg : arguments1) {
			arguments2.add(arg);
		}
		
		CommandLine cmdline1 = parse(options, arguments1);
		if (! cmdline1.hasOption('d')) {
			String defaultInstallPath = getDefaultInstallPath();
			if (defaultInstallPath != null) {
				arguments2.add("-d");
				arguments2.add(defaultInstallPath);
			}
		}
		
		CommandLine cmdline2 = parse(options, arguments2.toArray(new String[0]));
		if (! cmdline2.hasOption('d')) {
			throw new ParseException("Installation directory not set. Please, set the installation" +
				" directory as a command line paramater set the environment variable 'CAPTOR_HOME");
		}
		
		return cmdline2;
	}

}
