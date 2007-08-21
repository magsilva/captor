<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of August 9, 2001 on September 23, 2002 at 5:32:34 pm</time-stamp>


<name-space>
<name>Oficinacarrao</name>
<environment>Smalltalk</environment>
<private>false</private>
<imports>
			private Smalltalk.*
			private GREN.*
			</imports>
<category>Oficinacarrao</category>
</name-space>


<class>
<name>ModeloForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ModeloForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinacarrao.Modelo</body>

<body>objectName    
	    ^'Modelo'</body>

<body>pluralObjectName    
	    ^'Modelos'</body>
</methods>

<methods>
<class-id>Oficinacarrao.ModeloForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Modelo'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Comissao</name>
<environment>Oficinacarrao</environment>
<super>GREN.Commission</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Comissao class</class-id> <category>classReferences</category>

<body>executorClass
  ^Oficinacarrao.Tecnico</body>

<body>transactionClass
  ^Oficinacarrao.Consertodeveiculo</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>PedidoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MultiResourceTradeForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.PedidoForm class</class-id> <category>classReferences</category>

<body>transactionClass
	    ^Oficinacarrao.Pedido</body>

<body>transactionItemFormClass
	    ^Oficinacarrao.ItemdopedidoForm</body>
</methods>

<methods>
<class-id>Oficinacarrao.PedidoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Fornecedor'</body>

<body>resourcesTransactedLabel   
	    ^'Peca'</body>

<body>windowLabel   
	    ^'Pedido'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.PedidoForm</class-id> <category>report parameters</category>

<body>reportPendingTradesTitle
					^'Pedidos pendentes de fornecedores'</body>
</methods>


<class>
<name>TarefademaodeobraForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MaintenanceTaskForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.TarefademaodeobraForm class</class-id> <category>classReferences</category>

<body>maintenanceTaskClass
	    ^Oficinacarrao.Tarefademaodeobra</body>
</methods>

<methods>
<class-id>Oficinacarrao.TarefademaodeobraForm class</class-id> <category>interface specs</category>

<body>tasksPerformedLabel
	    ^'Tarefas de mao de obra'</body>

<body>windowLabel   
	    ^'Tarefa de mao de obra'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>CompraForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MultiResourceDeliveryForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.CompraForm class</class-id> <category>classReferences</category>

<body>paymentFormClass
	    ^Oficinacarrao.ParcelaapagarForm</body>

<body>transactionClass
	    ^Oficinacarrao.Compra</body>

<body>transactionItemFormClass
	    ^Oficinacarrao.ItemdacompraForm</body>
</methods>

<methods>
<class-id>Oficinacarrao.CompraForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Fornecedor'</body>

<body>aExecutorLabel   
	    ^'Almoxarife'</body>

<body>resourcesTransactedLabel   
	    ^'Peca'</body>

<body>windowLabel   
	    ^'Compra'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>MultaaofornecedorForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.FineRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.MultaaofornecedorForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Oficinacarrao.Multaaofornecedor</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>TaxadejurosForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.InterestRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.TaxadejurosForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Oficinacarrao.Taxadejuros</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Almoxarife</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionExecutor</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Almoxarife class</class-id> <category>hotspots configuration</category>

<body>receivesCommission
	^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>FornecedorForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>cidade telefone fax </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.FornecedorForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'freight' 'taxes')</body>

<body>guiSpec 
	    ^#fornecedorSpec</body>

<body>objectClass    
	    ^Oficinacarrao.Fornecedor</body>

<body>objectName    
	    ^'Fornecedor'</body>

<body>pluralObjectName    
	    ^'Fornecedores'</body>
</methods>

<methods>
<class-id>Oficinacarrao.FornecedorForm class</class-id> <category>interface specs</category>

