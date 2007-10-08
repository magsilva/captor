package com.ironiacorp.vendingmachine;

import java.math.BigDecimal;
import java.util.Set;

import com.ironiacorp.vendingmachine.money.Money;

public class ProductDispensing extends State
{
	public ProductDispensing(VendingMachine vm)
	{
		super(vm);
	}

	private Product findEqProduct(Product product)
	{
		Set<Product> products = vm.products.keySet();
		for (Product p : products) {
			if (p.getClass() == product.getClass()) {
				if (vm.products.get(p) > 0) {
					return p;
				}
			}
		}
		return null;
	}
	
	@Override
	public void cancel()
	{
		System.out.println("Sorry, your order has already been processed and cannot be cancelled now.");
	}

	@Override
	public void chooseProduct(Product product)
	{
		System.out.println("You choose the product " + product.getClass().getSimpleName());
		
		Product eqProduct = findEqProduct(product);
		
		if (vm.dispenserMoney.compareTo(product.getPrice()) < 0) {
			System.out.println("Sorry, the product you choose cost more than the amount inserted in the machine.");
		} else if (eqProduct == null || vm.products.get(eqProduct) == 0) {
			System.out.println("Sorry, the product you choose is out of stock. Please, pick another choice.");
		} else {
			BigDecimal change = vm.dispenserMoney.subtract(product.getPrice());
			vm.dispenserMoney = vm.dispenserMoney.subtract(change);
			vm.products.put(eqProduct, vm.products.get(eqProduct) - 1);
			vm.safeMoney.add(vm.dispenserMoney);
			vm.dispenserMoney = BigDecimal.ZERO;
			if (change.compareTo(BigDecimal.ZERO) > 0) {
				System.out.println("Please, take your product and change (" + change + ") in the dispenser.");
			} else {
				System.out.println("Please, take your product in the dispenser.");
			}
			vm.setState(new Idle(vm));
		}
	}

	@Override
	public void insertMoney(Money money)
	{
		vm.setState(new MoneyInput(vm));
		vm.insertMoney(money);
	}
}
