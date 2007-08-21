<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 23 de Setembro de 2002 at 5:13:54 pm</time-stamp>


<name-space>
<name>Oficinaapolo</name>
<environment>Smalltalk</environment>
<private>false</private>
<imports>
			private Smalltalk.*
			private GREN.*
			</imports>
<category>Oficinaapolo</category>
</name-space>


<class>
<name>Tecnico</name>
<environment>Oficinaapolo</environment>
<super>GREN.TransactionExecutor</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Tecnico class</class-id> <category>hotspots configuration</category>

<body>receivesCommission
	^true</body>
</methods>

<methods>
<class-id>Oficinaapolo.Tecnico class</class-id> <category>classReferences</category>

<body>commissionClass
	^Oficinaapolo.Comissao</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ConsertodeaparelhoForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.OneResourceMaintNPNTForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.ConsertodeaparelhoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Oficinaapolo.Consertodeaparelho</body>
</methods>

<methods>
<class-id>Oficinaapolo.ConsertodeaparelhoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>aExecutorLabel   
	    ^'Tecnico'</body>

<body>aResourceLabel   
	    ^'Aparelho'</body>

<body>windowLabel   
	    ^'Conserto de aparelho'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.ConsertodeaparelhoForm</class-id> <category>report parameters</category>

<body>reportByExecutorTitle
					^'Listar consertos por tecnico'</body>

<body>reportByPeriodTitle
					^'Listar consertos no período'</body>

<body>reportComToPayTitle
					^'Listar comissoes a pagar'</body>

<body>reportPaidComTitle
					^'Listar comissões pagas'</body>

<body>reportPendingMaintTitle
					^'Listar consertos pendentes'</body>
</methods>


<class>
<name>TipodeaparelhoForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.TipodeaparelhoForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinaapolo.Tipodeaparelho</body>

<body>objectName    
	    ^'Tipo de Aparelho'</body>

<body>pluralObjectName    
	    ^'Tipos de Aparelho'</body>
</methods>

<methods>
<class-id>Oficinaapolo.TipodeaparelhoForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Tipo de Aparelho'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Comissao</name>
<environment>Oficinaapolo</environment>
<super>GREN.Commission</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Comissao class</class-id> <category>classReferences</category>

<body>executorClass
  ^Oficinaapolo.Tecnico</body>

<body>transactionClass
  ^Oficinaapolo.Consertodeaparelho</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>TecnicoForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.TransactionExecutorForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.TecnicoForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'minimumValue')</body>

<body>objectClass    
	    ^Oficinaapolo.Tecnico</body>

<body>objectName    
	    ^'Tecnico'</body>

<body>pluralObjectName    
	    ^'Tecnicos'</body>
</methods>

<methods>
<class-id>Oficinaapolo.TecnicoForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Tecnico'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>FabricanteForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.FabricanteForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinaapolo.Fabricante</body>

<body>objectName    
	    ^'Fabricante'</body>

<body>pluralObjectName    
	    ^'Fabricantes'</body>
</methods>

<methods>
<class-id>Oficinaapolo.FabricanteForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Fabricante'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.FabricanteForm</class-id> <category>report parameters</category>

<body>reportByDescriptionTitle
					^'Listar aparelhos por modelo'</body>
</methods>


<class>
<name>ClienteForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco telefone email cidade </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.ClienteForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#clienteSpec</body>

<body>objectClass    
	    ^Oficinaapolo.Cliente</body>

<body>objectName    
	    ^'Cliente'</body>

<body>pluralObjectName    
	    ^'Clientes'</body>
</methods>

<methods>
<class-id>Oficinaapolo.ClienteForm class</class-id> <category>interface specs</category>

<body>clienteSpec
	"UIPainter new openOnClass: self andSelector: #clienteSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 77 127 732 467 ) ) 
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
					#layout: #(#{Core.Point} 294 155 ) 
					#name: #enderecoLabel 
					#label: 'Endereco' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 191 ) 
					#name: #telefoneLabel 
					#label: 'Telefone' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 226 ) 
					#name: #emailLabel 
					#label: 'Email' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 260 ) 
					#name: #cidadeLabel 
					#label: 'Cidade' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 155 644 180 ) 
					#name: #endereco 
					#model: #endereco 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 391 191 507 216 ) 
					#name: #telefone 
					#model: #telefone 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 226 560 251 ) 
					#name: #email 
					#model: #email 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 390 260 507 285 ) 
					#name: #cidade 
					#model: #cidade 
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
<class-id>Oficinaapolo.ClienteForm</class-id> <category>aspects</category>

<body>cidade
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #cidade.
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

<body>telefone
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #telefone.
		^adaptor</body>
</methods>

<methods>
<class-id>Oficinaapolo.ClienteForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 telefone := '' asValue.
					 email := '' asValue.
					 cidade := '' asValue</body>
</methods>


<class>
<name>AparelhoForm</name>
<environment>Oficinaapolo</environment>
<super>GREN.SingleResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>fabricante listFabricante </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.AparelhoForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#aparelhoSpec</body>

