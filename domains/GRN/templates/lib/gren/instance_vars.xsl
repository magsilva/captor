<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInstanceVars">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
		atoresPrincipais anoDoFilme precoDeLocacao diretor dubladaOuLegendada </inst-vars>
	-->
	<xsl:template name="instance_vars">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineInstanceVars"/>

		<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars>
		
		<xsl:value-of select="$newlineInstanceVars"/>
	</xsl:template>

</xsl:stylesheet>