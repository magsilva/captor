package captor.modelsystem.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Observable;
import java.util.Properties;

import captor.lib.def.Constant;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;


/**
 * This class holds information about the state of the window like current
 * x and y position, if the window is maximized, panel divider position and other stuffs
 * that improve the tool usability.
 * 
 * @author Kicho
 */
public class GUIHiddenConfig extends Observable  {
    
    //Constants
    public static final int WINDOW_MAXIMIZED = 0;
    public static final int WINDOW_CUSTOM_SIZE = 1;
    
    //Properties
    private int winPosX, winPosY, winPosWidth, winPosHeight;
    private boolean showWarningView, showErrorView, showConsoleView;
    private int windowState;
    private String lastOpenProjectDirectory;
    String lastOpenProject1, lastOpenProject2, lastOpenProject3, lastOpenProject4;
    String bodyAlignment;
    
    private int vSplitPosition, hSplitPosition;
    
    //Internal use
    private Properties applicationProps;
    private Model model;
    
    public GUIHiddenConfig(Model model)  {
        
        this.model = model;
        
        winPosX = winPosY = 30;
        winPosWidth = 700;
        winPosHeight = 500;
        showWarningView = true;
        showErrorView = true;
        showConsoleView = true;
        windowState = WINDOW_CUSTOM_SIZE;
        lastOpenProjectDirectory = "";
        lastOpenProject1 = "";
        lastOpenProject2 = "";
        lastOpenProject3 = "";
        lastOpenProject4 = "";
        hSplitPosition = 50;
        vSplitPosition = 50;
        bodyAlignment = "left";
    }

    public void addLastOpenProject(String projectName)  {
        String aux1, aux2, aux3, aux4;
        
        projectName = projectName.replace("\\\\", "\\");
        lastOpenProject1 = lastOpenProject1.replace("\\\\", "\\");
        lastOpenProject2 = lastOpenProject2.replace("\\\\", "\\");
        lastOpenProject3 = lastOpenProject3.replace("\\\\", "\\");
        lastOpenProject4 = lastOpenProject4.replace("\\\\", "\\");
        
        if ( projectName.equals(lastOpenProject1) )  {
            return;
        }
        else if ( projectName.equals(lastOpenProject2) )  {
            aux1 = lastOpenProject1;
            lastOpenProject1 = lastOpenProject2;
            lastOpenProject2 = aux1;
            setChanged();
            notifyObservers(Constant.ADD_OPEN_PROJECT_TO_FILE_MENU);
            return;
        } 
        else if ( projectName.equals(lastOpenProject3) )  {
            aux1 = lastOpenProject1;
            aux2 = lastOpenProject2;
            aux3 = lastOpenProject3;
            lastOpenProject1 = aux3;
            lastOpenProject3 = aux2;
            lastOpenProject2 = aux1;
            setChanged();
            notifyObservers(Constant.ADD_OPEN_PROJECT_TO_FILE_MENU);
            return;
        } 
        else if ( projectName.equals(lastOpenProject4) )  {
            aux1 = lastOpenProject1;
            aux2 = lastOpenProject2;
            aux3 = lastOpenProject3;
            aux4 = lastOpenProject4;
            lastOpenProject1 = aux4;
            lastOpenProject2 = aux1;
            lastOpenProject3 = aux2;
            lastOpenProject4 = aux3;
            setChanged();
            notifyObservers(Constant.ADD_OPEN_PROJECT_TO_FILE_MENU);
            return;
        }
        
        if ( lastOpenProject4.equals(""))  {
            lastOpenProject4 = projectName;
        }
        else if ( lastOpenProject3.equals(""))  {
            lastOpenProject3 = projectName;
        }
        else if ( lastOpenProject2.equals(""))  {
            lastOpenProject2 = projectName;
        }
        else if ( lastOpenProject1.equals(""))  {
            lastOpenProject1 = projectName;
        }
        else  {
            lastOpenProject4 = lastOpenProject3; 
            lastOpenProject3 = lastOpenProject2; 
            lastOpenProject2 = lastOpenProject1; 
            lastOpenProject1 = projectName; 
        }
        
        setChanged();
        notifyObservers(Constant.ADD_OPEN_PROJECT_TO_FILE_MENU);
    }
    
