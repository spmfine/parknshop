package com.group3.parknshop.customer.services.interfaces;

import com.group3.parknshop.entities.Users;

public interface ILoginService {
	
	public Boolean loginC(String name,String password);
	public Boolean addUser(Users user);
	public Boolean forgetPassword(String username,String email);
}