<body>objectClass    
	    ^Oficinaapolo.Aparelho</body>

<body>objectName    
	    ^'Aparelho'</body>

<body>pluralObjectName    
	    ^'Aparelhos'</body>

<body>typesCanvasClass
								    ^QualificationForm1</body>

<body>typesSpec
								    ^#resType1Spec</body>
</methods>

<methods>
<class-id>Oficinaapolo.AparelhoForm class</class-id> <category>interface specs</category>

<body>aparelhoSpec
	"UIPainter new openOnClass: self andSelector: #aparelhoSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 63 175 791 536 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 192 ) 
					#label: #statusLabel ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 488 76 588 103 ) 
					#name: #storageBt 
					#model: #storageBt 
					#helpText: 'Details about storage' 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #storageBt 
						#defaultString: 'Storage...' ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 12 58 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 80 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 116 ) 
					#label: #descriptionLabel ) 
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
					#layout: #(#{Graphics.Rectangle} 295 151 742 314 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 354 194 ) 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option1Label 
					#select: #available ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 465 194 ) 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option2Label 
					#select: #nonAvailable ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 276 ) 
					#name: #costLabel 
					#flags: 16 
					#label: #costLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 397 276 480 302 ) 
					#name: #costField 
					#flags: 24 
					#model: #cost 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 503 276 ) 
					#name: #salePriceLabel 
					#flags: 16 
					#label: #salePriceLabel ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 600 276 683 302 ) 
					#name: #salePriceField 
					#flags: 24 
					#model: #salePrice 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 231 ) 
					#name: #fabricanteLabel 
					#label: 'Fabricante' ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 377 231 547 256 ) 
					#name: #fabricante 
					#model: #fabricante 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedFabricante ) 
					#objectListMethod: #listFabricante ) ) ) )</body>

<body>descriptionLabel 
			
			^'Modelo'</body>

<body>idCodeLabel 
			
			^'Numero'</body>

<body>windowLabel   
	    ^'Aparelho'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.AparelhoForm</class-id> <category>aspects</category>

<body>fabricante
	^fabricante</body>

<body>fabricante: newFabricante
		self fabricante value: newFabricante</body>

<body>listFabricante
	^listFabricante</body>

<body>listFabricante: newListFabricante
	    listFabricante:= newListFabricante</body>
</methods>

<methods>
<class-id>Oficinaapolo.AparelhoForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 fabricante := 0 asValue.
										listFabricante := List new. Fabricante loadAll: listFabricante</body>
</methods>

<methods>
<class-id>Oficinaapolo.AparelhoForm</class-id> <category>changed messages</category>

<body>changedFabricante  
			    | listTemp |
                      self  fabricante value isNil 
			    ifFalse: [listTemp := List new.
			    self aStaticObject value fabricante: ((Fabricante loadAllLike: self  fabricante value to: listTemp) at: 1) idCode].
				super changedInputData</body>

<body>refreshForm  
			super refreshForm. 
						self  aStaticObject value fabricante &gt;= 1 
						ifTrue: [self fabricante: ( self objectWithIdCode: self aStaticObject value fabricante in: self listFabricante) description] ifFalse: [self fabricante: ' '].</body>
</methods>


<class>
<name>Consertodeaparelho</name>
<environment>Oficinaapolo</environment>
<super>GREN.ResourceMaintenance</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Consertodeaparelho class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^true</body>

<body>hasParts
	^false</body>

<body>hasPayment
	^false</body>

<body>hasQuotation
	^false</body>

<body>hasSourceParty
	^false</body>

<body>hasTasks
	^false</body>

<body>isItemized
	^false</body>
</methods>

<methods>
<class-id>Oficinaapolo.Consertodeaparelho class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Oficinaapolo.Cliente</body>

<body>executorClass
  ^Oficinaapolo.Tecnico</body>

<body>resourceClass    
	    ^Oficinaapolo.Aparelho</body>

<body>transactionPluralName    
	    ^'Consertos de aparelho'</body>

<body>transQuantificationStrategyClass
   ^SingleResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Cliente</name>
<environment>Oficinaapolo</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco telefone email cidade </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Cliente class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinaapolo.ClienteForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Cliente</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,telefone ,email ,cidade'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self telefone printString, ',', self email printString, ',', self cidade printString</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', telefone = ' ,self telefone printString,', email = ' ,self email printString,', cidade = ' ,self cidade printString</body>
</methods>

