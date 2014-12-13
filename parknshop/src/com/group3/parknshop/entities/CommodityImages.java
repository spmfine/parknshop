package com.group3.parknshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commodityImages")
public class CommodityImages {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="imageId")
	private Integer imageId;
	
	@Column(name="imageUrl")
	private String imageUrl;
	
	@ManyToOne(targetEntity=Commodity.class,fetch=FetchType.LAZY)
	@JoinColumn(name="commodityId")
	private Commodity commodity;

	@Column(name="isDefault")
	private Boolean isDefault;
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
}
