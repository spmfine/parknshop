package com.group3.parknshop.storeowner.actions;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.storeowner.services.interfaces.IApplyOpenShopService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value="struts-default")
@Results({
	@Result(name="success",value="/WEB-INF/index/success.jsp"),
})
public class ApplyOpenShopAction extends ActionSupport {

	@Resource( name = "applyOpenShopService" )
	private IApplyOpenShopService applyOpenShopService ;

}
