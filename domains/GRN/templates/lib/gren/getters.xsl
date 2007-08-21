<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineGetters">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
	<body>cor<xsl:value-of select="$newlineResourceTypeDefault"/>
		^cor</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	-->

	<xsl:template name="getters">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineGetters"/>

		<xsl:for-each select="attributes/attribute">
<body><xsl:value-of select="name"/>
	^<xsl:value-of select="name"/></body><xsl:value-of select="$newlineGetters"/>
		</xsl:for-each>
		
	</xsl:template>


</xsl:stylesheet>