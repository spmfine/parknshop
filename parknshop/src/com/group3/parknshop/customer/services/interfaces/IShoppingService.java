package com.group3.parknshop.customer.services.interfaces;

import java.util.List;

import com.group3.parknshop.entities.Commodity;

public interface IShoppingService {
	
	public List search(String searchKeys);
	public Object findById(Integer Id);
}
