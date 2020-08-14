package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Subjects;

public interface SubjectsDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Subjects findById(long id);
	/**
	 * 
	 * @param subjects
	 * @return
	 */
	public Subjects saveOrUpdate(Subjects subjects);
	
	/**
	 * 
	 * @return
	 */
	public List<Subjects> saveAll(List<Subjects> subjects);
	/**
	 * 
	 * @param subjectCode
	 * @return
	 */
	public Subjects findBySubjectCode(String subjectCode);

	/**
	 * 
	 * @return
	 */
	public List<Subjects> findAll();

}
