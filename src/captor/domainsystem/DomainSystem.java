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

package captor.domainsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.modelsystem.gui.GuiView;

/**
 * This class provides access to data in the main configuratin file. It
 * represents the current domain been used by the project manager and has common
 * methods for clients that manipulate in some way the domain information. i.e
 * ProjectSystem classes and WindowSystem classes.
 */
public class DomainSystem
{
	private Model model;

	public DomainSystem(Model model)
	{
		super();
		this.model = model;
	}

	public Vector<String> getDomainNames()
	{
		Vector<String> v = new Vector<String>();
		File file = new File(model.getConfig().getSystemConfig().getDomainPath());

		if (!file.exists()) {
			String errorMsg = "Cannot find domains directory: "
					+ model.getConfig().getSystemConfig().getDomainPath();
			model.getGui().getGuiView().setErrorView(errorMsg);
			throw new RuntimeException(errorMsg);
		}

		if (!file.isDirectory()) {
			String errorMsg = "The domain directory files: "
					+ model.getConfig().getSystemConfig().getDomainPath() + " is not a directory.";
			model.getGui().getGuiView().setErrorView(errorMsg);
			throw new RuntimeException(errorMsg);
		}

		for (File aux : file.listFiles()) {
			if (aux.isDirectory()) {
				if (new File(aux, aux.getName().concat(".domain")).exists())
					v.add(aux.getName());
			}
		}

		return v;
	}

	public Vector<FormType> getVariantByForm(String name)
	{
		Vector<FormType> v = new Vector<FormType>();
		FormsType p = model.getProject().getFormsType();

		if (p == null) {
			String errorMsg = "Cannot load forms from meta model.";
			model.getGui().getGuiView().setErrorView(errorMsg);
			throw new RuntimeException(errorMsg);
		}

		List<FormType> patternsList = p.getForm();
		for (Iterator<FormType> it1 = patternsList.iterator(); it1.hasNext();) {
			FormType pt = (FormType) it1.next();
			if (pt.getName().equals(name))
				v.add(pt);
		}

		return v;
	}

	public FormType getFirstForm()
	{
		FormsType p = model.getProject().getFormsType();

		if (p == null) {
			JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG1);
			return null;
		}

		List<FormType> patternsList = p.getForm();
		Iterator<FormType> it1 = patternsList.iterator();
		while (it1.hasNext()) {
			FormType pt = (FormType) it1.next();
			if (pt.isIsRoot()) {
				return pt;
			}
		}

