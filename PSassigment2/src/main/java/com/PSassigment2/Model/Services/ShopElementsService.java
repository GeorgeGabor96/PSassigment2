package com.PSassigment2.Model.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.PSassigment2.Model.Entities.Category;
import com.PSassigment2.Model.Entities.Product;
import com.PSassigment2.Model.Entities.ShopElement;

@Controller
public class ShopElementsService {

	public List<ShopElement> getShopElements()
	{
		List<ShopElement> shopElements = new ArrayList<>();
		
		Category shoes = new Category("Shoes");
		Category shirt = new Category("Shirt");
		shopElements.add(shoes);
		shopElements.add(shirt);
		
		Product nickShoe = new Product("Nick shoe", 100);
		Product adidasShoe = new Product("Adidas shoe", 140);
		shoes.addElement(nickShoe);
		shoes.addElement(adidasShoe);
		
		Product hmShirt = new Product("H&M shirt", 100);
		shirt.addElement(hmShirt);
		
		return shopElements;
	}
	
}
