<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineAspects">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
<body>cor
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #cor.
		^adaptor</body>
	-->
	<xsl:template name="aspects">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineAspects"/>
		<xsl:for-each select="attributes/attribute">
			<xsl:value-of select="$newlineAspects"/>			
			
<body><xsl:value-of select="name"/>
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #<xsl:value-of select="name"/>.
		^adaptor</body><xsl:value-of select="$newlineAspects"/>
			
		</xsl:for-each>
		
		<xsl:value-of select="$newlineAspects"/>		
		
	</xsl:template>

</xsl:stylesheet>