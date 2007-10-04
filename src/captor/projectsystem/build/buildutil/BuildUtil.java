package captor.projectsystem.build.buildutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import captor.lib.intl.MyIntl;
import captor.lib.util.FileUtil;
import captor.lib.util.StringUtil;
import captor.modelsystem.Model;
import captor.projectsystem.util.LongTask;


/**
 * @author Kicho
 *
 */
public class BuildUtil {
    
    public static Vector getAllXMLSources(Model model)  {
        
        String xmlPath = model.getProject().getInputFolder();
        
        File xmlDir = new File(xmlPath);
        
        if ( !xmlDir.exists() )  {
            JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(MyIntl.MSG14, xmlPath));
            throw new RuntimeException(StringUtil.formatMessage(MyIntl.MSG14, xmlPath));
        }
        
        if ( !xmlDir.isDirectory() )  {
            JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(MyIntl.MSG15, xmlPath));
            throw new RuntimeException(StringUtil.formatMessage(MyIntl.MSG14, xmlPath));
        }
        
        Vector xmlSources = new Vector();
        for (File f : xmlDir.listFiles())  {
            if (f.isFile() && FileUtil.getExtension(f.getName()).toUpperCase().equals("FIT")) {
                xmlSources.add(f);
            }
        }
        return xmlSources;
    }
    
    public static File createFile(Model model, File outputDir, String filename)
    {
        String fullFileName = "";
        //this is not a absolute path
        if (FileUtil.isAbsoluteFilename(filename)) {
        	fullFileName = filename;
        } else {
        	fullFileName = outputDir.getAbsolutePath() + System.getProperty("file.separator") + filename;
        }
        

        File file = new File(fullFileName);
        if ( file.exists() && !file.isDirectory() )  {
            //should overwrite?
            if ( model.getProject().getOverwriteResources() )  {
                return file;
            }
            
            //if don't ok
            return null;
        }
        
        //if the file dont exists, then create it!
        try {
            FileUtils.forceMkdir(file.getParentFile());
            file = new File(file.getParent(), file.getName());
        } catch (IOException e) {
            model.getGui().getGuiView().setConsoleView(StringUtil.formatMessage(MyIntl.VE_BUILDUTIL_7, file.getAbsolutePath()));
        }
        
        return file;
    }
    
    //-------------------------------------------------------------------------
    
    public static void transformError(Model model, File templateFile, File xmlSourceFile, File newFile)  {
        model.getGui().getBuildWindow().setEnabled(true);
        model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_BUILDUTIL_8, xmlSourceFile.getAbsolutePath(), newFile.getAbsolutePath(), templateFile.getAbsolutePath()));
        JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), MyIntl.MSG17);
    }
    
    //-------------------------------------------------------------------------
    
    public static Document loadSource(Model model, File source)  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(source);
            return document;
        } catch (ParserConfigurationException e) {
            JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(MyIntl.MSG18, e.toString()));
            return null;
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(MyIntl.MSG18, e.toString()));
            return null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(model.getGui().getBuildWindow(), StringUtil.formatMessage(MyIntl.MSG18, e.toString()));
            return null;
        }
        
    }
    
    //-------------------------------------------------------------------------
    
    public static boolean buildXSL(Model model, LongTask task, File templateFile, File xmlSourceFile, File newFile, Document document)  {
        
        //        System. out.println("Transformar:");
        //        System. out.println("  xmlSourceFile: " + xmlSourceFile.getAbsolutePath());
        //        System. out.println("        newFile: " + newFile.getAbsolutePath());
        //        System. out.println("   templateFile: " + templateFile.getAbsolutePath());
        //        return true;
        
        if ( newFile.exists() )  {
            try {
                scanForSafeZones(xmlSourceFile, document, newFile);
            } catch (Exception e1) {
                model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_BUILDUTIL_9, xmlSourceFile.getAbsolutePath(), newFile.getAbsolutePath(), StringUtil.formatOutput(e1.toString())));
                return false;
            }
        }

