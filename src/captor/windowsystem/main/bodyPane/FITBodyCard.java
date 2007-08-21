package captor.windowsystem.main.bodyPane;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import captor.domainsystem.FormComponentType;
import captor.domainsystem.FormComponentsType;
import captor.domainsystem.ParameterType;
import captor.domainsystem.ParametersType;
import captor.lib.intl.MyIntl;
import captor.modelsystem.Model;
import captor.projectsystem.xmlgen.CCBuffer;
import captor.windowsystem.formcomponent.FormComponent;
import captor.windowsystem.main.locationPane.util.CustomRenderer;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * @author Kicho
 *
 */
public class FITBodyCard extends JPanel implements ICards {
    
    public static final long serialVersionUID = 117;

    private Model model;
    private FormPath pp;
    
    private Vector formElList;
    private String errorMsg;
    protected DefaultMutableTreeNode node;
    
    
    public FITBodyCard(Model model, FormPath pp, DefaultMutableTreeNode node) {
        super();
        this.model = model;
        this.pp = pp;
        this.node = node;
        formElList = new Vector();
    }
    
    //-------------------------------------------------------------------------
    
    public void create()  {
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));

        JPanel elementPane = new JPanel();
        elementPane.setLayout(new BoxLayout(elementPane, BoxLayout.Y_AXIS));

        mainPane.add(titleElement());
        
        Dimension minSize = new Dimension(150, 10);
        Dimension prefSize = new Dimension(300, 12);
        Dimension maxSize = new Dimension(450, 25);
        
        FormComponentsType cst = pp.getFormType().getFormComponents();
        if ( cst != null )  {
            List listComponent = cst.getFormComponent(); 
            for(Iterator it1 = listComponent.iterator(); it1.hasNext();) {
                FormComponentType ct = (FormComponentType) it1.next();
                
                Class cls;
                
                try {
                    cls = Class.forName(ct.getFullname());
                } catch (ClassNotFoundException e) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 1.\n\n");
                    model.getGui().getGuiView().setErrorView(e.toString());
                    return;
                }
                
                Class partypes[] = new Class[2];
                partypes[0] = model.getClass();
                partypes[1] = node.getClass();
                Constructor ctor;
                
                try {
                    ctor = cls.getConstructor(partypes);
                } catch (SecurityException e1) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 2.\n\n");
                    model.getGui().getGuiView().setErrorView(e1.toString());
                    return;
                } catch (NoSuchMethodException e1) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 3.\n\n");
                    model.getGui().getGuiView().setErrorView(e1.toString());
                    return;
                }
                
                Object arglist[] = new Object[2];
                arglist[0] = model;
                arglist[1] = node;
                Object retobj;
                
                try {
                    retobj = ctor.newInstance(arglist);
                } catch (IllegalArgumentException e4) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 4.\n\n");
                    model.getGui().getGuiView().setErrorView(e4.toString());
                    return;
                } catch (InstantiationException e4) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 5.\n\n");
                    model.getGui().getGuiView().setErrorView(e4.toString());
                    return;
                } catch (IllegalAccessException e4) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 6.\n\n");
                    model.getGui().getGuiView().setErrorView(e4.toString());
                    return;
                } catch (InvocationTargetException e4) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 7.\n\n");
                    model.getGui().getGuiView().setErrorView(e4.toString());
                    return;
                }
                
                ParametersType pst = ct.getParameters();
                if ( pst != null )  {
                    List parameterList = pst.getParameter();
                    for(Iterator it2 = parameterList.iterator(); it2.hasNext();) {
                        ParameterType prt = (ParameterType) it2.next();
                        partypes = new Class[2];
                        partypes[0] = new String().getClass();
                        partypes[1] = new String().getClass();
                        Method meth;
                        
                        try {
                            meth = cls.getMethod("setParameter", partypes);
                        } catch (SecurityException e2) {
                            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 8.\n\n");
                            model.getGui().getGuiView().setErrorView(e2.toString());
                            return;
                        } catch (NoSuchMethodException e2) {
                            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 9.\n\n");
                            model.getGui().getGuiView().setErrorView(e2.toString());
                            return;
                        }
                        
                        arglist = new Object[2];
                        arglist[0] = prt.getName();
                        arglist[1] = prt.getValue();
                        
                        try {
                            meth.invoke(retobj, arglist);
                        } catch (IllegalArgumentException e3) {
                            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 10.\n\n");
                            model.getGui().getGuiView().setErrorView(e3.toString());
                            return;
                        } catch (IllegalAccessException e3) {
                            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 11.\n\n");
                            model.getGui().getGuiView().setErrorView(e3.toString());
                            return;
                        } catch (InvocationTargetException e3) {
                            model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 12.\n\n");
                            model.getGui().getGuiView().setErrorView(e3.toString());
                            return;
                        }                 
                        
                    }   
                }
                
                Class []aclass = null;
                Object []aobj = null;
                Method meth;
                
                try {
                    meth = cls.getMethod("parseParameters", aclass);
                } catch (SecurityException e3) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 13.\n\n");
                    model.getGui().getGuiView().setErrorView(e3.toString());
                    return;
                } catch (NoSuchMethodException e3) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 14.\n\n");
                    model.getGui().getGuiView().setErrorView(e3.toString());
                    return;
                }
                
                try {
                    meth.invoke(retobj, aobj);
                } catch (IllegalArgumentException e2) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 15.\n\n");
                    model.getGui().getGuiView().setErrorView(e2.toString());
                    return;
                } catch (IllegalAccessException e2) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 16.\n\n");
                    model.getGui().getGuiView().setErrorView(e2.toString());
                    return;
                } catch (InvocationTargetException e2) {
                    model.getGui().getGuiView().setErrorView("Use the meta-model validator to see details - 17.\n\n");
                    model.getGui().getGuiView().setErrorView(e2.toString());
                    return;
                }                 
                
                formElList.add(retobj);
                
                JPanel jp = (JPanel) retobj;
                //jp.setBorder(BorderFactory.createLineBorder(Color.black));

                elementPane.add(jp);
                elementPane.add(new Box.Filler(minSize, prefSize, maxSize));
            }
        }
