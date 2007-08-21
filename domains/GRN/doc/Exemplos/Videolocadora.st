<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 20 de Setembro de 2002 at 5:58:18 pm</time-stamp>


<name-space>
<name>Videolocadora</name>
<environment>Smalltalk</environment>
<private>false</private>
<imports>
			private Smalltalk.*
			private GREN.*
			</imports>
<category>Videolocadora</category>
</name-space>


<class>
<name>Locacao</name>
<environment>Videolocadora</environment>
<super>GREN.ResourceRental</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Locacao class</class-id> <category>hotspots configuration</category>

<body>generateInstanceCode    
	    ^ true</body>

<body>hasAssociatedSale
	^false</body>

<body>hasExecutor
	^false</body>

<body>hasFineRate
	    ^true</body>

<body>hasPayment
	^false</body>

<body>hasReservation
	^false</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Videolocadora.Locacao class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Videolocadora.Cliente</body>

<body>fineRateClass    
	    ^Videolocadora.Taxademulta</body>

<body>resourceClass    
	    ^Videolocadora.Filme</body>

<body>transactionItemClass
  ^Videolocadora.Itemlocacao</body>

<body>transactionPluralName    
	    ^'Locacoes'</body>

<body>transQuantificationStrategyClass
   ^InstantiableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>FitadevideoForm</name>
<environment>Videolocadora</environment>
<super>GREN.ResourceInstanceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>


<class>
<name>FilmeForm</name>
<environment>Videolocadora</environment>
<super>GREN.InstantiableResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>atoresPrincipais anoDoFilme precoDeLocacao diretor dubladaOuLegendada </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.FilmeForm class</class-id> <category>classReferences</category>

<body>additionalColumns
	^List with: 'anoDoFilme' with: 'diretor'</body>

<body>additionalColumnsWidths
	^List with: 10 with: 30</body>

<body>guiSpec 
	    ^#filmeSpec</body>

<body>objectClass    
	    ^Videolocadora.Filme</body>

<body>objectName    
	    ^'Filme'</body>

<body>pluralObjectName    
	    ^'Filmes'</body>

<body>resourceInstanceFormClass
	    ^Videolocadora.FitadevideoForm</body>

<body>typesCanvasClass
								    ^QualificationForm1</body>

<body>typesSpec
								    ^#resType1Spec</body>
</methods>

<methods>
<class-id>Videolocadora.FilmeForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 
			
			^'Nome do filme'</body>

