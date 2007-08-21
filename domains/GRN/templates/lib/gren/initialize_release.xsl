<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInitializeRelease">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
<body>initialize 
			    super initialize.
					 cor := '' asValue</body>
	-->
	
	<xsl:template name="initialize_release">
		
		<xsl:param name="attributes"/>
		
<xsl:value-of select="$newlineInitializeRelease"/>
<body>initialize
		super initialize.<xsl:value-of select="$newlineInitializeRelease"/><xsl:for-each select="attributes/attribute">
<xsl:text>			</xsl:text><xsl:value-of select="name"/> := '' asValue.<xsl:value-of select="$newlineInitializeRelease"/></xsl:for-each></body>
		
		<xsl:value-of select="$newlineInitializeRelease"/>
		
	</xsl:template>

</xsl:stylesheet>