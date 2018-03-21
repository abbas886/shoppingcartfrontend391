package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.domain.Category;

@Controller
public class AdminController {
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	@Autowired HttpSession httpSession;
	
	@GetMapping("/managecategories")
	public ModelAndView admincClickedCategories()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageCategories", true);
		//fetch all the categories again 
		List<Category> categories = categoryDAO.list();
		//and set to http session.
		httpSession.setAttribute("categories", categories);

		return mv;
	}
	
	@GetMapping("/managesupplier")
	public ModelAndView admincClickedSupplier()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageSuppliers", true);
		return mv;
	}
	
	@GetMapping("/manageproducts")
	public ModelAndView admincClickedProducts()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts", true);
		return mv;
	}

}