<body>fornecedorSpec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #bounds: #(#{Graphics.Rectangle} 73 130 728 470)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 9 55) #label: #listLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 77) #label: #idCodeLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 113) #label: #descriptionLabel) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 262 4 590 45)) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 3 4 227 44)) #(#{UI.SequenceViewSpec} #layout: #(#{Graphics.Rectangle} 7 80 282 318) #name: #allStaticObjects #model: #allStaticObjects #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #requestFocusInSelector: #changeRequest) #useModifierKeys: true #selectionType: #highlight) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 391 74 454 100) #name: #idCodeField #flags: 40 #model: #w_idCode #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 113 644 138) #name: #descriptionField #model: #w_description #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 9 10 222 41) #name: #navigationBtns #flags: 0 #clientKey: #navigationBtns) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 268 11 588 45) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 157) #name: #cidadeLabel #label: 'Cidade') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 187) #name: #telefoneLabel #label: 'Telefone') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 217) #name: #faxLabel #label: 'Fax') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 157 544 182) #name: #cidade #model: #cidade #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 187 544 212) #name: #telefone #model: #telefone #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 217 544 242) #name: #fax #model: #fax #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)))))</body>

<body>windowLabel   
	    ^'Fornecedor'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.FornecedorForm</class-id> <category>aspects</category>

<body>cidade
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #cidade.
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
<class-id>Oficinacarrao.FornecedorForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 cidade := '' asValue.
					 telefone := '' asValue.
					 fax := '' asValue</body>
</methods>


<class>
<name>Itemdacompra</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Itemdacompra class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Oficinacarrao.Peca</body>

<body>transactionClass    
	    ^Oficinacarrao.Compra</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Veiculo</name>
<environment>Oficinacarrao</environment>
<super>GREN.Resource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>ano cor </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Veiculo class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinacarrao.VeiculoForm</body>

<body>quantificationStrategyClass
   ^SingleResource</body>

<body>typeClasses  
	^List with: Oficinacarrao.Modelo</body>

<body>typeForms  
	^List with: Oficinacarrao.ModeloForm</body>
</methods>

<methods>
<class-id>Oficinacarrao.Veiculo class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List with: 'Modelo'</body>
</methods>

<methods>
<class-id>Oficinacarrao.Veiculo class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Veiculo</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,ano ,cor'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self ano printString, ',', self cor printString</body>

<body>updateSetClause
	    ^super updateSetClause,', ano = ' ,self ano printString,', cor = ' ,self cor printString</body>
</methods>

