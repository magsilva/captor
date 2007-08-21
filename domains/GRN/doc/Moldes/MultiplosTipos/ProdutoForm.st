<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 26 de Julho de 2005 at 5:37:26 pm</time-stamp>


<class>
<name>ProdutoForm</name>
<environment>T1</environment>
<super>GREN.SingleResourceForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>aaa bbb ccc ddd </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>T1</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T1.ProdutoForm class</class-id> <category>classReferences</category>

<body>guiSpec 
	    ^#produtoSpec</body>

<body>objectClass    
	    ^T1.Produto</body>

<body>objectName    
	    ^'Produto'</body>

<body>pluralObjectName    
	    ^'Produtos'</body>

<body>typesCanvasClass
								    ^QualificationForm2</body>

<body>typesSpec
								    ^#resType2Spec</body>
</methods>

<methods>
<class-id>T1.ProdutoForm class</class-id> <category>interface specs</category>

<body>produtoSpec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #bounds: #(#{Graphics.Rectangle} 22 56 750 417)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 213) #label: #statusLabel) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 488 76 588 103) #name: #storageBt #model: #storageBt #helpText: 'Details about storage' #label: #(#{Kernel.UserMessage} #key: #storageBt #defaultString: 'Storage...') #defaultable: true) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 12 58) #label: #listLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 297 80) #label: #idCodeLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 297 116) #label: #descriptionLabel) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 265 7 593 48)) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 6 7 230 47)) #(#{UI.SequenceViewSpec} #layout: #(#{Graphics.Rectangle} 10 83 285 321) #name: #allStaticObjects #model: #allStaticObjects #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #requestFocusInSelector: #changeRequest) #useModifierKeys: true #selectionType: #highlight) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 12 13 225 44) #name: #navigationBtns #flags: 0 #clientKey: #navigationBtns) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 271 14 591 48) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 394 77 457 103) #name: #idCodeField #flags: 40 #model: #w_idCode #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 393 116 647 141) #name: #descriptionField #model: #w_description #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 295 151 742 314) #name: #typesCanvas #flags: 0 #clientKey: #typesCanvas) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 354 215) #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option1Label #select: #available) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 465 215) #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option2Label #select: #nonAvailable) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 295 276) #name: #costLabel #flags: 16 #label: #costLabel) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 397 276 480 302) #name: #costField #flags: 24 #model: #cost #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 503 276) #name: #salePriceLabel #flags: 16 #label: #salePriceLabel) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 600 276 683 302) #name: #salePriceField #flags: 24 #model: #salePrice #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 300 300) #name: #aaaLabel #label: 'Aaa') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 300 330) #name: #bbbLabel #label: 'Bbb') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 300 360) #name: #cccLabel #label: 'Ccc') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 300 390) #name: #dddLabel #label: 'Ddd') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 380 300 550 325) #name: #aaa #model: #aaa #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 380 330 550 355) #name: #bbb #model: #bbb #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 380 360 550 385) #name: #ccc #model: #ccc #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 380 390 550 415) #name: #ddd #model: #ddd #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy'))))</body>

<body>windowLabel   
	    ^'Produto'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T1.ProdutoForm</class-id> <category>aspects</category>

<body>aaa
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #aaa.
		^adaptor</body>

<body>bbb
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #bbb.
		^adaptor</body>

<body>ccc
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #ccc.
		^adaptor</body>

<body>ddd
		| adaptor |
		adaptor := AspectAdaptor subjectChannel: self aStaticObject.
		adaptor forAspect: #ddd.
		^adaptor</body>
</methods>

<methods>
<class-id>T1.ProdutoForm</class-id> <category>initialize-release</category>

<body>initialize 
			    super initialize.
					 aaa := '' asValue.
					 bbb := 0 asValue.
					 ccc := 0.00 asValue.
					 ddd := Date today asValue</body>
</methods>



</st-source>