<body>filmeSpec
	"UIPainter new openOnClass: self andSelector: #filmeSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 333 54 1079 508 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 301 215 ) 
					#label: 'Fitas de video' ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 613 275 662 300 ) 
					#name: #addInstanceBt 
					#model: #addInstance 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: 'New' 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 613 321 662 346 ) 
					#name: #removeInstanceBt 
					#model: #removeInstance 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: 'Remove' 
					#defaultable: true ) 
				#(#{UI.DataSetSpec} 
					#layout: #(#{Graphics.Rectangle} 365 216 604 360 ) 
					#name: #instancesListTable 
					#flags: 13 
					#model: #instancesList 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedSelectedInstance ) 
					#columns: #(
						#(#{UI.DataSetColumnSpec} 
							#labelIsImage: false 
							#width: 20 
							#rendererType: #rowSelector 
							#editorType: #rowSelector 
							#noScroll: false ) 
						#(#{UI.DataSetColumnSpec} 
							#model: #'selectedRow code' 
							#callbacksSpec: 
							#(#{UI.UIEventCallbackSubSpec} 
								#valueChangeSelector: #changedInputData ) 
							#label: #codeLabel 
							#labelIsImage: false 
							#width: 50 
							#rendererType: #Text 
							#editorType: #None 
							#noScroll: false ) 
						#(#{UI.DataSetColumnSpec} 
							#model: #'selectedRow allocation' 
							#callbacksSpec: 
							#(#{UI.UIEventCallbackSubSpec} 
								#valueChangeSelector: #changedInputData ) 
							#label: #allocationLabel 
							#labelIsImage: false 
							#width: 70 
							#rendererType: #Text 
							#editorType: #None 
							#noScroll: false ) 
						#(#{UI.DataSetColumnSpec} 
							#model: #'selectedRow statusAsString' 
							#label: #statusLabel 
							#labelIsImage: false 
							#width: 80 
							#rendererType: #Text 
							#editorType: #None 
							#noScroll: false ) ) 
					#multipleSelections: false 
					#labelsAsButtons: true ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 292 209 668 373 ) ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 613 228 662 253 ) 
					#name: #editInstanceBt 
					#model: #editInstance 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: 'Edit' 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 488 76 587 103 ) 
					#name: #storageBt 
					#model: #storageBt 
					#helpText: 'Details about storage' 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #storageBt 
						#defaultString: 'Storage...' ) 
					#defaultable: true ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 297 157 747 323 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 12 58 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 80 ) 
					#label: 'Codigo de Barras' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 116 ) 
					#label: 'Nome do Filme' ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 265 7 593 48 ) ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 6 7 230 47 ) ) 
				#(#{UI.SequenceViewSpec} 
					#layout: #(#{Graphics.Rectangle} 10 83 285 321 ) 
					#name: #allStaticObjects 
					#model: #allStaticObjects 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#requestFocusInSelector: #changeRequest ) 
					#useModifierKeys: true 
					#selectionType: #highlight ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 394 77 457 103 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 393 116 647 141 ) 
					#name: #descriptionField 
					#model: #w_description 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 12 13 225 44 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 271 14 591 48 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 157 345 175 370 ) 
					#name: #dubladaOuLegendada 
					#model: #dubladaOuLegendada 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 99 379 310 405 ) 
					#name: #atoresPrincipais 
					#model: #atoresPrincipais 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 300 417 ) 
					#name: #costLabel 
					#flags: 16 
					#label: #costLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 382 417 465 443 ) 
					#name: #costField 
					#flags: 24 
					#model: #cost 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 492 417 ) 
					#name: #salePriceLabel 
					#flags: 16 
					#label: #salePriceLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 580 417 663 443 ) 
					#name: #salePriceField 
					#flags: 24 
					#model: #salePrice 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 93 414 263 439 ) 
					#name: #diretor 
					#model: #diretor 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 406 384 458 407 ) 
					#name: #anoDoFilme 
					#model: #anoDoFilme 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 572 384 638 408 ) 
					#name: #precoDeLocacao 
					#model: #precoDeLocacao 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 14 379 ) 
					#label: 'Atores principais' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 326 384 ) 
					#label: 'Ano do filme' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 467 384 ) 
					#label: 'Preco de locação' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 13 414 ) 
					#label: 'Diretor' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 345 ) 
					#label: 'Dublada ou Legendada ?' ) ) ) )</body>

<body>idCodeLabel 
			
			^'Codigo de barras'</body>

<body>windowLabel   
	    ^'Filme'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.FilmeForm</class-id> <category>aspects</category>

<body>anoDoFilme
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #anoDoFilme.
	^adaptor</body>

<body>atoresPrincipais
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #atoresPrincipais.
	^adaptor</body>

<body>diretor
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #diretor.
	^adaptor</body>

<body>dubladaOuLegendada
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #dubladaOuLegendada.
	^adaptor</body>

<body>precoDeLocacao
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #precoDeLocacao.
	^adaptor</body>
</methods>

<methods>
<class-id>Videolocadora.FilmeForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 atoresPrincipais := '' asValue.
					 anoDoFilme := '' asValue.
					 precoDeLocacao := 0.00 asValue.
					 diretor := '' asValue.
					 dubladaOuLegendada := '' asValue</body>
</methods>

<methods>
<class-id>Videolocadora.FilmeForm</class-id> <category>report parameters</category>

<body>reportByType
					^'Lista de videos por categoria'</body>
</methods>


<class>
<name>ItemlocacaoForm</name>
<environment>Videolocadora</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>


<class>
<name>LocacaoForm</name>
<environment>Videolocadora</environment>
<super>GREN.MultiResourceRentalForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.LocacaoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Videolocadora.Locacao</body>

<body>transactionItemFormClass
	    ^Videolocadora.ItemlocacaoForm</body>
</methods>

<methods>
<class-id>Videolocadora.LocacaoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>resourcesTransactedLabel   
	    ^'Filme'</body>

<body>windowLabel   
	    ^'Locacao'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.LocacaoForm</class-id> <category>report parameters</category>

<body>reportByDPTitle
					^'Lista de locações por cliente'</body>

<body>reportByNTransTitle
					^'Lista de filmes mais locados'</body>

<body>reportByPeriodTitle
					^'Relatório de locações no período'</body>

<body>reportByResourceTitle
					^'Lista de locações por filme'</body>

<body>reportOverdueTitle
					^'Relatório de locações não devolvidas'</body>
</methods>


<class>
<name>Genero</name>
<environment>Videolocadora</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Genero class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Videolocadora.Genero class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Fitadevideo</name>
<environment>Videolocadora</environment>
<super>GREN.ResourceInstance</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>


<class>
<name>GeneroForm</name>
<environment>Videolocadora</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.GeneroForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Videolocadora.Genero</body>

