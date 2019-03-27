package com.example.demo.com.example.demo;

import java.awt.List;
import java.sql.Date; // API 
import java.util.ArrayList;

import javax.validation.Valid;

import com.example.demo.com.example.demo.model.Customer;
import com.example.demo.com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Das ist unser Controller verweist auf list.html

@Controller
@SpringBootApplication
public class DemosApplication {

	@Autowired
	private CustomerRepository uRepository;
	
	
	
	@RequestMapping(value = "customers", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@GetMapping("/customers")
	public String searchForNameOrEmail
	(@RequestParam (value = "search", required = false) String surname, Model model)
	{
		// adding two arguments in the view (from one object)
	         model.addAttribute("customers", uRepository.findByName(surname));
	    if(surname == "")
	    	 model.addAttribute("customers", uRepository.findAll());
		model.addAttribute("serverTime", new java.util.Date());
		return "index";
	}
	@GetMapping("/72")
	public ModelAndView show()
	{
		ModelAndView model = new ModelAndView("index");
		model.addObject("serverTime", new Date(1980,3,3).toString());
		return model;
	}
	@GetMapping("/tasks")
	public String showTasks()
	{
		return "tasks";
	}
	
	@GetMapping("/create")
	public String showForm()
	{
		return "create";
	}
	@ModelAttribute("multiCheckboxAllValues")
	public String[] getMultiCheckboxAllValues() {
	    return new String[] {
	        "Monday", "Tuesday", "Wednesday", "Thursday", 
	        "Friday", "Saturday", "Sunday"
	    };
	}
	
	
	    @GetMapping("/signup")
	    public String showSignUpForm(Customer customer) {
	        return "add-customer";
	    }
	     
	    @PostMapping("/addcustomer")
	    public String addUser(@Valid Customer customer, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-customer";
	        }
	         
	        uRepository.save(customer);
	        model.addAttribute("customers", uRepository.findAll());
	        // add server time
	    	model.addAttribute("serverTime", new Date(1980,3,3).toString());
	        return "index";
	    }
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Customer user = uRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	         
	        model.addAttribute("user", user);
	        return "update-customer";
	    }
	    @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") long id, @Valid Customer customer, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            customer.setId(id);
	            return "update-customer";
	        }
	             
	        uRepository.save(customer);
	        model.addAttribute("users", uRepository.findAll());
	        return "index";
	    }
	         
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") long id, Model model) {
	        Customer current = uRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        uRepository.delete(current);
	        model.addAttribute("users", uRepository.findAll());
	        return "index";
	    }
	    
	    
	    // additional CRUD methods
	public static void main(String[] args) 
	{
		SpringApplication.run(DemosApplication.class, args);
	}

}
