package com.vn.service;

import java.util.Collection;

import com.vn.entities.Cart;

public interface CartService {

	double getAmount();

	int getCount();

	Collection<Cart> getAll();

	void clear();

	Cart update(int productID, int qty);

	void remove(int id);

	void add(Cart item);

}
