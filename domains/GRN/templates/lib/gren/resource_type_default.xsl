<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineResourceTypeDefault">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="resource_type_default">

	<xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:comment> Classe: ResourceType: Padrao: Identificar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:value-of select="$newlineResourceTypeDefault"/>

	<!-- CLASSE RESOURCE TYPE -->

<class><xsl:value-of select="$newlineResourceTypeDefault"/>
<name><xsl:value-of select="class"/></name><xsl:value-of select="$newlineResourceTypeDefault"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceTypeDefault"/>
<super>GREN.SimpleType</super><xsl:value-of select="$newlineResourceTypeDefault"/>
<private>false</private><xsl:value-of select="$newlineResourceTypeDefault"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceTypeDefault"/>

	<!--INSTANCE VARS-->
	<xsl:call-template name="instance_vars">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceTypeDefault"/>
<imports></imports><xsl:value-of select="$newlineResourceTypeDefault"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceTypeDefault"/>
</class><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>classReferences Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods><xsl:value-of select="$newlineResourceTypeDefault"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<body>typeClasses
	^List new</body><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<body>typeForms
	^List new</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
</methods><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods><xsl:value-of select="$newlineResourceTypeDefault"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/><body>typeFields
	^List new</body>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
</methods><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>accessing Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods><xsl:value-of select="$newlineResourceTypeDefault"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessing</category><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
</methods><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>SQLClauses Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods><xsl:value-of select="$newlineResourceTypeDefault"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceTypeDefault"/>

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

</methods><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>initialize-release Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods><xsl:value-of select="$newlineResourceTypeDefault"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
<xsl:value-of select="$newlineResourceTypeDefault"/>

	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

</methods><xsl:value-of select="$newlineResourceTypeDefault"/>

	<xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:comment> Classe: ResourceTypeForm: Padrao: Identificar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
	<xsl:value-of select="$newlineResourceTypeDefault"/>

	<!-- CLASSE RESOURCE TYPE FORM-->
	<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<class>
<name><xsl:value-of select="class"/>Form</name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>

	<!--INSTANCE VARS-->
	<xsl:call-template name="instance_vars">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>classReferences Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<body>objectClass   
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<body>objectName    
	    ^'<xsl:value-of select="class"/>'</body><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
    <body>pluralObjectName
	    ^'<xsl:value-of select="class"/>'</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	    
<xsl:value-of select="$newlineResourceTypeDefault"/>
<body>guiSpec
	^#<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineResourceTypeDefault"/>
	    
</methods>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>interface specs Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category>

<!-- NOVO CANVAS  -->
<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->
<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<body><xsl:value-of select="class"/>Spec
	"UIPainter new openOnClass: self andSelector: #<xsl:value-of select="class"/>Spec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#flags: 1 
			#bounds: #(#{Graphics.Rectangle} 324 131 1010 471 ) ) 
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
) ) )</body><xsl:value-of select="$newlineResourceTypeDefault"/>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->
<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<body>windowLabel   
	    ^'<xsl:value-of select="class"/>'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>aspects Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category>

	<!--ASPECTS-->
	<xsl:call-template name="aspects">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

</methods>

<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>initialize-release Methods</xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceTypeDefault"/>
<xsl:value-of select="$newlineResourceTypeDefault"/>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category>

	<!--INITIALIZE RELEASE-->
	<xsl:call-template name="initialize_release">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

</methods>

	</xsl:template>

</xsl:stylesheet>