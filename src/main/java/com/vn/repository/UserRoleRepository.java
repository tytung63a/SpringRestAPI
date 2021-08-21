package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.entities.AppUser;
import com.vn.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}