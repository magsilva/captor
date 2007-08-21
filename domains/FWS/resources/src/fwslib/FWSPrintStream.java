package fwslib;

import java.io.BufferedOutputStream;
import java.io.PrintStream;

import fws.FWS;

/**
 * @author Kicho
 *
 */
public class FWSPrintStream extends PrintStream {

    FWS frame;
    
    public FWSPrintStream(FWS frame, BufferedOutputStream bos, boolean b)  {
        super(bos, b);
        
        this.frame = frame;
        System.setOut(this);
        System.setErr(this);
    } 
    
    public void print(boolean b)  {
        super.print(b);
        frame.setMsg(new Boolean(b).toString());
    }
    
    public void print(char c)  {
        super.print(c);
        char [] cc = new char[0];
        frame.setMsg(new String(cc));
    }
    
    public void print(char[] s)  {
        super.print(s);
        
        if ( s == null )
            return;
        
        frame.setMsg(new String(s));
    }
    
    public void print(double d)  {
        super.print(d);
        frame.setMsg(new Double(d).toString());
    }
    
    public void print(float f)  {
        super.print(f);
        frame.setMsg(new Float(f).toString());
    }
    
    public void print(int i)  {
        super.print(i);
        frame.setMsg(new Integer(i).toString());
    }
    
    public void print(long l)  {
        super.print(l);
        frame.setMsg(new Long(l).toString());
    }
    
    public void print(Object obj)  {
        super.print(obj);
        
        if ( obj == null )
            return;
        
        
        frame.setMsg(obj.toString());
    }
    
    public void print(String s)   {
        super.print(s + "\n");
        
        if ( s == null )
            return;
        
        frame.setMsg(s);
    }

}
