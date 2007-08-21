/*
 *
 */
package captor.windowsystem.main.locationPane;

import java.io.File;
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import captor.domainsystem.DomainSystem;
import captor.domainsystem.FormType;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.windowsystem.main.bodyPane.FITBodyCard;
import captor.windowsystem.main.locationPane.util.FormPath;

/**
 * This class provide the buildInteraction(File interactionSourceFile) method to build interactions.
 * 
 * @author Kicho
 *
 */
public class TreeBuilder {
    
    private Model model;
    private static Document document;
    DefaultMutableTreeNode lastForm, interactionRoot;
    
    public TreeBuilder(Model model)  {
        this.model = model;
    }
    
    //-------------------------------------------------------------------------

    public void buildInteraction(File interactionSourceFile)  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        
        try {
            if ( interactionSourceFile == null )  {
                model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load file: </b></font>" + interactionSourceFile.getAbsolutePath() + "<br>");
                return;
            }
            
            if ( !interactionSourceFile.exists() )  {
                model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load file: </b></font>" + interactionSourceFile.getAbsolutePath() + "<br>");
                return;
            }

            DocumentBuilder builder = factory.newDocumentBuilder();
            setErrorHandler(builder);
            document = builder.parse(interactionSourceFile);
            parse(interactionSourceFile);
            
        } catch (SAXParseException spe) {
          // Error generated by the parser
          model.getGui().getGuiView().setErrorView("<br><b><font color=\"#FF0000\">Parsing error!</b></font> " + "<br><br><b>Line:</b> " + spe.getLineNumber() + "<br><b>URI:</b> " + spe.getSystemId() + "<br><br>");
          model.getGui().getGuiView().setErrorView("   " + StringUtil.formatOutput(spe.getMessage()) );
        
          // Use the contained exception, if any
          Exception  x = spe;
          if (spe.getException() != null)
            x = spe.getException();
          
          x.printStackTrace();
          model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(x.getMessage()));
        } catch (SAXException sxe) {
          // Error generated during parsing
          Exception  x = sxe;
          if (sxe.getException() != null)
            x = sxe.getException();
          x.printStackTrace();
          model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(x.getMessage()));

        } catch (ParserConfigurationException pce) {
          // Parser with specified options can't be built
          pce.printStackTrace();
          model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(pce.getMessage()));

        } catch (IOException ioe) {
          // I/O error
          ioe.printStackTrace();
          model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(ioe.getMessage()));
        }
    }

    //-------------------------------------------------------------------------
    
    private void parse(File file)  {
        Element pldata = document.getDocumentElement();
        if ( !pldata.getTagName().toUpperCase().equals("FORMSDATA") )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load the project.</b></font><br>The file: " + file.getAbsolutePath() + " is invalid format.<br>It doesn't contain a root tag named: 'formsData'.<br>");
            return;
        }
        
        NodeList nl = document.getElementsByTagName("forms");
        if ( nl == null || nl.getLength() == 0 )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load the project.</b></font><br>The file: " + file.getAbsolutePath() + " is invalid format.<br>It doesn't contain a tag named: 'forms'.");
            return;
        }
        
        Node patterns = nl.item(0);
        
        Node firstXMLPatternNode = getFirstNode(patterns);
        if ( firstXMLPatternNode == null )  {
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load the project.</b></font><br>Cannot find first form in file: " + file.getAbsolutePath());
            return;
        }
        
        buildInteraction(firstXMLPatternNode);
    }
    
    //-------------------------------------------------------------------------
    
    private void buildInteraction(Node firstXMLPatternNode)  {

        //criar o no da intera��o na arvore
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        interactionRoot = root;
        lastForm = root;
        
        int cont = model.getGui().getTree().getModel().getChildCount(root);
        cont++;
        DefaultMutableTreeNode interaction = new DefaultMutableTreeNode("Interaction ".concat(new Integer(cont).toString()));
        root.add(interaction);
        lastForm = interaction;
        
        buildPattern(firstXMLPatternNode, interaction, (cont - 1));
    }
    
    //-------------------------------------------------------------------------

    private void buildPattern(Node xmlPatternNode, DefaultMutableTreeNode parent, int interaction)  {
        //criar primeiro padr�o
        DomainSystem d = new DomainSystem(model);
        FormType pt = d.getFormById(xmlPatternNode.getAttributes().getNamedItem("id").getNodeValue());

        if ( pt == null )  {
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getGui().getTree().getModel().getRoot();
            int cont = model.getGui().getTree().getModel().getChildCount(root);
            model.getGui().getGuiView().setErrorView("<font color=\"#FF0000\"><b>Cannot load interaction:</b></font> " + cont);
            return;
        }

        FormPath pp = new FormPath();
        pp.setFormType(pt);
        pp.setInteraction(interaction);
        
        DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode(pp);
        pp.setTreeNode(dmtn);
        parent.add(dmtn);

        lastForm = dmtn;
        
        //esticar a arvore
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        ((DefaultTreeModel)model.getGui().getTree().getModel()).reload(root);
        model.getGui().getTree().expandPath(new TreePath(dmtn.getPath()));
//        
//        TreePath tp = new TreePath(dmtn.getPath());
//        model.getGui().getTree().setSelectionPath(tp);

        //criar os padr�es para os filhos
        NodeList nodeList = xmlPatternNode.getChildNodes();
        for ( int i = 0; i < nodeList.getLength(); i++ )  {
            Node node = nodeList.item(i);
            if ( node.getNodeName().toUpperCase().equals("FORM") )  {
                buildPattern(node, dmtn, interaction);
            }
            else  {
                if ( node.getNodeName().toUpperCase().equals("DATA") )  {
                    buildCard(pp, node, dmtn);
                }
            }
        }
    }
    
    //-------------------------------------------------------------------------

    private void buildCard(FormPath pp, Node data, DefaultMutableTreeNode node)  {
        FITBodyCard card = new FITBodyCard(model, pp, node);
        card.create();
        card.load(data);
        pp.setCard(card);
    }
    
    //-------------------------------------------------------------------------

    private Node getFirstNode(Node patterns)  {

        NodeList patternsList = patterns.getChildNodes();
        for ( int i = 0; i < patternsList.getLength(); i++ )  {
            Node pattern = patternsList.item(i);
            
            NamedNodeMap nnm = pattern.getAttributes();
            if ( nnm != null )
                if ( nnm.getNamedItem("id") != null )
                    if ( nnm.getNamedItem("id").getNodeValue() != null )
                        if ( new DomainSystem(model).compareId(nnm.getNamedItem("id").getNodeValue(), "1.*") )
                            return pattern;
        }
        
        return null;
    }
    
    //-------------------------------------------------------------------------

    private void setErrorHandler(DocumentBuilder builder)  {
        
        builder.setErrorHandler(
                new org.xml.sax.ErrorHandler() {
                  // ignore fatal errors (an exception is guaranteed)
                  public void fatalError(SAXParseException exception)
                  throws SAXException {
                  }
                  // treat validation errors as fatal
                  public void error(SAXParseException e)
                  throws SAXParseException
                  {
                    throw e;
                  }

                   // dump warnings too
                  public void warning(SAXParseException err)
                  throws SAXParseException
                  {
                    System.out.println("** Warning"
                      + ", line " + err.getLineNumber()
                      + ", uri " + err.getSystemId());
                    System.out.println("   " + err.getMessage());
                  }
                }
              );         
    }

    //-------------------------------------------------------------------------
    
    public void expandFirstInteraction()  {
      DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
      if ( root.getChildCount() > 0 )  {
          DefaultMutableTreeNode firstInteraction = (DefaultMutableTreeNode) root.getChildAt(0);
          if ( firstInteraction != null )  {
              expandInteraction(firstInteraction);
          }
      }
    }
    
    //-------------------------------------------------------------------------

    public void expandInteraction(DefaultMutableTreeNode node)  {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        ((DefaultTreeModel) model.getGui().getTree().getModel()).reload(root);
        expandInteraction2(node);
    }

    //-------------------------------------------------------------------------

    public void expandInteraction2(DefaultMutableTreeNode node)  {
        TreePath tp = new TreePath(node.getPath());
        model.getGui().getTree().setSelectionPath(tp);
        model.getGui().getTree().expandPath(tp);
        
        for ( int i = 0; i < node.getChildCount(); i++ )  {
            expandInteraction2((DefaultMutableTreeNode) node.getChildAt(i));
        }
    }
    
    //-------------------------------------------------------------------------
    
    public void selectFirstFormFromFirstInteraction()  {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getGui().getTree().getModel().getRoot();
        if ( root.getChildCount() > 0 )  {
            DefaultMutableTreeNode firstInteraction = (DefaultMutableTreeNode) root.getChildAt(0);
            if ( firstInteraction != null )  {
                selectFirstForm(firstInteraction);
            }
        }
    }
    
    public void selectFirstForm(DefaultMutableTreeNode interactionNode)  {
        DefaultMutableTreeNode firstNode = (DefaultMutableTreeNode) interactionNode.getChildAt(0);
        if ( firstNode != null )  {
            TreePath tp = new TreePath(firstNode.getPath());
            model.getGui().getTree().setSelectionPath(tp);
            model.getGui().getTree().expandPath(tp);
        }
    }
    
    //-------------------------------------------------------------------------
}
