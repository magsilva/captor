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

	<xsl:variable name="object">
		<xsl:value-of select="$current/form/data/textatt[@name='name']" />
	</xsl:variable>

	<xsl:variable name="state">
		<xsl:value-of select="$current/form/data/textatt[@name='name']" />
	</xsl:variable>


	<xsl:template match="/">
package com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.state.<xsl:value-of select="$object" />;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class <xsl:value-of select="$state"/> extends <xsl:value-of select="$object"/>State
{
	public <xsl:value-of select="$state"/>(ContextInState&lt;? extends IntrusiveState&gt; sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
	}

	public void throttle(double percent)
	{
	}
}

	</xsl:template>
</xsl:stylesheet>
