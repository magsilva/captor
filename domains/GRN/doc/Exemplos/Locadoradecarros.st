<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 23 de Setembro de 2002 at 1:28:31 pm</time-stamp>


<name-space>
<name>Locadoradecarros</name>
<environment>Smalltalk</environment>
<private>false</private>
<imports>
			private Smalltalk.*
			private GREN.*
			</imports>
<category>Locadoradecarros</category>
</name-space>


<class>
<name>Tipodeservico</name>
<environment>Locadoradecarros</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>valor </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Tipodeservico class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Locadoradecarros.TipodeservicoForm</body>

<body>measureUnityClass    
	    ^Locadoradecarros.Unidadedemedida</body>

<body>quantificationStrategyClass
   ^MeasurableResource</body>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Locadoradecarros.Tipodeservico class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<methods>
<class-id>Locadoradecarros.Tipodeservico class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Tipodeservico</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,valor'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self valor printString</body>

<body>updateSetClause
	    ^super updateSetClause,', valor = ' ,self valor printString</body>
</methods>

<methods>
<class-id>Locadoradecarros.Tipodeservico</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 valor := 0.00</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self valor: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Tipodeservico</class-id> <category>accessing</category>

<body>valor
	^valor</body>

<body>valor: newvalor
	self update: 'valor' to: newvalor.
	self changed: #valor.
	self isChanged: true.</body>
</methods>


<class>
<name>Reservadecarro</name>
<environment>Locadoradecarros</environment>
<super>GREN.ResourceReservation</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>horaRetirada horaPrevistaDevolucao dataCancelamento nroCartaoCredito </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Reservadecarro class</class-id> <category>hotspots configuration</category>

<body>generateInstanceCode    
	    ^ true</body>

<body>hasExecutor
	^false</body>

<body>hasPayment
	^false</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^false</body>
</methods>

<methods>
<class-id>Locadoradecarros.Reservadecarro class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Locadoradecarros.Cliente</body>

<body>resourceClass    
	    ^Locadoradecarros.Categoriadecarro</body>

<body>transactionPluralName    
	    ^'Reservas de Carros'</body>

<body>transQuantificationStrategyClass
   ^InstantiableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Reservadecarro</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,horaRetirada ,horaPrevistaDevolucao ,dataCancelamento ,nroCartaoCredito'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self horaRetirada printString, ',', self horaPrevistaDevolucao printString, ',', self dataCancelamento printForSaving, ',', self nroCartaoCredito printString</body>

<body>updateSetClause
	    ^super updateSetClause,', horaRetirada = ' ,self horaRetirada printString,', horaPrevistaDevolucao = ' ,self horaPrevistaDevolucao printString,', dataCancelamento = ' ,self dataCancelamento printForSaving,', nroCartaoCredito = ' ,self nroCartaoCredito printString</body>
</methods>

<methods>
<class-id>Locadoradecarros.Reservadecarro</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 horaRetirada := ''.
					 horaPrevistaDevolucao := ''.
					 dataCancelamento := Date today.
					 nroCartaoCredito := 0.00</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self horaRetirada: (aRow at: newIndex).
	self horaRetirada isNil ifTrue: [self horaRetirada: ' '].
	newIndex := newIndex + 1.
	self horaPrevistaDevolucao: (aRow at: newIndex).
	self horaPrevistaDevolucao isNil ifTrue: [self horaPrevistaDevolucao: ' '].
	newIndex := newIndex + 1.
	self dataCancelamento: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self nroCartaoCredito: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Reservadecarro</class-id> <category>accessing</category>

<body>dataCancelamento
	^dataCancelamento</body>

<body>dataCancelamento: newdataCancelamento
	self update: 'dataCancelamento' to: newdataCancelamento.
	self changed: #dataCancelamento.
	self isChanged: true.</body>

<body>horaPrevistaDevolucao
	^horaPrevistaDevolucao</body>

<body>horaPrevistaDevolucao: newhoraPrevistaDevolucao
	self update: 'horaPrevistaDevolucao' to: newhoraPrevistaDevolucao.
	self changed: #horaPrevistaDevolucao.
	self isChanged: true.</body>

<body>horaRetirada
	^horaRetirada</body>

<body>horaRetirada: newhoraRetirada
	self update: 'horaRetirada' to: newhoraRetirada.
	self changed: #horaRetirada.
	self isChanged: true.</body>

<body>nroCartaoCredito
	^nroCartaoCredito</body>

<body>nroCartaoCredito: newnroCartaoCredito
	self update: 'nroCartaoCredito' to: newnroCartaoCredito.
	self changed: #nroCartaoCredito.
	self isChanged: true.</body>
</methods>


<class>
<name>VendadeservicoForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.MultiResourceTradeForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.VendadeservicoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Locadoradecarros.Vendadeservico</body>

<body>transactionItemFormClass
	    ^Locadoradecarros.ItemdavendaForm</body>
</methods>

<methods>
<class-id>Locadoradecarros.VendadeservicoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>resourcesTransactedLabel   
	    ^'Categoriadecarro'</body>

<body>windowLabel   
	    ^'Venda de Serviço'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>LocacaodecarroForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.InstantiableResourceRentalForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>horaRetirada horaPrevistaDevolucao quilometragemRetirada vlrCombustivel horaDevolucao quilometragemDevolucao tipoPagamento nroDocPagamento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.LocacaodecarroForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Locadoradecarros.Locacaodecarro</body>
</methods>

<methods>
<class-id>Locadoradecarros.LocacaodecarroForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>aResourceLabel   
	    ^'Categoria de carro'</body>

<body>dateLabel 			
			^'Data de retirada'</body>

<body>finishingDateLabel 
			
			^'Data prevista devolucao'</body>

