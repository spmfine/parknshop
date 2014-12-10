package com.group3.parknshop.customer.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.group3.parknshop.common.dao.impl.BaseDaoImpl;
import com.group3.parknshop.customer.dao.interfaces.ILoginDao;
import com.group3.parknshop.entities.*;


@Repository("loginDao")
public class LoginDao extends BaseDaoImpl implements ILoginDao {
	
	public List findByName(String name){
		
		String sql = "select a from Users a where a.userName like ?";
		return this.getHibernateTemplate().find(sql,name);
	}

	public Boolean loginC(String name, String password) {
		// TODO Auto-generated method stub
		List<Users> lt =  this.findByName(name);
		if(lt.size()==1&&lt.get(0).getUserPassword().equals(password))
			return true;
		return false;
	}

	public Boolean addUser(Users user) {
		// TODO Auto-generated method stub
		List<Users> lt =  this.findByName(user.getUserName());
		if(lt.size()!=0)
			return false;
		if(this.getHibernateTemplate().save(user) != null)
			return true;
		return false;
	}

	public Boolean forgetPassword(String username, String email) {
		// TODO Auto-generated method stub
		List<Users> lt =  this.findByName(username);
		if(lt.size()==1&&lt.get(0).getUserEmail().equals(email))
			return true;
		return false;
	}
}
