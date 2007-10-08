package com.ironiacorp.vendingmachine;

import java.math.BigDecimal;
import java.util.HashMap;

import com.ironiacorp.vendingmachine.money.*;
import com.ironiacorp.vendingmachine.product.*;

/**
 * Vending machine, as described at "http://publib.boulder.ibm.com/infocenter/dmndhelp/v6rxmx/index.jsp?topic=/com.ibm.wbit.sample.tech.1.doc/bsmvend/topics/ssample.html"
 */
public class VendingMachine
{
	HashMap<Product, Integer> products;
	
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
		products = new HashMap<Product, Integer>();
		products.put(new Coke(), 10);
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

	public static void main(String[] args)
	{
		VendingMachine vm = new VendingMachine();
		vm.insertMoney(new Coin10());
		vm.insertMoney(new Coin5());
		vm.insertMoney(new Coin25());
		vm.insertMoney(new Coin50());
		vm.insertMoney(new Coin25());
		vm.chooseProduct(new Coke());
	}
}