<body>objectName    
	    ^'Genero'</body>

<body>pluralObjectName    
	    ^'Generos'</body>
</methods>

<methods>
<class-id>Videolocadora.GeneroForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Genero'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.GeneroForm</class-id> <category>report parameters</category>

<body>reportByDescriptionTitle
					^'Lista de videos por titulo'</body>
</methods>


<class>
<name>Cliente</name>
<environment>Videolocadora</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade estado telefone email documentoIdent dataNascimento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Cliente class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Videolocadora.ClienteForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Cliente</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,cidade ,estado ,telefone ,email ,documentoIdent ,dataNascimento'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self cidade printString, ',', self estado printString, ',', self telefone printString, ',', self email printString, ',', self documentoIdent printString, ',', self dataNascimento printForSaving</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', cidade = ' ,self cidade printString,', estado = ' ,self estado printString,', telefone = ' ,self telefone printString,', email = ' ,self email printString,', documentoIdent = ' ,self documentoIdent printString,', dataNascimento = ' ,self dataNascimento printForSaving</body>
</methods>

<methods>
<class-id>Videolocadora.Cliente</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 cidade := ''.
					 estado := ''.
					 telefone := ''.
					 email := ''.
					 documentoIdent := ''.
					 dataNascimento := Date today</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self endereco: (aRow at: newIndex).
	self endereco isNil ifTrue: [self endereco: ' '].
	newIndex := newIndex + 1.
	self cidade: (aRow at: newIndex).
	self cidade isNil ifTrue: [self cidade: ' '].
	newIndex := newIndex + 1.
	self estado: (aRow at: newIndex).
	self estado isNil ifTrue: [self estado: ' '].
	newIndex := newIndex + 1.
	self telefone: (aRow at: newIndex).
	self telefone isNil ifTrue: [self telefone: ' '].
	newIndex := newIndex + 1.
	self email: (aRow at: newIndex).
	self email isNil ifTrue: [self email: ' '].
	newIndex := newIndex + 1.
	self documentoIdent: (aRow at: newIndex).
	self documentoIdent isNil ifTrue: [self documentoIdent: ' '].
	newIndex := newIndex + 1.
	self dataNascimento: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Videolocadora.Cliente</class-id> <category>accessing</category>

<body>cidade
	^cidade</body>

<body>cidade: newcidade
	self update: 'cidade' to: newcidade.
	self changed: #cidade.
	self isChanged: true.</body>

<body>dataNascimento
	^dataNascimento</body>

<body>dataNascimento: newdataNascimento
	self update: 'dataNascimento' to: newdataNascimento.
	self changed: #dataNascimento.
	self isChanged: true.</body>

<body>documentoIdent
	^documentoIdent</body>

<body>documentoIdent: newdocumentoIdent
	self update: 'documentoIdent' to: newdocumentoIdent.
	self changed: #documentoIdent.
	self isChanged: true.</body>

<body>email
	^email</body>

<body>email: newemail
	self update: 'email' to: newemail.
	self changed: #email.
	self isChanged: true.</body>

<body>endereco
	^endereco</body>

<body>endereco: newendereco
	self update: 'endereco' to: newendereco.
	self changed: #endereco.
	self isChanged: true.</body>

<body>estado
	^estado</body>

<body>estado: newestado
	self update: 'estado' to: newestado.
	self changed: #estado.
	self isChanged: true.</body>

<body>telefone
	^telefone</body>

<body>telefone: newtelefone
	self update: 'telefone' to: newtelefone.
	self changed: #telefone.
	self isChanged: true.</body>
</methods>


<class>
<name>Filme</name>
<environment>Videolocadora</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>atoresPrincipais anoDoFilme precoDeLocacao diretor dubladaOuLegendada </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Filme class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Videolocadora.FilmeForm</body>

<body>quantificationStrategyClass
   ^InstantiableResource</body>

<body>resourceInstanceClass    
	    ^Videolocadora.Fitadevideo</body>

<body>resourceRentalClass    
	    ^Videolocadora.Locacao</body>

<body>typeClasses  
	^List with: Videolocadora.Genero</body>

<body>typeForms  
	^List with: Videolocadora.GeneroForm</body>
</methods>

<methods>
<class-id>Videolocadora.Filme class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List with: 'Genero'</body>
</methods>

<methods>
<class-id>Videolocadora.Filme class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Filme</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,atoresPrincipais ,anoDoFilme ,precoDeLocacao ,diretor ,dubladaOuLegendada'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self atoresPrincipais printString, ',', self anoDoFilme printString, ',', self precoDeLocacao printString, ',', self diretor printString, ',', self dubladaOuLegendada printString</body>

