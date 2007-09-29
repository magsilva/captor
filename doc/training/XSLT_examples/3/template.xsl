<?xml version="1.0"?> 

<!--
	The Dummy XML was improved with a for-each and an if statement.
	
	It print all messages given by the "/root/message" XPath location except by the 
	message that has the value 'Hello World 2'
-->	

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
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
			
			<xsl:if test=".!='Hello World 2'">
				<xsl:value-of select="."/><xsl:value-of select="$newline"/>
			</xsl:if>	
		
		</xsl:for-each>

	</xsl:template>

</xsl:stylesheet>