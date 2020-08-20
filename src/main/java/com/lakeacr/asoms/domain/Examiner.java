package com.lakeacr.asoms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Entity
@Table(name = "examiner")
public class Examiner {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "designation")
	private String designation;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "school_name")
	private String schoolName;
	@Column(name = "user_name")
	private String userName;
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

	@ManyToOne
	private HeadExaminer headExaminer;

	@ManyToOne
	private Centers centers;

	@ManyToOne
	private Subjects subjects;

	/**
	 * 
	 */
	public Examiner() {
	}

	/**
	 * @param name
	 * @param designation
	 * @param phoneNo
	 * @param emailId
	 * @param schoolName
	 * @param userName
	 * @param createdAt
	 * @param createdBy
	 * @param isActive
	 * @param isDeleted
	 * @param locations
	 * @param centers
	 */
	public Examiner(String name, String designation, String phoneNo, String emailId, String schoolName, String userName,
			Date createdAt, Long createdBy, boolean isActive, boolean isDeleted, HeadExaminer headExaminer,
			Centers centers, Subjects subjects) {
		super();
		this.name = name;
		this.designation = designation;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.schoolName = schoolName;
		this.userName = userName;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.headExaminer = headExaminer;
		this.centers = centers;
		this.subjects = subjects;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
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
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the headExaminer
	 */
	public HeadExaminer getHeadExaminer() {
		return headExaminer;
	}

	/**
	 * @param headExaminer the headExaminer to set
	 */
	public void setHeadExaminer(HeadExaminer headExaminer) {
		this.headExaminer = headExaminer;
	}

	/**
	 * @return the centers
	 */
	public Centers getCenters() {
		return centers;
	}

	/**
	 * @param centers the centers to set
	 */
	public void setCenters(Centers centers) {
		this.centers = centers;
	}

	/**
	 * @return the subjects
	 */
	public Subjects getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Examiner [id=" + id + ", name=" + name + ", designation=" + designation + ", phoneNo=" + phoneNo
				+ ", emailId=" + emailId + ", schoolName=" + schoolName + ", userName=" + userName + ", updatedAt="
				+ updatedAt + ", updatedBy=" + updatedBy + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", headExaminer=" + headExaminer + ", centers=" + centers + ", subjects=" + subjects
				+ "]";
	}

}
