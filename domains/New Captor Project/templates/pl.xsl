<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:include href="patterns.xsl"/>
	<xsl:include href="body.xsl"/>

	<!--______________________________________________________________________-->

	<xsl:output method="xml"/>
	
	<xsl:variable name="newline">
<xsl:text>
</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="ident"><xsl:text>      </xsl:text></xsl:variable>
	
	<!--______________________________________________________________________-->

	<xsl:template match="/">
	
		<!--______________________________________________________________________-->
		
		<xsl:value-of select="$newline"/>
		<xsl:value-of select="$newline"/>
		<forms><xsl:value-of select="$newline"/>
		
			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<name><xsl:value-of select="/formsData/project/name"/></name>
			<xsl:value-of select="$newline"/>

		<!--______________________________________________________________________-->

			<xsl:for-each select="/formsData/forms/form/form">
				<xsl:for-each select="form">

					<xsl:call-template name="patterns">
						<xsl:with-param name="pattern" select="."/>
					</xsl:call-template>

				</xsl:for-each>
			</xsl:for-each>

		<!--______________________________________________________________________-->

		<xsl:value-of select="$newline"/>
		</forms>
		<xsl:value-of select="$newline"/>

		<!--______________________________________________________________________-->

	</xsl:template>

</xsl:stylesheet>