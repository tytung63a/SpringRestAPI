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
@Table(name = "App_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
public class AppRole {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Role_Id")
    private Long roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;

}