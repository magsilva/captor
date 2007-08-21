<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineResourceNoType">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="resource_no_type">

	<xsl:value-of select="$newlineResourceNoType"/>
	<xsl:comment> Classe: Resource: Padrao: Identificar o recurso - Variant: Recurso sem tipo</xsl:comment><xsl:value-of select="$newlineResourceNoType"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceNoType"/>
	<xsl:value-of select="$newlineResourceNoType"/>

	
	<!-- CLASSE RESOURCE-->
	
<class><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<name><xsl:value-of select="class"/></name><xsl:value-of select="$newlineResourceNoType"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceNoType"/>

<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		<super>GREN.Resource</super><xsl:value-of select="$newlineResourceNoType"/>
	</xsl:when>
	<xsl:otherwise>
		<super>GREN.Resource</super><xsl:value-of select="$newlineResourceNoType"/>
	</xsl:otherwise>
</xsl:choose>

<private>false</private><xsl:value-of select="$newlineResourceNoType"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newlineResourceNoType"/>

<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceNoType"/>
<imports></imports><xsl:value-of select="$newlineResourceNoType"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

</class><xsl:value-of select="$newlineResourceNoType"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<xsl:value-of select="$newlineResourceNoType"/>
<body>resourceInstanceClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/data/grenclass"><xsl:if test="@name='InstanciaDoRecurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>
<xsl:value-of select="$newlineResourceNoType"/>


<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
<xsl:value-of select="$newlineResourceNoType"/>
<body>resourceRentalClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass"><xsl:if test="@name='Aluguel'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>

<xsl:if test="/formsData/forms/form/form/form/@id='4.2'">
<xsl:value-of select="$newlineResourceNoType"/>
<body>resourceRentalClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass"><xsl:if test="@name='Aluguel'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>
<xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<body>guiForm   
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<body>quantificationStrategyClass

<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		   ^SingleResource
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.2'">
		   ^InstantiableResource
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.3'">
		   ^MeasurableResource
	</xsl:when>
	<xsl:otherwise>
		   ^SingleResource
	</xsl:otherwise>
</xsl:choose>
   
   </body><xsl:value-of select="$newlineResourceNoType"/>
   

<xsl:value-of select="$newlineResourceNoType"/>
<body>typeClasses  
	^List new</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>typeForms  
	^List new</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<body>typeFields  
	^List new</body><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>
	
</methods><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>hotspots configuration</category><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<body>isStored    
	    ^false</body><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessing</category><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>

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

<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>


	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>


	
	<!-- /CLASSE RESOURCE-->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	

	<xsl:value-of select="$newlineResourceNoType"/>
	<xsl:value-of select="$newlineResourceNoType"/>
	<xsl:comment> Classe: ResourceForm: Padrao: Identificar o recurso - Variant: Recurso sem tipo</xsl:comment><xsl:value-of select="$newlineResourceNoType"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceNoType"/>
	<xsl:value-of select="$newlineResourceNoType"/>
	<xsl:value-of select="$newlineResourceNoType"/>

	<!-- CLASSE RESOURCE FORM-->

<class><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<name><xsl:value-of select="class"/>Form</name><xsl:value-of select="$newlineResourceNoType"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceNoType"/>

<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		<super>GREN.SingleResourceForm</super><xsl:value-of select="$newlineResourceNoType"/>
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.2'">
		<super>GREN.InstantiableResourceForm</super><xsl:value-of select="$newlineResourceNoType"/>
	</xsl:when>
	<xsl:otherwise>
		<super>GREN.SingleResourceForm</super><xsl:value-of select="$newlineResourceNoType"/>
	</xsl:otherwise>
</xsl:choose>

<private>false</private><xsl:value-of select="$newlineResourceNoType"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceNoType"/>

<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newlineResourceNoType"/>

<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceNoType"/>
<imports></imports><xsl:value-of select="$newlineResourceNoType"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

</class><xsl:value-of select="$newlineResourceNoType"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<body>resourceInstanceFormClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/data/grenclass"><xsl:if test="@name='InstanciaDoRecurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each>Form</body>
</xsl:if>


<xsl:value-of select="$newlineResourceNoType"/>
<body>guiSpec 
	    ^#<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>objectClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>objectName    
	    ^'<xsl:value-of select="class"/>'</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>pluralObjectName    
	    ^'<xsl:value-of select="pluralForm"/>'</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>typesCanvasClass
								    ^QualificationForm0</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body>typesSpec
								    ^#resType0Spec</body><xsl:value-of select="$newlineResourceNoType"/>
								    
<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/><body><xsl:value-of select="class"/>Spec
	"UIPainter new openOnClass: self andSelector: #<xsl:value-of select="class"/>Spec"


<!--____________SingleResource________________________________________________________-->
<xsl:choose>
<xsl:when test="/formsData/forms/form/form/@id='2.1'">
	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: '<xsl:value-of select="pluralForm"/>' 
	  		#flags: 1 
			#bounds: #(#{Graphics.Rectangle} 318 26 1021 504 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} -1 -1 696 342 ) 
					#name: #Subcanvas1 
					#flags: 0 
					#minorKey: #singleResSpec )
	<xsl:for-each select="attributes/attribute">
				#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 <xsl:value-of select="210 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>' ) 
	</xsl:for-each>

	<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 350 <xsl:value-of select="210 + 45 * position()"/> 665 <xsl:value-of select="235 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 350 <xsl:value-of select="210 + 45 * position()"/> 665 <xsl:value-of select="235 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 350 <xsl:value-of select="210 + 45 * position()"/> 665 <xsl:value-of select="235 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 350 <xsl:value-of select="210 + 45 * position()"/> 665 <xsl:value-of select="235 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
					</xsl:when>
				</xsl:choose>		

	</xsl:for-each>
	) ) )