    public void load(boolean production) {

        if ( production )  {
            String path = model.getConfig().getSystemConfig().getHiddenConfigPropertiesDefaultPath();
            
            Properties defaultProps;
            try  {
                defaultProps = new Properties();
                FileInputStream in = new FileInputStream(path);
                defaultProps.load(in);
                in.close();        
                
                applicationProps = new Properties(defaultProps);
                
                path = model.getConfig().getSystemConfig().getHiddenConfigPropertiesPath();
                
                File file = new File(path);
                if ( !file.exists() )  {
                    applicationProps = defaultProps;
                }
                else  {
	                in = new FileInputStream(path);
	                applicationProps.load(in);
	                in.close();
                }
            }
            catch(Exception e)  {
	            String errorMsg = "Captor Exception: Cannot open properties files.<br>Check if the files " + path + "exists.<br>";
                model.getGui().getGuiView().setErrorView(errorMsg);
                return;
            }
            
            winPosX = new Integer(applicationProps.getProperty("winPosX")).intValue();
            winPosY = new Integer(applicationProps.getProperty("winPosY")).intValue();
            winPosWidth = new Integer(applicationProps.getProperty("winPosWidth")).intValue();
            winPosHeight = new Integer(applicationProps.getProperty("winPosHeight")).intValue();
            
            windowState = new Integer(applicationProps.getProperty("windowState")).intValue();
            
            showWarningView = new Boolean(applicationProps.getProperty("showWarningView")).booleanValue();
            showErrorView = new Boolean(applicationProps.getProperty("showErrorView")).booleanValue();
            showConsoleView = new Boolean(applicationProps.getProperty("showConsoleView")).booleanValue();
            lastOpenProjectDirectory = applicationProps.getProperty("lastOpenProjectDirectory");
            lastOpenProject1 = applicationProps.getProperty("lastOpenProject1");
            lastOpenProject2 = applicationProps.getProperty("lastOpenProject2");
            lastOpenProject3 = applicationProps.getProperty("lastOpenProject3");
            lastOpenProject4 = applicationProps.getProperty("lastOpenProject4");
            hSplitPosition = new Integer(applicationProps.getProperty("hSplitPosition")).intValue();
            vSplitPosition = new Integer(applicationProps.getProperty("vSplitPosition")).intValue();
            bodyAlignment = applicationProps.getProperty("bodyAlignment");
        }
        else  {
            winPosX = 112;
            winPosY = 80;
            winPosWidth = 800;
            winPosHeight = 600;
            
            windowState = WINDOW_CUSTOM_SIZE;
            
            showWarningView = true;
            showErrorView = true;
            showConsoleView = true;
            
            lastOpenProjectDirectory = model.getConfig().getSystemConfig().getInstallPath();
            lastOpenProject1 = "";
            lastOpenProject2 = "";
            lastOpenProject3 = "";
            lastOpenProject4 = "";
            hSplitPosition = 50;
            vSplitPosition = 50;
            bodyAlignment = "left";
        }
    }

    public void save()  {
        String path = model.getConfig().getSystemConfig().getHiddenConfigPropertiesPath();
        
        if ( applicationProps != null )  {
	        try  {
	            FileOutputStream out = new FileOutputStream(path);
	            
	            applicationProps.put("winPosX", new Integer(winPosX).toString());
	            applicationProps.put("winPosY", new Integer(winPosY).toString());
	            applicationProps.put("winPosWidth", new Integer(winPosWidth).toString());
	            applicationProps.put("winPosHeight", new Integer(winPosHeight).toString());
	            applicationProps.put("windowState", new Integer(windowState).toString());
	            
	            applicationProps.put("showWarningView", new Boolean(showWarningView).toString());
	            applicationProps.put("showErrorView", new Boolean(showErrorView).toString());
	            applicationProps.put("showConsoleView", new Boolean(showConsoleView).toString());
	
	            applicationProps.put("lastOpenProject1", lastOpenProject1);
	            applicationProps.put("lastOpenProject2", lastOpenProject2);
	            applicationProps.put("lastOpenProject3", lastOpenProject3);
	            applicationProps.put("lastOpenProject4", lastOpenProject4);
	            applicationProps.put("vSplitPosition", new Integer(vSplitPosition).toString());
	            applicationProps.put("hSplitPosition", new Integer(hSplitPosition).toString());
	            applicationProps.put("bodyAlignment", bodyAlignment);
	            
	            if (lastOpenProjectDirectory != null )
	                applicationProps.put("lastOpenProjectDirectory", lastOpenProjectDirectory);
	
	            applicationProps.store(out, "---DO NOT EDIT THIS FILE---");
	            out.close();        
	        }
	        catch(Exception e)  {
	            String errorMsg = "Captor Exception: Cannot save properties files.<br>Check if the files " + path + " exists.<br><br>" + StringUtil.formatOutput(e.toString());
                model.getGui().getGuiView().setErrorView(errorMsg);
                //e.printStackTrace();
	            return;
	        }
        }
        
    }
    
    public boolean thereIsNoLastOpenProjects()  {
        if ( lastOpenProject1.equals("") && lastOpenProject2.equals("") && 
                lastOpenProject3.equals("") && lastOpenProject4.equals(""))
            return true;

        return false;
    }
    
