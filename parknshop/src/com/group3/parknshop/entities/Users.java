package com.group3.parknshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userPassword")
	private String userPassword;
	
	@Column(name="userEmail")
	private String userEmail;
	
	@Column(name="userPhone")
	private String userPhone;
	
	@Column(name="userRealName")
	private String userRealName;
	
	@Column(name="userType")
	private String userType;
	
	@OneToMany(targetEntity=Address.class,fetch=FetchType.LAZY)
	@JoinColumn(name="userId",insertable=true,updatable=true)
	private List<Address> address = new ArrayList<Address>(0);
	
	@Column(name="userBalance")
	private Integer userBalance;
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public Integer getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}
}
