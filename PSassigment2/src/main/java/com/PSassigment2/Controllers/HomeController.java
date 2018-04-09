package com.PSassigment2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PSassigment2.Model.Entities.ShopElement;
import com.PSassigment2.Model.Services.ShopElementsService;

@Controller
public class HomeController {
	
	@Autowired
	private ShopElementsService shopElementService;
	
	@RequestMapping("/pickAdmin")
	public ModelAndView chooseAdmin()
	{
		List<ShopElement> shopElements = shopElementService.getShopElements();
		
		return new ModelAndView("admin.jsp", "shopElements", shopElements);
	}
	
	@RequestMapping("/pickUser")
	public String chooseUser()
	{
		return "user.jsp";
	}
}