		return null;
	}

	public FormType getFormById(String id)
	{
		FormsType p = model.getProject().getFormsType();
		if (p == null) {
			model.getGui().getGuiView().setErrorView("Cannot load forms from meta model.");
			throw new RuntimeException("Cannot load forms from meta model.");
		}

		List<FormType> patternsList = p.getForm();
		Iterator<FormType> it1 = patternsList.iterator();
		while (it1.hasNext()) {
			FormType pt = (FormType) it1.next();
			if (compareId(pt.getId(), id))
				return pt;
		}

		return null;
	}

	public boolean compareId(String id1, String id2)
	{
		FormId formId1 = new FormId(id1);
		FormId formId2 = new FormId(id2);
		return formId1.equals(formId2);
	}

	public boolean containId(Vector<String> v, String id)
	{
		Iterator<String> i = v.iterator();
		while (i.hasNext()) {
			String aux = i.next();
			if (compareId(aux, id)) {
				return true;
			}
		}

		return false;
	}

	public String extendsMechanism(FormsType p)
	{
		if (p == null) {
			return "Cannot load forms from meta model (extendsMechanism failed).";
		}

		List<FormType> patternsList = p.getForm();
		Iterator<FormType> it1 = patternsList.iterator();
		while (it1.hasNext()) {
			FormType pt = it1.next();
			String et = pt.getExtends();
			if (et != null) {
				FormType auxPt = getFormById(et);

				// se o pai desse no for nulo, a clausula extends esta errada
				if (auxPt == null) {
					return "Bad Metal-model. Form: " + pt.getName() + " (Id: " + pt.getId() + "). This "
							+ "form extends a pattern with id \"" + et + "\", but this id was not found in "
							+ "\"" + p.getName() + "\" form meta-model.";
				}

				String ret = extendsMechanism2(auxPt, pt);
				if (ret != null) {
					return ret;
				}
			}
		}

		return null;
	}

	private String extendsMechanism2(FormType father, FormType son)
	{

		if (son == null) {
			return "Cannot find son pattern in extends mechanism.";
		}

		// nextpatterns
		if ((son.getNextForms() == null) && (father.getNextForms() != null)) {
			if (father.getNextForms().getNextForm() != null) {
				son.setNextForms(father.getNextForms());
			}
		}

		if ((son.getHelp() == null) && (father.getHelp() != null)) {
			son.setHelp(father.getHelp());
		}

		// formElements
		if ((son.getFormComponents() == null) && (father.getFormComponents() != null)) {
			if (father.getFormComponents().getFormComponent() != null) {
				son.setFormComponents(father.getFormComponents());
			}
		}

		return null;
	}


	public void loadGuiDomain(String path)
	{
		Unmarshaller u = null;
		JAXBContext jc = null;
		ValidationEventCollector vec = new ValidationEventCollector();
		GuiView guiView = model.getGui().getGuiView();

		try {
			jc = JAXBContext.newInstance("captor.domainsystem");
			u = jc.createUnmarshaller();
			u.setEventHandler(vec);
		} catch (Exception e) {
			guiView.setErrorView(
					"Cannot load captor.domainsystem XML instance: " + StringUtil.formatOutput(e.toString()));
			throw new RuntimeException("Cannot load captor.domainsystem XML instance: " + e);
		}

		try {
			FileInputStream is = new FileInputStream(path);
			JAXBElement<FormsType> element = (JAXBElement<FormsType>) u.unmarshal(is);
			FormsType f = element.getValue();
			model.getProject().setFormsType(f);
		} catch (FileNotFoundException e2) {
			guiView.setErrorView("Cannot find file: " + path);
			throw new RuntimeException("Cannot find file: " + path);
		} catch (UnmarshalException e4) {
			guiView.setErrorView("Cannot parse the domain file: " + path);
			guiView.setErrorView("omain file invalid format: " + StringUtil.formatOutput(e4.getMessage()));
			throw new RuntimeException("UnmarshalException: " + e4.getMessage());
		} catch (JAXBException e3) {
			guiView.setErrorView("Cannot parse the domain file: " + path);
			guiView.setErrorView("Metal-model invalid format: " + StringUtil.formatOutput(e3.getMessage()));
			throw new RuntimeException("Cannot find file: " + path);
		} catch (RuntimeException e1) {
			guiView.setErrorView("Cannot parse the domain file: " + path);
			guiView.setErrorView("Cannot validade domain meta-model file.");
			throw new RuntimeException("Cannot validade domain meta-model file: " + path);
		}

		if (vec.hasEvents()) {
			guiView.setErrorView("Metal-model invalid format:");
			for (ValidationEvent ve : vec.getEvents()) {
				int severityNumber = ve.getSeverity();
				String severity = "";
				if (severityNumber == ValidationEvent.ERROR) {
					severity = "ERROR";
				} else if (severityNumber == ValidationEvent.FATAL_ERROR) {
					severity = "FATAL ERROR";
				} else if (severityNumber == ValidationEvent.WARNING) {
					severity = "WARNING";
				}

				ValidationEventLocator locator = ve.getLocator();
				guiView.setErrorView("File: " + path);
				String msg = StringUtil.formatOutput(ve.getMessage());
				guiView.setErrorView("Description: " + msg);
				guiView.setErrorView("Severity: " + severity);
				guiView.setErrorView("Position:");
				guiView.setErrorView("Line Number: " + locator.getLineNumber());
				guiView.setErrorView("Column Number: " + locator.getColumnNumber());
				guiView.setErrorView("Node: " + locator.getNode());
				guiView.setErrorView("URL: " + locator.getURL());
			}
		}

		String errorMsg = extendsMechanism(model.getProject().getFormsType());

		if (errorMsg != null) {
			guiView.setErrorView(errorMsg);
		}
	}
}
