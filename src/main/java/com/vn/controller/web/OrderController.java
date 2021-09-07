package com.vn.controller.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entities.Cart;
import com.vn.entities.Product;
import com.vn.service.CartService;
import com.vn.service.ProductService;

@Controller
@RequestMapping("shoppingcart")
public class OrderController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("view")
	public String view(Model model) {
		model.addAttribute("list", cartService.getAll());
		model.addAttribute("amount", cartService.getAmount());
		model.addAttribute("count", cartService.getCount());
		return "/product/cartView";
		
	}
	@GetMapping("add/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		Optional<Product> product = productService.findById(id);
		if (product != null) {
			Cart cart = new Cart();
			cart.setProducID(product.get().getId());
			cart.setName(product.get().getName());
			cart.setPrice(product.get().getPrice());
			cart.setQty(1);
			cartService.add(cart);
		}
		return "redirect:/shoppingcart/view";
	}
	
	
	@GetMapping("update")
	public String updateCart(@RequestParam("id") Integer id , @RequestParam("qty") Integer qty) {
			System.err.println(qty);
			cartService.update(id, qty);
		return "redirect:/shoppingcart/view";
	}
	
	@GetMapping("clear")
	public String clear() {
		cartService.clear();
		return "redirect:/shoppingcart/view";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/shoppingcart/view";
	}
}
