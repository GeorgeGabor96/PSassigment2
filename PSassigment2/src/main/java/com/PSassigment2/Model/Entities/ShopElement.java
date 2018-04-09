package com.PSassigment2.Model.Entities;

public abstract class ShopElement {
	private String name;
	
	public ShopElement(String name)
	{
		this.name = name;
	}
	
	public abstract void show();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ShopElement [name=" + name + "]";
	}
}
