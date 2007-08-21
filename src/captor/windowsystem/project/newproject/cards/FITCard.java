package captor.windowsystem.project.newproject.cards;

import javax.swing.JPanel;

import captor.modelsystem.Model;
import captor.modelsystem.Project;


public abstract class FITCard extends JPanel {

    protected Model model;
    protected Project project;

    public FITCard(Model model, Project project)  {
        super();
        this.model = model;
        this.project = project;
        create();
    }
    
    public abstract void create();
    public abstract boolean validateFields();
    
}
