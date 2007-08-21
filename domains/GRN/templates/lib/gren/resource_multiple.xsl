<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
											
	<xsl:variable name="newlineResourceMultiple">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--______________________________________________________________________-->

	<xsl:template name="resource_multiple">

	<xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:comment> Classe: Resource: Padrao: Identificar o recurso - Variante: Multiplos tipos</xsl:comment><xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:value-of select="$newlineResourceMultiple"/>
	
	<!-- CLASSE RESOURCE-->

<class><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<name><xsl:value-of select="class"/></name><xsl:value-of select="$newlineResourceMultiple"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		<super>GREN.Resource</super><xsl:value-of select="$newlineResourceMultiple"/>
	</xsl:when>
	<xsl:otherwise>
		<super>GREN.Resource</super><xsl:value-of select="$newlineResourceMultiple"/>
	</xsl:otherwise>
</xsl:choose>

<private>false</private><xsl:value-of select="$newlineResourceMultiple"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceMultiple"/>

	<inst-vars>
	
	<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="name"/><xsl:text> </xsl:text>
				</xsl:for-each>			 
			</xsl:if>

			<xsl:if test="@name='InstanciaDoRecurso'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso1'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso2'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso3'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso4'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
		
		</xsl:for-each>
			
	</inst-vars>

<xsl:value-of select="$newlineResourceMultiple"/>
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceMultiple"/>
<imports></imports><xsl:value-of select="$newlineResourceMultiple"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceMultiple"/>

<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<xsl:value-of select="$newlineResourceMultiple"/>
<body>resourceInstanceClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/data/grenclass"><xsl:if test="@name='InstanciaDoRecurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>


<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
<xsl:value-of select="$newlineResourceMultiple"/>
<body>resourceRentalClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass"><xsl:if test="@name='Aluguel'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>

<xsl:if test="/formsData/forms/form/form/form/@id='4.2'">
<xsl:value-of select="$newlineResourceMultiple"/>
<body>resourceRentalClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass"><xsl:if test="@name='Aluguel'"><xsl:value-of select="class"/></xsl:if></xsl:for-each></body>
</xsl:if>

<xsl:value-of select="$newlineResourceMultiple"/>

<body>guiForm   
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</body><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

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
   
   </body><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

<body>typeClasses  
	^List <xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="substring(@name,1,13)='TipoDoRecurso'"> with: <xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> </xsl:if></xsl:for-each></body><xsl:value-of select="$newlineResourceMultiple"/>
	
<xsl:value-of select="$newlineResourceMultiple"/>

<body>typeForms  
	^List <xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="substring(@name,1,13)='TipoDoRecurso'">with: <xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form </xsl:if></xsl:for-each></body><xsl:value-of select="$newlineResourceMultiple"/>
	
<xsl:value-of select="$newlineResourceMultiple"/>
	
</methods><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceMultiple"/>

<body>typeFields  
	^List <xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="substring(@name,1,13)='TipoDoRecurso'"> with: '<xsl:value-of select="class"/>' </xsl:if></xsl:for-each></body>
	
	<xsl:value-of select="$newlineResourceMultiple"/>
  <xsl:value-of select="$newlineResourceMultiple"/>
	
</methods><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/> class</class-id> <category>hotspots configuration</category><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>isStored    
	    ^false</body><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>	    

</methods><xsl:value-of select="$newlineResourceMultiple"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>accessors</category>

<xsl:value-of select="$newlineResourceMultiple"/>

	<!--GETTERS-->
	<xsl:call-template name="getters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
	<!--SETTERS-->
	<xsl:call-template name="setters">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>
</methods>

<xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>SQLClauses</category><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>

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

<xsl:value-of select="$newlineResourceMultiple"/>
<body>updateWhereClause
	^'idcode=',self idCode printString</body><xsl:value-of select="$newlineResourceMultiple"/>
	
<xsl:value-of select="$newlineResourceMultiple"/>
</methods>
<xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceMultiple"/>


	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>


	<!--INITIALIZE ROW-->
	<xsl:call-template name="initialize_row">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceMultiple"/>
</methods>

<xsl:value-of select="$newlineResourceMultiple"/>

	<!-- /CLASSE RESOURCE-->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	<!-- ________________________________________________________________ -->
	

	<xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:comment> Classe: ResourceForm: Padrao: Identificar o recurso - Variant: Default</xsl:comment><xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineResourceMultiple"/>
	<xsl:value-of select="$newlineResourceMultiple"/>

	<!-- CLASSE RESOURCE FORM-->

<class><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<name><xsl:value-of select="class"/>Form</name><xsl:value-of select="$newlineResourceMultiple"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineResourceMultiple"/>


