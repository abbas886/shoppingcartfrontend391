package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CartDAO;
import com.niit.shopingcart.dao.UserDAO;
import com.niit.shopingcart.domain.Cart;
import com.niit.shopingcart.domain.User;

//Annotation
@Controller
public class UserController {
	
	
	//UserDAO - backend project
	@Autowired
	private UserDAO  userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	HttpSession httpSession;
	
	
	//will send user id and password from jsp to controller
	//it should validate the credentials
	//it should return username ---- valid credentials
	//it should return error message ----invalid credentials
	
	@PostMapping("validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	
	{
		ModelAndView mv = new ModelAndView("home");
		
		user= userDAO.validate(username, password);
		
		if (user ==null)
		{
			mv.addObject("errorMessage", "Invalid credentials, pl try agin.");
			
		}
		else
		{
			//valid credentials.
			//mv.addObject("welcomeMessage", "Welcome Mr./Ms " + user.getName());
			httpSession.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getName());
			httpSession.setAttribute("loggedInUserID", user.getEmailID());
			httpSession.setAttribute("isLoggedIn",true);
			//fetch how amy products are added to the cart.
			//this number add to httpSession.
			List<Cart> carts = cartDAO.list(user.getEmailID());
			httpSession.setAttribute("size", carts.size());
			
			
			httpSession.setAttribute("carts", carts);
			
			
			if(user.getRole()=='A')
			{
				httpSession.setAttribute("isAdmin", true);
			}
			
		}
		
		return mv;
		
	}

}








