<?xml version="1.0"?> 

<!--
	The Dummy XML was improved with modular design.
	Now the main template delegates the print commands to a template named 'print'.
	
	It still print all messages given by the "/root/message" XPath location.
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="text"/>
  
	<xsl:variable name="newline">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--
		Main template callback.
		The execution starts here.
	-->
	<xsl:template match="/">

		<xsl:for-each select="/root/message">
			
				<xsl:call-template name="print">
					<xsl:with-param name="message" select="."/>
				</xsl:call-template>

		</xsl:for-each>

	</xsl:template>

	<!--______________________________________________________________________-->

	<xsl:template name="print">
				<xsl:param name="message"/>
				
				<xsl:value-of select="$message"/><xsl:value-of select="$newline"/>
	</xsl:template>

	<!--______________________________________________________________________-->

</xsl:stylesheet>