<methods>
<class-id>Oficinaapolo.Cliente</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 telefone := ''.
					 email := ''.
					 cidade := ''</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self endereco: (aRow at: newIndex).
	self endereco isNil ifTrue: [self endereco: ' '].
	newIndex := newIndex + 1.
	self telefone: (aRow at: newIndex).
	self telefone isNil ifTrue: [self telefone: ' '].
	newIndex := newIndex + 1.
	self email: (aRow at: newIndex).
	self email isNil ifTrue: [self email: ' '].
	newIndex := newIndex + 1.
	self cidade: (aRow at: newIndex).
	self cidade isNil ifTrue: [self cidade: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Oficinaapolo.Cliente</class-id> <category>accessing</category>

<body>cidade
	^cidade</body>

<body>cidade: newcidade
	self update: 'cidade' to: newcidade.
	self changed: #cidade.
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

<body>telefone
	^telefone</body>

<body>telefone: newtelefone
	self update: 'telefone' to: newtelefone.
	self changed: #telefone.
	self isChanged: true.</body>
</methods>


<class>
<name>Aparelho</name>
<environment>Oficinaapolo</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>fabricante </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Aparelho class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinaapolo.AparelhoForm</body>

<body>quantificationStrategyClass
   ^SingleResource</body>

<body>typeClasses  
	^List with: Oficinaapolo.Tipodeaparelho</body>

<body>typeForms  
	^List with: Oficinaapolo.TipodeaparelhoForm</body>
</methods>

<methods>
<class-id>Oficinaapolo.Aparelho class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List with: 'Tipodeaparelho'</body>
</methods>

<methods>
<class-id>Oficinaapolo.Aparelho class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Aparelho</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,fabricante'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self fabricante printString</body>

<body>updateSetClause
	    ^super updateSetClause,', fabricante = ' ,self fabricante printString</body>
</methods>

<methods>
<class-id>Oficinaapolo.Aparelho</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 fabricante := 0</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self fabricante: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Oficinaapolo.Aparelho</class-id> <category>accessing</category>

<body>fabricante
	^fabricante</body>

<body>fabricante: newfabricante
	self update: 'fabricante' to: newfabricante.
	self changed: #fabricante.
	self isChanged: true.</body>
</methods>


<class>
<name>OficinaapoloMainWindow</name>
<environment>Oficinaapolo</environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.OficinaapoloMainWindow class</class-id> <category>resources</category>

<body>mainMenu
	"MenuEditor new openOnClass: self andSelector: #mainMenu"

	&lt;resource: #menu&gt;
	^#(#{UI.Menu} #(
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Cadastros' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Tipo de Aparelho' 
							#value: #tipodeaparelho ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Aparelho' 
							#value: #aparelho ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'C&amp;liente' 
							#value: #cliente ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Técnico' 
							#value: #tecnico ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Fabricante' 
							#value: #fabricante ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Co&amp;nserto de Aparelho' 
							#value: #consertodeaparelho ) ) #(5 1 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Relatórios' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 'Relatório de consertos pendentes' 
							#value: #pendingList3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Comissões pagas aos técnicos' 
							#value: #listPaidCommissions4 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Consertos efetuados por técnico' 
							#value: #listByExecutor4 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Comissões a pagar aos técnicos' 
							#value: #listCommissionsToPay4 ) ) #(4 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Finalizar' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Sim' 
							#value: #exit ) ) #(1 ) nil ) ) ) #(3 ) nil ) decodeAsLiteralArray</body>
</methods>

<methods>
<class-id>Oficinaapolo.OficinaapoloMainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'Oficina Apolo'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.OficinaapoloMainWindow</class-id> <category>resources</category>

<body>aparelho
^Oficinaapolo.AparelhoForm openWithSpec: #aparelhoSpec</body>

<body>cliente
^Oficinaapolo.ClienteForm openWithSpec: #clienteSpec</body>

<body>consertodeaparelho
^Oficinaapolo.ConsertodeaparelhoForm openWithSpec: #oneResBasicMaintNTNPSpec</body>

<body>fabricante
^Oficinaapolo.FabricanteForm openWithSpec: #windowSpec</body>

<body>listByDescription1
					^FabricanteForm new listByDescription</body>

<body>listByExecutor4
					^ConsertodeaparelhoForm new listByExecutor</body>

<body>listByPeriod3
					^ConsertodeaparelhoForm new listByPeriod</body>

<body>listCommissionsToPay4
					^ConsertodeaparelhoForm new listCommissionsToPay</body>

<body>listPaidCommissions4
					^ConsertodeaparelhoForm new listPaidCommissions</body>

<body>pendingList3
					^ConsertodeaparelhoForm new pendingList</body>

<body>tecnico
^Oficinaapolo.TecnicoForm openWithSpec: #transExecutorSpec</body>

<body>tipodeaparelho
^Oficinaapolo.TipodeaparelhoForm openWithSpec: #windowSpec</body>
</methods>

<methods>
<class-id>Oficinaapolo.OficinaapoloMainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='Oficinaapolo'.
	ReportHeader := '  O  F  I  C  I  N  A     A  P  O  L  O'.
	Language := #portuguese.
	super initialize.</body>
</methods>


<class>
<name>Fabricante</name>
<environment>Oficinaapolo</environment>
<super>GREN.StaticObject</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>


<class>
<name>Tipodeaparelho</name>
<environment>Oficinaapolo</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinaapolo</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinaapolo.Tipodeaparelho class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Oficinaapolo.Tipodeaparelho class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->




</st-source>
