package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> searchShareByCustomerId(Integer customerId);
}
