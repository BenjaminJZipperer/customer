package com.example.demo.com.example.demo.controller;

import com.example.demo.com.example.demo.model.User;
import com.example.demo.com.example.demo.model.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
	@RequestMapping("/register")
	public String registerAction(Model model) {
	    model.addAttribute("user", new User());
	    model.addAttribute("confirmPassword", "");
	    return "views/users/register";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(User user) {
	    // User savedUser = customerService.save(user);
	    return "redirect:/"; //redirect to homepage
	}
}
