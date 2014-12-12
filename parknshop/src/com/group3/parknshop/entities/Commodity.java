package com.group3.parknshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="commodityId")
	private Integer commodityId;
	
	@Column(name="commodityName")
	private String commodityName;
	
	@OneToMany(targetEntity=CommodityImages.class,fetch=FetchType.LAZY)
	@JoinColumn(name="commodityId",insertable=true,updatable=true)
	private List<CommodityImages> commodityImages = new ArrayList<CommodityImages>(0);
	
	@ManyToOne(targetEntity=Store.class,fetch=FetchType.LAZY)
	@JoinColumn(name="storeId")
	private Store store;

	@Column(name="commodityPrice")
	private Integer commodityPrice;
	
	@Column(name="commodityColor")
	private String commodityColor;
	
	@Column(name="commoditySize")
	private String commoditySize;
	
	@Column(name="commodityDetails")
	private String commodityDetails;
	
	@Column(name="commodityType")
	private String commodityType;

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Integer commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityDetails() {
		return commodityDetails;
	}

	public void setCommodityDetails(String commodityDetails) {
		this.commodityDetails = commodityDetails;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	
	public List<CommodityImages> getCommodityImages() {
		return commodityImages;
	}

	public void setCommodityImages(List<CommodityImages> commodityImages) {
		this.commodityImages = commodityImages;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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
}
