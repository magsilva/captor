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

package captor.projectsystem.build.buildutil;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathVariableResolver;

import org.w3c.dom.Document;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.build.CurrentResolver;

public class TailoredXPathUtil
{
	public static XPath newInstance()
	{
		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathVariableResolver resolver = new CurrentResolver();
        xpath.setXPathVariableResolver(resolver);
        
        return xpath;
	}
	
	
	public static String evaluateXPath(Model model, String str, Document document)
	{
		char[] charArray = str.toCharArray();

		StringBuffer ret = new StringBuffer("");

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != '$') {
				ret = ret.append(charArray[i]);
			} else {
				StringBuffer var = new StringBuffer("");
				i = i + 2;
				while (charArray[i] != '}' && i < charArray.length) {
					var = var.append(charArray[i]);
					i++;
				}

				StringBuffer value = evaluateXPath2(var, document);
				if (value == null || value.equals("")) {
					model.getGui().getGuiView().setErrorView(
							StringUtil.formatMessage(MyIntl.VE_TAILOREXPATH_UTIL_1, var.toString()));
					return null;
				}
				ret = ret.append(value);
			}
		}

		String aux = ret.toString();
		return aux;
	}

	private static StringBuffer evaluateXPath2(StringBuffer var, Document document)
	{
		try {
			XPath xpath = newInstance();
			String result = (String) xpath.evaluate(var.toString(), document, XPathConstants.STRING);
			if (result.equals("")) {
				return null;
			}

			return new StringBuffer(result);
		} catch (XPathExpressionException e) {
			return null;
		}
	}
}
