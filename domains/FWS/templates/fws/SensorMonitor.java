<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/">
	<xsl:variable name="NumSensors">
		<xsl:for-each select="/formsData/forms/form/form/form">
			<xsl:if test="position()=last()">
						<xsl:value-of select="position()"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:variable>
package fws;

import fwslib.DataBanker;
import fwslib.Runner;
import fwslib.driver.*;

/**
 * @author Captor
 *
 */
public class SensorMonitor extends Thread {

    Runner runner;
    
    public SensorMonitor(Runner runner)  {
        this.runner = runner;
    }

    //-------------------------------------------------------------------------

    public void run() {
        while ( true )  {
            
            if ( !runner.isRun() )
                return;

            try {
                Thread.sleep(FWS.SensorPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            
						<xsl:for-each select="/formsData/forms/form/form/form">
							<xsl:if test="data/combo='High'">
		            DataBanker.write(HighResSensorDriver.get(<xsl:value-of select="position()"/>));
	            </xsl:if>
							<xsl:if test="data/combo='Low'">
		            DataBanker.write(LowResSensorDriver.get(<xsl:value-of select="position()"/>));
	            </xsl:if>
						</xsl:for-each>
            
        }
    }

}
	</xsl:template>

</xsl:stylesheet>