//        if ( !(newFile.exists() && newFile.canWrite()) )  {
//            model.getGui().getGuiView().setErrorView("<b>Cannot write on file:</b> '" + newFile.getAbsolutePath() + "\nPermission denied.");
//            return false;
//        }

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            String stylesheet = templateFile.getAbsolutePath();
            
            
            model.getGui().getGuiView().setConsoleView(MyIntl.VE_BUILDUTIL_1 + newFile.getAbsolutePath() + "<br>");
            
            FileOutputStream os;
            try {
                os = new FileOutputStream(newFile);
            } catch (FileNotFoundException e1) {
                BuildUtil.transformError(model, templateFile, xmlSourceFile, newFile);
                task.setError(true);
                model.getGui().getGuiView().setErrorView(StringUtil.formatMessage(MyIntl.VE_BUILDUTIL_2, newFile.getAbsolutePath(), StringUtil.formatOutput(e1.toString())));
                return false;
            }
            
            Transformer transformer = null;
            StreamSource ss = new StreamSource(stylesheet);
            transformer = tFactory.newTransformer(ss);
            transformer.setErrorListener(new BuildErrorListener(model));
            transformer.transform(new StreamSource(xmlSourceFile.getAbsolutePath()), new StreamResult(os));
            
            try {
                os.flush();
                os.close();
            } catch (IOException e2) {
                BuildUtil.transformError(model, templateFile, xmlSourceFile, newFile);
                model.getGui().getGuiView().setErrorView(MyIntl.VE_BUILDUTIL_3 + StringUtil.formatOutput(e2.getMessage()));
                return false;
            }
            
            return true;
        } catch (TransformerException e) {
            BuildUtil.transformError(model, templateFile, xmlSourceFile, newFile);
            model.getGui().getGuiView().setErrorView(MyIntl.VE_BUILDUTIL_4);
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(e.toString()));
            model.getGui().getGuiView().setErrorView("<br><br>");
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(e.getMessageAndLocation()));
            model.getGui().getGuiView().setErrorView("<br>");
            SourceLocator sl = e.getLocator();
            if ( sl != null )  {
                model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>line number:</b> " + sl.getLineNumber());
                model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;<b>column number:</b> " + sl.getColumnNumber());
                model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>public id:</b> " + sl.getPublicId());
                model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>system id:</b> " + sl.getSystemId());
            }
            
            Throwable t = e.getException();
            if ( t instanceof TransformerConfigurationException )  {
                TransformerConfigurationException tce = (TransformerConfigurationException) t;
                sl = tce.getLocator();
                if ( sl != null )  {
                    model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>line number:</b> " + sl.getLineNumber());
                    model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;<b>column number:</b> " + sl.getColumnNumber());
                    model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>public id:</b> " + sl.getPublicId());
                    model.getGui().getGuiView().setErrorView("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>system id:</b> " + sl.getSystemId());
                }
            }
            
            model.getGui().getGuiView().setErrorView(MyIntl.VE_BUILDUTIL_5 + StringUtil.formatOutput(t.getClass().getName()) + "<br><br>");
            model.getGui().getGuiView().setErrorView(MyIntl.VE_BUILDUTIL_6);
            
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(t.getLocalizedMessage()) + "<br><br>");
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(t.getMessage()) + "<br><br>");
            model.getGui().getGuiView().setErrorView(StringUtil.formatOutput(t.toString()) + "<br><br>");
            
            return false;
        }
    }
    
    //-------------------------------------------------------------------------
    
    private static void scanForSafeZones(File xmlSourceFile, Document document, File outputFile) throws Exception {
        // Creates a temporary has of safe zones where
        // the key is the ID of the zone and the value
        // is the code within the safe zone
        Hashtable safeZones = new Hashtable();
        
        // The start and end patterns
        Pattern startPattern = Pattern.compile( "\\p{ASCII}+START-SAFE\\((.*?)\\)" );
        Pattern endPattern = Pattern.compile( "\\p{ASCII}+END-SAFE" );
             
        BufferedReader outputFileReader = new BufferedReader( new FileReader( outputFile ) );
        
        // Set up the state machine variables
        boolean inSafeZone = false;
        String zoneName = "";
        StringBuffer safeBuffer = new StringBuffer();
        
        // Go through the Java code a line at
        // a time looking for safe zones
        String line;
        while( ( line = outputFileReader.readLine() ) != null ) {
            if ( inSafeZone ) {
                if (endPattern.matcher( line ).matches()) {
                    safeZones.put( zoneName,safeBuffer.toString() );
                    inSafeZone = false;
                    safeBuffer.setLength( 0 );
                }
                else {
                    safeBuffer.append( line + "\n" );
                }
            }
            else {
                Matcher match = startPattern.matcher( line );
                if ( match.matches() ) {
                    inSafeZone = true;
                    zoneName = match.group( 1 );
                }
            }
        }
        
        outputFileReader.close();
        
        
      Element root = document.getDocumentElement();
        //retirar todos as safezones do source
        NodeList nodes = root.getElementsByTagName("safezone");
        for (int i=0; i < nodes.getLength(); i++) {
            nodes.item(i).getParentNode().removeChild(nodes.item(i));
        }
        
        // For each zone we find add a node
        // in the input DOM
        for (Enumeration sz = safeZones.keys();sz.hasMoreElements();) {
            zoneName = ( String )sz.nextElement( );
            String zoneValue = ( String )safeZones.get( zoneName );
            
            Element elem = document.createElement( "safezone" );
            elem.setAttribute( "id", zoneName );
            elem.appendChild (document.createCDATASection( zoneValue ) );
            
//            System.out.println("Safe soze ok");
//            System.out.println("zoneName: " + zoneName);
//            System.out.println("zoneValue" + zoneValue);
            
            root.appendChild( elem );
        }
        
        StringWriter writer = new StringWriter();
        Transformer transformer;
        try {
          transformer = TransformerFactory.newInstance().newTransformer();
        }
        catch (TransformerConfigurationException e) {
          throw new Exception("Could not create a transformer.", e);
        }
        
        try {
          transformer.transform(new DOMSource(document), new StreamResult(writer));
        }
        catch (TransformerException e) {
          throw new Exception("Could not transform document.", e);
        }        
        try {
            FileUtils.writeStringToFile(xmlSourceFile, writer.toString(), "UTF-8");
//        System.out.println(writer.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
}

