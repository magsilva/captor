/*
 *
 */
package captor.lib.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Kicho
 *
 */
public class FileUtil {

	public static boolean isAbsoluteFilename(String filename)
	{
		if (filename.substring(0,1).equals(File.separator)) {
			return true;
		}
		if (filename.substring(0,3).equals("c:" + File.separator)) {
			return true;
		}
		
		return false;
	}
	
    //-------------------------------------------------------------------------

    public static String getExtension(String filename) {
        int index = filename.lastIndexOf('.');

        if (-1 == index)
            return "";
        
        return filename.substring(index + 1);
    }
    
    //-------------------------------------------------------------------------

    public static boolean cloneDir(File source, File destination) {
        destination = new File(destination, source.getName());
        if ( ! destination.mkdir() )  {
            return false;
        } 
        
        File files[] = source.listFiles();
        for ( int i = 0; i < files.length; i++ )  {
            if ( files[i].isFile() )  {
                try {
                    FileUtils.copyFileToDirectory(files[i], destination);
                } catch (IOException e) {
                    String msgError = "Cannot clone directory.\nIOException.\n" + e;
                    System.out.println(msgError);
                    return false;
                }
            }
            else if ( files[i].isDirectory() )  {
                if ( !cloneDir2(files[i], destination) )  {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    public static boolean cloneDir2(File source, File destination) {
        destination = new File(destination, source.getName());
        
        if ( !destination.mkdir() )    {
            return false;
        }
        
        File files[] = source.listFiles();
        for ( int i = 0; i < files.length; i++ )  {
            if ( files[i].isFile() )  {
                try {
                    FileUtils.copyFileToDirectory(files[i], destination);
                } catch (IOException e) {
                    String msgError = "Cannot clone directory.\nIOException.\n" + e;
                    System.out.println(msgError);
                    return false;
                }
            }
            else if ( files[i].isDirectory() )  {
                return cloneDir2(files[i], destination);
            }
        }
        
        return true;
    }

    //-------------------------------------------------------------------------
}
