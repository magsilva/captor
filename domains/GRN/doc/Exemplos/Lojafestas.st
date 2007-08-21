<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 23 de Setembro de 2002 at 1:28:37 pm</time-stamp>


<name-space>
<name>Lojafestas</name>
<environment>Smalltalk</environment>
<private>false</private>
<imports>
			private Smalltalk.*
			private GREN.*
			</imports>
<category>Lojafestas</category>
</name-space>


<class>
<name>Unidadedemedida</name>
<environment>Lojafestas</environment>
<super>GREN.MeasureUnity</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Vendadeproduto</name>
<environment>Lojafestas</environment>
<super>GREN.BasicSale</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Vendadeproduto class</class-id> <category>hotspots configuration</category>

<body>hasDelivery
	^false</body>

<body>hasExecutor
	^false</body>

<body>hasPayment
	^false</body>

<body>hasQuotation
	^false</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Lojafestas.Vendadeproduto class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Lojafestas.Cliente</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionItemClass
  ^Lojafestas.Itemvendido</body>

<body>transactionPluralName    
	    ^'Vendas de Produtos'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Itempedido</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Itempedido class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionClass    
	    ^Lojafestas.Pedido</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ProdutoForm</name>
<environment>Lojafestas</environment>
<super>GREN.MeasurableResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>precoDeVenda podeseralugado listPodeseralugado </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ProdutoForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#produtoSpec</body>

<body>objectClass    
	    ^Lojafestas.Produto</body>

<body>objectName    
	    ^'Produto'</body>

<body>pluralObjectName    
	    ^'Produtos'</body>

<body>typesCanvasClass
								    ^QualificationForm1</body>

<body>typesSpec
								    ^#resType1Spec</body>
</methods>

<methods>
<class-id>Lojafestas.ProdutoForm class</class-id> <category>interface specs</category>

<body>produtoSpec
	"UIPainter new openOnClass: self andSelector: #produtoSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} -3 136 734 507 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 207 ) 
					#label: 'Re-Supply Level:' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 394 205 494 230 ) 
					#model: #reSupplyLevel 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 164 ) 
					#label: 'Quantity in Stock:' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 510 197 ) 
					#label: #measureUnityLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 394 163 494 188 ) 
					#model: #quantityInStock 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 617 196 717 221 ) 
					#model: #measureUnity 
					#objectListMethod: #allMeasureUnities ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 29 1 242 32 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 295 247 746 405 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 293 ) 
					#name: #precodevendaLabel 
					#label: 'Preço de venda' ) 
				#(#{UI.LabelSpec} 
					#properties: #(#{UI.PropertyListDictionary} #anchorType #anchorDestination ) 
					#layout: #(#{Core.Point} 293 336 ) 
					#name: #podeseralugadoLabel 
					#label: 'Pode ser alugado?' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 394 290 471 317 ) 
					#name: #precoDeVenda 
					#model: #precoDeVenda 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 394 338 456 361 ) 
					#name: #podeseralugado 
					#model: #podeseralugado 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedPodeseralugado ) 
					#objectListMethod: #listPodeseralugado ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 484 74 585 101 ) 
					#name: #storageBt 
					#model: #storageBt 
					#helpText: 'Details about storage' 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #storageBt 
						#defaultString: 'Storage...' ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 250 ) 
					#name: #costLabel 
					#flags: 16 
					#label: #costLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 393 250 476 276 ) 
					#name: #costField 
					#flags: 24 
					#model: #cost 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 500 292 ) 
					#name: #salePriceLabel 
					#flags: 16 
					#label: #salePriceLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 597 292 680 318 ) 
					#name: #salePriceField 
					#flags: 24 
					#model: #salePrice 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 8 56 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 78 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 121 ) 
					#label: #descriptionLabel ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 261 5 589 46 ) ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 2 5 226 45 ) ) 
				#(#{UI.SequenceViewSpec} 
					#layout: #(#{Graphics.Rectangle} 6 81 282 349 ) 
					#name: #allStaticObjects 
					#model: #allStaticObjects 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#requestFocusInSelector: #changeRequest ) 
					#useModifierKeys: true 
					#selectionType: #highlight ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 75 453 101 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 389 114 643 139 ) 
					#name: #descriptionField 
					#model: #w_description 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 8 11 221 42 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 267 12 587 46 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) ) ) )</body>

