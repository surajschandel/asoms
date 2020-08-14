/**
 * 
 */
package com.lakeacr.asoms.dto;

/**
 * @author SURAJ CHANDEL
 *
 */
public class DashboardCount {

	private int subjects;
	private int locations;
	private int centers;
	private int mediums;
	private int headExaminer;
	private int examiner;
	private int papers;
	/**
	 * @return the subjects
	 */
	public int getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(int subjects) {
		this.subjects = subjects;
	}
	/**
	 * @return the locations
	 */
	public int getLocations() {
		return locations;
	}
	/**
	 * @param locations the locations to set
	 */
	public void setLocations(int locations) {
		this.locations = locations;
	}
	/**
	 * @return the centers
	 */
	public int getCenters() {
		return centers;
	}
	/**
	 * @param centers the centers to set
	 */
	public void setCenters(int centers) {
		this.centers = centers;
	}
	/**
	 * @return the mediums
	 */
	public int getMediums() {
		return mediums;
	}
	/**
	 * @param mediums the mediums to set
	 */
	public void setMediums(int mediums) {
		this.mediums = mediums;
	}
	/**
	 * @return the headExaminer
	 */
	public int getHeadExaminer() {
		return headExaminer;
	}
	/**
	 * @param headExaminer the headExaminer to set
	 */
	public void setHeadExaminer(int headExaminer) {
		this.headExaminer = headExaminer;
	}
	/**
	 * @return the examiner
	 */
	public int getExaminer() {
		return examiner;
	}
	/**
	 * @param examiner the examiner to set
	 */
	public void setExaminer(int examiner) {
		this.examiner = examiner;
	}
	/**
	 * @return the papers
	 */
	public int getPapers() {
		return papers;
	}
	/**
	 * @param papers the papers to set
	 */
	public void setPapers(int papers) {
		this.papers = papers;
	}
	@Override
	public String toString() {
		return "DashboardCount [subjects=" + subjects + ", locations=" + locations + ", centers=" + centers
				+ ", mediums=" + mediums + ", headExaminer=" + headExaminer + ", examiner=" + examiner + ", papers="
				+ papers + "]";
	}
	
	
}
