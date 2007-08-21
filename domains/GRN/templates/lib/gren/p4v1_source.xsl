<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newline_p4v1_source">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:template name="p4v1_source">

	<!--_________________________________________________________________________-->

<class>
<name><xsl:value-of select="class"/></name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.SourceParty</super>
<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newline_p4v1_source"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newline_p4v1_source"/>
<xsl:value-of select="$newline_p4v1_source"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>hotspots configuration</category>

<body>hasWarehouses
	^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessing</category>


<xsl:value-of select="$newline_p4v1_source"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_source"/>
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

<xsl:value-of select="$newline_p4v1_source"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category>

<xsl:value-of select="$newline_p4v1_source"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>


	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_source"/>
</methods>

	<!--_________________________________________________________________________-->

<class>
<name><xsl:value-of select="class"/>Form</name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.SourcePartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>

<xsl:value-of select="$newline_p4v1_source"/>
<inst-vars><xsl:for-each select="attributes/attribute"><xsl:value-of select="name"/><xsl:text> </xsl:text></xsl:for-each></inst-vars><xsl:value-of select="$newline_p4v1_source"/>
<xsl:value-of select="$newline_p4v1_source"/>

<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body>

<body>objectName    
	    ^'<xsl:value-of select="class"/>'</body>

<body>pluralObjectName    
	    ^'<xsl:value-of select="pluralForm"/>'</body>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category>

<body><xsl:value-of select="class"/>Spec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: 
			#(#{UI.WindowSpec} #label: #windowLabel 
	  		#flags: 1 
			#bounds: #(#{Graphics.Rectangle} 73 130 738 470)) 
			
			#component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 9 55) #label: #listLabel) 
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 77) #label: #idCodeLabel) 
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 113) #label: #descriptionLabel) 
			#(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 262 4 590 45)) 
			#(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 3 4 227 44)) #(#{UI.SequenceViewSpec} #layout: #(#{Graphics.Rectangle} 7 80 282 318) #name: #allStaticObjects #model: #allStaticObjects #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #requestFocusInSelector: #changeRequest) #useModifierKeys: true #selectionType: #highlight) 
			#(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 391 74 454 100) #name: #idCodeField #flags: 40 #model: #w_idCode #alignment: #right #type: #number) 
			#(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 113 644 138) #name: #descriptionField #model: #w_description #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 9 10 222 41) #name: #navigationBtns #flags: 0 #clientKey: #navigationBtns) 
			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 268 11 588 45) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) 
			
<xsl:for-each select="attributes/attribute">
#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 <xsl:value-of select="127 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 
</xsl:for-each>
		
			<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="127 + 30 * position()"/> 644 <xsl:value-of select="152 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="127 + 30 * position()"/> 644 <xsl:value-of select="152 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="127 + 30 * position()"/> 644 <xsl:value-of select="152 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 <xsl:value-of select="127 + 30 * position()"/> 644 <xsl:value-of select="152 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
					</xsl:when>
				</xsl:choose>		
</xsl:for-each>			    
			
			<!--
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 157) #name: #aaaLabel #label: 'Aaa') 
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 187) #name: #bbbLabel #label: 'Bbb') 
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 217) #name: #cccLabel #label: 'Ccc') 
			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 247) #name: #dddLabel #label: 'Ddd') 
			
			#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 157 544 182) #name: #aaa #model: #aaa #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
			#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 187 544 212) #name: #bbb #model: #bbb #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
			#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 217 544 242) #name: #ccc #model: #ccc #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
			#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 247 544 272) #name: #ddd #model: #ddd #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
			-->
			
			)))</body>

<body>windowLabel   
	    ^'<xsl:value-of select="class"/>'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category>
<xsl:value-of select="$newline_p4v1_source"/>

	<!--ASPECTS-->
	<xsl:call-template name="aspects">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	
<xsl:value-of select="$newline_p4v1_source"/>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newline_p4v1_source"/>
</methods>


	<!--_________________________________________________________________________-->
		
	</xsl:template>


</xsl:stylesheet>