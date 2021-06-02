package com.customer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.CustomerEntity;
import com.customer.model.CustomerModel;
import com.customer.repository.CustomerRepository;

/**
 * @author ATMA
 *
 */
@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerEntity customerEntity;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerModel customerModel;
	
	
	//validate validate admin
	public boolean validateUser(String username) {
		if(username.equalsIgnoreCase("admin")) {
			return true;
		}
		return false;
	}
	
	//validate valid user
	public CustomerModel validateUser(String username, String password) {
		if(username.equalsIgnoreCase("admin")) {
			customerModel.setUserName("admin");
			customerModel.setAdmin(true);
			customerModel.setUser(false);
			return customerModel;
		}
		customerEntity= customerRepository.findByUsernameAndPassword(username, password);
		if(null!=customerEntity) {
			customerModel.setUserName(customerEntity.getUserName());
			customerModel.setAdmin(false);
			customerModel.setUser(true);
			customerModel.setId(customerEntity.getId());
		}
		else {
			return null;
		}
		return customerModel;
	}
	
	public CustomerModel createUser(CustomerModel customerModel, String password ) {
		customerEntity.setPassword(password);
		BeanUtils.copyProperties(customerModel, customerEntity);
		customerRepository.save(customerEntity);
		return customerModel;
	}

}
