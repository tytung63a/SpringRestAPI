package com.vn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/homepage")
	public String getHome() {
		return "hello home page";
	}
}