<body>reSupplyLevelLabel 
			
			^'Nivelcritico'</body>

<body>windowLabel   
	    ^'Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ProdutoForm</class-id> <category>aspects</category>

<body>listPodeseralugado
	^listPodeseralugado</body>

<body>listPodeseralugado: newListPodeseralugado
	    listPodeseralugado:= newListPodeseralugado</body>

<body>podeseralugado
	^podeseralugado</body>

<body>podeseralugado: newPodeseralugado
		self podeseralugado value: newPodeseralugado</body>

<body>precoDeVenda
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #precoDeVenda.
		^adaptor</body>
</methods>

<methods>
<class-id>Lojafestas.ProdutoForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 precoDeVenda := 0.00 asValue.
					 podeseralugado := 0 asValue.
										listPodeseralugado := GRENWizard.Podeseralugado new values</body>
</methods>

<methods>
<class-id>Lojafestas.ProdutoForm</class-id> <category>changed messages</category>

<body>changedPodeseralugado  
                      self  podeseralugado value isNil
			   ifFalse: [self aStaticObject value podeseralugado: (GRENWizard.Podeseralugado objectWithDescription: self podeseralugado value) idCode].
			   super changedInputData</body>

<body>refreshForm  
			super refreshForm. 
						self  aStaticObject value podeseralugado &gt;= 1 
						ifTrue: [self podeseralugado: (GRENWizard.Podeseralugado new values at: self aStaticObject value podeseralugado) description] ifFalse: [self podeseralugado: ' '].</body>
</methods>

<methods>
<class-id>Lojafestas.ProdutoForm</class-id> <category>report parameters</category>

<body>reportByDescriptionTitle
					^'Produtos por descrição'</body>

<body>reportByIdCodeTitle
					^'Produtos por código de barras'</body>
</methods>


<class>
<name>Check</name>
<environment>Lojafestas</environment>
<super>GREN.Check</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Cliente</name>
<environment>Lojafestas</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco telefone </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Cliente class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Lojafestas.ClienteForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Cliente</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,telefone'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self telefone printString</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', telefone = ' ,self telefone printString</body>
</methods>

<methods>
<class-id>Lojafestas.Cliente</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 telefone := ''</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self endereco: (aRow at: newIndex).
	self endereco isNil ifTrue: [self endereco: ' '].
	newIndex := newIndex + 1.
	self telefone: (aRow at: newIndex).
	self telefone isNil ifTrue: [self telefone: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Lojafestas.Cliente</class-id> <category>accessing</category>

<body>endereco
	^endereco</body>

<body>endereco: newendereco
	self update: 'endereco' to: newendereco.
	self changed: #endereco.
	self isChanged: true.</body>

<body>telefone
	^telefone</body>

<body>telefone: newtelefone
	self update: 'telefone' to: newtelefone.
	self changed: #telefone.
	self isChanged: true.</body>
</methods>


<class>
<name>FornecedorForm</name>
<environment>Lojafestas</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade telefone fax </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.FornecedorForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'freight' 'taxes')</body>

<body>guiSpec 
	    ^#fornecedorSpec</body>

<body>objectClass    
	    ^Lojafestas.Fornecedor</body>

<body>objectName    
	    ^'Fornecedor'</body>

<body>pluralObjectName    
	    ^'Fornecedores'</body>
</methods>

<methods>
<class-id>Lojafestas.FornecedorForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>fornecedorSpec
	"UIPainter new openOnClass: self andSelector: #fornecedorSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 20 18 675 358 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 9 55 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 83 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 119 ) 
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
					#layout: #(#{Graphics.Rectangle} 391 79 454 105 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 118 645 143 ) 
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
					#layout: #(#{Core.Point} 294 155 ) 
					#name: #enderecoLabel 
					#label: 'Endereco' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 192 ) 
					#name: #cidadeLabel 
					#label: 'Cidade' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 228 ) 
					#name: #telefoneLabel 
					#label: 'Telefone' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 265 ) 
					#name: #faxLabel 
					#label: 'Fax' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 156 561 181 ) 
					#name: #endereco 
					#model: #endereco 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 194 561 219 ) 
					#name: #cidade 
					#model: #cidade 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 232 561 257 ) 
					#name: #telefone 
					#model: #telefone 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 270 561 295 ) 
					#name: #fax 
					#model: #fax 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) ) ) )</body>

