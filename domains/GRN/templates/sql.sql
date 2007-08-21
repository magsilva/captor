<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="text"/>

  <xsl:include href="lib/sql/header.xsl"/>
  <xsl:include href="lib/sql/footer.xsl"/>
  <xsl:include href="lib/sql/begin_table.xsl"/>
  <xsl:include href="lib/sql/p1v1.xsl"/>
  <xsl:include href="lib/sql/p1v2.xsl"/>
  <xsl:include href="lib/sql/p1v3.xsl"/>
  <xsl:include href="lib/sql/p2v2.xsl"/>
  <xsl:include href="lib/sql/p4v1.xsl"/>
  <xsl:include href="lib/sql/p11v1.xsl"/>
  <xsl:include href="lib/sql/variables.xsl"/>

  <!--___Variaveis___________________________________________________________-->
  
  <xsl:variable name="newline">
<xsl:text>  
</xsl:text>  
  </xsl:variable>
  
  <xsl:variable name="char_type"><xsl:text>char</xsl:text></xsl:variable>

  <!--___Raiz________________________________________________________________-->

  <xsl:template match="/">
    <xsl:call-template name="header"/>
        
		<!--Padrao 1.1-->
		<xsl:if test="/formsData/forms/form/@id='1.1'">
			<xsl:call-template name="p1v1"/>
		</xsl:if>
		
		<!--Padrao 1.2-->
		<xsl:if test="/formsData/forms/form/@id='1.2'">
			<xsl:call-template name="p1v2"/>
		</xsl:if>
		
		<!--Padrao 1.3-->
		<xsl:if test="/formsData/forms/form/@id='1.3'">
			<xsl:call-template name="p1v3"/>
		</xsl:if>
		
		<!--Padrao 2.2-->
		<xsl:if test="/formsData/forms/form/form/@id='2.2'">
			<xsl:call-template name="p2v2"/>
		</xsl:if>
		
		<!--Padrao 4.1-->
		<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
			<xsl:call-template name="p4v1"/>
		</xsl:if>
		
		<!--Padrao 11.1-->
		<xsl:if test="/formsData/forms/form/form/form/form/@id='11.1'">
			<xsl:call-template name="p11v1"/>
		</xsl:if>
        
    <xsl:call-template name="footer"/>
    
  </xsl:template>
  
  <!--___/Raiz________________________________________________________________-->
  
</xsl:stylesheet> 

