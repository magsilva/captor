<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  
	<xsl:template name="p4v1">

  	
	<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">

		<!--________________________________________________________________-->
		<!--_______TABELA DE TAXADEMULTA (finerate) ________________________-->
		<!--________________________________________________________________-->
		
		<xsl:if test="@name='TaxaDeMulta'">
		
		<xsl:variable name="tableName" select="class"/>
#Tabela de taxa de multa do aluguel do recurso
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(

</xsl:text>
<xsl:text>	  			</xsl:text>percentageRate float,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>lowernumber integer,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>uppernumber integer);<xsl:value-of select="newline"/><xsl:text>
</xsl:text>

		</xsl:if>


		<!--________________________________________________________________-->
		<!--_______TABELA DE DESTINATION ___________________________________-->
		<!--________________________________________________________________-->

		<xsl:if test="@name='Destino'">
		<xsl:variable name="tableName" select="class"/>
#Tabela de destino de recurso
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(

</xsl:text>

<xsl:text>	  			</xsl:text>IdCode integer NOT NULL,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>description char(35)<xsl:value-of select="newline"/><xsl:text>
</xsl:text>

<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
	<xsl:if test="@name='Destino'">
		<xsl:for-each select="attributes/attribute">
			<xsl:call-template name="variables">
				<xsl:with-param name="name" select="name"/>
				<xsl:with-param name="type" select="type"/>
				<xsl:with-param name="length" select="length"/>
			</xsl:call-template>
		</xsl:for-each>);
	</xsl:if>
</xsl:for-each>

		</xsl:if>

		<!--________________________________________________________________-->
		<!--_______TABELA DE RESOURCE RENT__________________________________-->
		<!--________________________________________________________________-->

		<xsl:if test="@name='Aluguel'">
		<xsl:variable name="tableName" select="class"/>
#Tabela de aluguel de recurso
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(
</xsl:text>
<xsl:value-of select="newline"/>
		  		
<xsl:text>	  			</xsl:text>number integer not null, <xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>date date,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>observation char(60),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>status char(1),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>totalPrice float,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>totalDiscount float,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>destinationParty integer,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>

	<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
		<xsl:if test="@name='Origem'">
<xsl:text>	  			</xsl:text>sourceParty integer,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
		</xsl:if>
	</xsl:for-each>

<xsl:choose>
<xsl:when test="/formsData/forms/form/form/form/form/@id='11.1'">
</xsl:when>
<xsl:otherwise>
<xsl:text>	  			</xsl:text>resource integer,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
</xsl:otherwise>
</xsl:choose>

<xsl:choose>
<xsl:when test="/formsData/forms/form/form/form/form/@id='11.1'">
</xsl:when>
<xsl:when test="/formsData/forms/form/form/@id='2.2'">
<xsl:text>	  			</xsl:text>instanceCode char(10),<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
</xsl:when>
</xsl:choose>

<xsl:text>	  			</xsl:text>finishingDate date,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>returnDate date,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>fineValue float<xsl:value-of select="newline"/><xsl:text>
</xsl:text>

<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
	<xsl:if test="@name='Aluguel'">
		<xsl:for-each select="attributes/attribute">
			<xsl:call-template name="variables">
				<xsl:with-param name="name" select="name"/>
				<xsl:with-param name="type" select="type"/>
				<xsl:with-param name="length" select="length"/>
			</xsl:call-template>
		</xsl:for-each>);
	</xsl:if>
</xsl:for-each>

		</xsl:if>

		<!--________________________________________________________________-->
		<!--_______TABELA DE ORIGEM ________________________________________-->
		<!--________________________________________________________________-->

		<xsl:if test="@name='Origem'">
		<xsl:variable name="tableName" select="class"/>
#Tabela de origem do recurso (departamento ou filial)
drop table IF EXISTS <xsl:value-of select="$tableName"/>;

<xsl:text>create table IF NOT EXISTS </xsl:text><xsl:value-of select="$tableName"/><xsl:text>(
</xsl:text>
  	

<xsl:value-of select="newline"/>
<xsl:text>	  			</xsl:text>IdCode integer NOT NULL,<xsl:value-of select="newline"/><xsl:text>
</xsl:text>
<xsl:text>	  			</xsl:text>description char(35)<xsl:value-of select="newline"/><xsl:text>
</xsl:text>

<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
	<xsl:if test="@name='Origem'">
		<xsl:for-each select="attributes/attribute">
			<xsl:call-template name="variables">
				<xsl:with-param name="name" select="name"/>
				<xsl:with-param name="type" select="type"/>
				<xsl:with-param name="length" select="length"/>
			</xsl:call-template>
		</xsl:for-each>);
	</xsl:if>
</xsl:for-each>

		</xsl:if>

		<!--________________________________________________________________-->

	</xsl:for-each>
		
	</xsl:template>

</xsl:stylesheet>