<body>windowLabel   
	    ^'Fornecedor'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.FornecedorForm</class-id> <category>aspects</category>

<body>cidade
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #cidade.
		^adaptor</body>

<body>endereco
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #endereco.
		^adaptor</body>

<body>fax
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #fax.
		^adaptor</body>

<body>telefone
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #telefone.
		^adaptor</body>
</methods>

<methods>
<class-id>Lojafestas.FornecedorForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 cidade := '' asValue.
					 telefone := '' asValue.
					 fax := '' asValue</body>
</methods>


<class>
<name>Itemreservado</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Itemreservado class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionClass    
	    ^Lojafestas.Reservadeproduto</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ReservadeprodutoForm</name>
<environment>Lojafestas</environment>
<super>GREN.MultiResourceReservationForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ReservadeprodutoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Lojafestas.Reservadeproduto</body>

<body>transactionItemFormClass
	    ^Lojafestas.ItemreservadoForm</body>
</methods>

<methods>
<class-id>Lojafestas.ReservadeprodutoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>resourcesTransactedLabel   
	    ^'Produto'</body>

<body>windowLabel   
	    ^'Reserva de Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ReservadeprodutoForm</class-id> <category>report parameters</category>

<body>reportByResourceTitle
					^'Reservas por produto'</body>
</methods>


<class>
<name>CompraForm</name>
<environment>Lojafestas</environment>
<super>GREN.MultiResourceDeliveryForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.CompraForm class</class-id> <category>classReferences</category>

<body>paymentFormClass
	    ^Lojafestas.ContasapagarForm</body>

<body>transactionClass
	    ^Lojafestas.Compra</body>

<body>transactionItemFormClass
	    ^Lojafestas.ItemcompradoForm</body>
</methods>

<methods>
<class-id>Lojafestas.CompraForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Fornecedor'</body>

<body>resourcesTransactedLabel   
	    ^'Produto'</body>

<body>windowLabel   
	    ^'Compra'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.CompraForm</class-id> <category>report parameters</category>

<body>listByPeriodTitle
					^'Compras efetuadas no período'</body>
</methods>


<class>
<name>ContasapagarForm</name>
<environment>Lojafestas</environment>
<super>GREN.PaymentForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ContasapagarForm class</class-id> <category>classReferences</category>

<body>paymentClass    
	    ^Lojafestas.Contasapagar</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ContasapagarForm</class-id> <category>report parameters</category>

<body>reportComingTitle
					^'Contas a pagar no período'</body>

<body>reportOverdueTitle
					^'Contas em atraso'</body>

<body>reportPaidTitle
					^'Contas pagas no período'</body>
</methods>


<class>
<name>Itemvendido</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Itemvendido class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionClass    
	    ^Lojafestas.Vendadeproduto</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Compra</name>
<environment>Lojafestas</environment>
<super>GREN.PurchaseDelivery</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Compra class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^false</body>

<body>hasPayment
	^true</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Lojafestas.Compra class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Lojafestas.Fornecedor</body>

<body>paymentClass
  ^Lojafestas.Contasapagar</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>tradeClass    
	    ^Lojafestas.Pedido</body>

<body>transactionItemClass
  ^Lojafestas.Itemcomprado</body>

<body>transactionPluralName    
	    ^'Compras'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Estadodoproduto</name>
<environment>Lojafestas</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Estadodoproduto class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Lojafestas.Estadodoproduto class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Jurosdofornecedor</name>
<environment>Lojafestas</environment>
<super>GREN.InterestRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>ItemreservadoForm</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>AlugueldeprodutoForm</name>
<environment>Lojafestas</environment>
<super>GREN.MultiResourceRentalForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.AlugueldeprodutoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Lojafestas.Alugueldeproduto</body>

