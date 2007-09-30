package captor.windowsystem.util;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author Kicho
 *
 */
public class IconUtil {

    public static boolean debugOn=false;
    private static Hashtable htSizes = new Hashtable();  

    private static Hashtable htJarContents=new Hashtable();
    private static String jarFileName;
    private static boolean init = false;
    
    public static Icon getIcon(String name) {
        if ( !init )
            init();
        
        
        if ( !(name.equals("openArrow.gif") || name.equals("closeArrow.gif") 
                || name.equals("patternnode.gif") || name.equals("rootnode.gif")
                || name.equals("error.gif")
                ))
                return null;
        
        name = "res/icons/" + name;
        byte[] buff = getResource(name);
        if (buff == null) {
           System.out.println("Cannot load icon: " + name + ".");
           return null;
        } else {
//            System.out.println("Loading: " + name + ".");
            ImageIcon icon = new ImageIcon(buff);
            return icon;
        }        
    }
    
    //-------------------------------------------------------------------------

    public static Image getImage(String name) {
        if ( !init )
            init();
        
        
        if ( !(name.equals("captor.jpg")) )
                return null;
        
        name = "res/icons/" + name;
        byte[] buff = getResource(name);
        if (buff == null) {
           System.out.println("Cannot load image: " + name + ".");
           return null;
        } else {
//            System.out.println("loading image: " + name + ".");
            ImageIcon icon = new ImageIcon(buff);
            return icon.getImage();
        }        
    }

    //-------------------------------------------------------------------------
    
    private static void init() {
        init = true;
        try {
            ZipFile zf=new ZipFile(jarFileName);
            Enumeration e=zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze=(ZipEntry)e.nextElement();
                if (debugOn) {
                   System.out.println(dumpZipEntry(ze));
                }
                htSizes.put(ze.getName(),new Integer((int)ze.getSize()));
            }
            zf.close();
            
            FileInputStream fis=new FileInputStream(jarFileName);
            BufferedInputStream bis=new BufferedInputStream(fis);
            ZipInputStream zis=new ZipInputStream(bis);
            ZipEntry ze=null;
            while ((ze=zis.getNextEntry())!=null) {
               if (ze.isDirectory()) {
                  continue;
               }
               if (debugOn) {
                  System.out.println(
                     "ze.getName()="+ze.getName()+","+"getSize()="+ze.getSize()
                     );
               }
               int size=(int)ze.getSize();
               // -1 means unknown size.
               if (size==-1) {
                  size=((Integer)htSizes.get(ze.getName())).intValue();
               }
               byte[] b=new byte[(int)size];
               int rb=0;
               int chunk=0;
               while (((int)size - rb) > 0) {
                   chunk=zis.read(b,rb,(int)size - rb);
                   if (chunk==-1) {
                      break;
                   }
                   rb+=chunk;
               }
               // add to internal resource hashtable
               htJarContents.put(ze.getName(),b);
               if (debugOn) {
                  System.out.println(
                     ze.getName()+"  rb="+rb+
                     ",size="+size+
                     ",csize="+ze.getCompressedSize()
                     );
               }
            }
         } catch (NullPointerException e) {
            System.out.println("done.");
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
     }
    
    //-------------------------------------------------------------------------
    
    public static byte[] getResource(String name) {
        return (byte[])htJarContents.get(name);
     }

    //-------------------------------------------------------------------------

    /**
     * Dumps a zip entry into a string.
     * @param ze a ZipEntry
     */
    private static String dumpZipEntry(ZipEntry ze) {
        StringBuffer sb=new StringBuffer();
        if (ze.isDirectory()) {
           sb.append("d "); 
        } else {
           sb.append("f "); 
        }
        if (ze.getMethod()==ZipEntry.STORED) {
           sb.append("stored   "); 
        } else {
           sb.append("defalted ");
        }
        sb.append(ze.getName());
        sb.append("\t");
        sb.append(""+ze.getSize());
        if (ze.getMethod()==ZipEntry.DEFLATED) {
           sb.append("/"+ze.getCompressedSize());
        }
        return (sb.toString());
    }

    //-------------------------------------------------------------------------
    
    /**
     * @param jarFileName The jarFileName to set.
     */
    public static void setJarFileName(String jarFileName) {
        IconUtil.jarFileName = jarFileName;
    }
    
    //-------------------------------------------------------------------------
}
