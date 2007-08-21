<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 27 de Julho de 2005 at 3:33:13 pm</time-stamp>


<class>
<name>Marca1Form</name>
<environment>T2</environment>
<super>GREN.StaticObjectForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>aaa bbb ccc ddd </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>T2</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T2.Marca1Form class</class-id> <category>classReferences</category>

<body>objectClass    
	    ^T2.Marca1</body>

<body>objectName    
	    ^'Marca1'</body>

<body>pluralObjectName    
	    ^'Marcas1'</body>
</methods>

<methods>
<class-id>T2.Marca1Form class</class-id> <category>interface specs</category>

<body>marca1Spec
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #bounds: #(#{Graphics.Rectangle} 73 130 728 470)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 9 55) #label: #listLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 77) #label: #idCodeLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 113) #label: #descriptionLabel) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 262 4 590 45)) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 3 4 227 44)) #(#{UI.SequenceViewSpec} #layout: #(#{Graphics.Rectangle} 7 80 282 318) #name: #allStaticObjects #model: #allStaticObjects #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #requestFocusInSelector: #changeRequest) #useModifierKeys: true #selectionType: #highlight) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 391 74 454 100) #name: #idCodeField #flags: 40 #model: #w_idCode #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 390 113 644 138) #name: #descriptionField #model: #w_description #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 9 10 222 41) #name: #navigationBtns #flags: 0 #clientKey: #navigationBtns) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 268 11 588 45) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 157) #name: #aaaLabel #label: 'Aaa') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 187) #name: #bbbLabel #label: 'Bbb') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 217) #name: #cccLabel #label: 'Ccc') #(#{UI.LabelSpec} #layout: #(#{Core.Point} 294 247) #name: #dddLabel #label: 'Ddd') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 157 544 182) #name: #aaa #model: #aaa #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 187 544 212) #name: #bbb #model: #bbb #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 217 544 242) #name: #ccc #model: #ccc #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 374 247 544 272) #name: #ddd #model: #ddd #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy'))))</body>

<body>windowLabel   
	    ^'Marca1'</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T2.Marca1Form</class-id> <category>aspects</category>

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
<class-id>T2.Marca1Form</class-id> <category>initialize-release</category>

<body>initialize 
			    super initialize.
					 aaa := '' asValue.
					 bbb := 0 asValue.
					 ccc := 0.00 asValue.
					 ddd := Date today asValue</body>
</methods>



</st-source>
