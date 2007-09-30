/*
 *
 */
package captor.projectsystem.xmlgen;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import captor.lib.intl.MyIntl;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;


/**
 * This class runs trough the form tree and use the forms to generate the
 * XML specification data ("the source files").
 * 
 * @author Kicho
 *
 */
public class XMLGenerator {
    
    private Model model;
    private boolean build;
    public XMLGenerator(Model model) {
        super();
        this.model = model;
        build = false;
    }
    
    //-------------------------------------------------------------------------
    
    public Vector gen(boolean build)  {
        this.build = build;
        showMessage();
        Vector v = new Vector();
        if ( !toXML(v) )
            return null;
       
        return v;
    }
    
    //-------------------------------------------------------------------------

    private boolean toXML(Vector v)  {
        JTree tree = model.getGui().getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
        try  {
            
            for ( int i = 0; i < root.getChildCount(); i++ )  {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
                String label = (String) node.getUserObject();
                model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_XMLGENERATOR_8, label));

                CCBuffer out = new CCBuffer();
                out.appendln("<?xml version=\"" + model.getConfig().getSystemConfig().getXmlVersion() + "\" encoding=\"" + model.getConfig().getSystemConfig().getXmlEncoding() + "\"?>");
                out.newLine();
                out.appendln("<formsData>");
                out.newLine();

                out.ident();
                out.appendln("<project>");
                
                out.ident();
                out.append("<name>");
                out.append(model.getProject().getName(), true);
                out.appendln("</name>", true);
                out.dident();
                out.appendln("</project>");
                out.dident();

                
                out.newLine();
                out.newLine();
                out.ident();
                out.appendln("<forms>");
                
                for ( int j = 0; j < node.getChildCount(); j++ )  {
                    boolean flag = toXML2((DefaultMutableTreeNode) node.getChildAt(j), out);
                    if ( !flag )
                        return false;
                }
                
                out.appendln("</forms>");
                out.dident();
                
                out.newLine();
                out.appendln("</formsData>");
                v.add(out);
            }
            
        }
        catch(CompilerException e)  {
            return false;
        }
        model.getGui().getGuiView().setConsoleView(MyIntl.VE_XMLGENERATOR_9);
        if ( !build )
            JOptionPane.showMessageDialog(model.getGui().getCaptorWindow(), MyIntl.MSG57);
        
        return true;
    }
    
    //-------------------------------------------------------------------------

    private boolean toXML2(DefaultMutableTreeNode root, CCBuffer out) throws CompilerException {
        FormPath pp = (FormPath) root.getUserObject();
        
        
        if ( pp != null )  {
            FITBodyCard ife = pp.getCard();
            if ( ife != null )  {
                String fullpath = "<a href=\"" + pp.getFullPath() + "\">" + pp.getFullPath() + "</a>";
                model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_XMLGENERATOR_10, fullpath));
                out.newLine();
                out.ident();
                out.appendln("<form id=\"" + pp.getFormType().getId() + "\" variant=\"" + pp.getFormType().getVariant() + "\">");
                if ( !ife.validateAllFields() )  {
                    
                    model.getGui().getGuiView().setErrorView(MyIntl.VE_XMLGENERATOR_4);
                    model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_XMLGENERATOR_5, pp.getFullPath()));
                    model.getGui().getGuiView().setErrorView(MyIntl.VE_XMLGENERATOR_6);
                    model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_XMLGENERATOR_7, ife.getErrorMsg()));
                    return false;
                }

                out.newLine();
                out.ident();
                out.appendln("<data>");
                ife.toXML(out);
                out.newLine();
                out.appendln("</data>");
                out.dident();
                
                int count = root.getChildCount();
                if ( count > 0 )  {
                    for ( int i = 0; i < count; i++ )  {
                        DefaultMutableTreeNode aux = (DefaultMutableTreeNode) root.getChildAt(i);
                        if ( !toXML2(aux, out) )
                            return false;
                    }
                }
                
                out.newLine();
                out.appendln("</form>");
                out.dident();
            }
            else  {
                model.getGui().getGuiView().setErrorView(MyIntl.VE_XMLGENERATOR_3);
                return false;
            }
        }
        
        return true;
    }
    
    //-------------------------------------------------------------------------
    
    private void showMessage()  {
        model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_XMLGENERATOR_1, model.getProject().getName()));
        model.getGui().getGuiView().setConsoleView(MyIntl.VE_XMLGENERATOR_2);
    }
    
}