<body>locacaodecarroSpec
	"UIPainter new openOnClass: self andSelector: #locacaodecarroSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 133 23 800 640 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 14 287 ) 
					#label: #instanceCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 212 171 ) 
					#label: #finishingDateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 441 170 ) 
					#name: #returnDateLbl 
					#flags: 16 
					#label: #returnDateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 196 64 ) 
					#name: #reservationNumberLabel 
					#flags: 16 
					#label: #reservationNumberLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 17 253 ) 
					#label: #aResourceLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 101 ) 
					#name: #sourcePartyLabel 
					#label: #aSourcePartyLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 171 ) 
					#label: #dateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 16 210 ) 
					#label: #observationLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 135 ) 
					#label: #aDestinationPartyLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 65 ) 
					#label: #numberLabel ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 33 2 483 51 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 383 209 ) 
					#name: #executorLabel 
					#label: #aExecutorLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 508 5 ) 
					#label: #statusLabel ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 564 6 ) 
					#name: #option1RadioBt 
					#flags: 32 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option1Label 
					#select: #option1 ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 564 29 ) 
					#name: #option2RadioBt 
					#flags: 32 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option2Label 
					#select: #option2 ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 564 53 ) 
					#name: #option3RadioBt 
					#flags: 48 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option3Label 
					#select: #option3 ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 488 1 635 51 ) ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 448 209 607 234 ) 
					#name: #executor 
					#model: #aExecutor 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#isReadOnly: false 
					#objectListMethod: #allExecutors ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 15 464 640 553 ) 
					#name: #totalsCanvas 
					#clientKey: #totalsCanvas ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 420 60 542 85 ) 
					#name: #reservationBt 
					#flags: 24 
					#model: #searchReservation 
					#label: #reservationBtLabel 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 366 132 408 157 ) 
					#name: #destinationPartyFormOpenBt 
					#model: #destinationPartyFormOpen 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#focusOutSelector: #refreshAllDestinationParties ) 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #moreBt 
						#defaultString: 'More...' ) 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 336 251 378 276 ) 
					#name: #resourceFormOpenBt 
					#model: #resourceFormOpen 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#focusOutSelector: #refreshAllResources ) 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #moreBt 
						#defaultString: 'More...' ) 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 361 563 431 604 ) 
					#name: #paymentBt 
					#flags: 24 
					#model: #payment 
					#label: #paymentLabel 
					#defaultable: true ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 412 110 656 164 ) 
					#name: #GroupBox1 ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 482 109 ) 
					#name: #Label1 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #printConfirmation 
						#defaultString: '' ) ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 420 132 524 155 ) 
					#name: #ActionButton2 
					#model: #rentalConfBt 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #rentalConf 
						#defaultString: nil ) 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 534 132 646 155 ) 
					#name: #ActionButton3 
					#model: #returnConfBt 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #returnConf 
						#defaultString: nil ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 16 324 ) 
					#name: #horaretiradaLabel 
					#label: 'Hora de retirada' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 207 321 ) 
					#name: #horaprevistadevolucaoLabel 
					#label: 'Hora prevista dev.' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 15 353 ) 
					#name: #quilometragemretiradaLabel 
					#label: 'Km retirada' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 18 389 ) 
					#name: #vlrcombustivelLabel 
					#label: 'Vlr. combustível' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 410 322 ) 
					#name: #horadevolucaoLabel 
					#label: 'Hora de devolucao' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 322 353 ) 
					#name: #quilometragemdevolucaoLabel 
					#label: 'Km devolucao' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 13 422 ) 
					#name: #tipopagamentoLabel 
					#label: 'Tipo de pagamento' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 321 423 ) 
					#name: #nrodocpagamentoLabel 
					#label: 'Nro. doc. pagamento' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 125 61 188 87 ) 
					#name: #numberField 
					#flags: 40 
					#model: #number 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 312 61 412 87 ) 
					#name: #reservationNumberField 
					#flags: 56 
					#model: #reservationNumber 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 124 100 360 125 ) 
					#name: #aSourcePartyBox 
					#flags: 40 
					#model: #aSourceParty 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#isReadOnly: false 
					#objectListMethod: #allSourceParties ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 124 131 360 156 ) 
					#name: #aDestinationPartyBox 
					#flags: 40 
					#model: #aDestinationParty 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#objectListMethod: #allDestinationParties ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 124 165 202 191 ) 
					#name: #dateField 
					#flags: 40 
					#model: #date 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 338 167 416 193 ) 
					#name: #finishingDateField 
					#flags: 40 
					#model: #finishingDate 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData 
						#requestFocusOutSelector: 
						#validDate: ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 544 165 622 191 ) 
					#name: #returnDateField 
					#flags: 56 
					#model: #returnDate 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedReturnDate 
						#requestFocusOutSelector: 
						#validDate: ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 123 208 369 234 ) 
					#name: #observationField 
					#flags: 40 
					#model: #observation 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 123 250 324 275 ) 
					#name: #aResourceBox 
					#flags: 40 
					#model: #aResource 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #checkResourceAvailability ) 
					#objectListMethod: #allResources ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 121 285 189 313 ) 
					#name: #instanceCodeField 
					#flags: 40 
					#model: #instanceCode 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInstanceCode ) 
					#type: #string ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 120 320 190 346 ) 
					#name: #horaRetirada 
					#model: #horaRetirada 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 324 320 391 345 ) 
					#name: #horaPrevistaDevolucao 
					#model: #horaPrevistaDevolucao 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 514 320 580 346 ) 
					#name: #horaDevolucao 
					#model: #horaDevolucao 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 119 352 292 379 ) 
					#name: #quilometragemRetirada 
					#model: #quilometragemRetirada 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 454 354 624 379 ) 
					#name: #quilometragemDevolucao 
					#model: #quilometragemDevolucao 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 119 386 191 412 ) 
					#name: #vlrCombustivel 
					#model: #vlrCombustivel 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 117 420 287 445 ) 
					#name: #tipoPagamento 
					#model: #tipoPagamento 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 451 416 621 441 ) 
					#name: #nroDocPagamento 
					#model: #nroDocPagamento 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 536 559 612 599 ) 
					#name: #saleBt 
					#model: #sale 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #saleBt 
						#defaultString: 'Sale...' ) 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 476 254 525 279 ) 
					#name: #saleBt 
					#model: #sale 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #saleBt 
						#defaultString: 'Sale...' ) 
					#defaultable: true ) ) ) )</body>

<body>numberLabel 		
			^'Numero da locação'</body>

<body>returnDateLabel 			
			^'Data de devolução'</body>

