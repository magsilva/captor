<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="p11v1">

  	
	<xsl:for-each select="/formsData/forms/form/form/form/form/data/grenclass">
		<!--________________________________________________________________-->
		<!--_______TABELA DE ITEM __________________________________________-->
		<!--________________________________________________________________-->

		<xsl:if test="@name='ItemDaTransacao'">
		<xsl:variable name="tableName" select="class"/>

#Tabela de origem de item de recurso
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(
</xsl:text>
  	

<xsl:value-of select="newline"/>
<xsl:text>	  			</xsl:text>transaction integer NOT NULL,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>resource char(35),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>value float<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<xsl:text>	  			</xsl:text>,instanceCode char(10)<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
</xsl:if>);

		</xsl:if>

		<!--________________________________________________________________-->

	</xsl:for-each>
		
	</xsl:template>

</xsl:stylesheet>