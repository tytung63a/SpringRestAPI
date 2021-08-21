package com.vn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "User_Name", length = 36)
    private String userName;

    @Column(name = "Encryted_Password", length = 128)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1)
    private boolean enabled;


}