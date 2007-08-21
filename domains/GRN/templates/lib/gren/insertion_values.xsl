<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInsertionValue">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
		<body>insertionValueClause 
	    		^super insertionValueClause, ',', self data printForSaving, ',', self numero printString, ',', self nome printString</body>
	-->
	<xsl:template name="insertion_values">
		
		<xsl:param name="attributes"/>

		<xsl:value-of select="$newlineInsertionValue"/>
		
		<body>insertionValueClause
    			^super insertionValueClause <xsl:for-each select="attributes/attribute">, ',', self <xsl:value-of select="name"/><xsl:text> </xsl:text><xsl:choose><xsl:when test="type='date'">printForSaving</xsl:when><xsl:otherwise>printString</xsl:otherwise></xsl:choose> </xsl:for-each></body><xsl:value-of select="$newlineInsertionValue"/>
		
		<xsl:value-of select="$newlineInsertionValue"/>		
	</xsl:template>

</xsl:stylesheet>