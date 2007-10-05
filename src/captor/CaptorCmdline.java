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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class CaptorCmdline extends CaptorCore
{
	public CaptorCmdline(String installPath)
	{
		super(installPath);
	}

	protected static Options getOptions()
	{
		Options options = new Options();
		return options;
	}
	
	public static void main(String[] args)
    {
    	CommandLine cmdline = processCmdline(args, getOptions());
    	String installPath = cmdline.getOptionValue('d');
    	CaptorCmdline captor = new CaptorCmdline(installPath);
    }

}
