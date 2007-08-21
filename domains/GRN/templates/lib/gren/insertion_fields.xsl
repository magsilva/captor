<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInsertionField">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
		insertionFieldClause
			^super insertionFieldClause,', endereco, cidade, estado, tel, documento, email, dtaNasc'.	
	-->
	<xsl:template name="insertion_fields">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineInsertionField"/>
		
		<body>insertionFieldClause
			^super insertionFieldClause,'<xsl:for-each select="attributes/attribute">, <xsl:value-of select="name"/></xsl:for-each>'.</body><xsl:value-of select="$newlineInsertionField"/>
		
		<xsl:value-of select="$newlineInsertionField"/>		
		
	</xsl:template>

</xsl:stylesheet>