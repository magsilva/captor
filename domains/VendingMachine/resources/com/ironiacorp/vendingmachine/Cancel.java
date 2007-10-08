package com.ironiacorp.vendingmachine;

import java.math.BigDecimal;

import com.ironiacorp.vendingmachine.money.Money;

public class Cancel extends State
{
	public Cancel(VendingMachine vm)
	{
		super(vm);
	}

	@Override
	public void cancel()
	{
		if (vm.dispenserMoney.compareTo(BigDecimal.ZERO) == 0) {
			System.out.println("Sorry, there is nothing to be cancelled here.");
		} else {
			vm.dispenserMoney = BigDecimal.ZERO;
			System.out.println("Please, take your money in the dispenser.");
		}
		vm.setState(new Idle(vm));
	}

	@Override
	public void chooseProduct(Product product)
	{
		System.out.println("Sorry, too late to choose a product, your order has already been cancelled.");
		vm.setState(new Idle(vm));
	}

	@Override
	public void insertMoney(Money money)
	{
		System.out.println("Sorry, too late to insert money, your order has already been cancelled.");
		vm.setState(new Idle(vm));
	}
}