<methods>
<class-id>Oficinacarrao.Veiculo</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 ano := ''.
					 cor := ''</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
	newIndex := newIndex + 1.
	self ano: (aRow at: newIndex).
	self ano isNil ifTrue: [self ano: ' '].
	newIndex := newIndex + 1.
	self cor: (aRow at: newIndex).
	self cor isNil ifTrue: [self cor: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Oficinacarrao.Veiculo</class-id> <category>accessing</category>

<body>ano
	^ano</body>

<body>ano: newano
	self update: 'ano' to: newano.
	self changed: #ano.
	self isChanged: true.</body>

<body>cor
	^cor</body>

<body>cor: newcor
	self update: 'cor' to: newcor.
	self changed: #cor.
	self isChanged: true.</body>
</methods>


<class>
<name>Taxadejuros</name>
<environment>Oficinacarrao</environment>
<super>GREN.InterestRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>Parcelaapagar</name>
<environment>Oficinacarrao</environment>
<super>GREN.Payment</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Parcelaapagar class</class-id> <category>classReferences</category>

<body>defaultPaymentStrategyClass   
	    ^Cash</body>

<body>fineRateClass    
	    ^Oficinacarrao.Multaaofornecedor</body>

<body>interestRateClass    
	    ^Oficinacarrao.Jurosdofornecedor</body>

<body>paymentStrategyClasses  
	    ^List with: Cash with: Check</body>

<body>transactionClass    
	    ^Oficinacarrao.Compra</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Consertodeveiculo</name>
<environment>Oficinacarrao</environment>
<super>GREN.ResourceMaintenance</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Consertodeveiculo class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^false</body>

<body>hasParts
	^true</body>

<body>hasPayment
	^true</body>

<body>hasQuotation
	^false</body>

<body>hasSourceParty
	^false</body>

<body>hasTasks
	^true</body>

<body>isItemized
	^false</body>
</methods>

<methods>
<class-id>Oficinacarrao.Consertodeveiculo class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Oficinacarrao.Cliente</body>

<body>executorClass
  ^Oficinacarrao.Tecnico</body>

<body>maintenancePartClass    
	    ^Oficinacarrao.Pecausadanoconserto</body>

<body>maintenanceTaskClass    
	    ^Oficinacarrao.Tarefademaodeobra</body>

<body>paymentClass
  ^Oficinacarrao.Parcelaareceber</body>

<body>resourceClass    
	    ^Oficinacarrao.Veiculo</body>

<body>transactionPluralName    
	    ^'Consertos de Veiculo'</body>

<body>transQuantificationStrategyClass
   ^SingleResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Taxademulta</name>
<environment>Oficinacarrao</environment>
<super>GREN.FineRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>ParcelaapagarForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.PaymentForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ParcelaapagarForm class</class-id> <category>classReferences</category>

<body>paymentClass    
	    ^Oficinacarrao.Parcelaapagar</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ParcelaapagarForm</class-id> <category>report parameters</category>

<body>reportPaidTitle
					^'Contas pagas aos fornecedores'</body>
</methods>


<class>
<name>ConsertodeveiculoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.OneResourceMaintWPWTForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ConsertodeveiculoForm class</class-id> <category>classReferences</category>

<body>maintenancePartFormClass
	    ^Oficinacarrao.PecausadanoconsertoForm</body>

<body>maintenanceTaskFormClass
	    ^Oficinacarrao.TarefademaodeobraForm</body>

<body>paymentFormClass
	    ^Oficinacarrao.ParcelaareceberForm</body>

<body>transactionClass
	    ^Oficinacarrao.Consertodeveiculo</body>
</methods>

<methods>
<class-id>Oficinacarrao.ConsertodeveiculoForm class</class-id> <category>interface specs</category>

<body>aDestinationPartyLabel   
	    ^'Cliente'</body>

<body>aExecutorLabel   
	    ^'Tecnico'</body>

<body>aResourceLabel   
	    ^'Veiculo'</body>

<body>partsBtLabel
	    ^'Peca usada no conserto...'</body>

<body>tasksBtLabel
	    ^'Tarefa de mao de obra...'</body>

<body>windowLabel   
	    ^'Conserto de Veiculo'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ConsertodeveiculoForm</class-id> <category>report parameters</category>

<body>reportByExecutorTitle
					^'Consertos efetuados por técnico'</body>

<body>reportDailyGainsTitle
					^'Resumo de ganhos no período'</body>

<body>reportPaidComTitle
					^'Comissões pagas aos técnicos'</body>

<body>reportPendingMaintTitle
					^'Relatório de consertos pendentes'</body>
</methods>


<class>
<name>Tecnico</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionExecutor</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Tecnico class</class-id> <category>hotspots configuration</category>

<body>receivesCommission
	^true</body>
</methods>

<methods>
<class-id>Oficinacarrao.Tecnico class</class-id> <category>classReferences</category>

<body>commissionClass
	^Oficinacarrao.Comissao</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ParcelaareceberForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.PaymentForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ParcelaareceberForm class</class-id> <category>classReferences</category>

<body>paymentClass    
	    ^Oficinacarrao.Parcelaareceber</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ParcelaareceberForm</class-id> <category>report parameters</category>

<body>reportComingTitle
					^'Parcelas a receber no período'</body>

<body>reportOverdueTitle
					^'Parcelas vencidas e não pagas'</body>

<body>reportPaidTitle
					^'Parcelas recebidas no período'</body>
</methods>


<class>
<name>AlmoxarifeForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionExecutorForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.AlmoxarifeForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'specialty' 'percentage' 'minimumValue' 'salary')</body>

<body>objectClass    
	    ^Oficinacarrao.Almoxarife</body>

<body>objectName    
	    ^'Almoxarife'</body>

<body>pluralObjectName    
	    ^'Almoxarifes'</body>
</methods>

<methods>
<class-id>Oficinacarrao.AlmoxarifeForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>windowLabel   
	    ^'Almoxarife'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ItemdacompraForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>Unidadedemedida</name>