<body>windowLabel   
	    ^'Locação de Carro'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.LocacaodecarroForm</class-id> <category>aspects</category>

<body>horaDevolucao
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #horaDevolucao.
	^adaptor</body>

<body>horaPrevistaDevolucao
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #horaPrevistaDevolucao.
	^adaptor</body>

<body>horaRetirada
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #horaRetirada.
	^adaptor</body>

<body>nroDocPagamento
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #nroDocPagamento.
	^adaptor</body>

<body>quilometragemDevolucao
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #quilometragemDevolucao.
	^adaptor</body>

<body>quilometragemRetirada
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #quilometragemRetirada.
	^adaptor</body>

<body>tipoPagamento
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #tipoPagamento.
	^adaptor</body>

<body>vlrCombustivel
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #vlrCombustivel.
	^adaptor</body>
</methods>

<methods>
<class-id>Locadoradecarros.LocacaodecarroForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 horaRetirada := '' asValue.
					 horaPrevistaDevolucao := '' asValue.
					 quilometragemRetirada := 0.00 asValue.
					 vlrCombustivel := 0.00 asValue.
					 horaDevolucao := '' asValue.
					 quilometragemDevolucao := 0.00 asValue.
					 tipoPagamento := '' asValue.
					 nroDocPagamento := 0 asValue</body>
</methods>

<methods>
<class-id>Locadoradecarros.LocacaodecarroForm</class-id> <category>report parameters</category>

<body>reportByPeriodTitle
					^'Listagem de carros alugados por período'</body>

<body>summarizeBySPTitle
					^'Histórico de aluguéis por cliente'</body>
</methods>


<class>
<name>ReservadecarroForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.OneResourceReservationForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>horaRetirada horaPrevistaDevolucao dataCancelamento nroCartaoCredito </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.ReservadecarroForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Locadoradecarros.Reservadecarro</body>
</methods>

<methods>
<class-id>Locadoradecarros.ReservadecarroForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>aResourceLabel   
	    ^'Categoria de carro'</body>

<body>dateLabel 			
			^'Data de retirada'</body>

<body>numberLabel 			
			^'Número da reserva'</body>

<body>reservadecarroSpec
	"UIPainter new openOnClass: self andSelector: #reservadecarroSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 363 254 1024 768 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 200 182 ) 
					#label: #beginDateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 368 181 ) 
					#name: #endDateLbl 
					#label: #endDateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 257 ) 
					#label: #aResourceLabel ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 324 256 366 281 ) 
					#name: #resourceFormOpenBt 
					#model: #resourceFormOpen 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#focusOutSelector: #refreshAllResources ) 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #moreBt 
						#defaultString: 'More...' ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 114 ) 
					#name: #sourcePartyLabel 
					#label: #aSourcePartyLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 184 ) 
					#label: #dateLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 222 ) 
					#label: #observationLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 148 ) 
					#label: #aDestinationPartyLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 76 ) 
					#label: #numberLabel ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 42 15 492 64 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 369 145 411 170 ) 
					#name: #destinationPartyFormOpenBt 
					#model: #destinationPartyFormOpen 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#focusOutSelector: #refreshAllDestinationParties ) 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #moreBt 
						#defaultString: 'More...' ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 379 222 ) 
					#name: #executorLabel 
					#label: #aExecutorLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 517 18 ) 
					#label: #statusLabel ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 573 19 ) 
					#name: #option1RadioBt 
					#flags: 32 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option1Label 
					#select: #option1 ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 573 42 ) 
					#name: #option2RadioBt 
					#flags: 32 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option2Label 
					#select: #option2 ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 573 66 ) 
					#name: #option3RadioBt 
					#flags: 48 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option3Label 
					#select: #option3 ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 497 14 644 64 ) ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 576 303 646 344 ) 
					#name: #paymentBt 
					#flags: 24 
					#model: #payment 
					#label: #paymentLabel 
					#defaultable: true ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 447 221 606 246 ) 
					#name: #executor 
					#model: #aExecutor 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#isReadOnly: false 
					#objectListMethod: #allExecutors ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 25 416 650 505 ) 
					#name: #totalsCanvas 
					#clientKey: #totalsCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 289 ) 
					#name: #horaretiradaLabel 
					#label: 'Hora de retirada' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 319 ) 
					#name: #horaprevistadevolucaoLabel 
					#label: 'Hora prevista dev.' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 349 ) 
					#name: #datacancelamentoLabel 
					#label: 'Data cancelam.' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 379 ) 
					#name: #nrocartaocreditoLabel 
					#label: 'Nro cartão crédito' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 119 73 182 99 ) 
					#name: #numberField 
					#flags: 40 
					#model: #number 
					#alignment: #right 
					#type: #number ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 118 112 354 137 ) 
					#name: #aSourcePartyBox 
					#flags: 40 
					#model: #aSourceParty 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#isReadOnly: false 
					#objectListMethod: #allSourceParties ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 118 143 354 168 ) 
					#name: #aDestinationPartyBox 
					#flags: 40 
					#model: #aDestinationParty 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#objectListMethod: #allDestinationParties ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 119 180 197 206 ) 
					#name: #dateField 
					#flags: 40 
					#model: #date 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 277 179 355 205 ) 
					#name: #beginDateField 
					#flags: 40 
					#model: #beginDate 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData 
						#requestFocusOutSelector: 
						#validDate: ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 458 177 536 203 ) 
					#name: #endDateField 
					#model: #endDate 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#requestFocusOutSelector: 
						#validDate: ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 119 220 365 246 ) 
					#name: #observationField 
					#flags: 40 
					#model: #observation 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 118 255 319 280 ) 
					#name: #aResourceBox 
					#flags: 40 
					#model: #aResource 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#focusOutSelector: #checkResourceAvailability 
						#valueChangeSelector: #changedInputData ) 
					#objectListMethod: #allResources ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 118 289 288 314 ) 
					#name: #horaRetirada 
					#model: #horaRetirada 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 118 319 288 344 ) 
					#name: #horaPrevistaDevolucao 
					#model: #horaPrevistaDevolucao 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 118 349 288 374 ) 
					#name: #dataCancelamento 
					#model: #dataCancelamento 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #date 
					#formatString: 'd-mm-yy' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 118 379 288 404 ) 
					#name: #nroCartaoCredito 
					#model: #nroCartaoCredito 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0' ) ) ) )</body>

