<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:import href="lib/string.xsl" />

	<xsl:output method="text"/>
	
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

	<xsl:template match="/">
	
package com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.state.<xsl:value-of select="$object" />;

import com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.SpaceShuttle;
import com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.state.<xsl:value-of select="$objectType"/>State;
import com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>.state.<xsl:value-of select="$object"/>.*;
import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public abstract class <xsl:value-of select="$object"/>State extends <xsl:value-of select="$objectType"/>State
{
	<xsl:value-of select="$object"/> obj;

	public <xsl:value-of select="$object"/>State(ContextInState&lt;? extends IntrusiveState&gt; sm)
	{
		super(sm);
		if (! (sm instanceof <xsl:value-of select="$object"/>)) {
			throw new IllegalArgumentException();
		}
		obj = (<xsl:value-of select="$object"/>) sm;
	}
}
	</xsl:template>
</xsl:stylesheet>