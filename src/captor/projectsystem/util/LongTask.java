package captor.projectsystem.util;

/**
 * This class is used to control the build process trought the threads that
 * executes the entire process.
 * 
 * <p>
 * If the process finishes, then the attribute done is set to true.
 * </p>
 * 
 * <p>
 * If the process has a error, then the _error attribute will be set
 * to true. 
 * </p>

 * <p>
 * The thread will looking for state changes and abort the process if
 * necessary.
 * </p>
 * 
 * @author Kicho
 *
 */
public class LongTask {
    
    private boolean done;
    private boolean _error;
    private boolean isCancelled;

    public LongTask() {
        done = false;
        _error = false;
        isCancelled = false;
    }
    
    //-------------------------------------------------------------------------

    /**
     * @return Returns the done.
     */
    public synchronized boolean isDone() {
        return done;
    }
    /**
     * @return Returns the isCancelled.
     */
    public boolean isCancelled() {
        return isCancelled;
    }
    /**
     * @param isCancelled The isCancelled to set.
     */
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
    /**
     * @return Returns the _error.
     */
    public boolean hasError() {
        return _error;
    }
    /**
     * @param _error The _error to set.
     */
    public synchronized void setError(boolean _error) {
        this._error = _error;
    }
    /**
     * @param done The done to set.
     */
    public synchronized void setDone(boolean done) {
        this.done = done;
    }
    
    //-------------------------------------------------------------------------
    
}
