<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInitialize">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
initialize
		super initialize.
			aaa := ''.
			bbb := Date today.
			ccc := 0.0.
			ddd := 0.
	-->
	<xsl:template name="initialize">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineInitialize"/>
		
		<body>initialize
		super initialize.
			<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="$newlineInitialize"/><xsl:text>			</xsl:text><xsl:value-of select="name"/> := <xsl:if test="type='char'">''.</xsl:if><xsl:if test="type='integer'">0.</xsl:if><xsl:if test="type='float'">0.00.</xsl:if><xsl:if test="type='date'">Date today.</xsl:if></xsl:for-each>
		</body>
			
		<xsl:value-of select="$newlineInitialize"/>		
		
	</xsl:template>

</xsl:stylesheet>