</xsl:when>
<!--____________InstanceResource________________________________________________________-->
<xsl:when test="/formsData/forms/form/form/@id='2.2'">
		^#(#{UI.FullSpec} 
		#window: #(#{UI.WindowSpec} 
		#label: #windowLabel 
		#flags: 1 
		#bounds: #(#{Graphics.Rectangle} 50 99 796 523)) 
		#component: #(#{UI.SpecCollection} 
		#collection: 
		
		
		#(#(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 301 215) 
		#label: #instancesLabel) #(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 613 275 662 300) 
		#name: #addInstanceBt 
		#model: #addInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'New' 
		#defaultable: true) #(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 613 321 662 346) 
		#name: #removeInstanceBt 
		#model: #removeInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'Remove' 
		#defaultable: true) #(#{UI.DataSetSpec} 
		#layout: #(#{Graphics.Rectangle} 365 216 604 360) 
		#name: #instancesListTable 
		#flags: 13 
		#model: #instancesList 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedSelectedInstance) 
		#columns: #(#(#{UI.DataSetColumnSpec} 
		#labelIsImage: false 
		#width: 20 
		#rendererType: #rowSelector 
		#editorType: #rowSelector 
		#noScroll: false) #(#{UI.DataSetColumnSpec} 
		#model: #'selectedRow code' 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: #codeLabel 
		#labelIsImage: false 
		#width: 50 
		#rendererType: #Text 
		#editorType: #None 
		#noScroll: false) #(#{UI.DataSetColumnSpec} 
		#model: #'selectedRow allocation' 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: #allocationLabel 
		#labelIsImage: false 
		#width: 70 
		#rendererType: #Text 
		#editorType: #None 
		#noScroll: false) #(#{UI.DataSetColumnSpec} 
		#model: #'selectedRow statusAsString' 
		#label: #statusLabel 
		#labelIsImage: false 
		#width: 80 
		#rendererType: #Text 
		#editorType: #None 
		#noScroll: false)) 
		#multipleSelections: false 
		#labelsAsButtons: true) #(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 292 209 668 373)) 
		#(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 613 228 662 253) 
		#name: #editInstanceBt 
		#model: #editInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'Edit' 
		#defaultable: true) #(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 488 76 587 103) 
		#name: #storageBt 
		#model: #storageBt 
		#helpText: 'Details about storage' 
		#label: #(#{Kernel.UserMessage} 
		#key: #storageBt 
		#defaultString: 'Storage...') 
		#defaultable: true) #(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 295 153 745 319) 
		#name: #typesCanvas 
		#flags: 0 
		#clientKey: #typesCanvas) #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 12 58) 
		#label: #listLabel) #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 80) 
		#label: #idCodeLabel) #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 116) 
		#label: #descriptionLabel) #(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 265 7 593 48)) #(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 6 7 230 47)) #(#{UI.SequenceViewSpec} 
		#layout: #(#{Graphics.Rectangle} 10 83 285 321) 
		#name: #allStaticObjects 
		#model: #allStaticObjects 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#requestFocusInSelector: #changeRequest) 
		#useModifierKeys: true 
		#selectionType: #highlight) #(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 394 77 457 103) 
		#name: #idCodeField 
		#flags: 40 
		#model: #w_idCode 
		#alignment: #right 
		#type: #number) #(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 393 116 647 141) 
		#name: #descriptionField 
		#model: #w_description 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData)) #(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 12 13 225 44) 
		#name: #navigationBtns 
		#flags: 0 
		#clientKey: #navigationBtns) #(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 271 14 591 48) 
		#name: #basicBtnsCanvas #flags: 0 
		#clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 383) 
		#name: #costLabel #flags: 16 
		#label: #costLabel) #(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 378 382 461 408) 
		#name: #costField #flags: 24 
		#model: #cost 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#type: #number 
		#formatString: '0.00') #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 497 383) 
		#name: #salePriceLabel 
		#flags: 16 
		#label: #salePriceLabel) 
		#(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 594 383 677 409) 
		#name: #salePriceField #flags: 24 
		#model: #salePrice 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#type: #number #formatString: '0.00') 
		
<xsl:for-each select="attributes/attribute">
#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 <xsl:value-of select="360 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 
</xsl:for-each>
		
			<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="360 + 30 * position()"/> 665 <xsl:value-of select="383 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="360 + 30 * position()"/> 665 <xsl:value-of select="383 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="360 + 30 * position()"/> 665 <xsl:value-of select="383 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="360 + 30 * position()"/> 665 <xsl:value-of select="383 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
					</xsl:when>
				</xsl:choose>		
</xsl:for-each>			    
		)))
</xsl:when>
</xsl:choose>
	</body><xsl:value-of select="$newlineResourceNoType"/>
						
<xsl:value-of select="$newlineResourceNoType"/>
<body>windowLabel   
	    ^'<xsl:value-of select="class"/>'</body><xsl:value-of select="$newlineResourceNoType"/>

<xsl:value-of select="$newlineResourceNoType"/>
</methods><xsl:value-of select="$newlineResourceNoType"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceNoType"/>
<methods><xsl:value-of select="$newlineResourceNoType"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category><xsl:value-of select="$newlineResourceNoType"/>
<xsl:value-of select="$newlineResourceNoType"/>

	<!--ASPECTS-->
	<xsl:call-template name="aspects">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<!--<body>initialize 
			    super initialize.
					 aaa := '' asValue.
					 bbb := 0 asValue.
					 ccc := 0.00 asValue.
					 ddd := Date today asValue</body>-->
					 
</methods>

	<!-- /CLASSE RESOURCE TYPE FORM-->
	
	<xsl:value-of select="$newlineResourceNoType"/>

	</xsl:template>
	

</xsl:stylesheet>