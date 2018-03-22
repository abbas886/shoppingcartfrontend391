package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.domain.Category;
@Controller
public class CategoryController {

	// we need to call CategoryDAO methods
	// get,save,update,delete,list

	// 1. inject the CategoryDAO and Category
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@Autowired HttpSession httpSession;

	// http://localhost:8080/shoppingcart/category/get/cate_001
	// @GetMapping("/category/get/{id}")
	@RequestMapping(name = "/category/get/{id}", method = RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam("id") String id) {
		// based on id, fetch the details from categoryDAO
		category = categoryDAO.get(id);

		// navigate to home page
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("category", category);
		return mv;

	}

	@PostMapping("/category/save/")
	/*
	 * public ModelAndView saveCategory(@RequestParam("id") String id,
	 * 
	 * @RequestParam("id") String name,
	 * 
	 * @RequestParam("id") String description)
	 */
	public ModelAndView saveCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,
			@RequestParam("description") String description) {
		
		ModelAndView mv = new ModelAndView("home");
		//set the values to category
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		//save into db
		if(categoryDAO.save(category))
		{
			mv.addObject("categorySuccessMessage", "The category created successfully");
			//fetch all the categories again 
	/*		List<Category> categories = categoryDAO.list();
			//and set to http session.
			httpSession.setAttribute("categories", categories);
	*/	}
		else
		{
			mv.addObject("categoryErrorMessage", "Coulc not able to create category.  please contact admin");
		}
		return mv;

	}

	@PutMapping("/category/update/")
	public ModelAndView updateCategory(@ModelAttribute Category category) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call save method of categoryDAO
		if (categoryDAO.update(category) == true) {
			// add success message
			mv.addObject("successMessage", "The category updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the category.");

		}
		return mv;

	}

	@GetMapping("/category/delete")
	public ModelAndView deleteCategory(@RequestParam String id) {
		System.out.println("going to delete category : " + id);
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		//we supposed to fetch the latest categories
		//and add to httpSession
		// based on id, fetch the details from categoryDAO
		if (categoryDAO.delete(id) == true) {
			// add success message
			mv.addObject("successMessage", "The category deleted successfully");

		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not delete the category.");

		}

		return mv;

	}

	@GetMapping("/categories")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDAO.list();
		mv.addObject("categories", categories);
		return mv;
	}
	/*@GetMapping("/category/edit")
	public ModelAndView editCategory(@RequestParam String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		
		category = categoryDAO.get(id);
		
		httpSession.setAttribute("category", category);
		return mv;
		
	}*/

}
