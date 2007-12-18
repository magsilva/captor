package captor.windowsystem.project.newproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;



public class ShowDetails extends FITCard  implements KeyListener  {
    
    public static final long serialVersionUID = 128;

    public ShowDetails(Model model, Project project) {
        super(model, project);
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.setLayout(null);
        
        JLabel label;
        int x = 8;
        int y = 28;
        int x2 = 138;
        int labelHeight = 15;
        double factor = 7.0;
        
        int labelWidth = 125;
        int maxWidth;
        
        Color c = Color.BLUE;
        c = c.darker();
        
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_PDOMAIN,  SwingConstants.RIGHT);
        label.setBounds(x, y, labelWidth, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);
        label = new JLabel(project.getName());
        label.setBounds(x2, y, 1400, labelHeight);
        add(label);
        
        y = y + 35;
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_PNAME, SwingConstants.RIGHT);
        label.setBounds(x, y, labelWidth, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);
        label = new JLabel(project.getDomain());
        label.setBounds(x2, y, 1400, labelHeight);
        add(label);
        
        y = y + 35;
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_PPATH, SwingConstants.RIGHT);
        label.setBounds(x, y, labelWidth, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);
        
        int width = (int) (project.getPath().length() * factor);
        maxWidth = width;
        label = new JLabel(project.getPath().concat("  "));
        label.setBounds(x2, y,  1400, labelHeight);
        add(label);
        
        y = y + 35;
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_PINPUT_FOLDER, SwingConstants.RIGHT);
        label.setBounds(x, y, labelWidth, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);
        label = new JLabel(project.getInputFolder().concat("  "));
        
        width = (int) (project.getInputFolder().length() * factor);
        if ( width > maxWidth)
            maxWidth = width;
        
        label.setBounds(x2, y, 1400, labelHeight);
        add(label);
        
        y = y + 35;
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_POUTPUT_FOLDER, SwingConstants.RIGHT);
        label.setBounds(x, y, labelWidth, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);
        
        label = new JLabel(project.getOutputFolder().concat("  "));
        
        width = (int) (project.getOutputFolder().length() * factor);
        if ( width > maxWidth)
            maxWidth = width;
        
        label.setBounds(x2, y, 1400, labelHeight);
        add(label);
        
        y = y + 35;
        label = new JLabel(MyIntl.NEW_PROJECT_WINDOW_OVERWRITE + ": ", SwingConstants.RIGHT);
        label.setBounds(x, y+20, labelWidth+150, labelHeight);
        label.setFont(new Font("Default", Font.BOLD, 12));
        label.setForeground(c);
        add(label);

        label = new JLabel( new Boolean(project.getOverwriteResources()).toString() );
        
        label.setBounds(x2+150, y+20, 150, labelHeight+5);
        add(label);
        
        this.setPreferredSize(new Dimension(maxWidth,340));
    }    
    
    //-------------------------------------------------------------------------
    
    public boolean validateFields()  {
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e)  {
    }
    
    //-------------------------------------------------------------------------
    
    }
