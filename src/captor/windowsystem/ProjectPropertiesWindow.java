package captor.windowsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.windowsystem.project.newproject.Header;
import captor.windowsystem.project.newproject.cards.ShowDetails;



public class ProjectPropertiesWindow extends CaptorFrame implements ActionListener {

    public static final long serialVersionUID = 60358;

    ShowDetails showDetails;
    Header header;
    JScrollPane scroll;
    JPanel footer;
    
    public ProjectPropertiesWindow(Model model)  {
        super(model, model.getGui().getCaptorWindow());
    }

    //-----------------------------------------------------------------------

    protected void init() throws Exception {
        setCenterSize(600, 423);
        this.setResizable(false);
        this.setState(Frame.NORMAL);
        this.setTitle(MyIntl.PROJECT_PROPERTIES_WINDOW_TITLE);
        this.addWindowListener(this);
        this.setLayout(new BorderLayout());

        showDetails = new ShowDetails(model, model.getProject());
        header = new Header("projectproperties.gif");
        header.setTitle(MyIntl.PROJECT_PROPERTIES_WINDOW_TITLE);
        makeFooter();
        
        scroll = new JScrollPane(showDetails);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        this.getContentPane().add(header, BorderLayout.PAGE_START);
        this.getContentPane().add(scroll, BorderLayout.CENTER);
        this.getContentPane().add(footer, BorderLayout.PAGE_END);
    }
    
    //-----------------------------------------------------------------------

    private void makeFooter()  {
        footer = new JPanel();
        footer.setPreferredSize(new Dimension(500,40));
        footer.setBorder(BorderFactory.createLineBorder(Color.black));
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
        
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        
        Dimension minSize = new Dimension(150, 500);
        Dimension prefSize = new Dimension(200, 500);
        Dimension maxSize = new Dimension(500, 500);
        footer.add(new Box.Filler(minSize, prefSize, maxSize));
        
        footer.add(new JLabel("   "));
        footer.add(new Box.Filler(minSize, prefSize, maxSize));
        footer.add(ok);
        footer.add(new JLabel("   "));
    }
    
    //-----------------------------------------------------------------------

    public void actionPerformed (ActionEvent e) {
        if ( e.getActionCommand().equals("OK") )  {
            close();
        }
    }
    
    //-----------------------------------------------------------------------

    protected void windowClosing2(WindowEvent e) {
    }

    //-----------------------------------------------------------------------
    


}
