<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:import href="lib/string.xsl" />

	<xsl:output method="text"/>

	<!-- General purpose functions -->
	<xsl:template name="replace-string">
		<xsl:param name="text"/>
		<xsl:param name="replace"/>
		<xsl:param name="with"/>
		<xsl:choose>
			<xsl:when test="contains($text,$replace)">
				<xsl:value-of select="substring-before($text,$replace)"/>
				<xsl:value-of select="$with"/>
				<xsl:call-template name="replace-string">
					<xsl:with-param name="text" select="substring-after($text,$replace)"/>
					<xsl:with-param name="replace" select="$replace"/>
					<xsl:with-param name="with" select="$with"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$text"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- End of general purpose functions -->

	<xsl:variable name="faceValue">
		<xsl:value-of select="/formsData/current/form/data/textatt[@name='faceValue']"/>
	</xsl:variable>

	<xsl:variable name="className">
		<xsl:value-of select="/formsData/current/form/data/textatt[@name='name']"/>
	</xsl:variable>


	<xsl:template match="/">
package com.ironiacorp.vendingmachine.money;

import java.math.BigDecimal;

public class <xsl:value-of select="$className" />
{
	@Override
	public BigDecimal value()
	{
		return new BigDecimal("<xsl:value-of select="$faceValue" />");
	}
}

	</xsl:template>
</xsl:stylesheet>