<environment>Oficinacarrao</environment>
<super>GREN.MeasureUnity</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>PecaForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MeasurableResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.PecaForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinacarrao.Peca</body>

<body>objectName    
	    ^'Peca'</body>

<body>pluralObjectName    
	    ^'Pecas'</body>

<body>typesCanvasClass
								    ^QualificationForm1</body>

<body>typesSpec
								    ^#resType1Spec</body>
</methods>

<methods>
<class-id>Oficinacarrao.PecaForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Peca'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.PecaForm</class-id> <category>report parameters</category>

<body>reportByUMTitle
					^'Peças com nível baixo de estoque'</body>
</methods>


<class>
<name>Categoria</name>
<environment>Oficinacarrao</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Categoria class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Oficinacarrao.Categoria class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ItemdopedidoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionItemForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>OficinacarraoMainWindow</name>
<environment>Oficinacarrao</environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.OficinacarraoMainWindow class</class-id> <category>resources</category>

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
							#rawLabel: '&amp;Modelo de veículo' 
							#value: #modelo ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Veículo' 
							#value: #veiculo ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Unidade de medida' 
							#value: #unidadedemedida ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'C&amp;ategoria de Peça' 
							#value: #categoria ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Peça' 
							#value: #peca ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'C&amp;liente' 
							#value: #cliente ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Técnico' 
							#value: #tecnico ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Alm&amp;oxarife' 
							#value: #almoxarife ) 
						#(#{UI.MenuItem} 
							#rawLabel: '&amp;Fornecedor' 
							#value: #fornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Multa ao cliente' 
							#value: #taxademulta ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Juros ao cliente' 
							#value: #taxadejuros ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Multa para Fornecedor' 
							#value: #multaaofornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Juros do fornecedor' 
							#value: #jurosdofornecedor ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Co&amp;nserto de Veículo' 
							#value: #consertodeveiculo ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'P&amp;edido de Peça' 
							#value: #pedido ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Comp&amp;ra de Peça' 
							#value: #compra ) ) #(9 4 3 ) nil ) ) 
			#(#{UI.MenuItem} 
				#rawLabel: '&amp;Relatórios' 
				#submenu: #(#{UI.Menu} #(
						#(#{UI.MenuItem} 
							#rawLabel: 'Relatório de consertos pendentes' 
							#value: #pendingList3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Resumo de ganhos no período' 
							#value: #listGainsByPeriod3 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Comissões pagas aos técnicos' 
							#value: #listPaidCommissions4 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Consertos efetuados por técnico' 
							#value: #listByExecutor4 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Parcelas a receber no período' 
							#value: #listComingInstallments7 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Parcelas vencidas e não pagas' 
							#value: #listOverdueInstallments7 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Parcelas recebidas no período' 
							#value: #listPaidInstallments7 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Peças com nível baixo de estoque' 
							#value: #listByUnderMin9 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Pedidos pendentes de fornecedores' 
							#value: #listPendingTrades10 ) 
						#(#{UI.MenuItem} 
							#rawLabel: 'Contas pagas aos fornecedores' 
							#value: #listPaidInstallments15 ) ) #(10 ) nil ) ) ) #(3 ) nil ) decodeAsLiteralArray</body>
</methods>

<methods>
<class-id>Oficinacarrao.OficinacarraoMainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'Oficina Carrao'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.OficinacarraoMainWindow</class-id> <category>resources</category>

<body>almoxarife
^Oficinacarrao.AlmoxarifeForm openWithSpec: #transExecutorSpec</body>

<body>categoria
^Oficinacarrao.CategoriaForm openWithSpec: #windowSpec</body>

<body>cliente
^Oficinacarrao.ClienteForm openWithSpec: #clienteSpec</body>

<body>compra
^Oficinacarrao.CompraForm openWithSpec: #multiResDeliverySpec</body>

<body>consertodeveiculo
^Oficinacarrao.ConsertodeveiculoForm openWithSpec: #oneResBasicMaintWTWPSpec</body>

