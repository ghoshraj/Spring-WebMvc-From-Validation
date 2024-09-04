package com.raj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raj.entity.product;
import com.raj.repo.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("/edit")
	public String editrecord(@RequestParam("id") Integer id, Model model) {
		Optional<product> findbyid = repo.findById(id);
		if (findbyid.isPresent()) {
			product pro = findbyid.get();
			model.addAttribute("pro", pro);
		}
		return "index";
	}

	@GetMapping("/delete")
	public String deleterecord(@RequestParam("id") Integer id, Model model) {
		repo.deleteById(id);
		model.addAttribute("msg", "record deleted");
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/products")
	public String getallrecord(Model model) {
		List<product> list = repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}

	@PostMapping("/product")
	public String SaveProduct(@Validated @ModelAttribute("pro") BindingResult result, product p, Model model) {
		if (result.hasErrors())
			return "index";
		p = repo.save(p);
		if (p.getID() != null) {
			model.addAttribute("msg", "product save");
		}
		return "index";
	}

	@GetMapping("/")
	public String loadpage(Model model) {
		model.addAttribute("pro", new product());
		return "index";
	}
}
