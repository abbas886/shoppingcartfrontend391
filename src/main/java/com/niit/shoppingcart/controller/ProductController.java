package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.dao.SupplierDAO;
import com.niit.shopingcart.domain.Product;
@Controller
public class ProductController {


	// we need to call ProductDAO methods
	// get,save,update,delete,list

	// 1. inject the ProductDAO and Product
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	
	@Autowired
	private SupplierDAO supplierDAO;


	@Autowired
	private Product product;

	@Autowired
	HttpSession httpSession;

	// http://localhost:8080/shoppingcart/product/get/cate_001
	// @GetMapping("/product/get/{id}")
	/*@RequestMapping(name = "/product/get/", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam String id) {
		// based on id, fetch the details from productDAO
		product = productDAO.get(id);

		// navigate to home page
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("product", product);
		return mv;

	}*/

	@PostMapping("/product/save/")
	/*
	 * public ModelAndView saveProduct(@RequestParam("id") String id,
	 * 
	 * @RequestParam("id") String name,
	 * 
	 * @RequestParam("id") String description)
	 */
	public ModelAndView saveProduct(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("price") String price,
			@RequestParam("categoryID") String categoryID,
			@RequestParam("supplierID") String supplierID
			
			) {

		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		price = price.replace(",","");
		product.setPrice(Integer.parseInt(price));
		//product.setCategory(categoryDAO.get(categoryID));
		//product.setSupplier(supplierDAO.get(supplierID));
		product.setCategoryId(categoryID);
		product.setSupplierId(supplierID);
		if (productDAO.save(product)) {
			mv.addObject("productSuccessMessage", "The product created successfully");
		} else {
			mv.addObject("productErrorMessage", "Coulc not able to create product.  please contact admin");
		}
		return mv;

	}

	@PutMapping("/product/update/")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call save method of productDAO
		if (productDAO.update(product) == true) {
			// add success message
			mv.addObject("successMessage", "The product updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the product.");

		}
		return mv;

	}

	@GetMapping("/product/delete")
	public ModelAndView deleteProduct(@RequestParam String id) {
		System.out.println("going to delete product : " + id);
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		// we supposed to fetch the latest categories
		// and add to httpSession
		// based on id, fetch the details from productDAO
		if (productDAO.delete(id) == true) {
			// add success message
			mv.addObject("successMessage", "The product deleted successfully");

		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not delete the product.");

		}

		return mv;

	}

	@GetMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		// based on product id fetch product details.
		product = productDAO.get(id);
		// mv.addObject("selectedProduct", product);
		httpSession.setAttribute("selectedProduct", product);

		return mv;
	}

	@GetMapping("/products")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List<Product> categories = productDAO.list();
		mv.addObject("products", categories);
		return mv;
	}
	/*
	 * @GetMapping("/product/edit") public ModelAndView editProduct(@RequestParam
	 * String id) { ModelAndView mv = new
	 * ModelAndView("redirect:/manageproducts");
	 * 
	 * product = productDAO.get(id);
	 * 
	 * httpSession.setAttribute("product", product); return mv;
	 * 
	 * }
	 */



}
