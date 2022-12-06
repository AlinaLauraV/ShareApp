package com.example.customer.service;


import com.example.customer.entity.Customer;
import com.example.customer.persistence.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;


    @Override
    public List<Customer> searchShareByCustomerId(Integer customerId) {
        return customerDao.searchByCustomerId(customerId);
    }
}
