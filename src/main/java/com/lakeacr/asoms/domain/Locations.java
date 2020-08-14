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
@Table(name = "locations")
public class Locations {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "location_name")
	private String locationName;
	@Column(name = "location_code")
	private String locationCode;
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
	public Locations() {
		super();
	}
	

	/**
	 * @param locationName
	 * @param locationCode
	 * @param createdAt
	 * @param createdBy
	 * @param isActive
	 * @param isDeleted
	 */
	public Locations(String locationName, String locationCode, Date createdAt, Long createdBy, boolean isActive,
			boolean isDeleted) {
		super();
		this.locationName = locationName;
		this.locationCode = locationCode;
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
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
		return "ScanningLocation [id=" + id + ", locationName=" + locationName + ", locationCode=" + locationCode
				+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", createdAt=" + createdAt + ", createdBy="
				+ createdBy + ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + "]";
	}

	
}
