package com.sunbase.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbase.customer.models.Customer;
import com.sunbase.customer.requestDto.CustomerRequestDto;
import com.sunbase.customer.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) throws Exception {
		
		try {
			return new ResponseEntity<>(customerService.createCustomer(customerRequestDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(customerService.createCustomer(customerRequestDto), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer customer) throws Exception{
		try {
			return customerService.updateCustomer(customer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	 @GetMapping
	    public ResponseEntity<Page<Customer>> searchCustomers(
	            @RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm,
	            @RequestParam(value = "sortField", required = false, defaultValue = "id") String sortField,
	            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,
	            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
	            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

	        Page<Customer> customers = customerService.searchCustomers(searchTerm, sortField, sortDirection, pageNumber, pageSize);
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	 
	 @GetMapping("/get/{id}")
	 public Customer getCustomerById(@PathVariable(value = "id") String id) throws Exception{
		 try {
			return customerService.getCustomerById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteCustomerById(@PathVariable(value = "id") String id) throws Exception{
		 try {
			return customerService.deleteCustomerById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	 }
}
