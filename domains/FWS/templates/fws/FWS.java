<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:variable name="newline">
<xsl:text>
</xsl:text>
	</xsl:variable>
	<xsl:variable name="ident">
		<xsl:text>        </xsl:text>
	</xsl:variable>
	<!--______________________________________________________________________-->
	<xsl:template match="/">
	<xsl:variable name="SensorPeriod">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='SensorPeriod'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="MsgType">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='MsgType'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="TransmitPeriod">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='TransmitPeriod'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="HistoryLength">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='HistoryLength'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="HighResolutionWeight">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='HighResolutionWeight'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="LowResolutionWeight">
		<xsl:for-each select="/formsData/forms/form/form">
			<xsl:if test="@id='3.1'">
			
				<xsl:for-each select="data/combo">
					<xsl:if test="@name='LowResolutionWeight'">
						<xsl:value-of select="."/>
					</xsl:if>
				</xsl:for-each>
				
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<!--__________________________________________________________________________-->
	
	<xsl:variable name="WindGeneratorHost">
		<xsl:choose>
			<xsl:when test="count(/formsData/forms/form/form[@id='2.1']/data/textatt[@name='WindGeneratorHost'])=0">localhost</xsl:when>
			<xsl:otherwise><xsl:value-of select="/formsData/forms/form/form[@id='2.1']/data/textatt[@name='WindGeneratorHost']"/></xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="WindGeneratorPort">
		<xsl:choose>
			<xsl:when test="count(/formsData/forms/form/form[@id='2.1']/data/textatt[@name='WindGeneratorPort'])=0">4017</xsl:when>
			<xsl:otherwise><xsl:value-of select="/formsData/forms/form/form[@id='2.1']/data/textatt[@name='WindGeneratorPort']"/></xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="ControlTowerHost">
		<xsl:choose>
			<xsl:when test="count(/formsData/forms/form/form[@id='2.1']/data/textatt[@name='ControlTowerHost'])=0">localhost</xsl:when>
			<xsl:otherwise><xsl:value-of select="/formsData/forms/form/form[@id='2.1']/data/textatt[@name='ControlTowerHost']"/></xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="ControlTowerPort">
		<xsl:choose>
			<xsl:when test="count(/formsData/forms/form/form[@id='2.1']/data/textatt[@name='ControlTowerPort'])=0">4018</xsl:when>
			<xsl:otherwise><xsl:value-of select="/formsData/forms/form/form[@id='2.1']/data/textatt[@name='ControlTowerPort']"/></xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<!--__________________________________________________________________________-->
	<xsl:variable name="NumSensors">
		<xsl:for-each select="/formsData/forms/form/form/form">
			<xsl:if test="position()=last()">
						<xsl:value-of select="position()"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<!--__________________________________________________________________________-->
	<xsl:variable name="Title">
		<xsl:for-each select="/formsData/forms/form/data/textatt">
			<xsl:if test="@name='ApplicationTitle'">
				<xsl:value-of select="."/>
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="ApplicationId">
		<xsl:for-each select="/formsData/forms/form/data/textatt">
			<xsl:if test="@name='ApplicationId'">
				<xsl:value-of select="."/>
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
	<!--__________________________________________________________________________-->
package fws;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fwslib.DataBanker;
import fwslib.Runner;
import fwslib.FWSPrintStream;
import fwslib.MessageGenerator;


/**
 * @author Captor
 *
 */
public class FWS extends JFrame implements ActionListener, WindowListener {

    public static final int SensorPeriod = <xsl:value-of select="$SensorPeriod"/> * 100;
    public static final int TransmitPeriod = <xsl:value-of select="$TransmitPeriod"/> * 100;
    public static final int LowResWeight = <xsl:value-of select="$HighResolutionWeight"/>;
    public static final int HighResWeight = <xsl:value-of select="$LowResolutionWeight"/>;
    public static final String MsgType = "<xsl:value-of select="$MsgType"/>";

