package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
