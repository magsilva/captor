<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="p1v2">

		<!--________________________________________________________________-->
		<!--_______________TABELA DE RECURSO________________________________-->
		<!--________________________________________________________________-->
  	
<xsl:variable name="comment" select="'Tabela de Recurso'"/>

#<xsl:value-of select="$comment"/><xsl:value-of select="$newline"/>
	
<xsl:text>drop table IF EXISTS </xsl:text><xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="@name='Recurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="@name='Recurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each><xsl:text>(
					idCode integer not null 
					,description char(35)</xsl:text>

<xsl:if test="/formsData/forms/form/form/@id='2.1'"><xsl:value-of select="$newline"/><xsl:text>					</xsl:text>,status char(1)<xsl:value-of select="newline"/></xsl:if>
		
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="$newline"/><xsl:text>					,</xsl:text><xsl:value-of select="name"/><xsl:text> </xsl:text><xsl:value-of select="type"/><xsl:if test="type='char'">(<xsl:value-of select="length"/>)</xsl:if>
				</xsl:for-each>
			</xsl:if>
		</xsl:for-each>
		
		<xsl:value-of select="$newline"/><xsl:text>					);</xsl:text>
 	
	</xsl:template>

</xsl:stylesheet>