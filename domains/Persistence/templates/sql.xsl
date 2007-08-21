<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="text"/>

  <!--___Variaveis___________________________________________________________-->
  
  <xsl:variable name="newline">
<xsl:text>  
</xsl:text>  
  </xsl:variable>

  <!--___Raiz________________________________________________________________-->

  <xsl:template match="/">
		<xsl:for-each select="/formsData/forms/form/form/form">
			<xsl:variable name="tableName"><xsl:value-of select="data/textatt[@name='tableName']"/></xsl:variable>

			<xsl:variable name="attrs">
				<xsl:for-each select="data/table/row">
				
					<xsl:if test="position()!=last()">
						<xsl:if test="col[@number='2']/value='String'"><xsl:value-of select="col[@number='1']/value"/><xsl:text> </xsl:text> varchar(30)<xsl:text>, </xsl:text></xsl:if>
						<xsl:if test="col[@number='2']/value='int'"><xsl:value-of select="col[@number='1']/value"/> int,</xsl:if>
					</xsl:if>
					
					<xsl:if test="position()=last()">
						<xsl:if test="col[@number='2']/value='String'"><xsl:value-of select="col[@number='1']/value"/><xsl:text> </xsl:text> varchar(30)<xsl:text></xsl:text></xsl:if>
						<xsl:if test="col[@number='2']/value='int'"><xsl:value-of select="col[@number='1']/value"/> int</xsl:if>
					</xsl:if>
						
				</xsl:for-each>
			</xsl:variable>

drop table IF EXISTS <xsl:value-of select="$tableName"/>; 
CREATE TABLE <xsl:value-of select="$tableName"/> (id int, <xsl:value-of select="$attrs"/>);
		</xsl:for-each>
  </xsl:template>
  
  <!--___/Raiz________________________________________________________________-->
  
</xsl:stylesheet> 

