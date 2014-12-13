package com.group3.parknshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="orderId")
	private Integer orderId;
	
	@Column(name="transferId")
	private String transferId;

	@Column(name="orderStartTime")
	private String orderStartTime;
	
	@Column(name="orderEndTime")
	private String orderEndTime;
	
	@Column(name="orderMessage")
	private String orderMessage;
	
	@Column(name="orderState")
	private String orderState;
	
	@Column(name="storeId")
	private Integer storeId;
	
	@Column(name="commodityId")
	private Integer commodityId;
	
	@Column(name="commodityColor")
	private String commodityColor;
	
	@Column(name="commoditySize")
	private String commoditySize;
	
	@Column(name="commodityPrice")
	private Float commodityPrice;
	
	@Column(name="commodityNumber")
	private Integer commodityNumber;
	
	@Column(name="commodityTotalPrice")
	private Float commodityTotalPrice;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="userAddress")
	private String userAddress;
	
	@Column(name="userPhone")
	private String userPhone;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public String getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public String getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityColor() {
		return commodityColor;
	}

	public void setCommodityColor(String commodityColor) {
		this.commodityColor = commodityColor;
	}

	public String getCommoditySize() {
		return commoditySize;
	}

	public void setCommoditySize(String commoditySize) {
		this.commoditySize = commoditySize;
	}

	public Float getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(Integer commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public Float getCommodityTotalPrice() {
		return commodityTotalPrice;
	}

	public void setCommodityTotalPrice(Float commodityTotalPrice) {
		this.commodityTotalPrice = commodityTotalPrice;
	}
	
}