package com.group3.parknshop.customer.dao.interfaces;

import com.group3.parknshop.entities.Users;

public interface ILoginDao {

	Boolean loginC(String name,String password);
	Boolean addUser(Users user);
	Boolean forgetPassword(String username,String email);
}