<body>transactionItemFormClass
	    ^Lojafestas.ItemalugadoForm</body>
</methods>

<methods>
<class-id>Lojafestas.AlugueldeprodutoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>resourcesTransactedLabel   
	    ^'Produto'</body>

<body>totalPriceLabel 
			
			^'Taxa'</body>

<body>windowLabel   
	    ^'Aluguel de Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.AlugueldeprodutoForm</class-id> <category>report parameters</category>

<body>reportByNTransTitle
					^'Produtos mais alugados'</body>

<body>reportByResourceTitle
					^'Aluguéis por produto'</body>

<body>reportDailyGainsTitle
					^'Ganhos com aluguel no período'</body>

<body>reportOverdueTitle
					^'Produtos alugados e não devolvidos'</body>
</methods>


<class>
<name>ClienteForm</name>
<environment>Lojafestas</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco telefone </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ClienteForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#clienteSpec</body>

<body>objectClass    
	    ^Lojafestas.Cliente</body>

<body>objectName    
	    ^'Cliente'</body>

<body>pluralObjectName    
	    ^'Clientes'</body>
</methods>

<methods>
<class-id>Lojafestas.ClienteForm class</class-id> <category>interface specs</category>

<body>clienteSpec
	"UIPainter new openOnClass: self andSelector: #clienteSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 93 128 748 468 ) ) 
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
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 157 ) 
					#name: #enderecoLabel 
					#label: 'Endereco' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 200 ) 
					#name: #telefoneLabel 
					#label: 'Telefone' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 157 643 181 ) 
					#name: #endereco 
					#model: #endereco 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 200 494 225 ) 
					#name: #telefone 
					#model: #telefone 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) ) ) )</body>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>windowLabel   
	    ^'Cliente'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.ClienteForm</class-id> <category>aspects</category>

<body>endereco
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #endereco.
		^adaptor</body>

<body>telefone
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #telefone.
		^adaptor</body>
</methods>

<methods>
<class-id>Lojafestas.ClienteForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 telefone := '' asValue</body>
</methods>


<class>
<name>LojafestasMainWindow</name>
<environment>Lojafestas</environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.LojafestasMainWindow class</class-id> <category>resources</category>

<body>mainMenu
	"MenuEditor new openOnClass: self andSelector: #mainMenu"

	&lt;resource: #menu&gt;
	^#(#{UI.Menu} #(
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Arquivo' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Sair' 
							#value: #exit ) ) #(1 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Cadastros' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Unidade de medida' 
							#value: #unidadedemedida ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Estado do Produto' 
							#value: #estadodoproduto ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Produto' 
							#value: #produto ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'C&amp;liente' 
							#value: #cliente ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Fornecedor' 
							#value: #fornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Multa para Fornecedor' 
							#value: #multadofornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Juros do fornecedor' 
							#value: #jurosdofornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Reserva de Produto' 
							#value: #reservadeproduto ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Aluguel de Produtos' 
							#value: #alugueldeproduto ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Venda de Produtos' 
							#value: #vendadeproduto ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'P&amp;edido ao Fornecedor' 
							#value: #pedido ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'C&amp;ompra do Fornecedor' 
							#value: #compra ) ) #(5 2 3 2 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Relatórios' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 'Produtos por descrição' 
							#value: #listByDescription1 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Produtos por código de barras' 
							#value: #listByIdCode1 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Ganhos com aluguel no período' 
							#value: #listGainsByPeriod3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Reservas por produto' 
							#value: #listByResource5 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Aluguéis por produto' 
							#value: #listByResource3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Produtos mais alugados' 
							#value: #listByNumberOfTransactions3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Ganhos com venda no período' 
							#value: #listGainsByPeriod7 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Produtos alugados e não devolvidos' 
							#value: #listOverdueRentals3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Compras efetuadas no período' 
							#value: #listByPeriod9 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Pedidos pendentes do fornecedor' 
							#value: #listPendingTrades12 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Contas a pagar no período' 
							#value: #listComingInstallments11 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Contas em atraso' 
							#value: #listOverdueInstallments11 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Contas pagas no período' 
							#value: #listPaidInstallments11 ) ) #(13 ) nil ) ) ) #(3 ) nil ) decodeAsLiteralArray</body>
