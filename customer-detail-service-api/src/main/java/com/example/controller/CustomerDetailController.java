package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.CustomerDetail;
import com.example.service.CustomerDetailService;

@Controller
public class CustomerDetailController {
	
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@RequestMapping("/")
	public ModelAndView getUserInputPage() {
		return new ModelAndView("InputCustomerId");
	}
	
	@RequestMapping("/checkCustomerDetail")
	public ModelAndView checkDetailController(@RequestParam("customerId") String customerId) {
		ModelAndView modelAndView =new ModelAndView();
		
		List<CustomerDetail> customerDetails=customerDetailService.getCustomerDetailByCustomerId(customerId);
		
		modelAndView.addObject("customerDetails", customerDetails);
		modelAndView.addObject("customerId", customerId);
		modelAndView.setViewName("ShowCustomerDetail");
		return modelAndView;
	}

}