<xsl:choose>
	<xsl:when test="/formsData/forms/form/form/@id='2.1'">
		<super>GREN.SingleResourceForm</super><xsl:value-of select="$newlineResourceMultiple"/>
	</xsl:when>
	<xsl:when test="/formsData/forms/form/form/@id='2.2'">
		<super>GREN.InstantiableResourceForm</super><xsl:value-of select="$newlineResourceMultiple"/>
	</xsl:when>
	<xsl:otherwise>
		<super>GREN.SingleResourceForm</super><xsl:value-of select="$newlineResourceMultiple"/>
	</xsl:otherwise>
</xsl:choose>


<private>false</private><xsl:value-of select="$newlineResourceMultiple"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineResourceMultiple"/>

	<inst-vars>
	
	<xsl:for-each select="/formsData/forms/form/data/grenclass">
			<xsl:if test="@name='Recurso'">
				<xsl:for-each select="attributes/attribute">
					<xsl:value-of select="name"/><xsl:text> </xsl:text>
				</xsl:for-each>			 
			</xsl:if>

			<xsl:if test="@name='InstanciaDoRecurso'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso1'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso2'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso3'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
			<xsl:if test="@name='TipoDoRecurso4'">
				<xsl:value-of select="object"/><xsl:text> </xsl:text>
			</xsl:if>
		
		</xsl:for-each>
			
	</inst-vars><xsl:value-of select="$newlineResourceMultiple"/>

<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineResourceMultiple"/>
<imports></imports><xsl:value-of select="$newlineResourceMultiple"/>
<category><xsl:value-of select="/formsData/project/name"/></category><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
</class><xsl:value-of select="$newlineResourceMultiple"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>classReferences</category><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:if test="/formsData/forms/form/form/@id='2.2'">
<body>resourceInstanceFormClass
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:for-each select="/formsData/forms/form/form/data/grenclass"><xsl:if test="@name='InstanciaDoRecurso'"><xsl:value-of select="class"/></xsl:if></xsl:for-each>Form</body>
</xsl:if>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>guiSpec 
	    ^#<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>objectClass    
	    ^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/></body><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>objectName    
	    ^'<xsl:value-of select="object"/>'</body><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>pluralObjectName    
	    ^'<xsl:value-of select="pluralForm"/>'</body><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>

<body>typesCanvasClass
	    ^QualificationForm<xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="last()=position()"><xsl:value-of select="position()-1"/></xsl:if></xsl:for-each></body><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<body>typesSpec
	    ^#resType<xsl:for-each select="/formsData/forms/form/data/grenclass"><xsl:if test="last()=position()"><xsl:value-of select="position()-1"/></xsl:if></xsl:for-each>Spec</body><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>



</methods><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form class</class-id> <category>interface specs</category><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>

<body><xsl:value-of select="class"/>Spec
	"UIPainter new openOnClass: self andSelector: #<xsl:value-of select="class"/>Spec"

