<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:output method="text"/>

	<xsl:template match="textatt[@name='name']">
		products.put(new <xsl:value-of select="."/>(), 10);
	</xsl:template>

	<xsl:template match="data">
		<xsl:apply-templates select="./textatt[@name='name']" />
	</xsl:template>

	<xsl:template match="/">
package com.ironiacorp.vendingmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import com.ironiacorp.vendingmachine.money.*;
import com.ironiacorp.vendingmachine.product.*;

/**
 * Vending machine, as described at "http://publib.boulder.ibm.com/infocenter/dmndhelp/v6rxmx/index.jsp?topic=/com.ibm.wbit.sample.tech.1.doc/bsmvend/topics/ssample.html"
 */
public class VendingMachine
{
	HashMap&lt;Product, Integer&gt; products;
	
	BigDecimal safeMoney;
	
	BigDecimal dispenserMoney;

	State currentState;

	public void setState(State state)
	{
		System.out.println("Changing from state " + this.currentState.getClass().getSimpleName() + " to " + state.getClass().getSimpleName());
		this.currentState = state;
	}
	
	public State getState()
	{
		return currentState;
	}
	
	
	public VendingMachine()
	{
		products = new HashMap&lt;Product, Integer&gt;();
		<xsl:apply-templates select="//form[@id='2.1']"/>		
		safeMoney = BigDecimal.ZERO;
		dispenserMoney = BigDecimal.ZERO;
		currentState = new Idle(this);
	}

	public void insertMoney(Money money)
	{
		currentState.insertMoney(money);
	}
	
	public void chooseProduct(Product product)
	{
		currentState.chooseProduct(product);
	}
	
	public void cancel()
	{
		currentState.cancel();
	}

	// START-SAFE
	public static void main(String[] args)
	{
		VendingMachine vm = new VendingMachine();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		do {
			try {
				input = in.readLine();
			} catch (IOException ioe) {
				System.out.println("Invalid command, try again");
			}
			
			if (input.startsWith("insert ")) {
				try {
					Class clazz = Class.forName(input.replaceFirst("insert ", "com.ironiacorp.vendingmachine.money."));
					Money money = (Money) clazz.newInstance();
					vm.insertMoney(money);		
				} catch (Exception e) {
					System.out.println("Sorry, I cannot accept this money.");
				}
			} else if (input.startsWith("choose ")) {
				try {
					Class clazz = Class.forName(input.replaceFirst("choose ", "com.ironiacorp.vendingmachine.product."));
					Product product = (Product) clazz.newInstance();
					vm.chooseProduct(product);
				} catch (Exception e) {
					System.out.println("Sorry, I do not have this one.");
				}
			} else {
				System.out.println("Unknown command.");
			}
		} while (! input.equals("exit"));
	}
	// END-SAFE
}

	</xsl:template>
</xsl:stylesheet>