//      elementPane.setBorder(BorderFactory.createLineBorder(Color.black));


        String bodyAlignment = model.getConfig().getGuiHiddenConfig().getBodyAlignment();
        
        if ( bodyAlignment.trim().toLowerCase().equals("center") )  {
	        JPanel centerPane = new JPanel();
	        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.X_AXIS));
	        centerPane.add(Box.createRigidArea(new Dimension(5,5)));
	        centerPane.add(Box.createHorizontalGlue());
	        centerPane.add(elementPane);
	        centerPane.add(Box.createHorizontalGlue());
	        centerPane.add(Box.createRigidArea(new Dimension(5,5)));
	        mainPane.add(centerPane);
        }
        else   {
            mainPane.add(elementPane);
        }
        
        
        mainPane.add(Box.createVerticalGlue());
        mainPane.add(new JLabel(""));

        //mainPane.setBorder(BorderFactory.createLineBorder(Color.black));
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.add(mainPane);
    }    
    
    //-------------------------------------------------------------------------
    
    private JPanel titleElement()  {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText(MyIntl.VE_FITBODY_CARD_2 + ": " + pp.getFormType().getName() + " - " + MyIntl.VE_FITBODY_CARD_1 + ": " + pp.getFormType().getVariant());
        label.setFont(new java.awt.Font("Dialog", 1, 13));
        
        panel.add(label);
        panel.setPreferredSize(new Dimension(400,40));
        panel.setMaximumSize(new Dimension(500,40));
        //panel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        return panel;
    }
    
    //-------------------------------------------------------------------------
    
    public void updateAllElements()  {
        for ( int i = 0; i < formElList.size(); i++ )  {
            FormComponent ife = (FormComponent) formElList.get(i);
            ife.updateValues();
        } 
    }
    
    //-------------------------------------------------------------------------
    
    public void toXML(CCBuffer out)  {
        for ( int i = 0; i < formElList.size(); i++ )  {
            FormComponent ife = (FormComponent) formElList.get(i);
            ife.updateValues();
            ife.toXML(out);
        } 
    }
    
    //-------------------------------------------------------------------------
    
    public boolean validateAllFields()  {
        for ( int i = 0; i < formElList.size(); i++ )  {
            FormComponent ife = (FormComponent) formElList.get(i);
            if ( !ife.validateFields() )   {
                //setting the error and formcomponent error
                model.getGui().getGuiControl().setFormError(ife);
                model.getGui().getGuiControl().setNodeError(node);
                
                //put a red line in the formcomponent error
                ife.setBorder(BorderFactory.createLineBorder(Color.red));
                errorMsg = ife.getErrorMsg();
                
                //select the error node in the tree
                TreePath tp = new TreePath(node.getPath());
                model.getGui().getTree().setSelectionPath(tp);

                //show body
                model.getGui().getGuiControl().setLoadedPattern(true);

                //updating all icons
                CustomRenderer customRenderer = new CustomRenderer(model);
                model.getGui().getTree().setCellRenderer(customRenderer);
                
                return false;
            }
        } 
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    /**
     * @return Returns the formElList.
     */
    public Vector getFormElList() {
        return formElList;
    }
    /**
     * @param formElList The formElList to set.
     */
    public void setFormElList(Vector formElList) {
        this.formElList = formElList;
    }
    
    /**
     * @return Returns the errorMsg.
     */
    public String getErrorMsg() {
        return errorMsg;
    }
    
    //-------------------------------------------------------------------------
    
    public String toString()  {
        return pp.toString();
    }
    
    //-------------------------------------------------------------------------
    
    public void load(org.w3c.dom.Node node)  {
        for ( int i = 0; i < formElList.size(); i++ )  {
            FormComponent formElement = null;
            formElement = (FormComponent) formElList.get(i);
            formElement.load(node);
            
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void setModel(Model model)  {
        this.model = model;
        for ( int i = 0; i < formElList.size(); i++ )  {
            FormComponent ife = (FormComponent) formElList.get(i);
            ife.setModel(model);
        } 
    }
    
    //-------------------------------------------------------------------------
}
