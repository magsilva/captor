<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/">
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
	<!--______________________________________________________________________-->
package testcase;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fws.FWS;
import fws.MessageFormat;

/**
 * @author Captor
 *
 */
public class MessageFormatTest extends TestCase {
	
    public static Test suite()  {
        return new TestSuite(MessageFormatTest.class);
    }
    
    //-------------------------------------------------------------------------
    
		public static void main(String args[]) { 
		    junit.textui.TestRunner.run(suite());
		}

		<xsl:if test="$MsgType='LONGMSG'">
    //-------------------------------------------------------------------------

    public void testLongMsg() {
        String message = MessageFormat.create(10);
        
        assertEquals(message, "LONGMSG:" + FWS.ID + ":10" + ":1");
    }
    </xsl:if>

		<xsl:if test="$MsgType='SHORTMSG'">
    //-------------------------------------------------------------------------

    public void testShortMsg() {
        String message = MessageFormat.create(10);
        
        assertEquals(message, "SHORTMSG:" + FWS.ID + ":10");
    }
    </xsl:if>
}
	</xsl:template>

</xsl:stylesheet>