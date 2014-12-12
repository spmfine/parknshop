package com.group3.parknshop.customer.dao.interfaces;

import java.util.List;

public interface IShoppingDao {

	public List search(String searchKeys);
	public Object findById(Integer Id);
}
