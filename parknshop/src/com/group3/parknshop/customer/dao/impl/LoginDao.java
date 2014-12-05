package com.group3.parknshop.customer.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.group3.parknshop.common.dao.impl.BaseDaoImpl;
import com.group3.parknshop.customer.dao.interfaces.ILoginDao;
import com.group3.parknshop.entities.*;


@Repository("loginDao")
public class LoginDao extends BaseDaoImpl implements ILoginDao {

	public Boolean loginC(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "select a from Users a where a.userName like ?";
		List<Users> lt =  this.getHibernateTemplate().find(sql,name);
		if(lt.size()==1&&lt.get(0).getUserPassword().equals(password))
			return true;
		return false;
	}

}
