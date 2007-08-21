<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineSetters">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
	<body>cor: newcor<xsl:value-of select="$newlineResourceTypeDefault"/>
		self update: 'cor' to: newcor.<xsl:value-of select="$newlineResourceTypeDefault"/>
		self changed: #cor.<xsl:value-of select="$newlineResourceTypeDefault"/>
		self isChanged: true.</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	-->
	<xsl:template name="setters">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineSetters"/>
		
		<xsl:for-each select="attributes/attribute">
	
<body><xsl:value-of select="name"/>: new<xsl:value-of select="name"/>
		self update: '<xsl:value-of select="name"/>' to: new<xsl:value-of select="name"/>.
		self changed: #<xsl:value-of select="name"/>.
		self isChanged: true.</body><xsl:value-of select="$newlineSetters"/><xsl:value-of select="$newlineSetters"/>
	
		</xsl:for-each>
		
	</xsl:template>

</xsl:stylesheet>