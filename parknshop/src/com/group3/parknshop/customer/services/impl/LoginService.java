package com.group3.parknshop.customer.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group3.parknshop.customer.dao.interfaces.ILoginDao;
import com.group3.parknshop.customer.services.interfaces.ILoginService;


@Service("loginService")
public class LoginService implements ILoginService {

	@Resource(name="loginDao")
	private ILoginDao logindao;
	
	public Boolean loginC(String name, String password) {
		// TODO Auto-generated method stub
		return logindao.loginC(name,password);
	}

}