</methods>

<methods>
<class-id>Lojafestas.LojafestasMainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'Loja Festas'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.LojafestasMainWindow</class-id> <category>resources</category>

<body>alugueldeproduto
^Lojafestas.AlugueldeprodutoForm openWithSpec: #multipleResRentalSpec</body>

<body>cliente
^Lojafestas.ClienteForm openWithSpec: #clienteSpec</body>

<body>compra
^Lojafestas.CompraForm openWithSpec: #multiResDeliverySpec</body>

<body>estadodoproduto
^Lojafestas.EstadodoprodutoForm openWithSpec: #windowSpec</body>

<body>fornecedor
^Lojafestas.FornecedorForm openWithSpec: #fornecedorSpec</body>

<body>jurosdofornecedor
^Lojafestas.JurosdofornecedorForm openWithSpec: #windowSpec</body>

<body>listByDescription1
					^ProdutoForm new listByDescription</body>

<body>listByIdCode1
					^ProdutoForm new listByIdCode</body>

<body>listByNumberOfTransactions3
					^AlugueldeprodutoForm new listByNumberOfTransactions</body>

<body>listByPeriod9
					^CompraForm new listByPeriod</body>

<body>listByResource3
					^AlugueldeprodutoForm new listByResource</body>

<body>listByResource5
					^ReservadeprodutoForm new listByResource</body>

<body>listComingInstallments11
					^ContasapagarForm new listComingInstallments</body>

<body>listGainsByPeriod3
					^AlugueldeprodutoForm new listGainsByPeriod</body>

<body>listGainsByPeriod7
					^VendadeprodutoForm new listGainsByPeriod</body>

<body>listOverdueInstallments11
					^ContasapagarForm new listOverdueInstallments</body>

<body>listOverdueRentals3
					^AlugueldeprodutoForm new listOverdueRentals</body>

<body>listPaidInstallments11
					^ContasapagarForm new listPaidInstallments</body>

<body>listPendingTrades12
					^PedidoForm new listPendingTrades</body>

<body>multadofornecedor
^Lojafestas.MultadofornecedorForm openWithSpec: #windowSpec</body>

<body>pedido
^Lojafestas.PedidoForm openWithSpec: #multiResTradeSpec</body>

<body>produto
^Lojafestas.ProdutoForm openWithSpec: #produtoSpec</body>

<body>reservadeproduto
^Lojafestas.ReservadeprodutoForm openWithSpec: #multiResourceReservSpec</body>

<body>unidadedemedida
^Lojafestas.UnidadedemedidaForm openWithSpec: #windowSpec</body>

<body>vendadeproduto
^Lojafestas.VendadeprodutoForm openWithSpec: #multiResTradeSpec</body>
</methods>

<methods>
<class-id>Lojafestas.LojafestasMainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='Lojafestas'.
	ReportHeader := '  L  O  J  A     F  E  S  T  A  S'.
	Language := #portuguese.
	super initialize.</body>
</methods>


<class>
<name>Contasapagar</name>
<environment>Lojafestas</environment>
<super>GREN.Payment</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Contasapagar class</class-id> <category>classReferences</category>

<body>defaultPaymentStrategyClass   
	    ^Cash</body>

<body>fineRateClass    
	    ^Lojafestas.Multadofornecedor</body>

<body>interestRateClass    
	    ^Lojafestas.Jurosdofornecedor</body>

<body>paymentStrategyClasses  
	    ^List with: Cash with: Check</body>

<body>transactionClass    
	    ^Lojafestas.Compra</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ItemvendidoForm</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>EstadodoprodutoForm</name>
<environment>Lojafestas</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.EstadodoprodutoForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Lojafestas.Estadodoproduto</body>

<body>objectName    
	    ^'Estado do Produto'</body>

<body>pluralObjectName    
	    ^'Estados do Produto'</body>
</methods>

