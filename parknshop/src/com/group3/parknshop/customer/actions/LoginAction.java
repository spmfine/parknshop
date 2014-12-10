package com.group3.parknshop.customer.actions;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.customer.services.interfaces.ILoginService;
import com.group3.parknshop.entities.Users;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value="struts-default")
@Results({
	@Result(name="login",value="/WEB-INF/index/login.jsp"),
	@Result(name="success",value="/WEB-INF/index/success.jsp"),
	@Result(name="fail",value="/WEB-INF/index/fail.jsp"),
	@Result(name="checksum",value="/WEB-INF/index/checksum.jsp"),
	@Result(name="regist",value="/WEB-INF/index/regist.jsp"),
	@Result(name="forgetpassword",value="/WEB-INF/index/forgetpassword.jsp")
})

public class LoginAction extends ActionSupport{

	@Resource(name="loginService")
	private ILoginService loginservice;
	
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ILoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(ILoginService loginservice) {
		this.loginservice = loginservice;
	}

	public String gotoLogin(){
		
		return "login";
	}
	
	public String gotoRegist(){
		
		return "regist";
	}
	
	public String gotoCheckSum(){
		
		return "checksum";
	}
	
	public String gotoForgetPassword(){
		
		return "forgetpassword";
	}
	/*
	 * 用户登录
	 */
	public String loginC(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String checksum = req.getParameter("checksum");
		String remember = req.getParameter("remember");
		
		HttpSession session = req.getSession();
		String check = (String)session.getAttribute("checksum");

		if(checksum.equals(check)){
		
			if(loginservice.loginC(username,password)){
				if(remember!=null&&remember.equals("remember")){
					//保存cookie
					Cookie name = new Cookie("username",username);
					name.setMaxAge(7*24*3600);
					Cookie pass = new Cookie("password",password);
					pass.setMaxAge(7*24*3600);
					ServletActionContext.getResponse().addCookie(name);
					ServletActionContext.getResponse().addCookie(pass);
				}
				return "success";
			}
			return "fail";
		}else
			return "fail";
	}
	/**
	 * 用户注册
	 * @return
	 */
	public String regist(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String checksum = req.getParameter("checksum");
		String check = (String)req.getSession().getAttribute("checksum");
		if(checksum.equals(check)){
			if(loginservice.addUser(user))
				return "success";
		}
		return "fail";
	}
	/**
	 * 忘记密码
	 */
	public String forgetPassword(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		if(loginservice.forgetPassword(username,email))
			return "success";
		System.out.println("action");
		return "fail";
	}
	
}
