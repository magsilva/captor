/*
 *
 */
package captor.domainsystem.metamodelvalidator;


/**
 * @author Kicho
 *
 */
public class ValidationResults {
    
    private final int  SPACE = 5;
    private int ident;
    private StringBuffer buffer;
    private boolean success;
    
    public ValidationResults() {
        success = true;
        buffer = new StringBuffer();
        ident = 0;
    }

    //-------------------------------------------------------------------------

    public void appendBuffer(String buffer)  {
        this.buffer.append("\n");
        makeIdent();
        this.buffer.append(buffer);
    }
    
    public void appendBuffer(StringBuffer buffer)  {
        this.buffer.append("\n");
        makeIdent();
        this.buffer.append(buffer);
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the buffer.
     */
    public StringBuffer getBuffer() {
        return buffer;
    }
    /**
     * @param buffer The buffer to set.
     */
    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
    /**
     * @return Returns the success.
     */
    public boolean isSuccess() {
        return success;
    }
    /**
     * @param success The success to set.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    //-------------------------------------------------------------------------

    private void makeIdent()  {
        for ( int i = 0 ; i < ident; i++ )
            buffer = buffer.append(" ");
    }
    
    public void ident()  {
        ident = ident + SPACE;
    }
    
    public void dident()  {
        if ( ident - SPACE >= 0 )
            ident = ident - SPACE;
    }
    
    public void newLine()  {
        buffer = buffer.append("\n");
    }

    //-------------------------------------------------------------------------
    
}
