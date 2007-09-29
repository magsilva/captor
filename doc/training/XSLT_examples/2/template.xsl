<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!--
	The Dummy XML was improved with a for-each statement.
	
	It print all messages given by the "/root/message" XPath location.
-->	
  
  <xsl:output method="text"/>
  
	<!--
		A variable newLine to print end line caracteres.
	-->

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
			<xsl:value-of select="."/><xsl:value-of select="$newline"/>
		</xsl:for-each>

	</xsl:template>

</xsl:stylesheet>