<body>windowLabel   
	    ^'Reserva de Carro'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.ReservadecarroForm</class-id> <category>aspects</category>

<body>dataCancelamento
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #dataCancelamento.
	^adaptor</body>

<body>horaPrevistaDevolucao
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #horaPrevistaDevolucao.
	^adaptor</body>

<body>horaRetirada
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #horaRetirada.
	^adaptor</body>

<body>nroCartaoCredito
	| adaptor |
	adaptor := AspectAdaptor subjectChannel: self aTransaction.
	adaptor forAspect: #nroCartaoCredito.
	^adaptor</body>
</methods>

<methods>
<class-id>Locadoradecarros.ReservadecarroForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 horaRetirada := '' asValue.
					 horaPrevistaDevolucao := '' asValue.
					 dataCancelamento := Date today asValue.
					 nroCartaoCredito := 0.00 asValue</body>
</methods>

<methods>
<class-id>Locadoradecarros.ReservadecarroForm</class-id> <category>report parameters</category>

<body>reportByPeriodTitle
					^'Listagem das reservas efetuadas por período'</body>
</methods>


<class>
<name>CarroForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.ResourceInstanceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>fabricante marca modelo ano </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.CarroForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#carroSpec</body>
</methods>

<methods>
<class-id>Locadoradecarros.CarroForm class</class-id> <category>interface specs</category>

<body>carroSpec
	"UIPainter new openOnClass: self andSelector: #carroSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#properties: #(#{UI.PropertyListDictionary} ) 
			#label: #resourceInstanceWindowLabel 
			#min: #(#{Core.Point} 296 220 ) 
			#max: #(#{Core.Point} 296 323 ) 
			#bounds: #(#{Graphics.Rectangle} 512 384 808 707 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 28 27 ) 
					#label: #codeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 28 69 ) 
					#name: #allocationLabel 
					#label: #allocationLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 29 113 ) 
					#label: #statusLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 144 ) 
					#name: #fabricanteLabel 
					#label: 'Fabricante' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 174 ) 
					#name: #marcaLabel 
					#label: 'Marca' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 204 ) 
					#name: #modeloLabel 
					#label: 'Modelo' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 24 234 ) 
					#name: #anoLabel 
					#label: 'Ano' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 107 23 166 48 ) 
					#name: #codeField 
					#model: #code 
					#type: #string ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 106 68 206 93 ) 
					#name: #allocationField 
					#model: #allocation ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 95 113 ) 
					#model: #status 
					#label: #option1Label 
					#select: #available ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 191 113 ) 
					#model: #status 
					#label: #option2Label 
					#select: #nonAvailable ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 104 144 274 169 ) 
					#name: #fabricante 
					#model: #fabricante 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 104 174 274 199 ) 
					#name: #marca 
					#model: #marca 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 104 204 274 229 ) 
					#name: #modelo 
					#model: #modelo 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 104 234 172 260 ) 
					#name: #ano 
					#model: #ano 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 57 277 106 302 ) 
					#model: #accept 
					#label: 'Ok' 
					#defaultable: true ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 180 274 229 299 ) 
					#model: #cancel 
					#label: 'Cancel' 
					#defaultable: true ) ) ) )</body>

<body>codeLabel 
			
			^'Placa'</body>

<body>resourceIdCodeLabel 
			
			^'Numero'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.CarroForm</class-id> <category>private</category>

<body>assignVariables
	super assignVariables.
	
	self aResourceInstance fabricante: fabricante value.
	self aResourceInstance marca: marca value.
	self aResourceInstance modelo: modelo value.
	self aResourceInstance ano: ano value.</body>
</methods>

<methods>
<class-id>Locadoradecarros.CarroForm</class-id> <category>initialize-release</category>

<body>initializeWithInstance
	super initializeWithInstance.
	
	fabricante := self aResourceInstance fabricante asValue.
	marca := self aResourceInstance marca asValue.
	modelo := self aResourceInstance modelo asValue.
	ano := self aResourceInstance ano asValue.</body>
</methods>

<methods>
<class-id>Locadoradecarros.CarroForm</class-id> <category>aspects</category>

<body>ano
	^ano.</body>

<body>ano: newano
	ano := newano.</body>

<body>fabricante
	^fabricante.</body>

<body>fabricante: newfabricante
	fabricante := newfabricante.</body>

<body>marca
	^marca.</body>

<body>marca: newmarca
	marca := newmarca.</body>

<body>modelo
	^modelo.</body>

<body>modelo: newmodelo
	modelo := newmodelo.</body>
</methods>


<class>
<name>CategoriadecarroForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.InstantiableResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>valorDiaria valorSemanal valorMensal nroCarros </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.CategoriadecarroForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#categoriadecarroSpec</body>

<body>objectClass    
	    ^Locadoradecarros.Categoriadecarro</body>

<body>objectName    
	    ^'Categoria de carro'</body>

<body>pluralObjectName    
	    ^'Categoria de carros'</body>

<body>resourceInstanceFormClass
	    ^Locadoradecarros.CarroForm</body>

<body>typesCanvasClass
								    ^QualificationForm0</body>

<body>typesSpec
								    ^#resType0Spec</body>
</methods>

<methods>
<class-id>Locadoradecarros.CategoriadecarroForm class</class-id> <category>interface specs</category>

