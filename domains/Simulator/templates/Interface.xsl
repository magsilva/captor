<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:import href="lib/string.xsl" />
	<xsl:output method="text"/>
	<xsl:param name="current" />
	
	<xsl:variable name="appName">
		<xsl:value-of select="/formsData/forms/form[@id='1.1']/data/textatt[@name='name']"/>
	</xsl:variable>

	<xsl:variable name="appPackageName">
		<xsl:call-template name="str:to-lower">
			<xsl:with-param name="text" select="$appName"/>
		</xsl:call-template>
	</xsl:variable>

	<xsl:variable name="interfaceName">
		<xsl:value-of select="$current/form/data/textatt[@name='name']"/>
	</xsl:variable>

	<!-- Operations -->
	<xsl:template match="form[@id='5.1']/data">
		void <xsl:text> </xsl:text> <xsl:value-of select="textatt[@name='name']" />(<xsl:apply-templates select="table" />);
	</xsl:template>

	<!-- Operations arguments -->
	<xsl:template match="row">
		<xsl:if test="@number='0'">
			<xsl:value-of select="col[@number='1']/value" /><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value" /> 
		</xsl:if>
		<xsl:if test="@number!='0'">
			<xsl:text>, </xsl:text><xsl:value-of select="col[@number='1']/value" /><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value" /> 
		</xsl:if>
	</xsl:template>

	<!-- Attributes -->
	<xsl:template match="form[@id='6.1']/data">
		<xsl:variable name="attribute">
			<xsl:call-template name="str:capitalise">
				<xsl:with-param name="text" select="textatt[@name='name']"/>
			</xsl:call-template>
		</xsl:variable>
	
		<xsl:value-of select="textatt[@name='type']" /><xsl:text> </xsl:text>get<xsl:value-of select="$attribute" />();
		void <xsl:text> </xsl:text>set<xsl:value-of select="$attribute" />(<xsl:value-of select="textatt[@name='type']" /><xsl:text> </xsl:text><xsl:value-of select="textatt[@name='name']"/>);
	</xsl:template>
 
	<xsl:template match="/">
package com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>;

public interface <xsl:value-of select="$interfaceName"/>
{
	<xsl:apply-templates select="$current/form/form[@id='5.1']" />

	<xsl:apply-templates select="$current/form/form[@id='6.1']" />
}
	</xsl:template>
</xsl:stylesheet>