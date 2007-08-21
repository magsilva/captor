<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 27 de Julho de 2005 at 3:33:10 pm</time-stamp>


<class>
<name>Marca1</name>
<environment>T2</environment>
<super>GREN.SimpleType</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars>aaa bbb ccc ddd </inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>T2</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T2.Marca1 class</class-id> <category>classReferences</category>

<body>typeClasses  
	^List new</body>

<body>typeForms  
	^List new</body>
</methods>

<methods>
<class-id>T2.Marca1 class</class-id> <category>SQLClauses</category>

<body>typeFields  
	^List new</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>T2.Marca1</class-id> <category>accessing</category>

<body>aaa
	^aaa</body>

<body>aaa: newaaa
	self update: 'aaa' to: newaaa.
	self changed: #aaa.
	self isChanged: true.</body>

<body>bbb
	^bbb</body>

<body>bbb: newbbb
	self update: 'bbb' to: newbbb.
	self changed: #bbb.
	self isChanged: true.</body>

<body>ccc
	^ccc</body>

<body>ccc: newccc
	self update: 'ccc' to: newccc.
	self changed: #ccc.
	self isChanged: true.</body>

<body>ddd
	^ddd</body>

<body>ddd: newddd
	self update: 'ddd' to: newddd.
	self changed: #ddd.
	self isChanged: true.</body>
</methods>

<methods>
<class-id>T2.Marca1</class-id> <category>SQLClauses</category>

<body>insertionFieldClause
								^super insertionFieldClause,' ,aaa ,bbb ,ccc ,ddd'</body>

<body>insertionValueClause 
			    ^super insertionValueClause, ',', self aaa printString, ',', self bbb printString, ',', self ccc printString, ',', self ddd printForSaving</body>

<body>updateSetClause
			    ^super updateSetClause,', aaa = ' ,self aaa printString,', bbb = ' ,self bbb printString,', ccc = ' ,self ccc printString,', ddd = ' ,self ddd printForSaving</body>
</methods>

<methods>
<class-id>T2.Marca1</class-id> <category>initialize-release</category>

<body>initialize
			    super initialize.
					 aaa := ''.
					 bbb := 0.
					 ccc := 0.00.
					 ddd := Date today</body>

<body>initialize: aRow index: anIndex 
			    | newIndex |
				newIndex := super initialize: aRow index: anIndex.
				newIndex := newIndex + 1.
				self aaa: (aRow at: newIndex).
				self aaa isNil ifTrue: [self aaa: ' '].
				newIndex := newIndex + 1.
				self bbb: (aRow at: newIndex).
				newIndex := newIndex + 1.
				self ccc: (aRow at: newIndex).
				newIndex := newIndex + 1.
				self ddd: (aRow at: newIndex).self isChanged: false.
			^newIndex + 1</body>
</methods>



</st-source>
