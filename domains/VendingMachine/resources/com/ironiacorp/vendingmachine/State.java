package com.ironiacorp.vendingmachine;

import com.ironiacorp.vendingmachine.money.Money;


public abstract class State
{
	protected VendingMachine vm;

	public State(VendingMachine vm)
	{
		this.vm = vm;
	}

	public abstract void insertMoney(Money money);
	
	public abstract void chooseProduct(Product product);
	
	public abstract void cancel();


}