<xsl:choose>
<xsl:when test="/formsData/forms/form/form/@id='2.1'">
	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: '<xsl:value-of select="pluralForm"/>' 
  		#flags: 1 
			#bounds: #(#{Graphics.Rectangle} 318 26 1050 504 ) ) 
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
		#component: 
		
		#(#{UI.SpecCollection} 
		#collection: 

		#(#(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 300 285) 
		#label: #instancesLabel) 
		
		<!--________________________________________________________________-->
		
		#(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 640 275 690 300) 
		#name: #editInstanceBt 
		#model: #editInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'Edit' 
		#defaultable: true) 

		#(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 640 325 690 350) 
		#name: #addInstanceBt 
		#model: #addInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'New' 
		#defaultable: true) 
		
		#(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 640 375 690 400) 
		#name: #removeInstanceBt 
		#model: #removeInstance 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: 'Remove' 
		#defaultable: true) 

		
		<!--________________________________________________________________-->
		
		#(#{UI.DataSetSpec} 
		#layout: #(#{Graphics.Rectangle} 385 275 625 420) 
		#name: #instancesListTable 
		#flags: 13 
		#model: #instancesList 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedSelectedInstance) 
		#columns: 
		
		#(#(#{UI.DataSetColumnSpec} 
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
		#noScroll: false) 
		
		#(#{UI.DataSetColumnSpec} 
		#model: #'selectedRow allocation' 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#label: #allocationLabel 
		#labelIsImage: false 
		#width: 70 
		#rendererType: #Text 
		#editorType: #None 
		#noScroll: false) 
		
		#(#{UI.DataSetColumnSpec} 
		#model: #'selectedRow statusAsString' 
		#label: #statusLabel 
		#labelIsImage: false 
		#width: 80 
		#rendererType: #Text 
		#editorType: #None 
		#noScroll: false)) 
		#multipleSelections: false 
		#labelsAsButtons: true) 
		
		<!--________________________________________________________________-->

		#(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 292 270 700 430)) 
		
		#(#{UI.ActionButtonSpec} 
		#layout: #(#{Graphics.Rectangle} 488 76 587 103) 
		#name: #storageBt 
		#model: #storageBt 
		#helpText: 'Details about storage' 
		#label: #(#{Kernel.UserMessage} 
		#key: #storageBt 
		#defaultString: 'Storage...') 
		#defaultable: true) 
		
		#(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 295 153 745 319) 
		#name: #typesCanvas 
		#flags: 0 
		#clientKey: #typesCanvas) 
		
		#(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 12 58) 
		#label: #listLabel) #(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 80) 
		#label: #idCodeLabel) 
		
		#(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 116) 
		#label: #descriptionLabel) 
		
		#(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 265 7 593 48)) 
		
		#(#{UI.GroupBoxSpec} 
		#layout: #(#{Graphics.Rectangle} 6 7 230 47)) 
		
		#(#{UI.SequenceViewSpec} 
		#layout: #(#{Graphics.Rectangle} 10 83 285 321) 
		#name: #allStaticObjects 
		#model: #allStaticObjects 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#requestFocusInSelector: #changeRequest) 
		#useModifierKeys: true 
		#selectionType: #highlight) 
		
		#(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 394 77 457 103) 
		#name: #idCodeField 
		#flags: 40 
		#model: #w_idCode 
		#alignment: #right 
		#type: #number) 
		
		#(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 393 116 647 141) 
		#name: #descriptionField 
		#model: #w_description 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData)) 
		
		#(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 12 13 225 44) 
		#name: #navigationBtns 
		#flags: 0 
		#clientKey: #navigationBtns) 
		
		#(#{UI.SubCanvasSpec} 
		#layout: #(#{Graphics.Rectangle} 271 14 591 48) 
		#name: #basicBtnsCanvas #flags: 0 
		#clientKey: #basicBtnsCanvas) 
		
		#(#{UI.LabelSpec} 
		#layout: #(#{Core.Point} 295 383) 
		#name: #costLabel #flags: 16 
		#label: #costLabel) 
		
		#(#{UI.InputFieldSpec} 
		#layout: #(#{Graphics.Rectangle} 378 382 461 408) 
		#name: #costField #flags: 24 
		#model: #cost 
		#callbacksSpec: #(#{UI.UIEventCallbackSubSpec} 
		#valueChangeSelector: #changedInputData) 
		#type: #number 
		#formatString: '0.00') 
		
		#(#{UI.LabelSpec} 
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
#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 <xsl:value-of select="415 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 
</xsl:for-each>
		
			<xsl:for-each select="attributes/attribute">
				<xsl:choose>
					<xsl:when test="type='char'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="415 + 30 * position()"/> 665 <xsl:value-of select="440 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
					</xsl:when>
					<xsl:when test="type='integer'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="415 + 30 * position()"/> 665 <xsl:value-of select="440 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
					</xsl:when>
					<xsl:when test="type='float'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="415 + 30 * position()"/> 665 <xsl:value-of select="440 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
					</xsl:when>
					<xsl:when test="type='date'">
#(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 375 <xsl:value-of select="415 + 30 * position()"/> 665 <xsl:value-of select="440 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
					</xsl:when>
				</xsl:choose>		
</xsl:for-each>			    
		)))
</xsl:when>
</xsl:choose>
</body>

<xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
<body>windowLabel   
	    ^'<xsl:value-of select="class"/>'</body><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>
</methods><xsl:value-of select="$newlineResourceMultiple"/>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>aspects</category>
	<!--ASPECTS-->
	<xsl:call-template name="aspects">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceMultiple"/>

</methods><xsl:value-of select="$newlineResourceMultiple"/>

<xsl:value-of select="$newlineResourceMultiple"/>
<methods><xsl:value-of select="$newlineResourceMultiple"/>
<xsl:value-of select="$newlineResourceMultiple"/>

<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form</class-id> <category>initialize-release</category><xsl:value-of select="$newlineResourceMultiple"/>

	<!--INITIALIZE-->
	<xsl:call-template name="initialize">
		<xsl:with-param name="vars" select="attributes"/>
	</xsl:call-template>

<xsl:value-of select="$newlineResourceMultiple"/>
</methods>
<xsl:value-of select="$newlineResourceMultiple"/>
	
	<!-- /CLASSE RESOURCE TYPE FORM-->

	</xsl:template>
	
</xsl:stylesheet>