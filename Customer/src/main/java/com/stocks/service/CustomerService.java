package com.stocks.service;

import java.sql.SQLIntegrityConstraintViolationException;

import com.stocks.entity.Customer;

public interface CustomerService {

	// Collection<Customer> getAllCustomers();
        
    Customer loginCheck(String userEmail, String userPassword);
        
    Customer addCustomer(Customer customer) throws SQLIntegrityConstraintViolationException;
    
    boolean balanceCheck(int userId);
    
    Customer updateBalance(int userId, double inc);
        
}