    public static final int NumSensors = <xsl:value-of select="$NumSensors"/>;
    public static final int HistoryLenght = <xsl:value-of select="$HistoryLength"/> * NumSensors;
    public static final String ID = "<xsl:value-of select="$ApplicationId"/>";
    
    //-------------------------------------------------------------------------
    
    public static final int WIND_GENERATOR_PORT = <xsl:value-of select="$WindGeneratorPort"/>;
    public static final int CONTROL_TOWER_PORT = <xsl:value-of select="$ControlTowerPort"/>;
    public static final String WIND_GENERATOR_HOST = "<xsl:value-of select="$WindGeneratorHost"/>";
    public static final String CONTROL_TOWER_HOST = "<xsl:value-of select="$ControlTowerHost"/>";
    
    //-------------------------------------------------------------------------
    
    JTextArea msgTA = new JTextArea();
    JButton startButton = new JButton();
    JButton cleanButton = new JButton();
    JScrollPane scrollPane;
    Runner runner = new Runner();

    //-------------------------------------------------------------------------
    
    public FWS()  {
    	
// START-SAFE(TestZone)
<xsl:value-of select="/formsData/safezone[@id='TestZone']"/>// END-SAFE

        this.setTitle("<xsl:value-of select="$Title"/>");

        this.getContentPane().setLayout(null);
        this.setTitle("<xsl:value-of select="$Title"/>");
        this.setSize(new Dimension(500,340));

        startButton.setText("Start");
        cleanButton.setText("Clean");
        
        scrollPane = new JScrollPane(msgTA);
        scrollPane.setBounds(new Rectangle(10, 10, 474, 250));
        
        startButton.setBounds(new Rectangle(10, 270, 70, 25));
        cleanButton.setBounds(new Rectangle(90, 270, 70, 25));
        
        startButton.addActionListener(this);
        cleanButton.addActionListener(this);

        this.getContentPane().add(startButton, null);
        this.getContentPane().add(cleanButton, null);
        this.getContentPane().add(scrollPane, null);
        this.addWindowListener(this);
        
        redirectLog();
    }
    
	//-------------------------------------------------------------------------

    public static void main(String[] args)  {
	    FWS fws = new FWS();
	    fws.setVisible(true);
	}

	//-------------------------------------------------------------------------

	public void actionPerformed(ActionEvent e)  {
        
	    if ( e.getActionCommand().equals("Start") )  {
		    startButton.setText("Stop");
	
	        runner.setRun(true);
	        DataBanker.init();
	        MessageGenerator m = new MessageGenerator(runner);
	        m.start();
	        
	        SensorMonitor s = new SensorMonitor(runner);
	        s.start();
	    }
	    else  if ( e.getActionCommand().equals("Stop") ) {
		    startButton.setText("Start");
	        runner.setRun(false);
	    }
	    else  if ( e.getActionCommand().equals("Clean") ) {
	        msgTA.setText("");
	    }
    
	}
	
	//-------------------------------------------------------------------------

	public void redirectLog()  {
      BufferedOutputStream bos = new BufferedOutputStream(new ByteArrayOutputStream());
      FWSPrintStream printStream = new FWSPrintStream(this, bos, true);
	}

	//-------------------------------------------------------------------------
	
	public void setMsg(String s)  {
	    msgTA.setText(msgTA.getText() + "\n" + s);
	}
	
	//-------------------------------------------------------------------------
    
	public void windowClosed(WindowEvent e)       {}
    public void windowOpened(WindowEvent e)       {}
    public void windowIconified(WindowEvent e)    {}
    public void windowDeiconified(WindowEvent e)  {}
    public void windowActivated(WindowEvent e)    {}
    public void windowDeactivated(WindowEvent e)  {}
    public void windowStateChanged(WindowEvent e) {}
    
    //-------------------------------------------------------------------------
    
    public void windowClosing(WindowEvent event) {
        runner.setRun(false);
        
				try {
        	Thread.sleep(1500);
				} catch (InterruptedException e) {
        	System.out.println(e);
        }
        
        System.exit(0);
    }

    //-------------------------------------------------------------------------
}
	</xsl:template>

</xsl:stylesheet>