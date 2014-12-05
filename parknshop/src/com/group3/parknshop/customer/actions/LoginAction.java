package com.group3.parknshop.customer.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.customer.services.interfaces.ILoginService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value="struts-default")
@Results({
	@Result(name="login",value="/WEB-INF/index/login.jsp"),
	@Result(name="success",value="/WEB-INF/index/success.jsp"),
	@Result(name="fail",value="/WEB-INF/index/fail.jsp"),
	@Result(name="checksum",value="/WEB-INF/index/checksum.jsp")
})

public class LoginAction extends ActionSupport{

	@Resource(name="loginService")
	private ILoginService loginservice;

	public ILoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(ILoginService loginservice) {
		this.loginservice = loginservice;
	}

	
	
	public String gotoLogin(){
		
		return "login";
	}
	
	public String loginC(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username= "+name+"/r/n"+"password="+password);
		if(loginservice.loginC(name,password))
			return "success";
		return "fail";
	}
	
	public String gotoCheckSum(){
		
		return "checksum";
	}
	
}
