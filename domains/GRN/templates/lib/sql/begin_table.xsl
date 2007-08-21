<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="begin_table">
		
		<xsl:param name="comment"/>
		<xsl:param name="grenclass"/>
		<xsl:param name="class"/>

#<xsl:value-of select="$comment"/><xsl:value-of select="$newline"/>
	
<xsl:text>drop table IF EXISTS </xsl:text><xsl:for-each select="$grenclass"><xsl:if test="@name=$class"><xsl:value-of select="class"/></xsl:if></xsl:for-each>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:for-each select="$grenclass"><xsl:if test="@name=$class"><xsl:value-of select="class"/></xsl:if></xsl:for-each><xsl:text>(
		  		idCode integer not null, 
		  		description char(35)</xsl:text></xsl:template>

</xsl:stylesheet> 

