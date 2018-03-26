package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.dao.SupplierDAO;
import com.niit.shopingcart.domain.Category;
import com.niit.shopingcart.domain.Product;
import com.niit.shopingcart.domain.Supplier;

@Controller
public class AdminController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Product product;
	
	
	
	

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
	
	@GetMapping("/managesuppliers")
	public ModelAndView admincClickedSupplier()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageSuppliers", true);
		
		List<Supplier> suppliers =  supplierDAO.list();
		httpSession.setAttribute("suppliers", suppliers);
		
		return mv;
	}
	
	@GetMapping("/manageproducts")
	public ModelAndView admincClickedProducts()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts", true);
		//we suppsed to fetch all categories and suppliers
		//and set it to http seesion.
		 List<Category> categories = categoryDAO.list();
		 List<Supplier> suppliers = supplierDAO.list();
		 List<Product> products = productDAO.list();
		 
		 httpSession.setAttribute("categories", categories);
		 httpSession.setAttribute("suppliers", suppliers);
		 httpSession.setAttribute("products", products);
		return mv;
	}

}







