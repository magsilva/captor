<?xml version="1.0"?>

<st-source>
<time-stamp>From VisualWorks® NonCommercial, Release 5i.4 of 9 de Agosto de 2001 on 23 de Setembro de 2002 at 5:53:49 pm</time-stamp>


<class>
<name>Estadocivil</name>
<environment>GRENWizard</environment>
<super>GREN.DiscreteList</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category>GREN-Wizard</category>
</class>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>GRENWizard.Estadocivil class</class-id> <category>instance creation</category>

<body>new
	^super new initialize</body>
</methods>

<!-- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -->


<methods>
<class-id>GRENWizard.Estadocivil</class-id> <category>initialize-release</category>

<body>initialize
	| ec estadocivil |
	estadocivil := List new.
	
	ec := GREN.StaticObject new.
	ec idCode: 1.
	ec description: 'Solteiro'.
	estadocivil add: ec.
	ec := GREN.StaticObject new.
	ec idCode: 2.
	ec description: 'Casado'.
	estadocivil add: ec.
	self values: estadocivil</body>
</methods>



</st-source>
