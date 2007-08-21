<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineItem">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="itemize">

	<xsl:value-of select="$newlineItem"/>
	<xsl:comment> Classe: Item: Padrao: Identificar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineItem"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineItem"/>
	<xsl:value-of select="$newlineItem"/>


		<xsl:variable name="aluguel">
		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
			<xsl:if test="@name='Aluguel'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>

		<xsl:variable name="recurso">
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>


	
	<!-- CLASSE ITEM-->
	
<xsl:value-of select="$newlineItem"/>
<class><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>

<name><xsl:value-of select="class"/></name><xsl:value-of select="$newlineItem"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineItem"/>
<super>GREN.TransactionItem</super><xsl:value-of select="$newlineItem"/>
<private>false</private><xsl:value-of select="$newlineItem"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineItem"/>
<inst-vars></inst-vars><xsl:value-of select="$newlineItem"/>
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineItem"/>
<imports></imports><xsl:value-of select="$newlineItem"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>
</class><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineItem"/>
<methods><xsl:value-of select="$newlineItem"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>classReferences</category><xsl:value-of select="$newlineItem"/>

		<xsl:if test="/formsData/forms/form/form/@id='2.1'">
<body>itemQuantificationStrategyClass
   ^SingleResTransItem</body><xsl:value-of select="$newlineItem"/>
		</xsl:if>
		
		<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<body>itemQuantificationStrategyClass
   ^InstResTransItem</body><xsl:value-of select="$newlineItem"/>
		</xsl:if>

<xsl:value-of select="$newlineItem"/><body>resourceClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$recurso"/></body><xsl:value-of select="$newlineItem"/>

<xsl:value-of select="$newlineItem"/><body>transactionClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$aluguel"/></body><xsl:value-of select="$newlineItem"/>

<xsl:value-of select="$newlineItem"/>
</methods><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>

	
	<!-- /CLASSE ITEM-->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	

	<xsl:value-of select="$newlineItem"/>
	<xsl:value-of select="$newlineItem"/>
	<xsl:comment> Classe: ItemForm: Padrao: Identificar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineItem"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineItem"/>
	<xsl:value-of select="$newlineItem"/>
	<xsl:value-of select="$newlineItem"/>

	<!-- CLASSE ITEM FORM-->

<xsl:value-of select="$newlineItem"/>
<class><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>

<name><xsl:value-of select="class"/>Form</name><xsl:value-of select="$newlineItem"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineItem"/>
<super>GREN.TransactionItemForm</super><xsl:value-of select="$newlineItem"/>
<private>false</private><xsl:value-of select="$newlineItem"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineItem"/>
<inst-vars></inst-vars><xsl:value-of select="$newlineItem"/>
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineItem"/>
<imports></imports><xsl:value-of select="$newlineItem"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>
</class><xsl:value-of select="$newlineItem"/>
<xsl:value-of select="$newlineItem"/>

	<!-- /CLASSE ITEM TYPE FORM-->
	
	<xsl:value-of select="$newlineItem"/>

	</xsl:template>
	

</xsl:stylesheet>