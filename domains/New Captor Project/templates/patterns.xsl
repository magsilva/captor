<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!--______________________________________________________________________-->

	<xsl:output method="xml"/>
	
	<!--______________________________________________________________________-->

	<xsl:template name="patterns">
		<xsl:param name="attributes"/>

			<!--PATTERN-->
			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			
			<xsl:choose>
				<xsl:when test="data/patternId='1.1'">
					<form isRoot="true">
						
						<xsl:call-template name="body">
							<xsl:with-param name="body" select="."/>
						</xsl:call-template>
						
					<xsl:value-of select="$newline"/>
					<xsl:value-of select="$ident"/>
					</form>
					<xsl:value-of select="$newline"/>
				</xsl:when>
				<xsl:otherwise>
					<form>
					
						<xsl:call-template name="body">
							<xsl:with-param name="body" select="."/>
						</xsl:call-template>
					
					<xsl:value-of select="$newline"/>
					<xsl:value-of select="$ident"/>
					</form>
					<xsl:value-of select="$newline"/>
				</xsl:otherwise>
			</xsl:choose>

  		<xsl:for-each select="form">
	  		<xsl:call-template name="patterns">
		  		<xsl:with-param name="pattern" select="."/>
			  </xsl:call-template>
		  </xsl:for-each>

	</xsl:template>

	<!--______________________________________________________________________-->

</xsl:stylesheet>