<body>fornecedor
^Oficinacarrao.FornecedorForm openWithSpec: #fornecedorSpec</body>

<body>jurosdofornecedor
^Oficinacarrao.JurosdofornecedorForm openWithSpec: #windowSpec</body>

<body>listByExecutor4
					^ConsertodeveiculoForm new listByExecutor</body>

<body>listByUnderMin9
					^PecaForm new listByUnderMin</body>

<body>listComingInstallments7
					^ParcelaareceberForm new listComingInstallments</body>

<body>listGainsByPeriod3
					^ConsertodeveiculoForm new listGainsByPeriod</body>

<body>listOverdueInstallments7
					^ParcelaareceberForm new listOverdueInstallments</body>

<body>listPaidCommissions4
					^ConsertodeveiculoForm new listPaidCommissions</body>

<body>listPaidInstallments15
					^ParcelaapagarForm new listPaidInstallments</body>

<body>listPaidInstallments7
					^ParcelaareceberForm new listPaidInstallments</body>

<body>listPendingTrades10
					^PedidoForm new listPendingTrades</body>

<body>modelo
^Oficinacarrao.ModeloForm openWithSpec: #windowSpec</body>

<body>multaaofornecedor
^Oficinacarrao.MultaaofornecedorForm openWithSpec: #windowSpec</body>

<body>peca
^Oficinacarrao.PecaForm openWithSpec: #measResSpec</body>

<body>pedido
^Oficinacarrao.PedidoForm openWithSpec: #multiResTradeSpec</body>

<body>pendingList3
					^ConsertodeveiculoForm new pendingList</body>

<body>taxadejuros
^Oficinacarrao.TaxadejurosForm openWithSpec: #windowSpec</body>

<body>taxademulta
^Oficinacarrao.TaxademultaForm openWithSpec: #windowSpec</body>

<body>tecnico
^Oficinacarrao.TecnicoForm openWithSpec: #transExecutorSpec</body>

<body>unidadedemedida
^Oficinacarrao.UnidadedemedidaForm openWithSpec: #windowSpec</body>

<body>veiculo
^Oficinacarrao.VeiculoForm openWithSpec: #veiculoSpec</body>
</methods>

<methods>
<class-id>Oficinacarrao.OficinacarraoMainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='Oficinacarrao'.
	ReportHeader := '  O  F  I  C  I  N  A     C  A  R  R  A  O'.
	Language := #english.
	super initialize.</body>
</methods>


<class>
<name>TaxademultaForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.FineRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.TaxademultaForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Oficinacarrao.Taxademulta</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Cliente</name>
<environment>Oficinacarrao</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade telefone email </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Cliente class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinacarrao.ClienteForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Cliente</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,endereco ,cidade ,telefone ,email'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self endereco printString, ',', self cidade printString, ',', self telefone printString, ',', self email printString</body>

<body>updateSetClause
	    ^super updateSetClause,', endereco = ' ,self endereco printString,', cidade = ' ,self cidade printString,', telefone = ' ,self telefone printString,', email = ' ,self email printString</body>
</methods>

<methods>
<class-id>Oficinacarrao.Cliente</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := ''.
					 cidade := ''.
					 telefone := ''.
					 email := ''</body>

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
	self email: (aRow at: newIndex).
	self email isNil ifTrue: [self email: ' '].
	self isChanged: false.
	^newIndex + 1</body>
</methods>

<methods>
<class-id>Oficinacarrao.Cliente</class-id> <category>accessing</category>

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
<name>Parcelaareceber</name>
<environment>Oficinacarrao</environment>
<super>GREN.Payment</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Parcelaareceber class</class-id> <category>classReferences</category>

<body>defaultPaymentStrategyClass   
	    ^Cash</body>

<body>fineRateClass    
	    ^Oficinacarrao.Taxademulta</body>

<body>interestRateClass    
	    ^Oficinacarrao.Taxadejuros</body>

<body>paymentStrategyClasses  
	    ^List with: Cash with: Check</body>

<body>transactionClass    
	    ^Oficinacarrao.Consertodeveiculo</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>TecnicoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionExecutorForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.TecnicoForm class</class-id> <category>classReferences</category>

