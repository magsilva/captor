package captor.windowsystem.project.newproject;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.modelsystem.Project;
import captor.windowsystem.CaptorFrame;


public class Body extends JPanel {

    public static final long serialVersionUID = 120;

    private static final String CARD1 = "card1";
    private static final String CARD2 = "card2";
    private static final String CARD3 = "card3";
    
    private static final int FIRST  = 1;
    private static final int SECOND = 2;
    private static final int THIRD  = 3;
    
    private int state = 0;
    
    private Model model;
    private SelectProjectType card1;
    private CreateProject card2;
    private ShowDetails card3;
    private CaptorFrame frame;
    private Header header;
    private Project project;
    private Footer footer;
    
    public Body(Model model, CaptorFrame frame, Header header, Project project) {
        super();
        
        this.model = model;
        this.frame = frame;
        this.header = header;
        this.project = project;
        
        create();
    }
    
    //-------------------------------------------------------------------------

    public void create()  {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new CardLayout());
        
        card1 = new SelectProjectType(model, project, this);
        add(card1, CARD1);

        card2 = new CreateProject(model, project, frame, this);
        add(card2, CARD2);
    }
    
    //-------------------------------------------------------------------------

    /**
     * @return Returns the footer.
     */
    public Footer getFooter() {
        return footer;
    }
    /**
     * @param footer The footer to set.
     */
    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    /**
     * @return Returns the state.
     */
    public int getState() {
        return state;
    }
    /**
     * @param state The state to set.
     */
    public void setState(int state) {
        this.state = state;
    }
    
    //-------------------------------------------------------------------------

    public void first()  {
        state = FIRST;
        CardLayout cl = (CardLayout)(getLayout());
        cl.show(this, CARD1);        
        header.setTitle(MyIntl.NEW_PROJECT_WINDOW_SELECT_WIZARD);
        header.setDetails(MyIntl.NEW_PROJECT_WINDOW_CREATE_NEW_PROJECT);
     }

    //-------------------------------------------------------------------------

    public void second()  {
        if ( card1.validateFields() )  {
            state = SECOND;
            CardLayout cl = (CardLayout)(getLayout());
            cl.show(this, CARD2);
            header.setTitle(MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT);
            header.setDetails(MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT_WORKSPACE);
            card2.start();
        }
     }

    //-------------------------------------------------------------------------

    public void third()  {
        if ( card2.validateFields() )  {
            state = THIRD;
            header.setTitle(MyIntl.NEW_PROJECT_WINDOW_PROJECT_DETAILS);
            header.setDetails(MyIntl.NEW_PROJECT_WINDOW_PLEASE_CHECK);
            card3 = new ShowDetails(model, project);
            JScrollPane scroll = new JScrollPane(card3);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            add(scroll, CARD3);
            CardLayout cl = (CardLayout)(getLayout());
            cl.show(this, CARD3);
        }
     }
    
    //-------------------------------------------------------------------------

    public void next()  {
        if ( state == FIRST )  {
            second();
        }
        else if ( state == SECOND )  {
            third();
        }
        
        footer.updateButtons();
    }

    //-------------------------------------------------------------------------

    public void back()  {
        if ( state == SECOND )
            first();
        else if ( state == THIRD )
            second();
    }
    
    //-------------------------------------------------------------------------

    public boolean hasNext()  {
        if ( state == FIRST || state == SECOND )
            return true;

        return false;
    }

    public boolean hasBack()  {
        if ( state == SECOND || state == THIRD )
            return true;

        return false;
    }
    
    //-------------------------------------------------------------------------
}

