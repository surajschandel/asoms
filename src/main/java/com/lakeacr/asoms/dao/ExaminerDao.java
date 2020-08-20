package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Examiner;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface ExaminerDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Examiner findById(long id);
	/**
	 * 
	 * @param examiner
	 * @return
	 */
	public Examiner saveOrUpdate(Examiner examiner);
	
	/**
	 * @param examiners
	 * @return
	 */
	public List<Examiner> saveAll(List<Examiner> examiners);
	

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
	public List<Examiner> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
