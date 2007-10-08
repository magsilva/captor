package com.ironiacorp.vendingmachine;

import com.ironiacorp.vendingmachine.money.Money;

public class MoneyInput extends State
{
	public MoneyInput(VendingMachine vm)
	{
		super(vm);
	}

	public void insertMoney(Money money)
	{
		vm.dispenserMoney = vm.dispenserMoney.add(money.value());
		System.out.println("Total money inserted: " + vm.dispenserMoney);
	}

	@Override
	public void cancel()
	{
		vm.setState(new Cancel(vm));
	}

	@Override
	public void chooseProduct(Product product)
	{
		vm.setState(new ProductDispensing(vm));
		vm.chooseProduct(product);
	}

}
