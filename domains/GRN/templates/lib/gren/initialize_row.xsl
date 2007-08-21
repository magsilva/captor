<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineInitializeRow">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
initialize: aRow index: anIndex 
	| newIndex |
	newIndex := super initialize: aRow index: anIndex.
	newIndex := newIndex + 1.
	self porta: (aRow at: newIndex).
	self cor: (aRow at: newIndex+1).
	self isChanged: false.
	^newIndex+2
	-->
	<xsl:template name="initialize_row">
		
		<xsl:param name="attributes"/>
		
		<xsl:value-of select="$newlineInitializeRow"/>
		
<body>initialize: aRow index: anIndex 
		| newIndex |
		newIndex := super initialize: aRow index: anIndex.
		newIndex := newIndex + 1.
		<xsl:for-each select="attributes/attribute">
		self <xsl:value-of select="name"/>: (aRow at: newIndex+ <xsl:value-of select="position() - 1"/>).
		<xsl:if test="type='char'">
		self <xsl:value-of select="name"/> isNil ifTrue: [self <xsl:value-of select="name"/>: ' '].
	  </xsl:if></xsl:for-each>
		self isChanged: false.
		<xsl:for-each select="attributes/attribute">
		<xsl:if test="position()=last()">
		^newIndex+<xsl:value-of select="position()"/>
		</xsl:if>
		
		</xsl:for-each></body>

		<xsl:value-of select="$newlineInitializeRow"/>		
		
	</xsl:template>

</xsl:stylesheet>