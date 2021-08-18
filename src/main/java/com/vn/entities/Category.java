package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the category database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;

	@OneToMany(mappedBy="category")
	private List<Product> products;

}