package captor.modelsystem;

import captor.lib.util.FITClipboard;

/**
 * This class hold a object for internal transfer area objects use.
 * It was used for copy, cut and paste functions that no longer exists.
 * 
 * <p>
 * As it implementation is very nice, the source still remains 
 * on repository and if some form component developer need this function
 * it will be already implemented in the architecture.
 * </p>
 * 
 * @author Kicho
 *
 */
public class Util {

    private FITClipboard clipboard;
    
    public Util() {
        clipboard = new FITClipboard();
    }

    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the clipBoard.
     */
    public FITClipboard getClipboard() {
        return clipboard;
    }
    /**
     * @param clipBoard The clipBoard to set.
     */
    public void setClipboard(FITClipboard clipBoard) {
        this.clipboard = clipBoard;
    }
    
    //-------------------------------------------------------------------------
}
