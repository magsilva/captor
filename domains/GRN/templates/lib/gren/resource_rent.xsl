<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:include href="p4v1_finerate.xsl"/>
	<xsl:include href="p4v1_rent.xsl"/>
	<xsl:include href="p4v1_source.xsl"/>
	<xsl:include href="p4v1_destino.xsl"/>


	<xsl:variable name="newlineRentResource">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="resource_rent">

		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">


	<xsl:if test="@name='TaxaDeMulta'">

	<xsl:value-of select="$newlineRentResource"/>
	
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:comment> Classe: RENT: Padrao: Alugar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>

	<!-- CLASSE FINERATE-->
			<xsl:call-template name="p4v1_finerate"/>
	<!-- /FINERATE-->

	</xsl:if>
	
	<xsl:if test="@name='Aluguel'">

	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:comment> Classe: RENTFORM: Padrao: Alugar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>

	<!-- CLASSE RENT-->
			<xsl:call-template name="p4v1_rent"/>
	<!-- /CLASSE RENT-->

	</xsl:if>

	<xsl:if test="@name='Destino'">

	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:comment> Classe: DESTINO: Padrao: Alugar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>

	<!-- CLASSE DESTINO-->
			<xsl:call-template name="p4v1_destino"/>
	<!-- /CLASSE DESTINO-->
	
	</xsl:if>

	<xsl:if test="@name='Origem'">

	<xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>
	<xsl:comment> Classe: Origem: Padrao: Alugar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineRentResource"/>
	<xsl:value-of select="$newlineRentResource"/>

	
	<!-- CLASSE ORIGEM-->
			<xsl:call-template name="p4v1_source"/>
	<!-- /CLASSE ORIGEM-->

	</xsl:if>

		</xsl:for-each>

	</xsl:template>

</xsl:stylesheet>