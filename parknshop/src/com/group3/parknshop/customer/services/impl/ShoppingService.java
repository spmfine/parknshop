package com.group3.parknshop.customer.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group3.parknshop.customer.dao.interfaces.IShoppingDao;
import com.group3.parknshop.customer.services.interfaces.IShoppingService;
import com.group3.parknshop.entities.Commodity;

@Service("shoppingService")
public class ShoppingService implements IShoppingService {
	
	@Resource(name="shoppingDao")
	private IShoppingDao shoppingDao;

	public List search(String searchKeys) {
		// TODO Auto-generated method stub
		return shoppingDao.search(searchKeys);
	}

	public Object findById(Integer Id) {
		// TODO Auto-generated method stub
		return shoppingDao.findById(Id);
	}

}
