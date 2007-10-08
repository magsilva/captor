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

package captor.projectsystem.build.mapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.gui.GuiView;

/**
 * This class loads the mapper trasnfomation file into memory before the
 * generation process occurs.
 */
public class Mapper
{

	private String filename;
	private Model model;

	public Mapper(Model model, String filename)
	{
		this.filename = filename;
		this.model = model;
	}

	public ComposerType load()
	{
		Unmarshaller u = null;
		JAXBContext jc = null;
		ValidationEventCollector vec = new ValidationEventCollector();
		ComposerType composer = null;
		GuiView gv = model.getGui().getGuiView();

		try {
			jc = JAXBContext.newInstance("captor.projectsystem.build.mapper");
			u = jc.createUnmarshaller();
			u.setEventHandler(vec);
		} catch (Exception e) {
			String msgError = "Cannot load captor.projectsystem.build.mapper XML instance: "
					+ StringUtil.formatOutput(e.toString());
			gv.setErrorView(msgError);
			throw new RuntimeException(msgError);
		}

		try {
			JAXBElement<ComposerType> element = (JAXBElement<ComposerType>) u.unmarshal(new FileInputStream(filename));
			composer = element.getValue();
		} catch (RuntimeException e1) {
			String msgError = "Cannot validade mapper meta-model file " + filename;
			gv.setErrorView(msgError);
			// throw new RuntimeException("Cannot validade domain meta-model
			// file: " + filename);
		} catch (FileNotFoundException e2) {
			String msgError = ">Cannot find file " + filename;
			gv.setErrorView(msgError);
			throw new RuntimeException("Cannot find file: " + msgError);
		} catch (JAXBException e3) {
			// this exception is being handled by vec.hasEvents
		}

		if (vec.hasEvents()) {
			ValidationEvent[] ve = vec.getEvents();
			gv.setErrorView("Mapper file invalid format: <br>");
			for (int i = 0; i < ve.length; i++) {
				int severityNumber = ve[i].getSeverity();
				String severity = "";
				if (severityNumber == ValidationEvent.ERROR) {
					severity = "ERROR";
				} else if (severityNumber == ValidationEvent.FATAL_ERROR) {
					severity = "FATAL ERROR";
				} else if (severityNumber == ValidationEvent.WARNING) {
					severity = "WARNING";
				}
				String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				ValidationEventLocator locator = ve[i].getLocator();
				gv.setErrorView(space + "(" + i + ")" + space + "File: " + filename + "<br>");
				gv.setErrorView(space + "(" + i + ")" + space + "Description: "	+ StringUtil.formatOutput(ve[i].getMessage()) + "<br>");
				gv.setErrorView(space + "(" + i + ")" + space + "Severity: " + severity	+ "<br>");
				gv.setErrorView("<br>");
				gv.setErrorView(space + "(" + i + ")" + space + "Position: " + "<br>");
				gv.setErrorView(space + "("	+ i	+ ")" + space + "Line Number: "	+ locator.getLineNumber() + "<br>");
				gv.setErrorView(space + "(" + i + ")" + space + "Column Number: "	+ locator.getColumnNumber() + "<br>");
				gv.setErrorView(space + "(" + i + ")" + space + "Node: " + locator.getNode() + "<br>");
				gv.setErrorView(space + "("	+ i	+ ")" + space + "URL: "	+ locator.getURL() + "<br>");
				gv.setErrorView("<br>");

				int index = ve[i].getMessage().indexOf("Possible tag names are");

				if (index != -1) {
					gv.setErrorView("This usually means that you put a statement in the wrong position.<br>");
					gv.setErrorView("Remember:<br>");
					gv.setErrorView(" - In the statements tag, you always have to put the statements: callTask, if and for-each tag in this order.<br>");
					gv.setErrorView(" - After the if tag, you always have to put the statements: callTask, ifTask and for-each tag in this order.<br>");
					gv.setErrorView(" - After the for-each tag, you aways have to put the statements: callTask, ifTask and for-each tag in this order.<br>");
					model.getGui().getGuiView().setErrorView("");
				}

				throw new RuntimeException("Mapper file invalid format");
			}
		}

		return composer;
	}
}
