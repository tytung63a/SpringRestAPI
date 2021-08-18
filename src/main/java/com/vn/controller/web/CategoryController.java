package com.vn.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.service.CategoryService;
import com.vn.vo.CategoryVO;

@Controller(value = "admin_categories")
@RequestMapping("/admin/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String listCategory(Model model) {
		try {
			model.addAttribute("list", categoryService.readAll());
			model.addAttribute("obj", categoryService.readAll().get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("title", "List Categories");
		return "admin/categories/list";
	}

	@GetMapping("/create")
	public String viewCategory(Model model) {
		model.addAttribute("categoryForm", new CategoryVO());
		model.addAttribute("title", "Create Product");
		return "admin/categories/create";
	}

	@PostMapping("/create")
	public String saveCategory(@Validated @ModelAttribute("categoryForm") CategoryVO vo, BindingResult bindingResult,
			Model model, RedirectAttributes rAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/categories/create";
		} else {
			categoryService.create(vo);
			rAttributes.addFlashAttribute("message", "Create Category is successfuly with id: " + vo.getId());
			return "redirect:/admin/categories";
		}

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes rAttributes) {
		try {
			categoryService.delete(id);
			rAttributes.addFlashAttribute("message", "Delete Category is successfuly with id: " + id);
			return "redirect:/admin/categories";
		} catch (Exception e) {
			rAttributes.addFlashAttribute("message", "Delete Category failed, please Delete Product first");
			return "redirect:/admin/categories";
		}
	}

	@GetMapping("/edit/{id}")
	public String editView(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("categoryForm", categoryService.detail(id));
		model.addAttribute("title", "Edit Product");
		return "admin/categories/edit";
	}

	@PostMapping("/edit/{id}")
	public String editCategory(@Validated @ModelAttribute("categoryForm") CategoryVO vo, 
			BindingResult bindingResult, RedirectAttributes rAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "admin/categories/edit";
		} else {
			categoryService.update(vo);
			rAttributes.addFlashAttribute("message", "Edit Category is successfuly with id: " + vo.getId());
			return "redirect:/admin/categories";
		}

	}
}
