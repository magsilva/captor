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

package captor.projectsystem.build;

import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.build.buildutil.AntRunner;
import captor.projectsystem.util.LongTask;

public class BuilderLauncherThread extends Thread
{

	private Model model;
	private LongTask task;

	public BuilderLauncherThread(Model model, LongTask task)
	{
		this.model = model;
		this.task = task;
	}

	public void run()
	{
		BuildProject bp = new BuildProject(model, task);

		try {
			AntRunner ac = new AntRunner(model);
			ac.preCall();

			boolean res = bp.build();
			if (!res)
				task.setError(true);

			task.setDone(true);
			if (!task.hasError()) {
				ac.posCall();
			}

		} catch (Exception e) {
			task.setDone(true);
			task.setError(true);

			String msg = MyIntl.MSG2 + e;
			JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), msg);
			model.getGui().getGuiView().setErrorView(e.getMessage());
			e.printStackTrace();
		}
	}
}
