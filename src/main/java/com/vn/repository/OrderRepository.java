package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}


