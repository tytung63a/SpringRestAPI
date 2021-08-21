package com.vn.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vn.service.ProductService;

@Controller
public class HomePageController {

	@Autowired
	private ProductService productService;

	@GetMapping("/homepage")
	public String homePage(Model model) {
		try {
			model.addAttribute("list", productService.readAll());
			model.addAttribute("obj", productService.readAll().get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "home/homePage";

	}

}
