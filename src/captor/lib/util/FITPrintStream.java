/*
 *
 */
package captor.lib.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;

import captor.modelsystem.Model;


/**
 * @author Kicho
 *
 */
public class FITPrintStream extends PrintStream  {
    
    private File logFile;
    PrintWriter out;
    
    PrintStream defaultOut;
    Model model;
    
    public FITPrintStream(Model model, BufferedOutputStream bos, boolean b)  {
        super(bos, b);
        this.model = model;
        
        defaultOut = System.out;
        
        System.setOut(this);
        System.setErr(this);
        
        File logDir = new File(model.getConfig().getSystemConfig().getInstallPath() + "/log/");
        if ( !logDir.exists() )  {
            try {
                FileUtils.forceMkdir(logDir);
            } catch (IOException e) {
                throw new RuntimeException("Cannot create log dir.");
            }
        }
        
        logFile = new File(logDir, getDate() + ".log");
        if ( !logFile.exists() )  {
            try {
                logFile.createNewFile();
                
                FileOutputStream  outputStream;
                try { 
                   outputStream = new FileOutputStream(logFile.getAbsoluteFile());
                } catch ( FileNotFoundException e ) {
                    model.getGui().getGuiView().setErrorView("<br>Cannot initalize logger.<br>Cannot open file: " + logFile.getAbsolutePath());
                    return ;
                }
                out = new PrintWriter(outputStream);
                
            } catch (IOException e) {
                model.getGui().getGuiView().setErrorView("<br>Cannot initalize logger.<br>Cannot create file: " + logFile.getAbsolutePath());
            }
        }
    }
    
    //-------------------------------------------------------------------------

    private String getDate()  {
        Calendar calendar = new GregorianCalendar();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int hora = calendar.get(Calendar.HOUR);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundo = calendar.get(Calendar.SECOND);

        String ret = "y" + ano + "_m" + mes + "_d" + dia + "__h" + hora + "_m" + minuto + "_s" + segundo;
        return ret; 
    }
    
    //-------------------------------------------------------------------------

    public void print(boolean b)  {
        super.print(b);

        if ( out != null )  {
            out.println(new Boolean(b).toString());
            out.flush();
            defaultOut.println(new Boolean(b).toString());
            defaultOut.flush();
        }
    }
    
    public void print(char c)  {
        super.print(c);
        char []ca = new char[1];
        ca[0] = c;
        if ( out != null )  {
            out.println(new String(ca));
            out.flush();
            defaultOut.println(new String(ca));
            defaultOut.flush();
        }
    }
    
    public void print(char[] s)  {
        super.print(s);
        
        if ( s == null )
            return;

        if ( s == null )
            return;
        
        if ( out != null )  {
            out.println(new String(s));
            out.flush();
            defaultOut.println(new String(s));
            defaultOut.flush();
        }
    }
    
    public void print(double d)  {
        super.print(d);
        
        if ( out != null )  {
            out.println(new Double(d).toString());
            out.flush();
            defaultOut.println(new Double(d).toString());
            defaultOut.flush();
        }
    }
    
    public void print(float f)  {
        super.print(f);
        
        if ( out != null )  {
            out.println(new Float(f).toString());
            out.flush();
            defaultOut.println(new Float(f).toString());
            defaultOut.flush();
        }
    }
    
    public void print(int i)  {
        super.print(i);
        
        if ( out != null )  {
            out.println(new Integer(i).toString());
            out.flush();
            defaultOut.println(new Integer(i).toString());
            defaultOut.flush();
        }
    }
    
    public void print(long l)  {
        super.print(l);
        
        if ( out != null )  {
            out.println(new Long(l).toString());
            out.flush();
            defaultOut.println(new Long(l).toString());
            defaultOut.flush();
        }
    }
    
    public void print(Object obj)  {
        super.print(obj);
        
        if ( obj == null )
            return;
        
        if ( out != null )  {
            out.println(obj.toString());
            out.flush();
            defaultOut.println(obj.toString());
            defaultOut.flush();
        }
    }
    
    public void print(String s)   {
        super.print(s + "\n");
        
        if ( s == null )
            return;
        
        if ( out != null )  {
            out.println(s);
            out.flush();
            defaultOut.println(s);
            defaultOut.flush();
        }
    }
    
}
