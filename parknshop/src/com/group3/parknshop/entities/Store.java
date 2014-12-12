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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="storeId")
	private Integer storeId;
	
	@Column(name="storeName")
	private String storeName;
	
	@Column(name="storeLevel")
	private Integer storeLevel;
	
	@Column(name="userId")
	private Integer userId;
	
	
	@OneToMany(targetEntity=Commodity.class,fetch=FetchType.LAZY)
	@JoinColumn(name="storeId",updatable=true,insertable=true)
	private List<Commodity> commodity = new ArrayList<Commodity>(0);


	public Integer getStoreId() {
		return storeId;
	}


	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public Integer getStoreLevel() {
		return storeLevel;
	}


	public void setStoreLevel(Integer storeLevel) {
		this.storeLevel = storeLevel;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public List<Commodity> getCommodity() {
		return commodity;
	}


	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

}
