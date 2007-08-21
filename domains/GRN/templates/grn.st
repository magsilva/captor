<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!--______________________________________________________________________-->

	<xsl:include href="lib/gren/patterns.xsl"/>
	<xsl:include href="lib/gren/main_window.xsl"/>

	<xsl:output method="xml"/>
	
	<xsl:variable name="newline">
<xsl:text>
</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="ident">
		<xsl:text>        </xsl:text>
	</xsl:variable>
	

	<!--______________________________________________________________________-->

	<xsl:template match="/">

	<xsl:value-of select="$newline"/>
	<xsl:value-of select="$newline"/>
	<xsl:comment>Header </xsl:comment><xsl:value-of select="$newline"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newline"/>
	<xsl:value-of select="$newline"/>


<!--HEADER-->
<st-source><xsl:value-of select="$newline"/><xsl:value-of select="$newline"/>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 28 de Junho de 2005 at 1:26:33 pm</time-stamp><xsl:value-of select="$newline"/>
<xsl:value-of select="$newline"/>

<name-space><xsl:value-of select="$newline"/>
<name><xsl:value-of select="formsData/project/name"/></name><xsl:value-of select="$newline"/>
<environment>Smalltalk</environment><xsl:value-of select="$newline"/>
<private>false</private><xsl:value-of select="$newline"/>
<imports><xsl:value-of select="$newline"/>
<xsl:value-of select="$ident"/>private Smalltalk.*<xsl:value-of select="$newline"/>
<xsl:value-of select="$ident"/>private GREN.*<xsl:value-of select="$newline"/>
</imports><xsl:value-of select="$newline"/>
<category><xsl:value-of select="formsData/project/name"/></category><xsl:value-of select="$newline"/>
</name-space><xsl:value-of select="$newline"/>
	
		<!--PATTERNS-->
		<xsl:apply-templates select="/formsData/forms"/>
		<!--/PATTERNS-->
		
		<!--MAIN WINDOW-->
		<xsl:call-template name="main_window"/>
		<!--/MAIN WINDOW-->
		
<xsl:value-of select="$newline"/><xsl:value-of select="$newline"/><xsl:value-of select="$newline"/>
</st-source>
<!--/HEADER-->

	</xsl:template>

</xsl:stylesheet>