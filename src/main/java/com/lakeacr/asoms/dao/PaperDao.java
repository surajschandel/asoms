package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Paper;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface PaperDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Paper findById(long id);
	/**
	 * 
	 * @param paper
	 * @return
	 */
	public Paper saveOrUpdate(Paper paper);
	
	/**
	 * @param papers
	 * @return
	 */
	public List<Paper> saveAll(List<Paper> papers);
	
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
	public List<Paper> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