<body>categoriadecarroSpec
	"UIPainter new openOnClass: self andSelector: #categoriadecarroSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 262 90 1008 581 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 301 215 ) 
					#label: #instancesLabel ) 
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
					#layout: #(#{Graphics.Rectangle} 295 153 745 319 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 12 58 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 80 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 116 ) 
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
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 383 ) 
					#name: #costLabel 
					#flags: 16 
					#label: #costLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 497 383 ) 
					#name: #salePriceLabel 
					#flags: 16 
					#label: #salePriceLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 410 ) 
					#name: #valordiariaLabel 
					#label: 'Valor da diária' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 440 ) 
					#name: #valorsemanalLabel 
					#label: 'Valor semanal' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 497 413 ) 
					#name: #valormensalLabel 
					#label: 'Valor mensal' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 501 443 ) 
					#name: #nrocarrosLabel 
					#label: 'Nro. de carros' ) 
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
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 378 382 461 408 ) 
					#name: #costField 
					#flags: 24 
					#model: #cost 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 594 383 679 408 ) 
					#name: #salePriceField 
					#flags: 24 
					#model: #salePrice 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 378 410 461 435 ) 
					#name: #valorDiaria 
					#model: #valorDiaria 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 593 412 680 437 ) 
					#name: #valorMensal 
					#model: #valorMensal 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 377 440 463 466 ) 
					#name: #valorSemanal 
					#model: #valorSemanal 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 593 442 683 468 ) 
					#name: #nroCarros 
					#model: #nroCarros 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number ) ) ) )</body>

<body>windowLabel   
	    ^'Categoria de carro'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.CategoriadecarroForm</class-id> <category>aspects</category>

<body>nroCarros
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #nroCarros.
		^adaptor</body>

<body>valorDiaria
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #valorDiaria.
		^adaptor</body>

<body>valorMensal
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #valorMensal.
		^adaptor</body>

<body>valorSemanal
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #valorSemanal.
		^adaptor</body>
</methods>

<methods>
<class-id>Locadoradecarros.CategoriadecarroForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 valorDiaria := 0.00 asValue.
					 valorSemanal := 0.00 asValue.
					 valorMensal := 0.00 asValue.
					 nroCarros := 0 asValue</body>
</methods>


<class>
<name>Unidadedemedida</name>
<environment>Locadoradecarros</environment>
<super>GREN.MeasureUnity</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>


<class>
<name>Locacaodecarro</name>
<environment>Locadoradecarros</environment>
<super>GREN.ResourceRental</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>horaRetirada horaPrevistaDevolucao quilometragemRetirada vlrCombustivel horaDevolucao quilometragemDevolucao tipoPagamento nroDocPagamento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Locacaodecarro class</class-id> <category>hotspots configuration</category>

<body>generateInstanceCode    
	    ^ true</body>

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
	^false</body>
</methods>

<methods>
<class-id>Locadoradecarros.Locacaodecarro class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Locadoradecarros.Cliente</body>

<body>fineRateClass    
	    ^GREN.FineRate</body>

<body>reservationClass    
	    ^Locadoradecarros.Reservadecarro</body>

<body>resourceClass    
	    ^Locadoradecarros.Categoriadecarro</body>

<body>tradeClass    
	    ^Locadoradecarros.Vendadeservico</body>

<body>transactionPluralName    
	    ^'Locacoes de Carros'</body>

<body>transQuantificationStrategyClass
   ^InstantiableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Locacaodecarro</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,horaRetirada ,horaPrevistaDevolucao ,quilometragemRetirada ,vlrCombustivel ,horaDevolucao ,quilometragemDevolucao ,tipoPagamento ,nroDocPagamento'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self horaRetirada printString, ',', self horaPrevistaDevolucao printString, ',', self quilometragemRetirada printString, ',', self vlrCombustivel printString, ',', self horaDevolucao printString, ',', self quilometragemDevolucao printString, ',', self tipoPagamento printString, ',', self nroDocPagamento printString</body>

<body>updateSetClause
	    ^super updateSetClause,', horaRetirada = ' ,self horaRetirada printString,', horaPrevistaDevolucao = ' ,self horaPrevistaDevolucao printString,', quilometragemRetirada = ' ,self quilometragemRetirada printString,', vlrCombustivel = ' ,self vlrCombustivel printString,', horaDevolucao = ' ,self horaDevolucao printString,', quilometragemDevolucao = ' ,self quilometragemDevolucao printString,', tipoPagamento = ' ,self tipoPagamento printString,', nroDocPagamento = ' ,self nroDocPagamento printString</body>
</methods>

<methods>
<class-id>Locadoradecarros.Locacaodecarro</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 horaRetirada := ''.
					 horaPrevistaDevolucao := ''.
					 quilometragemRetirada := 0.00.
					 vlrCombustivel := 0.00.
					 horaDevolucao := ''.
					 quilometragemDevolucao := 0.00.
					 tipoPagamento := ''.
					 nroDocPagamento := 0</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self horaRetirada: (aRow at: newIndex).
	self horaRetirada isNil ifTrue: [self horaRetirada: ' '].
	newIndex := newIndex + 1.
	self horaPrevistaDevolucao: (aRow at: newIndex).
	self horaPrevistaDevolucao isNil ifTrue: [self horaPrevistaDevolucao: ' '].
	newIndex := newIndex + 1.
	self quilometragemRetirada: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self vlrCombustivel: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self horaDevolucao: (aRow at: newIndex).
	self horaDevolucao isNil ifTrue: [self horaDevolucao: ' '].
	newIndex := newIndex + 1.
	self quilometragemDevolucao: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self tipoPagamento: (aRow at: newIndex).
	self tipoPagamento isNil ifTrue: [self tipoPagamento: ' '].
	newIndex := newIndex + 1.
	self nroDocPagamento: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Locacaodecarro</class-id> <category>accessing</category>

<body>horaDevolucao
	^horaDevolucao</body>

<body>horaDevolucao: newhoraDevolucao
	self update: 'horaDevolucao' to: newhoraDevolucao.
	self changed: #horaDevolucao.
	self isChanged: true.</body>

<body>horaPrevistaDevolucao
	^horaPrevistaDevolucao</body>

<body>horaPrevistaDevolucao: newhoraPrevistaDevolucao
	self update: 'horaPrevistaDevolucao' to: newhoraPrevistaDevolucao.
	self changed: #horaPrevistaDevolucao.
	self isChanged: true.</body>

<body>horaRetirada
	^horaRetirada</body>

<body>horaRetirada: newhoraRetirada
	self update: 'horaRetirada' to: newhoraRetirada.
	self changed: #horaRetirada.
	self isChanged: true.</body>

<body>nroDocPagamento
	^nroDocPagamento</body>

