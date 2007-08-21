/*
 *
 */
package captor.projectsystem.xmlgen;

/**
 * This class is used to store the XML Generated data 
 * from form components just before it will be persisted.
 * 
 * @author Kicho
 *
 */
public class CCBuffer {
    
    private final int  SPACE = 5;
    private int ident;
    private StringBuffer buffer;
    
    public CCBuffer() {
        super();
        buffer = new StringBuffer();
        ident = 0;
    }
    
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
    
    //---------------------------------------------------------------
    
    public String toString()  {
        return buffer.toString();
    }
    
    //---------------------------------------------------------------
    
    public void appendln(int ap)  {
        makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    public void appendln(String ap)  {
        makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    
    public void appendln(StringBuffer ap)  {
        makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    //---------------------------------------------------------------

    public void appendln(int ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    public void appendln(String ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    public void appendln(StringBuffer ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
        buffer = buffer.append("\n");
    }
    
    //---------------------------------------------------------------
    
    public void append(int ap)  {
        makeIdent();
        buffer = buffer.append(ap);
    }
    
    public void append(String ap)  {
        makeIdent();
        buffer = buffer.append(ap);
    }
    
    public void append(StringBuffer ap)  {
        makeIdent();
        buffer = buffer.append(ap);
    }
    
    //---------------------------------------------------------------
    
    public void append(int ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
    }
    
    public void append(String ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
    }
    
    public void append(StringBuffer ap, boolean ident)  {
        if ( !ident )
            makeIdent();
        buffer = buffer.append(ap);
    }
    
}
