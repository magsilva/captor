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

	<xsl:variable name="objectType">
		<xsl:value-of select="/formsData/forms/form[@id='1.1']/data/textatt[@name='type']"/>
	</xsl:variable>

	<xsl:variable name="object">
		<xsl:value-of select="$current/form/data/textatt[@name='name']"/>
	</xsl:variable>

	<xsl:variable name="objectInterfaces">
		<xsl:variable name="list">
			<xsl:for-each select="$current/form/form[@id='3.1']">
				<xsl:value-of select="data/textatt[@name='name']" /><xsl:text>, </xsl:text>
			</xsl:for-each>
		</xsl:variable>
		
		<xsl:call-template name="str:substring-before-last">
			<xsl:with-param name="text" select="$list" />
			<xsl:with-param name="chars">,</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	
	
	<!-- Operations -->
 	<xsl:template match="form[@id='5.1']/data">
		public void <xsl:text> </xsl:text> <xsl:value-of select="textatt[@name='name']" />(<xsl:apply-templates select="table" />)
		{
			currentState.<xsl:value-of select="textatt[@name='name']" />(<xsl:apply-templates select="table" />);
		}
	</xsl:template>
 	
	<!-- Operations arguments (signature) -->
	<xsl:template match="row">
		<xsl:if test="@number='0'">
			<xsl:value-of select="col[@number='1']/value" /><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value" /> 
		</xsl:if>
		<xsl:if test="@number!='0'">
			<xsl:text>, </xsl:text><xsl:value-of select="col[@number='1']/value" /><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value" /> 
		</xsl:if>
	</xsl:template>

	<!--  Operation arguments (call) -->
	<xsl:template match="row/col[@number='2']">
		<xsl:if test="@number='0'">
			<xsl:text> </xsl:text><xsl:value-of select="col[@number='2']/value" /> 
		</xsl:if>
		<xsl:if test="@number!='0'">
			<xsl:text>, </xsl:text><xsl:value-of select="col[@number='2']/value" /> 
		</xsl:if>
	</xsl:template>


	<!-- Attributes -->
	<xsl:template match="form[@id='6.1']/data">
		<xsl:variable name="attribute">
			<xsl:call-template name="str:capitalise">
				<xsl:with-param name="text" select="textatt[@name='name']"/>
			</xsl:call-template>
		</xsl:variable>
	
		<xsl:text>public </xsl:text><xsl:value-of select="textatt[@name='type']" /><xsl:text> </xsl:text>get<xsl:value-of select="$attribute" />()
		{
			return <xsl:value-of select="textatt[@name='name']" />;
		}
		
		
		<xsl:text>public void set</xsl:text><xsl:value-of select="$attribute" />(<xsl:value-of select="textatt[@name='type']" /><xsl:text> </xsl:text><xsl:value-of select="textatt[@name='name']"/>)
		{
			this.<xsl:value-of select="textatt[@name='name']" /> = <xsl:value-of select="textatt[@name='name']" />; 
		}
	</xsl:template>
	
	<xsl:template match="form[@id='3.1']">
		<xsl:apply-templates select="form[@id='5.1']" />

		<xsl:apply-templates select="form[@id='6.1']" />
	</xsl:template>

	<xsl:template match="form[@id='7.1']">
		addState(<xsl:value-of select="data/textatt[@name='name']" />.class);
	</xsl:template>
	

	
	<xsl:template match="/">
package com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>;

import com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.state.<xsl:value-of select="$object"/>.*;
import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class <xsl:value-of select="$object"/> extends ContextInState&lt;<xsl:value-of select="$objectType"/>State 
implements <xsl:value-of select="$objectInterfaces" />
{
	
	
	
 
 
	<xsl:apply-templates select="$current/form/form[@id='3.1']" />
	
	public <xsl:value-of select="$object"/>()
	{
		<xsl:apply-templates select="$current/form/form/form[@id='7.1']" />
		
		<xsl:for-each select="$current/form/form[@id='4.1']/data/table[@id='finalState']/row">
			addFinalState(<xsl:value-of select="col/value" />.class);
		</xsl:for-each>


		setStartState(<xsl:value-of select="$current/form/form[@id='4.1']/data/textatt[@name='initialState']" />.class);
			
		start();
	}
}
	</xsl:template>
</xsl:stylesheet>