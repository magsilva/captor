<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:include href="rent_p1vX_p2vX_p4v1.xsl"/>
  <xsl:include href="rent_p1vX_p2vX_p4v1_p11v1.xsl"/>

	<xsl:variable name="newline_p4v1_rent">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:template name="p4v1_rent">


		<xsl:variable name="cliente">
		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
			<xsl:if test="@name='Destino'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>
		
		<xsl:variable name="multa">
		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
			<xsl:if test="@name='TaxaDeMulta'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>
		
		<xsl:variable name="origem">
		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
			<xsl:if test="@name='Origem'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>

		<xsl:variable name="resource">
		<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:value-of select="class"/>
			</xsl:if>
		</xsl:for-each>
		</xsl:variable>

	<!--_________________________________________________________________________-->

<class>
<name><xsl:value-of select="class"/></name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.ResourceRental</super>
<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newline_p4v1_rent"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newline_p4v1_rent"/>
<xsl:value-of select="$newline_p4v1_rent"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>hotspots configuration</category>

<body>generateInstanceCode    
	    ^true</body>
	    
<body>hasAssociatedSale
	^false</body>

<body>hasExecutor
	^false</body>

<xsl:choose>
        <xsl:when test="/formsData/forms/form/form/form/data/grenclass/@name='TaxaDeMulta'">
                <body>hasFineRate
                    ^true</body>
        </xsl:when>
        <xsl:otherwise>
                <body>hasFineRate
	                ^false</body>
        </xsl:otherwise>
</xsl:choose>


<body>hasPayment
	^false</body>

<body>hasReservation
	^false</body>

<xsl:choose>
        <xsl:when test="/formsData/forms/form/form/form/data/grenclass/@name='Origem'">
                <body>hasSourceParty
	                ^true</body>
        </xsl:when>
        <xsl:otherwise>
                <body>hasSourceParty
	                ^false</body>
        </xsl:otherwise>
</xsl:choose>

<xsl:choose>
	
	<xsl:when test="/formsData/forms/form/form/form/data/grenclass/@name='Origem'">
<body>hasSourceParty
	^true</body>
	</xsl:when>
	
	<xsl:otherwise>
<body>hasSourceParty
	^false</body>
	</xsl:otherwise>
	
</xsl:choose>

<xsl:choose>		
		<xsl:when test="/formsData/forms/form/form/form/form/@id='11.1'">
<body>isItemized
	^true</body>
		</xsl:when>
		
		<xsl:otherwise>
<body>isItemized
	^false</body>
		</xsl:otherwise>
</xsl:choose>		
	
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>classReferences</category>

		<xsl:if test="/formsData/forms/form/form/form/form/@id='11.1'">
<xsl:for-each select="/formsData/forms/form/form/form/form/data/grenclass">

<xsl:if test="last()=position()">
<body>transactionItemClass
  ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body>
</xsl:if>
</xsl:for-each>
		</xsl:if>
		

<body>destinationPartyClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$cliente"/></body>

<body>fineRateClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$multa"/></body>

<body>resourceClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$resource"/></body>

<xsl:choose>
        <xsl:when test="/formsData/forms/form/form/form/data/grenclass/@name='Origem'">
                <body>sourcePartyClass
                        ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$origem"/></body>
        </xsl:when>
</xsl:choose>

<body>transactionPluralName    
	    ^'<xsl:value-of select="pluralForm"/>'</body>


<xsl:if test="/formsData/forms/form/form/@id='2.1'">
<body>transQuantificationStrategyClass
   ^SingleResTransaction</body>
</xsl:if>

<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<body>transQuantificationStrategyClass
   ^InstantiableResTransaction</body>
</xsl:if>


</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessing</category>

<xsl:value-of select="$newline_p4v1_rent"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_rent"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>SQLClauses</category>

	<!--INSERTION FIELDS-->
	<xsl:call-template name="insertion_fields">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
	<!--INSERTION VALUES-->
	<xsl:call-template name="insertion_values">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

	<!--UPDATE CLAUSE-->
	<xsl:call-template name="update_clause">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_rent"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>


	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_rent"/>
</methods>

	<!--_________________________________________________________________________-->


<class>
<name><xsl:value-of select="class"/>Form</name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>

<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/form/form/@id='11.1'">
		<super>GREN.MultiResourceRentalForm</super><xsl:value-of select="$newline_p4v1_rent"/>
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		<super>GREN.OneResourceRentalForm</super>
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.2'">
		<super>GREN.InstantiableResourceRentalForm</super>
	</xsl:when>
	<xsl:otherwise>
		<super>GREN.OneResourceRentalForm</super>
	</xsl:otherwise>
</xsl:choose>

<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newline_p4v1_rent"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newline_p4v1_rent"/>
<xsl:value-of select="$newline_p4v1_rent"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category>

		<xsl:if test="/formsData/forms/form/form/form/form/@id='11.1'">
<xsl:for-each select="/formsData/forms/form/form/form/form/data/grenclass">

<xsl:if test="last()=position()">
<body>transactionItemFormClass
  ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</body>
</xsl:if>
</xsl:for-each>
		</xsl:if>

<body>transactionClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'<xsl:value-of select="$cliente"/>'</body>


<!--____________________SPEC____________________-->
<!--____________________SPEC____________________-->
<!--____________________SPEC____________________-->
<body><xsl:value-of select="class"/>Spec

<xsl:choose>

		<xsl:when test="/formsData/forms/form/form/form/form/@id='11.1'">
                        <xsl:call-template name="p1vX_p2vX_p4v1_p11v1">		
                                <xsl:with-param name="attributes" select="attributes"/>
                        </xsl:call-template>
		</xsl:when>
		
		<xsl:otherwise>
                        <xsl:call-template name="p1vX_p2vX_p4v1">		
                                <xsl:with-param name="attributes" select="attributes"/>
                        </xsl:call-template>
		</xsl:otherwise>
		
</xsl:choose>
			</body>
<!--____________________SPEC____________________-->
<!--____________________SPEC____________________-->
<!--____________________SPEC____________________-->

<body>aResourceLabel   
	    ^'<xsl:value-of select="$resource"/>'</body>


		<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
			<xsl:if test="@name='Origem'">
	    <body>aSourcePartyLabel   
	    ^'<xsl:value-of select="$origem"/>'</body>
			</xsl:if>
		</xsl:for-each>

<body>windowLabel   
	    ^'<xsl:value-of select="class"/>'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category>
<xsl:value-of select="$newline_p4v1_rent"/>

<xsl:for-each select="attributes/attribute">

<xsl:value-of select="$newline_p4v1_rent"/>
<body><xsl:value-of select="name"/><xsl:value-of select="$newline_p4v1_rent"/>
	| adaptor |<xsl:value-of select="$newline_p4v1_rent"/>
	adaptor := AspectAdaptor subjectChannel: self aTransaction.<xsl:value-of select="$newline_p4v1_rent"/>
	adaptor forAspect: #<xsl:value-of select="name"/>.<xsl:value-of select="$newline_p4v1_rent"/>
	^adaptor</body><xsl:value-of select="$newline_p4v1_rent"/>

</xsl:for-each>
	
<xsl:value-of select="$newline_p4v1_rent"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_rent"/>
</methods>

	<!--_________________________________________________________________________-->
		
	</xsl:template>


</xsl:stylesheet>