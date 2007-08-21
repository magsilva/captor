<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 23 de Setembro de 2002 at 5:53:42 pm</time-stamp>


<class>
<name>Podeseralugado</name>
<environment>GRENWizard</environment>
<super>GREN.DiscreteList</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>GREN-Wizard</category>
</class>

<methods>
<class-id>GRENWizard.Podeseralugado</class-id> <category>initialize-release</category>

<body>initialize
	| so element |
	element := List new.
	
	so := GREN.StaticObject new.
	so idCode: 1.
	so description: 'Sim'.
	element add: so.
	so := GREN.StaticObject new.
	so idCode: 2.
	so description: 'Nao'.
	element add: so.
	self values: element</body>
</methods>



</st-source>