<methods>
<class-id>Lojafestas.EstadodoprodutoForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Estado do Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>JurosdofornecedorForm</name>
<environment>Lojafestas</environment>
<super>GREN.InterestRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.JurosdofornecedorForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Lojafestas.Jurosdofornecedor</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Multadofornecedor</name>
<environment>Lojafestas</environment>
<super>GREN.FineRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Itemalugado</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Itemalugado class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionClass    
	    ^Lojafestas.Alugueldeproduto</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Alugueldeproduto</name>
<environment>Lojafestas</environment>
<super>GREN.ResourceRental</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Alugueldeproduto class</class-id> <category>hotspots configuration</category>

<body>hasAssociatedSale
	^true</body>

<body>hasExecutor
	^false</body>

<body>hasFineRate    
	    ^false</body>

<body>hasPayment
	^false</body>

<body>hasReservation
	^true</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Lojafestas.Alugueldeproduto class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Lojafestas.Cliente</body>

<body>fineRateClass    
	    ^GREN.FineRate</body>

<body>reservationClass    
	    ^Lojafestas.Reservadeproduto</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>tradeClass    
	    ^Lojafestas.Vendadeproduto</body>

<body>transactionItemClass
  ^Lojafestas.Itemalugado</body>

<body>transactionPluralName    
	    ^'Alugueis de Produto'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Itemcomprado</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Itemcomprado class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionClass    
	    ^Lojafestas.Compra</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Fornecedor</name>
<environment>Lojafestas</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade telefone fax </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Fornecedor class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Lojafestas.FornecedorForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Fornecedor</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,cidade ,telefone ,fax'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self cidade printString, ',', self telefone printString, ',', self fax printString</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', cidade = ' ,self cidade printString,', telefone = ' ,self telefone printString,', fax = ' ,self fax printString</body>
</methods>

