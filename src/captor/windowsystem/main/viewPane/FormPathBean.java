package captor.windowsystem.main.viewPane;

/**
 * @author Kicho
 *
 */
public class FormPathBean {

    private String formName;
    private int formIndex;
    
    public FormPathBean() {
    }
    
    public FormPathBean(String formName, int formIndex) {
        this.formName = formName;
        this.formIndex = formIndex;
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the formIndex.
     */
    public int getFormIndex() {
        return formIndex;
    }
    /**
     * @param formIndex The formIndex to set.
     */
    public void setFormIndex(int formIndex) {
        this.formIndex = formIndex;
    }
    /**
     * @return Returns the formName.
     */
    public String getFormName() {
        return formName;
    }
    /**
     * @param formName The formName to set.
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        return "\nName: " + formName + "\nIndex: " + formIndex + "\n"; 
    }
}
