package com.vn.controller.web;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.service.CategoryService;
import com.vn.service.ProductService;
import com.vn.vo.CategoryVO;
import com.vn.vo.ProductVO;

@Controller(value = "admin_products")
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;


	@GetMapping
	public String listCategory(Model model) {
		try {
			model.addAttribute("list", productService.readAll());
			model.addAttribute("obj", productService.readAll().get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("title", "List Products");

		return "admin/products/list";
	}

	@GetMapping("/create")
	public String viewCategory(Model model) {
		model.addAttribute("productForm", new ProductVO());
		model.addAttribute("title", "Create Products");
		List<CategoryVO> list = categoryService.readAll();
		model.addAttribute("categories", list);
		return "admin/products/create";
	}

	@PostMapping("/create")
	public String saveProduct(@Validated @ModelAttribute("productForm") ProductVO vo, BindingResult bindingResult,
			@RequestParam(name = "image") MultipartFile multipartFile, RedirectAttributes rAttributes, Model model)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		String path = System.getProperty("user.dir"); // lấy đường dẫn của thư mục
		try {
			String filePath = path + "/src/main/resources/static/images/" + vo.getImage().getOriginalFilename();
			vo.getImage().transferTo(Paths.get(filePath)); // lấy ảnh từ VO chuyển tới filepath
		} catch (Exception e) {
			System.out.println("Lỗi ghi file vào thư mục");
		}
		if (!bindingResult.hasErrors()) {
			productService.create(vo);
			rAttributes.addFlashAttribute("message", "Create Product is successfuly with id: " + vo.getId());
			return "redirect:/admin/products";
		} else {
			return "admin/products/create";
		}
	}

	@GetMapping("/edit/{id}")
	public String editView(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("productForm", productService.detail(id));
		model.addAttribute("title", "Edit Product");
		List<CategoryVO> list = categoryService.readAll();
		model.addAttribute("categories", list);
		return "admin/products/edit";
	}

	@PostMapping("/edit/{id}")
	public String editCategory(@Validated @ModelAttribute("productForm") ProductVO vo, BindingResult bindingResult,
			@RequestParam(name = "image") MultipartFile multipartFile, RedirectAttributes rAttributes, Model model) {
		String path = System.getProperty("user.dir"); // lấy đường dẫn của thư mục
		try {
			String filePath = path + "/src/main/resources/static/images/" + vo.getImage().getOriginalFilename();
			vo.getImage().transferTo(Paths.get(filePath)); // lấy ảnh từ VO chuyển tới filepath
		} catch (Exception e) {
			System.out.println("Lỗi ghi file vào thư mục");
		}
		if (!bindingResult.hasErrors()) {
			productService.update(vo);
			rAttributes.addFlashAttribute("message", "Edit Product is successfuly with id: " + vo.getId());
			return "redirect:/admin/products";
		} else {
			return "admin/products/edit";
		}

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes rAttributes) {
		productService.delete(id);
		rAttributes.addFlashAttribute("message", "Delete Product is successfuly with id: " + id);
		return "redirect:/admin/products";
	}
}
