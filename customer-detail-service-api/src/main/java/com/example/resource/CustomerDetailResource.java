package com.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CustomerDetailList;
import com.example.service.CustomerDetailService;

@RestController
public class CustomerDetailResource {
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@GetMapping(path="/customer/detail/{cId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailList getMovieRatingByUserIdResource(@PathVariable("cId") String customerId) {
		return new CustomerDetailList(customerDetailService.getCustomerDetailByCustomerId(customerId));
	}
	
}