<body>attributesToOmit
			^#( 'minimumValue')</body>

<body>objectClass    
	    ^Oficinacarrao.Tecnico</body>

<body>objectName    
	    ^'Tecnico'</body>

<body>pluralObjectName    
	    ^'Tecnicos'</body>
</methods>

<methods>
<class-id>Oficinacarrao.TecnicoForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>windowLabel   
	    ^'Tecnico'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Peca</name>
<environment>Oficinacarrao</environment>
<super>GREN.StockResource</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Peca class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinacarrao.PecaForm</body>

<body>measureUnityClass    
	    ^Oficinacarrao.Unidadedemedida</body>

<body>quantificationStrategyClass
   ^MeasurableResource</body>

<body>typeClasses  
	^List with: Oficinacarrao.Categoria</body>

<body>typeForms  
	^List with: Oficinacarrao.CategoriaForm</body>
</methods>

<methods>
<class-id>Oficinacarrao.Peca class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List with: 'Categoria'</body>
</methods>

<methods>
<class-id>Oficinacarrao.Peca class</class-id> <category>hotspots configuration</category>

<body>isStored    
	    ^false</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Cash</name>
<environment>Oficinacarrao</environment>
<super>GREN.Cash</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>Itemdopedido</name>
<environment>Oficinacarrao</environment>
<super>GREN.TransactionItem</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Itemdopedido class</class-id> <category>classReferences</category>

<body>itemQuantificationStrategyClass
   ^MeasResTransItem</body>

<body>resourceClass    
	    ^Oficinacarrao.Peca</body>

<body>transactionClass    
	    ^Oficinacarrao.Pedido</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>UnidadedemedidaForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MeasureUnityForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.UnidadedemedidaForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinacarrao.Unidadedemedida</body>

<body>objectName    
	    ^'Unidade de medida'</body>

<body>pluralObjectName    
	    ^'Unidades de medida'</body>
</methods>

<methods>
<class-id>Oficinacarrao.UnidadedemedidaForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Unidade de medida'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Pecausadanoconserto</name>
<environment>Oficinacarrao</environment>
<super>GREN.MaintenancePart</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Pecausadanoconserto class</class-id> <category>classReferences</category>

<body>partClass
  ^Oficinacarrao.Peca</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Jurosdofornecedor</name>
<environment>Oficinacarrao</environment>
<super>GREN.InterestRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>CategoriaForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.CategoriaForm class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^Oficinacarrao.Categoria</body>

<body>objectName    
	    ^'Categoria'</body>

<body>pluralObjectName    
	    ^'Categorias'</body>
</methods>

<methods>
<class-id>Oficinacarrao.CategoriaForm class</class-id> <category>interface specs</category>

<body>windowLabel   
	    ^'Categoria'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Pedido</name>
<environment>Oficinacarrao</environment>
<super>GREN.BasicPurchase</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Pedido class</class-id> <category>hotspots configuration</category>

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
<class-id>Oficinacarrao.Pedido class</class-id> <category>classReferences</category>

<body>deliveryClass    
	    ^Oficinacarrao.Compra</body>

<body>destinationPartyClass    
	    ^Oficinacarrao.Fornecedor</body>

<body>resourceClass    
	    ^Oficinacarrao.Peca</body>

<body>transactionItemClass
  ^Oficinacarrao.Itemdopedido</body>

<body>transactionPluralName    
	    ^'Pedidos'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Check</name>
<environment>Oficinacarrao</environment>
<super>GREN.Check</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>Modelo</name>
<environment>Oficinacarrao</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Modelo class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>Oficinacarrao.Modelo class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>ClienteForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.DestinationPartyForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>endereco cidade telefone email </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ClienteForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#clienteSpec</body>

<body>objectClass    
	    ^Oficinacarrao.Cliente</body>

<body>objectName    
	    ^'Cliente'</body>

<body>pluralObjectName    
	    ^'Clientes'</body>
</methods>

<methods>
<class-id>Oficinacarrao.ClienteForm class</class-id> <category>interface specs</category>

