 package captor.windowsystem.main;
 
 import java.util.Observable;
 
 import javax.swing.JMenuBar;
 import javax.swing.JPanel;
 
 import captor.modelsystem.Model;
 import captor.windowsystem.MainWindow;
 import captor.windowsystem.main.bodyPane.BodyPane;
 import captor.windowsystem.main.headerPane.Header;
 import captor.windowsystem.main.locationPane.FormNavigatorPane;
 import captor.windowsystem.main.menubar.SmartMenuBar;
 import captor.windowsystem.main.viewPane.ViewPane;
 
 
 public class WindowMaker {
     
     /**
      * This class create and refresh all main window components.
      * 
      * <p>
      * The main appication windows is: 
      * navigation panel, body panel, view panel and header panel.
      * </p>
      * 
      * @author Kicho
      */
     Model model;
     
     SmartMenuBar smartMenuBar;
     
     Header header;
     BodyPane body;
     FormNavigatorPane location;
     ViewPane view;
     MainWindow frame;
     
     public WindowMaker(MainWindow frame, Model model) {
         this.model = model;
         this.frame = frame;
         
         header = new Header(model);
         body = new BodyPane(model);
         location = new FormNavigatorPane(model);
         view = new ViewPane(model);
         smartMenuBar = new SmartMenuBar(model);
         
         model.getGui().getGuiControl().addObserver(body);
         model.getConfig().getGuiHiddenConfig().addObserver(smartMenuBar);
         model.getConfig().getGuiHiddenConfig().addObserver(view);
         model.getConfig().getGuiHiddenConfig().addObserver(location);
         
         model.getGui().getGuiView().addObserver(view);
         model.addObserver(location);
     }
     
     //-------------------------------------------------

     public JPanel createHeader()  {
         return header;
     }
     
     //-------------------------------------------------

     public JPanel createBody()  {
         return body;
     }
     
     //-------------------------------------------------

     public JPanel createLocation()  {
         return location;
     }
     
     //-------------------------------------------------

     public JPanel createView()  {
         return view;
     }
     
     //-------------------------------------------------

     public JMenuBar createSmartMenuBar()  {
         return smartMenuBar;
     }
     
     //-------------------------------------------------
     
     public void update(Observable observable, Object obj)  {
     }

     //-------------------------------------------------

     /**
     * @return Returns the body.
     */
    public BodyPane getBody() {
        return body;
    }

    /**
     * @param body The body to set.
     */
    public void setBody(BodyPane body) {
        this.body = body;
    }

    /**
     * @return Returns the location.
     */
    public FormNavigatorPane getLocation() {
        return location;
    }

    /**
     * @param location The location to set.
     */
    public void setLocation(FormNavigatorPane location) {
        this.location = location;
    }
     
     //-------------------------------------------------
 }
