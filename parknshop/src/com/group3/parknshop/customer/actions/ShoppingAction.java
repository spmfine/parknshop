package com.group3.parknshop.customer.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.group3.parknshop.customer.services.interfaces.IShoppingService;
import com.group3.parknshop.entities.Commodity;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value="struts-default")
@Results({
	
	@Result(name="search",value="/WEB-INF/index/searchResult.jsp"),
	@Result(name="detail",value="/WEB-INF/index/goodsDetail.jsp"),
	@Result(name="success",value="/WEB-INF/index/success.jsp")
	
})
public class ShoppingAction extends ActionSupport{
	
	@Resource(name="shoppingService")
	private IShoppingService shoppingService;
	
	Commodity commodity;
	
	List<Commodity> commodityList;
	
	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public IShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(IShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@SuppressWarnings("unchecked")
	public String search(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String searchKeys = req.getParameter("searchKeys");
		commodityList = (List<Commodity>)shoppingService.search(searchKeys);
		System.out.println("hah");
		return "search";
	}
	
	public String gotoDetail(){
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String commodityId = req.getParameter("commodityId");
		commodity = (Commodity)shoppingService.findById(Integer.parseInt(commodityId));
		System.out.println("hahha");
		return "detail";
	}

	public String createOrder(){
		
		return "success";
	}
	
}
