<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="p2v2">

		<!--________________________________________________________________-->
		<!--_______TABELA DE INSTANCIA DE RECURSO___________________________-->
		<!--________________________________________________________________-->
  	
	<xsl:for-each select="/formsData/forms/form/form/data/grenclass">
		<xsl:if test="@name='InstanciaDoRecurso'">
		<xsl:variable name="tableName" select="class"/>
#Tabela de instancia de recurso
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(
</xsl:text>
		</xsl:if>
	</xsl:for-each>
  	

<xsl:value-of select="newline"/>
<xsl:text>	  			</xsl:text>resourceIdCode integer,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>code char(10),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>allocation char(35),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>				  </xsl:text>status char(1)<xsl:value-of select="newline"/>

		<xsl:for-each select="/formsData/forms/form/form/data/grenclass">
			<xsl:if test="@name='InstanciaDoRecurso'">
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