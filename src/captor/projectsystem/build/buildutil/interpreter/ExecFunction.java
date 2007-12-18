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

package captor.projectsystem.build.buildutil.interpreter;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.xalan.trace.PrintTraceListener;
import org.apache.xpath.NodeSet;
import org.w3c.dom.Document;

import com.ironiacorp.commons.xml.DomDumper;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.build.buildutil.TailoredXPathUtil;
import captor.projectsystem.build.buildutil.interpreter.ast.Function;
import captor.projectsystem.build.buildutil.interpreter.ast.Parameters;

public class ExecFunction
{

	public static boolean exec(Function function, Document document, Model model)
	{
		if (function == null) {
			return false;
		}

		Parameters parameters = function.getParameters();

		if (function.getName().equals("exists")) {
			return execExists(function, parameters.getParameters(), document, model);
		} else if (function.getName().equals("equal")) {
			return execEqual(function, parameters.getParameters(), document, model);
		} else if (function.getName().equals("not-equal")) {
			return execNotEqual(function, parameters.getParameters(), document, model);
		}

		return false;
	}


	private static boolean execExists(Function function, Vector parameters, Document document, Model model)
	{
		if (parameters.size() != 1)
			return false;

		String parameter = (String) parameters.get(0);

		if (parameter == null) {
			model.getGui().getGuiView().setConsoleView(
					StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_1, function.getName()));
			return false;
		}

		try {
	        XPath xpath = TailoredXPathUtil.newInstance();
	        String result = (String) xpath.evaluate(parameter, document, XPathConstants.STRING);
			if (result.equals("")) {
				return false;
			}
			return true;
		} catch (XPathExpressionException e) {
			model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_2);
			model.getGui().getGuiView().setWarningView(
					StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_3, parameter, StringUtil.formatOutput(e
							.getMessage())));
			return false;
		}
	}


	private static boolean execEqual(Function function, Vector parameters, Document document, Model model)
	{
		if (parameters.size() != 2) {
			return false;
		}

		String parameter1 = (String) parameters.get(0);
		String parameter2 = (String) parameters.get(1);

		parameter1 = getParameterValue(parameter1, document, model);
		if (parameter1 == null) {
			model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
			return false;
		}

		parameter2 = getParameterValue(parameter2, document, model);
		if (parameter2 == null) {
			model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
			return false;
		}

		return parameter1.equals(parameter2);
	}


	private static boolean execNotEqual(Function function, Vector parameters, Document document, Model model)
	{
		if (parameters.size() != 2)
			return false;

		String parameter1 = (String) parameters.get(0);
		String parameter2 = (String) parameters.get(1);

		parameter1 = getParameterValue(parameter1, document, model);
		parameter2 = getParameterValue(parameter2, document, model);

		if (parameter1 == null) {
			model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
			return false;
		}
		if (parameter2 == null) {
			model.getGui().getGuiView().setConsoleView(MyIntl.VE_EXEC_FUNCTION_4);
			return false;
		}

		return !parameter1.equals(parameter2);
	}


	private static String getParameterValue(String parameter, Document document, Model model)
	{
		// se for um literal
		char[] charArray = parameter.toCharArray();
		int len = charArray.length;
		if (charArray[0] == '\'' && charArray[len - 1] == '\'') {
			return parameter.substring(1, len - 1);
		}

		String result = null;
		try {
			XPath xpath = TailoredXPathUtil.newInstance();
			
			// TODO: Fix this! Probably its XPath library issue
			xpath.evaluate(parameter, document, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			model.getGui().getGuiView().setErrorView(e.getMessage());
			e.printStackTrace();
			
			model.getGui().getGuiView().setWarningView(
					StringUtil.formatMessage(MyIntl.VE_EXEC_FUNCTION_5, parameter, StringUtil.formatOutput(
							e.getMessage())));
		}
		
		return result;
	}
}
