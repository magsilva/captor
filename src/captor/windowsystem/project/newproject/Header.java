package captor.windowsystem.project.newproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Header extends JPanel {
    
    public static final long serialVersionUID = 122;

    JLabel titleLabel, detailsLabel;
    JPanel left, right, middle;
    Icon icon;
    JLabel middleLabel;
    String iconName;
    
    public Header() {
        super();
        iconName = "newprojectwizard.gif";
        create();
    }

    public Header(String iconName) {
        super();
        this.iconName = iconName;
        create();
    }
    
    public void create()  {
        setBackground(Color.WHITE);
        setOpaque(true);
        repaint();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel();
        detailsLabel = new JLabel();
        
        titleLabel.setFont(new Font("Default", Font.BOLD, 12));
        detailsLabel.setFont(new Font("Default", Font.PLAIN, 12));
        
        left = new JPanel();
        right = new JPanel();
        middle = new JPanel();
        
        //-----------------------------------------------------------
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        
        titleLabel.setBounds(new Rectangle(10,10,100,10));
        detailsLabel.setBounds(new Rectangle(20,20,100,10));

        titleLabel.setBackground(Color.WHITE);
        detailsLabel.setBackground(Color.WHITE);
        titleLabel.setOpaque(true);
        detailsLabel.setOpaque(true);
        
        left.setOpaque(true);
        left.setBackground(Color.WHITE);
        
        left.add(new JLabel(" "));
        left.add(titleLabel);
        left.add(new JLabel(" "));
        left.add(detailsLabel);
        left.add(new JLabel(" "));
        
        //-----------------------------------------------------------

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setOpaque(true);
        right.setBackground(Color.WHITE);

        right.add(new JLabel(" "));
        
        //-----------------------------------------------------------
        middle.setOpaque(true);
        middle.setBackground(Color.WHITE);

        middleLabel = new JLabel();
        middle.add(middleLabel);
        
        //-----------------------------------------------------------
        add(left, BorderLayout.WEST);
        add(middle, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
    }
    
    public void setTitle(String title)  {
        titleLabel.setText("            "  + title);
    }

    public void setDetails(String details)  {
        detailsLabel.setText("                   " + details);
    }
}

