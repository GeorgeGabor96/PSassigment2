package com.PSassigment2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllera {
	
	@RequestMapping("/add")
	public String r()
	{
		System.out.println(123);
		return "index.jsp";
	}
}
