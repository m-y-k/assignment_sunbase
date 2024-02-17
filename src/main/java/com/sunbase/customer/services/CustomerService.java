package com.sunbase.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunbase.customer.models.Customer;
import com.sunbase.customer.repositories.CustomerRepository;
import com.sunbase.customer.requestDto.CustomerRequestDto;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public String createCustomer(CustomerRequestDto customerRequestDto) throws Exception{
		Customer customer = new Customer();
		customer.setFirstName(customerRequestDto.getFirst_name());
		customer.setLastName(customerRequestDto.getLast_name());
		customer.setEmail(customerRequestDto.getEmail());
		customer.setAddress(customerRequestDto.getAddress());
		customer.setCity(customerRequestDto.getCity());
		customer.setPhone(customerRequestDto.getPhone());
		customer.setState(customerRequestDto.getState());
		customer.setStreet(customerRequestDto.getStreet());
	
		try {
			customerRepository.save(customer);
			return "Customer added succesfully";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public String updateCustomer(Customer customer) {
		String idString = customer.getId();
		
			Customer customer2 = customerRepository.findById(idString).get();
			customerRepository.save(customer);
			return "customer updated";
		
	}
	
	public Page<Customer> searchCustomers(String searchTerm, String sortField, String sortDirection, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return customerRepository.findBySearchTermAndSort(searchTerm, sortField, sortDirection, pageable);
    }
	
	
	public Customer getCustomerById(String id) {
		
		return customerRepository.findById(id).get();
	}
	
	public String deleteCustomerById(String id) {
		
		customerRepository.deleteById(id);
		return "deleted successfully";
	}
}