<body>clienteSpec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #bounds: #(#{Graphics.Rectangle} 73 130 728 470)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 9 55) #label: #listLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 77) #label: #idCodeLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 113) #label: #descriptionLabel) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 262 4 590 45)) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 3 4 227 44)) #(#{UI.SequenceViewSpec} #layout: #(#{Graphics.Rectangle} 7 80 282 318) #name: #allStaticObjects #model: #allStaticObjects #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #requestFocusInSelector: #changeRequest) #useModifierKeys: true #selectionType: #highlight) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 391 74 454 100) #name: #idCodeField #flags: 40 #model: #w_idCode #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 113 644 138) #name: #descriptionField #model: #w_description #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 9 10 222 41) #name: #navigationBtns #flags: 0 #clientKey: #navigationBtns) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 268 11 588 45) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 157) #name: #enderecoLabel #label: 'Endereco') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 187) #name: #cidadeLabel #label: 'Cidade') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 217) #name: #telefoneLabel #label: 'Telefone') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 247) #name: #emailLabel #label: 'Email') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 157 544 182) #name: #endereco #model: #endereco #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 187 544 212) #name: #cidade #model: #cidade #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 217 544 242) #name: #telefone #model: #telefone #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 247 544 272) #name: #email #model: #email #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)))))</body>

<body>descriptionLabel 
			
			^'Nome'</body>

<body>windowLabel   
	    ^'Cliente'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.ClienteForm</class-id> <category>aspects</category>

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
<class-id>Oficinacarrao.ClienteForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 endereco := '' asValue.
					 cidade := '' asValue.
					 telefone := '' asValue.
					 email := '' asValue</body>
</methods>


<class>
<name>Tarefademaodeobra</name>
<environment>Oficinacarrao</environment>
<super>GREN.MaintenanceTask</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Tarefademaodeobra class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^true</body>
</methods>

<methods>
<class-id>Oficinacarrao.Tarefademaodeobra class</class-id> <category>classReferences</category>

<body>executorClass    
	    ^Oficinacarrao.Tecnico</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Compra</name>
<environment>Oficinacarrao</environment>
<super>GREN.PurchaseDelivery</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Compra class</class-id> <category>hotspots configuration</category>

<body>hasExecutor
	^true</body>

<body>hasPayment
	^true</body>

<body>hasSourceParty
	^false</body>

<body>isItemized
	^true</body>
</methods>

<methods>
<class-id>Oficinacarrao.Compra class</class-id> <category>classReferences</category>

<body>destinationPartyClass    
	    ^Oficinacarrao.Fornecedor</body>

<body>executorClass
  ^Oficinacarrao.Almoxarife</body>

<body>paymentClass
  ^Oficinacarrao.Parcelaapagar</body>

<body>resourceClass    
	    ^Oficinacarrao.Peca</body>

<body>tradeClass    
	    ^Oficinacarrao.Pedido</body>

<body>transactionItemClass
  ^Oficinacarrao.Itemdacompra</body>

<body>transactionPluralName    
	    ^'Compras'</body>

<body>transQuantificationStrategyClass
   ^MeasurableResTransaction</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>Multaaofornecedor</name>
<environment>Oficinacarrao</environment>
<super>GREN.FineRate</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>


<class>
<name>Fornecedor</name>
<environment>Oficinacarrao</environment>
<super>GREN.DestinationParty</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>cidade telefone fax </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Fornecedor class</class-id> <category>classReferences</category>

<body>guiForm   
	    ^Oficinacarrao.FornecedorForm</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.Fornecedor</class-id> <category>SQLClauses</category>

<body>insertionFieldClause 
	    ^super insertionFieldClause,' ,cidade ,telefone ,fax'</body>

<body>insertionValueClause 
	    ^super insertionValueClause , ',', self cidade printString, ',', self telefone printString, ',', self fax printString</body>

<body>updateSetClause
	    ^super updateSetClause,', cidade = ' ,self cidade printString,', telefone = ' ,self telefone printString,', fax = ' ,self fax printString</body>
</methods>

