<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:include href="instance_vars.xsl"/>
	<xsl:include href="getters.xsl"/>
	<xsl:include href="setters.xsl"/>
	<xsl:include href="insertion_fields.xsl"/>
	<xsl:include href="insertion_values.xsl"/>
	<xsl:include href="update_clause.xsl"/>
	<xsl:include href="initialize.xsl"/>
	<xsl:include href="initialize_row.xsl"/>
	<xsl:include href="aspects.xsl"/>
	<xsl:include href="initialize_release.xsl"/>
	
	<!--_____________________________________________________________________-->

	<xsl:include href="resource_default.xsl"/>
	<xsl:include href="resource_type_default.xsl"/>
	<xsl:include href="resource_no_type.xsl"/>
	<xsl:include href="resource_multiple.xsl"/>
	<xsl:include href="resource_type_multiple.xsl"/>
	<xsl:include href="instantiable_resource.xsl"/>
	<xsl:include href="resource_rent.xsl"/>
	<xsl:include href="itemize.xsl"/>
	
	<!--_____________________________________________________________________-->
	
	<xsl:variable name="newlinePatterns">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template match="forms">

		<xsl:if test="/formsData/forms/form/@id='1.1'">
			<xsl:call-template name="p1v1"/>
		</xsl:if>

		<xsl:if test="/formsData/forms/form/@id='1.2'">
			<xsl:call-template name="p1v2"/>
		</xsl:if>
		
		<xsl:if test="/formsData/forms/form/@id='1.3'">
			<xsl:call-template name="p1v3"/>
		</xsl:if>
		
		<xsl:if test="/formsData/forms/form/form/@id='2.2'">
			<xsl:call-template name="p2v2"/>
		</xsl:if>
		
		<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
			<xsl:call-template name="p4v1"/>
		</xsl:if>
		
		<xsl:if test="/formsData/forms/form/form/form/form/@id='11.1'">
			<xsl:call-template name="p11v1"/>
		</xsl:if>

	</xsl:template>
  
	<!--______________________________________________________________________-->

	<xsl:template name="p1v1">
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
					<xsl:call-template name="resource_default"/>
			</xsl:if>
		
			<xsl:if test="@name='TipoDoRecurso'">
					<xsl:call-template name="resource_type_default"/>
			</xsl:if>
		</xsl:for-each>

	</xsl:template>

	<xsl:template name="p1v2">
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
					<xsl:call-template name="resource_no_type"/>
			</xsl:if>
		</xsl:for-each>
	
	</xsl:template>

	<xsl:template name="p1v3">
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
					<xsl:call-template name="resource_multiple"/>
			</xsl:if>

			<xsl:if test="substring(@name,1,13)='TipoDoRecurso'">
					<xsl:call-template name="resource_type_multiple">
						<xsl:with-param name="type" select="."/>
					</xsl:call-template>
			</xsl:if>
		
		</xsl:for-each>
	
	</xsl:template>

	<xsl:template name="p2v2">
		<xsl:for-each select="/formsData/forms/form/form/data/grenclass">
			<xsl:if test="@name='InstanciaDoRecurso'">
					<xsl:call-template name="instantiable_resource"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="p11v1">
		<xsl:for-each select="/formsData/forms/form/form/form/form/data/grenclass">
			<xsl:if test="@name='ItemDaTransacao'">
					<xsl:call-template name="itemize"/>
			</xsl:if>
		</xsl:for-each>
		
	</xsl:template>

	<xsl:template name="p4v1">
	
			<xsl:call-template name="resource_rent"/>
	</xsl:template>

	<!--______________________________________________________________________-->

</xsl:stylesheet>