<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!--______________________________________________________________________-->

	<xsl:output method="xml"/>
	
	<!--______________________________________________________________________-->

	<xsl:template name="body">
		<xsl:param name="teste"/>

			<!--ID-->
			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			<id><xsl:value-of select="data/patternId"/></id>
			<xsl:value-of select="$newline"/>
			
			<!--ENABLED-->
			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			<enabled>true</enabled>
			<xsl:value-of select="$newline"/>
		
			<!--NAME-->
			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			<name><xsl:value-of select="../data/textatt"/></name>
			<xsl:value-of select="$newline"/>
			
			<!--VARIANT-->
 			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			
			<xsl:for-each select="data/textatt">
				<xsl:if test="@name='variant_name'">
		 			<variant><xsl:value-of select="."/></variant>
				</xsl:if>
			</xsl:for-each>
 			<xsl:value-of select="$newline"/>
 			
			<!--nextForms-->
 			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			<nextForms>
			
			<xsl:for-each select="../data/nextForms/nextForm">
		 			<xsl:value-of select="$newline"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<nextForm>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
						<id><xsl:value-of select="id"/></id>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
						<minChilds><xsl:value-of select="minChilds"/></minChilds>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
						<maxChilds><xsl:value-of select="maxChilds"/></maxChilds>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					<xsl:value-of select="$ident"/>
					</nextForm>
			</xsl:for-each>
			
 			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			</nextForms>
 			<xsl:value-of select="$newline"/>

			<!--HELP-->
 			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			
			<xsl:for-each select="data/textatt">
				<xsl:if test="@name='help'">
					<help><xsl:value-of select="."/></help>		
				</xsl:if>
			</xsl:for-each>
 			<xsl:value-of select="$newline"/>

			<!--FORM ELEMENTS-->
 			<xsl:value-of select="$newline"/>
			<xsl:value-of select="$ident"/>
			<xsl:value-of select="$ident"/>
			
				<formComponents>
				<xsl:for-each select="data/formComponents/formComponent">
				
					<formComponent>
						<fullname><xsl:value-of select="fullname"/></fullname>
						
						<parameters>
						<xsl:for-each select="parameters/parameter">
							<parameter>
								<name><xsl:value-of select="name"/></name>
								<value><xsl:value-of select="value"/></value>
							</parameter>
						</xsl:for-each>
						
						</parameters>
					</formComponent>
				
				</xsl:for-each>
				
				</formComponents>
			

	</xsl:template>

	<!--______________________________________________________________________-->

</xsl:stylesheet>