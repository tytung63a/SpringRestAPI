package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
   
}