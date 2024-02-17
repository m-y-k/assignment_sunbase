package com.sunbase.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.sunbase.customer.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	 @Query(value = "SELECT * FROM customer WHERE (first_name LIKE CONCAT('%', :searchTerm, '%') OR last_name LIKE CONCAT('%', :searchTerm, '%') OR email LIKE CONCAT('%', :searchTerm, '%')) ORDER BY :sortField :sortDirection",
	           countQuery = "SELECT COUNT(*) FROM customer WHERE (first_name LIKE CONCAT('%', :searchTerm, '%') OR last_name LIKE CONCAT('%', :searchTerm, '%') OR email LIKE CONCAT('%', :searchTerm, '%'))",
	           nativeQuery = true)
	    Page<Customer> findBySearchTermAndSort(String searchTerm, String sortField, String sortDirection, Pageable pageable);

}
