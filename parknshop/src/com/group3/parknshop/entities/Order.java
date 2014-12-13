package com.group3.parknshop.entities;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {
	
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
	
	@Column(name="commodityId")
	private Integer commodityId;
	
	@Column(name="commodityColor")
	private String commodityColor;
	
	@Column(name="commoditySize")
	private Integer commoditySize;
	
	@Column(name="commodityPrice")
	private String commodityPrice;
	
	@ManyToOne(targetEntity=Users.class,fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Users user;

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

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
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

	public Integer getCommoditySize() {
		return commoditySize;
	}

	public void setCommoditySize(Integer commoditySize) {
		this.commoditySize = commoditySize;
	}

	public String getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
