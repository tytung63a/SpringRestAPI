package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}