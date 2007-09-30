package captor.projectsystem.build.buildutil.interpreter;

/**
 * @author Kicho
 *
 */
public class Eval {

    private boolean ret;
    private String errorMsg;
    
    public Eval(boolean ret, String errorMsg) {
        this.errorMsg = errorMsg;
        this.ret = ret;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the errorMsg.
     */
    public String getErrorMsg() {
        return errorMsg;
    }
    /**
     * @param errorMsg The errorMsg to set.
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    /**
     * @return Returns the ret.
     */
    public boolean getRet() {
        return ret;
    }
    /**
     * @param ret The ret to set.
     */
    public void setRet(boolean ret) {
        this.ret = ret;
    }
    
    //-------------------------------------------------------------------------
}
