package captor.projectsystem.open;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.projectsystem.ProjectSystem;
import captor.windowsystem.main.locationPane.TreeBuilder;
import captor.windowsystem.project.OpenProjectFilter;


public class OpenProject  {

    JFileChooser fc;
    private Model model;

    public OpenProject(Model model) {
        this.model = model;
        File file = null;
        
        //escolher um path padr�o
        String path = model.getConfig().getGuiHiddenConfig().getLastOpenProjectDirectory();
        if ( path != null )  {
	        path = path.substring(0, (path.lastIndexOf(File.separator) + 1));
            file = new File(path);
        }
        
        if ( file == null )  {
            file = new File(model.getConfig().getSystemConfig().getInstallPath());
        }
        
        if ( file == null )  {
            file = new File(".");
        }

        fc = new JFileChooser(file);
        fc.addChoosableFileFilter(new OpenProjectFilter());
    }

    //-------------------------------------------------------------------------
    
    public void open() {
        int returnVal = fc.showOpenDialog(model.getGui().getCaptorWindow());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            open(file);
        }
   }
    
   public void open(String path)  {
        File file = new File(path);
        if ( !file.isFile())  {
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG30);
            return;
        }
        open(file);
    }    

   //-------------------------------------------------------------------------

   public void open(File file) {
       model.getGui().getGuiView().setClearAllViews(true);

       if ( model.getProject() == null )
           model.setProject(new Project(model));
       
        //carregando o projeto
        model.getProject().load(file.getAbsolutePath());
        model.getConfig().getGuiHiddenConfig().addLastOpenProject(file.getAbsolutePath());
        
        //carregando o meta-modelo
        model.getGui().loadGuiDomain();
        
        //carregando a �rvore de padr�es
        ProjectSystem pm = new ProjectSystem(model);
        if ( !loadTree() )  {
            model.setProject(null);
            return;
        }
        
        //mostrando a janela de propriedades do projeto
        pm.showProperties();
        
        //armazenando no hist�rico dos arquivos abertos 
        model.getConfig().getGuiHiddenConfig().setLastOpenProjectDirectory(file.getAbsolutePath());
        model.getProject().setStatus(Project.SAVED);
   }
   
   //-------------------------------------------------------------------------

   public boolean loadTree()  {
       //para cada arquivo de intera��o
       File inputDir = new File(model.getProject().getInputFolder());
       
       if ( !inputDir.exists() || !inputDir.isDirectory() )  {
           String msg = "Cannot load project.<br>";
           msg = msg + "The directory: " + inputDir.getAbsolutePath() + " either does not exist or is not a directory.<br><br>";
           
           String details = new String(msg);
           msg = msg + "See error view for details.";

           details = details + "Possible source problems are:<br><br>";
           
           details = details + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Source:     The file is corrupted.<br>";
           details = details + "&nbsp;- Correction: Open the project file and fix the problem.<br><br>";
           model.getGui().getGuiView().setErrorView(details);
           
           JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG32);

           return false;
       }
       
       File []files = inputDir.listFiles();
       TreeBuilder mr = new TreeBuilder(model);
       for ( int i = 0; i < files.length; i++ )  {
           mr.buildInteraction(files[i]);
       }
       
       //expand tree
       TreeBuilder tb = new TreeBuilder(model);
       tb.expandFirstInteraction();
       tb.selectFirstFormFromFirstInteraction();
       model.getGui().getGuiControl().setLoadedPattern(true);
       return true;
   }

   //-------------------------------------------------------------------------
}
