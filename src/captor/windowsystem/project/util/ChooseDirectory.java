package captor.windowsystem.project.util;

import java.io.File;

import javax.swing.JFileChooser;

import captor.modelsystem.Model;
import captor.windowsystem.CaptorFrame;


public class ChooseDirectory  {

    JFileChooser fc;
    private CaptorFrame frame;

    public ChooseDirectory(CaptorFrame frame, Model model) {
        this.frame = frame;
        
        File file = new File(model.getConfig().getSystemConfig().getProjectPath());
        fc = new JFileChooser(file);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    //-------------------------------------------------------------------------
    
    public String open() {
        int returnVal = fc.showOpenDialog(frame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file.getAbsolutePath();
        } 
        
        return null;
   }

    //-------------------------------------------------------------------------
}