<methods>
<class-id>Lojafestas.Fornecedor</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 cidade := ''.
					 telefone := ''.
					 fax := ''</body>

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
	self telefone: (aRow at: newIndex).
	self telefone isNil ifTrue: [self telefone: ' '].
	newIndex := newIndex + 1.
	self fax: (aRow at: newIndex).
	self fax isNil ifTrue: [self fax: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Lojafestas.Fornecedor</class-id> <category>accessing</category>

<body>cidade
	^cidade</body>

<body>cidade: newcidade
	self update: 'cidade' to: newcidade.
	self changed: #cidade.
	self isChanged: true.</body>

<body>endereco
	^endereco</body>

<body>endereco: newendereco
	self update: 'endereco' to: newendereco.
	self changed: #endereco.
	self isChanged: true.</body>

<body>fax
	^fax</body>

<body>fax: newfax
	self update: 'fax' to: newfax.
	self changed: #fax.
	self isChanged: true.</body>

<body>telefone
	^telefone</body>

<body>telefone: newtelefone
	self update: 'telefone' to: newtelefone.
	self changed: #telefone.
	self isChanged: true.</body>
</methods>


<class>
<name>MultadofornecedorForm</name>
<environment>Lojafestas</environment>
<super>GREN.FineRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.MultadofornecedorForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Lojafestas.Multadofornecedor</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ItemalugadoForm</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Reservadeproduto</name>
<environment>Lojafestas</environment>
<super>GREN.ResourceReservation</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Reservadeproduto class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^false</body>

<body>hasPayment
	^false</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Lojafestas.Reservadeproduto class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Lojafestas.Cliente</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionItemClass
  ^Lojafestas.Itemreservado</body>

<body>transactionPluralName    
	    ^'Reservas de Produto'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Produto</name>
<environment>Lojafestas</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>precoDeVenda podeseralugado </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Produto class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Lojafestas.ProdutoForm</body>

<body>measureUnityClass    
	    ^Lojafestas.Unidadedemedida</body>

<body>quantificationStrategyClass
   ^MeasurableResource</body>

<body>resourceRentalClass    
	    ^Lojafestas.Alugueldeproduto</body>

<body>typeClasses  
	^List with: Lojafestas.Estadodoproduto</body>

<body>typeForms  
	^List with: Lojafestas.EstadodoprodutoForm</body>
</methods>

<methods>
<class-id>Lojafestas.Produto class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List with: 'Estadodoproduto'</body>
</methods>

<methods>
<class-id>Lojafestas.Produto class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Produto</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,precoDeVenda ,podeseralugado'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self precoDeVenda printString, ',', self podeseralugado printString</body>

<body>updateSetClause
	    ^super updateSetClause,', precoDeVenda = ' ,self precoDeVenda printString,', podeseralugado = ' ,self podeseralugado printString</body>
</methods>

<methods>
<class-id>Lojafestas.Produto</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 precoDeVenda := 0.00.
					 podeseralugado := 0</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self precoDeVenda: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self podeseralugado: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Lojafestas.Produto</class-id> <category>accessing</category>

<body>podeseralugado
	^podeseralugado</body>

<body>podeseralugado: newpodeseralugado
	self update: 'podeseralugado' to: newpodeseralugado.
	self changed: #podeseralugado.
	self isChanged: true.</body>

<body>precoDeVenda
	^precoDeVenda</body>

<body>precoDeVenda: newprecoDeVenda
	self update: 'precoDeVenda' to: newprecoDeVenda.
	self changed: #precoDeVenda.
	self isChanged: true.</body>
</methods>


<class>
<name>PedidoForm</name>
<environment>Lojafestas</environment>
<super>GREN.MultiResourceTradeForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.PedidoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Lojafestas.Pedido</body>

<body>transactionItemFormClass
	    ^Lojafestas.ItempedidoForm</body>
</methods>

<methods>
<class-id>Lojafestas.PedidoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Fornecedor'</body>

<body>resourcesTransactedLabel   
	    ^'Produto'</body>

<body>windowLabel   
	    ^'Pedido'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.PedidoForm</class-id> <category>report parameters</category>

<body>reportPendingTradesTitle
					^'Pedidos pendentes do fornecedor'</body>
</methods>


<class>
<name>ItemcompradoForm</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>VendadeprodutoForm</name>
<environment>Lojafestas</environment>
<super>GREN.MultiResourceTradeForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.VendadeprodutoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Lojafestas.Vendadeproduto</body>

<body>transactionItemFormClass
	    ^Lojafestas.ItemvendidoForm</body>
</methods>

<methods>
<class-id>Lojafestas.VendadeprodutoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>resourcesTransactedLabel   
	    ^'Produto'</body>

<body>windowLabel   
	    ^'Venda de Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.VendadeprodutoForm</class-id> <category>report parameters</category>

<body>reportDailyGainsTitle
					^'Ganhos com venda no período'</body>
</methods>


<class>
<name>UnidadedemedidaForm</name>
<environment>Lojafestas</environment>
<super>GREN.MeasureUnityForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.UnidadedemedidaForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Lojafestas.Unidadedemedida</body>

<body>objectName    
	    ^'Unidade de Medida'</body>

<body>pluralObjectName    
	    ^'Unidades de Medida'</body>
</methods>

<methods>
<class-id>Lojafestas.UnidadedemedidaForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Unidade de Medida'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ItempedidoForm</name>
<environment>Lojafestas</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Cash</name>
<environment>Lojafestas</environment>
<super>GREN.Cash</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>


<class>
<name>Pedido</name>
<environment>Lojafestas</environment>
<super>GREN.BasicPurchase</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Lojafestas</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Lojafestas.Pedido class</class-id> <category>hotspots configuration</category>

<body>hasDelivery
	^true</body>

<body>hasExecutor
	^false</body>

<body>hasPayment
	^false</body>

<body>hasQuotation
	^false</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Lojafestas.Pedido class</class-id> <category>classReferences</category>

<body>deliveryClass    
	    ^Lojafestas.Compra</body>

<body>destinationPartyClass    
	    ^Lojafestas.Fornecedor</body>

<body>resourceClass    
	    ^Lojafestas.Produto</body>

<body>transactionItemClass
  ^Lojafestas.Itempedido</body>

<body>transactionPluralName    
	    ^'Pedidos'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->




</st-source>