<body>nroDocPagamento: newnroDocPagamento
	self update: 'nroDocPagamento' to: newnroDocPagamento.
	self changed: #nroDocPagamento.
	self isChanged: true.</body>

<body>quilometragemDevolucao
	^quilometragemDevolucao</body>

<body>quilometragemDevolucao: newquilometragemDevolucao
	self update: 'quilometragemDevolucao' to: newquilometragemDevolucao.
	self changed: #quilometragemDevolucao.
	self isChanged: true.</body>

<body>quilometragemRetirada
	^quilometragemRetirada</body>

<body>quilometragemRetirada: newquilometragemRetirada
	self update: 'quilometragemRetirada' to: newquilometragemRetirada.
	self changed: #quilometragemRetirada.
	self isChanged: true.</body>

<body>tipoPagamento
	^tipoPagamento</body>

<body>tipoPagamento: newtipoPagamento
	self update: 'tipoPagamento' to: newtipoPagamento.
	self changed: #tipoPagamento.
	self isChanged: true.</body>

<body>vlrCombustivel
	^vlrCombustivel</body>

<body>vlrCombustivel: newvlrCombustivel
	self update: 'vlrCombustivel' to: newvlrCombustivel.
	self changed: #vlrCombustivel.
	self isChanged: true.</body>
</methods>


<class>
<name>LocadoradecarrosMainWindow</name>
<environment>Locadoradecarros</environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.LocadoradecarrosMainWindow class</class-id> <category>resources</category>

<body>mainMenu
	"MenuEditor new openOnClass: self andSelector: #mainMenu"

	&lt;resource: #menu&gt;
	^#(#{UI.Menu} #(
			#(#{UI.MenuItem} 
				#rawLabel: 'Cadastros' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #cliente 
								#defaultString: 'Cliente' ) 
							#value: #cliente ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #unidadedemedida 
								#defaultString: 'Unidade de Medida' ) 
							#value: #unidadedemedida ) ) #(2 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: 'Locação' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #categoriadecarro 
								#defaultString: 'Categoria de Carro' ) 
							#value: #categoriadecarro ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #reservadecarro 
								#defaultString: 'Reserva de Carro' ) 
							#value: #reservadecarro ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #locacaodecarro 
								#defaultString: 'Locação de Carro' ) 
							#value: #locacaodecarro ) ) #(3 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: 'Venda de Serviços' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #tipodeservico 
								#defaultString: 'Tipo de Serviço' ) 
							#value: #tipodeservico ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #vendadeservico 
								#defaultString: 'Venda de Serviço' ) 
							#value: #vendadeservico ) ) #(2 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: 'Relatórios' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #listByPeriod3 
								#defaultString: 'Listagem de carros alugados por período' ) 
							#value: #listByPeriod3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #listByPeriod4 
								#defaultString: 'Listagem das reservas efetuadas por período''' ) 
							#value: #listByPeriod4 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 
							#(#{Kernel.UserMessage} 
								#key: #listByDestinationParty3 
								#defaultString: 'Histórico de aluguéis por cliente' ) 
							#value: #listByDestinationParty3 ) ) #(3 ) nil ) ) ) #(4 ) nil ) decodeAsLiteralArray</body>
</methods>

<methods>
<class-id>Locadoradecarros.LocadoradecarrosMainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'Locadora de Carros'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.LocadoradecarrosMainWindow</class-id> <category>resources</category>

<body>categoriadecarro
^Locadoradecarros.CategoriadecarroForm openWithSpec: #categoriadecarroSpec</body>

<body>cliente
^Locadoradecarros.ClienteForm openWithSpec: #clienteSpec</body>

<body>listByDestinationParty3
					^LocacaodecarroForm new listByDestinationParty</body>

<body>listByPeriod3
					^LocacaodecarroForm new listByPeriod</body>

<body>listByPeriod4
					^ReservadecarroForm new listByPeriod</body>

<body>locacaodecarro
^Locadoradecarros.LocacaodecarroForm openWithSpec: #locacaodecarroSpec</body>

<body>reservadecarro
^Locadoradecarros.ReservadecarroForm openWithSpec: #reservadecarroSpec</body>

<body>tipodeservico
^Locadoradecarros.TipodeservicoForm openWithSpec: #tipodeservicoSpec</body>

<body>unidadedemedida
^Locadoradecarros.UnidadedemedidaForm openWithSpec: #windowSpec</body>

<body>vendadeservico
^Locadoradecarros.VendadeservicoForm openWithSpec: #multiResTradeSpec</body>
</methods>

<methods>
<class-id>Locadoradecarros.LocadoradecarrosMainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='Locadoradecarros'.
	ReportHeader := '  L  O  C  A  D  O  R  A    D  E    C  A  R  R  O  S'.
	Language := #portuguese.
	super initialize.</body>
</methods>


<class>
<name>Categoriadecarro</name>
<environment>Locadoradecarros</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>valorDiaria valorSemanal valorMensal nroCarros </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Categoriadecarro class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Locadoradecarros.CategoriadecarroForm</body>

<body>quantificationStrategyClass
   ^InstantiableResource</body>

<body>resourceInstanceClass    
	    ^Locadoradecarros.Carro</body>

<body>resourceRentalClass    
	    ^Locadoradecarros.Locacaodecarro</body>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Locadoradecarros.Categoriadecarro class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<methods>
<class-id>Locadoradecarros.Categoriadecarro class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Categoriadecarro</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,valorDiaria ,valorSemanal ,valorMensal ,nroCarros'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self valorDiaria printString, ',', self valorSemanal printString, ',', self valorMensal printString, ',', self nroCarros printString</body>

<body>updateSetClause
	    ^super updateSetClause,', valorDiaria = ' ,self valorDiaria printString,', valorSemanal = ' ,self valorSemanal printString,', valorMensal = ' ,self valorMensal printString,', nroCarros = ' ,self nroCarros printString</body>
</methods>

