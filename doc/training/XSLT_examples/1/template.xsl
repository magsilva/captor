<?xml version="1.0"?> 

<!--
	This is the simplest XSL template that can be written.
	It is called Dummie XSL.
	
	It simply print a message given by the "/root/message" XPath location.
-->	

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="text"/>
  
	<!--
		Main template callback.
		The execution starts here.
	-->	
	<xsl:template match="/">

		<xsl:value-of select="/root/message"/>

	</xsl:template>

</xsl:stylesheet>