package com.group3.parknshop.storeowner.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.entities.Commodity;
import com.group3.parknshop.storeowner.services.interfaces.ICommodityService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "success", value = "/WEB-INF/index/success.jsp"),
		@Result(name = "fail", value = "/WEB-INF/index/fail.jsp"),
		@Result(name = "add", value = "/WEB-INF/index/addCommodity.jsp"),
		@Result(name = "update", value = "/WEB-INF/index/success.jsp"),
		@Result(name = "delete", value = "/WEB-INF/index/success.jsp"), })
public class CommodityAction extends ActionSupport {

	@Resource(name = "commodityService")
	private ICommodityService commodityService;
	
	private Commodity commodity;

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

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
	 * 添加商品 add products
	 */
	public String add() {
		if (commodityService.addCommodity(commodity)) {
			return "success";
		} else {
			return "fail";
		}
	}

	/*
	 * 更新商品 update products
	 */
	public String update() {
		return "";
	}

	/*
	 * 删除商品 delete products
	 */
	public String delete() {
		if (commodityService.deleteCommodity(commodity)) {
			return "success";
		} else {
			return "fail";
		}
	}

}
