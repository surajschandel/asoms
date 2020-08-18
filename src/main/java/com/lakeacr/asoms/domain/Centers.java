package com.lakeacr.asoms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Entity
@Table(name = "centers")
public class Centers {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "center_name")
	private String centerName;
	@Column(name = "center_code")
	private String centerCode;
	@Column(name = "location_code")
	private String locationCode;
	@Column(name = "address")
	private String address;
	@Column(name = "pin_code")
	private String pinCode;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "contact_person")
	private String contactPerson;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "updated_by")
	private Long updatedBy;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "deleted_at")
	private Date deletedAt;
	@Column(name = "deleted_by")
	private Long deletedBy;
	private boolean isActive;
	private boolean isDeleted;

	/**
	 * 
	 */
	public Centers() {
		super();
	}

	/**
	 * @param centerName
	 * @param centerCode
	 * @param locationCode
	 * @param address
	 * @param pinCode
	 * @param phoneNo
	 * @param emailId
	 * @param createdAt
	 * @param createdBy
	 * @param isActive
	 * @param isDeleted
	 */
	public Centers(String centerName, String centerCode, String locationCode, String contactPerson, String address,
			String pinCode, String phoneNo, String emailId, Date createdAt, Long createdBy, boolean isActive,
			boolean isDeleted) {
		super();
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.locationCode = locationCode;
		this.address = address;
		this.contactPerson = contactPerson;
		this.pinCode = pinCode;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}

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
	 * @return the centerName
	 */
	public String getCenterName() {
		return centerName;
	}

	/**
	 * @param centerName the centerName to set
	 */
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	/**
	 * @return the centerCode
	 */
	public String getCenterCode() {
		return centerCode;
	}

	/**
	 * @param centerCode the centerCode to set
	 */
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	/**
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @param deletedAt the deletedAt to set
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	/**
	 * @return the deletedBy
	 */
	public Long getDeletedBy() {
		return deletedBy;
	}

	/**
	 * @param deletedBy the deletedBy to set
	 */
	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Centers [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ", locationCode="
				+ locationCode + ", address=" + address + ", pinCode=" + pinCode + ", phoneNo=" + phoneNo
				+ ", contactPerson=" + contactPerson + ", emailId=" + emailId + ", updatedAt=" + updatedAt
				+ ", updatedBy=" + updatedBy + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", deletedAt="
				+ deletedAt + ", deletedBy=" + deletedBy + ", isActive=" + isActive + ", isDeleted=" + isDeleted + "]";
	}

}