<methods>
<class-id>Locadoradecarros.Categoriadecarro</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 valorDiaria := 0.00.
					 valorSemanal := 0.00.
					 valorMensal := 0.00.
					 nroCarros := 0</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self valorDiaria: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self valorSemanal: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self valorMensal: (aRow at: newIndex).
	newIndex := newIndex + 1.
	self nroCarros: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Categoriadecarro</class-id> <category>accessing</category>

<body>nroCarros
	^nroCarros</body>

<body>nroCarros: newnroCarros
	self update: 'nroCarros' to: newnroCarros.
	self changed: #nroCarros.
	self isChanged: true.</body>

<body>valorDiaria
	^valorDiaria</body>

<body>valorDiaria: newvalorDiaria
	self update: 'valorDiaria' to: newvalorDiaria.
	self changed: #valorDiaria.
	self isChanged: true.</body>

<body>valorMensal
	^valorMensal</body>

<body>valorMensal: newvalorMensal
	self update: 'valorMensal' to: newvalorMensal.
	self changed: #valorMensal.
	self isChanged: true.</body>

<body>valorSemanal
	^valorSemanal</body>

<body>valorSemanal: newvalorSemanal
	self update: 'valorSemanal' to: newvalorSemanal.
	self changed: #valorSemanal.
	self isChanged: true.</body>
</methods>


<class>
<name>TipodeservicoForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.MeasurableResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>valor </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.TipodeservicoForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#tipodeservicoSpec</body>

<body>objectClass    
	    ^Locadoradecarros.Tipodeservico</body>

<body>objectName    
	    ^'Tipo de Servico'</body>

<body>pluralObjectName    
	    ^'Tipos de Servicos'</body>

<body>typesCanvasClass
								    ^QualificationForm0</body>

<body>typesSpec
								    ^#resType0Spec</body>
</methods>

<methods>
<class-id>Locadoradecarros.TipodeservicoForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 			
			^'Descrição'</body>

<body>quantityInStockLabel 			
			^'Quantidade em estoque'</body>

<body>reSupplyLevelLabel 			
			^'Nivel de ressuprimento'</body>

<body>tipodeservicoSpec
	"UIPainter new openOnClass: self andSelector: #tipodeservicoSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 241 259 990 609 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 235 ) 
					#label: #reSupplyLevelLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 195 ) 
					#label: #quantityInStockLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 531 197 ) 
					#label: #measureUnityLabel ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 29 1 242 32 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 293 37 744 195 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 300 274 ) 
					#name: #valorLabel 
					#label: 'Valor' ) 
				#(#{UI.ActionButtonSpec} 
					#layout: #(#{Graphics.Rectangle} 505 74 606 101 ) 
					#name: #storageBt 
					#model: #storageBt 
					#helpText: 'Details about storage' 
					#label: 
					#(#{Kernel.UserMessage} 
						#key: #storageBt 
						#defaultString: 'Storage...' ) 
					#defaultable: true ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 298 356 ) 
					#name: #costLabel 
					#flags: 16 
					#label: #costLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 500 356 ) 
					#name: #salePriceLabel 
					#flags: 16 
					#label: #salePriceLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 8 56 ) 
					#label: #listLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 78 ) 
					#label: #idCodeLabel ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 293 114 ) 
					#label: #descriptionLabel ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 261 5 589 46 ) ) 
				#(#{UI.GroupBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 2 5 226 45 ) ) 
				#(#{UI.SequenceViewSpec} 
					#layout: #(#{Graphics.Rectangle} 6 81 281 319 ) 
					#name: #allStaticObjects 
					#model: #allStaticObjects 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#requestFocusInSelector: #changeRequest ) 
					#useModifierKeys: true 
					#selectionType: #highlight ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 8 11 221 42 ) 
					#name: #navigationBtns 
					#flags: 0 
					#clientKey: #navigationBtns ) 
				#(#{UI.SubCanvasSpec} 
					#layout: #(#{Graphics.Rectangle} 267 12 587 46 ) 
					#name: #basicBtnsCanvas 
					#flags: 0 
					#clientKey: #basicBtnsCanvas ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 411 75 474 101 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 410 114 664 139 ) 
					#name: #descriptionField 
					#model: #w_description 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 415 195 515 220 ) 
					#model: #quantityInStock 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{GRENComboBoxSpec} 
					#layout: #(#{Graphics.Rectangle} 638 196 738 221 ) 
					#model: #measureUnity 
					#objectListMethod: #allMeasureUnities ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 414 235 514 260 ) 
					#model: #reSupplyLevel 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 392 356 494 380 ) 
					#name: #costField 
					#flags: 24 
					#model: #cost 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 597 356 680 382 ) 
					#name: #salePriceField 
					#flags: 24 
					#model: #salePrice 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 413 270 516 294 ) 
					#name: #valor 
					#model: #valor 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#type: #number 
					#formatString: '0.00' ) ) ) )</body>

<body>windowLabel   
	    ^'Tipo de Serviço'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.TipodeservicoForm</class-id> <category>aspects</category>

<body>valor
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #valor.
		^adaptor</body>
</methods>

<methods>
<class-id>Locadoradecarros.TipodeservicoForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 valor := 0.00 asValue</body>
</methods>


<class>
<name>Itemdavenda</name>
<environment>Locadoradecarros</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Itemdavenda class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Locadoradecarros.Tipodeservico</body>

<body>transactionClass    
	    ^Locadoradecarros.Vendadeservico</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Cliente</name>
<environment>Locadoradecarros</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade estado telefone email documentoIdentidade dataNascimento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Cliente class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Locadoradecarros.ClienteForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Cliente</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,cidade ,estado ,telefone ,email ,documentoIdentidade ,dataNascimento'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self cidade printString, ',', self estado printString, ',', self telefone printString, ',', self email printString, ',', self documentoIdentidade printString, ',', self dataNascimento printForSaving</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', cidade = ' ,self cidade printString,', estado = ' ,self estado printString,', telefone = ' ,self telefone printString,', email = ' ,self email printString,', documentoIdentidade = ' ,self documentoIdentidade printString,', dataNascimento = ' ,self dataNascimento printForSaving</body>
</methods>

