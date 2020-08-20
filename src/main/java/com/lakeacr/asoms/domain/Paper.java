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
@Table(name = "paper")
public class Paper {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String paperCode;
	private String regionCode;
	private String mainAnsScriptPage;
	private String supplAnsScriptPage;
	private String modelQuestionPaper;
	private String modelAnswer;
	private double totalMarks;
	private double optionalQuestionMarks;
	private double passingMarks;
	private String markingScheme;
	private Date updatedAt;
	private Long updatedBy;
	private Date createdAt;
	private Long createdBy;
	private Date deletedAt;
	private Long deletedBy;
	private boolean isActive;
	private boolean isDeleted;

	@ManyToOne
	private Subjects subjects;
	@ManyToOne
	private Medium medium;

	/**
	 * 
	 */
	public Paper() {
		super();
	}

	/**
	 * @param name
	 * @param paperCode
	 * @param regionCode
	 * @param mainAnsScriptPage
	 * @param supplAnsScriptPage
	 * @param modelQuestionPaper
	 * @param modelAnswer
	 * @param totalMarks
	 * @param optionalQuestionMarks
	 * @param passingMarks
	 * @param markingScheme
	 * @param createdAt
	 * @param createdBy
	 * @param isActive
	 * @param isDeleted
	 * @param subjects
	 * @param medium
	 */
	public Paper(String name, String paperCode, String regionCode, String mainAnsScriptPage, String supplAnsScriptPage,
			String modelQuestionPaper, String modelAnswer, double totalMarks, double optionalQuestionMarks,
			double passingMarks, String markingScheme, Date createdAt, Long createdBy, boolean isActive,
			boolean isDeleted, Subjects subjects, Medium medium) {
		super();
		this.name = name;
		this.paperCode = paperCode;
		this.regionCode = regionCode;
		this.mainAnsScriptPage = mainAnsScriptPage;
		this.supplAnsScriptPage = supplAnsScriptPage;
		this.modelQuestionPaper = modelQuestionPaper;
		this.modelAnswer = modelAnswer;
		this.totalMarks = totalMarks;
		this.optionalQuestionMarks = optionalQuestionMarks;
		this.passingMarks = passingMarks;
		this.markingScheme = markingScheme;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.subjects = subjects;
		this.medium = medium;
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
	 * @return the paperCode
	 */
	public String getPaperCode() {
		return paperCode;
	}

	/**
	 * @param paperCode the paperCode to set
	 */
	public void setPaperCode(String paperCode) {
		this.paperCode = paperCode;
	}

	/**
	 * @return the regionCode
	 */
	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * @param regionCode the regionCode to set
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	/**
	 * @return the mainAnsScriptPage
	 */
	public String getMainAnsScriptPage() {
		return mainAnsScriptPage;
	}

	/**
	 * @param mainAnsScriptPage the mainAnsScriptPage to set
	 */
	public void setMainAnsScriptPage(String mainAnsScriptPage) {
		this.mainAnsScriptPage = mainAnsScriptPage;
	}

	/**
	 * @return the supplAnsScriptPage
	 */
	public String getSupplAnsScriptPage() {
		return supplAnsScriptPage;
	}

	/**
	 * @param supplAnsScriptPage the supplAnsScriptPage to set
	 */
	public void setSupplAnsScriptPage(String supplAnsScriptPage) {
		this.supplAnsScriptPage = supplAnsScriptPage;
	}

	/**
	 * @return the modelQuestionPaper
	 */
	public String getModelQuestionPaper() {
		return modelQuestionPaper;
	}

	/**
	 * @param modelQuestionPaper the modelQuestionPaper to set
	 */
	public void setModelQuestionPaper(String modelQuestionPaper) {
		this.modelQuestionPaper = modelQuestionPaper;
	}

	/**
	 * @return the modelAnswer
	 */
	public String getModelAnswer() {
		return modelAnswer;
	}

	/**
	 * @param modelAnswer the modelAnswer to set
	 */
	public void setModelAnswer(String modelAnswer) {
		this.modelAnswer = modelAnswer;
	}

	/**
	 * @return the totalMarks
	 */
	public double getTotalMarks() {
		return totalMarks;
	}

	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	/**
	 * @return the optionalQuestionMarks
	 */
	public double getOptionalQuestionMarks() {
		return optionalQuestionMarks;
	}

	/**
	 * @param optionalQuestionMarks the optionalQuestionMarks to set
	 */
	public void setOptionalQuestionMarks(double optionalQuestionMarks) {
		this.optionalQuestionMarks = optionalQuestionMarks;
	}

	/**
	 * @return the passingMarks
	 */
	public double getPassingMarks() {
		return passingMarks;
	}

	/**
	 * @param passingMarks the passingMarks to set
	 */
	public void setPassingMarks(double passingMarks) {
		this.passingMarks = passingMarks;
	}

	/**
	 * @return the markingScheme
	 */
	public String getMarkingScheme() {
		return markingScheme;
	}

	/**
	 * @param markingScheme the markingScheme to set
	 */
	public void setMarkingScheme(String markingScheme) {
		this.markingScheme = markingScheme;
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

	/**
	 * @return the medium
	 */
	public Medium getMedium() {
		return medium;
	}

	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", name=" + name + ", paperCode=" + paperCode + ", regionCode=" + regionCode
				+ ", mainAnsScriptPage=" + mainAnsScriptPage + ", supplAnsScriptPage=" + supplAnsScriptPage
				+ ", modelQuestionPaper=" + modelQuestionPaper + ", modelAnswer=" + modelAnswer + ", totalMarks="
				+ totalMarks + ", optionalQuestionMarks=" + optionalQuestionMarks + ", passingMarks=" + passingMarks
				+ ", markingScheme=" + markingScheme + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", deletedAt=" + deletedAt + ", deletedBy="
				+ deletedBy + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", subjects=" + subjects
				+ ", medium=" + medium + "]";
	}

}
