package com.lakeacr.asoms.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Entity
public class LoginHistory {

	@Id
	@GeneratedValue
	private Long id;
	private Long userId;
	private Date loginTime;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	@Override
	public String toString() {
		return "LoginHistory [id=" + id + ", userId=" + userId + ", loginTime=" + loginTime + "]";
	}
	
	
}