<methods>
<class-id>Locadoradecarros.Cliente</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 cidade := ''.
					 estado := ''.
					 telefone := ''.
					 email := ''.
					 documentoIdentidade := ''.
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
	self documentoIdentidade: (aRow at: newIndex).
	self documentoIdentidade isNil ifTrue: [self documentoIdentidade: ' '].
	newIndex := newIndex + 1.
	self dataNascimento: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Cliente</class-id> <category>accessing</category>

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

<body>documentoIdentidade
	^documentoIdentidade</body>

<body>documentoIdentidade: newdocumentoIdentidade
	self update: 'documentoIdentidade' to: newdocumentoIdentidade.
	self changed: #documentoIdentidade.
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
<name>UnidadedemedidaForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.MeasureUnityForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.UnidadedemedidaForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Locadoradecarros.Unidadedemedida</body>

<body>objectName    
	    ^'Unidade de Medida'</body>

<body>pluralObjectName    
	    ^'Unidades de Medidas'</body>
</methods>

<methods>
<class-id>Locadoradecarros.UnidadedemedidaForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Unidade de Medida'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Vendadeservico</name>
<environment>Locadoradecarros</environment>
<super>GREN.BasicSale</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.Vendadeservico class</class-id> <category>hotspots configuration</category>

<body>generateInstanceCode    
	    ^ true</body>

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
<class-id>Locadoradecarros.Vendadeservico class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Locadoradecarros.Cliente</body>

<body>resourceClass    
	    ^Locadoradecarros.Categoriadecarro</body>

<body>transactionItemClass
  ^Locadoradecarros.Itemdavenda</body>

<body>transactionPluralName    
	    ^'Vendas de Servicos'</body>

<body>transQuantificationStrategyClass
   ^InstantiableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ClienteForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade estado telefone email documentoIdentidade dataNascimento </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Locadoradecarros.ClienteForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'freight' 'taxes')</body>

<body>guiSpec 
	    ^#clienteSpec</body>

<body>objectClass    
	    ^Locadoradecarros.Cliente</body>

<body>objectName    
	    ^'Cliente'</body>

<body>pluralObjectName    
	    ^'Clientes'</body>
</methods>

<methods>
<class-id>Locadoradecarros.ClienteForm class</class-id> <category>interface specs</category>

<body>clienteSpec
	"UIPainter new openOnClass: self andSelector: #clienteSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 369 384 1024 764 ) ) 
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
					#layout: #(#{Core.Point} 294 187 ) 
					#name: #cidadeLabel 
					#label: 'Cidade' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 217 ) 
					#name: #estadoLabel 
					#label: 'Estado' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 247 ) 
					#name: #telefoneLabel 
					#label: 'Telefone' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 277 ) 
					#name: #emailLabel 
					#label: 'Email' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 307 ) 
					#name: #documentoidentidadeLabel 
					#label: 'Doc. identidade' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 294 337 ) 
					#name: #datanascimentoLabel 
					#label: 'Data nasc.' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 379 74 442 100 ) 
					#name: #idCodeField 
					#flags: 40 
					#model: #w_idCode 
					#alignment: #right 
					#type: #number ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 377 113 631 138 ) 
					#name: #descriptionField 
					#model: #w_description 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
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
					#layout: #(#{Graphics.Rectangle} 374 217 405 240 ) 
					#name: #estado 
					#model: #estado 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#numChars: 2 ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 247 544 272 ) 
					#name: #telefone 
					#model: #telefone 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#formatString: '(@@@) @@@-@@@@' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 277 544 302 ) 
					#name: #email 
					#model: #email 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 374 307 544 332 ) 
					#name: #documentoIdentidade 
					#model: #documentoIdentidade 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 373 337 442 362 ) 
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
<class-id>Locadoradecarros.ClienteForm</class-id> <category>aspects</category>

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

<body>documentoIdentidade
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #documentoIdentidade.
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
<class-id>Locadoradecarros.ClienteForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 cidade := '' asValue.
					 estado := '' asValue.
					 telefone := '' asValue.
					 email := '' asValue.
					 documentoIdentidade := '' asValue.
					 dataNascimento := Date today asValue</body>
</methods>


<class>
<name>Carro</name>
<environment>Locadoradecarros</environment>
<super>GREN.ResourceInstance</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>fabricante marca modelo ano </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>

<methods>
<class-id>Locadoradecarros.Carro</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,fabricante ,marca ,modelo ,ano'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self fabricante printString, ',', self marca printString, ',', self modelo printString, ',', self ano printString</body>

<body>updateSetClause
	    ^super updateSetClause,', fabricante = ' ,self fabricante printString,', marca = ' ,self marca printString,', modelo = ' ,self modelo printString,', ano = ' ,self ano printString</body>
</methods>

<methods>
<class-id>Locadoradecarros.Carro</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 fabricante := ''.
					 marca := ''.
					 modelo := ''.
					 ano := 0</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self fabricante: (aRow at: newIndex).
	self fabricante isNil ifTrue: [self fabricante: ' '].
	newIndex := newIndex + 1.
	self marca: (aRow at: newIndex).
	self marca isNil ifTrue: [self marca: ' '].
	newIndex := newIndex + 1.
	self modelo: (aRow at: newIndex).
	self modelo isNil ifTrue: [self modelo: ' '].
	newIndex := newIndex + 1.
	self ano: (aRow at: newIndex).
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Locadoradecarros.Carro</class-id> <category>accessing</category>

<body>ano
	^ano</body>

<body>ano: newano
	self update: 'ano' to: newano.
	self changed: #ano.
	self isChanged: true.</body>

<body>fabricante
	^fabricante</body>

<body>fabricante: newfabricante
	self update: 'fabricante' to: newfabricante.
	self changed: #fabricante.
	self isChanged: true.</body>

<body>marca
	^marca</body>

<body>marca: newmarca
	self update: 'marca' to: newmarca.
	self changed: #marca.
	self isChanged: true.</body>

<body>modelo
	^modelo</body>

<body>modelo: newmodelo
	self update: 'modelo' to: newmodelo.
	self changed: #modelo.
	self isChanged: true.</body>
</methods>


<class>
<name>ItemdavendaForm</name>
<environment>Locadoradecarros</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Locadoradecarros</category>
</class>



</st-source>
