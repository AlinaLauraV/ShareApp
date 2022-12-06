package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Customer;
import com.example.entity.CustomerDetail;
import com.example.entity.CustomerDetailList;
import com.example.entity.CustomerList;
import com.example.entity.Share;

public class CustomerDetailServiceImpl implements CustomerDetailService {
	
	//RestTemplate is used to call Rest API
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<CustomerDetail> getCustomerDetailByCustomerId(String customerId) {
		List<CustomerDetail> customerDetailList=new ArrayList<CustomerDetail>();
		
		//calling rating service and storing list in ratingList Object
		CustomerList customerList=restTemplate.getForObject("http://localhost:8084/customers/"+customerId, CustomerList.class);
		
		//Iterating over RatingList and picking every rating
		for(Customer customer:customerList.getCustomers()) {
			// from everyrating, picking movie ID and calling movie service
			Share share=restTemplate.getForObject("http://localhost:8082/shares/"+customer.getShareId(), Share.class);
			
			// creating movie rating object
			CustomerDetail customerDetail=new CustomerDetail(customer.getCustomerId(), 
					share.getShareName(), customer.getQuantity(), share.getMarketPrice(), 
					(customer.getQuantity()*share.getMarketPrice()), 
					customer.getShareType());
			
			//adding movie rating object in list
			customerDetailList.add(customerDetail);
		}
		return customerDetailList;
	}

}
