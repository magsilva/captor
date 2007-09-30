package captor.windowsystem.project;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import captor.lib.intl.MyIntl;
 
public class OpenProjectFilter extends FileFilter {
    
    /**
     * 
     */
    public OpenProjectFilter() {
    }
    
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals("cap") || extension.equals("fit") )
                return true;
        }
        
        return false;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    //The description of this filter
    public String getDescription() {
        return MyIntl.PROJECT_FILE_DESCRIPTION;
    }
    
}
