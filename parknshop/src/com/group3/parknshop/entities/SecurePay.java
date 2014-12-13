package com.group3.parknshop.entities;

import javax.persistence.*;

@Entity
@Table(name="securePay")
public class SecurePay {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="securePayId")
	private Integer securePayId;
	
	@Column(name="orderId")
	private Integer orderId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="storeId")
	private Integer storeId;
	
	@Column(name="commodityTotalPrice")
	private Float commodityTotalPrice;
	
	@Column(name="securePayState")
	private String securePayState;

	public Integer getSecurePayId() {
		return securePayId;
	}

	public void setSecurePayId(Integer securePayId) {
		this.securePayId = securePayId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Float getCommodityTotalPrice() {
		return commodityTotalPrice;
	}

	public void setCommodityTotalPrice(Float commodityTotalPrice) {
		this.commodityTotalPrice = commodityTotalPrice;
	}

	public String getSecurePayState() {
		return securePayState;
	}

	public void setSecurePayState(String securePayState) {
		this.securePayState = securePayState;
	}
	
}
