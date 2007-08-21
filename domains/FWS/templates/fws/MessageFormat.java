<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/">
	
	<xsl:variable name="MsgType">
		<xsl:value-of select="/formsData/forms/form/form[@id='3.1']/data/combo"/>
	</xsl:variable>

package fws;

import java.util.Vector;

/**
 * @author Captor
 *
 */
public class MessageFormat {

    static int msgNum = 0;
    
    public static String create(int i) {

// START-SAFE(TestZone)
<xsl:value-of select="/formsData/safezone[@id='TestZone']"/>// END-SAFE
        
        msgNum++;
        
        String s = new String();
        s = s.concat(FWS.MsgType);
        s = s.concat(":");
        s = s.concat(FWS.ID);
        s = s.concat(":");
        s = s.concat(new Integer(i).toString());
        <xsl:if test="$MsgType='LONGMSG'">
        try {
          Integer mn = new Integer(msgNum);
		      s = s.concat(":");
    	    s = s.concat(mn.toString());
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        </xsl:if>
        
        return s;
    }
}
	</xsl:template>

</xsl:stylesheet>