    /**
     * @return Returns the showWarningView.
     */
    public boolean isShowWarningView() {
        return showWarningView;
    }
    /**
     * @param showWarningView The showWarningView to set.
     */
    public void setShowWarningView(boolean showWarningView) {
        this.showWarningView = showWarningView;
        setChanged();
        notifyObservers(Constant.GUI_CONF_SHOW_HIDE_WARNING_VIEW);
    }
    /**
     * @return Returns the lastOpenProject1.
     */
    public String getLastOpenProject1() {
        return lastOpenProject1;
    }
    /**
     * @param lastOpenProject1 The lastOpenProject1 to set.
     */
    public void setLastOpenProject1(String lastOpenProject1) {
        this.lastOpenProject1 = lastOpenProject1;
    }
    /**
     * @return Returns the lastOpenProject2.
     */
    public String getLastOpenProject2() {
        return lastOpenProject2;
    }
    /**
     * @param lastOpenProject2 The lastOpenProject2 to set.
     */
    public void setLastOpenProject2(String lastOpenProject2) {
        this.lastOpenProject2 = lastOpenProject2;
    }
    /**
     * @return Returns the lastOpenProject3.
     */
    public String getLastOpenProject3() {
        return lastOpenProject3;
    }
    /**
     * @param lastOpenProject3 The lastOpenProject3 to set.
     */
    public void setLastOpenProject3(String lastOpenProject3) {
        this.lastOpenProject3 = lastOpenProject3;
    }
    /**
     * @return Returns the lastOpenProject4.
     */
    public String getLastOpenProject4() {
        return lastOpenProject4;
    }
    /**
     * @param lastOpenProject4 The lastOpenProject4 to set.
     */
    public void setLastOpenProject4(String lastOpenProject4) {
        this.lastOpenProject4 = lastOpenProject4;
    }
    /**
     * @return Returns the lastOpenProjectDirectory.
     */
    public String getLastOpenProjectDirectory() {
        return lastOpenProjectDirectory;
    }
    /**
     * @param lastOpenProjectDirectory The lastOpenProjectDirectory to set.
     */
    public void setLastOpenProjectDirectory(String lastOpenProjectDirectory) {
        this.lastOpenProjectDirectory = lastOpenProjectDirectory;
    }
    /**
     * @return Returns the winPosHeight.
     */
    public int getWinPosHeight() {
        return winPosHeight;
    }
    /**
     * @return Returns the windowState.
     */
    public int getWindowState() {
        return windowState;
    }
    /**
     * @param windowState The windowState to set.
     */
    public void setWindowState(int windowState) {
        this.windowState = windowState;
    }
    /**
     * @param winPosHeight The winPosHeight to set.
     */
    public void setWinPosHeight(int winPosHeight) {
        this.winPosHeight = winPosHeight;
    }
    /**
     * @return Returns the winPosWidth.
     */
    public int getWinPosWidth() {
        return winPosWidth;
    }
    /**
     * @param winPosWidth The winPosWidth to set.
     */
    public void setWinPosWidth(int winPosWidth) {
        this.winPosWidth = winPosWidth;
    }
    /**
     * @return Returns the winPosX.
     */
    public int getWinPosX() {
        return winPosX;
    }
    /**
     * @param winPosX The winPosX to set.
     */
    public void setWinPosX(int winPosX) {
        this.winPosX = winPosX;
    }
    /**
     * @return Returns the winPosY.
     */
    public int getWinPosY() {
        return winPosY;
    }
    /**
     * @param winPosY The winPosY to set.
     */
    public void setWinPosY(int winPosY) {
        this.winPosY = winPosY;
    }
    
    //----------------------------------------------------
    /**
     * @return Returns the showErrorView.
     */
    public boolean getShowErrorView() {
        return showErrorView;
    }
    /**
     * @param showErrorView The showErrorView to set.
     */
    public void setShowErrorView(boolean showErrorView) {
        this.showErrorView = showErrorView;
        setChanged();
        notifyObservers(Constant.GUI_CONF_SHOW_HIDE_ERROR_VIEW);
    }
    /**
     * @return Returns the showConsoleView.
     */
    public boolean getShowConsoleView() {
        return showConsoleView;
    }
    /**
     * @param showConsoleView The showConsoleView to set.
     */
    public void setShowConsoleView(boolean showConsoleView) {
        this.showConsoleView = showConsoleView;
        setChanged();
        notifyObservers(Constant.GUI_CONF_SHOW_HIDE_CONSOLE_VIEW);
    }
    /**
     * @return Returns the showLogView.
     */
    public boolean getShowWarningView() {
        return showWarningView;
    }
    
    /**
     * @return Returns the hSplitPosition.
     */
    public int getHSplitPosition() {
        return hSplitPosition;
    }
    /**
     * @param splitPosition The hSplitPosition to set.
     */
    public void setHSplitPosition(int splitPosition) {
        hSplitPosition = splitPosition;
    }
    /**
     * @return Returns the vSplitPosition.
     */
    public int getVSplitPosition() {
        return vSplitPosition;
    }
    /**
     * @param splitPosition The vSplitPosition to set.
     */
    public void setVSplitPosition(int splitPosition) {
        vSplitPosition = splitPosition;
    }
    /**
     * @return Returns the bodyAlignment.
     */
    public String getBodyAlignment() {
        return bodyAlignment;
    }
    /**
     * @param bodyAlignment The bodyAlignment to set.
     */
    public void setBodyAlignment(String bodyAlignment) {
        this.bodyAlignment = bodyAlignment;
    }
}
