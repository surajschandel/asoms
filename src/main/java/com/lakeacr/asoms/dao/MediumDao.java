package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Medium;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface MediumDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Medium findById(long id);
	/**
	 * 
	 * @param medium
	 * @return
	 */
	public Medium saveOrUpdate(Medium o);
	
	/**
	 * 
	 * @return
	 */
	public List<Medium> saveAll(List<Medium> o);
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Medium findByLocationCode(String code);

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
	public List<Medium> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
