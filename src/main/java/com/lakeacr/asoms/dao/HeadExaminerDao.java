package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.HeadExaminer;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface HeadExaminerDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public HeadExaminer findById(long id);
	/**
	 * 
	 * @param examiner
	 * @return
	 */
	public HeadExaminer saveOrUpdate(HeadExaminer examiner);
	
	/**
	 * @param examiners
	 * @return
	 */
	public List<HeadExaminer> saveAll(List<HeadExaminer> examiners);
	

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public void deleteById(long id);
	/**
	 * 
	 * @return
	 */
	public List<HeadExaminer> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
