<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
	<xsl:output method="text"/>
  

	<xsl:template name="header">
	
<!--use DATABASE_NAME;-->

#Apagar o banco de dados
DROP DATABASE IF EXISTS <xsl:value-of select="/formsData/project/name"/>;

#Criando o banco de dados
CREATE DATABASE IF NOT EXISTS <xsl:value-of select="/formsData/project/name"/>;

USE <xsl:value-of select="/formsData/project/name"/>;

  	<xsl:text>

#Tabela de idCodes
drop table IF EXISTS IdCode; 
	
create table IF NOT EXISTS  IdCode (
			className char(35),
			lastIdCode integer);
</xsl:text></xsl:template>

</xsl:stylesheet> 

