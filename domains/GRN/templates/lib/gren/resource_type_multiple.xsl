<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineResourceTypeMultiple">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="resource_type_multiple">
		<xsl:param name="type"/>	
	   
	   <!--Dados:
	   Nome do projeto: 
	   Nome da classe: <xsl:value-of select="$type/class"/>
	   Nome do objeto: <xsl:value-of select="$type/object"/>
	   Nome pluralForm: <xsl:value-of select="$type/pluralForm"/>
	   -->
	   
			
	<xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:comment> Classe: ResourceType: Padrao: Identificar o recurso - Variant: Multiplos Recursos</xsl:comment><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!-- CLASSE RESOURCE TYPE -->
	
<class><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<name><xsl:value-of select="$type/class"/></name><xsl:value-of select="$newlineResourceTypeMultiple"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceTypeMultiple"/>
<super>GREN.SimpleType</super><xsl:value-of select="$newlineResourceTypeMultiple"/>
<private>false</private><xsl:value-of select="$newlineResourceTypeMultiple"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--INSTANCE VARS-->
	<xsl:call-template name="instance_vars">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceTypeMultiple"/>
<imports></imports><xsl:value-of select="$newlineResourceTypeMultiple"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

</class><xsl:value-of select="$newlineResourceTypeMultiple"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/> class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<body>typeClasses  
	^List new</body><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<body>typeForms  
	^List new</body><xsl:value-of select="$newlineResourceTypeMultiple"/>
	
<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/> class</class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<body>typeFields  
	^List new</body><xsl:value-of select="$newlineResourceTypeMultiple"/>
	
<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/></class-id> <category>accessing</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/></class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--INSERTION FIELDS-->
	<xsl:call-template name="insertion_fields">
		<xsl:with-param name="vars" select="$type/attributes"/>
	</xsl:call-template>
	<!--INSERTION VALUES-->
	<xsl:call-template name="insertion_values">
		<xsl:with-param name="vars" select="$type/attributes"/>
	</xsl:call-template>
	<!--UPDATE CLAUSE-->
	<xsl:call-template name="update_clause">
		<xsl:with-param name="vars" select="$type/attributes"/>
	</xsl:call-template>

</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/></class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
<xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
			
<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!-- /CLASSE RESOURCE TYPE -->

	<!--______________________________________________________________________-->
	<!--______________________________________________________________________-->
	<!--______________________________________________________________________-->
	<!--______________________________________________________________________-->

	<!-- CLASSE RESOURCE TYPE FORM-->

	<xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:comment> Classe: ResourceTypeForm: Padrao: Identificar o recurso - Variant: Multiplos Recursos</xsl:comment><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<xsl:value-of select="$newlineResourceTypeMultiple"/>


<class><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<name><xsl:value-of select="$type/class"/>Form</name><xsl:value-of select="$newlineResourceTypeMultiple"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceTypeMultiple"/>
<super>GREN.StaticObjectForm</super><xsl:value-of select="$newlineResourceTypeMultiple"/>
<private>false</private><xsl:value-of select="$newlineResourceTypeMultiple"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<!--INSTANCE VARS-->
	<xsl:call-template name="instance_vars">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceTypeMultiple"/>
<imports></imports><xsl:value-of select="$newlineResourceTypeMultiple"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

</class><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/>Form class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/><body>guiSpec
	^#<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<body>objectClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/></body><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<body>objectName    
	    ^'<xsl:value-of select="$type/object"/>'</body><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/><body>pluralObjectName    
	    ^'<xsl:value-of select="$type/pluralForm"/>'</body><xsl:value-of select="$newlineResourceTypeMultiple"/>
	    
<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/>Form class</class-id> <category>interface specs</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>

<body><xsl:value-of select="class"/>Spec
	"UIPainter new openOnClass: self andSelector: #<xsl:value-of select="class"/>Spec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
  		#flags: 1 
			#bounds: #(#{Graphics.Rectangle} 324 131 1000 471 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 9 55 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 77 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 113 ) 
					#label: #descriptionLabel ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 262 4 590 45 ) ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 3 4 227 44 ) ) 
				#(#{UI.SequenceViewSpec} 
					#layout: #(#{Graphics.Rectangle} 7 80 282 318 ) 
					#name: #allStaticObjects 
					#model: #allStaticObjects 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#requestFocusInSelector: #changeRequest ) 
					#useModifierKeys: true 
					#selectionType: #highlight ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 74 454 100 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 113 644 138 ) 
					#name: #descriptionField 
					#model: #w_description 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 9 10 222 41 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 268 11 588 45 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) 
	<xsl:for-each select="attributes/attribute">
				#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 <xsl:value-of select="110 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>' ) 
	</xsl:for-each>

	<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="110 + 45 * position()"/> 650 <xsl:value-of select="135 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="110 + 45 * position()"/> 650 <xsl:value-of select="135 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="110 + 45 * position()"/> 650 <xsl:value-of select="135 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="110 + 45 * position()"/> 650 <xsl:value-of select="135 + 45 * position()"/> ) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
					</xsl:when>
				</xsl:choose>		

	</xsl:for-each>
) ) )</body><xsl:value-of select="$newlineResourceTypeMultiple"/>


<xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/><body>windowLabel   
	    ^'<xsl:value-of select="$type/class"/>'</body><xsl:value-of select="$newlineResourceTypeMultiple"/>
	    
<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
<xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/>Form</class-id> <category>aspects</category><xsl:value-of select="$newlineResourceTypeMultiple"/>
	<!--ASPECTS-->
	<xsl:call-template name="aspects">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
<methods><xsl:value-of select="$newlineResourceTypeMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="$type/class"/>Form</class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceTypeMultiple"/>

	<!--INITIALIZE RELEASE-->
	<xsl:call-template name="initialize_release">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceTypeMultiple"/>
</methods><xsl:value-of select="$newlineResourceTypeMultiple"/>
	
	<!-- /CLASSE RESOURCE TYPE FORM-->

	</xsl:template>

</xsl:stylesheet>