<body>updateSetClause
	    ^super updateSetClause,', atoresPrincipais = ' ,self atoresPrincipais printString,', anoDoFilme = ' ,self anoDoFilme printString,', precoDeLocacao = ' ,self precoDeLocacao printString,', diretor = ' ,self diretor printString,', dubladaOuLegendada = ' ,self dubladaOuLegendada printString</body>
</methods>

<methods>
<class-id>Videolocadora.Filme</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 atoresPrincipais := ''.
					 anoDoFilme := ''.
					 precoDeLocacao := 0.00.
					 diretor := ''.
					 dubladaOuLegendada := ''</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self atoresPrincipais: (aRow at: newIndex).
	self atoresPrincipais isNil ifTrue: [self atoresPrincipais: ' '].
	newIndex := newIndex + 1.
	self anoDoFilme: (aRow at: newIndex).
	self anoDoFilme isNil ifTrue: [self anoDoFilme: ' '].
	newIndex := newIndex + 1.
	self precoDeLocacao: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self diretor: (aRow at: newIndex).
	self diretor isNil ifTrue: [self diretor: ' '].
	newIndex := newIndex + 1.
	self dubladaOuLegendada: (aRow at: newIndex).
	self dubladaOuLegendada isNil ifTrue: [self dubladaOuLegendada: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Videolocadora.Filme</class-id> <category>accessing</category>

<body>anoDoFilme
	^anoDoFilme</body>

<body>anoDoFilme: newanoDoFilme
	self update: 'anoDoFilme' to: newanoDoFilme.
	self changed: #anoDoFilme.
	self isChanged: true.</body>

<body>atoresPrincipais
	^atoresPrincipais</body>

<body>atoresPrincipais: newatoresPrincipais
	self update: 'atoresPrincipais' to: newatoresPrincipais.
	self changed: #atoresPrincipais.
	self isChanged: true.</body>

<body>diretor
	^diretor</body>

<body>diretor: newdiretor
	self update: 'diretor' to: newdiretor.
	self changed: #diretor.
	self isChanged: true.</body>

<body>dubladaOuLegendada
	^dubladaOuLegendada</body>

<body>dubladaOuLegendada: newdubladaOuLegendada
	self update: 'dubladaOuLegendada' to: newdubladaOuLegendada.
	self changed: #dubladaOuLegendada.
	self isChanged: true.</body>

<body>precoDeLocacao
	^precoDeLocacao</body>

<body>precoDeLocacao: newprecoDeLocacao
	self update: 'precoDeLocacao' to: newprecoDeLocacao.
	self changed: #precoDeLocacao.
	self isChanged: true.</body>
</methods>


<class>
<name>Itemlocacao</name>
<environment>Videolocadora</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.Itemlocacao class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^InstResTransItem</body>

<body>resourceClass    
	    ^Videolocadora.Filme</body>

<body>transactionClass    
	    ^Videolocadora.Locacao</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Taxademulta</name>
<environment>Videolocadora</environment>
<super>GREN.FineRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>


<class>
<name>VideolocadoraMainWindow</name>
<environment>Videolocadora</environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.VideolocadoraMainWindow class</class-id> <category>resources</category>

<body>mainMenu
	| mb |
	mb := MenuBuilder new.
	mb beginSubMenuLabeled: 'File'; add: 'Exit' -&gt; #exit; endSubMenu.
	
	mb beginSubMenuLabeled: 'Edit';  add: 'Filme' -&gt; #filme;  add: 'Genero' -&gt; #genero;  add: 'Locacao' -&gt; #locacao;  add: 'Taxa de Multa' -&gt; #taxademulta;  add: 'Cliente' -&gt; #cliente;  endSubMenu.
	mb beginSubMenuLabeled: 'Reports';  add: 'Lista de videos por titulo' -&gt; #listByDescription1;  add: 'Lista de videos por categoria' -&gt; #listByType1;  add: 'Lista de locações por cliente' -&gt; #listByDestinationParty3;  add: 'Lista de clientes' -&gt; #listByDescription3;  add: 'Relatório de locações no período' -&gt; #listByPeriod3;  add: 'Relatório de locações não devolvidas' -&gt; #listOverdueRentals3;  add: 'Lista de locações por filme' -&gt; #listByResource3;  add: 'Lista de filmes mais locados' -&gt; #listByNumberOfTransactions3;  endSubMenu.
	^mb menu</body>
</methods>

<methods>
<class-id>Videolocadora.VideolocadoraMainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'Videolocadora'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.VideolocadoraMainWindow</class-id> <category>resources</category>

<body>cliente
^Videolocadora.ClienteForm openWithSpec: #clienteSpec</body>

<body>filme
^Videolocadora.FilmeForm openWithSpec: #filmeSpec</body>

<body>genero
^Videolocadora.GeneroForm openWithSpec: #windowSpec</body>

<body>listByDescription1
					^GeneroForm new listByDescription</body>

<body>listByDescription3
					^ClienteForm new listByDescription</body>

<body>listByDestinationParty3
					^LocacaoForm new listByDestinationParty</body>

<body>listByNumberOfTransactions3
					^LocacaoForm new listByNumberOfTransactions</body>

<body>listByPeriod3
					^LocacaoForm new listByPeriod</body>

<body>listByResource3
					^LocacaoForm new listByResource</body>

<body>listByType1
					^FilmeForm new listByType</body>

<body>listOverdueRentals3
					^LocacaoForm new listOverdueRentals</body>

<body>locacao
^Videolocadora.LocacaoForm openWithSpec: #multipleResRentalSpec</body>

<body>taxademulta
^Videolocadora.TaxademultaForm openWithSpec: #windowSpec</body>
</methods>

<methods>
<class-id>Videolocadora.VideolocadoraMainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='Videolocadora'.
	ReportHeader := '  V  I  D  E  O  L  O  C  A  D  O  R  A'.
	Language := #portuguese.
	super initialize.</body>
</methods>


<class>
<name>ClienteForm</name>
<environment>Videolocadora</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade estado telefone email documentoIdent dataNascimento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.ClienteForm class</class-id> <category>classReferences</category>

<body>additionalColumns
	^List with: 'cidade' with: 'telefone'</body>

<body>additionalColumnsWidths
	^List with: 20 with: 15</body>

<body>guiSpec 
	    ^#clienteSpec</body>

<body>objectClass    
	    ^Videolocadora.Cliente</body>

<body>objectName    
	    ^'Cliente'</body>

<body>pluralObjectName    
	    ^'Clientes'</body>
</methods>

<methods>
<class-id>Videolocadora.ClienteForm class</class-id> <category>interface specs</category>

<body>clienteSpec
	"UIPainter new openOnClass: self andSelector: #clienteSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 79 83 734 461 ) ) 
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
					#layout: #(#{Graphics.Rectangle} 7 80 283 354 ) 
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
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 157 ) 
					#label: 'Endereco' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 187 ) 
					#label: 'Cidade' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 217 ) 
					#label: 'Estado' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 247 ) 
					#label: 'Telefone' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 277 ) 
					#label: 'Email' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 307 ) 
					#label: 'Documento de Identidade/Tipo' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 337 ) 
					#label: 'Data de Nascimento' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 157 544 182 ) 
					#name: #endereco 
					#model: #endereco 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 187 544 212 ) 
					#name: #cidade 
					#model: #cidade 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 217 404 239 ) 
					#name: #estado 
					#model: #estado 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 247 517 271 ) 
					#name: #telefone 
					#model: #telefone 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 277 544 302 ) 
					#name: #email 
					#model: #email 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 451 307 621 332 ) 
					#name: #documentoIdent 
					#model: #documentoIdent 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 401 335 503 358 ) 
					#name: #dataNascimento 
					#model: #dataNascimento 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) ) ) )</body>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>windowLabel   
	    ^'Cliente'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.ClienteForm</class-id> <category>aspects</category>

<body>cidade
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #cidade.
	^adaptor</body>

<body>dataNascimento
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #dataNascimento.
	^adaptor</body>

<body>documentoIdent
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #documentoIdent.
	^adaptor</body>

<body>email
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #email.
	^adaptor</body>

<body>endereco
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #endereco.
	^adaptor</body>

<body>estado
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #estado.
	^adaptor</body>

<body>telefone
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aStaticObject.
	adaptor forAspect: #telefone.
	^adaptor</body>
</methods>

<methods>
<class-id>Videolocadora.ClienteForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 cidade := '' asValue.
					 estado := '' asValue.
					 telefone := '' asValue.
					 email := '' asValue.
					 documentoIdent := '' asValue.
					 dataNascimento := Date today asValue</body>
</methods>

<methods>
<class-id>Videolocadora.ClienteForm</class-id> <category>report parameters</category>

<body>reportByDescriptionTitle
					^'Lista de clientes'</body>
</methods>


<class>
<name>TaxademultaForm</name>
<environment>Videolocadora</environment>
<super>GREN.FineRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Videolocadora</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Videolocadora.TaxademultaForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Videolocadora.Taxademulta</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->




</st-source>
