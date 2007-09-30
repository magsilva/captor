/*
 *
 */
package captor.projectsystem.build.buildutil;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class BuildErrorListener implements ErrorListener {
    
    private Model model;
    
    public BuildErrorListener(Model model)  {
        this.model = model;
    }

    public void error(TransformerException exception)  {
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.toString()));
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.getMessageAndLocation()));
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.getLocationAsString()));
    }
    public void fatalError(TransformerException exception)  {
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.toString()));
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.getMessageAndLocation()));
        model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(exception.getLocationAsString()));
    }
    public void warning(TransformerException exception)  {
        model.getGui().getGuiView().setErrorView(exception.toString());
        model.getGui().getGuiView().setErrorView(exception.getMessageAndLocation());
        model.getGui().getGuiView().setErrorView(exception.getLocationAsString());
    }
    
    //-------------------------------------------------------------------------

}
