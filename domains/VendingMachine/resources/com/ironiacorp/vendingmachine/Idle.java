package com.ironiacorp.vendingmachine;

import com.ironiacorp.vendingmachine.money.Money;


public class Idle extends State
{
	public Idle(VendingMachine vm)
	{
		super(vm);
	}

	@Override
	public void cancel()
	{
		vm.setState(new Cancel(vm));
		vm.cancel();
	}

	@Override
	public void chooseProduct(Product product)
	{
		System.out.println("Please, insert money first.");
	}

	@Override
	public void insertMoney(Money money)
	{
		vm.setState(new MoneyInput(vm));
		vm.insertMoney(money);
	}
}
