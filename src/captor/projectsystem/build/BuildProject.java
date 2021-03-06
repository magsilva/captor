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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Stack;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.modelsystem.gui.GuiView;
import captor.projectsystem.build.buildutil.BuildUtil;
import captor.projectsystem.build.buildutil.TailoredXPathUtil;
import captor.projectsystem.build.buildutil.interpreter.ExecFunction;
import captor.projectsystem.build.buildutil.interpreter.ExpressionInterpreter;
import captor.projectsystem.build.buildutil.interpreter.ast.Function;
import captor.projectsystem.build.mapper.CallTaskType;
import captor.projectsystem.build.mapper.ComposeType;
import captor.projectsystem.build.mapper.ComposerType;
import captor.projectsystem.build.mapper.ForEachType;
import captor.projectsystem.build.mapper.IfType;
import captor.projectsystem.build.mapper.MainType;
import captor.projectsystem.build.mapper.Mapper;
import captor.projectsystem.build.mapper.MapperException;
import captor.projectsystem.build.mapper.TaskType;
import captor.projectsystem.build.mapper.TasksType;
import captor.projectsystem.util.LongTask;

public class BuildProject
{
	public static Stack<Node> currentNodes = new Stack<Node>();

	private Model model;
	private LongTask task;

	// path do diretorio de template
	String templatePath;
	String mapperFilePath;

	// file separator
	String separator;

	List taskList;
	Document document;
	File xmlSourceFile;
	
	public BuildProject(Model model, LongTask task)
	{
		this.model = model;
		this.task = task;
		separator = System.getProperty("file.separator");
	}

	public boolean build()
	{

		String domainPath = model.getConfig().getSystemConfig().getInstallPath();
		// domainPath = domainPath.concat(separator);
		domainPath = domainPath.concat("domains");
		domainPath = domainPath.concat(separator);
		domainPath = domainPath.concat(model.getProject().getDomain());

		mapperFilePath = domainPath.concat(separator);
		mapperFilePath = mapperFilePath.concat("rules.xml");

		return build(mapperFilePath);
	}

