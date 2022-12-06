package com.example.service;

import java.util.List;
import com.example.entity.CustomerDetail;

public interface CustomerDetailService {

	public List<CustomerDetail> getCustomerDetailByCustomerId(String customerId);
	
}
