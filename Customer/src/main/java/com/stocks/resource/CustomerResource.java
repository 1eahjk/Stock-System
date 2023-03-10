package com.stocks.resource;

import com.stocks.entity.Customer;
import com.stocks.service.CustomerService;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerService customerService;
	
	
	// GET method to check the customer exists in the database for login check
	@GetMapping(path = "/customers/{userEmail}/{userPassword}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer loginCheckResource(@PathVariable("userEmail") String userEmail, @PathVariable("userPassword") String userPassword) {
		return customerService.loginCheck(userEmail, userPassword);
	}
	
	// POST method to add a customer to the database
	@PostMapping(path = "/customers",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomerResource(@RequestBody Customer customer) throws SQLIntegrityConstraintViolationException {
        try {
        	if(customerService.addCustomer(customer) != null)
                return "User added";
            else
                return "User not added";
        } catch (SQLIntegrityConstraintViolationException e) {
            return "User not added.";
        }
    }
	
	// GET method to check that the customer has sufficient funds to swipe in
	@GetMapping(path = "/customers/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String balanceCheckResource(@PathVariable("userId") int userId) {
		if(customerService.balanceCheck(userId))
			return "Sufficient funds";
		else
			return "Insufficient funds";
	}
	
	// PUT method to update the customers balance
	@PutMapping(path = "/customers/{userId}/{inc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateBalanceResource(@PathVariable("userId") int userId, @PathVariable("inc") double inc) {
		
		return customerService.updateBalance(userId, inc);
	}
}
