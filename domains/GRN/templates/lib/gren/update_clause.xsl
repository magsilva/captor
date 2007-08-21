<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineUpdateClause">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
		<body>updateSetClause<xsl:value-of select="$newlineResourceTypeDefault"/>
			    ^super updateSetClause,', cor = ' ,self cor printString</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	-->
	<xsl:template name="update_clause">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineUpdateClause"/>
		
		<body>updateSetClause
			^super updateSetClause<xsl:for-each select="attributes/attribute">,', <xsl:value-of select="name"/> =', self <xsl:value-of select="name"/> <xsl:text> </xsl:text><xsl:choose><xsl:when test="type='date'">printForSaving</xsl:when><xsl:otherwise>printString</xsl:otherwise></xsl:choose> </xsl:for-each>.</body><xsl:value-of select="$newlineUpdateClause"/>
		
		<xsl:value-of select="$newlineUpdateClause"/>		
		
	</xsl:template>

</xsl:stylesheet>