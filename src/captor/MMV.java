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

import java.util.HashMap;
import captor.windowsystem.MetaModelValidatorWindow;

/**
 * Meta-model validator.
 */
public class MMV extends Captor
{
	protected MMV(HashMap<String, Object> args)
	{
		super(args);
	}

	protected void start()
	{
        MetaModelValidatorWindow mmv = new MetaModelValidatorWindow(model);
        mmv.setVisible(true);
	}
	
    public static void main(String[] args)
    {
      	MMV mmv = new MMV(parseArguments(args));
    	mmv.start();
    } 
}
