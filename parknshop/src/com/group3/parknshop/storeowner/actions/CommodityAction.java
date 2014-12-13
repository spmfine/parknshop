package com.group3.parknshop.storeowner.actions;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.storeowner.services.interfaces.ICommodityService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "add", value = "/WEB-INF/index/login.jsp"),
		@Result(name = "update", value = "/WEB-INF/index/success.jsp"),
		@Result(name = "delete", value = "/WEB-INF/index/fail.jsp"), })
public class CommodityAction extends ActionSupport {

	@Resource( name = "commodityService" )
	private ICommodityService commodityService ;

	public String gotoAdd() {
		return "add";
	}

	public String gotoUpdate() {
		return "update";
	}

	public String gotoDelete() {
		return "delete";
	}

	/*
	 * 添加商品
	 * add products
	 */
	public String add() {
		return "" ;
	}

	/*
	 * 更新商品
	 * update products
	 */
	public String update() {
		return "" ;
	}

	/*
	 * 删除商品
	 * delete products
	 */
	public String delete() {
		return "" ;
	}

}