<methods>
<class-id>Oficinacarrao.Fornecedor</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 cidade := ''.
					 telefone := ''.
					 fax := ''</body>

<body>initialize: aRow index: anIndex
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	
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
<class-id>Oficinacarrao.Fornecedor</class-id> <category>accessing</category>

<body>cidade
	^cidade</body>

<body>cidade: newcidade
	self update: 'cidade' to: newcidade.
	self changed: #cidade.
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
<name>PecausadanoconsertoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.MaintenancePartForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.PecausadanoconsertoForm class</class-id> <category>classReferences</category>

<body>maintenancePartClass
	    ^Oficinacarrao.Pecausadanoconserto</body>
</methods>

<methods>
<class-id>Oficinacarrao.PecausadanoconsertoForm class</class-id> <category>interface specs</category>

<body>partDescriptionLabel
	    ^'Peca'</body>

<body>partsUsedLabel
	    ^'Pecas'</body>

<body>windowLabel   
	    ^'Peca usada no conserto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>JurosdofornecedorForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.InterestRateForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.JurosdofornecedorForm class</class-id> <category>classReferences</category>

<body>rateClass
	    ^Oficinacarrao.Jurosdofornecedor</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->



<class>
<name>VeiculoForm</name>
<environment>Oficinacarrao</environment>
<super>GREN.SingleResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>ano cor </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>Oficinacarrao</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.VeiculoForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#veiculoSpec</body>

<body>objectClass    
	    ^Oficinacarrao.Veiculo</body>

<body>objectName    
	    ^'Veiculo'</body>

<body>pluralObjectName    
	    ^'Veiculos'</body>

<body>typesCanvasClass
								    ^QualificationForm1</body>

<body>typesSpec
								    ^#resType1Spec</body>
</methods>

<methods>
<class-id>Oficinacarrao.VeiculoForm class</class-id> <category>interface specs</category>

<body>descriptionLabel 
			
			^'Placa'</body>

<body>veiculoSpec
	"UIPainter new openOnClass: self andSelector: #veiculoSpec"

	&lt;resource: #canvas&gt;
	^#(#{UI.FullSpec} 
		#window: 
		#(#{UI.WindowSpec} 
			#label: #windowLabel 
			#bounds: #(#{Graphics.Rectangle} 35 88 763 449 ) ) 
		#component: 
		#(#{UI.SpecCollection} 
			#collection: #(
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 297 190 ) 
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
					#layout: #(#{Graphics.Rectangle} 297 153 744 316 ) 
					#name: #typesCanvas 
					#flags: 0 
					#clientKey: #typesCanvas ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 356 192 ) 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option1Label 
					#select: #available ) 
				#(#{UI.RadioButtonSpec} 
					#layout: #(#{Core.Point} 467 192 ) 
					#model: #status 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) 
					#label: #option2Label 
					#select: #nonAvailable ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 295 277 ) 
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
					#layout: #(#{Core.Point} 300 226 ) 
					#name: #anoLabel 
					#label: 'Ano' ) 
				#(#{UI.LabelSpec} 
					#layout: #(#{Core.Point} 423 227 ) 
					#name: #corLabel 
					#label: 'Cor' ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 335 225 383 249 ) 
					#name: #ano 
					#model: #ano 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) 
				#(#{UI.InputFieldSpec} 
					#layout: #(#{Graphics.Rectangle} 453 225 551 252 ) 
					#name: #cor 
					#model: #cor 
					#callbacksSpec: 
					#(#{UI.UIEventCallbackSubSpec} 
						#valueChangeSelector: #changedInputData ) ) ) ) )</body>

<body>windowLabel   
	    ^'Veiculo'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>Oficinacarrao.VeiculoForm</class-id> <category>aspects</category>

<body>ano
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #ano.
		^adaptor</body>

<body>cor
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #cor.
		^adaptor</body>
</methods>

<methods>
<class-id>Oficinacarrao.VeiculoForm</class-id> <category>initialize-release</category>

<body>initialize
	    super initialize.
					 ano := '' asValue.
					 cor := '' asValue</body>
</methods>



</st-source>
