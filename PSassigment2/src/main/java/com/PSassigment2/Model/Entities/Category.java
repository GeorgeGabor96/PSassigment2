package com.PSassigment2.Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Category extends ShopElement{
	
	private List<ShopElement> elements;
	
	public Category(String name) {
		super(name);
		elements = new ArrayList<>();
	}

	@Override
	public void show()
	{
		System.out.println(this);
		for(ShopElement element: elements)
		{
			element.show();
		}
	}
	
	public void addElement(ShopElement element)
	{
		elements.add(element);
	}
	
	public void removeElement(ShopElement element)
	{
		elements.remove(element);
	}

	@Override
	public String toString() {
		return "Category [toString()=" + super.toString() + "]";
	}
}
