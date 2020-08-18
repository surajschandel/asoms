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
@Table(name = "medium")
public class Medium {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "medium_name")
	private String mediumName;
	@Column(name = "medium_code")
	private String mediumCode;
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
	public Medium() {
		super();
	}
	

	/**
	 * @param mediumName
	 * @param mediumCode
	 * @param createdAt
	 * @param createdBy
	 * @param isActive
	 * @param isDeleted
	 */
	public Medium(String mediumName, String mediumCode, Date createdAt, Long createdBy, boolean isActive,
			boolean isDeleted) {
		super();
		this.mediumName = mediumName;
		this.mediumCode = mediumCode;
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
	 * @return the mediumName
	 */
	public String getMediumName() {
		return mediumName;
	}

	/**
	 * @param mediumName the mediumName to set
	 */
	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}

	/**
	 * @return the mediumCode
	 */
	public String getMediumCode() {
		return mediumCode;
	}

	/**
	 * @param mediumCode the mediumCode to set
	 */
	public void setMediumCode(String mediumCode) {
		this.mediumCode = mediumCode;
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
		return "ScanningLocation [id=" + id + ", mediumName=" + mediumName + ", mediumCode=" + mediumCode
				+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", createdAt=" + createdAt + ", createdBy="
				+ createdBy + ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + "]";
	}

	
}
