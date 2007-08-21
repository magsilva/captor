package captor.modelsystem.gui;

import java.util.Observable;

import captor.lib.def.Constant;


/**
 * The GuiView object handle the data processed by the view windows. 
 * 
 * <p>
 * There are three view windows available: console view, error view and warning view.
 * </p>
 * 
 * <p>
 * The clients should change this class attributes to change views state.
 * </p>
 * 
 * @author Kicho
 */
public class GuiView extends Observable  {

    private String warningView, errorView, consoleView, outputView;
    private boolean clearAllViews;

    public GuiView() {
        warningView = new String(); 
        errorView = new String();
        consoleView = new String();
    }

    
    /**
     * @return Returns the clearAllViews.
     */
    public boolean getClearAllViews() {
        return clearAllViews;
    }
    /**
     * @param clearAllViews The clearAllViews to set.
     */
    public void setClearAllViews(boolean clearAllViews) {
        this.clearAllViews = clearAllViews;
        setChanged();
        notifyObservers(Constant.CLEAR_ALL_VIEWS);
    }
    /**
     * @return Returns the outputView.
     */
    public String getOutputView() {
        return outputView;
    }
    /**
     * @return Returns the consoleView.
     */
    public String getConsoleView() {
        return consoleView;
    }
    /**
     * @param consoleView The consoleView to set.
     */
    public void setConsoleView(String consoleView) {
        this.consoleView = consoleView;
        setChanged();
        notifyObservers(Constant.PRINT_CONSOLE);
    }
    /**
     * @return Returns the errorView.
     */
    public String getErrorView() {
        return errorView;
    }
    /**
     * @param errorView The errorView to set.
     */
    public void setErrorView(String errorView) {
        this.errorView = errorView;
        setChanged();
        notifyObservers(Constant.PRINT_ERROR);
    }

    public String getWarningView() {
        return warningView;
    }
    public void setWarningView(String warningView) {
        this.warningView = warningView;
        setChanged();
        notifyObservers(Constant.PRINT_WARNING);
    }
}
