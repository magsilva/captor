<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInstantiableResource">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="instantiable_resource">

	<xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:comment> Classe: Instancia do recurso: Padrao: Quantificar o recurso - Variant: Recurso instanciavel</xsl:comment><xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:value-of select="$newlineInstantiableResource"/>

	
	<!-- CLASSE RESOURCE INSTANCE-->

<class>
<name><xsl:value-of select="class"/></name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.ResourceInstance</super>
<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newlineInstantiableResource"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newlineInstantiableResource"/>
<xsl:value-of select="$newlineInstantiableResource"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessing</category>

<xsl:for-each select="attributes/attribute">
<xsl:value-of select="$newlineInstantiableResource"/>
<body><xsl:value-of select="name"/><xsl:value-of select="$newlineInstantiableResource"/>
	^<xsl:value-of select="name"/></body><xsl:value-of select="$newlineInstantiableResource"/>

<body><xsl:value-of select="name"/>: new<xsl:value-of select="name"/><xsl:value-of select="$newlineInstantiableResource"/>
	self update: '<xsl:value-of select="name"/>' to: new<xsl:value-of select="name"/>.<xsl:value-of select="$newlineInstantiableResource"/>
	self changed: #<xsl:value-of select="name"/>.<xsl:value-of select="$newlineInstantiableResource"/>
	self isChanged: true.</body><xsl:value-of select="$newlineInstantiableResource"/>
</xsl:for-each>

</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>SQLClauses</category>

<xsl:value-of select="$newlineInstantiableResource"/>

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

<xsl:value-of select="$newlineInstantiableResource"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category>

<xsl:value-of select="$newlineInstantiableResource"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>


	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineInstantiableResource"/>
</methods>

	<!-- /CLASSE RESOURCE INSTANCE-->

	<xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:comment> Classe: Form da Instancia do recurso: Padrao: Quantificar o recurso - Variant: Recurso instanciavel</xsl:comment><xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:value-of select="$newlineInstantiableResource"/>

	
	<!-- CLASSE RESOURCE INSTANCE FORM-->

<class>
<name><xsl:value-of select="class"/>Form</name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.ResourceInstanceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newlineInstantiableResource"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newlineInstantiableResource"/>
<xsl:value-of select="$newlineInstantiableResource"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineInstantiableResource"/>
<methods><xsl:value-of select="$newlineInstantiableResource"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category><xsl:value-of select="$newlineInstantiableResource"/>

<xsl:value-of select="$newlineInstantiableResource"/><body>guiSpec 
	    ^#<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineInstantiableResource"/>

<xsl:value-of select="$newlineInstantiableResource"/>
</methods><xsl:value-of select="$newlineInstantiableResource"/>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category>

<body><xsl:value-of select="class"/>Spec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} 
			
			#window: #(#{UI.WindowSpec} 
			#properties: #(#{UI.PropertyListDictionary} ) 
			#label: 'resourceInstance' 
			#min: #(#{Core.Point} 350 300 ) 
			#max: #(#{Core.Point} 350 300 ) 
			#bounds: #(#{Graphics.Rectangle} 400 300 696 520) 
			#flags: 1 ) 
			#component: #(#{UI.SpecCollection} 
			#collection: 
			#(#(#{UI.LabelSpec} 
			#layout: #(#{Core.Point} 28 27) 
			#label: #codeLabel) 
			
			#(#{UI.InputFieldSpec} 
			#layout: #(#{Graphics.Rectangle} 107 23 166 48) 
			#name: #codeField 
			#model: #code 
			#type: #string) #(#{UI.LabelSpec} 
			#layout: #(#{Core.Point} 28 69) 
			#name: #allocationLabel 
			#label: #allocationLabel) #(#{UI.InputFieldSpec} 
			#layout: #(#{Graphics.Rectangle} 106 68 206 93) 
			#name: #allocationField 
			#model: #allocation) 
			
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 29 113) #label: #statusLabel) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 95 113) #model: #status #label: #option1Label #select: #available) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 191 113) #model: #status #label: #option2Label #select: #nonAvailable) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 69 167 118 192) #model: #accept #label: 'Ok' #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 179 167 228 192) #model: #cancel #label: 'Cancel' #defaultable: true) 
			
			<xsl:for-each select="attributes/attribute">
#(#{UI.LabelSpec} #layout: #(#{Core.Point} 30 <xsl:value-of select="199 + 30 * position()"/>)  #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 
			</xsl:for-each>
			
			<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 110 <xsl:value-of select="199 + 30 * position()"/> 280 <xsl:value-of select="224 + 30 * position()"/>)  #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 110 <xsl:value-of select="199 + 30 * position()"/> 280 <xsl:value-of select="224 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 110 <xsl:value-of select="199 + 30 * position()"/> 280 <xsl:value-of select="224 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 110 <xsl:value-of select="199 + 30 * position()"/> 280 <xsl:value-of select="224 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')


					</xsl:when>
				</xsl:choose>		
			</xsl:for-each>
			
			)))</body>
</methods><xsl:value-of select="$newlineInstantiableResource"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineInstantiableResource"/>
<methods><xsl:value-of select="$newlineInstantiableResource"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category><xsl:value-of select="$newlineInstantiableResource"/>

<xsl:for-each select="attributes/attribute">
<xsl:value-of select="$newlineInstantiableResource"/>
<body><xsl:value-of select="name"/><xsl:value-of select="$newlineInstantiableResource"/>
	^<xsl:value-of select="name"/>.</body><xsl:value-of select="$newlineInstantiableResource"/>

<body><xsl:value-of select="name"/>: new<xsl:value-of select="name"/><xsl:value-of select="$newlineInstantiableResource"/>
	<xsl:value-of select="name"/> := new<xsl:value-of select="name"/>.</body><xsl:value-of select="$newlineInstantiableResource"/>
</xsl:for-each>

</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>private</category>

<body>assignVariables
			    super assignVariables.
<xsl:for-each select="attributes/attribute">
	self aResourceInstance <xsl:value-of select="name"/>: <xsl:value-of select="name"/> value.<xsl:value-of select="$newlineInstantiableResource"/>
</xsl:for-each>			    
	</body>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category>

<body>initializeWithInstance
			    super initializeWithInstance.
<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="name"/> := self aResourceInstance <xsl:value-of select="name"/> asValue.<xsl:value-of select="$newlineInstantiableResource"/>
</xsl:for-each>			    
					</body>
</methods>

	<!-- /CLASSE RESOURCE INSTANCE FORM-->

	</xsl:template>

</xsl:stylesheet>