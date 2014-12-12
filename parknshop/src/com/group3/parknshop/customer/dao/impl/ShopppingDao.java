package com.group3.parknshop.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.group3.parknshop.common.dao.impl.BaseDaoImpl;
import com.group3.parknshop.customer.dao.interfaces.IShoppingDao;
import com.group3.parknshop.entities.Commodity;

@Repository("shoppingDao")
public class ShopppingDao  extends BaseDaoImpl implements IShoppingDao{

	public List search(String searchKeys) {
		// TODO Auto-generated method stub
		String sql = "select a from Commodity a where a.commodityName like ?";
		return this.getHibernateTemplate().find(sql,"%"+searchKeys+"%");
	}

	public Object findById(Integer Id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Commodity.class, Id);
	}
	
}
