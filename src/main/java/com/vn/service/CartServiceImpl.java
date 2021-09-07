package com.vn.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.vn.entities.Cart;

@SessionScope
@Service
public class CartServiceImpl implements CartService{
	Map<Integer, Cart> maps = new HashMap<>();

	@Override
	public void add(Cart item) {
		Cart cart = maps.get(item.getProducID());
		if (cart == null) {
			maps.put(item.getProducID(), item);
		} else {
			cart.setQty(cart.getQty() + 1);
		}
	}

	@Override
	public void remove(int id) {
		maps.remove(id);
	}

	@Override
	public Cart update(int productID, int qty) {
		Cart cart = maps.get(productID);
		cart.setQty(qty);
		return cart;

	}

	@Override
	public void clear() {
		maps.clear();
	}

	@Override
	public Collection<Cart> getAll() {
		return maps.values();
	}

	@Override
	public int getCount() {
		return maps.values().size();
	}

	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQty() * item.getPrice()).sum();

	}
}
