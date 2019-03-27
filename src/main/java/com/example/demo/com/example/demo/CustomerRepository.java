package com.example.demo.com.example.demo;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	// Auswahl: Alle objekt mit diesem Usernamen
	@Query("SELECT t FROM Customer t where t.username = :username")
    public Collection <Customer> findByName(@Param("username") String username);
	
}
