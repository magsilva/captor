<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:output method="text"/>

	<xsl:variable name="productName">
		<xsl:value-of select="$current/form/data/textatt[@name='name']"/>
	</xsl:variable>

	<xsl:variable name="productPrice">
		<xsl:value-of select="$current/form/data/textatt[@name='price']"/>
	</xsl:variable>

	<xsl:template match="/">
package com.ironiacorp.vendingmachine.product;

import java.math.BigDecimal;
import com.ironiacorp.vendingmachine.Product;

public class <xsl:value-of select="$productName"/> implements Product
{
	public String getName()
	{
		return "<xsl:value-of select="$productName"/>";
	}

	public BigDecimal getPrice()
	{
		return new BigDecimal("<xsl:value-of select="$productPrice"/>");

	}
}
	</xsl:template>

</xsl:stylesheet>