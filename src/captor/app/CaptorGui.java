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

import java.io.File;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.commons.cli.Options;

import captor.lib.intl.MyIntlEnglish;
import captor.lib.intl.MyIntlPortuguese;
import captor.modelsystem.Model;
import captor.windowsystem.util.IconUtil;

public abstract class CaptorGui extends CaptorApp
{
	protected CaptorGui(String installPathname, String language)
	{
		super(installPathname);
		if (language.equals("pt")) {
        	MyIntlPortuguese.load();
        } else if (language.equals("en")) {
        	MyIntlEnglish.load();
        } else {
            MyIntlEnglish.load();
        }

		IconUtil.setJarFileName(model.getConfig().getSystemConfig().getInstallPath() + "lib" + File.separator + "res.jar");

        startLog(model);
        installLookAndFeel(model);
        startGui();
	}

	
	protected static Options getOptions()
	{
		Options options = new Options();
		options.addOption("l", "lang", true, "Language");
		return options;
	}

	protected static void installLookAndFeel(Model model)
	{
		boolean useConfiguredLNF = false;
		UIManager.LookAndFeelInfo[] installed = UIManager.getInstalledLookAndFeels();
	
		try {
	
			for (LookAndFeelInfo lnf : installed) {
				String name = lnf.getClassName();
				if (name.equals(model.getConfig().getGuiConfig().getLookAndFeel())) {
					useConfiguredLNF = true;
					break;
				}
			}
	
			if (useConfiguredLNF) {
				try {
					UIManager.setLookAndFeel(model.getConfig().getGuiConfig().getLookAndFeel());
				} catch (Exception e) {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}
			} else {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		} catch (Exception e) {
			System.out.println("Cannot install look and feel.");
		}
	}
	
	protected abstract void startGui();
}
