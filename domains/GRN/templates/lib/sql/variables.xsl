<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  	<xsl:output method="text"/>
  
	<xsl:template name="variables">
	  	<xsl:param name="name"/>
  		<xsl:param name="type"/>
  		<xsl:param name="length"/><xsl:text>					,</xsl:text><xsl:value-of select="$name"/><xsl:text> </xsl:text><xsl:value-of select="$type"/><xsl:if test="type=$char_type">(<xsl:value-of select="$length"/>)</xsl:if><xsl:text>
</xsl:text></xsl:template>

</xsl:stylesheet> 

