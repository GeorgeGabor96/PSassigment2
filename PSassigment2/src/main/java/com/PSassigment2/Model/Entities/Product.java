package com.PSassigment2.Model.Entities;

public class Product extends ShopElement{

	private int price;
	
	public Product(String name, int price) {
		super(name);
		this.price = price;
	}

	@Override
	public void show() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", toString()=" + super.toString() + "]";
	}
}
