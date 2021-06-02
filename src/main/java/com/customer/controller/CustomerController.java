package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.CustomerModel;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/validateUser")
	public ResponseEntity<CustomerModel> validateUser(@RequestBody CustomerModel customerModel, String password) {

		if (null != customerModel && null != password) {
			customerModel=customerService.validateUser(customerModel.getUserName(), password);
			if(null!=customerModel) {
				return new ResponseEntity<CustomerModel>(customerModel, HttpStatus.OK);
			}
		}
		return new ResponseEntity<CustomerModel>(customerModel, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<CustomerModel> registerUser(@RequestBody CustomerModel customerModel, String password){
		customerModel=customerService.createUser(customerModel, password);
		return new ResponseEntity<CustomerModel>(customerModel, HttpStatus.CREATED);
	}
}










