package com.group3.parknshop.customer.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group3.parknshop.common.SendEmail;
import com.group3.parknshop.customer.dao.interfaces.ILoginDao;
import com.group3.parknshop.customer.services.interfaces.ILoginService;
import com.group3.parknshop.entities.Users;


@Service("loginService")
public class LoginService implements ILoginService {

	@Resource(name="loginDao")
	private ILoginDao logindao;
	
	public Boolean loginC(String name, String password) {
		// TODO Auto-generated method stub
		return logindao.loginC(name,password);
	}

	public Boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return logindao.addUser(user);
	}

	public Boolean forgetPassword(String username, String email) {
		// TODO Auto-generated method stub
		//��֤�û����������Ƿ���ע����Ϣһ��
		if(logindao.forgetPassword(username,email)){
			
			System.out.println("service before email");
			
			String subject = "������ParknShop�˺���������";
			String content = "���ã�������������ӽ����������á�<a href='www.baidu.com'>��������</a>";
			if(SendEmail.sendEmail(email,subject,content))
				return true;
		}
		System.out.println("service after email");
		return false;
	}

}
