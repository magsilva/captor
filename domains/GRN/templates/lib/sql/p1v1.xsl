<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="p1v1">

		<!--________________________________________________________________-->
		<!--_______________TABELA DE RECURSO________________________________-->
		<!--________________________________________________________________-->
  	

<xsl:variable name="comment" select="'Tabela de Recurso'"/>

#<xsl:value-of select="$comment"/><xsl:value-of select="$newline"/>
	
<xsl:text>drop table IF EXISTS </xsl:text><xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="@name='Recurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="@name='Recurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each><xsl:text>(
					idCode integer not null 
					,description char(35)</xsl:text>

<xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="@name='TipoDoRecurso'"><xsl:text>
					</xsl:text>,<xsl:value-of select="class"/> char(1)<xsl:value-of select="newline"/></xsl:if></xsl:for-each>

<xsl:if test="/formsData/forms/form/form/@id='2.1'"><xsl:value-of select="$newline"/><xsl:text>					</xsl:text>,status char(1)<xsl:value-of select="newline"/></xsl:if>

		
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="$newline"/><xsl:text>					,</xsl:text><xsl:value-of select="name"/><xsl:text> </xsl:text><xsl:value-of select="type"/><xsl:if test="type='char'">(<xsl:value-of select="length"/>)</xsl:if>
				</xsl:for-each>
			</xsl:if>
		</xsl:for-each>
		
		<xsl:value-of select="$newline"/><xsl:text>					);</xsl:text>
		
		
		<!--________________________________________________________________-->
		<!--_______________TABELA DE TIPO DE RECURSO________________________-->
		<!--________________________________________________________________-->


		<xsl:call-template name="begin_table">
			<xsl:with-param name="comment" select="'Tabela de Tipo de Recurso'"/>
			<xsl:with-param name="grenclass" select="/formsData/forms/form/data/grenclass"/>
			<xsl:with-param name="class" select="'TipoDoRecurso'"/>
		</xsl:call-template>
		
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='TipoDoRecurso'">
				<xsl:for-each select="attributes/attribute">
					<xsl:call-template name="variables">
					  	<xsl:with-param name="name" select="name"/>
  						<xsl:with-param name="type" select="type"/>
  						<xsl:with-param name="length" select="length"/>
					</xsl:call-template>
				</xsl:for-each>);

			</xsl:if>
		</xsl:for-each>

 	
	</xsl:template>

</xsl:stylesheet>