	public boolean build(String mapperFile)
	{
		// faz verifica��es nos dados do projeto
		if (model.getProject() == null) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), MyIntl.MSG3);
			return true;
		}

		if (model.getProject().getStatus() == Project.CLOSED) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), MyIntl.MSG3);
			return true;
		}

		if (model.getProject().getStatus() == Project.UNSAVED) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), MyIntl.MSG4);
			return true;
		}

		File file = new File(mapperFile);
		if (!file.exists()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG5, mapperFile));
			return false;
		}

		// caminho para o diret�rio de dominio i.e.
		// install_path/domains/domain_name
		String domainPath = model.getConfig().getSystemConfig().getInstallPath();
		domainPath = domainPath.concat(separator);
		domainPath = domainPath.concat("domains");
		domainPath = domainPath.concat(separator);
		domainPath = domainPath.concat(model.getProject().getDomain());

		// Fazer diversas verifica��es no sistema de arquivos dos templates
		templatePath = domainPath.concat(separator);
		templatePath = templatePath.concat("templates");

		File templateDir = new File(templatePath);

		if (!templateDir.exists()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG6, templatePath));

			task.setError(true);
			return false;
		}

		if (!templateDir.isDirectory()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG7, templatePath));

			task.setError(true);
			return false;
		}

		// Fazer diversas verifica��es no sistema de arquivos nos diretorio de
		// output
		String outputPath = model.getProject().getOutputFolder();
		File outputDir = new File(outputPath);

		if (!outputDir.exists()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG8, outputPath));

			task.setError(true);
			return false;
		}

		if (!outputDir.isDirectory()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG9, outputPath));

			task.setError(true);
			return false;
		}

		if (!outputDir.canWrite()) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG10, outputPath));

			task.setError(true);
			return false;
		}

		// ---------------------------------------------------------------------

		// model.getGui().getGuiView().setClearAllViews(true);

		// carregar o objeto de mapeamento
		Mapper mapper = new Mapper(model, mapperFile);
		ComposerType composer = null;
		try {
			composer = mapper.load();
		} catch (RuntimeException e1) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(
					MyIntl.MSG11, mapperFile));
			return false;
		}
		if (composer == null) {
			JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), (MyIntl.MSG16 + mapperFile));

			task.setError(true);
			return false;
		}

		boolean res = false;

		model.getGui().getGuiView().setConsoleView(MyIntl.VE_BUILDPROJECT_1);
		res = runTasks(composer);
		while (! currentNodes.empty()) {
			currentNodes.pop();
		}
		saveDocument();

		if (res) {
			if (!task.isCancelled())
				model.getGui().getGuiView().setConsoleView(MyIntl.VE_BUILDPROJECT_2);
			else
				model.getGui().getGuiView().setConsoleView(MyIntl.VE_BUILDPROJECT_3);

			return true;
		}

		model.getGui().getGuiView().setErrorView("");
		JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), MyIntl.MSG13);
		return false;

	}

	// -------------------------------------------------------------------------

	private boolean runTasks(ComposerType composer)
	{

		// statements e tasks disponiveis
		MainType st = composer.getMain();
		TasksType tt = composer.getTasks();

		taskList = tt.getTask();
		List calltasksList = st.getCallTask();
		List iftasksList = st.getIf();
		List foreachtasksList = st.getForEach();

		Vector xmlSources = BuildUtil.getAllXMLSources(model);
		for (int interaction = 0; interaction < xmlSources.size(); interaction++) {
			xmlSourceFile = (File) xmlSources.get(interaction);
			document = BuildUtil.loadSource(model, xmlSourceFile);

			if (document == null) {
				model.getGui().getGuiView().setErrorView(
						StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_4, xmlSourceFile.getAbsolutePath(),
								interaction));
				task.setError(true);
				return false;
			}

			boolean res = false;
			res = parseStatements(calltasksList, iftasksList, foreachtasksList, interaction);
			if (!res) {
				return false;
			}
		}

		return true;
	}

	// -------------------------------------------------------------------------

	private boolean parseStatements(List calltasksList, List iftasksList, List foreachtasksList,
			int interaction)
	{

		// callTask execution
		Iterator it0 = calltasksList.iterator();
		while (it0.hasNext()) {
			CallTaskType ctt = (CallTaskType) it0.next();
			boolean res = false;
			res = callTask(ctt.getId(), xmlSourceFile, interaction);
			if (!res) {
				model.getGui().getGuiView().setErrorView(
						StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_5, ctt.getId()));
				task.setError(true);
				return false;
			}
		}

		// ifTask execution
		Iterator it1 = iftasksList.iterator();
		while (it1.hasNext()) {
			IfType ift = (IfType) it1.next();
			boolean res = false;
			res = ifTask(ift, interaction);
			if (!res) {
				task.setError(true);
				return false;
			}
		}

		// for-EachTask execution
		Iterator it2 = foreachtasksList.iterator();
		while (it2.hasNext()) {
			ForEachType fet = (ForEachType) it2.next();
			boolean res = false;
			res = forEachTask(fet, interaction);
			if (!res) {
				task.setError(true);
				return false;
			}
		}

		return true;
	}

	private boolean forEachTask(ForEachType fet, int interaction)
	{
		String select = fet.getSelect();
		NodeList nodeList = null;
		GuiView gv = model.getGui().getGuiView();
		
		try {
	        XPath xpath = TailoredXPathUtil.newInstance();
	        nodeList = (NodeList) xpath.evaluate(select, document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			gv.setErrorView(StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_6, select));
			return false;
		}

		if (nodeList.getLength() == 0) {
			gv.setWarningView(StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_7, select, mapperFilePath));
			gv.setConsoleView(MyIntl.VE_BUILDPROJECT_8);
		}

		List calltasksList = fet.getCallTask();
		List iftasksList = fet.getIf();
		List foreachtasksList = fet.getForEach();
		boolean res = false;

		// Gett the root node from document
		Node root = document.getFirstChild();

		// if this will be evaluated to true, it will be a hardozourous night to
		// find out what the hell has happened
		if (root == null) {
			return false;
		}

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			String uuidValue = UUID.randomUUID().toString();
			Element element = (Element) node;
			element.setAttribute("uuid", uuidValue);
			currentNodes.push(node);
			
			res = parseStatements(calltasksList, iftasksList, foreachtasksList, interaction);
			
			currentNodes.pop();
			element.removeAttribute("uuid");
			
			if (! res) {
				return false;
			}
		}

		return true;
	}

	// -------------------------------------------------------------------------

	private boolean ifTask(IfType ift, int interaction)
	{
		ExpressionInterpreter ei = new ExpressionInterpreter(ift.getTest());

		Function function = null;
		try {
			function = ei.parseFunction();
		} catch (MapperException e1) {
			model.getGui().getGuiView().setErrorView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_9, ift.getTest(), StringUtil
							.formatOutput(e1.getMessage()), mapperFilePath));
			return false;
		}

		boolean res = ExecFunction.exec(function, document, model);
		if (res) {
			List calltasksList = ift.getCallTask();
			List iftasksList = ift.getIf();
			List foreachtasksList = ift.getForEach();
			return parseStatements(calltasksList, iftasksList, foreachtasksList, interaction);
		}

		// singnaling errors just if has an error
		return true;
	}

	// -------------------------------------------------------------------------

	private boolean callTask(String value, File xmlSourceFile, int interaction)
	{
		for (Iterator it1 = taskList.iterator(); it1.hasNext();) {
			TaskType tt = (TaskType) it1.next();
			if (tt.getId().equals(value)) {
				boolean res = false;
				try {
					res = execTask(tt, xmlSourceFile, interaction);
				} catch (MapperException e) {
					model.getGui().getGuiView().setErrorView(
							StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_10, value));
					return false;
				}
				return res;
			}
		}

		task.setError(true);
		model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_11, value));
		return false;
	}

	// -------------------------------------------------------------------------

	private boolean execTask(TaskType tt, File xmlSourceFile, int interaction) throws MapperException
	{
		if (task.isCancelled() || task.isDone()) {
			return true;
		}
		
		GuiView view = model.getGui().getGuiView();
		
		ComposeType ct = tt.getCompose();
		String templateFileName = ct.getTemplate();
		String newFilename = ct.getNewFilename();

		File templateFile = new File(templatePath, templateFileName);
		if (! templateFile.exists()) {
			view.setErrorView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_12, templateFile.getAbsolutePath(), tt.getId()));
			throw new MapperException(MapperException.INVALID_TEMPLATE_PATH, StringUtil.formatMessage(
					MyIntl.VE_BUILDPROJECT_12, templateFile.getAbsolutePath(), tt.getId()));
		}

		newFilename = TailoredXPathUtil.evaluateXPath(model, newFilename, document);
		if (newFilename == null) {
			view.setErrorView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_13, tt.getId(), newFilename));
			// just a warning, just cancel this buildOutputFile and dont set the error
			return false;
		}

		File outputDir = new File(model.getProject().getOutputFolder());
		outputDir = new File(outputDir, "interaction_".concat(new Integer(interaction).toString()));

		if (! outputDir.exists()) {
			if (! outputDir.mkdirs()) {
				view.setErrorView(
						StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_14, outputDir.getAbsolutePath()));
				throw new MapperException(MapperException.CANNOT_CREATE_OUTPUT_DIR, StringUtil.formatMessage(
						MyIntl.VE_BUILDPROJECT_14, outputDir.getAbsolutePath()));
			}
		}

		File newFile = BuildUtil.createFile(model, outputDir, newFilename);
		if (newFile == null) {
			view.setConsoleView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_15, newFilename));
			return true;
		}

		boolean res = saveDocument();
		if (res) {
			return BuildUtil.buildXSL(model, task, templateFile, xmlSourceFile, newFile, document);
		} else {
			view.setErrorView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_16, newFilename));
			return true;
		}
	}

	// -------------------------------------------------------------------------

	private boolean saveDocument()
	{

		try {
			FileOutputStream OS = new FileOutputStream(xmlSourceFile.getAbsolutePath());
			Properties OP = new Properties();
			OP.setProperty(OutputKeys.METHOD, "xml");
			OP.setProperty(OutputKeys.INDENT, "yes");
			org.apache.xalan.serialize.Serializer serializer = org.apache.xalan.serialize.SerializerFactory
					.getSerializer(OP);
			serializer.setOutputStream(OS);
			serializer.asDOMSerializer().serialize(document);
			OS.flush();
			OS.close();
			return true;
		} catch (IOException e) {
			model.getGui().getGuiView().setErrorView(
					StringUtil.formatMessage(MyIntl.VE_BUILDPROJECT_17, xmlSourceFile.getAbsolutePath(),
							StringUtil.formatOutput(e.toString())));
			return false;
		}
	}
}
